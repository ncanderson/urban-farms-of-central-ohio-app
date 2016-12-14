<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<c:url var="addNewBuyer" value="admin-buyer-users-all"/>
<p class="text-center"><a href="${addNewBuyers}" type="button" class="btn btn-primary wide-button">Add New Buyer</a></p>

<div>
	<c:forEach var="user" items="${allBuyers}">
		<div class="col-xs-12 col-md-4 highlight-box">
			<h3>${user.buyerUserOrg}</h3>
			<h3>${user.firstName} ${user.lastName}</h3>
			<h3>${user.email}</h3>
			<h3>${user.phoneNumber}</h3>
			<c:choose>
				<c:when test="${user.isActive()}">
					<h3><em>Active User</em></h3>
				</c:when>
				<c:otherwise>
					<h3><em>Inactive User</em></h3>
				</c:otherwise>
			</c:choose>
			<c:url var="userDetails" value="admin-buyer-user-edit?userId=${user.userId}" />
			<a href="${userDetails}" type="button" class="btn btn-info">Edit Buyer Details</a>
		</div>
	</c:forEach>  			     
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
