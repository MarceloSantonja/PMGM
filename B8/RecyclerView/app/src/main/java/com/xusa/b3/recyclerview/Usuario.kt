package com.xusa.b3.recyclerview

class Usuario() {
    var nombre: String
    var apellidos: String
    init {
        nombre=""
        apellidos=""
    }
    constructor(nombre:String, apellidos:String):this()
    {
        this.nombre = nombre
        this.apellidos = apellidos
    }
}
