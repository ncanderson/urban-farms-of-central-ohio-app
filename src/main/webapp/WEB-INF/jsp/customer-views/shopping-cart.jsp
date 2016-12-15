<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="imagePath" value="/img/" />

<h1 class="text-center">Shopping Cart</h1>

<p>Invoice: ${invoice.invoiceId}</p>

<p>${invoice.date}</p>
<p>${invoice.buyerName}</p>
<p>${invoice.buyerId}</p>
<p>${invoice.saleType}</p>
<p>${invoice.status}</p>
<p>${invoice.userId}</p>
<br />

<p>${user.type}</p>
<p>${user.userId}</p>
<p>${user.email}</p>
<p>${user.firstName}</p>
<p>${user.lastName}</p>
<p>${user.phoneNumber}</p>
<p>${user.isGlobalAdmin()}</p>
<p>${user.isAdmin()}</p>
<p>${user.isActive()}</p>
<p>${user.buyerId}</p>
<p>${user.resetPassword}</p>
<br />

<p>${buyerOrganization.buyerId}</p>
<p>${buyerOrganization.buyerName}</p>
<p>${buyerOrganization.address1}</p>
<p>${buyerOrganization.address2}</p>
<p>${buyerOrganization.city}</p>
<p>${buyerOrganization.stateCode}</p>
<p>${buyerOrganization.zipCode}</p>
<p>${buyerOrganization.contactPhone}</p>
<p>${buyerOrganization.notes}</p>
<p>${buyerOrganization.isActive()}</p>
<p>${buyerOrganization.description}</p>
<p>${buyerOrganization.largeOrderDiscount}</p>
<p>${buyerOrganization.discount}</p>
<br />

<c:forEach var="invoiceItem" items="${invoiceItems}">
	<p>${invoiceItem.invoiceItemId}</p>
	<p>${invoiceItem.invoiceId}</p>
	<p>${invoiceItem.invoiceQnty}</p>
	<p>${invoiceItem.harvestDetailsId}</p>
	<p>${invoiceItem.updatedItemPrice}</p>
	<p>${invoiceItem.userId}</p>
	<p>${invoiceItem.invoiceItemStatusId}</p>
	<p>${invoiceItem.invoiceOverridePrice}</p>
	<p>${invoiceItem.dateAddedToInvoice}</p>
	<br />
</c:forEach>

<c:forEach var="harvestItem" items="${harvestDetailItems}">
	<p>${harvestItem.harvestItemId}</p>
	<p>${harvestItem.itemId}</p>
	<p>${harvestItem.harvestQnty}</p>
	<p>${harvestItem.harvestImageId}</p>
	<p>${harvestItem.averageSize}</p>
	<p>${harvestItem.availability}</p>
	<p>${harvestItem.comments}</p>
	<p>${harvestItem.dateAdded}</p>
	<p>${harvestItem.price}</p>
	<p>${harvestItem.reconciliationId}</p>
	<p>${harvestItem.itemType}</p>
	<p>${harvestItem.itemVariety}</p>
	<p>${harvestItem.itemImageId}</p>
	<p>${harvestItem.itemDescription}</p>
	<p>${harvestItem.farmerEnteredPickComments}</p>
	<p>${harvestItem.endDate}</p>
	<br />
</c:forEach>

<h2>${total}</h2>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />

