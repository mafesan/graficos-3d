var value = 500;
var obj = {
    value: 0,
    increment: function() {
        this.value++;
        //Este this hace referencia al objeto donde vive esta funcion
        var innerFunction = function() {
            console.log(this.value);
            //Este this se refiere al objeto global, no donde vive!
        }

        innerFunction(); //Function Invocation Pattern

    }
}

obj.increment(); //Method Invocation Pattern
