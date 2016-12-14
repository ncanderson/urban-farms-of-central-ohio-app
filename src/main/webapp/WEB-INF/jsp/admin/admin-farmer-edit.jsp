<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<c:url var="defaultUserPhoto" value="/img/default-photo-user.jpg" />

<h2 class="text-center">Edit Farmer Details</h2>

<div class="col-xs-12 col-md-9 admin-content">
	
	<div class="col-xs-12">
		<h2 class="text-center head-text">${farmer.firstName} ${farmer.lastName}</h2>
		<h3>Current Information</h3><br />
		<h4><span class="head-text">Email:</span> ${farmer.email}</h4>
		<h4><span class="head-text">Phone Number:</span> ${farmer.phoneNumber}</h4>
		<c:choose>
			<c:when test="${farmer.isActive()}">
				<h4><em>Active User</em></h4>
			</c:when>
			<c:otherwise>
				<h4><em>Inactive User</em></h4>
			</c:otherwise>
		</c:choose>
		<c:if test="${farmer.isAdmin()}">
			<h4><em>User is Admin</em></h4>
		</c:if>
	</div>

	<div class="col-xs-12" id="updateForm">
	<h3>Update Information</h3>
		<form action="admin-all-farmers-view-insert" method="POST">
			<ul class="form-flex-outer">
				<li>
					<label for="firstName">First Name:</label>
					<input type="text" name="firstName" placeholder="${farmer.firstName}"/>
				</li>
				<li>
					<label for="lastName">Last Name:</label>
					<input type="text" name="lastName" placeholder="${farmer.lastName}"/>
				</li>
				<li>
					<label for="email">Enter Email:</label>
					<input type="text" name="email" placeholder="${farmer.email}"/>
				</li>
				<li>
					<label for="phoneNumber">Enter Phone Number:</label>
					<input type="text" name="phoneNumber" placeholder="${farmer.phoneNumber}" />
				</li>
		   		<li>
		   			<label for="temporaryPassword">Temporary Password:</label>
		   			<input type="text" name="temporaryPassword" />
		   		</li>
				<li>
					<label for="buyerUserIsAdmin">Admin Privileges?</label>
					<select name="buyerUserIsAdmin">
					<c:choose>
						<c:when test="${farmer.isAdmin()}">
							<option value="true">Yes</option>
							<option value="false">No</option>
						</c:when>
						<c:otherwise>
					        <option value="false">No</option>
					        <option value="true">Yes</option>
						</c:otherwise>
					</c:choose>
			    	</select>
				</li>
				<li>
					<label for="buyerUserIsActive">Active User?</label>
					<select name="buyerUserIsActive" >
					<c:choose>
						<c:when test="${farmer.isActive()}">
							<option value="true">Yes</option>
							<option value="false">No</option>
						</c:when>
						<c:otherwise>
							<option value="false">No</option>
							<option value="true">Yes</option>
					</c:otherwise>
					</c:choose>
					</select>
				</li>
				<li>
					<input type="submit" value="Save" class="form-centered-button" />
					<input type="hidden" name="userId" value="${farmer.userId}" />
				</li>
			</ul>
		</form>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />