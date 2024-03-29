<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<div class="col-xs-12 col-md-9">
	<form action="enterInventory" method="POST">
		<ul class="form-flex-outer">
			<li>
				<label for="harvestImageId">Enter Image URL:</label>
				<input type="text" name="harvestImageId" />
			</li>
			<li>
				<label for="type">Select crop family:</label>
				<select name="type" id="crop-type">
				<option selected="selected">Select Crop Family</option>
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
			</li>
			<li>
				<label for="harvestQuantity">Enter pounds available:</label>
				<input type="text" name="harvestQuantity" />
			</li>	
	   		<li>
	   			<label for="averageSizeOfItem">Average size of item:</label>
	   			<input type="text" name="averageSizeOfItem" />	
	   		</li>
	   		<li>
	   			<label for="pricePerPound">Enter price per pound:</label>
	   			<input type="text" name="pricePerPound" id="pricePerPound"/>
	   		</li>

		    <li>
	  			<label for="harvestAvailability">Availability:</label>
	  			<textarea rows="2" id="harvestAvailability" placeholder="Enter crop availability" name="harvestAvailability"></textarea>
	   		</li>
	   		<li>
	  			<label for="harvestEndDate">End Availability On:</label>
	  			<input type="date" placeholder="dd/MM/yyyy" name="harvestEndDate"/>
	   		</li>
	   		<li>
	   			<label for="harvestDetailsComments">Message:</label>
	   			<textarea rows="2" id="harvestDetailsComments" placeholder="Notes about the crop" name="harvestDetailsComments" ></textarea>
	   		</li>
	   		<li>
	   			<label for="farmerEnteredPickComments">Pick List Comments:</label>
	   			<textarea rows="2" id="farmerEnteredPickComments" placeholder="Pick-list comments" name="farmerEnteredPickComments" ></textarea>
	   		</li>
			<li>
				<input type="submit" class="form-centered-button" value="Add Item to Harvest Availability" />
			</li>
		</ul>
	</form>	
 </div>       
<c:import url="/WEB-INF/jsp/common/footer.jsp" />