<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Employees Login</title>
	</head>		

	<body>
	
		<h1><strong>Employees Login</strong></h1>
						
		<c:url value="/loginProcessingUrl" var="login"/>
		
		 <c:if test="${param.error != null}">
			<p>Bad username/password</p>
		</c:if>
		
		<form:form action="${login}" method="post">
			<label>Username:</label> <input type="text" name="username" />
			<label>Password:</label> <input type="text" name="password" />
			<input type="submit"/>
		</form:form>
<%--		<security:authorize access="isAuthenticated()">--%>
<%--			authenticated as <security:authentication property="principal.username" />--%>
<%--		</security:authorize>--%>
	</body>
</html>