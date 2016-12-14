<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:import url="/WEB-INF/jsp/common/dashboard-sidebar.jsp" />

<title>Add new Farmer</title>
</head>
<body>
<h1>*****This form is not complete******</h1>
<h3>*****missing temp password, salt, credentials_id******</h3>

<form action="admin-all-farmers-view-insert" method="POST">
		
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
			
			<h3><label for="farmerIsAdmin">Is Admin</label></h3>
			<select name="farmerIsAdmin">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
		 <div class="Rtable-cell">
			
			<h3><label for="farmerIsActive">Is Active</label></h3>
			<select name="farmerIsActive">
		        <option value="true">True</option>
		        <option value="false">False</option>
		    </select>
   		</div> 
   		<!--  TODO  password and mobile/work phone select -->
		<input type="submit" value="Save" />
	</form>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />