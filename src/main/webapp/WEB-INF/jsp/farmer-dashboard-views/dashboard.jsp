<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="col-xs-12 col-md-3">
	<div class="menu-header">
		<h3>Menu</h3>
	</div>
	
	<div class="navbar" >
		<ul class="nav navbar-nav col-xs-12" id="menu-items">
			<li><a href="enterInventory">Create New Order List</a></li>
			<li><a href="#">View Pending Orders</a></li>
			<li><a href="#">View Past Orders</a></li>
			<li><a href="#">Update Customer Information</a></li>
		</ul>
	</div>
</div>

<div class="col-xs-12 col-md-9" id="content">
	<div class="dashboard-item">
		<h3>View All pending orders</h3>
	</div>
	
	<div class="dashboard-item">
		<h3>View past orders</h3>
	</div>
	
	<div class="dashboard-item">
		<h3>Update Customer Information</h3>
	</div>
</div>
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />