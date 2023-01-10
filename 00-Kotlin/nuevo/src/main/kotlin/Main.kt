import java.util.*
import kotlin.collections.ArrayList

//Main.kt
fun main() {
    println("Hola mundo")
    //Tipos de variables

    //INMUTABLES (No Re Asignar) =
    val inmutable: String = "Pablo";
    //inmutable = "Alexander"; //No se puede reasignar

    //MUTABLES (Re Asignar) =
    var mutable: String = "Kevin"
    mutable = "Daniel"

    //val > var

    //Sintax Duck typing
    val ejemploVariable = "Ejemplo"
    val edadEjemplo: Int = 12
    ejemploVariable.trim()

    //Variables primitivas
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    val mayorEdad: Boolean = true
    //Clases JAVA
    val fechaNacimiento: Date = Date()

    //If else
    if (true) {
    } else {
    }

    // switch no existe
    val estadoCivilWhen = "S"
    when (estadoCivilWhen) {
        ("S") -> {
            println("acercarse")
        }
        "C" -> {
            println("alejarse")
        }
        "UN" -> println("hablar")
        else -> println("No reconocido")
    }

    //If en una linea
    val coqueteo = if (estadoCivilWhen == "S") "SI" else "NO"

    val sumaUno = Suma(1, 1);
    val sumaUDos = Suma(null, 1);
    val sumaTres = Suma(1, null);
    val sumaCuatro = Suma(null, null);
    sumaUno.sumar()
    sumaUDos.sumar()
    sumaTres.sumar()
    sumaCuatro.sumar()
    Suma.pi
    Suma.elevarAlCuadrado(2)
    println(Suma.historialSumas)


    //ARREGLOS

    //TIPOS DE ARREGLOS

    //Arreglos Estaticos
    val arregloEstatico: Array<Int> = arrayOf<Int>(1, 2, 3)
    println(arregloEstatico)

    //ArregloDinamico
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    //OPERADORES -> Sirven para los arreglos estaticos y Dinamicos

    //FOR EACH -> Unit
    //Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico
        .forEach{
            valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    arregloEstatico
        .forEachIndexed() { indice: Int, valorActual: Int ->
            println("Valor ${valorActual} Indice: ${indice}")
        }
    println(respuestaForEach)

    // MAP -> Muta el arreglo (Cambia el arreglo)
    //1) Enviemos el nuevo




    //Filter -> FILTRAR EL ARREGLO
    //1) Devolver una expresion (TRUE o FALSE)
    // 2)Nuevo arreglo filtrado
    val respuestaFilter: List<Int> = arregloDinamico
        .filter { valorActual: Int ->
            val mayoresACinco: Boolean = valorActual > 5//Expresin Condicion
            return@filter mayoresACinco
        }
    val respuestaFilterDos = arregloDinamico.filter { it <= 5 }
    println(respuestaFilter)
    println(respuestaFilterDos)

    // OR AND
    // OR -> ANY (alguno cumple?)
    // AND -> ALL (Todos cumplen?)

    val respuestaAny: Boolean = arregloDinamico
        .any {valorActual: Int ->
            return@any (valorActual > 5)
        }
    println(respuestaAny) //true

    val respuestaAll: Boolean = arregloDinamico
        .all { valorActual: Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll) // false

    //REDUCE -> Valor acumulado
    // Valor acumulado = 0 (Siempre 0 en ñenguaje Kotlin)
    // [1, 2, 3, 4, 5] -> Sumeme todos los valores del arreglo
    // valorIteracion1 = valor Empieza + 1 = 0 + 1 = 1 -> Iteracion 1
    // valorIteracion2 = valorIteracion1 + 2 = 1 + 2 = 3 -> Iteracion 2
    // valorIteracion3 = valorIteracion2 + 3 = 3 + 3 = 6 -> Iteracion 3
    // valorIteracion4 = valorIteracion3 + 4 = 6 + 4 = 10 -> Iteracion 4
    // valorIteracion5 = valorIteracion4 + 5 = 10 + 5 = 15 -> Iteracion 5

    val respuestaReduce: Int = arregloDinamico
        .reduce { //acumulado = 0 -> SIEMPRE EMPIEZA EN 0
                acumulado: Int, valorActual: Int ->
            return@reduce (acumulado + valorActual) //-> Logica negocio
        }
    println(respuestaReduce) //78






    //Unit == void
    fun imprimirNombre(nombre: String): Unit {
        println("Nombre: ${nombre}")
    }

    fun calcularSueldo(
        sueldo: Double, //Requerido
        tasa: Double = 12.00, //Opcional (Defecto)
        bonoEspecial: Double? = null, // Opcional (Null) -> nullable
    ): Double {
        //String -> String?
        //Int -> Int?
        //Date -> Date?
        if (bonoEspecial == null) {
            return sueldo * (100 / tasa)
        } else {
            return sueldo * (100 / tasa) + bonoEspecial
        }
    }
}
    abstract class NumerosJava{
        protected val numeroUno: Int
        private val numeroDos: Int

        constructor(
            uno: Int,
            dos: Int
        ){ // Bloque codigo constructor
            this.numeroUno = uno
            this.numeroDos = dos
            println("Inicializado")
        }
    }

abstract class Numeros (// Constructor Primario
        // uno: Int, //Parametro
        // public var uno: Int, //Propiedd de la clase publica
        // var uno: Int, //Propiedad de la clase publica
        protected val numeroUno: Int,
        protected val numeroDos: Int
        ){
   // protected val numeroUno: Int
    // var cedula: String = ""
    // var cedula: String = ""
    init{ // Bloque codigo constructor Primario
        //this.numeroUno = uno
        this.numeroUno
        numeroUno
        this.numeroDos
        numeroDos
        println("Inicializado")
    }
}

class Suma( //Constructor Primario SUma
    uno: Int, //Parametro
    dos: Int //Parametro
): Numeros(uno, dos){
    init{ // Bloque codigo constructor Primario
        this.numeroUno
        this.numeroDos
    }
    constructor( //Segundo constructor
        uno: Int?, //Parametro
        dos: Int //Parametro
    ):this( //llamada constructor primario
        if(uno == null) 0 else uno,
        dos
    ){

    }
    constructor( //Segundo constructor
        uno: Int, //Parametro
        dos: Int? //Parametro
    ):this( //llamada constructor primario
        uno,
        if(dos == null) 0 else uno,
    ){

    }
    constructor( //Segundo constructor
        uno: Int?, //Parametro
        dos: Int? //Parametro
    ):this( //llamada constructor primario
        if(uno == null) 0 else uno,
        if(dos == null) 0 else dos,
    ){

    }
    public fun sumar():Int{
        return numeroUno + numeroDos
    }
    companion object { //Atributos y Metodos "Compartidos" entre las instancias
        val pi = 3.14
        fun elevarAlCuadrado(num: Int): Int{
            return num * num
        }
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(valorNuevaSuma: Int){
            historialSumas.add(valorNuevaSuma)
        }
    }
}
