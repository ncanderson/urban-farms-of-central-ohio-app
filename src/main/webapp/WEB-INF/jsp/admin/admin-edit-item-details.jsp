<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<c:url var="defaultPhoto" value="/img/default-photo-veggies.jpg" />

<div class="col-xs-12 col-md-9" id="content">

<img src="${defaultPhoto}" alt="default-veggie-photo" id="crop-photo"/>

	
	<form action="admin-items-view-update" method="POST">
		<input type="hidden" name="itemId" value="${item.itemId}"/>
		<div class="">
			<h3> ${item.type}</h3>
			<label for="itemType">Enter Item Type</label>
			<input type="text" name="itemType" />
   		</div>
		<div class="">
			<h3> ${item.variety}</h3>
			<label for="itemVariety">Enter Item Variety</label>
			<input type="text" name="itemVariety" />
   		</div>
   		<div class="">
			<h3> ${item.description}</h3>
			<label for="itemDescription">Enter Item Description</label>
			<textarea rows="4" name="itemDescription">Enter Item Description</textarea>   		
		</div>
		 <div class="">
			<h3> ${item.active}</h3>
			<label for="itemIsActive">Is Active</label>
			<select name="itemIsActive">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
   		<div>
   			<h3>Seasonal Availability</h3>
   			<hr>
   			
   			<div>
	  			<label for="harvestEndDate">End Availability On:</label>
	  			<input type="date" placeholder="dd/MM/yyyy" name="harvestEndDate"/>
	   		</div>
   			
   			
   			
   		</div>
		<input type="submit" value="Save" />
	</form>
	
</div>
	


<c:import url="/WEB-INF/jsp/common/footer.jsp" />		<label for="harvestImageId">Enter Image URL:</label>
		