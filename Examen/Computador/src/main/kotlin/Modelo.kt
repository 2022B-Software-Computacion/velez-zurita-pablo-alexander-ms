import java.util.*
import java.time.LocalDate

class Modelo {
    var id: Int = 0
    var nombre: String = ""
    var fechaLanzamiento: LocalDate? = null
    var precio: Float = 0f
    var descripcion: String = ""

    constructor() {
    }

    constructor(id: Int, nombre: String, fechaLanzamiento: LocalDate?, precio: Float, descripcion: String) {
        this.id = id
        this.nombre = nombre
        this.fechaLanzamiento = fechaLanzamiento
        this.precio = precio
        this.descripcion = descripcion
    }


    override fun toString(): String {
        return "id: $id, Modelo: $nombre,Fecha de lanzamiento: $fechaLanzamiento,  Precio: $$precio \n" +
                "Descripcion: $descripcion"
    }

    fun obtenerAtributos(): String {
        return "$id,$nombre,$fechaLanzamiento,$precio,$descripcion"
    }
}