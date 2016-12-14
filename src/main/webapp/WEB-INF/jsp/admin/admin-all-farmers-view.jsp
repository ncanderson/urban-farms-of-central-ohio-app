<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<title>Admin Add User</title>

	
	<div>
		<c:forEach var="user" items="${allFarmers}">
						
				<div><h3>${user.firstName} ${user.lastName}</h3></div>
				<div><h3>${user.email}</h3></div>
				<div><h3>${user.active}</h3></div>
				<c:url var="userDetails" value="admin-edit-farmer-view?userID=${user.userID}" />
				<div><a href=${userDetails }>Edit Farmer Details</a></div>
			
		</c:forEach>  			     
	</div>
	
	<c:url var="addFarmer" value="admin-add-new-farmer"/>
	<div><a href=${addFarmer }>Add New Farmer</a></div>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />