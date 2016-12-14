<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<title>Edit Farmer View</title>

	
<form action="admin-all-farmers-update" method="POST">
		<input type="hidden" name="userID" value="${farmer.userID }"/>
		<div class="Rtable-cell">
			<h3> ${farmer.firstName}</h3>
			<label for="firstName">First Name</label>
			<input type="text" name="firstName" />
   		</div>
		<div class="Rtable-cell">
			<h3> ${farmer.lastName}</h3>
			<label for="lastName">Last Name</label>
			<input type="text" name="lastName" />
   		</div>
   		<div class="Rtable-cell">
			<h3> ${farmer.email}</h3>
			<label for="email">Enter Email</label>
			<input type="text" name="email" />s  		
		</div>
		<div class="Rtable-cell">
			<h3> ${farmer.phoneNumber}</h3>
			<label for="phoneNumber">Enter Phone Number</label>
			<input type="text" name="phoneNumber" />  		
		</div>
		 <div class="Rtable-cell">
			<h3> ${farmer.admin}</h3>
			<label for="farmerIsActive">Is Active</label>
			<select name="farmerIsActive">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
   		<!--  TODO reset password and mobile/work phone select -->
		<input type="submit" value="Save" />
	</form>
	




<c:import url="/WEB-INF/jsp/common/footer.jsp" />