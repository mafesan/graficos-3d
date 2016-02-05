var array_numeros = ["cero", "uno", "dos", "tres", "cuatro"];
var obj_numeros = {
  0: "cero",
  1: "uno",
  2: "dos",
  3: "tres",
  4: "cuatro"
};

console.log(array_numeros);
console.log(obj_numeros);

console.log(array_numeros[2]);
console.log(obj_numeros[2]);

console.log(array_numeros.length); //hereda de Array.prototype
console.log(obj_numeros.length); //hereda de Object.prototype; no tiene length


array_numeros[1000] = "mil";
console.log(array_numeros.length);

console.log(array_numeros[94]);
console.log(array_numeros[1000]);

array_numeros[array_numeros.length] = "mil uno";
array_numeros.push("mil dos");

array_numeros = ["cero", "uno", "dos", "tres", "cuatro"];
delete(array_numeros[2]);
console.log(array_numeros);

array_numeros = ["cero", "uno", "dos", "tres", "cuatro"];
array_numeros.splice(2, 1);
console.log(array_numeros);

array_numeros = ["cero", "uno", "dos", "tres", "cuatro"];
array_numeros.splice(2, 1, "dos y un poco", "dos y medio");
console.log(array_numeros);

var matrix = [[1, 2],[3, 4]];
console.log(matrix[1][0]);


array_numeros = ["cero", "uno", "dos", "tres", "cuatro"];
var otro_array = array_numeros.concat(["cinco", 6])
console.log(otro_array);

var cadena = otro_array.join(":");
console.log(cadena);
console.log(typeof cadena);

array_numeros = ["cero", "uno", "dos", "tres", "cuatro"];
var num = array_numeros.pop();
console.log(array_numeros);
console.log(num);
