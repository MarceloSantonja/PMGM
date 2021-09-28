package com.marcelo.b3ejercicioparcelable

import android.os.Parcel
import android.os.Parcelable

class Persona() : Parcelable {
    var dni : String?
    var nombre : String?
    var edad : Int?

    init{
        this.dni = ""
        this.nombre =""
        this.edad = 0

    }
    constructor(dni : String?, nombre : String?, edad : Int?) : this() {
        this.dni = dni
        this.nombre = nombre
        this.edad = edad

    }
    constructor(parcel: Parcel) : this() {
        this.dni = parcel.readString()
        this.nombre = parcel.readString()
        this.edad = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(dni)
        parcel.writeInt(edad!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Persona> {
        override fun createFromParcel(parcel: Parcel): Persona {
            return Persona(parcel)
        }

        override fun newArray(size: Int): Array<Persona?> {
            return arrayOfNulls(size)
        }
    }

}