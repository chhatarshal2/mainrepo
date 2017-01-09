<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Spring MVC and List Example</h2>

	<c:if test="${not empty products}">

		<ul>
			<c:forEach var="product" items="${products}">
				<li>${product.name}</li>
				<li><img src=${product.url} alt="img04"></li>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>