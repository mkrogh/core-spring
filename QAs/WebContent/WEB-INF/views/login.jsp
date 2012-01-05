<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:import url="/WEB-INF/views/layout/top.jsp" />


<div class="page-header">
<h1>Login</h1>
</div>

<c:if test="${!empty param.login_error}">
	<h2> <font color="red"> Incorrect username and/or password </font></h2>
</c:if>


<form action="<c:url value='/j_spring_security_check'/>" method="post">
	<table>
		<tr>
			<td>Username:</td>
			<td><input type="text" name="j_username"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="j_password"/></td>
		</tr>
		<tr>
			<td colspan='2'><input name="submit" type="submit" value="Login"/></td>
		</tr>
	</table>
</form>

<c:import url="/WEB-INF/views/layout/bottom.jsp" />
