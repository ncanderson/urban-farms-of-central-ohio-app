<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:import url="/WEB-INF/jsp/admin/admin-sidebar-menu.jsp" />

<<<<<<< HEAD
<title>Add new Item</title>

	  
=======
<div class="col-xs-12 col-md-9" id="content">  
>>>>>>> 18d4151febe3a8eebf2fff3fdbdbd97a1c124393
	<form action="admin-items-view-insert" method="POST">
		
		<div class="Rtable-cell">
			
			<h3><label for="itemType">Type</label></h3>
			<input type="text" name="itemType" />
   		</div>
		<div class="Rtable-cell">
			
			<h3><label for="itemVariety">Variety</label></h3>
			<input type="text" name="itemVariety" />
   		</div>
   		<div class="Rtable-cell">
			
			<h3><label for="itemDescription">Description</label></h3>
			<textarea rows="4" name="itemDescription">Enter Item Description</textarea>   		
		</div>
		 <div class="Rtable-cell">
			
			<h3><label for="itemIsActive">Is Active</label></h3>
			<select name="itemIsActive">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
   		<div>
   			<h3>This Div for seasons input</h3><!-- seasons  -->
   		</div>
		<div class="Rtable-cell">
		
		<!-- TODO select start and end date for each season -->
		
		</div>
		<input type="submit" value="Save" />
	</form>
</div>




<c:import url="/WEB-INF/jsp/common/footer.jsp" />