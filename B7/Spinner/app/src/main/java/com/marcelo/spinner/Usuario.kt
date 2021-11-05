package com.marcelo.spinner

class Usuario {
    var nombre: String
    var apellidos: String

    init {
         nombre =""
        apellidos=""
    }
    constructor()


    constructor(nombre: String, apellidos: String) {
        this.nombre = nombre
        this.apellidos = apellidos
    }
}