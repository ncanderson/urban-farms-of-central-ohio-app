<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<title>Admin main</title>
</head>
<body>

<ul>
	<c:url var="EditItems" value="/admin/admin-items-view" />
	<li><a href="${EditItems}">Edit Items</a></li>
	
	<c:url var="AddUser" value="/admin/admin-add-user" />
	<li><a href="${AddUser}">Add User</a></li>
	
	<c:url var="AproveBuyer" value="/admin/admin-approve-buyer" />
	<li><a href="${AproveBuyer}">Approve Buyers</a></li>
	
</ul>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
