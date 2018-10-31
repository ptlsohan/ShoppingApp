$().ready(function(){
	console.log('form validation');
$('#register').validate({
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
	min:8,
	max:100
	},
password: {
required: true,
minlength: 5
},
confirmPassword: {
required: true,
minlength: 5,
equalTo: password
}
},
messages: {
confirm_password: {
	equalTo: "please enter the same password"
}
}

});

});
