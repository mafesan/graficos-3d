var value = 500;
var obj = {
    value: 0,
    increment: function() {
      var that = this;
      that.value++;

        var innerFunction = function() {
            console.log(that.value);
        }

        innerFunction(); //Function Invocation Pattern

    }
}

obj.increment(); //Method Invocation Pattern
