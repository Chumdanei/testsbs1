/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-20 15:34:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class booking_005fdetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<body onload=\"load()\">\r\n");
      out.write("<article class=\"content cards-page\">\r\n");
      out.write("                    \t\r\n");
      out.write("                    <section class=\"section\">\r\n");
      out.write("                        <div class=\"row sameheight-container\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <div class=\"card card-block sameheight-item\">\r\n");
      out.write("                                    <div class=\"title-block\">\r\n");
      out.write("                                        <h3 class=\"title\"> Booking Information </h3>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <br><br>\r\n");
      out.write("                                    <form class=\"form-group\" id =\"myForm\">\r\n");
      out.write("                                    \t<div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"exampleInputEmail3\">Booking Code</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"code\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"exampleInputEmail3\">Name</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"uname\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"exampleInputEmail3\">From</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"from\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"exampleInputEmail3\">To</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"to\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"exampleInputEmail3\">Departure Date</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"dept_date\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"exampleInputEmail3\">Departure Time</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"dept_time\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"exampleInputEmail3\">Booked On</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"bookedOn\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"exampleInputEmail3\">Number of bookings</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"no_booking\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        \r\n");
      out.write("                                        \r\n");
      out.write("                                        <button class=\"btn btn-default\" id=\"btnCancel\" onclick=\"parent.history.go(-1)\"><i class=\"fa fa-angle-left\"></i><b>Back</b></button> \r\n");
      out.write("                               \r\n");
      out.write("                                       \r\n");
      out.write("                                        \r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </section>\r\n");
      out.write("                    \r\n");
      out.write("                </article>\r\n");
      out.write("                \r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var id;\r\n");
      out.write("load = function () {\r\n");
      out.write("\tvar data = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("\tconsole.log(data)\r\n");
      out.write("\tvar booking = data.booking;\r\n");
      out.write("\tvar locations = data.locations;\r\n");
      out.write("\tvar p_locations = data.p_locations;\r\n");
      out.write("\tconsole.log(data)\r\n");
      out.write("\t$(\"#code\").val(booking.code);\r\n");
      out.write("\t$(\"#uname\").val(booking.n);\r\n");
      out.write("\t$(\"#from\").val(searchPLocation(booking.source_id,p_locations)+\", \"+searchLocation(booking.from_id,locations));\r\n");
      out.write("\t$(\"#to\").val(searchPLocation(booking.destination_id,p_locations)+\", \"+searchLocation(booking.to_id,locations));\r\n");
      out.write("\t$(\"#dept_date\").val(formatDate(booking.dept_date));\r\n");
      out.write("\t$(\"#dept_time\").val(booking.dept_time);\r\n");
      out.write("\t$(\"#bookedOn\").val(formatDate(booking.booking_date));\r\n");
      out.write("\t$(\"#no_booking\").val(booking.number_booking);\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"input\").prop('disabled', true);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"#bookingMng\").addClass(\"active\");\r\n");
      out.write("\t$(\"#myForm\").on('submit',function(e){\r\n");
      out.write("\t\te.preventDefault();\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("formatDate =function (date) {\r\n");
      out.write("    var d = new Date(date),\r\n");
      out.write("        month = '' + (d.getMonth() + 1),\r\n");
      out.write("        day = '' + d.getDate(),\r\n");
      out.write("        year = d.getFullYear();\r\n");
      out.write("\r\n");
      out.write("    if (month.length < 2) month = '0' + month;\r\n");
      out.write("      if (day.length < 2) day = '0' + day;\r\n");
      out.write("\r\n");
      out.write("    return [month, day, year].join('-');\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function searchPLocation(id, myArray){\r\n");
      out.write("    for (var i=0; i < myArray.length; i++) {\r\n");
      out.write("        if (myArray[i].id === id) {\r\n");
      out.write("            return myArray[i].name;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function searchLocation(id, myArray){\r\n");
      out.write("    for (var i=0; i < myArray.length; i++) {\r\n");
      out.write("        if (myArray[i].id === id) {\r\n");
      out.write("            return myArray[i].name;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}