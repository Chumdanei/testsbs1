/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-22 17:07:09 UTC
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\r\n");
      out.write("  <title>KIT Admin</title>\r\n");
      out.write("  <meta name=\"_csrf\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("    <!-- default header name is X-CSRF-TOKEN -->\r\n");
      out.write("    <meta name=\"_csrf_header\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.headerName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("      \r\n");
      out.write("  <!-- CSS  -->\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css\">\r\n");
      out.write("  ");
      if (_jspx_meth_spring_005furl_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custom_booking}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" rel=\"stylesheet\"/>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <!--  Scripts  -->\r\n");
      out.write("  <script src=\"https://momentjs.com/downloads/moment.js\"></script>\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>  \r\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/flatpickr\"></script>\r\n");
      out.write("  ");
      if (_jspx_meth_spring_005furl_005f1(_jspx_page_context))
        return;
      out.write("\t\r\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer_bookingjs}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("  <style type=\"text/css\">\r\n");
      out.write("\t.input-field {\r\n");
      out.write("\t    margin-top: 0rem;\r\n");
      out.write("\t}\r\n");
      out.write("\th5 {\r\n");
      out.write("\t    font-size: 1.64rem;\r\n");
      out.write("\t    line-height: 110%;\r\n");
      out.write("\t    margin: 2.5rem 0 1.5rem 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t#book_now{\r\n");
      out.write("\t    width: 100%;\r\n");
      out.write("   \t\theight: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\t@media only screen and (min-width: 993px){\r\n");
      out.write("\t.container {\r\n");
      out.write("\t\t    width: 60%;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tnav .brand-logo {\r\n");
      out.write("    \tleft: 15%;\r\n");
      out.write("    }\t\r\n");
      out.write("    .btn , .btn:hover, .btn-large:hover, .btn:focus, .btn-large:focus, .btn-floating:focus{\r\n");
      out.write("\t    background-color: #ee6e73;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.custom_link{\r\n");
      out.write("\t\tfont-size: 9px;\r\n");
      out.write("\t\tcolor:#64B5F6;\r\n");
      out.write("\t}\r\n");
      out.write("\t#departure_date{\r\n");
      out.write("\t\t    margin: 0 0 2px 0!important;\r\n");
      out.write("\t}\r\n");
      out.write("\t.modal-content .input-field .dropdown-content{\r\n");
      out.write("\t    max-height: 180px!important;\r\n");
      out.write("\t}\r\n");
      out.write("\t#source_loc_id-error,#new_source_pickup_name-error,#new_dropoff_name-error,#select_dest_id-error\r\n");
      out.write("\t,#source_name-error,#destination_name-error,#departure_time-error,#departure_date-error,#number_of_seat-error{\r\n");
      out.write("\t\tcolor:red;\r\n");
      out.write("\t}\r\n");
      out.write("\t#source_name-error,#destination_name-error,#departure_time-error{\r\n");
      out.write("\t\tcolor:red;\r\n");
      out.write("\t\t    margin-top: -30px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.select-wrapper span.caret {\r\n");
      out.write("\t    margin: 15px 0!important;\r\n");
      out.write("    }\r\n");
      out.write("    .modal-content .input-field .select-wrapper input.select-dropdown {\r\n");
      out.write("\t    margin: 0!important;\r\n");
      out.write("\t}\r\n");
      out.write("    .confirm_success{\r\n");
      out.write("    \tcolor:white;\r\n");
      out.write("    \tbackground-color: green;\r\n");
      out.write("    }\r\n");
      out.write("    .confirm_error{\r\n");
      out.write("    \tcolor:white;\r\n");
      out.write("    \tbackground-color: red;\r\n");
      out.write("    }\r\n");
      out.write("    #confirm{\r\n");
      out.write("    \toverflow-y: visible;\r\n");
      out.write("    \t width: 50%;\r\n");
      out.write("    }\r\n");
      out.write("\t#confirm_booking_request,#cancel_confirm_model{\r\n");
      out.write("\t\twidth: 300px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.content_confirm{\r\n");
      out.write("\t\tpadding: 0px!important;\r\n");
      out.write("\t}\r\n");
      out.write("\t.confirm_booking_request_model{\r\n");
      out.write("\t\twidth:100%\r\n");
      out.write("\t}\r\n");
      out.write("\t.cancel_booking_modal{\r\n");
      out.write("\t\twidth:100%;\r\n");
      out.write("\t}\r\n");
      out.write("\t.select-wrapper input.select-dropdown{\r\n");
      out.write("\t\t-webkit-user-select:none;\r\n");
      out.write("\t\t-moz-user-select:none;\r\n");
      out.write("\t\t-ms-user-select:none;\r\n");
      out.write("\t\t-o-user-select:none; // latest Opera versions support -webkit-\r\n");
      out.write("\t\tuser-select:none;\r\n");
      out.write("\t\t}\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  \r\n");
      out.write("<!-- Dropdown Structure -->\r\n");
      out.write("<ul id=\"dropdown1\" class=\"dropdown-content\">\r\n");
      out.write("  <li class=\"booking_history1 hide-on-med-and-up\"><a href=\"booking_history\">History</a></li>\r\n");
      out.write("  <li><a href=\"#!\">Profile</a></li>\r\n");
      out.write("  <li><a onclick=\"formSubmit()\">Logout</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("<nav>\r\n");
      out.write("  <div class=\"nav-wrapper\">\r\n");
      out.write("    <a href=\"customer_home\" class=\"brand-logo\">Logo</a>\r\n");
      out.write("      <ul class=\"right\">\r\n");
      out.write("      <li><a class=\"dropdown-button\" href=\"#!\" data-activates=\"dropdown1\"><span id=\"fullname\"></span><i class=\"material-icons right\">arrow_drop_down</i></a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<form id=\"form_book_now\" class=\"col s12\">\r\n");
      out.write("\t<div class=\"row container\">\r\n");
      out.write("\t\t<h5 class=\"center\">Shuttle Bus Booking</h5>\r\n");
      out.write("\t\t<div class=\"input-field col s12 m6\">\r\n");
      out.write("\t\t    <select id=\"source_name\" name=\"source_name\" required></select>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t    <div class=\"input-field col s12 m6\">\r\n");
      out.write("\t\t    <select id=\"destination_name\" name=\"destination_name\" required>\r\n");
      out.write("\t\t    <option disabled selected>Destination Location</option>\r\n");
      out.write("\t\t    </select>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"input-field col s12 m6\">\r\n");
      out.write("\t\t    <select id=\"departure_time\" name=\"departure_time\" required>\r\n");
      out.write("\t\t    </select>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t    <div class=\"input-field col s12 m6\">\r\n");
      out.write("\t\t    \t<div class=\"input-field s6 flatpickr\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"Select Departure Date\" id=\"departure_date\" name=\"departure_date\" data-input class=\"input flatpickr-input active\" required> \t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<a id=\"custom_location\" class=\"custom_link right\" href=\"request_booking\"><span style=\"color:red;\">*Cannot find date or time you want?</span></a>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t   <div class=\"input-field col s12\">\r\n");
      out.write("\t\t       <input id=\"number_of_seat\" name=\"number_of_seat\" type=\"text\" class=\"validate\" required> \r\n");
      out.write("\t\t       <label for=\"last_name\">Number of Ticket</label>\r\n");
      out.write("\t\t  </div> \r\n");
      out.write("\t\t  <div class=\"input-field col s12\">\r\n");
      out.write("\t\t    <button id=\"book_now\" class=\"btn\" type=\"submit\" name=\"action\">Book Now</button>\r\n");
      out.write("\t\t  </div>  \r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<div id=\"get_booking_request\" class=\"row container\"></div> \r\n");
      out.write("<div id=\"all_booking_history\" class=\"row container hide-on-small-only\"></div> \r\n");
      out.write("<!-- Ask for confirm booking request -->\r\n");
      out.write("<div id=\"cancel_confirm_model\" class=\"modal\">\r\n");
      out.write("    <div class=\"modal-content container center\">\r\n");
      out.write("\t    <h5 class=\"center\">Confirm</h5>\r\n");
      out.write("\t\t<p> Do you want to cancel your shuttle bus booking now?\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t<!-- <span id=\"get_req_book_footer\"></span> -->\r\n");
      out.write("\t\t<span id=\"get_cancel_booking_footer\"></span>\r\n");
      out.write("\t    <a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Cancel</a>\r\n");
      out.write("\t </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Confirm Modal -->\r\n");
      out.write("<div id=\"confirm\" class=\"modal\">\r\n");
      out.write("    <div class=\"modal-content center content_confirm\">\r\n");
      out.write("      <p id=\"confirm_text\"></p>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Ask for confirm booking request -->\r\n");
      out.write("<div id=\"confirm_booking_request\" class=\"modal\">\r\n");
      out.write("    <div class=\"modal-content container center\">\r\n");
      out.write("\t    <h5 class=\"center\">Confirm</h5>\r\n");
      out.write("\t\t<p> Do you want to book ticket now?\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t<span id=\"get_req_book_footer\"></span>\r\n");
      out.write("\t    <a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Cancel</a>\r\n");
      out.write("\t </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Ask for phone number while booking -->\r\n");
      out.write("<div id=\"confirm_phone_number_modal\" class=\"modal\">\r\n");
      out.write("\t<div class=\"modal-content container\">\r\n");
      out.write("\t   <h5 class=\"center\">Please tell us your phone number in Cambodia!</h5>\r\n");
      out.write("\t   <div class=\"input-field col s6\">\r\n");
      out.write("\t       <input placeholder=\"Enter your phone number for ctacting between you and driver!\" id=\"user_confirm_phone_number\" name=\"user_confirm_phone_number\" type=\"text\" class=\"validate\">\r\n");
      out.write("\t   </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"modal-footer\">\r\n");
      out.write("\t    <a id=\"confirm_phone_number_btn\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Confirm</a>\r\n");
      out.write("\t    <a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Skip</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Custom Source Pick Up Location -->\r\n");
      out.write("<div id=\"coustom_source_pl\" class=\"modal\">\r\n");
      out.write("\t<form id=\"form_coustom_source_pl\">\r\n");
      out.write("\t    <div class=\"modal-content container\">\r\n");
      out.write("\t      <h5 class=\"center\">Add Your Custom Pick Up location</h5>\r\n");
      out.write("\t      <div class=\"input-field col s12 m6\">\r\n");
      out.write("\t\t\t    <select id=\"source_loc_id\" name=\"source_loc_id\" required></select>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"input-field col s6\">\r\n");
      out.write("\t          <input placeholder=\"Where you want us to pick up?\" id=\"new_source_pickup_name\" name=\"new_source_pickup_name\" type=\"text\" class=\"validate\">\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div class=\"modal-footer\">\r\n");
      out.write("\t    \t<button type=\"submit\" class=\"modal-action waves-effect waves-green btn-flat\">Confirm</button>\r\n");
      out.write("\t      \t<a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Cancel</a>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- Custom Drop-Off Location -->\r\n");
      out.write("<div id=\"coustom_dropoff\" class=\"modal\">\r\n");
      out.write("\t<form id=\"form_coustom_dropoff\">\r\n");
      out.write("\t    <div class=\"modal-content container\">\r\n");
      out.write("\t      <h5 class=\"center\">Add Your Custom drop-off location</h5>\r\n");
      out.write("\t      <div class=\"input-field col s12 m6\">\r\n");
      out.write("\t\t\t    <select id=\"select_dest_id\" name=\"select_dest_id\" required></select>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"input-field col s6\">\r\n");
      out.write("\t          <input placeholder=\"Where you want us to drop-off?\" id=\"new_dropoff_name\" name=\"new_dropoff_name\" type=\"text\" class=\"validate\">\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div class=\"modal-footer\">\r\n");
      out.write("\t    \t<button type=\"submit\" class=\"modal-action waves-effect waves-green btn-flat\">Confirm</button>\r\n");
      out.write("\t      \t<a href=\"#!\" class=\"modal-action modal-close waves-effect waves-green btn-flat\">Cancel</a>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t<form action=\"logout\" method=\"post\" id=\"logoutForm\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.parameterName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_csrf.token}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t</form>\r\n");
      out.write("  </body>\r\n");
      out.write("  \r\n");
      out.write("  <script>\r\n");
      out.write("\t\tfunction formSubmit() {\r\n");
      out.write("\t\t\tdocument.getElementById(\"logoutForm\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("</script>\r\n");
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
