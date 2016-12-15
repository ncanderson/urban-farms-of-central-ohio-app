<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url var="imagePath" value="/img/" />

<h1>${detailCrop.itemVariety} ${detailCrop.itemType}</h1>

<div>

	<div>
		<img src="${imagePath}/${detailCrop.harvestImageId}" alt="crop image" class="crop-image-medium" />
	</div>
	
	<div id="crop-detail-information">
		<p>Available Until: ${detailCrop.endDate}</p>
		<p>Price: $${detailCrop.price}</p>
		<p>Average Size: ${detailCrop.averageSize}</p>
		<p>Item availability: ${detailCrop.availability}/lbs</p>
		<p>Description: ${detailCrop.itemDescription}</p>
		<p>Comments: ${detailCrop.comments}</p>
	</div>
	<c:url var="cartHref" value="/customer-views/shopping-cart" /> 
	<form action="${cartHref}" method="POST">
	   	<input type="text" name="harvestQuantityToBuy" placeholder="Quantity to buy" />
	   	<input type="submit" value="Add to Cart"/>
	   	<input type="hidden" name="harvestItemToBuy" value="${detailCrop.harvestItemId}" />
    </form>

</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />

