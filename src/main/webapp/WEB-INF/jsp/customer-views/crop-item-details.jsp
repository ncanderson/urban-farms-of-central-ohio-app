<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url var="imagePath" value="/img/" />

<h1>${detailCrop.itemVariety} ${detailCrop.itemType}</h1>

<div>

	<div>
		<img src="${imagePath}/${item.harvestImageId}" alt="crop image" class="crop-image" />
	</div>
	
	<div id="crop-detail-information">
		<p>Available Until: ${detailCrop.endDate}</p>
		<p>Price: $${detailCrop.price}</p>
		<p>Average Size: ${detailCrop.averageSize}</p>
		<p>Item availability: ${detailCrop.availability}</p>
		<p>Description: ${detailCrop.itemDescription}</p>
		<p>Comments: ${detailCrop.comments}</p>
	</div>
	
	<form action="customer-views/shopping-cart" method="POST">
	   	<input type="text" placeholder="Quantity to buy" />
	   	<input type="submit" value="Add to Cart" name="harvestQuantityToBuy"/>
	   	<input type="hidden" name="harvestItemToBuy" value="${item.harvestItemId}" />
    </form>

</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />

