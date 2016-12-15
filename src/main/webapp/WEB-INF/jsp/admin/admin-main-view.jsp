<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="jumbotron text-center">

<h2>Admin Options</h2>
	<div class="col-xs-8 col-xs-offset-2 col-md-4 col-md-offset-4" >
		<c:url var="viewItems" value="/admin/admin-item-view" />
		<a href="${viewItems}" type="button" class="btn btn-primary btn-block ">Edit Items</a>
		<br />
		<c:url var="viewFarmers" value="/admin/admin-farmer-view-all" />
		<a href="${viewFarmers}" type="button" class="btn btn-primary btn-block ">Edit Farmer Users</a>
		<br>
		<c:url var="viewBuyers" value="/admin/admin-buyer-users-all" />
		<a href="${viewBuyers}" type="button" class="btn btn-primary btn-block">Edit Buyer Users</a>
		<br>
		<c:url var="viewCompanies" value="/admin/admin-companies-all" />
		<a href="${viewCompanies}" type="button" class="btn btn-primary btn-block">Edit Companies</a>
		<br>
		<c:url var="viewBanners" value="/admin/admin-banners-all" />
		<a href="${viewBanners}" type="button" class="btn btn-primary btn-block">Edit Banner Notification</a>
	</div>
	
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
