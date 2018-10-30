<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>




	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:20%">OrderId</th>
							<th style="width:20%">Product</th>
							<th style="width:18%">Address</th>
							<th style="width:22%" class="text-center">total Amount</th>
							<th style="width:20%"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list}" var="entry">
						<tr>
							<td data-th="Product">
								<div class="row">
									
									<div class="col-sm-10">
										<h4 class="nomargin">${entry.orderId} </h4>
										<p></p>
									</div>
								</div>
							</td>
							
							<td data-th="Price"><c:forEach items="${entry.productList}" var="map">
   <li> Product name = ${map.key.name} Qty = ${map.value}</li>
 
</c:forEach> </td>
							<td data-th="Quantity">
								${entry.address.street},${entry.address.apt}
							</td>
							<td data-th="Subtotal" class="text-center">${entry.totalAmt}</td>
							<td class="actions" data-th="">
			
								 								
							
							 <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalLong${entry.orderId}">
  Remove
</button>
								 <div class="modal fade" id="exampleModalLong${entry.orderId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Alert!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Delete order?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <form action="deleteOrder" method="post"><input type="hidden" id="id" name="id" value="${entry.orderId}"><input type="submit" class="btn btn-danger" value="delete"></form>	
								 
      </div>
    </div>
  </div>
</div>			
							</td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong></strong></td>
						</tr>
						<tr>
							<td><a href="home" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong></strong></td>
							
						</tr>
					</tfoot>
				</table>
</div>

<script src="JS/autocomplete.js"></script>

</body>
</html>