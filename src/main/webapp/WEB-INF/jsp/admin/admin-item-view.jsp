<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<div>
    
    <c:url var="addNewItem" value="/admin/admin-add-new-item" />
	<p class="text-center"><a href="${addNewItem}" type="button" class="btn btn-primary wide-button">Add New Item</a></p>

	<c:url var="defaultPhoto" value="/img/default-photo-veggies.jpg" />

	<div class="col-xs-12 col-md-9" id="content">
		<div>
			<h3>Produce Items</h3>
			<c:forEach var="item" items="${activeCrops}">
				<div class="Rtable Rtable--2cols Rtable--collapse">
		        	<c:url var="itemDetails" value="admin-item-details-edit?itemId=${item.itemId}" />
		        	<div class="Rtable-cell"><a href="${itemDetails}"><img src="${defaultPhoto}" alt="default-veggie-photo" class="crop-image-small"/></a></div>
					<div class="Rtable-cell Rtable-cell--head">
						<h3><a href="${itemDetails}">${item.variety} ${item.type}</a></h3>
					</div>
				</div>
			</c:forEach>
		</div>
	   
	</div>
	
</div>         
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />