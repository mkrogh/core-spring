<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/layout/top.jsp" />

<div class="page-header">	
	<h1>Questions <small>and answers..</small></h1>
</div>		

<c:forEach var="question" items="${questions}" varStatus="status">
	<c:if test="${status.first}"><ul></c:if>
	<c:url value="/questions/${question.id}" var="url" />
	<li><a href='${url}'">${question}?</a></li>
	<c:if test="${status.last}"></ul></c:if>
</c:forEach>

<c:import url="/WEB-INF/views/layout/bottom.jsp" />