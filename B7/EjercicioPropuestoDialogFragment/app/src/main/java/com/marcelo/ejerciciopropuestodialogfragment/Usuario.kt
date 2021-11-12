package com.marcelo.ejerciciopropuestodialogfragment

class Usuario( val nombre : String , val contraseña :String, var guardar: Boolean=true ) {


    override fun toString(): String {
        var contraseñaCifrada :String =""
        for (i in 1..contraseña.length) contraseñaCifrada += "*"
        return "Login: $nombre\n" +
                "Password: $contraseñaCifrada" +
                "Activado recuerdo de datos"
    }

}