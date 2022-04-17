package com.example.examen

class LibroOrganizer {
    private var listaLibros = listOf<LibroVO>()

    init {
        listaLibros = listOf(

            LibroVO("Bases de Datos","BASES DE DATOS", "Coronel, Morris y Rob"),
            LibroVO("Aprende SQL","BASES DE DATOS", "Alan Beaulieu"),
            LibroVO("Aprende Access 2016","BASES DE DATOS", "Microsoft"),
            LibroVO("Clean Code","PROGRAMACION", "Robert C"),
            LibroVO("Desing Patterns","PROGRAMACION", "Erich Gamma"),
            LibroVO("Code Simplicity","PROGRAMACION", "Max Kanat"),
            LibroVO("Redes Informaticas","REDES", "Jose Dordoigne"),
            LibroVO("Redes Cisco","REDES", "Ernersto Ariganello"),
            LibroVO("Redes y Seguridad","REDES", "Matias David"),
            LibroVO("Inteligencia Matematica","MATEMATICAS", "Eduardo Saenz"),
            LibroVO("Matematica y Literatura","MATEMATICAS", "Marta Macho"),
            LibroVO("Malditas Matematicas","MATEMATICAS", "Carlo Frabetti")



        )
    }

    fun obtenerLibrosPorArea(Area: String): ArrayList<LibroVO> {
        val result = arrayListOf<LibroVO>()
        for (libros in listaLibros) {

            if (libros.Area == Area) {
                result.add(libros)
            }



        }
return result
    }
}