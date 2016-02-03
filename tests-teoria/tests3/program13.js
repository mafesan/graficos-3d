var closure = function() {

    var counter = 0;

    return {
        getCounter : function() { return counter;},
        increment : function(inc) {
            if (typeof inc !== 'number')
                inc = 1;

            counter += inc;
        }
    };
} (); //<-------------- () invokes the function

closure.increment(10);

console.log(closure.getCounter()); 
