<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url var="imagePath" value="/img/" />

<div class="jumbotron">
	<h1>Thank you for your order!</h1>
</div>

<div class="col-xs-8 col-xs-offset-2 col-md-4 col-md-offset-4" >
	<c:url var="home" value="/welcome" />
	<a href="${home}" type="button" class="btn btn-primary btn-block ">Back To Home</a>
</div>
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
