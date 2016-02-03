// Constructor Invocation Pattern

var Func1 = function() {
  var obj = {
      objdata : "Hello World A"
    };

  return obj;
}

var Func2 = function() {
    this.data = "Hello World B";
    return 234;
}

var f1 = new Func1(); //f1 is set to obj
var f2 = new Func2(); //f2 is set to a new object

console.log(f1.objdata);
console.log(f2.data);
