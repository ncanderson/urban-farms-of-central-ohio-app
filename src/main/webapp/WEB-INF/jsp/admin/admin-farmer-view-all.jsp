<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<c:url var="addFarmer" value="admin-farmer-new"/>
<p class="text-center"><a href="${addFarmer}" type="button" class="btn btn-primary wide-button">Add New Farmer</a></p>

<div>
	<c:forEach var="user" items="${allFarmers}">
		<div class="col-xs-12 col-md-4 highlight-box">
			<h3>${user.firstName} ${user.lastName}</h3>
			<h3>${user.email}</h3>
			<c:choose>
				<c:when test="${user.isActive()}">
					<h3><em>Active User</em></h3>
				</c:when>
				<c:otherwise>
					<h3><em>Inactive User</em></h3>
				</c:otherwise>
			</c:choose>
			<c:url var="userDetails" value="admin-farmer-edit?userId=${user.userId}" />
			<a href="${userDetails}" type="button" class="btn btn-info">Edit Farmer Details</a>
		</div>
	</c:forEach>  			     
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />