<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<form action="enterInventory" method="POST">
	<ul class="form-flex-outer">
		<li>
			<label for="text">Enter Image URL:</label>
			<input type="text" name="imageId" />
		</li>
		<li>
			<label for="type">Enter crop type:</label>
			<input type="text" name="type" />
		</li>
		<li>
			<label for="variety">Enter crop variety, if any:</label>
			<input type="text" name="variety" />
		</li>
		<li>
			<label for="harvestQnty">Enter pounds available:</label>
			<input type="text" name="harvestQnty" />
		</li>	
		<li>
			<label for="price">Enter price per pound:</label>
			<input type="text" name="price" />
		</li>
	    <li>
     			<label for="availability">Availability:</label>
     			<textarea rows="2" id="availability" placeholder="Enter crop availability"></textarea>
   		</li>
   		<li>
     			<label for="notes">Message:</label>
     			<textarea rows="2" id="notes" placeholder="Notes about the crop"></textarea>
   		</li>
		<li>
			<input type="submit" value="Add Item to Order" />
		</li>
	</ul>
</form>

<img src="https://s-media-cache-ak0.pinimg.com/564x/79/a3/3e/79a33ea964cb35247a13ba78555e2f4d.jpg" alt="A demon" />

            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />