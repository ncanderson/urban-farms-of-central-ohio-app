<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="farmer-dashboard-sidebar-menu.jsp" />

<c:url var="defaultPhoto" value="/img/default-photo-veggies.jpg" />

<div class="col-xs-12 col-md-9" id="content">
	<div class="dashboard-item">
		<h3>Available Inventory</h3>
		<c:forEach var="item" items="${harvestItemsList}">
			<div class="Rtable Rtable--5cols Rtable--collapse">
		        <form action="editInventoryItem?itemId=${item.itemId}" method="GET" class="Rtable-cell Rtable-cell" >
			        <button type="submit" class="btn btn-default btn-sm">
			        	<span class="glyphicon glyphicon-edit"></span> Edit
			        </button>
		        </form>
				<div class="Rtable-cell Rtable-cell--head">${item.itemType}</div>
				<div class="Rtable-cell">${item.itemVariety}</div>
				<div class="Rtable-cell"><img src="${defaultPhoto}" alt="default-veggie-photo" id="crop-photo"/></div>
				<div class="Rtable-cell Rtable-cell--foot">${item.harvestItemId} (Put price here you turkey)</div>
			</div>
		</c:forEach>
	</div>
	
	<div class="dashboard-item">
		<h3>View All pending orders</h3>
		<c:forEach var="pendingInvoice" items="${pendingOrders}">
			<div class="Rtable Rtable--4cols Rtable--collapse">
				<div class="Rtable-cell Rtable-cell"><button type="button" class="btn btn-default btn-sm">
		        	<span class="glyphicon glyphicon-edit"></span> Edit
		        </button></div>
				<div class="Rtable-cell Rtable-cell--head">${pendingInvoice.invoiceId}</div>
				<div class="Rtable-cell">${pendingInvoice.date}</div>
				<div class="Rtable-cell">${pendingInvoice.saleType}</div>
				<div class="Rtable-cell">${pendingInvoice.buyerName}</div>
				<div class="Rtable-cell">${pendingInvoice.status}</div>
				<%-- <div class="Rtable-cell">${pendingInvoice.getTotal()}</div> --%>
				<div class="Rtable-cell">${pendingInvoice.price.toString()}</div>
				<div class="Rtable-cell Rtable-cell--foot">${pendingInvoice.items.size()}</div>
			</div>
		</c:forEach>		
	</div>

	<div class="dashboard-item">
		<h3>View past orders LIMITING SQL QUERY TO 10 CURRENTLY</h3>
		<c:forEach var="invoice" items="${pastOrders}">
			<div class="Rtable Rtable--7cols Rtable--collapse">
				<div class="Rtable-cell Rtable-cell--head">${invoice.invoiceId}</div>
				<div class="Rtable-cell">${invoice.date}</div>
				<div class="Rtable-cell">${invoice.saleType}</div>
				<div class="Rtable-cell">${invoice.buyerName}</div>
				<div class="Rtable-cell">${invoice.status}</div>
				<%-- <div class="Rtable-cell">${invoice.getTotal()}</div> --%>
				<div class="Rtable-cell Rtable-cell--foot">${item.price.toString()}</div>
			</div>
			
		</c:forEach>
	</div>
	
	<div class="dashboard-item">
		<h3>View Customer Information</h3>
	</div>
</div>
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />