<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:import url="/WEB-INF/jsp/admin/admin-sidebar-menu.jsp" />

<div>
    
    <c:url var="addNewItem" value="/admin-add-new-item" />
	<a href="${addNewItem }" type="button" class="btn btn-primary wide-button">Add New Item</a>

<c:url var="defaultPhoto" value="/img/default-photo-veggies.jpg" />

<div class="col-xs-12 col-md-9" id="content">
	<div class="dashboard-item">
		<h3>Produce Items</h3>
		<c:forEach var="item" items="${activeCrops}">
			<div class="Rtable Rtable--2cols Rtable--collapse">
		        <div class="Rtable-cell"><img src="${defaultPhoto}" alt="default-veggie-photo" id="crop-photo"/></div>
		        <c:url var="itemDetails" value="admin-edit-item-details?itemId=${item.itemId}" />
				<div class="Rtable-cell Rtable-cell--head">
					<h3> <a href=${itemDetails }>${item.type} ${item.variety}</a></h3>
				</div>
			</div>
		</c:forEach>
	</div>
	

	<c:url var="addNewItem" value="admin-add-new-item" />
	<div><a href=${addNewItem }>Add New Item</a></div>
            
</div>
</div>         
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />