<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<title>Admin main</title>

	<div class="jumbotron">
	
	<h2>Admin Options</h2>
		<div class="span2" >
			<div>
				<c:url var="ViewItems" value="/admin/admin-items-view" />
				<a href="${ViewItems}" type="button" class="btn btn-primary wide-button">Edit Items</a>
			</div>
			<br>
			<div>
				<c:url var="ViewFarmers" value="/admin/admin-all-farmers-view" />
				<a href="${ViewFarmers}" type="button" class="btn btn-primary wide-button">Edit Farmer Users</a>
			</div>
			<br>
			<div>
				<c:url var="ViewBuyers" value="/admin/admin-all-buyers-view" />
				<a href="${ViewBuyers}" type="button" class="btn btn-primary wide-button">Edit Buyer Users</a>
			</div>
			<br>
			<div>
				<c:url var="ViewCompanies" value="/admin/admin-all-companies-view" />
				<a href="${ViewCompanies }" type="button" class="btn btn-primary wide-button">Edit Companies</a>
			</div>
			<br>
			<div>
				<c:url var="ViewBanners" value="/admin/admin-all-banners-view" />
				<a href="${ViewBanners}" type="button" class="btn btn-primary wide-button">Edit Banner Notification</a>
			</div>
		</div>
		
	</div>
		














<c:import url="/WEB-INF/jsp/common/footer.jsp" />
