package com.DaoClasses;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;













//import org.springframework.stereotype.Service;
import com.EncryptionDecryption.*;
import com.EntityClasses.*;
import com.HibernateUtil.HibernateUtil;
import com.ModelClasses.*;
import com.client_mail.ApplicationConfig;
//import com.ServiceClasses.usersService;
//import com.client_mail.ApplicationConfig;
//import com.client_mail.MailService;
import com.client_mail.MailService;




@Repository
public class userDaoImpl implements usersDao{
	
	Encryption encrypt= new Encryption();
	Decryption decrypt= new Decryption();
	
	
	
	//===================For SS========================================  
    
	public String Key(int mount){
		 SecureRandom random = new SecureRandom();
		    String key;
		  
		    key=  new BigInteger(mount*5, random).toString(32);
		   
		return key;
	}
	
    
    
  //=================================================================    

	
	
	
	public User_Info findByUserName(String username) {
    	Transaction trns1 = null; 
        Session session = HibernateUtil.getSessionFactory().openSession();
        //System.out.println("String type user: "+username.split("--")[1]);
        String Username[] = username.split("--");
        
		List<User_Info> users = new ArrayList<User_Info>();
		
		try {
            trns1 = session.beginTransaction();
            users = session.createQuery("from User_Info where email=?").setParameter(0, Username[0]).list();
            
           
            if (users.size() > 0) {
            	for( UserRole us: users.get(0).getUserRole()){
            		System.out.println(us.getRole());
            	}
            	System.out.println(Username.length);
            	if(Username.length>1){
            		
            		users.get(0).setType("google");
            	}
    			return users.get(0);
    		} else {
    			return null;
    		}
        } catch (RuntimeException e) {
        	e.printStackTrace();
        	
        }finally{
		    session.flush();
        	session.close();
        }
		return null;
	}
	
	public boolean createUser(UserModel user,String type) {
    	Transaction trns1 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
            trns1 = session.beginTransaction();
            User_Info user_info = new User_Info();
            Encryption encode = new Encryption();
            String hashedPassword = encode.PasswordEncode(user.getPassword());
            UserRole user_role = new UserRole();
            user_info.setBatch_id(0);
            user_info.setEmail(user.getEmail());
            user_info.setName(user.getName());
            user_info.setUsername(user.getUsername());
            user_info.setPhone_number(user.getPhone());
            if(type.equals("google")){
            	user_info.setGooglePassword(hashedPassword);
            	System.out.println("google");

            }
            else {
            	System.out.println("system");
            	user_info.setPassword(hashedPassword);
            	user_info.setGender(user.getGender());
            	
            }
            
            user_info.setEnabled(true);
            if(user.getEmail().contains("@kit.edu.kh")){
            	
            	user_role.setRole("ROLE_STUDENT");
            	user_info.setNumber_ticket(36);
            	
            }else{
            	
            	user_role.setRole("ROLE_CUSTOMER");
     	
            }
            user_role.setUser_info(user_info);
            session.save(user_info);
            session.save(user_role);
          trns1.commit();
          return true;
        } catch (RuntimeException e) {
        	
        }
        finally {
		    session.flush();
		    session.close();
        }
		return false;
	}
	public boolean updateUser(User_Info user,UserModel user_model,String type){
    	Transaction trns1 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
            trns1 = session.beginTransaction();
            Encryption encode = new Encryption();
            String hashedPassword = encode.PasswordEncode(user_model.getPassword());
            System.out.println(user_model.getPassword());
            if(type.equals("google")){
            	user.setGooglePassword(hashedPassword);
            }
            else {
            	System.out.println(type);
            	System.out.println(user.getEmail());
            	user.setPassword(hashedPassword);
            }
            
          session.update(user);
          trns1.commit();
          return true;
        } catch (RuntimeException e) {
        	e.printStackTrace();
        }
        finally {
		    session.flush();
		    session.close();
        }
		return false;
	}
	public int saveBus(Bus_Master bus) {
		List <Bus_Master> buses  = new ArrayList<Bus_Master>();
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Bus_Master where plate_number=:number and enabled=:status";
            Query query = session.createQuery(queryString);
            query.setString("number",bus.getPlate_number());
            query.setBoolean("status", true);
            buses=(List<Bus_Master>)query.list();
         
    			if(buses.size()>0)
    				return 0;
    		Timestamp created_at = new Timestamp(System.currentTimeMillis());
        	bus.setCreated_at(created_at);
        	bus.setEnabled(true);
        	bus.setAvailability(true);
            session.save(bus);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
	}



    public int createUserr(User_Info user) {
        List <User_Info> users  = new ArrayList<User_Info>();
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String queryString = "FROM User_Info where email=:email";
            Query query = session.createQuery(queryString);
            query.setString("email",user.getEmail());
            users=(List<User_Info>)query.list();
         
                if(users.size()>0)
                    return 0;
                Timestamp created_at = new Timestamp(System.currentTimeMillis());
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(hashedPassword);
                user.setEnabled(true); 
                user.setCreated_at(created_at);
                user.setBatch_id(0);
                UserRole user_role= new UserRole();
                user_role.setRole(user.getProfile());
                user_role.setCreated_at(created_at);
                user_role.setUser_info(user);
                Set<UserRole> userrole= new HashSet<UserRole>();
                userrole.add(user_role);
                user.setUserRole(userrole);
                user.setProfile("");
                session.save(user);
                transaction.commit();
                transaction = session.beginTransaction();
                session.save(user_role);  
                session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }
	

    
     public int changePass(User_Info user) {
        List <User_Info> users  = new ArrayList<User_Info>();
        Transaction transaction = null;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String queryString = "FROM User_Info where email=:email";
            Query query = session.createQuery(queryString);
            query.setString("email",user.getEmail());
            users=(List<User_Info>)query.list();
            User_Info u = users.get(0);
         
                if(passwordEncoder.matches(user.getPassword(), u.getPassword()))
                {
                    Timestamp updated_at = new Timestamp(System.currentTimeMillis());
                    String encryptedPassword = passwordEncoder.encode(user.getProfile());
                    u.setPassword(encryptedPassword);
                    u.setUpdated_at(updated_at);
                    u.setProfile("");
                    session.update(u);
                    session.getTransaction().commit();
                }
                else
                    return 0;
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }



	
	public List<User_Info> getAllUsers() {
      	List<User_Info> users= new ArrayList<User_Info>();
   		Transaction trns25 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
			trns25  = session.beginTransaction();
			String queryString  = "from UserRole where role=:role";
 		 	Query query = session.createQuery(queryString);
 		 	query.setString("role", "ROLE_ADMIN");
 		 	List<UserRole> roles = query.list();
 		 	for(int i=0;i<roles.size();i++)
 		 	{
 		 		User_Info user1 = new User_Info();
 		 		User_Info user = roles.get(i).getUser_info();
 		 		user1.setId(user.getId());
 		 		user1.setName(user.getName());
 		 		users.add(user1);
 		 	}
 		 	
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();			
		}
		finally{
			session.flush();
			session.close();
		}
        return users;
    } 

    public List<User_Info> getAllStudents() {
        List<User_Info> users= new ArrayList<User_Info>();
        Transaction trns25 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
            trns25  = session.beginTransaction();
            String queryString  = "from UserRole where role=:role";
            Query query = session.createQuery(queryString);
            query.setString("role", "ROLE_STUDENT");
            List<UserRole> roles = query.list();
            for(int i=0;i<roles.size();i++)
            {
                User_Info user1 = new User_Info();
                User_Info user = roles.get(i).getUser_info();
                user1.setId(user.getId());
                user1.setUsername(user.getUsername());
                users.add(user1);
            }
            
        }
        catch(RuntimeException e)
        {
            e.printStackTrace();            
        }
        finally{
            session.flush();
            session.close();
        }
        return users;
    } 
	
	
	public List<User_Info> getAlDrivers() {
      	List<User_Info> users= new ArrayList<User_Info>();
   		Transaction trns25 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
			trns25  = session.beginTransaction();
			String queryString  = "from UserRole where role=:role";
 		 	Query query = session.createQuery(queryString);
 		 	query.setString("role", "ROLE_DRIVER");
 		 	List<UserRole> roles = query.list();
 		 	for(int i=0;i<roles.size();i++)
 		 	{
 		 		User_Info user1 = new User_Info();
 		 		User_Info user = roles.get(i).getUser_info();
 		 		user1.setId(user.getId());
 		 		user1.setName(user.getUsername());
 		 		user1.setPhone_number(user.getPhone_number());
 		 		user1.setEmail(user.getEmail());
 		 		users.add(user1);
 		 	}
 		 	
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();			
		}
		finally{
			session.flush();
			session.close();
		}
        return users;
    } 
	
	
	
	
	
	
	public User_Info getCustomerById(int id) {
		User_Info customer = new User_Info();
   		Transaction trns25 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
			trns25  = session.beginTransaction();
			String queryString  = "from User_Info where id=:id";
 		 	Query query = session.createQuery(queryString);
 		 	query.setInteger("id", id);
 		 	customer = (User_Info) query.uniqueResult();
 		 	
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();			
		}
		finally{
			session.flush();
			session.close();
		}
        return customer;
    } 



    public User_Info getCustomerByEmail(String email) {
        User_Info customer = new User_Info();
        Transaction trns25 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
            trns25  = session.beginTransaction();
            String queryString  = "from User_Info where email=:email";
            Query query = session.createQuery(queryString);
            query.setString("email", email);
            customer = (User_Info) query.uniqueResult();
            
        }
        catch(RuntimeException e)
        {
            e.printStackTrace();            
        }
        finally{
            session.flush();
            session.close();
        }
        return customer;
    } 
	
	
	
	
	
	
	
	
	public List<User_Info> getAlCustomers() {
      	List<User_Info> users= new ArrayList<User_Info>();
   		Transaction trns25 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
			trns25  = session.beginTransaction();
			String queryString  = "from UserRole where role=:role or role =:role1";
 		 	Query query = session.createQuery(queryString);
 		 	query.setString("role", "ROLE_CUSTOMER");
 		 	query.setString("role1", "ROLE_STUDENT");
 		 	List<UserRole> roles = query.list();
 		 	for(int i=0;i<roles.size();i++)
 		 	{
 		 		User_Info user1 = new User_Info();
 		 		User_Info user = roles.get(i).getUser_info();
 		 		user1.setId(user.getId());
 		 		user1.setName(user.getUsername());
 		 		user1.setPhone_number(user.getPhone_number());
 		 		user1.setEmail(user.getEmail());
 		 		users.add(user1);
 		 	}
 		 	
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();			
		}
		finally{
			session.flush();
			session.close();
		}
        return users;
    } 
	
	
	
	
	public int updateBus(Bus_Master bus) {
		int count = 0;
		List <Bus_Master> buses  = new ArrayList<Bus_Master>();
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            buses = getAllBuses();
            for(Bus_Master b:buses)
            {
            	if(bus.getId()!=b.getId())
            			{
            				if (b.getPlate_number().equals(bus.getPlate_number()))
            					count++;
            			}
            }
            if(count>=1)
            	return 0;
            String queryString = "FROM Bus_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",bus.getId());
            Bus_Master updatedBus  = (Bus_Master) query.uniqueResult();
            Timestamp updated_at = new Timestamp(System.currentTimeMillis());
            updatedBus.setDescription(bus.getDescription());
            updatedBus.setModel(bus.getModel());
            updatedBus.setPlate_number(bus.getPlate_number());
        	updatedBus.setUpdated_at(updated_at);
        	updatedBus.setNumber_of_seat(bus.getNumber_of_seat());
            session.update(updatedBus);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
		}


        public int updateDate(Batch_Master batch) {
        int count = 0;
        List <Batch_Master> batches  = new ArrayList<Batch_Master>();
        Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            batches = getAllDates();
            for(Batch_Master b:batches)
            {
                if(batch.getId()!=b.getId())
                        {
                            if (b.getName().equals(batch.getName()))
                                count++;
                        }
            }
            if(count>=1)
                return 0;
            String queryString = "FROM Batch_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",batch.getId());
            Batch_Master updatedBatch  = (Batch_Master) query.uniqueResult();
            Timestamp updated_at = new Timestamp(System.currentTimeMillis());
            updatedBatch.setName(batch.getName());
            updatedBatch.setUpdated_at(updated_at);
            updatedBatch.setDate_of_leaving(batch.getDate_of_leaving());
            session.update(updatedBatch);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
        }


	
	public List <Pickup_Location_Master> getPickUpLocationByName (String name){
		List <Pickup_Location_Master> p_locations  = new ArrayList<Pickup_Location_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Pickup_Location_Master where name=:name";
            Query query = session.createQuery(queryString);
            query.setString("name",name);
            p_locations=(List<Pickup_Location_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return p_locations;
        } finally {
            session.flush();
            session.close();
        }
        return p_locations;
		
	}
	
	
	public List <Location_Master> getLocationByName (String name){
		List <Location_Master> locations  = new ArrayList<Location_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Location_Master where name=:name";
            Query query = session.createQuery(queryString);
            query.setString("name",name);
            locations=(List<Location_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return locations;
        } finally {
            session.flush();
            session.close();
        }
        return locations;
		
	}
	
	
	
	
	
	public int updateLocation(Location_Master location) {
		int count = 0;
		List <Location_Master> locations  = new ArrayList<Location_Master>();
		List <Pickup_Location_Master> p_locations  = new ArrayList<Pickup_Location_Master>();
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            locations = getAllLocations();
            p_locations = getAllPickUpLocations();
            for(Location_Master l:locations)
            {
            	if(location.getId()!=l.getId())
            			{
            				if (l.getName().equals(location.getName()))
            					count++;
            			}
            }
            p_locations = getPickUpLocationByName(location.getName());
            if(count>=1||p_locations.size()>0)
            	return 0;
            String queryString = "FROM Location_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",location.getId());
            Location_Master updatedLocation  = (Location_Master) query.uniqueResult();
            Timestamp updated_at = new Timestamp(System.currentTimeMillis());
            updatedLocation.setName(location.getName());
            updatedLocation.setUpdated_at(updated_at);
            session.update(updatedLocation);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
		}
	
	
	
	public int updatePickUpLocation(Pickup_Location_Master p_location){
		int count = 0;
		List <Location_Master> locations  = new ArrayList<Location_Master>();
		List <Pickup_Location_Master> p_locations  = new ArrayList<Pickup_Location_Master>();
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            locations = getAllLocations();
            p_locations = getAllPickUpLocations();
            for(Pickup_Location_Master pl:p_locations)
            {
            	if(p_location.getId()!=pl.getId())
            			{
            				if (pl.getName().equals(p_location.getName()))
            					count++;
            			}
            }
            locations = getLocationByName(p_location.getName());
            if(count>=1||locations.size()>0)
            	return 0;
            String queryString = "FROM Pickup_Location_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",p_location.getId());
            Pickup_Location_Master updatedPLocation  = (Pickup_Location_Master) query.uniqueResult();
            Timestamp updated_at = new Timestamp(System.currentTimeMillis());
            updatedPLocation.setName(p_location.getName());
            updatedPLocation.setUpdated_at(updated_at);
            session.update(updatedPLocation);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
		
	}
	
	
	


	public List<Bus_Master> getAllBuses(){
		List<Bus_Master> p= new ArrayList<Bus_Master>();
        Transaction trns16 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns16 = session.beginTransaction();
            Query query = session.createQuery("from Bus_Master where enabled =:status and availability=:availability");
            query.setBoolean("status", true);
            query.setBoolean("availability", true);
            p = query.list();
            } catch (RuntimeException e) {
            e.printStackTrace();
            return p;
        } finally {
            session.flush();
            session.close();
        }
        return p;
		
	}



    public List<Bus_Master> getAllBuses2(){
        List<Bus_Master> p= new ArrayList<Bus_Master>();
        Transaction trns16 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns16 = session.beginTransaction();
            Query query = session.createQuery("from Bus_Master where enabled =:status");
            query.setBoolean("status", true);
            p = query.list();
            } catch (RuntimeException e) {
            e.printStackTrace();
            return p;
        } finally {
            session.flush();
            session.close();
        }
        return p;
        
    }



    public List<Dept_Time_Master> getAllTimes(){
        List<Dept_Time_Master> p= new ArrayList<Dept_Time_Master>();
        Transaction trns16 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns16 = session.beginTransaction();
            Query query = session.createQuery("from Dept_Time_Master where enabled =:status");
            query.setBoolean("status", true);
            p = query.list();
            } catch (RuntimeException e) {
            e.printStackTrace();
            return p;
        } finally {
            session.flush();
            session.close();
        }
        return p;
        
    }
    public List<Batch_Master> getAllDates(){
        List<Batch_Master> p= new ArrayList<Batch_Master>();
        Transaction trns16 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns16 = session.beginTransaction();
            Query query = session.createQuery("from Batch_Master where enabled =:status");
            query.setBoolean("status", true);
            p = query.list();
            } catch (RuntimeException e) {
            e.printStackTrace();
            return p;
        } finally {
            session.flush();
            session.close();
        }
        return p;
        
    }
    public Cost getAllPrices(){
        Cost cost = new Cost();
        Transaction trns16 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns16 = session.beginTransaction();
            Query query = session.createQuery("from Cost");
            cost = (Cost)query.uniqueResult();
            System.out.println("Costttttt "+cost);
            } catch (RuntimeException e) {
            e.printStackTrace();
            return cost;
        } finally {
            session.flush();
            session.close();
        }
        return cost;
        
    }
	public List<Location_Master> getAllLocations(){
		List<Location_Master> p= new ArrayList<Location_Master>();
        Transaction trns16 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns16 = session.beginTransaction();
            Query query = session.createQuery("from Location_Master where enabled =:status");
            query.setBoolean("status", true);
            p = query.list();
            } catch (RuntimeException e) {
            e.printStackTrace();
            return p;
        } finally {
            session.flush();
            session.close();
        }
        return p;
		
	}
	public List<Pickup_Location_Master> getAllPickUpLocations(){
		List<Pickup_Location_Master> p= new ArrayList<Pickup_Location_Master>();
        Transaction trns16 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns16 = session.beginTransaction();
            Query query = session.createQuery("from Pickup_Location_Master where enabled =:status");
            query.setBoolean("status", true);
            p = query.list();
            } catch (RuntimeException e) {
            e.printStackTrace();
            return p;
        } finally {
            session.flush();
            session.close();
        }
        return p;
		
	}
	public Bus_Master getBusById (int id){
		Bus_Master bus= new Bus_Master();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Bus_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            bus=(Bus_Master)query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return bus;
        } finally {
            session.flush();
            session.close();
        }
        return bus;
		
	}
	
	
	public Booking_Master getBookingById (int id){
		Booking_Master booking= new Booking_Master();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Booking_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            booking=(Booking_Master)query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return booking;
        } finally {
            session.flush();
            session.close();
        }
        return booking;
		
	}
	
	
	
	
	public Booking_Request_Master getBookingRequestById (int id){
		Booking_Request_Master request= new Booking_Request_Master();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Booking_Request_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            request=(Booking_Request_Master)query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return request;
        } finally {
            session.flush();
            session.close();
        }
        return request;
		
	}
	
	
	public List<Booking_Master> getBookingByScheduleId (int id){
		List<Booking_Master> booking= new ArrayList<Booking_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Booking_Master b where schedule_id=:id order by b.description";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            booking=(List<Booking_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return booking;
        } finally {
            session.flush();
            session.close();
        }
        return booking;
		
	}
	
	
	public Schedule_Master getScheduleById (int id){
		Schedule_Master schedule= new Schedule_Master();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Schedule_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            schedule=(Schedule_Master)query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return schedule;
        } finally {
            session.flush();
            session.close();
        }
        return schedule;
		
	}
	
	
	public Location_Master getLocationById (int id){
		Location_Master location= new Location_Master();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Location_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            location=(Location_Master)query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return location;
        } finally {
            session.flush();
            session.close();
        }
        return location;
		
	}
	
	
	
	
	public Pickup_Location_Master getPickUpLocationById (int id){
		Pickup_Location_Master p_location= new Pickup_Location_Master();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Pickup_Location_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            p_location=(Pickup_Location_Master)query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return p_location;
        } finally {
            session.flush();
            session.close();
        }
        return p_location;
		
	}
	
	
	
	public int deleteBus(int id){
		Transaction trns21 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Bus_Master bus = new Bus_Master();
        List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
        try {
            trns21 = session.beginTransaction();
            schedules =  new userDaoImpl().busBeforeDelete(id);
            if (schedules.size()>0)
                return 5;
            String queryString = "from Bus_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id); 
            bus=(Bus_Master)query.uniqueResult();
            bus.setEnabled(false);
            session.update(bus);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
	}
	public int deleteLocation(int id){
		Transaction trns21 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Location_Master location = new Location_Master();
        try {
            trns21 = session.beginTransaction();
            String queryString = "from Location_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            location=(Location_Master)query.uniqueResult();
            location.setEnabled(false);
            session.update(location);
            deletePickUpLocationByLocatinId(id);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
	}
	
	public int deleteSchedule(int id){
		Transaction trns21 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Schedule_Master schedule = new Schedule_Master();
        try {
            trns21 = session.beginTransaction();
            String queryString = "from Schedule_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            schedule=(Schedule_Master)query.uniqueResult();
            session.delete(schedule);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
	}


    public int deleteTime(int id){
        Transaction trns21 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Dept_Time_Master time = new Dept_Time_Master();
        try {
            trns21 = session.beginTransaction();
            String queryString = "from Dept_Time_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            time=(Dept_Time_Master)query.uniqueResult();
            session.delete(time);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }


    public int deleteDate(int id){
        Transaction trns21 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Batch_Master date = new Batch_Master();
        try {
            trns21 = session.beginTransaction();
            String queryString = "from Batch_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            date=(Batch_Master)query.uniqueResult();
            session.delete(date);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }


	
	public void deletePickUpLocationByLocatinId(int id){
		Transaction trns24 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           	trns24 = session.beginTransaction();
            String queryString = "update Pickup_Location_Master p set p.enabled=:status where p.location_id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            query.setBoolean("status", false);
            query.executeUpdate();
            session.getTransaction().commit();
         
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
		
	}
	
	
	
	public int deletePickUpLocation(int id){
		Transaction trns21 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pickup_Location_Master p_location = new Pickup_Location_Master();
        try {
            trns21 = session.beginTransaction();
            String queryString = "from Pickup_Location_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",id);
            p_location=(Pickup_Location_Master)query.uniqueResult();
            p_location.setEnabled(false);
            session.update(p_location);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
		
	}
	
	
	public int saveLocation(Location_Master location){
		System.out.println("LOCATIONNNNNN "+location.getDept_time2());
		List <Location_Master> locations  = new ArrayList<Location_Master>();
		List <Pickup_Location_Master> p_locations  = new ArrayList<Pickup_Location_Master>();
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Location_Master where name=:name and enabled=:status";
            String queryString2 = "FROM Pickup_Location_Master where name=:name and enabled=:status";
            Query query = session.createQuery(queryString);
            query.setString("name",location.getName());
            query.setBoolean("status",true);
            Query query2 = session.createQuery(queryString2);
            query2.setString("name",location.getName());
            query2.setBoolean("status",true);
            locations=(List<Location_Master>)query.list();
            p_locations=(List<Pickup_Location_Master>)query2.list();
            
    			if(locations.size()>0 || p_locations.size()>0)
    				return 0;
    		Timestamp created_at = new Timestamp(System.currentTimeMillis());
        	location.setCreated_at(created_at);
        	location.setEnabled(true);
        	if(!location.getDept_time2().equals("nth"))
        	location.setDept_time(java.sql.Time.valueOf(location.getDept_time2()));
            session.save(location);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
	}
	public Map<String, Object> saveSchedule(Schedule_Model schedule) throws ParseException{
		List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
		Schedule_Master s = new Schedule_Master();
		Map<String, Object> map = new HashMap <String, Object>();
		Date dept_date = null;
		Time dept_time = null;
    	Transaction trns7 = null;
        int iid;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            Customer_Booking booking = new Customer_Booking();
            List<Integer> ints1 = new ArrayList<Integer>();
            List<Integer> ints2 = new ArrayList<Integer>();
    		int from = new userDaoImpl().getPickUpLocationById(schedule.getSource_id()).getLocation_id();
    		int to = new userDaoImpl().getPickUpLocationById(schedule.getDestination_id()).getLocation_id();
    		booking.setAdult(0);
    		booking.setChild(0);
    		booking.setDate(schedule.getDept_date());
    		booking.setDestination(schedule.getDestination_id());
    		booking.setNumber_of_seat(0);
    		booking.setSource(schedule.getSource_id());
    		booking.setStatus("Booked");
    		booking.setTime(schedule.getDept_time());
            
    		List<User_Info> drivers =  get_all_available_drivers(session,booking,from,to);
    		List<Bus_Master> buses =  get_all_bus2(session,booking,from,to);
    		boolean condition1 = false;
    		boolean condition2 = false;
    		String status1 = new String ();
    		String status2 = new String ();
    		
    		
    		for(int i=0;i<drivers.size();i++){
    			String q = " and dept_date=:date and dept_time=:time and driver_id=:id";
    			String qString = "from Schedule_Master where id>0"+q;
                Query quer = session.createQuery(qString);
                quer.setInteger("id",drivers.get(i).getId());
                quer.setDate("date",java.sql.Date.valueOf(booking.getDate()));
                quer.setTime("time",java.sql.Time.valueOf(booking.getTime()));
    			if(getDriverNBusByExcep(quer).size()>0)
    				drivers.remove(i);
    		}
    		
    		for(int i=0;i<buses.size();i++){
    			String qq = " and dept_date=:date and dept_time=:time and bus_id=:id";
    			String qs = "from Schedule_Master where id>0"+qq;
                Query qsq = session.createQuery(qs);
                qsq.setInteger("id",buses.get(i).getId());
                qsq.setDate("date",java.sql.Date.valueOf(booking.getDate()));
                qsq.setTime("time",java.sql.Time.valueOf(booking.getTime()));
    			if(getDriverNBusByExcep(qsq).size()>0)
    				buses.remove(i);
    		}
    		
    		
    		if(drivers.size()>0)
    		{
    			for(User_Info d:drivers)
    			{
    				if (d.getId()==schedule.getDriver_id())
    				{
    					condition1 = true;
    				}
    				ints1.add(d.getId());
    			}
    			if(condition1){
    				status1 =  "driver fine";
    			}
    			else{
    				status1 =  "driver not fine";
    			}
    			
    		}
    		else{
    			status1 =  "no driver available";
    		}
    		
    		
    		
    		
    		if(buses.size()>0)
    		{
    			for(Bus_Master b:buses)
    			{
    				if (b.getId()==schedule.getBus_id())
    				{
    					condition2 = true;
    				}
    				ints2.add(b.getId());
    			}
    			if(condition2){
    				status2 =  "bus fine";
    			}
    			else{
    				status2 =  "bus not fine";
    			}
    			
    		}
    		else{
    			status2 =  "no bus available";
    		}
    		
    		System.out.println("+++++++++++++++++++ "+status1);
    		System.out.println("+++++++++++++++++++ "+status2);
    		if(status1.equals("driver fine")&&status2.equals("bus fine"))
	    		{
    				Timestamp created_at = new Timestamp(System.currentTimeMillis());
		    		int remaining =  new userDaoImpl().getBusById(schedule.getBus_id()).getNumber_of_seat()-schedule.getNumber_booking();
		    		s.setBus_id(schedule.getBus_id());
		    		s.setCreated_at(created_at);
		    		s.setDept_date(java.sql.Date.valueOf(schedule.getDept_date()));
		    		s.setDept_time(java.sql.Time.valueOf(schedule.getDept_time()));
		    		s.setDestination_id(schedule.getDestination_id());
		    		s.setDriver_id(schedule.getDriver_id());
		    		s.setNumber_booking(schedule.getNumber_booking());
		    		s.setNumber_customer(schedule.getNumber_customer());
		    		s.setNumber_staff(schedule.getNumber_staff());
		    		s.setNumber_student(schedule.getNumber_student());
		    		s.setRemaining_seat(remaining);
		    		s.setSource_id(schedule.getSource_id());
		    		s.setFrom_id(new userDaoImpl().getPickUpLocationById(schedule.getSource_id()).getLocation_id());
		    		s.setTo_id(new userDaoImpl().getPickUpLocationById(schedule.getDestination_id()).getLocation_id());
		            session.save(s);
                    iid = s.getId();
                    s.setCode(getScheduleSequence(iid));
                    session.update(s);
		            session.getTransaction().commit();
    				map.put("status", "all fine");
	    			map.put("message", "Schedule "+getScheduleSequence(iid)+" has just been created successfully");
	    		}
    		else if(status1.equals("driver not fine")&&status2.equals("bus not fine"))
    		{
    			map.put("status", "d nfine b nfine");
    			map.put("message", "Neither the driver nor the bus you have selected will be available for this departure time, but you can choose ohers");
    			map.put("driver_data", ints1.toString());
    			map.put("bus_data", ints2.toString());
    		}
    		else if(status2.equals("bus not fine"))
    		{
    			map.put("status", "b nfine");
    			map.put("message", "The bus you have selected will not be available for this departure time, but you can choose ohers");
    			map.put("bus_data", ints2.toString());
    		}
    		else if(status1.equals("driver not fine"))
    		{
    			map.put("status", "d nfine");
    			map.put("message", "The driver you have selected will not be available for this departure time, but you can choose ohers");
    			map.put("driver_data", ints1.toString());
    		}
    		else if(status1.equals("no driver available")&&status2.equals("no bus available"))
    		{
    			map.put("status", "driver n bus not available");
    			map.put("message", "Neither driver nor bus will be available for this departure time");
    		}
    		else if(status1.equals("no driver available"))
    		{
    			map.put("status", "driver not available");
    			map.put("message", "No driver will not be available for this departure time");
    		}
    		else if(status2.equals("no bus available"))
    		{
    			map.put("status", "bus not available");
    			map.put("message", "No bus will not be available for this departure time");
    		}
    		
    		
    		
    		
    		
            
    		
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            map.put("status", "error");
			map.put("message", "Technical problem occurs");
			return map;
        } finally {
            session.flush();
            session.close();
        }
        return map;
		
	}

    public String getScheduleSequence(int id){ 
           int code;
           String scode = new String();
           code = 10000000+id; 
           scode = Integer.toString(code); 
           scode = scode.substring(1); 
           return "S"+scode; 
          
    }
	
	
	
	
	public List<Bus_Master> get_all_bus2(Session session,Customer_Booking cb,int from, int to) throws ParseException{
		System.out.println("get_all_bus");
		List<Bus_Master> query_all_bus=new ArrayList<Bus_Master>();
		List<Bus_Master> buses=new ArrayList<Bus_Master>();
		List<Map<String,Object>> same_date_route =new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> same_date_diff_route =new ArrayList<Map<String,Object>>();
		Custom_Dao custom_imp=new Custom_Imp();
		try {
			same_date_route=same_date_same_route(session, cb, from, to);
			List<Integer> unava1= (List<Integer>) same_date_route.get(0).get("unavailable_bus");
			same_date_diff_route=same_date_differ_route(session, cb, from, to);
			List<Integer> unava2= (List<Integer>) same_date_diff_route.get(0).get("unavailable_bus");
			String excep="";
			for(int i=0;i<unava1.size();i++){
				excep+=" and id!="+unava1.get(i);
			}
			for(int i=0;i<unava2.size();i++){
				excep+=" and id!="+unava2.get(i);
			}
            query_all_bus = session.createQuery("from Bus_Master where enabled=?"+excep+" order by number_of_seat asc").setBoolean(0, true).list();  
            if(query_all_bus.size()>0){            
	              for(int i=0;i<query_all_bus.size();i++){	
	            	  Bus_Master bus = new Bus_Master();
	                  bus.setModel(query_all_bus.get(i).getModel());
	                  bus.setNumber_of_seat(query_all_bus.get(i).getNumber_of_seat());
	                  bus.setId(query_all_bus.get(i).getId());
	                  buses.add(bus);
	              } 
            }
	              
        } catch (RuntimeException e) {
        	e.printStackTrace();
        }    
		return buses;
	}
	
	
	
	
	
	
	
	public  List<Map<String,Object>> same_date_same_route(Session session,Customer_Booking cb,int from, int to) throws ParseException{
		List<Schedule_Master> sch=new ArrayList<Schedule_Master>();
		List<Map<String,Object>> all_bus =new ArrayList<Map<String,Object>>();
		List<Integer> ava_bus=new ArrayList<Integer>();
		List<Integer> una_bus=new ArrayList<Integer>();
		try {
			
			sch=session.createQuery("from Schedule_Master where dept_date=:date and dept_time!=:time and to_id=:to and from_id=:from")
					.setDate("date",java.sql.Date.valueOf(cb.getDate()))
					.setTime("time", java.sql.Time.valueOf(cb.getTime()))
					.setParameter("to", to)
					.setParameter("from", from).list();
			
			for(int i=0;i<sch.size();i++){
				if(time_same_date(sch.get(i).getDept_time().toString(),cb.getTime(),8)){
					ava_bus.add(sch.get(i).getBus_id());
				}else{
					una_bus.add(sch.get(i).getBus_id());
				}
			}
			Map<String, Object> map=new HashMap<String , Object>();
			map.put("unavailable_bus", una_bus);
			map.put("available_bus", ava_bus);
			all_bus.add(map);
			System.out.println("same_date_same_route:  ");
			System.out.println(all_bus);
	              
        } catch (RuntimeException e) {
        	e.printStackTrace();
        }    
		return all_bus;
	}
	//Check Bus Available and not from the same route 
	public List<Map<String,Object>> same_date_differ_route(Session session,Customer_Booking cb,int from, int to) throws ParseException{
			List<Schedule_Master> sch=new ArrayList<Schedule_Master>();
			List<Map<String,Object>> all_bus =new ArrayList<Map<String,Object>>();
			List<Integer> ava_bus=new ArrayList<Integer>();
			List<Integer> una_bus=new ArrayList<Integer>();
			try {	
				sch=session.createQuery("from Schedule_Master where dept_date=:date and from_id!=:from")
						.setDate("date",java.sql.Date.valueOf(cb.getDate()))
						.setParameter("from", from).list();
				
				for(int i=0;i<sch.size();i++){
					if(time_same_date(sch.get(i).getDept_time().toString(),cb.getTime(),4)){
						ava_bus.add(sch.get(i).getBus_id());
					}else{
						una_bus.add(sch.get(i).getBus_id());
					}
				}
				Map<String, Object> map=new HashMap<String , Object>();
				map.put("unavailable_bus", una_bus);
				map.put("available_bus", ava_bus);
				all_bus.add(map);
				System.out.println("same_date_differ_route:  ");
				System.out.println(all_bus);
		              
	        } catch (RuntimeException e) {
	        	e.printStackTrace();
	        }    
			return all_bus;
		}
	
	
	
	
	
	
	
	
	
	
	
	public static List<Schedule_Master> getDriverNBusByExcep (Query query){
		List<Schedule_Master> schedules= new ArrayList<Schedule_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            schedules=(List<Schedule_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
		
	}
	
	
	
	
	public static List<User_Info> get_all_available_drivers(Session session,Customer_Booking cb,int from, int to) throws ParseException{
		System.out.println("get_all_available_drivers");
		List<User_Info> drivers=new ArrayList<User_Info>();
		List<Map<String,Object>> all_bus =new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> same_date_route =new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> same_date_diff_route =new ArrayList<Map<String,Object>>();
		try {
			same_date_route= new userDaoImpl().same_date_same_rout(session, cb, from, to);
			List<Integer> unava1= (List<Integer>) same_date_route.get(0).get("unavailable_bus");
			same_date_diff_route=new userDaoImpl().same_date_differ_rout(session, cb, from, to);
			List<Integer> unava2= (List<Integer>) same_date_diff_route.get(0).get("unavailable_bus");
			unava1.addAll(unava2);
			drivers = new userDaoImpl().getAllD(unava1);
	
	              
        } catch (RuntimeException e) {
        	e.printStackTrace();
        }
		return drivers;    
		
		
	}

	
	
	//Check Bus Available and not from the same route 
	
		public  List<Map<String,Object>> same_date_same_rout(Session session,Customer_Booking cb,int from, int to) throws ParseException{
			List<Schedule_Master> sch=new ArrayList<Schedule_Master>();
			List<Map<String,Object>> all_bus =new ArrayList<Map<String,Object>>();
			List<Integer> ava_bus=new ArrayList<Integer>();
			List<Integer> una_bus=new ArrayList<Integer>();
			try {
				
				sch=session.createQuery("from Schedule_Master where dept_date=:date and dept_time!=:time and to_id=:to and from_id=:from and driver_id!=:idd")
						.setDate("date",java.sql.Date.valueOf(cb.getDate()))
						.setTime("time", java.sql.Time.valueOf(cb.getTime()))
						.setParameter("to", to)
						.setInteger("idd", 0)
						.setParameter("from", from).list();
				
				for(int i=0;i<sch.size();i++){
					if(time_same_date(sch.get(i).getDept_time().toString(),cb.getTime(),8)){
						ava_bus.add(sch.get(i).getDriver_id());
					}else{
						una_bus.add(sch.get(i).getDriver_id());
					}
				}
				Map<String, Object> map=new HashMap<String , Object>();
				map.put("unavailable_bus", una_bus);
				map.put("available_bus", ava_bus);
				all_bus.add(map);
				
		              
	        } catch (RuntimeException e) {
	        	e.printStackTrace();
	        }    
			return all_bus;
		}
		
		
		
		
		
		
		//Check Bus Available and not from the same route 
		public  List<Map<String,Object>> same_date_differ_rout(Session session,Customer_Booking cb,int from, int to) throws ParseException{
				List<Schedule_Master> sch=new ArrayList<Schedule_Master>();
				List<Map<String,Object>> all_bus =new ArrayList<Map<String,Object>>();
				List<Integer> ava_bus=new ArrayList<Integer>();
				List<Integer> una_bus=new ArrayList<Integer>();
				try {	
					sch=session.createQuery("from Schedule_Master where dept_date=:date and from_id!=:from and driver_id!=:idd")
							.setDate("date",java.sql.Date.valueOf(cb.getDate()))
							.setInteger("idd", 0)
							.setParameter("from", from).list();
					
					for(int i=0;i<sch.size();i++){
						if(time_same_date(sch.get(i).getDept_time().toString(),cb.getTime(),4)){
							ava_bus.add(sch.get(i).getDriver_id());
						}else{
							una_bus.add(sch.get(i).getDriver_id());
						}
					}
					Map<String, Object> map=new HashMap<String , Object>();
					map.put("unavailable_bus", una_bus);
					map.put("available_bus", ava_bus);
					all_bus.add(map);
					
			              
		        } catch (RuntimeException e) {
		        	e.printStackTrace();
		        }    
				return all_bus;
			}
	
		public  List<User_Info> getAllD(List<Integer> idd) {
	      	List<User_Info> users= new ArrayList<User_Info>();
	   		Transaction trns25 = null;
			Session session = HibernateUtil.getSessionFactory().openSession();
			try{
				List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
				trns25  = session.beginTransaction();
				String queryString  = "from UserRole where role=:role";
	 		 	Query query = session.createQuery(queryString);
	 		 	query.setString("role", "ROLE_DRIVER");
	 		 	List<UserRole> roles = query.list();
	 		 	
	 		 	List<Integer> ids = new ArrayList<Integer>();
	 		 	ids = idd;
	 		 	boolean status = false;
	 		 	for(UserRole role :roles){
	 		 		for(int id : ids){
	 		 			if(role.getUser_info().getId() == id){
	 		 				status = true;
	 		 						break;
	 		 			}
	 		 		}
	 		 		if(!status){
	 		 			//No users found
	 		 			users.add(role.getUser_info());
	 		 		}
	 		 		status = false;
	 		 		
	 		 	}
	 		 	
			}
			catch(RuntimeException e)
			{
				e.printStackTrace();			
			}
			finally{
//				session.flush();
//				session.close();
			}
	        return users;
	    } 
	
	
		public Boolean time_same_date(String user_time, String time,long time_dura) throws ParseException{
			 
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1 = format.parse(user_time);
			Date date2 = format.parse(time);
			long difference = date2.getTime() - date1.getTime();
			long duration =difference/(1000*60*60);
			
			if(duration>=time_dura||duration<=-time_dura){
				return true;
			}else{
				return false;
			}
		}



















    

    public List <Schedule_Master> searchSchedule(Schedule_Model schedule) throws ParseException{
            List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();           
            Transaction trns7 = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                trns7 = session.beginTransaction();
                String queryString = "FROM Schedule_Master where source_id=:source_id and destination_id=:destination_id and dept_date=:dept_date and dept_time=:dept_time and remaining_seat >=:seat";
                Query query = session.createQuery(queryString);
                query.setInteger("source_id",schedule.getSource_id());
                query.setInteger("destination_id",schedule.getDestination_id());
                query.setInteger("seat",schedule.getRemaining_seat());
                query.setDate("dept_date",new SimpleDateFormat("MM/dd/yyyy").parse(schedule.getDept_date()));
                query.setTime("dept_time",java.sql.Time.valueOf(schedule.getDept_time()));
                schedules=(List<Schedule_Master>)query.list();
                } catch (RuntimeException e) {
                if (trns7 != null) {
                    trns7.rollback();
                }
                e.printStackTrace();
            } finally {
                session.flush();
                session.close();
            }
            return schedules;
        }



     public List <Schedule_Master> getA(Schedule_Model schedule) throws ParseException{
            List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
            Transaction trns7 = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                trns7 = session.beginTransaction();
                String queryString = "FROM Schedule_Master where dept_date=:dept_date";
                Query query = session.createQuery(queryString);
                query.setDate("dept_date",new SimpleDateFormat("MM/dd/yyyy").parse(schedule.getDept_date()));
                schedules=(List<Schedule_Master>)query.list();
                } catch (RuntimeException e) {
                if (trns7 != null) {
                    trns7.rollback();
                }
                e.printStackTrace();
            } finally {
                session.flush();
                session.close();
            }
            return schedules;
        }


        public List <Schedule_Master> getP(List <Schedule_Master> ss) throws ParseException{
            List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
            List <Bus_Master> buses  = new ArrayList<Bus_Master>();
            Transaction trns7 = null;
            int i;
            String queryString="FROM Bus_Master where ";
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                trns7 = session.beginTransaction();
                for(i=0;i<ss.size();i++){
                    queryString+= "(id !=:id"+i+")";
                    if(i!=ss.size()-1)
                        queryString+= " and ";}
                Query query = session.createQuery(queryString);
                for(i=0;i<ss.size();i++)
                    query.setInteger("id"+i, ss.get(i).getBus_id());
                buses=query.list();
                for(Bus_Master bus:buses)
                {
                    Schedule_Master schedule = new Schedule_Master();
                    schedule.setBus_id(bus.getId());
                    schedules.add(schedule);
                }
                } catch (RuntimeException e) {
                if (trns7 != null) {
                    trns7.rollback();
                }
                e.printStackTrace();
            } finally {
                session.flush();
                session.close();
            }
            return schedules;
        }














    public int saveTime(Schedule_Model schedule) throws ParseException{
        List <Dept_Time_Master> times  = new ArrayList<Dept_Time_Master>();
        Dept_Time_Master time = new Dept_Time_Master();
        Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Dept_Time_Master where dept_time=:dept_time";
            Query query = session.createQuery(queryString);
            query.setTime("dept_time",java.sql.Time.valueOf(schedule.getDept_time()));
            times=(List<Dept_Time_Master>)query.list();
            if(times.size()>0)
                    return 0;
            Timestamp created_at = new Timestamp(System.currentTimeMillis());
            time.setDept_time(java.sql.Time.valueOf(schedule.getDept_time()));
            time.setCreated_at(created_at);
            time.setEnabled(true);
            session.save(time);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }



    public int saveDate(Batch_Master b) throws ParseException{
        List <Batch_Master> batches  = new ArrayList<Batch_Master>();
        Batch_Master batch = new Batch_Master();
        Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Batch_Master where name=:name";
            Query query = session.createQuery(queryString);
            query.setString("name",b.getName());
            batches=(List<Batch_Master>)query.list();
            if(batches.size()>0)
                    return 0;
            Timestamp created_at = new Timestamp(System.currentTimeMillis());
            batch.setName(b.getName());
            batch.setCreated_at(created_at);
            batch.setDate_of_leaving(b.getDate_of_leaving());
            batch.setEnabled(true);
            session.save(batch);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }

    public int saveCost(Cost cost){
        Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            Timestamp created_at = new Timestamp(System.currentTimeMillis());
            cost.setCreated_at(created_at);
            session.save(cost);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }


    public int updateCost(Cost cost){
        Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            Timestamp updated_at = new Timestamp(System.currentTimeMillis());
            String queryString = "FROM Cost";
            Query query = session.createQuery(queryString);
            Cost n_cost=(Cost)query.list().get(0);
            n_cost.setAdult(cost.getAdult());
            n_cost.setChild(cost.getChild());
            n_cost.setUpdated_at(updated_at);
            session.update(n_cost);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }






	
	
	public int saveSchedule2(Schedule_Model schedule) throws ParseException{
		List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
		Schedule_Master s = new Schedule_Master();
		int id;
		Date dept_date = null;
		Time dept_time = null;
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Schedule_Master where code=:code";
            Query query = session.createQuery(queryString);
            query.setString("code",schedule.getCode());
            schedules=(List<Schedule_Master>)query.list();
            if(schedules.size()>0)
    				return 0;
    		Timestamp created_at = new Timestamp(System.currentTimeMillis());
    		int remaining =  new userDaoImpl().getBusById(schedule.getBus_id()).getNumber_of_seat()-schedule.getNumber_booking();
    		s.setBus_id(schedule.getBus_id());
    		s.setCode(schedule.getCode());
    		s.setCreated_at(created_at);
    		s.setDept_date(getScheduleById(schedule.getIdd()).getDept_date());
    		s.setDept_time(getScheduleById(schedule.getIdd()).getDept_time());
    		s.setDestination_id(schedule.getDestination_id());
    		s.setDriver_id(schedule.getDriver_id());
    		s.setNumber_booking(schedule.getNumber_booking());
    		s.setNumber_customer(schedule.getNumber_customer());
    		s.setNumber_staff(schedule.getNumber_staff());
    		s.setNumber_student(schedule.getNumber_student());
    		s.setRemaining_seat(remaining);
    		s.setSource_id(schedule.getSource_id());
    		s.setFrom_id(schedule.getFrom_id());
    		s.setTo_id(schedule.getTo_id());
            session.save(s);
            id = s.getId();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return -5;
        } finally {
            session.flush();
            session.close();
        }
		return id;
	}
	
	
	
	
	
	public int updateSchedule(Schedule_Model schedule){
		List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
		int count =0;
		Date dept_date = null;
		Time dept_time = null;
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            schedules = getAllSchedules();
            for(Schedule_Master ss:schedules)
            {
                if(schedule.getId()!=ss.getId())
                        {
                            if (ss.getCode().equals(schedule.getCode()))
                                count++;
                        }
            }
            if(count>=1)
                return 0;
            String queryString = "FROM Schedule_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",schedule.getId());
            Schedule_Master s  = (Schedule_Master) query.uniqueResult();
    		Timestamp updated_at = new Timestamp(System.currentTimeMillis());
    		s.setBus_id(schedule.getBus_id());
    		s.setRemaining_seat(new userDaoImpl().getBusById(schedule.getBus_id()).getNumber_of_seat()-new userDaoImpl().getScheduleById(schedule.getId()).getNumber_booking());
    		s.setUpdated_at(updated_at);
    		s.setDriver_id(schedule.getDriver_id());
            session.update(s);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
	}
	
	
	
	
	public int confirmRequest(Booking_Request_Master request){
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Booking_Request_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",request.getId());
            Booking_Request_Master r  = (Booking_Request_Master) query.uniqueResult();
    		Timestamp updated_at = new Timestamp(System.currentTimeMillis());
    		r.setProvided_time(request.getProvided_time());
    		r.setUpdated_at(updated_at);
    		r.setStatus("Confirmed");
    		session.update(r);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
	}
	
	
	
	public int rejectRequest(Booking_Request_Master request){
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Booking_Request_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",request.getId());
            Booking_Request_Master r  = (Booking_Request_Master) query.uniqueResult();
    		Timestamp updated_at = new Timestamp(System.currentTimeMillis());
    		r.setUpdated_at(updated_at);
    		r.setStatus("Rejected");
    		session.update(r);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
	}
	
	
	
	public int ignoreRefund(Refund_Master refund){
        Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Refund_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",refund.getId());
            Refund_Master r  = (Refund_Master) query.uniqueResult();
            
            r.setStatus("Ignored");
            session.update(r);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }

    public int doneRefund(Refund_Master refund){
        Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Refund_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",refund.getId());
            Refund_Master r  = (Refund_Master) query.uniqueResult();
            
            r.setStatus("Done");
            session.update(r);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }

    public int payBooking(Booking_Master booking){
        Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Booking_Master where id=:id";
            Query query = session.createQuery(queryString);
            query.setInteger("id",booking.getId());
            Booking_Master r  = (Booking_Master) query.uniqueResult();
            
            r.setPayment("Succeed");
            session.update(r);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
    }







	public int savePickUpLocation(Pickup_Location_Master p_location){
		List <Pickup_Location_Master> p_locations  = new ArrayList<Pickup_Location_Master>();
		List <Location_Master> locations  = new ArrayList<Location_Master>();
    	Transaction trns7 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns7 = session.beginTransaction();
            String queryString = "FROM Pickup_Location_Master where name=:name and enabled=:status";
            String queryString2 = "FROM Location_Master where name=:name and enabled=:status";
            Query query = session.createQuery(queryString);
            query.setString("name",p_location.getName());
            query.setBoolean("status",true);
            Query query2 = session.createQuery(queryString2);
            query2.setString("name",p_location.getName());
            query2.setBoolean("status",true);
            p_locations=(List<Pickup_Location_Master>)query.list();
            locations=(List<Location_Master>)query2.list();
         
    			if(locations.size()>0 || p_locations.size()>0)
    				return 0;
    		Timestamp created_at = new Timestamp(System.currentTimeMillis());
        	p_location.setCreated_at(created_at);
        	p_location.setEnabled(true);
        	p_location.setPermanent(true);
            session.save(p_location);  
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns7 != null) {
                trns7.rollback();
            }
            e.printStackTrace();
            return 5;
        } finally {
            session.flush();
            session.close();
        }
		return 1;
		
	}


    public List <Booking_Master> getAllHistoricalBookings(){
        List <Booking_Master> bookings  = new ArrayList<Booking_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Booking_Master where dept_date<:localDate and (payment=:payment or payment=:payment2) and notification !=:notification";
            Query query = session.createQuery(queryString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println(dtf.format(localDate));
            query.setDate("localDate", date);
            query.setString("payment", "Succeed");
            query.setString("payment2", "Cash");
            query.setString("notification", "Cancelled");
            bookings=(List<Booking_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return bookings;
        } finally {
            session.flush();
            session.close();
        }
        return bookings;
        
    }


	public List <Booking_Master> getAllCurrentBookings(){
		List <Booking_Master> bookings  = new ArrayList<Booking_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Booking_Master where dept_date>=:localDate and (payment=:payment or payment=:payment2) and notification!=:notification";
            Query query = session.createQuery(queryString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println(dtf.format(localDate));
            query.setDate("localDate", date);
            query.setString("payment", "Succeed");
            query.setString("payment2", "Cash"); 
            query.setString("notification", "Cancelled");
            bookings=(List<Booking_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return bookings;
        } finally {
            session.flush();
            session.close();
        }
        return bookings;
		
	}




    public List <Booking_Master> getAllUnpaidBookings(){
        List <Booking_Master> bookings  = new ArrayList<Booking_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Booking_Master where payment=:payment and notification!=:notification";
            Query query = session.createQuery(queryString);
            query.setString("payment", "Cash"); 
            query.setString("notification", "Cancelled");
            bookings=(List<Booking_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return bookings;
        } finally {
            session.flush();
            session.close();
        }
        return bookings;
        
    }




    public List <Refund_Master> getAllRefunds(){
        List <Refund_Master> refunds  = new ArrayList<Refund_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Refund_Master where status=:status";
            Query query = session.createQuery(queryString);
            query.setString("status", "Pending"); 
            refunds=(List<Refund_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return refunds;
        } finally {
            session.flush();
            session.close();
        }
        return refunds;
        
    }




	
	
	
	public List <Booking_Master> getAllBookings(){
		List <Booking_Master> bookings  = new ArrayList<Booking_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Booking_Maste";
            Query query = session.createQuery(queryString);
            bookings=(List<Booking_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return bookings;
        } finally {
            session.flush();
            session.close();
        }
        return bookings;
		
	}
	
	
	
	public List <Booking_Request_Master> getAllCurrentBookingRequests(){
		List <Booking_Request_Master> requests  = new ArrayList<Booking_Request_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Booking_Request_Master where dept_date>=:localDate and status=:status and enabled=:enabled";
            Query query = session.createQuery(queryString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println(dtf.format(localDate));
            query.setDate("localDate", date);
            query.setString("status", "Pending");
            query.setBoolean("enabled", true);
            requests=(List<Booking_Request_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return requests;
        } finally {
            session.flush();
            session.close();
        }
        return requests;
		
	}
	
	
	public List <Booking_Request_Master> getAllHistoricalBookingRequests(){
		List <Booking_Request_Master> requests  = new ArrayList<Booking_Request_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Booking_Request_Master where dept_date<=:localDate or status!=:status";
            Query query = session.createQuery(queryString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println(dtf.format(localDate));
            query.setDate("localDate", date);
            query.setString("status", "Pending");
            requests=(List<Booking_Request_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return requests;
        } finally {
            session.flush();
            session.close();
        }
        return requests;
		
	}
	
	
	
//	public String customer_booking2(Customer_Booking cb) throws ParseException{	
//		System.out.println("customer_booking2");
//		Transaction trns = null;
//        Session session = HibernateUtil.getSessionFactory().openSession(); 
//        List<Map<String,Object>> all_bus =new ArrayList<Map<String,Object>>();  
//        List<Schedule_Master> schedule=new ArrayList<Schedule_Master>();
//        Custom_Dao custom_imp=new Custom_Imp();
//		try {
//            trns = session.beginTransaction();
//            Pickup_Location_Master pick_source=new Pickup_Location_Master();
//          	pick_source = (Pickup_Location_Master) session.createQuery("from Pickup_Location_Master where id=?").setParameter(0, cb.getSource()).list().get(0);
//          	Pickup_Location_Master pick_destin=new Pickup_Location_Master();
//          	pick_destin = (Pickup_Location_Master) session.createQuery("from Pickup_Location_Master where id=?").setParameter(0, cb.getDestination()).list().get(0);
//            
//          	schedule=session.createQuery("from Schedule_Master where dept_date=:date and dept_time=:time and to_id=:to and from_id=:from")
//					.setDate("date",java.sql.Date.valueOf(cb.getDate()))
//					.setTime("time", java.sql.Time.valueOf(cb.getTime()))
//					.setParameter("to", pick_destin.getLocation_id())
//					.setParameter("from", pick_source.getLocation_id()).list();
//          	
//          	Boolean check_ass=true; // Check whether we can assign this passenger to existing schedule or not
//          	for(int i=0;i<schedule.size();i++){
//          		if(schedule.get(i).getRemaining_seat()>=cb.getNumber_of_seat())
//          			return "Confirm";
//          	}          	
//          	if(check_ass)
//          		{
//          		all_bus= custom_imp.get_all_bus(session,cb,pick_source.getLocation_id(),pick_destin.getLocation_id());
//          		//extract buses in schedule from all_bus
//          		//after extracting, if no buses left just not confirm, if yes check number seats
//          		}
//		} catch (RuntimeException e) {
//        	e.printStackTrace();
//        	trns.rollback();
//        	return "error";
//        }finally {
//            session.flush();
//            session.close();
//        }           
//		return "Confirm";
//	}
//	
	
	
	
	
	public List <Schedule_Master> getAllCurrentSchedules(){
		List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Schedule_Master where dept_date>=:localDate";
            Query query = session.createQuery(queryString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println(dtf.format(localDate));
            query.setDate("localDate", date);
            schedules=(List<Schedule_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return schedules;
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
		
	}


    public List <Schedule_Master> busBeforeDelete(int id){
        List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Schedule_Master where dept_date>=:localDate and bus_id=:id";
            Query query = session.createQuery(queryString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println(dtf.format(localDate));
            query.setDate("localDate", date);
            query.setInteger("id",id);
            schedules=(List<Schedule_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return schedules;
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
        
    }
	
	
	public List <Schedule_Master> getAllSchedules(){
		List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Schedule_Master order by id asc";
            Query query = session.createQuery(queryString);
            schedules=(List<Schedule_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return schedules;
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
		
	}
	
	
	public List<Booking_Master> getBookingReporting(B_Model booking) throws ParseException {
		List<Booking_Master> bookings= null;
		int from = booking.getFrom_id();
		int to = booking.getTo_id();
		System.out.println("Date "+booking.getDept_date());
		System.out.println("Time "+booking.getN());
		String query = "from Booking_Master where id>0";
   		if(from!=0)
   			query=query+" and from_id=:from";
   		if(to!=0)
   			query=query+" and to_id=:to";
   		if(!booking.getDept_date().equals("nth"))
   			query=query+" and dept_date=:date";
   		if(!booking.getN().toString().equals("nth"))
   	    	query=query+" and dept_time=:time";
        if(!booking.getNotification().equals("nth"))
            query=query+" and notification=:notification";
   		System.out.println("Query "+query);
		Transaction trns25 = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
			trns25  = session.beginTransaction();
  		 	Query q = session.createQuery(query);
  		 	if(from!=0)
  		 		q.setInteger("from", from );
  	   		if(to!=0)
  	   			q.setInteger("to", to);
  	   		if(!booking.getDept_date().equals("nth"))
  	   			q.setDate("date", new SimpleDateFormat("MM/dd/yyyy").parse(booking.getDept_date()));
  	   		if(!booking.getN().toString().equals("nth"))
  	   			q.setTime("time",java.sql.Time.valueOf(booking.getN()));
            if(!booking.getNotification().equals("nth"))
            	q.setString("notification",booking.getNotification());
  	   		System.out.println("Q "+q);
  	   		bookings = q.list();
  	   		System.out.println("Size "+bookings.size());
 		 	
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return bookings;
		}
		finally{
			session.flush();
			session.close();
		}
		return bookings;
	}





    public List<Booking_Master> getScheduleReporting(B_Model booking) throws ParseException {
        List<Booking_Master> bookings= null;
        int from = booking.getFrom_id();
        int to = booking.getTo_id();
        int driver = booking.getUser_id();
        int bus = booking.getSchedule_id();
        System.out.println("Date "+booking.getDept_date());
        System.out.println("Time "+booking.getN());
        String query = "from Schedule_Master where id>0";
        if(from!=0)
            query=query+" and from_id=:from";
        if(to!=0)
            query=query+" and to_id=:to";
        if(driver!=0)
            query=query+" and driver_id=:driver";
        if(bus!=0)
            query=query+" and bus_id=:bus";
        if(!booking.getDept_date().equals("nth"))
            query=query+" and dept_date=:date";
        if(!booking.getN().toString().equals("nth"))
            query=query+" and dept_time=:time";
        
        System.out.println("Query "+query);
        Transaction trns25 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            List<Map<String,Object>> list_map = new ArrayList<Map<String,Object>>();
            trns25  = session.beginTransaction();
            Query q = session.createQuery(query);
            if(from!=0)
                q.setInteger("from", from );
            if(to!=0)
                q.setInteger("to", to);
            if(driver!=0)
                q.setInteger("driver", driver);
            if(bus!=0)
                q.setInteger("bus", bus);
            if(!booking.getDept_date().equals("nth"))
                q.setDate("date", new SimpleDateFormat("MM/dd/yyyy").parse(booking.getDept_date()));
            if(!booking.getN().toString().equals("nth"))
                q.setTime("time",java.sql.Time.valueOf(booking.getN()));
            
            System.out.println("Q "+q);
            bookings = q.list();
            System.out.println("Size "+bookings.size());
            
        }
        catch(RuntimeException e)
        {
            e.printStackTrace();
            return bookings;
        }
        finally{
            session.flush();
            session.close();
        }
        return bookings;
    }



	
	
	
	public List <Schedule_Master> getAllHistoricalSchedules(){
		List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Schedule_Master where dept_date<:localDate";
            Query query = session.createQuery(queryString);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println(dtf.format(localDate));
            query.setDate("localDate", date);
            schedules=(List<Schedule_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return schedules;
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
		
	}
	
	
	

	
	
	
	public List <Schedule_Master> getAllSchedulesByMonth(String month, String year) throws ParseException{
		List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Schedule_Master s where s.dept_date between :date1 and :date2";
            Query query = session.createQuery(queryString);
            Date date1;
    		Date date2;
            String first = "01/"+month+"/"+year;
            date1 = formatter.parse(first);
            String last = getLastDateOfMonth(date1)+"/"+month+"/"+year;
       		date2 = formatter.parse(last);
       		System.out.println(date1+"   "+date2);
       		
      		query.setDate("date1", date1);
            query.setDate("date2", date2);
            
            schedules=(List<Schedule_Master>)query.list();        
        } catch (RuntimeException e) {
            e.printStackTrace();
            return schedules;
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
		
	}
	
	
	
	public List <Schedule_Master> schedule_list(String date, String month, String year) throws ParseException{
		List <Schedule_Master> schedules  = new ArrayList<Schedule_Master>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 =  session.beginTransaction();
            String queryString = "from Schedule_Master s where s.dept_date=:date1";
            Query query = session.createQuery(queryString);
            Date date1;
            String first = date+"/"+month+"/"+year;
            date1 = formatter.parse(first);
      		query.setDate("date1", date1);
      		schedules=(List<Schedule_Master>)query.list();        
        } catch (RuntimeException e) {
            e.printStackTrace();
            return schedules;
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
		
	}
	
	
	
	
	public String getLastDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return Integer.toString(cal.getTime().getDate());
    }
	
	
	public int moveSchedule(int arr[], int id)
	{
		Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int a[]=arr;    
        int old_id;
        try {
            trns19 =  session.beginTransaction();
            old_id = new userDaoImpl().getBookingById(a[0]).getSchedule_id();
            Schedule_Master master = new userDaoImpl().getScheduleById(old_id);
            master.setNumber_booking(master.getNumber_booking()-new userDaoImpl().getScheduleById(id).getNumber_booking());
            master.setRemaining_seat(master.getRemaining_seat()+new userDaoImpl().getScheduleById(id).getNumber_booking());
            session.update(master);
            for (int i = 0; i < a.length; i++)
   		   {
              Booking_Master booking = new userDaoImpl().getBookingById(a[i]);
              booking.setSchedule_id(id);
   		      session.update(booking);
   		     
   		   }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns19 != null) {
                trns19.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
	}
	
	
	
	public int moveSimple(int arr[], int old_id, int new_id, int bookings)
	{
		Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int a[]=arr;    
        try {
            trns19 =  session.beginTransaction();
            for (int i = 0; i < a.length; i++)
   		   {
              System.out.println(a[i]);
              Booking_Master booking = getBookingById(a[i]);
              booking.setSchedule_id(new_id);
   		      session.update(booking);
   		     
   		   }
            Schedule_Master old_schedule = getScheduleById(old_id);
            old_schedule.setNumber_booking(old_schedule.getNumber_booking()-bookings);
            old_schedule.setRemaining_seat(old_schedule.getRemaining_seat()+bookings);
            
            Schedule_Master new_schedule = getScheduleById(new_id);
            new_schedule.setNumber_booking(new_schedule.getNumber_booking()+bookings);
            new_schedule.setRemaining_seat(new_schedule.getRemaining_seat()-bookings);
            
            session.update(old_schedule);
            session.update(new_schedule);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	if (trns19 != null) {
                trns19.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            session.flush();
            session.close();
        }
        return 1;
	}
	public List<Bus_Master> getBusByAva (){
		List<Bus_Master> buses= new ArrayList<Bus_Master>();
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Bus_Master where availability=:availability";
            Query query = session.createQuery(queryString);
            query.setBoolean("availability",false);
            buses=(List<Bus_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return buses;
        } finally {
            session.flush();
            session.close();
        }
        return buses;
		
	}


    public List<Schedule_Master> getUnassignedSchedule (Schedule_Model s){
        List<Schedule_Master> schedules = new ArrayList<Schedule_Master>();
        boolean status =false;
        Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns19 = session.beginTransaction();
            String queryString = "from Schedule_Master where dept_date=:dept_date "+
            "and dept_time=:dept_time and from_id=:from_id and to_id =:to_id"+ 
            " and description=:description";
            Query query = session.createQuery(queryString);
            query.setDate("dept_date", s.getDept_date2());
            query.setTime("dept_time", s.getDept_time2());
            query.setInteger("from_id", s.getFrom_id());
            query.setInteger("to_id", s.getTo_id());
            query.setString("description", "Unassigned");
            schedules=(List<Schedule_Master>)query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return schedules;
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
        
    }

    
	

    public Map<String, String> moveToRental(Schedule_Model model)
    {
    	Schedule_Master s = new Schedule_Master();
    	Map<String, String> map = new HashMap<String,String>();
    	Transaction trns19 = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int a[]=model.getB();    
        int s_id = 0;
        System.out.println("Modellllllllllllll "+model);
        try {
        	Timestamp created_at = new Timestamp(System.currentTimeMillis());
            trns19 =  session.beginTransaction();
            List<Schedule_Master> schedules = new ArrayList<Schedule_Master>();
            schedules = new userDaoImpl().getUnassignedSchedule(model);
            if(schedules.size()>=1)
            {
            	int ab = 0;
            	for (int i = 0; i < a.length; i++)
                {
                   System.out.println(a[i]);
                   Booking_Master booking = getBookingById(a[i]);
                   booking.setSchedule_id(schedules.get(0).getId());
                   booking.setNotification("Booked");
                   ab += booking.getNumber_booking();
                   session.update(booking);
                  
                }
            	ab+= schedules.get(0).getNumber_booking();
                if(model.getSource_id()!=0)
                    schedules.get(0).setSource_id(model.getSource_id());
                if(model.getDestination_id()!=0)
                    schedules.get(0).setDestination_id(model.getDestination_id());
            	schedules.get(0).setNumber_booking(ab);
            	session.update(schedules.get(0));
            	
            	map.put("status", "55");
                map.put("code", schedules.get(0).getCode());
            }
            else
            {
            	int bus_id;
                List<Bus_Master> buses  = new userDaoImpl().getBusByAva();
                if(buses.size()>0)
                {
                	bus_id = buses.get(0).getId();
                }
                else{
                	Bus_Master bus = new Bus_Master();
                	bus.setAvailability(false);
                	bus.setCreated_at(created_at);
                	bus.setEnabled(true);
                	bus.setModel("Rental Bus");
                	bus.setNumber_of_seat(0);
                	bus.setPlate_number("Unknown");
                	bus_id = (Integer) session.save(bus);
                }
                	
                s.setBus_id(bus_id);
        		s.setCreated_at(created_at);
        		s.setDept_date(model.getDept_date2());
        		s.setDept_time(model.getDept_time2());
        		s.setDestination_id(model.getDestination_id());
        		s.setDriver_id(0);
        		s.setNumber_customer(model.getNumber_customer());
        		s.setNumber_staff(model.getNumber_staff());
        		s.setNumber_student(model.getNumber_student());
        		s.setSource_id(model.getSource_id());
        		s.setRemaining_seat(0);
                s.setDescription("Unassigned");
        		s.setFrom_id(model.getFrom_id());
        		s.setTo_id(model.getTo_id());
        		s_id  = (Integer) session.save(s);
        		s.setCode(getScheduleSequence(s_id));
                int ab = 0;
                for (int i = 0; i < a.length; i++)
               {
                  System.out.println(a[i]);
                  Booking_Master booking = getBookingById(a[i]);
                  booking.setSchedule_id(s_id);
                  booking.setNotification("Booked");
                  ab += booking.getNumber_booking();
                  session.update(booking);
                 
               }
                s.setNumber_booking(ab);           
                session.update(s);
                map.put("status", "1");
                map.put("code", getScheduleSequence(s_id));
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns19 != null) {
                trns19.rollback();
            }
            e.printStackTrace();
            map.put("status", "0");
            return map;
        } finally {
            session.flush();
            session.close();
        }
        
        return map;
    }


	
	
	
	public void confirmedRequest(String email) {
		Boolean ret=false;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			trns  = session.beginTransaction();
	  	        Mail mail = new Mail();
		        mail.setMailFrom("vkirirom_shuttlebus@gmail.com.com");
		        mail.setMailTo(email);
		        mail.setMailSubject("Kirirom Shuttle Bus Booking Request");
		 
		        Map < String, Object > model = new HashMap < String, Object > ();
		        model.put("name", new userDaoImpl().getCustomerByEmail(email).getUsername());
		        model.put("email", email);
		        mail.setModel(model);
		        mail.setFile_name("booking_request_confirmed_email_template.txt");
		        
		 
		        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		        MailService mailService = (MailService) context.getBean("mailService");
		        mailService.sendEmail(mail);
		        context.close();
		        ret=true;
		}
		catch (RuntimeException e){
            if (trns != null) {
                trns.rollback();
            }
     	}finally {
            session.flush();
            session.close();
          }
      
	}
	
	
	
	public void rejectedRequest(String email) {
		Boolean ret=false;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			trns  = session.beginTransaction();
	  	        Mail mail = new Mail();
		        mail.setMailFrom("vkirirom_shuttlebus@gmail.com.com");
		        mail.setMailTo(email);
		        mail.setMailSubject("Kirirom Shuttle Bus Booking Request");
		 
		        Map < String, Object > model = new HashMap < String, Object > ();
		        model.put("name", new userDaoImpl().getCustomerByEmail(email).getUsername());
		        model.put("email", email);
		        mail.setModel(model);
		        mail.setFile_name("booking_request_rejected_email_template.txt");
		        
		 
		        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		        MailService mailService = (MailService) context.getBean("mailService");
		        mailService.sendEmail(mail);
		        context.close();
		        ret=true;
		}
		catch (RuntimeException e){
            if (trns != null) {
                trns.rollback();
            }
     	}finally {
            session.flush();
            session.close();
          }
        
	}

	public static void main(String arg[]){
	    String email = "varathana14@kit.edu.kh";
	    System.out.println(email.contains("@kit.edu.kh"));
        String ar = email.split("@")[0];
        String year = String.valueOf(ar.charAt(ar.length()-2)) + ar.charAt(ar.length()-1);
        int batch = Integer.parseInt(year) -13;
        System.out.println(batch);

    }

	
	
}






