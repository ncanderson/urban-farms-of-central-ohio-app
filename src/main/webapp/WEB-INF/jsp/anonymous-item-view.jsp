<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="defaultPhoto" value="/img/default-photo-veggies.jpg" />

<div class="col-xs-12 col-md-9" id="content">
	<div class="dashboard-item">
		<h3>Available Harvest Inventory</h3>
		<div class="Rtable Rtable--5cols Rtable--collapse" id="anonymous-view-header">
			<div class="Rtable-cell Rtable-cell--head"></div>
			<div class="Rtable-cell">Crop Type</div>
			<div class="Rtable-cell">Crop Variety</div>
			<div class="Rtable-cell">Harvest Quantity</div>
			<div class="Rtable-cell Rtable-cell--foot">Sales Price</div>
		</div>
		
		<c:forEach var="item" items="${harvestItemsList}">
			<div class="Rtable Rtable--5cols Rtable--collapse">
		        <div class="Rtable-cell"><img src="${defaultPhoto}" alt="default-veggie-photo" id="crop-photo"/></div>
		        <div class="Rtable-cell Rtable-cell--head">${item.itemType}</div>
		        <div class="Rtable-cell">${item.itemVariety}</div>
		        <div class="Rtable-cell">${item.harvestQnty}</div>
		        <div class="Rtable-cell Rtable-cell--foot">$${item.price}</div>	
			</div>
		</c:forEach>
	</div>
</div>
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
