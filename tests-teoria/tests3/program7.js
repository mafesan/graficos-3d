var person = {
    "First_Name": "Barry",
    "Last_Name": "Steyn",
    "do_Something": function() { alert('something'); }
}

console.log(person.age);

Object.prototype.age = 56;

console.log(person.age);
