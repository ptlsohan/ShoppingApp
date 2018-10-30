let value;
$(document).ready(function() {
	$("button[type=button]").prop("disabled",true);
	$('input[type=radio][name=select]').change(function(){
		console.log(this.value);
		if(this.value==='selectAddress'){
			$("fieldset").prop("readOnly",true);
			$("button[type=button]").prop("disabled",false);
		}else if(this.value==='newAddress'){
			$("fieldset").prop("readOnly",false);
			$("button[type=button]").prop("disabled",true);
			$('#addressId').val(null);
	    	$('#street').val(null);
			$('#apt').val(null);
			$('#city').val(null);
			$('#state').val(null);
			$('#zip').val(null);
			$('#country').val(null);
			$('#phone').val(null);
			
		}
	});
	
	$('input[type=radio][name=addressList]').change(function(){
		console.log(this.value);
	//	result=JSON.parse(this.value);

		$.ajax("fetchAddress?id="+this.value, {
	    	dataType: 'json',
	    	success: function(data) {
	    	console.log(data['street']);
	    	value=data;
	    	console.log('result',value.addressId);
	    	$('#addressId').val(value['addressId']);
	    	$('#street').val(value['street']);
			$('#apt').val(value['apt']);
			$('#city').val(value['city']);
			$('#state').val(value['state']);
			$('#zip').val(value['zip']);
			$('#country').val(value['country']);
			$('#phone').val(value['phone']);
	    	},
	    	error: function(jqXHR, textStatus, errorThrown) {
	    	console.log(textStatus); //error logging
	    	}
	    	});
		
		console.log('result',value.street);
		
		
		
		
	});
	
	
});