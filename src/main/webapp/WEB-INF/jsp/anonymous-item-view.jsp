<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<div class="Rtable Rtable--4cols Rtable--collapse js-RtableAccordions">
		<c:forEach var="item" items="${itemList}">
			<c:url var="itemDetails" value="anonymous-detail-view?itemId=${item.itemId}" />
			<button class="Accordion" role="tab">${item.variety} ${item.type}</button>
			
			<div class="Rtable-cell"><a href="${itemDetails}"><img src="${item.imageId}" alt="crop image" class="crop-image" /></a></div>
			<div class="Rtable-cell  Rtable-cell--head"><a href="${itemDetails}"><h3>${item.variety} ${item.type}</h3></a></div>
			<div class="Rtable-cell"><a href="${itemDetails}">(Harvest Qnty not implemented) lbs. available</a></div>
			<div class="Rtable-cell Rtable-cell--foot"><a href="${itemDetails}">(Price not implemented)/lbs</a></div>
		</c:forEach>  			     
	</div>   
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
