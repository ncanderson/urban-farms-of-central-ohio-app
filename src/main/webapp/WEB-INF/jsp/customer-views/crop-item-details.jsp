<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<h1>${detailCrop.variety} ${detailCrop.type}</h1>

<div class="Rtable-cell"><img src="${item.imageId}" alt="crop image" class="crop-image" /></div>
<div class="Rtable-cell  Rtable-cell--head"><h3>${item.variety} ${item.type}</h3></div>
<div class="Rtable-cell">${item.harvestQnty} lbs. available</div>
<div class="Rtable-cell Rtable-cell--foot">${item.price.toString()}/lbs</div>
	
	
	
<c:url var="itemDetails" value="crop-item-details?itemId=${item.itemId}" />
<div class="Rtable-cell"><a href=${itemDetails }>Show Item Details</a></div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />