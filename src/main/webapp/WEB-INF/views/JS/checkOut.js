let result;
$(document).ready(function() {
	$("button[type=button]").prop("disabled",true);
	$('input[type=radio][name=select]').change(function(){
		console.log(this.value);
		if(this.value==='selectAddress'){
			$("fieldset").prop("disabled",true);
			$("button[type=button]").prop("disabled",false);
		}else if(this.value==='newAddress'){
			$("fieldset").prop("disabled",false);
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
	    	result=data;
	    	console.log('result',result.addressId);
	    	$('#addressId').val(result['addressId']);
	    	$('#street').val(result['street']);
			$('#apt').val(result['apt']);
			$('#city').val(result['city']);
			$('#state').val(result['state']);
			$('#zip').val(result['zip']);
			$('#country').val(result['country']);
			$('#phone').val(result['phone']);
	    	},
	    	error: function(jqXHR, textStatus, errorThrown) {
	    	console.log(textStatus); //error logging
	    	}
	    	});
		
		
		
		
		
		
	});
	
	
});