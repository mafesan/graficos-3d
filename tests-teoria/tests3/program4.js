// Constructor Invocation Pattern

function Imaginario(real, imaginario) {
  this.real = real;
  this.imaginario = imaginario;

  this.modulo = function(){
    return Math.sqrt(this.real*this.real+this.imaginario* this.imaginario);
  }
}

function main() {

    var numero = new Imaginario(4,4);
    var otro_numero = new Imaginario(5,5);

    var diff = function(numA, numB) {
      return numA.modulo() -  numB.modulo();
    }

    console.log(numero.real);
    console.log(otro_numero.real);
    console.log(numero.modulo());
    console.log(otro_numero.modulo());

    console.log(diff(numero, otro_numero));

}

main();
