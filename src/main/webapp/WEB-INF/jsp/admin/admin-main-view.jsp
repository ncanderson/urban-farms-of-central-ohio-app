<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="jumbotron text-center">

<h2>Admin Options</h2>
	<div class="span2" >
		<div>
			<c:url var="viewItems" value="/admin/admin-item-view" />
			<a href="${viewItems}" type="button" class="btn btn-primary wide-button">Edit Items</a>
		</div>
		<br>
		<div>
			<c:url var="viewFarmers" value="/admin/admin-farmer-view-all" />
			<a href="${viewFarmers}" type="button" class="btn btn-primary wide-button">Edit Farmer Users</a>
		</div>
		<br>
		<div>
			<c:url var="viewBuyers" value="/admin/admin-buyer-users-all" />
			<a href="${viewBuyers}" type="button" class="btn btn-primary wide-button">Edit Buyer Users</a>
		</div>
		<br>
		<div>
			<c:url var="viewCompanies" value="/admin/admin-companies-all" />
			<a href="${viewCompanies}" type="button" class="btn btn-primary wide-button">Edit Companies</a>
		</div>
		<br>
		<div>
			<c:url var="viewBanners" value="/admin/admin-banners-all" />
			<a href="${viewBanners}" type="button" class="btn btn-primary wide-button">Edit Banner Notification</a>
		</div>
	</div>
	
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
