<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>Questions</title>
		<link href="<c:url value='/resources/bootstrap.css' />" rel="stylesheet" type="text/css" media="all" />
		<link href="<c:url value='/resources/main.css' />" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>
		<div class="topbar">
	      <div class="fill">
	        <div class="container">
	          <a class="brand" href="<c:url value="/" />">Questions</a>
	          <ul class="nav">
	            <li class="active"><a href="<c:url value="/" />">Home</a></li>
	            <li><a href="<c:url value="/questions" />">Questions</a></li>
	            <li><a href="<c:url value="/questions/new" />">New</a></li>
	          </ul>
	          <security:authorize access="isAnonymous()">
	          <form action="<c:url value='/j_spring_security_check'/>" method="post" class="pull-right">
	            <input name="j_username" class="input-small" type="text" placeholder="Username"/>
	            <input name="j_password" class="input-small" type="password" placeholder="Password"/>
	            <button class="btn" type="submit">Sign in</button>
	          </form>
			  </security:authorize>
			  <security:authorize access="isAuthenticated()">
	          	<p class="pull-right">
          			<security:authentication property="principal.username"/> (<a href="<c:url value='/j_spring_security_logout' />">Logout</a>)
				</p>
	          </security:authorize>
	        </div>
	      </div>
	    </div>
		<div class="container">
			<div class="content">
				
