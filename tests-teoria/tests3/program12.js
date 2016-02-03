//Closures

var incrementer = function(s) {
  var start = s;

  return {
    increment: function() {
      start = start + 1;
    },
    getValue: function() {
      return start;
    }
  }
}

var inc0 = incrementer(0);
var inc8 = incrementer(8);

inc0.increment();
inc8.increment();

console.log(inc0.getValue());
console.log(inc8.getValue());
