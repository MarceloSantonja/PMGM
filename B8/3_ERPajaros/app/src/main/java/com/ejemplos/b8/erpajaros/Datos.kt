package com.ejemplos.b8.erpajaros

import android.os.Parcel
import android.os.Parcelable


class Datos : Parcelable {
    var pos: Int
    var icono: Int
    var nombre: String?
    var desc: String?

    constructor(p: Int, ic: Int, n: String?, d: String?) {
        pos = p
        icono = ic
        nombre = n
        desc = d
    }

    protected constructor(`in`: Parcel) {
        pos = `in`.readInt()
        icono = `in`.readInt()
        nombre = `in`.readString()
        desc = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(pos)
        dest.writeInt(icono)
        dest.writeString(nombre)
        dest.writeString(desc)
    }



    companion object CREATOR : Parcelable.Creator<Datos> {
        override fun createFromParcel(parcel: Parcel): Datos {
            return Datos(parcel)
        }

        override fun newArray(size: Int): Array<Datos?> {
            return arrayOfNulls(size)
        }
    }
}
