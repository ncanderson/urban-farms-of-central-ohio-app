<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<title>Insert title here</title>
</head>
<body>
	<c:url var="checkoutHref" value="/customer-views/current-inventory" />
	<form action="${checkoutHref}" method="POST">
	<ul class="form-flex-outer">
		<li>
			<input type="submit" value="Add Item to Order" />
		</li>
	</ul>
	</form>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />