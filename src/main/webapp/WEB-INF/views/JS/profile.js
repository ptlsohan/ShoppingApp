$().ready(function(){
	console.log('login validation');
$('#profile').validate({
	rules: {	
		firstName: {
			required: true,
			minlength: 2
		},
		lastName: {
			required: true,
			minlength: 2
		},
		age:{
			min: 8,
			max: 100
		}
		
	},
	messages:{
		firstName: {
			required: "Please enter your first name"
		}
	}
});

});