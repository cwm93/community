<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%
	final String queryString = request.getQueryString();
	final String url = request.getContextPath() + "/login" + (queryString != null ? "?" + queryString : "");
	response.sendRedirect(response.encodeRedirectURL(url));
%>