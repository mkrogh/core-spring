<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/top.jsp" />


<div class="page-header">
<h1>Access Denied</h1>
</div>
<p>Sorry, Access Denied</p>
<p><a href="<c:url value="/" />">Return to Home Page</a> or
<p><a href="<c:url value='/j_spring_security_logout' />">Logout</a></p>

<c:import url="/WEB-INF/views/layout/bottom.jsp" />