<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>



<c:if test="${list.size()!=0 }">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:45%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:28%">Quantity</th>
							<th style="width:7%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list}" var="entry">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${pageContext.request.contextPath}/images/product/${entry.key.image }" width="90" height="90" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${entry.key.name}</h4>
										<p></p>
									</div>
								</div>
							</td>
							<td data-th="Price" >$${entry.key.price}</td>
							<td data-th="Quantity">
							<div class="input-group mb-2 w-50">
							<input type="hidden" id="pid" value="${entry.key.id}" >
        <div class="input-group-prepend">
         <span class="input-group-btn">
        
               
               <button type="button" onclick="minusQuantity(${entry.key.id},'${entry.key.price}')" class="btn btn-danger btn-number"  id='removeItem' data-type="minus" data-field="quant[2]">
               <span class="glyphicon glyphicon-minus">-</span>
              </button>
          </span>
          </div>
								<input type="number" id="quantity${entry.key.id}"   class="form-control text-center" value="${entry.value}">
							<div class="input-group-append">
        <span class="input-group-btn">
              <button type="button" onclick="addQuantity(${entry.key.id},'${entry.key.price}')" id='addItem'class="btn btn-success btn-number" data-type="plus" data-field="quant[2]">
                  <span class="glyphicon glyphicon-plus">+</span>
              </button>
          </span>
          </div>
	</div>
							</td>
							<td data-th="Subtotal" class="text-center" id="totalAmt${entry.key.id}">${entry.key.price*entry.value}</td>
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
							
						</tr>
						<tr>
							<td><a href="home" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<!-- <td class="hidden-xs text-center"><strong>Total $${total}</strong></td> -->
							<td><a href="checkout" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</c:if>
<c:if test="${list.size()==0}">
<p>No Items in cart</p>
</c:if>


<script src="JS/autocomplete.js"></script>
<!-- <script src="JS/updateCart.js"></script> -->
<script type="text/javascript">
function addQuantity(id,price) {
	console.log(id);
	
	let ele='#quantity'+id;
	let val=$(ele).val();
	let ele1='#totalAmt'+id;
	console.log(val);
	
	if(val>=10){
		
	}else{
		
	let sum=parseInt(val)+1;
	$(ele).attr('value',sum);
	let total=$(ele).val()*price;
	console.log('total',total);
	$(ele1).html(total);
	//$("button[type=submit]").prop("disabled",false);
	$.ajax({
	    url: 'updateAddCart?id='+id,
	    type: 'POST',
	    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	    success: function (response) {
	    	 console.log('success');
	    },
	    error: function () {
	        console.log('error');
	    }
	});
	
	}
}
function minusQuantity(id,price) {
	console.log(id);
	
	let ele='#quantity'+id;
	let ele1='#totalAmt'+id;
	console.log(ele1);
	let val=$(ele).val();
	console.log(val);
	
	
	if(val<='1'){
		$("input #addButton").prop("disabled",true);
	}else{
		
		let sum=parseInt(val)-1;

		if(sum<='1'){
			$("input #addButton").prop("disabled",true);
		}
		
		$(ele).attr('value',sum);
		let total=$(ele).val()*price;
		console.log('total',total);
		$(ele1).html(total);
		$.ajax({
		    url: 'updateCart?id='+id,
		    type: 'POST',
	
		    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		    success: function (response) {
		    	 console.log('success');
		    },
		    error: function () {
		    	 console.log('error');
		    }
		});
		
	}
}
</script>
</body>
</html>