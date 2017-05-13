var numbers = [1,2,3,4,5,6]

var newarray=numbers.filter(function(number){
	return number%2==0;
})

console.log(newarray);

