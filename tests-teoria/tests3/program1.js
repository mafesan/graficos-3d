//Function Invocation Pattern

var pi=3.141592;

var deg2Rad = function(deg) {
  return deg*this.pi/180.0;
}

var res = deg2Rad(90);

console.log(res);
