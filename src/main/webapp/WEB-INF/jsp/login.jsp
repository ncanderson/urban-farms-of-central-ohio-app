<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<div class="jumbotron">
	
		<h1>Please login to access the site</h1>
		
		<div class="center-block">
			<form method="POST" action="login">
				<label for="userName">Username: </label>
				<input type="text" name="userName" /><br />
				
				<label for="password">Password: </label>
				<input type="password" name="password" /><br />
				
				<input type="submit" value="Submit" />
			</form>
		</div>
	
	</div>
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />