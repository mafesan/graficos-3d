//Method Invocation Pattern

var obj = {
    value: 0,
    increment: function() {
        this.value+=1;
    }
};

obj.increment();

console.log(obj.value);
