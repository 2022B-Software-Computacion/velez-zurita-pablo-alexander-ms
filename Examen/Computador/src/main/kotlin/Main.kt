import java.io.*
import java.time.LocalDate
import java.util.*

fun main(){
    var opcion = ""
    do {
        println("## MARCAS DE COMPUTADOR ##")
        println("1.- Ingresar una nueva Marca")
        println("2.- Listar Marcas ingresadas")
        println("3.- Actualizar una Marca ingresada")
        println("4.- Eliminar una Marca ingresada")
        println("-------------------------------------")
        println("## MODELOS DE COMPUTADOR ##")
        println("5.- Ingresar un nuevo Modelo")
        println("6.- Listar Modelos ingresados")
        println("7.- Actualizar un Modelo ingresado")
        println("8.- Eliminar un Modelo ingresado")
        println("9.- Finalizar programa")
        println("Ingrese una opcion")

        opcion = readln().toString()

        when (opcion){
            ("1") -> {
                registrarMarca()
            }
            ("2") -> println("Opcion 2")
            ("3") -> println("Opcion 3")
            ("4") -> println("Opcion 4")
            ("5") -> println("Opcion 5")
            ("6") -> println("Opcion 6")
            ("7") -> println("Opcion 7")
            ("8") -> println("Opcion 8")
            ("9") -> {
                println("Hemos salido")
            }
            else -> println("Opción no válida")
        }
    } while (opcion != "9")
}

fun registrarMarca(){
    var miMarca = Marca()
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    // Obtener los datos de la Marca
    print("Escriba el id de la Marca: ")
    miMarca.id = readln().toInt()
    print("Escriba el nombre de la Marca: ")
    miMarca.nombre = readln()
    print("Escriba la fecha de fundacion de la Marca (yy-mm-dd): ")
    miMarca.fechaFundacion = LocalDate.parse(readln())
    miMarca.listaModelos = agregarListaModelos()
    try {
        archivo = File("Marcas.txt")
        fw = FileWriter(archivo, true)
        pw = PrintWriter(fw)
        //
        pw.println(miMarca.obtenerAtributos())

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun agregarListaModelos(): MutableList<Modelo>{
    var listaModelosNuevos = mutableListOf<Modelo>()
    var aux: Modelo
    var flag = true
    while (flag) {
        println("¿Quiere agregar un modelo de la marca?")
        println("Y / N")
        if (readln().equals("N")){
            return listaModelosNuevos
        }else{
            println("Ingrese el ID del modelo")
            aux = obtenerModeloPorId(readln().toInt())
            listaModelosNuevos.add(aux)
        }
    }
    return listaModelosNuevos
}

fun obtenerModeloPorId(id: Int): Modelo{
    val listaModelos = mutableListOf<Modelo>()
    var modelo = Modelo()
    try {
        val file = File("Modelos.txt")
        val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
        reader.lines().forEach {
            val tokens = StringTokenizer(it, ",")
            var dato: String = tokens.nextToken()
            val nuevoModelo = Modelo()
            nuevoModelo.id = dato.toInt()
            dato = tokens.nextToken()
            nuevoModelo.nombre = dato
            dato = tokens.nextToken()
            nuevoModelo.fechaLanzamiento = LocalDate.parse(dato)
            dato = tokens.nextToken()
            nuevoModelo.precio = dato.toFloat()
            dato = tokens.nextToken()
            nuevoModelo.descripcion = dato.toString()
            listaModelos.add(nuevoModelo)
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    listaModelos.forEach {
        if(it.id == id){
            modelo = it
        }
    }
    return modelo
}