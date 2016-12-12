<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<div class="Rtable Rtable--4cols Rtable--collapse js-RtableAccordions">
		<c:forEach var="item" items="${harvestItemsList}">
			<c:url var="itemDetails" value="anonymous-detail-view?itemId=${item.itemId}" />
			<button class="Accordion" role="tab"><%-- ${item.variety} ${item.type} --%>${item.itemId}</button>
			<div class="Rtable-cell"><a href="${itemDetails}"><%-- <img src="${item.imageId}" alt="crop image" class="crop-image" /> --%>image</a></div>
			<div class="Rtable-cell  Rtable-cell--head"><h3><a href="${itemDetails}"><%-- ${item.variety} ${item.type} --%>type, variety</a></h3></div>
			<div class="Rtable-cell"><a href="${itemDetails}">${item.harvestQnty} lbs. available</a></div>
			<div class="Rtable-cell Rtable-cell--foot"><a href="${itemDetails}">${item.price}/lbs</a></div>
		</c:forEach>  			     
	</div>   
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
