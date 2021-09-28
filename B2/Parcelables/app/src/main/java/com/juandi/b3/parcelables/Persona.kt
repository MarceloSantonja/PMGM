package com.juandi.b3.parcelables

import android.os.Parcel
import android.os.Parcelable

class Persona() : Parcelable {
    var nombre : String
    var edad: Int

    constructor(parcel: Parcel) : this() {
        nombre = parcel.readString().toString()
        edad = parcel.readInt()
    }

    init {
        nombre=""
        edad=0

    }
    constructor(nombre: String, edad: Int) : this() {
        this.nombre = nombre
        this.edad = edad
    }

    override fun toString(): String {
        return "$nombre $edad"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(edad)
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