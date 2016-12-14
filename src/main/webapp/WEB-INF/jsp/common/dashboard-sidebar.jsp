<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-xs-12 col-md-3" id="dashboard-sidebar">

	<div class="menu-header">
		<h3>Menu</h3>
	</div>

	<div class="navbar">
		<ul class="nav navbar-nav col-xs-12 col-lg-1" id="farmer-menu-items">
		
			<c:if test="${requestScope['javax.servlet.forward.request_uri'] != '/capstone/farmer-dashboard-views/dashboard'}">
				<c:url var="farmerDashboard" value="/farmer-dashboard-views/dashboard" />
				<li><a href="${farmerDashboard}">Back to Dashboard</a></li>
			</c:if>
			<c:if test="${requestScope['javax.servlet.forward.request_uri'] != '/capstone/farmer-dashboard-views/enterInventory'}">
				<c:url var="enterInventory" value="/farmer-dashboard-views/enterInventory"/>
				<li><a href="${enterInventory}">Add New Harvest Item</a></li>			
			</c:if>
			
			<li><a href="view-pending-orders">View Pending Orders</a></li>
			<li><a href="view-past-orders">View Past Orders</a></li>
			<li><a href="update-user-info">View Customer Information</a></li>
		</ul>
		
		<c:if test="${currentUser.isAdmin()}">
			<h3>Admin Options</h3>
			
			<div class="navbar">
				<ul class="nav navbar-nav col-xs-12 col-lg-1" id="admin-menu-items">
					<c:url var="ViewItems" value="/admin/admin-item-view" />
					<li><a href="${ViewItems}">Edit Items</a></li>
					<c:url var="ViewFarmers" value="/admin/admin-farmer-view-all" />
					<li><a href="${ViewFarmers}">Edit Farmer Users</a></li>
					<c:url var="ViewBuyers" value="/admin/admin-buyer-users-all" />
					<li><a href="${ViewBuyers}">Edit Buyers Users</a></li>
					<c:url var="ViewCompanies" value="/admin/admin-companies-all" />
					<li><a href="${ViewCompanies}">Edit Companies</a></li>
					<c:url var="ViewBanners" value="/admin/admin-banners-all" />
					<li><a href="${ViewBanners}">Edit Banner Notifications</a></li>
				</ul>
			</div>
		</c:if>
	</div>

</div>