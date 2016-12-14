<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<title>Add New Buyer User</title>

<h3>Add New Buyer User</h3>

<form action="admin-all-buyer-users-all-insert" method="POST">
		
		<div class="Rtable-cell">
			
			<h3><label for="firstName">First Name</label></h3>
			<input type="text" name="firstName" />
   		</div>
		<div class="Rtable-cell">
			
			<h3><label for="lastName">Last Name</label></h3>
			<input type="text" name="lastName" />
   		</div>
   		<div class="Rtable-cell">
			
			<h3><label for="email">Enter Email</label></h3>
			<input type="text" name="email" />		
		</div>
		<div class="Rtable-cell">
			
			<h3><label for="phoneNumber">Enter Phone Number</label></h3>
			<input type="text" name="phoneNumber" />  		
		</div>
		 <div class="Rtable-cell">
			
			<h3><label for="buyerUserIsAdmin">Is Admin</label></h3>
			<select name="buerUserIsAdmin">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
		 <div class="Rtable-cell">
			
			<h3><label for="buyerUserIsActive">Is Active</label></h3>
			<select name="buyerUserIsActive">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
   		
   		<div class="Rtable-cell">
			
			<h3><label for="buyerUserOrg">Select Org</label></h3>
			<select name="buyerUserOrg">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
   		<!--  TODO  password and mobile/work phone select -->
		<input type="submit" value="Save" />
	</form>
















<c:import url="/WEB-INF/jsp/common/footer.jsp" />