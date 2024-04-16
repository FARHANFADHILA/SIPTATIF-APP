package belajar.p2.siptatif.data

import java.io.Serializable

data class Mahasiswa(
    val nama:String,
    val nim:String,
    val email: String,
    val judulTugasSkripsi:String,
    val calonPembimbing1:String,
    val calonPembimbing2:String,
    val tanggalDaftar:String
): Serializable
