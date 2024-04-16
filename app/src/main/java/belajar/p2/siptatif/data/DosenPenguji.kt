package belajar.p2.siptatif.data

import java.io.Serializable

data class DosenPenguji(
    val nama: String,
    val nip: String,
    val kuota: String,
    val keahlian:String
): Serializable
