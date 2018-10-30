let result;
$(document).ready(function() {
	console.log('autocomplete loaded');
	 $('#keyword').keyup(function(event) {
		 console.log('akey up');
         var name = $('#keyword').val();
         $.get('autocomplete', {
                 keyword : name
         }, function(data) 
         {
         
         	 result = $.map(data, function (d){
                 return d;
                 });
        });
         $("#keyword").autocomplete({
             source: result
           });
        
	 } );	
//	$('#keyword').keyup(function(event) {
//	console.log($('#keyword').val());
//	
////	$.get('autocomplete', {
////      keyword : keyword
////	}, function(data){
////		console.log(data);
////	});
//	
//	$.ajax("autocomplete?keyword=", {
//    	dataType: "json",
//    	data: 'sam',
//    	success: function(data) {
//    	console.log(data);
//    	list:data
//    	},
//    	error: function(jqXHR, textStatus, errorThrown) {
//    	console.log(textStatus); //error logging
//    	}
//    	});
//	
//	
//	result=['samsiung']
//	$("#keyword").autocomplete({
//      source: result
//    });
//	});
	
});