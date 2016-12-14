<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<h1>*****This form is not complete******</h1>
<h3>*****salt, credentials_id******</h3>

<h2 class="text-center">Add New Buyer</h2>

<div class="col-xs-12 col-md-9 admin-content">

	<form action="admin-buyer-user-add-new" method="POST">
		<ul class="form-flex-outer">
			<li>
				<label for="buyerUserOrg">Organization:</label>
				<input type="text" name="buyerUserOrg" />
			</li>
			<li>
				<label for="firstName">First Name:</label>
				<input type="text" name="firstName" />
			</li>
			<li>
				<label for="lastName">Last Name:</label>
				<input type="text" name="lastName" />
			</li>
			<li>
				<label for="email">Enter Email:</label>
				<input type="text" name="email" />
			</li>
			<li>
				<label for="phoneNumber">Enter Phone Number:</label>
				<input type="text" name="phoneNumber" />
			</li>
	   		<li>
	   			<label for="temporaryPassword">Temporary Password:</label>
	   			<input type="text" name="temporaryPassword" />
	   		</li>
			<li>
				<label for="buyerUserIsAdmin">Admin Privileges?</label>
				<select name="buyerIsAdmin">
			        <option value="false">No</option>
			        <option value="true">Yes</option>
		    	</select>
			</li>
			<li>
				<label for="buyerUserIsActive">Active buyer?</label>
				<select name="buyerIsActive">
			        <option value="false">No</option>
			        <option value="true">Yes</option>
		    	</select>
			</li>
			<li>
				<input type="submit" value="Save" class="form-centered-button" />
			</li>
		</ul>
	</form>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />