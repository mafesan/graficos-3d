
var add = function() {
    var i;
    var sum=0;

    for(i=0; i<arguments.length; i++)
    {
      if(typeof arguments[i] === 'number') {
        sum += arguments[i];
      }
      else {
        throw {
          name: 'typeError',
          message: 'Argument '+i+"("+arguments[i]+') is not a number'
        }
      }
    }

    return sum;
}

try {
  console.log( add(1,2,3,4,5,"seis",7,8,9) );
} catch (e) {
  console.log(e.name +": "+e.message);
}
