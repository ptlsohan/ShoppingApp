<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
      <div class="row justify-content-center">
     
      <div class="card col-sm-5 mt-5  border-0" style="width: 18rem;background-color: rgba(0,0,0,.5); ">
        <img class="card-img-top mt-2" src="${pageContext.request.contextPath}/images/product/${product.image }" style="max-width:100%;max-height:100%;" width="300px" height="400px" alt=".." class="rounded mx-auto d-block col-sm-5 m-1 border-0" alt="...">

      </div>
      <div class="card col-sm-5 mt-5 border-0 " style="width: 18rem;background-color: rgba(0,0,0,.5); color:white; ">

      <div class="card-body">
        <h5 class="card-title font-weight-bold">${product.name}</h5>
        <p class="card-text">price:$${product.price}</p>
        <p class="card-text">${product.companyName}</p>
        <c:if test='${product.category}=="fashion"'>
        <p class="card-text">${product.color}</p>
        </c:if>
        <form action="../addToCart">
        <input type="hidden" name="id" value="${product.id}">
        <input type="hidden" name="category" value="${product.category}">
        
       
        <div class="input-group mb-2 w-50">
        <div class="input-group-prepend">
         <span class="input-group-btn">
        
               
               <button type="button" class="btn btn-danger btn-number"  id='removeItem' data-type="minus" data-field="quant[2]">
               <span class="glyphicon glyphicon-minus">-</span>
              </button>
          </span>
          </div>
          
        <input type="number" class="form-control" id="quantity" name="quantity" min="1" value="1" max="${product.quantity }" oninvalid="this.setCustomValidity('Not in stock. Please remove few item or try again later')" onvalid="this.setCustomValidity('')" onchange="this.setCustomValidity('')"><br>
       <div class="input-group-append">
        <span class="input-group-btn">
              <button type="button"  id='addItem'class="btn btn-success btn-number" data-type="plus" data-field="quant[2]">
                  <span class="glyphicon glyphicon-plus">+</span>
              </button>
          </span>
          </div>
	</div>
        
        
        <input type="submit" id="addButton" data-toggle="modal" data-target="#exampleModal" class="btn btn-primary mt-5 w-100" value="Add to cart">
        </form>
        
      </div>
      </div>
   
  
  <div class="card col-sm-10" style="background-color: rgba(0,0,0,.5); color:white; ">
    <div class="card-header">
  <p class="text-center font-weight-bold"> Product Details</p>
    </div>
    <div class="card-body">
      <table class="table table-borderless">

        <tbody>
        <tr>
          <th ><tag:message code="productName"></tag:message> </th>
          <td> ${product.name}</td>
        </tr>


 <c:if test='${product.category=="mobile"}'>
		<tr>
          <th ><tag:message code="screenSize"></tag:message></th>
          <td>${product.screenSize} </td>
        </tr>
        <tr>
          <th ><tag:message code="processor"></tag:message></th>
          <td>${product.processor}</td>
        </tr>
        <tr>
          <th ><tag:message code="ram"></tag:message></th>
          <td>${product.ram} GB</td>
        </tr>
        
        <tr>
          <th ><tag:message code="os"></tag:message></th>
          <td>${product.os}</td>
        </tr>
        <tr>
          <th ><tag:message code="camera"></tag:message></th>
          <td>${product.camera} </td>
        </tr>
         </c:if>
         
         
         <c:if test='${product.category=="laptop"}'>
		<tr>
          <th ><tag:message code="screenSize"></tag:message></th>
          <td>${product.size} </td>
        </tr>
        <tr>
          <th ><tag:message code="processor"></tag:message></th>
          <td>${product.processor}</td>
        </tr>
        <tr>
          <th ><tag:message code="ram"></tag:message></th>
          <td>${product.ram} GB</td>
        </tr>
        
        <tr>
          <th >SSD</th>
          <td>${product.storageCapacity}</td>
        </tr>
       
         </c:if>
         
         
          <c:if test='${product.category=="book"}'>
		<tr>
          <th ><tag:message code="author"></tag:message></th>
          <td>${product.author} </td>
        </tr>
        <tr>
          <th ><tag:message code="category"></tag:message></th>
          <td>${product.subCategory}</td>
        </tr>
        
       
         </c:if>
         
         
         <c:if test='${product.category=="fashion"}'>
		<tr>
          <th ><tag:message code="category"></tag:message></th>
          <td>${product.gender} </td>
        </tr>
        <tr>
          <th ><tag:message code="color"></tag:message></th>
          <td>${product.color}</td>
        </tr>
         <tr>
          <th ><tag:message code="size"></tag:message></th>
          <td>${product.size}</td>
        </tr>
        
       
         </c:if>
         
         
        </tbody>
      </table>
  </div>
  </div>
   </div>


  <div class="modal fade" id="myModal" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ${sessionScope.addMsg}
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
       
      </div>
    </div>
  </div>
</div>
</div>
<c:if test="${sessionScope.addMsg!=null}">
<script>

$('#myModal').modal('show')
<%session.removeAttribute("addMsg");%>

</script>
</c:if>

<script type="text/javascript">
$(document).ready(function(){
	console.log('doc loaded');
	
		
	
	
	 document.getElementById('removeItem').addEventListener('click',function(e){
		e.preventDefault();
		console.log('button remove clicked');
		let val=$('#quantity').val();
		
		if(val<='0'){
			$("input #addButton").prop("disabled",true);
		}else{
			
			let sum=parseInt(val)-1;

			if(sum<='0'){
				$("input #addButton").prop("disabled",true);
			}
			
			$('#quantity').attr("value",sum);
		}
			
	}); 
	
	document.getElementById('addItem').addEventListener('click',function(e){
		e.preventDefault();
		console.log('button add clicked');
		let val=$('#quantity').val();
		if(val>=10){
			
		}else{
			
		let sum=parseInt(val)+1;
		$('#quantity').attr("value",sum);
		//$("button[type=submit]").prop("disabled",false);
		}
	}
	);
		/* function remove(event){
		console.log(event);
		event.preventDefault();
		let val=$('#quantity').val();
	
		if(val<='0'){
			$("button[type=submit]").prop("disabled",true);
		}else{
			
			let sum=parseInt(val)-1;

			if(sum<='0'){
			//	$("button[type=submit]").prop("disabled",true);
			}
			
			$('#quantity').attr("value",sum);
		}
		 */	 
		
			
		
//	}
	/* function add(e){
		event.preventDefault();
		let val=$('#quantity').val();
		if(val>=10){
			
		}else{
			
		let sum=parseInt(val)+1;
		$('#quantity').attr("value",sum);
		//$("button[type=submit]").prop("disabled",false);
		}
	} */
	 
	
});
</script>
<script src="${pageContext.request.contextPath}/JS/autocomplete.js"></script>

</body>
</html>