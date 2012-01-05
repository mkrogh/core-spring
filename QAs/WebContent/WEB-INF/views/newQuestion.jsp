<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="/WEB-INF/views/layout/top.jsp" />
<h1>
	New question:
</h1>

<c:url var="form_url" value="/questions"/>
<form:form commandName="question" action="${form_url}" cssClass="aligned" >
	<form:label path="question">Question:</form:label>
	<form:input path="question"/>
	<form:errors path="question"/>
	<div>
		<input type="submit" value="Create Question"/>
	</div>
</form:form>

<c:import url="/WEB-INF/views/layout/bottom.jsp" />