<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:url var="imagePath" value="/img/" />

<div class="jumbotron">
	<h1 class="text-center">Shopping Cart</h1>
</div>

<p>Invoice: ${invoice.invoiceId}</p>
<ul>
<c:forEach var="item" items="${itemList}">
<li>${item.harvestDetailsId }</li>
<li>${item.invoiceQnty }</li>
<li>${item.invoiceId }</li>
<li>${item.userId }</li>
</c:forEach>
</ul>


 ${invoice.getInvoiceTotal() }


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
