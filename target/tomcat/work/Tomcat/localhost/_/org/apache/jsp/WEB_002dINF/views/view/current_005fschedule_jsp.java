/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-16 07:41:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class current_005fschedule_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    <div class=\"title-block\">\r\n");
      out.write("                         <div class=\"clearfix\" style=\"margin-bottom: 10px;\">\r\n");
      out.write("                         \t<div class=\"pull-left\">\r\n");
      out.write("                         \t\t<h3 class=\"title\"> Schedules </h3>\r\n");
      out.write("                         \t\t<p class=\"title-description\"> All current schedules </p> \r\n");
      out.write("                         \t</div>\r\n");
      out.write("                         \t<div class=\"btn-group pull-right\">\r\n");
      out.write("\t\t                        <button type=\"button\" class=\"btn btn-info\" id=\"btnList\" style=\"color:white;border-right:2px solid white;\"><i class=\"fa fa-list-ul\"></i></button>\r\n");
      out.write("\t\t                        <button type=\"button\" class=\"btn btn-info\" onclick=\"window.location.href='schedule'\" style=\"color:white;\"><i class=\"fa fa-calendar\"></i></button>\r\n");
      out.write("\t\t                    </div>\r\n");
      out.write("                         \t\r\n");
      out.write("                         </div>\r\n");
      out.write("                         \r\n");
      out.write("                       \r\n");
      out.write("\t                         <div style=\"margin-bottom: 10px;\">\r\n");
      out.write("\t\t                         <button type=\"button\" class=\"btn btn-pill-right btn-info pull-right\" style=\"color:white;\" onclick=\"location.href='historical_schedule';\">View all historical schedules <i class=\"fa fa-angle-right\"></i></button>\r\n");
      out.write("\t\t                         <button type=\"button\" class=\"btn btn-info\" onclick=\"window.location.href='create_schedule'\" style=\"color:white;\">Create</button>\r\n");
      out.write("\t                      \t </div>\r\n");
      out.write("\t                      \t </div>\r\n");
      out.write("\t                      \t <div style=\"margin-bottom: 10px;\">\r\n");
      out.write("\t                      \t     <input type=\"text\" class=\"form-control\" placeholder=\"Search for any schedule by code...\" id=\"txtbox\"/>\r\n");
      out.write("\t                    \t </div>\t\r\n");
      out.write("                   \r\n");
      out.write("                    \t\r\n");
      out.write("                    <section class=\"section\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-12\">\r\n");
      out.write("                                <div class=\"card\">\r\n");
      out.write("                                    <div class=\"card-block\">\r\n");
      out.write("                                        <div class=\"card-title-block\">\r\n");
      out.write("                                            <h3 class=\"title\"> Current and future schedules </h3>\r\n");
      out.write("                                            \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <section class=\"example\">\r\n");
      out.write("                                            <div class=\"table-responsive\">\r\n");
      out.write("                                                <table class=\"table table-striped table-bordered table-hover\">\r\n");
      out.write("                                                    <thead>\r\n");
      out.write("                                                        <tr>\r\n");
      out.write("                                                            <th>No</th>\r\n");
      out.write("                                                            <th>Code</th>\r\n");
      out.write("                                                            <th>Bus</th>\r\n");
      out.write("                                                            <th>Driver</th>\r\n");
      out.write("                                                            <th>From</th>\r\n");
      out.write("                                                            <th>To</th>\r\n");
      out.write("                                                            <th>Departure Date</th>\r\n");
      out.write("                                                            <th>Departure Time</th>\r\n");
      out.write("                                                            <th>Number of bookings</th>\r\n");
      out.write("                                                            <th></th>\r\n");
      out.write("                                                        </tr>\r\n");
      out.write("                                                    </thead>\r\n");
      out.write("                                                    <tbody id=\"allSchedules\">\r\n");
      out.write("                                                       \r\n");
      out.write("                                                    </tbody>\r\n");
      out.write("                                                </table>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </section>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </section>\r\n");
      out.write("                </article>\r\n");
      out.write("                \r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("var ch;\r\n");
      out.write("load = function(){\t\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl:'getAllCurrentSchedules',\r\n");
      out.write("\t\ttype:'GET',\r\n");
      out.write("\t\tsuccess: function(response){\r\n");
      out.write("\t\t\tconsole.log(response)\r\n");
      out.write("\t\t\tvar schedules = response.schedules;\r\n");
      out.write("\t\t\tvar locations = response.locations;\r\n");
      out.write("\t\t\tvar buses = response.buses;\r\n");
      out.write("\t\t\tvar drivers  = response.drivers;\r\n");
      out.write("\t\t\tfor (var i=0;i<schedules.length;i++)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\tvar schedule = '<tr class=\"hoverr search\" s-title=\"'+schedules[i].code+'\" data-url=\"schedule_detail?id='+schedules[i].id+'\"><td>'+(i+1)+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td>'+schedules[i].code+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td>'+searchBus(schedules[i].bus_id,buses)+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td>'+searchDriver(schedules[i].driver_id,drivers)+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td>'+searchLocation(schedules[i].from_id,locations)+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td>'+searchLocation(schedules[i].to_id,locations)+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td>'+formatDate(schedules[i].dept_date)+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td>'+schedules[i].dept_time+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td>'+schedules[i].number_booking+'</td>'\r\n");
      out.write("\t\t\t\t\t\t\t\t+'<td class=\"unhoverr\" data-url=\"'+schedules[i].id+'\" style=\"color:#e85a71\"><i class=\"fa fa-trash\"></i></td></tr>';\r\n");
      out.write("\t\t\t$(\"#allSchedules\").append(schedule);\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$( \".unhoverr\" ).on('click', function(e) {\r\n");
      out.write("\t\t\t\te.stopPropagation();\t\r\n");
      out.write("\t\t\t\tvar s_id = parseInt($(this).attr('data-url'));\r\n");
      out.write("\t\t\t\tdeleteSchedule(s_id);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\".hoverr\").on('click', function(e) {\r\n");
      out.write("\t\t\t\te.stopPropagation();\r\n");
      out.write("\t\t    \tlocation.href=$(this).attr('data-url');\r\n");
      out.write("\t\t\t});\r\n");
      out.write("    \t},\r\n");
      out.write("\terror: function(err){\r\n");
      out.write("\t\tswal(\"Oops!\", \"Cannot get all schedules data\", \"error\")\r\n");
      out.write("\t\tconsole.log(JSON.stringify(err));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("goTO = function(){\r\n");
      out.write("\t$('#bsubmit').trigger('click');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"#scheduleMng\").addClass(\"active\");\r\n");
      out.write("\t$(\"#btnList\").addClass(\"active\");\r\n");
      out.write("\t$(\"#txtbox\").keyup(function(){\r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t   $(\".search\").each(function(){\r\n");
      out.write("\t \t         \r\n");
      out.write("\t\t          $(this).show();\r\n");
      out.write("\t\t         \r\n");
      out.write("\t\t        });\r\n");
      out.write("\t\t     var searchValue = $(\"#txtbox\").val().toLowerCase();\r\n");
      out.write("\t\t     \tif(searchValue!=null&&searchValue!=\"\")\r\n");
      out.write("\t\t     \t\t{\r\n");
      out.write("\t\t     \t\t $(\".search\").each(function(){\r\n");
      out.write("\t\t    \t         var title = $(this).attr('s-title'); \r\n");
      out.write("\t\t    \t         title = title.toLowerCase();\r\n");
      out.write("\t\t    \t         var check = title.search(searchValue);\r\n");
      out.write("\t\t    \t         if(check==-1)\r\n");
      out.write("\t\t    \t         {\r\n");
      out.write("\t\t    \t          $(this).hide();\r\n");
      out.write("\t\t    \t         }\r\n");
      out.write("\t\t    \t        });\r\n");
      out.write("\t\t     \t\t}\r\n");
      out.write("\t\t     \telse{\r\n");
      out.write("\t\t       \r\n");
      out.write("\t\t        $(\".search\").each(function(){\r\n");
      out.write("\t\t   \t         \r\n");
      out.write("\t\t   \t          $(this).show();\r\n");
      out.write("\t\t   \t         \r\n");
      out.write("\t\t   \t        });\r\n");
      out.write("\t\t     \t}\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
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
      out.write("function searchLocation(id, myArray){\r\n");
      out.write("    for (var i=0; i < myArray.length; i++) {\r\n");
      out.write("        if (myArray[i].id === id) {\r\n");
      out.write("            return myArray[i].name;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function searchDriver(id, myArray){\r\n");
      out.write("    for (var i=0; i < myArray.length; i++) {\r\n");
      out.write("        if (myArray[i].id === id) {\r\n");
      out.write("            return myArray[i].name;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function searchBus(id, myArray){\r\n");
      out.write("    for (var i=0; i < myArray.length; i++) {\r\n");
      out.write("        if (myArray[i].id === id) {\r\n");
      out.write("            return myArray[i].model;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("deleteSchedule=function(s_id)\r\n");
      out.write("{\r\n");
      out.write("swal({\r\n");
      out.write("    title: \"Do you want to delete this schedule?\",\r\n");
      out.write("    text: \"Make sure there is no booking in this schedule.\",\r\n");
      out.write("    type: \"warning\",\r\n");
      out.write("    showCancelButton: true,\r\n");
      out.write("    confirmButtonColor: \"#E71D36\",\r\n");
      out.write("    confirmButtonText: \"Delete\",\r\n");
      out.write("    cancelButtonText: \"Cancel\",\r\n");
      out.write("    closeOnConfirm: false,\r\n");
      out.write("    closeOnCancel: true\r\n");
      out.write("  },\r\n");
      out.write("    function (isConfirm) {\r\n");
      out.write("      if (isConfirm) {\r\n");
      out.write("    \t  $.ajax({\r\n");
      out.write("    \t\t\turl:'deleteSchedule?id='+s_id,\r\n");
      out.write("    \t\t\ttype:'GET',\r\n");
      out.write("    \t\t\tsuccess: function(response){\r\n");
      out.write("    \t\t\t\tif(response.status==\"1\")\r\n");
      out.write("    \t  \t      {\r\n");
      out.write("    \t  \t      setTimeout(function() {\r\n");
      out.write("    \t  \t             swal({\r\n");
      out.write("    \t  \t                 title: \"Done!\",\r\n");
      out.write("    \t  \t                 text: response.message,\r\n");
      out.write("    \t  \t                 type: \"success\"\r\n");
      out.write("    \t  \t             }, function() {\r\n");
      out.write("    \t  \t            \twindow.location.reload();\r\n");
      out.write("    \t  \t             });\r\n");
      out.write("    \t  \t         }, 10);\r\n");
      out.write("\r\n");
      out.write("    \t  \t      }\r\n");
      out.write("\r\n");
      out.write("    \t  \t          else\r\n");
      out.write("    \t  \t           {\r\n");
      out.write("    \t  \t           swal(\"Oops!\",response.message, \"error\")\r\n");
      out.write("\r\n");
      out.write("    \t  \t           } \t\t\r\n");
      out.write("    \t\t\t},\r\n");
      out.write("    \t\t\terror: function(err){\r\n");
      out.write("    \t\t\tswal(\"Oops!\", \"Cannot get all buses data\", \"error\")\r\n");
      out.write("    \t\t\tconsole.log(JSON.stringify(err));\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t});\r\n");
      out.write("      } \r\n");
      out.write("    });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>");
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
