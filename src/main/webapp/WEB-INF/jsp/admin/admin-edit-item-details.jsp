<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<title>Edit Item Details</title>
</head>
<body>
	
	<form action="admin-items-view" method="POST">
		<input type="hidden" name="itemId" value="${item.itemId}"/>
		<div class="Rtable-cell">
			<h3> ${item.type}</h3>
			<label for="itemType">Enter Item Type</label>
			<input type="text" name="itemTyper" />
   		</div>
		<div class="Rtable-cell">
			<h3> ${item.variety}</h3>
			<label for="itemVariety">Enter Item Variety</label>
			<input type="text" name="itemVariety" />
   		</div>
   		<div class="Rtable-cell">
			<h3> ${item.description}</h3>
			<label for="itemDescription">Enter Item Description</label>
			<textarea rows="4" name="itemDescription">Enter Item Description</textarea>   		
		</div>
		 <div class="Rtable-cell">
			<h3> ${item.active}</h3>
			<label for="itemIsActive">Is Active</label>
			<select name="itemIsActive">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
   		<div>
   			<h3>This Div for seasons input</h3><!-- seasons -->
   		</div>
		<div class="Rtable-cell">
		
		<!-- TODO select start and end date for each season -->
		
		</div>
		<input type="submit" value="Save" />
	</form>
	
	
	


<c:import url="/WEB-INF/jsp/common/footer.jsp" />		<label for="harvestImageId">Enter Image URL:</label>
		