<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>




    <div class="container">
      <c:if test="${ error!=null }">
<div class="alert alert-danger" role="alert">
	<div style="color:red">${error}</div>
	</div>
	</c:if>

      <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">Your cart</span>
            <span class="badge badge-secondary badge-pill">${list.size()}</span>
          </h4>
          <ul class="list-group mb-3">
          <c:forEach items="${list}" var="entry">
            <li class="list-group-item d-flex justify-content-between lh-condensed" style="background-color: rgba(255,255,255,0.6)">
              <div>
                <h6 class="my-0">${entry.key.name}</h6>
                <small class="text-muted"> $${entry.key.price} x ${entry.value}</small>
              </div>
              <span class="text-muted">${entry.key.price*entry.value}</span>
            </li>
            </c:forEach>
           
            
            <li class="list-group-item d-flex justify-content-between" style="background-color: rgba(255,255,255,0.6)">
              <span>Total (USD)</span>
              <strong>$${total}</strong>
            </li>
          </ul>

          
        </div>
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3">Shipping address</h4>
          <form action="makePayment" id="checkout" class="needs-validation" novalidate="">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required="">
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required="">
                <div class="invalid-feedback">
                  Valid last name is required.
                </div>
              </div>
            </div>


		<div>
            <input type="radio" id="selectAddress"
                   name="select" value="selectAddress"  />
            <label for="selectAddress">Select existing Address</label>
        </div>

        <div>
            <input type="radio" id="newAddress"
                   name="select" value="newAddress" checked/>
            <label for="newAddress">Add newAddress</label>
        </div>
		<button type="button" id="showList" class="btn btn-info" data-toggle="modal" data-target="#exampleModalCenter">Select address</button>
            
	 <fieldset >
	 <input type="hidden" id="addressId" name="addressId" >
            <div class="mb-3">
              <label for="street">Street</label>
              <input type="text" class="form-control" id="street" name="street" placeholder="1234 Main St" required="">
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <div class="mb-3">
              <label for="apt">Apt </label>
              <input type="text" class="form-control" id="apt" name="apt" placeholder="Apartment or suite">
            </div>
            
            <div class="mb-3">
              <label for="city">City </label>
              <input type="text" class="form-control" id="city" name="city" placeholder="City">
            </div>

            <div class="row">
              <div class="col-md-5 mb-3">
                <label for="state">State </label>
              <input type="text" class="form-control" id="state" name="state" placeholder="State">
              </div>
              <div class="col-md-4 mb-3">
                <label for="country">Country </label>
              <input type="text" class="form-control" id="country" name="country" placeholder="Country">
              </div>
              <div class="col-md-3 mb-3">
                <label for="zip">Zip</label>
                <input type="text" class="form-control" id="zip" name="zip" placeholder="" required="">
                <div class="invalid-feedback">
                  Zip code required.
                </div>
              </div>
            </div>
            <div class="mb-3">
              <label for="phone">Phone </label>
              <input type="text" class="form-control" id="phone" name="phone" placeholder="phone">
            </div>
           </fieldset>
           
           
            <hr class="mb-4">

            <h4 class="mb-3">Payment</h4>

            
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="fullName">Name on card</label>
                <input type="text" class="form-control" id="fullName" name="fullName" placeholder="" required="">
                <small class="text-muted">Full name as displayed on card</small>
                <div class="invalid-feedback">
                  Name on card is required
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="cc-number">Credit card number</label>
                <input type="text" class="form-control" id="cardNum" name="cardNum" placeholder="" required="">
                <div class="invalid-feedback">
                  Credit card number is required
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">Expiration</label>
                <input type="text" class="form-control" id="expDate" name="expDate" placeholder="" required="">
                <div class="invalid-feedback">
                  Expiration date required
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">CVV</label>
                <input type="text" class="form-control" id="cardCvv" name="cardCvv" placeholder="" required="" size="3">
                <div class="invalid-feedback">
                  Security code required
                </div>
              </div>
            </div>
            <hr class="mb-4">
            <input type="hidden" name="totalAmt" value="${total}">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Make Payment</button>
          </form>
        </div>
      </div>

      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">© 2017-2018 Shopping App</p>
        <ul class="list-inline">
          <li class="list-inline-item"><a href="#">Privacy</a></li>
          <li class="list-inline-item"><a href="#">Terms</a></li>
          <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
      </footer>
    </div>

  
  
  <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Select Address</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
       <c:forEach items="${addresses}" var="entry">
            <li class="list-group-item d-flex justify-content-between lh-condensed">
             
             
              <div>
                <h6 class="my-0"> <div>
            <input type="radio" id="${entry}"
                   name="addressList" 
     value="${entry.addressId }"  />
            <label for="${entry}">${entry.street} ${entry.apt} </label>
        </div></h6>
                
              </div>
             
            </li>
            </c:forEach>
      
       

       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Done</button>
       
      </div>
    </div>
  </div>
</div>
  

<script type="text/javascript" src="JS/checkOut.js">
<!--

//-->
</script>
<script src="JS/autocomplete.js"></script>

</body>
</html>