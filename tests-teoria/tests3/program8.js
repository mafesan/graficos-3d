// Apply Invocation pattern

var add = function(num1, num2) {
        return num1+num2;
}

array = [3,4];

console.log(add.apply(null,array));
