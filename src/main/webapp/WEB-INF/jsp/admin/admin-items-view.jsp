<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<title>Admin Items</title>
</head>
<body>
	
	
	<div class="Rtable Rtable--5cols Rtable--collapse js-RtableAccordions">
		<c:forEach var="item" items="${activeCrops}">
				
				<div class="Rtable-cell"><img src="${item.imageId}" alt="crop image" class="crop-image" /></div>
				
				<div class="Rtable-cell  Rtable-cell--head"><h3>${item.type}</h3></div>
				<div class="Rtable-cell"><h3>${item.variety}</h3></div>
						
				 <c:url var="itemDetails" value="admin-edit-item-details?itemId=${item.itemId}" />
				<div class="Rtable-cell"><a href=${itemDetails }>Edit Item Details</a></div>
			
		</c:forEach>  			     
	</div>
	
	<c:url var="itemDetails" value="admin-edit-item-details?itemId=${item.itemId}" />
	<div><a href=${itemDetails }>Edit Item Details</a></div>

 


	
		