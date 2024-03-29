<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url var="imagePath" value="/img/" />

<h2 class="text-center">Currently Available Items</h2>
<h3 class="text-center">Click an item for further details</h3>
	
<!-- <div id="main-page-menu-header" class="Rtable Rtable--4cols js-RtableAccordions">
	<div class="Rtable-cell Rtable-cell--head"></div>
	<div class="Rtable-cell"><h4>Crop</h4></div>
	<div class="Rtable-cell"><h4>Harvest Quantity</h4></div>
	<div class="Rtable-cell Rtable-cell--foot"><h4>Sale Price</h4></div>
</div> -->
   
<div class="Rtable Rtable--4cols Rtable--collapse js-RtableAccordions">
	<c:forEach var="item" items="${harvestItemsList}">
	    <c:url var="itemDetails" value="anonymous-detail-view?harvestItemId=${item.harvestItemId}" />
	    <button class="Accordion" role="tab">${item.itemVariety} ${item.itemType}</button>
	    <div class="Rtable-cell"><a href="${itemDetails}"><img src="${imagePath}/${item.harvestImageId}" alt="crop image" class="crop-image-small" /></a></div>
	    <div class="Rtable-cell  Rtable-cell--head"><h3><a href="${itemDetails}">${item.itemVariety} ${item.itemType}</a></h3></div>
	    <div class="Rtable-cell"><a href="${itemDetails}">${item.harvestQnty}/lbs. available</a></div>
	    <div class="Rtable-cell Rtable-cell--foot"><a href="${itemDetails}">$${item.price}/lbs.</a></div>
	    <hr />
	</c:forEach>                 
</div>   
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
