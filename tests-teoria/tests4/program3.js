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

AdvancedUser.prototype = new User();
AdvancedUser.prototype.setLogin = function(newlogin) {
  this.login = newlogin;
}

var u1 = new AdvancedUser("paco", "fmartin");
u1.setLogin("fm4rt1n");
console.log(u1.toString());

var u0 = new User("gorka", "paurea");
console.log(u0.toString());
u0.setLogin("paureabis");
