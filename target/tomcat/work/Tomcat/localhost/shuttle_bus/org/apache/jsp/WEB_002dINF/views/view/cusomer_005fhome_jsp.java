/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-15 06:40:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cusomer_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005furl_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005furl_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005furl_0026_005fvar_005fvalue_005fnobody.release();
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n");
      out.write("  <title>KIT Admin</title>\n");
      out.write("  <meta name=\"_csrf\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("    <!-- default header name is X-CSRF-TOKEN -->\n");
      out.write("    <meta name=\"_csrf_header\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.headerName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("      \n");
      out.write("  <!-- CSS  -->\n");
      out.write("  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css\">\n");
      out.write("  ");
      if (_jspx_meth_spring_005furl_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custom_booking}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" rel=\"stylesheet\"/>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("  <!--  Scripts  -->\n");
      out.write("  <script src=\"https://momentjs.com/downloads/moment.js\"></script>\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>  \n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js\"></script> \n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js\"></script>\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js\"></script>\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/flatpickr\"></script>\n");
      out.write("  ");
      if (_jspx_meth_spring_005furl_005f1(_jspx_page_context))
        return;
      out.write("\t\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer_bookingjs}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("  <style type=\"text/css\">\n");
      out.write("\t.input-field {\n");
      out.write("\t    margin-top: 0rem;\n");
      out.write("\t}\n");
      out.write("\th5 {\n");
      out.write("\t    font-size: 1.64rem;\n");
      out.write("\t    line-height: 110%;\n");
      out.write("\t    margin: 2.5rem 0 1.5rem 0;\n");
      out.write("\t}\n");
      out.write("\t#book_now{\n");
      out.write("\t    width: 100%;\n");
      out.write("   \t\theight: 100%;\n");
      out.write("\t}\n");
      out.write("\t@media only screen and (min-width: 993px){\n");
      out.write("\t.container {\n");
      out.write("\t\t    width: 60%;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\tnav .brand-logo {\n");
      out.write("    \tleft: 15%;\n");
      out.write("    }\t\n");
      out.write("    .btn , .btn:hover, .btn-large:hover, .btn:focus, .btn-large:focus, .btn-floating:focus{\n");
      out.write("\t    background-color: #ee6e73;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.custom_link{\n");
      out.write("\t\tfont-size: 9px;\n");
      out.write("\t\tcolor:#64B5F6;\n");
      out.write("\t}\n");
      out.write("\t#departure_date{\n");
      out.write("\t\t    margin: 0 0 2px 0!important;\n");
      out.write("\t}\n");
      out.write("\t.modal-content .input-field .dropdown-content{\n");
      out.write("\t    max-height: 180px!important;\n");
      out.write("\t}\n");
      out.write("\t#source_loc_id-error,#new_source_pickup_name-error,#new_dropoff_name-error,#select_dest_id-error\n");
      out.write("\t,#source_name-error,#destination_name-error,#departure_time-error,#departure_date-error,#number_of_seat-error{\n");
      out.write("\t\tcolor:red;\n");
      out.write("\t}\n");
      out.write("\t.select-wrapper span.caret {\n");
      out.write("\t    margin: 15px 0!important;\n");
      out.write("    }\n");
      out.write("    .modal-content .input-field .select-wrapper input.select-dropdown {\n");
      out.write("\t    margin: 0!important;\n");
      out.write("\t}\n");
      out.write("    .confirm_success{\n");
      out.write("    \tcolor:white;\n");
      out.write("    \tbackground-color: green;\n");
      out.write("    }\n");
      out.write("    .confirm_error{\n");
      out.write("    \tcolor:white;\n");
      out.write("    \tbackground-color: red;\n");
      out.write("    }\n");
      out.write("    #confirm{\n");
      out.write("    \toverflow-y: visible;\n");
      out.write("    \t width: 50%;\n");
      out.write("    }\n");
      out.write("\t#confirm_booking_request,#cancel_confirm_model{\n");
      out.write("\t\twidth: 300px;\n");
      out.write("\t}\n");
      out.write("\t.content_confirm{\n");
      out.write("\t\tpadding: 0px!important;\n");
      out.write("\t}\n");
      out.write("\t.confirm_booking_request_model{\n");
      out.write("\t\twidth:100%\n");
      out.write("\t}\n");
      out.write("\t.cancel_booking_modal{\n");
      out.write("\t\twidth:100%;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  \n");
      out.write("<!-- Dropdown Structure -->\n");
      out.write("<ul id=\"dropdown1\" class=\"dropdown-content\">\n");
      out.write("  <li class=\"booking_history1 hide-on-med-and-up\"><a href=\"booking_history\">History</a></li>\n");
      out.write("  <li><a href=\"#!\">Profile</a></li>\n");
      out.write("  <li><a onclick=\"formSubmit()\">Logout</a></li>\n");
      out.write("</ul>\n");
      out.write("<nav>\n");
      out.write("  <div class=\"nav-wrapper\">\n");
      out.write("    <a href=\"customer_home\" class=\"brand-logo\">Logo</a>\n");
      out.write("      <ul class=\"right\">\n");
      out.write("      <li><a class=\"dropdown-button\" href=\"#!\" data-activates=\"dropdown1\"><span id=\"fullname\"></span><i class=\"material-icons right\">arrow_drop_down</i></a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("<form id=\"form_book_now\" class=\"col s12\">\n");
      out.write("\t<div class=\"row container\">\n");
      out.write("\t\t<h5 class=\"center\">Shuttle Bus Booking</h5>\n");
      out.write("\t\t<div class=\"input-field col s12 m6\">\n");
      out.write("\t\t    <select id=\"source_name\" name=\"source_name\" required></select>\n");
      out.write("\t\t    <label>Source</label>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t    <div class=\"input-field col s12 m6\">\n");
      out.write("\t\t    <select id=\"destination_name\" name=\"destination_name\" required>\n");
      out.write("\t\t    </select>\n");
      out.write("\t\t    <label>Destination</label>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t  <div class=\"input-field col s12 m6\">\n");
      out.write("\t\t    <select id=\"departure_time\" name=\"departure_time\" required>\n");
      out.write("\t\t    </select>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t    <div class=\"input-field col s12 m6\">\n");
      out.write("\t\t    \t<div class=\"input-field s6 flatpickr\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"Select Date\" id=\"departure_date\" name=\"departure_date\" data-input class=\"input flatpickr-input active\" required> \t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<a id=\"custom_location\" class=\"custom_link right\" href=\"request_booking\"><span style=\"color:red;\">*Cannot find date or time you want?</span></a>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t   <div class=\"input-field col s12\">\n");
      out.write("\t\t       <input id=\"number_of_seat\" name=\"number_of_seat\" type=\"text\" class=\"validate\" required> \n");
      out.write("\t\t       <label for=\"last_name\">Number of Ticket</label>\n");
      out.write("\t\t  </div> \n");
      out.write("\t\t  <div class=\"input-field col s12\">\n");
      out.write("\t\t    <button id=\"book_now\" class=\"btn\" type=\"submit\" name=\"action\">Book Now</button>\n");
      out.write("\t\t  </div>  \n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<div id=\"get_booking_request\" class=\"row container\"></div> \n");
      out.write("<div id=\"all_booking_history\" class=\"row container hide-on-small-only\"></div> \n");
      out.write("<!-- Ask for confirm booking request -->\n");
      out.write("<div id=\"cancel_confirm_model\" class=\"modal\">\n");
      out.write("    <div class=\"modal-content container center\">\n");
      out.write("\t    <h5 class=\"center\">Confirm</h5>\n");
      out.write("\t\t<p> Do you want to cancel your shuttle bus booking now?\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"modal-footer\">\n");
      out.write("\t\t<span id=\"get_req_book_footer\"></span>\n");
      out.write("\t    <a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Cancel</a>\n");
      out.write("\t </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Confirm Modal -->\n");
      out.write("<div id=\"confirm\" class=\"modal\">\n");
      out.write("    <div class=\"modal-content center content_confirm\">\n");
      out.write("      <p id=\"confirm_text\"></p>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!-- Ask for confirm booking request -->\n");
      out.write("<div id=\"confirm_booking_request\" class=\"modal\">\n");
      out.write("    <div class=\"modal-content container center\">\n");
      out.write("\t    <h5 class=\"center\">Confirm</h5>\n");
      out.write("\t\t<p> Do you want to book ticket now?\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"modal-footer\">\n");
      out.write("\t\t<span id=\"get_req_book_footer\"></span>\n");
      out.write("\t    <a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Cancel</a>\n");
      out.write("\t </div>\n");
      out.write("</div>\n");
      out.write("<!-- Custom Source Pick Up Location -->\n");
      out.write("<div id=\"coustom_source_pl\" class=\"modal\">\n");
      out.write("\t<form id=\"form_coustom_source_pl\">\n");
      out.write("\t    <div class=\"modal-content container\">\n");
      out.write("\t      <h5 class=\"center\">Add Your Custom Pick Up location</h5>\n");
      out.write("\t      <div class=\"input-field col s12 m6\">\n");
      out.write("\t\t\t    <select id=\"source_loc_id\" name=\"source_loc_id\" required></select>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t  <div class=\"input-field col s6\">\n");
      out.write("\t          <input placeholder=\"Where you want us to pick up?\" id=\"new_source_pickup_name\" name=\"new_source_pickup_name\" type=\"text\" class=\"validate\">\n");
      out.write("\t        </div>\n");
      out.write("\t    </div>\n");
      out.write("\t    <div class=\"modal-footer\">\n");
      out.write("\t    \t<button type=\"submit\" class=\"modal-action waves-effect waves-green btn-flat\">Confirm</button>\n");
      out.write("\t      \t<a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Cancel</a>\n");
      out.write("\t    </div>\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("<!-- Custom Drop-Off Location -->\n");
      out.write("<div id=\"coustom_dropoff\" class=\"modal\">\n");
      out.write("\t<form id=\"form_coustom_dropoff\">\n");
      out.write("\t    <div class=\"modal-content container\">\n");
      out.write("\t      <h5 class=\"center\">Add Your Custom drop-off location</h5>\n");
      out.write("\t      <div class=\"input-field col s12 m6\">\n");
      out.write("\t\t\t    <select id=\"select_dest_id\" name=\"select_dest_id\" required></select>\n");
      out.write("\t\t  </div>\n");
      out.write("\t\t  <div class=\"input-field col s6\">\n");
      out.write("\t          <input placeholder=\"Where you want us to drop-off?\" id=\"new_dropoff_name\" name=\"new_dropoff_name\" type=\"text\" class=\"validate\">\n");
      out.write("\t        </div>\n");
      out.write("\t    </div>\n");
      out.write("\t    <div class=\"modal-footer\">\n");
      out.write("\t    \t<button type=\"submit\" class=\"modal-action waves-effect waves-green btn-flat\">Confirm</button>\n");
      out.write("\t      \t<a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Cancel</a>\n");
      out.write("\t    </div>\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\t<form action=\"logout\" method=\"post\" id=\"logoutForm\">\n");
      out.write("\t\t<input type=\"hidden\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\n");
      out.write("\t</form>\n");
      out.write("  </body>\n");
      out.write("  \n");
      out.write("  <script>\n");
      out.write("\t\tfunction formSubmit() {\n");
      out.write("\t\t\tdocument.getElementById(\"logoutForm\").submit();\n");
      out.write("\t\t}\n");
      out.write("</script>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_spring_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f0 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvar_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005furl_005f0.setParent(null);
    // /WEB-INF/views/view/cusomer_home.jsp(16,2) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f0.setValue("/resources/css/custom_booking.css");
    // /WEB-INF/views/view/cusomer_home.jsp(16,2) name = var type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f0.setVar("custom_booking");
    int[] _jspx_push_body_count_spring_005furl_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005furl_005f0 = _jspx_th_spring_005furl_005f0.doStartTag();
      if (_jspx_th_spring_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005furl_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005furl_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005furl_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:url
    org.springframework.web.servlet.tags.UrlTag _jspx_th_spring_005furl_005f1 = (org.springframework.web.servlet.tags.UrlTag) _005fjspx_005ftagPool_005fspring_005furl_0026_005fvar_005fvalue_005fnobody.get(org.springframework.web.servlet.tags.UrlTag.class);
    _jspx_th_spring_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_spring_005furl_005f1.setParent(null);
    // /WEB-INF/views/view/cusomer_home.jsp(27,2) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f1.setValue("/resources/js/customer_booking.js");
    // /WEB-INF/views/view/cusomer_home.jsp(27,2) name = var type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005furl_005f1.setVar("customer_bookingjs");
    int[] _jspx_push_body_count_spring_005furl_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005furl_005f1 = _jspx_th_spring_005furl_005f1.doStartTag();
      if (_jspx_th_spring_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005furl_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005furl_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005furl_005f1.doFinally();
      _005fjspx_005ftagPool_005fspring_005furl_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_spring_005furl_005f1);
    }
    return false;
  }
}
