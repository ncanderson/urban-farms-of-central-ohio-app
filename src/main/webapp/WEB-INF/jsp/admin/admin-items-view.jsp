<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<title>Admin Items</title>
</head>
<body>
	
	
	<div class="Rtable Rtable--5cols Rtable--collapse js-RtableAccordions">
		<c:forEach var="item" items="${activeCrops}"><!-- NOTE: these are fake crops, change in buyer controller when ready -->
				
				<button class="Accordion" role="tab">${item.variety} ${item.type}</button>
				<div class="Rtable-cell"><img src="${item.imageId}" alt="crop image" class="crop-image" /></div>
				<div class="Rtable-cell  Rtable-cell--head"><h3>${item.variety} ${item.type}</h3></div>
				<div class="Rtable-cell">${item.harvestQnty} lbs. available</div>
				<div class="Rtable-cell Rtable-cell--foot">${item.price.toString()}/lbs</div>
						
				 <c:url var="itemDetails" value="admin-edit-item-details?itemId=${item.itemId}" />
				<div class="Rtable-cell"><a href=${itemDetails }>Edit Item Details</a></div>
			
		</c:forEach>  			     
	</div>





	
		