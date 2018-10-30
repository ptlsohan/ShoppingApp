<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>



<c:if test="${list.size()!=0 }">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list}" var="entry">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${entry.key.companyName} ${entry.key.name}</h4>
										<p></p>
									</div>
								</div>
							</td>
							<td data-th="Price">$${entry.key.price}</td>
							<td data-th="Quantity">
								<input type="number" readOnly class="form-control text-center" value="${entry.value}">
							</td>
							<td data-th="Subtotal" class="text-center">${entry.key.price*entry.value}</td>
							<td class="actions" data-th="">
							
								 
								 
								 <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalLong${entry.key.id}">
  Remove
</button>
								 <div class="modal fade" id="exampleModalLong${entry.key.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Alert!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Remove item from Cart?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <form action="deleteItem" method="post"><input type="hidden" id="p" name="id" value="${entry.key.id}">
								 <button type="submit" class="btn btn-danger">Delete</button></form>	
								 
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
							<td class="text-center"><strong>Total $${total}</strong></td>
						</tr>
						<tr>
							<td><a href="home" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total $${total}</strong></td>
							<td><a href="checkout" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</c:if>
<c:if test="${list.size()==0}">
<p>No Items in cart</p>
</c:if>


<script src="JS/autocomplete.js"></script>
</body>
</html>