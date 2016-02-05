function User(name, login) {
  this.name = name;
  this.login = login;
}

User.prototype.toString = function() {
  return "[User: "+ this.name +": "+this.login+"]";
};

User.prototype.checkLogin = function(login) {
  return this.login === login;
};

var u1 = new User("paco", "fmartin");
var u2 = new User("gorka", "paurea");

console.log(u1.toString());
console.log(u2.toString());

console.log(u1.checkLogin("paco"));
console.log(u1.checkLogin("pisha"));
console.log(u2.checkLogin("paco"));
console.log(u2.checkLogin("paurea"));
