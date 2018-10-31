let value;
$(document).ready(function() {
	$("button[type=button]").prop("disabled",true);
	$('input[type=radio][name=select]').change(function(){
		
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
		
	//	result=JSON.parse(this.value);

		$.ajax("fetchAddress?id="+this.value, {
	    	dataType: 'json',
	    	success: function(data) {
	    	console.log(data['street']);
	    	value=data;
	    	
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
		
		
		
		
		
		
	});
	
	$('#checkout').validate({
		rules: {	
			firstName: {
				required: true,
				minlength: 2,
				lettersonly: true
			},
			lastName: {
				required: true,
				minlength: 2,
				lettersonly: true
			},
			street: {
				required: true,
				minlength: 2
			},
			apt: {
				required: true,
				minlength: 2
			},
			city: {
				required: true,
				minlength: 2
			},
			state: {
				required: true,
				minlength: 2
			},
			country: {
				required: true,
				minlength: 2
			},
			phone: {
				required: true,
				minlength: 2
			},
			fullname:{
				lettersonly: true	
			},
			cardNum:{
				creditcard: true
			},
			cardCvv: {
				integer: true
			},
			expDate :{
				dateNL: true
			},
			phone :{
				phoneUS: true
			}
			
		},
		messages:{
			firstName: {
				required: "Please enter your first name"
			}
		}
	});
	
	$.validator.addMethod( "integer", function( value, element ) {
		return this.optional( element ) || value.length < 4 && value.match(/^[0-9]{3}$/);
	}, "Please enter valid cvv number" );
	
	$.validator.addMethod( "phoneUS", function( phone_number, element ) {
		phone_number = phone_number.replace( /\s+/g, "" );
		return this.optional( element ) || phone_number.length > 9 &&
			phone_number.match( /^(\+?1-?)?(\([2-9]([02-9]\d|1[02-9])\)|[2-9]([02-9]\d|1[02-9]))-?[2-9]\d{2}-?\d{4}$/ );
	}, "Please specify a valid phone number" );
	
	$.validator.addMethod( "creditcard", function( value, element ) {
		if ( this.optional( element ) ) {
			return "dependency-mismatch";
		}

		// Accept only spaces, digits and dashes
		if ( /[^0-9 \-]+/.test( value ) ) {
			return false;
		}

		var nCheck = 0,
			nDigit = 0,
			bEven = false,
			n, cDigit;

		value = value.replace( /\D/g, "" );

		// Basing min and max length on
		// https://dev.ean.com/general-info/valid-card-types/
		if ( value.length < 13 || value.length > 20 ) {
			return false;
		}

		for ( n = value.length - 1; n >= 0; n-- ) {
			cDigit = value.charAt( n );
			nDigit = parseInt( cDigit, 10 );
			if ( bEven ) {
				if ( ( nDigit *= 2 ) > 9 ) {
					nDigit -= 9;
				}
			}

			nCheck += nDigit;
			bEven = !bEven;
		}

		return ( nCheck % 10 ) === 0;
	}, "Please enter a valid credit card number." );
	
	$.validator.addMethod( "lettersonly", function( value, element ) {
		return this.optional( element ) || value.match(/^[a-z]+$/);
	}, "Letters only please" );
	
	$.validator.addMethod( "dateNL", function( value, element ) {
		return this.optional( element ) || /^(0[1-9]|1[0-2])\/([0-9]{4}|[0-9]{2})$/.test( value );
	}, $.validator.messages.date );
	
	
	
});