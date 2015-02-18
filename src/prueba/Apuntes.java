int a //Variables de instancia
final int a 
/*
No lo puedes cambiar una vez asignado. -->variable solo lectura (diferencia con la anterior, que no la puedes cambiar)
*/
static int a       
/*
static-->variables de clase, propias de una clase y no del objeto, y se puede cambiar
*/

static final int a  
/*
variable de clase que no puede cambiar --> esto es una constante, ejemplo: constantes matemáticas
*/

/*
Segun el estándar de Java
las variables siempre deben ser private
y los métodos heredados, tienen que ser protected o public
Si otras clases van a heredar de esta, los métodos deben ser protected
y si no, public.

Mirar 'getters' y 'setters'


¿que entra en el examen?
-Lo que haya en las transparencias, todo.
-Ver array lists
-tipos de variables, constantes, public, private, etc.
-¿porque esto no compila?
-Herencia, clases
-javaranch --> examenes del estilo que suelen hacer. (rancho de java)
-orientación a objetos -- mucho!
-visibilidad, encapsulación, polimorfismo
-padre = padre, padre = hijo, etc.
-en una herencia faltan 3 palabras, ¿cuales?



Un metodo estático (static) no puede tener un this.
El único método que debería ser estático es el main. 
(no mas clases ni variables, ni métodos).

Si al declarar una variable, no pones nada
como int a;
automaticamente se declara como public, y no nos interesa.
public es visible desde fuera y desde el resto de las clases.

private int a;
Una clase que herede de la que tiene a, desde la clase hija no 
puedo cambiarlo. (Desde la padre si)
Puedo acceder a ese valor o cambiarlo con set y get.
Tambien puedo ponerlo protected. --> de cara a fuera de las clases
es privado, pero se comporta como publico para las clases que heredan,
Asi que podemos acceder a 'a' sin usar métodos como get o set.

SIEMPRE HAY QUE PONER A UNA VARIABLE SU ÁMBITO DE VISIBILIDAD
(NO DEJAR NADA SIN PONER)

*/

EJEMPLO:

public class A{
	int x;
	
	public void setvavue(int x){
		// x = x; esto es lo mismo, pero queda mal
		this.x = x;
	}

