<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

	<div>
		<c:forEach var="buyerUser" items="${allBuyers}">
						
				<div><h3>${buyerUser.firstName} ${user.lastName}</h3></div>
				<div><h3>${buyerUser.email}</h3></div>
				<div><h3>${buyerUser.active}</h3></div>
				<div><h3>${buyerUser.companyName}</h3></div>
				<c:url var="buyerUserDetails" value="admin-edit-buyer-user?userID=${buyerUser.userID}" />
				<div><a href=${buyerUserDetails }>Edit Buyer User Details</a></div>
			
		</c:forEach>  			     
	</div>
	
	<c:url var="addBuyerUser" value="admin-add-new-buyer-user"/>
	<div><a href=${addBuyerUser }>Add New Buyer</a></div>
	























<c:import url="/WEB-INF/jsp/common/footer.jsp" />