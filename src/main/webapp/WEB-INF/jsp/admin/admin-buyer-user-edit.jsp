<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<c:url var="defaultUserPhoto" value="/img/default-photo-user.jpg" />

<h2 class="text-center">Edit buyer Details</h2>

<div class="col-xs-12 col-md-9 admin-content">
	
	<div class="col-xs-12">
		<h2 class="text-center head-text">${buyer.firstName} ${buyer.lastName}</h2>
		<h3>Current Information</h3><br />
		<h4><span class="head-text">Organization: ${buyer.buyerUserOrg}</span></h4>
		<h4><span class="head-text">Email:</span> ${buyer.email}</h4>
		<h4><span class="head-text">Phone Number:</span> ${buyer.phoneNumber}</h4>
		<c:choose>
			<c:when test="${buyer.isActive()}">
				<h4><em>Active Buyer</em></h4>
			</c:when>
			<c:otherwise>
				<h4><em>Inactive Buyer</em></h4>
			</c:otherwise>
		</c:choose>
		<c:if test="${buyer.isAdmin()}">
			<h4><em>Buyer is Admin</em></h4>
		</c:if>
	</div>

	<div class="col-xs-12" id="updateForm">
	<h3>Update Information</h3>
		<form action="admin-all-buyer-users-all-insert" method="POST">
			<ul class="form-flex-outer">
				<li>
					<label for="buyerUserOrg">Organization</label>
					<input type="text" name="buyerUserOrg" placeholder="${buyer.organization}" />
				</li>
				<li>
					<label for="firstName">First Name:</label>
					<input type="text" name="firstName" placeholder="${buyer.firstName}"/>
				</li>
				<li>
					<label for="lastName">Last Name:</label>
					<input type="text" name="lastName" placeholder="${buyer.lastName}"/>
				</li>
				<li>
					<label for="email">Enter Email:</label>
					<input type="text" name="email" placeholder="${buyer.email}"/>
				</li>
				<li>
					<label for="phoneNumber">Enter Phone Number:</label>
					<input type="text" name="phoneNumber" placeholder="${buyer.phoneNumber}" />
				</li>
		   		<li>
		   			<label for="temporaryPassword">Temporary Password:</label>
		   			<input type="text" name="temporaryPassword" />
		   		</li>
				<li>
					<label for="buyerUserIsAdmin">Admin Privileges?</label>
					<select name="buyerUserIsAdmin">
					<c:choose>
						<c:when test="${buyer.isAdmin()}">
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
						<c:when test="${buyer.isActive()}">
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
					<input type="hidden" name="userId" value="${buyer.userId}" />
				</li>
			</ul>
		</form>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />