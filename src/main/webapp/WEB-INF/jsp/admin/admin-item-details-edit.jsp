<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<c:url var="defaultPhoto" value="/img/default-photo-veggies.jpg" />

<div class="col-xs-12 col-md-9 admin-content">

	<div class="col-xs-12 col-md-6">
		<img src="${defaultPhoto}" alt="default-veggie-photo" class="crop-image-medium img-responsive"/>
	</div>
	
	<div class="col-xs-12 col-md-6">
		<c:choose>
			<c:when test="${empty adminDetailItem.variety}">
				<h2 class="text-center">${adminDetailItem.type}</h2>
			</c:when>
			<c:otherwise>
				<h2 class="text-center">${adminDetailItem.type}, ${adminDetailItem.variety}</h2>
			</c:otherwise>
		</c:choose>
		<h3>Current Information</h3>
		<h4><span class="head-text">Family:</span> ${adminDetailItem.type}</h4>
		<h4><span class="head-text">Variety:</span> ${adminDetailItem.variety}</h4>
		<h4><span class="head-text">Default description:</span> ${adminDetailItem.description}</h4>
		<h4><span class="head-text">Image URL:</span> ${adminDetailItem.imageId}</h4>
		<c:choose>
			<c:when test="${adminDetailItem.isActive()}">
				<h4>Crop is currently <em>active</em></h4>
			</c:when>
			<c:otherwise>
				<h4>Crop is currently <em>inactive</em></h4>						
			</c:otherwise>
		</c:choose>
	</div>

	<div class="col-xs-12">
		<form action="admin-items-view-update" method="POST">
			<ul class="form-flex-outer">
		 		<li>
					<label for="itemType">Update Item Type:</label>
					<input type="text" name="itemType" />
			 	</li>
			 	<li>
					<label for="itemVariety">Update Item Variety:</label>
					<input type="text" name="itemVariety" />
				</li>
				<li>
					<label for="imageId">Update Image URL:</label>
					<input type="text" name="imageId" />
				</li>
				<li>   		
					<label for="itemDescription">Update Item Description:</label>
					<textarea rows="2" name="itemDescription" placeholder="Enter Item Description"></textarea>   		
				</li>
				<li>
					<label for="itemIsActive">Is Active?:</label>
					<select name="itemIsActive">
				        <option value="true">True</option>
				        <option value="false">False</option>
			    	</select>
				</li>
				<li>
					<label for="startDate1">Season 1 start Date:</label>
					<input type="date" placeholder="dd/MM/yyyy" name="startDate1"/>
				</li>
				<li>
					<label for="endDate1">Season 1 end Date:</label>
					<input type="date" placeholder="dd/MM/yyyy" name="endDate1"/>
				</li>
				<li>
					<label for="startDate2">Season 2 start Date:</label>
					<input type="date" placeholder="dd/MM/yyyy" name="startDate2"/>
				</li>
				<li>
					<label for="endDate2">Season 2 end Date:</label>
					<input type="date" placeholder="dd/MM/yyyy" name="endDate2"/>
				</li>
				<li>
					<label for="startDate3">Season 3 start Date:</label>
					<input type="date" placeholder="dd/MM/yyyy" name="startDate3"/>
				</li>
				<li>
					<label for="endDate3">Season 3 end Date:</label>
					<input type="date" placeholder="dd/MM/yyyy" name="endDate3"/>
				</li>
				<li>
					<input type="submit" value="Save" />
					<input type="hidden" name="itemId" value="${item.itemId}"/>
				</li>
			</ul>
		</form>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />		
		