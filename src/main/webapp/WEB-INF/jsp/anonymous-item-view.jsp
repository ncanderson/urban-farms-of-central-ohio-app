<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<div class="Rtable Rtable--4cols Rtable--collapse js-RtableAccordions">
		<c:forEach var="item" items="${itemList}">
			<button class="Accordion" role="tab">${item.variety} ${item.type}</button>
			<div class="Rtable-cell"><img src="${item.imageId}" alt="crop image" class="crop-image" /></div>
			<div class="Rtable-cell  Rtable-cell--head"><h3>${item.variety} ${item.type}</h3></div>
			<div class="Rtable-cell">${item.harvestQnty} lbs. available</div>
			<div class="Rtable-cell Rtable-cell--foot">${item.price.toString()}/lbs</div>
		</c:forEach>  			     
	</div>     
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
