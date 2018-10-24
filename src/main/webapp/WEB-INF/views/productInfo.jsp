<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
      <div class="row justify-content-center">
      <div class="card col-sm-5 m-1 border-0" style="width: 18rem;">
        <img class="card-img-top" src="${pageContext.request.contextPath}/images/product.png" width="200px" height="200px" alt=".." class="rounded mx-auto d-block col-sm-5 m-1 border-0" alt="...">

      </div>
      <div class="card col-sm-5 m-1 border-0" style="width: 18rem;">

      <div class="card-body">
        <h5 class="card-title">${product.name}</h5>
        <p class="card-text">price:$${product.price}</p>
        <p class="card-text">${product.companyName}</p>
        <c:if test='${product.category}=="fashion"'>
        <p class="card-text">${product.color}</p>
        </c:if>
        <form action="../addToCart">
        <input type="hidden" name="id" value="${product.id}">
        <input type="hidden" name="category" value="${product.category}">
        <input type="number" name="quantity" min="1" value="1"><br>
        
        <input type="submit" data-toggle="modal" data-target="#exampleModal" class="btn btn-primary" value="Add to cart">
        </form>
        
      </div>
      </div>
    </div>
    
  <div class="card ">
    <div class="card-header">
   Product Details
    </div>
    <div class="card-body">
      <table class="table table-borderless">

        <tbody>
        <tr>
          <th >Product </th>
          <td>${product.companyName} ${product.name}</td>
        </tr>

		<tr>
          <th >Screen size</th>
          <td>${product.screenSize} </td>
        </tr>
        <tr>
          <th >Processor</th>
          <td>${product.processor}</td>
        </tr>
        <tr>
          <th >Ram</th>
          <td>${product.ram} GB</td>
        </tr>
        
        <tr>
          <th >Operating System</th>
          <td>${product.os}</td>
        </tr>
        <tr>
          <th >Camera</th>
          <td>${product.camera} </td>
        </tr>
         
        </tbody>
      </table>
  </div>
  </div>


  <div class="modal fade" id="myModal" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
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

</body>
</html>