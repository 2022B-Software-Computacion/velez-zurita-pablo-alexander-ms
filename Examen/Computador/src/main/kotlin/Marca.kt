import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.time.LocalDate

class Marca {
    var id: Int = 0
    var nombre: String = ""
    var paisOrigen: String = ""
    var fechaFundacion: LocalDate? = null
    var listaModelos = mutableListOf<Modelo>()

    constructor() {
    }

    constructor(id: Int, nombre: String, paisOrigen: String, fechaFundacion: LocalDate?,
                listaModelos: MutableList<Modelo>) {
        this.id = id
        this.nombre = nombre
        this.paisOrigen = paisOrigen
        this.fechaFundacion = fechaFundacion
        this.listaModelos = listaModelos
    }

    fun obtenerAtributos(): String {
        var idsModelos: String = ""
        listaModelos.forEach{
            idsModelos += ","+it.id.toString()
        }
        return "$id,$nombre,$fechaFundacion,$paisOrigen$idsModelos"
    }
    override fun toString(): String {
        var modelos: String = ""
        listaModelos.forEach {
            modelos += it.nombre + "\n"
        }
        return "\nID: $id, Marca: $nombre, Pais de Origen: $paisOrigen, Fecha de Fundacion: $fechaFundacion\n" +
                "Modelos:\n $modelos"
    }


}