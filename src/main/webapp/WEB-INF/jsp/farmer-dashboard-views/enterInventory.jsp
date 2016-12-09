<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<form action="enterInventory" method="POST">
	<ul class="form-flex-outer">
		<li>
			<label for="harvestImageId">Enter Image URL:</label>
			<input type="text" name="harvestImageId" />
		</li>
<%-- 		<li>
			<label for="type">Select crop type:</label>
			<select name="type" id="crop-type">
				<c:forEach var="cropItem" items="${allCropsList}">
					<option value="${cropItem.type}">${cropItem.type}</option>
				</c:forEach>
			</select>
		</li>
		<li>
			<label for="variety">Select crop variety:</label>
			<select name="variety" id="crop-variety">
				<c:forEach var="cropVariety" items="${allCropsList}">
					<option value="${cropVariety.variety}">${cropVariety.variety.toUpperCase()}</option>
				</c:forEach>
			</select>
		</li> --%>
		<li>
			<label for="harvestQuantity">Enter pounds available:</label>
			<input type="text" name="harvestQuantity" />
		</li>	
		<li>
			<label for="price">Enter price per pound:</label>
			<input type="text" name="price" />
		</li>
   		<li>
   			<label for="averageSizeOfItem">Average size of item:</label>
   			<input type="text" name="harvestDetailsComments" />	
   		</li>
	    <li>
  			<label for="harvestAvailability">Availability:</label>
  			<textarea rows="2" id="harvestAvailability" placeholder="Enter crop availability"></textarea>
   		</li>
   		<li>
   			<label for="harvestDetailsComments">Message:</label>
   			<textarea rows="2" id="harvestDetailsComments" placeholder="Notes about the crop"></textarea>
   		</li>
		<li>
			<input type="submit" value="Add Item to Order" />
		</li>
	</ul>
</form>

<img src="https://s-media-cache-ak0.pinimg.com/564x/79/a3/3e/79a33ea964cb35247a13ba78555e2f4d.jpg" alt="A demon" />

            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />