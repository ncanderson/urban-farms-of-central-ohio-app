<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="col-xs-12 col-md-3">
	<div class="menu-header">
		<h3>Menu</h3>
	</div>

	<div class="navbar" >
		<ul class="nav navbar-nav col-xs-12" id="menu-items">
			<li><a href="enterInventory">Create New Order List</a></li>
			<li>+++++NOT IMPLEMENTED+++++</li>
			<li><a href="view-pending-orders">View Pending Orders</a></li>
			<li><a href="view-past-orders">View Past Orders</a></li>
			<li><a href="update-user-info">View Customer Information</a></li>
			<li>+++++NOT IMPLEMENTED+++++</li>
		</ul>
	</div>
</div>

<div class="col-xs-12 col-md-9" id="content">
	<div class="dashboard-item">
		<h3>Current Order List</h3>
		<c:forEach var="item" items="${itemsList}">
			<div class="Rtable Rtable--4cols Rtable--collapse">
				<div class="Rtable-cell Rtable-cell--head">${item.type}</div>
				<div class="Rtable-cell">${item.imageId}</div>
				<div class="Rtable-cell">${item.variety}</div>
				<div class="Rtable-cell Rtable-cell--foot">${item.price.toString()}</div>
			</div>
		</c:forEach>
	</div>
	
	<div class="dashboard-item">
		<h3>View All pending orders</h3>
		<c:forEach var="pendingInvoice" items="${pendingOrders}">
			<div class="Rtable Rtable--4cols Rtable--collapse">
				<div class="Rtable-cell Rtable-cell--head">${pendingInvoice.invoiceId}</div>
				<div class="Rtable-cell">${pendingInvoice.date}</div>
				<div class="Rtable-cell">${pendingInvoice.saleType}</div>
				<div class="Rtable-cell">${pendingInvoice.buyerName}</div>
				<div class="Rtable-cell">${pendingInvoice.status}</div>
				<div class="Rtable-cell">${pendingInvoice.getTotal()}</div>
				<div class="Rtable-cell">${pendingInvoice.price.toString()}</div>
				<div class="Rtable-cell Rtable-cell--foot">${pendingInvoice.items.size()}</div>
			</div>
		</c:forEach>		
	</div>

	<div class="dashboard-item">
		<h3>View all orders</h3>
		<c:forEach var="invoice" items="${allOrders}">
			<div class="Rtable Rtable--4cols Rtable--collapse">
				<div class="Rtable-cell Rtable-cell--head">${invoice.invoiceId}</div>
				<div class="Rtable-cell">${invoice.date}</div>
				<div class="Rtable-cell">${invoice.saleType}</div>
				<div class="Rtable-cell">${invoice.buyerName}</div>
				<div class="Rtable-cell">${invoice.status}</div>
				<div class="Rtable-cell">${invoice.getTotal()}</div>
				<div class="Rtable-cell Rtable-cell--foot">${item.price.toString()}</div>
			</div>
		</c:forEach>
	</div>
	
	<div class="dashboard-item">
		<h3>View Customer Information</h3>
	</div>
</div>
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />