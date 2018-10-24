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
								<input type="number" class="form-control text-center" value="${entry.value}">
							</td>
							<td data-th="Subtotal" class="text-center">${entry.key.price*entry.value}</td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
								 <form action="deleteItem" method="post"><input type="hidden" id="p" name="id" value="${entry.key.id}"><input type="submit" class="btn btn-danger" value="delete"></form>								
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



</body>
</html>