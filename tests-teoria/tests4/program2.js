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

function AdvancedUser(name, login) {
  this.name = name;
  this.login = login;
};

AdvancedUser.prototype = new User(); //inherit User methods

var u1 = new AdvancedUser("paco", "fmartin");
console.log(u1.toString());

var u2 = Object.create(u1);
u2.age = 22;
console.log(u2.age);
console.log(u1.age);
