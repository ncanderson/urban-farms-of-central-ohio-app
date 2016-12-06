<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="center-block col-sm-10">

   <div class="container">
        <table id="available-crops" class="table table-striped ">
            <thead>
                <tr>
                	<th>Image</th>
                    <th>Crop</th>
                    <th>Quantity Available (pounds)</th>
                    <th>Price (per pound)</th>
                    <th>Availability</th>
                    <th>Image</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${itemList}">
            
            
            
			</c:forEach>            
            </tbody>
        </table>
    </div>    

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />