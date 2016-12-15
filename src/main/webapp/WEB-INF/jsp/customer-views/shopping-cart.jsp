<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url var="imagePath" value="/img/" />

<div class="jumbotron"><h1>PLACEHOLDER FOR SHOPPING CART</h1></div>

<p>Invoice: ${invoice.invoiceId}</p>
<p>${invoice.invoiceTotal}</p>
<ul>
<c:forEach var="item" items="${itemList}">
<li>${item.harvestDetailsId}</li>

</c:forEach>
</ul>
            
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
