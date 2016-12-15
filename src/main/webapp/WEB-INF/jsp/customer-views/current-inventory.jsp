<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="imagePath" value="/img/" />

<h2 class="text-center">Currently Available Items</h2>
<h3 class="text-center">Click an item for further details</h3>
	
<!-- <div id="main-page-menu-header" class="Rtable Rtable--5cols js-RtableAccordions">
       <div class="Rtable-cell Rtable-cell--head"></div>
       <div class="Rtable-cell"><h4>Crop</h4></div>
       <div class="Rtable-cell"><h4>Harvest Quantity</h4></div>
       <div class="Rtable-cell Rtable-cell--foot"><h4>Sale Price</h4></div>
       <div class="Rtable-cell"></div>
</div> -->
   
<div class="Rtable Rtable--5cols Rtable--collapse js-RtableAccordions">
	<c:forEach var="item" items="${harvestItemsList}">
	    <c:url var="itemDetails" value="/customer-views/crop-item-details?harvestItemId=${item.harvestItemId}" />
	    <button class="Accordion" role="tab">${item.itemVariety} ${item.itemType}</button>
	    <div class="Rtable-cell"><a href="${itemDetails}"><img src="${imagePath}/${item.harvestImageId}" alt="crop image" class="crop-image-small" /></a></div>
	    <div class="Rtable-cell  Rtable-cell--head"><h3><a href="${itemDetails}">${item.itemVariety} ${item.itemType}</a></h3></div>
	    <div class="Rtable-cell"><a href="${itemDetails}">${item.harvestQnty}/lbs. available</a></div>
	    <div class="Rtable-cell"><a href="${itemDetails}">$${item.price}/lbs.</a></div>
	    
	   	<c:url var="cartHref" value="/customer-views/shopping-cart" /> 
	    <form action="${cartHref}" method="POST" class="Rtable-cell Rtable-cell--foot Rtable-form">
	    	<input type="text" placeholder="Quantity" name="harvestQuantityToBuy" class="Rtable-cell" />
	    	<input type="submit" value="Add to Cart" class="Rtable-cell"/>
	    	<input type="hidden" name="harvestItemToBuy" value="${item.harvestItemId}" />
	    </form>
	</c:forEach>                 
</div>   
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />