<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.springframework.validation.BindingResult" %>
<%@ page import="org.example.model.User" %>

<%
  // Retrieve BindingResult and user object from session or request attributes
  BindingResult result = (BindingResult) request.getAttribute("org.springframework.validation.BindingResult.user");
  User user = (User) request.getAttribute("user");

  if (result != null && result.hasErrors()) {
    out.println("<div style='color:red;'>");
    out.println("<h4>Please correct the following errors:</h4>");
    for (var error : result.getFieldErrors()) {
      out.println("<div><strong>" + error.getField() + ":</strong> " + error.getDefaultMessage() + "</div>");
    }
    out.println("</div>");
  }
%>
