package com.marcelo.personallibrary

import android.os.Parcel
import android.os.Parcelable

class Persona() : Parcelable {
    private var dni : String?

    private var nombre : String?

    private var edad : Int?


    fun getEdad (): Int? {
        return this.edad;
    }
    init{
        this.dni = ""
        this.nombre =""
        this.edad = 0

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
        // ayuda override
        override fun toString(): String = "Nombre: "

    }
}