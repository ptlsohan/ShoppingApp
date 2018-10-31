$().ready(function(){
	
$('#login').validate({
	rules: {	
		username: {
			required: true,
			minlength: 2
		},
		password:{
			required: true,
			minlength: 5
			
		}
	},
	messages:{
		username: {
			required: "Please enter your username"
		}
	}
});

});