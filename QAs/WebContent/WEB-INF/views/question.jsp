<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:import url="/WEB-INF/views/layout/top.jsp" />

<div class="page-header">
<h1>${question}</h1>
</div>

<security:authorize access="hasRole('ROLE_EDITOR')">
<p>
	<a href="<c:url value='/questions/${question.id}/edit'/>">Edit</a>
</p>

<c:url var="form_url" value="/questions/${question.id}/destroy"/>
<form:form commandName="question" action="${form_url}">
		<input type="submit" value="Destroy"/>
</form:form>
</security:authorize>

<c:import url="/WEB-INF/views/layout/bottom.jsp" />