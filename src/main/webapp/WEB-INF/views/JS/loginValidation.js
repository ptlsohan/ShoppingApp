$().ready(function(){
$('form').validate({
	rules: {	
		email: {
			required: true
		},
		password:{
			required: true
			
		}
	},
	messages:{
		email: {
			required: "Please enter your Email"
		}
	}
});
alert("hello");
});