// Apply Invocation pattern

var obj = {
    data:'Hello World'
}

var displayData = function() {
    console.log(this.data);
}

displayData(); //undefined
displayData.apply(obj); //Hello World
