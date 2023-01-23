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
            ("2") -> {
                mostrarMarca()
            }
            ("3") -> {
                actualizarInformacionMarca()
            }
            ("4") -> {
                eliminarMarca()
            }
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
    print("Escriba el pais matriz de la Marca: ")
    miMarca.paisOrigen = readln()
    print("Escriba la fecha de fundacion de la Marca (yy-mm-dd): ")
    miMarca.fechaFundacion = LocalDate.parse(readln())
    miMarca.listaModelos = agregarListaModelos()
    try {
        archivo = File("Marca.txt")
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

fun mostrarMarca(){
    val listaMarcas = mutableListOf<Marca>()
    try {
        val file = File("Marca.txt")
        val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
        reader.lines().forEach{
            var miListaModelos = mutableListOf<Modelo>()
            //miListaCanciones.clear()
            val tokens = StringTokenizer(it, ",")
            var dato: String = tokens.nextToken()
            val nuevaMarca = Marca()
            nuevaMarca.id = dato.toInt()
            dato = tokens.nextToken()
            nuevaMarca.nombre = dato
            dato = tokens.nextToken()
            nuevaMarca.paisOrigen = dato
            dato = tokens.nextToken()
            nuevaMarca.fechaFundacion = LocalDate.parse(dato)
            // aquí se vuelve a realizar una búsqueda por tokens
            while(tokens.hasMoreTokens()){
                dato = tokens.nextToken()
                miListaModelos.add(obtenerModeloPorId(dato.toInt()))
            }
            nuevaMarca.listaModelos = miListaModelos
            listaMarcas.add(nuevaMarca)
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    listaMarcas.forEach{
        println(it.toString())
    }
}

fun agregarListaModelos(): MutableList<Modelo>{
    var listaModelosNuevos = mutableListOf<Modelo>()
    var aux: Modelo
    var flag = true
    var opcionIf = ""
    while (flag) {
        println("¿Quiere agregar un modelo de la marca?")
        println("Y / N")
        opcionIf = readln()
        if (opcionIf =="N" || opcionIf =="n"){
            return listaModelosNuevos
        }else if (opcionIf =="Y" || opcionIf =="y"){
            println("Ingrese el ID del modelo")
            aux = obtenerModeloPorId(readln().toInt())
            listaModelosNuevos.add(aux)
        }else{
            println("Opcion no reconocida")
        }
    }
    return listaModelosNuevos
}

fun obtenerModeloPorId(id: Int): Modelo{
    val listaModelos = mutableListOf<Modelo>()
    var modelo = Modelo()
    try {
        val file = File("Modelo.txt")
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

fun actualizarInformacionMarca(){
    val listaMarcas = mutableListOf<Marca>()
    println("Introduzca el ID de la marca que desea actualizar")
    val id = readln().toInt()
    // Lee el archivo y genera una lista con las marcas actuales
    val file = File("Marca.txt")
    val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
    reader.lines().forEach {
        var miListaModelos = mutableListOf<Modelo>()
        val tokens = StringTokenizer(it, ",")
        var dato: String = tokens.nextToken()
        val nuevaMarca = Marca()
        nuevaMarca.id = dato.toInt()
        dato = tokens.nextToken()
        nuevaMarca.nombre = dato
        dato = tokens.nextToken()
        nuevaMarca.paisOrigen = dato
        dato = tokens.nextToken()
        nuevaMarca.fechaFundacion = LocalDate.parse(dato)
        // aquí se vuelve a realizar una búsqueda por tokens
        while(tokens.hasMoreTokens()){
            dato = tokens.nextToken()
            miListaModelos.add(obtenerModeloPorId(dato.toInt()))
        }
        nuevaMarca.listaModelos = miListaModelos
        listaMarcas.add(nuevaMarca)
    }
    var marcaAux = Marca()
    listaMarcas.forEach {
        if (it.id == id){
            marcaAux = it
        }
    }
    val indiceMarca = listaMarcas.indexOf(marcaAux)
    // Eliminamos el album anterior
    listaMarcas.remove(marcaAux)
    // Actualizamos la cancion
    print("Escriba el id de la Marca: ")
    marcaAux.id = readln().toInt()
    print("Escriba el nuevo nombre de la Marca: ")
    marcaAux.nombre = readln()
    print("Escriba el nuevo pais matriz de la Marca: ")
    marcaAux.paisOrigen = readln()
    print("Escriba la nueva fecha de fundacion de la Marca (yy-mm-dd): ")
    marcaAux.fechaFundacion = LocalDate.parse(readln())
    // Añadimos el album actualizado
    listaMarcas.add(indiceMarca, marcaAux)

    //println(listaAlbumes)

    // Vamos a reescribir toodo el archivo
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    try {
        archivo = File("Marca.txt")
        fw = FileWriter(archivo)
        pw = PrintWriter(fw)
        listaMarcas.forEach {
            pw.println(it.obtenerAtributos())
        }
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

fun eliminarMarca(){
    val listaMarcas = mutableListOf<Marca>()
    println("Introduzca el ID del album que desea eliminar")
    val id = readln().toInt()
    // Lee el archivo y genera una lista con las marcas actuales
    val file = File("Marca.txt")
    val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
    reader.lines().forEach {
        var miListaModelos = mutableListOf<Modelo>()
        val tokens = StringTokenizer(it, ",")
        var dato: String = tokens.nextToken()
        val nuevaMarca = Marca()
        nuevaMarca.id = dato.toInt()
        dato = tokens.nextToken()
        nuevaMarca.nombre = dato
        dato = tokens.nextToken()
        nuevaMarca.paisOrigen = dato
        dato = tokens.nextToken()
        nuevaMarca.fechaFundacion = LocalDate.parse(dato)
        // aquí se vuelve a realizar una búsqueda por tokens
        while(tokens.hasMoreTokens()){
            dato = tokens.nextToken()
            miListaModelos.add(obtenerModeloPorId(dato.toInt()))
        }
        nuevaMarca.listaModelos = miListaModelos
        listaMarcas.add(nuevaMarca)
    }
    var marcaAux = Marca()
    listaMarcas.forEach {
        if (it.id == id){
            marcaAux = it
        }
    }
    listaMarcas.remove(marcaAux)
    // Ya se tiene una lista sin el elemento
    // Vamos a reescribir toodo el archivo
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    try {
        archivo = File("Marca.txt")
        fw = FileWriter(archivo)
        pw = PrintWriter(fw)
        listaMarcas.forEach {
            pw.println(it.obtenerAtributos())
        }
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