<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="farmer-dashboard-sidebar-menu.jsp" />

<c:url var="defaultPhoto" value="/img/default-photo-veggies.jpg" />

<div class="col-xs-12 col-md-9">
	<form action="editInventoryItem" method="POST">
		<ul class="form-flex-outer">
			<li>
				<label for="harvestImageId">Enter Image URL:</label>
				<input type="text" name="harvestImageId" value="${detailCrop.harvestImageId}" />
			</li>
			
			<!-- Allow to change type/variety? -->
<%-- 			<li>
				<label for="type">Select crop family:</label>
				<select name="type" id="crop-type">
					<c:forEach var="cropType" items="${distinctCropTypes}">
						<option value="${cropType}">${cropType}</option>
					</c:forEach>
				</select>
			</li>
			<li id="crop-variety-hidden">
				<label for="variety">Select crop variety:</label>
				<select name="variety" id="crop-variety">
					<!-- JS will fill this menu out -->
				</select>
			</li> --%>
			<li>
				<label for="harvestQuantity">Enter pounds available:</label>
				<input type="text" name="harvestQuantity" value="${detailCrop.harvestQnty}"/>
			</li>	
			<li>
				<label for="price">Enter price per pound:</label>
				<input type="text" name="price" value="${detailCrop.price}"/>
			</li>
	   		<li>
	   			<label for="averageSizeOfItem">Average size of item:</label>
	   			<input type="text" name="averageSizeOfItem" value="${detailCrop.averageSize}"/>	
	   		</li>
		    <li>
	  			<label for="harvestAvailability">Availability:</label>
	  			<input type="text" id="harvestAvailability" value="${detailCrop.availability}"/>
	   		</li>
	   		<li>
	   			<label for="harvestDetailsComments">Message:</label>
	   			<input type="text" id="harvestDetailsComments" value="${detailCrop.comments}"/>
	   		</li>
	   		<li>
	   			<label for="farmerEnteredPickComments">Pick List Comments:</label>
	   			<input type="text" id="farmerEnteredPickComments" value="${detailCrop.farmerEnteredPickComments}"/>
	   		</li>
			<li>
				<input type="submit" class="form-centered-button" value="Update Item" />
			</li>
		</ul>
	</form>
 </div>       
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />