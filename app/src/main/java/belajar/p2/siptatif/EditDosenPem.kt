package belajar.p2.siptatif

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import belajar.p2.siptatif.data.DosenPembimbing
import belajar.p2.siptatif.ui.theme.MyTheme
@Suppress("DEPRECATION")
class EditDosenPem : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val modelDospem = intent.getSerializableExtra("data") as DosenPembimbing
                    val nama2 = modelDospem.nama
                    val nip2 = modelDospem.nip
                    val kuota2 = modelDospem.kuota
                    val keahlian2= modelDospem.keahlian
                    Scaffold(
                        topBar = { TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                            title = { Text(text = "Edit Data", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
                        )
                        },
                    ){
                        Column(modifier = Modifier.padding(top=55.dp)){
                            EditDospem(nama = nama2, nip = nip2, kuota = kuota2, keahlian = keahlian2)
                            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                                MyTheme {

                                    Button(onClick = {onBackPressed() }, modifier = Modifier.padding(end = 20.dp)) {
                                        Text(text = "BATAL")
                                    }
                                    Button(onClick = { val tobrd = Intent(this@EditDosenPem, Beranda::class.java)
                                        startActivity(tobrd)
                                        Toast.makeText(this@EditDosenPem, "TERSIMPAN", Toast.LENGTH_SHORT).show()}, modifier = Modifier.padding(start = 20.dp)) {
                                        Text(text = "SIMPAN")
                                    }
                                }
                            }

                        }

                    }
                }
            }
        }
    }
}

@Composable
fun EditDospem(nama:String, nip:String, kuota:String,keahlian:String) {
    var textnama by remember { mutableStateOf(TextFieldValue(nama)) }
    var textnip by remember { mutableStateOf(TextFieldValue(nip)) }
    var textkuota by remember { mutableStateOf(TextFieldValue(kuota)) }
    var textkeahlian by remember { mutableStateOf(TextFieldValue(keahlian)) }
    Column {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)){
            Row(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
                Text(text = "Nama ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(70.dp))
                OutlinedTextField(
                    value = textnama,
                    onValueChange = { textnama = it },
                    modifier = Modifier.height(60.dp),
                    maxLines = 1
                )
            }
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)){
            Row(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
                Text(text = "NIP ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(70.dp))
                OutlinedTextField(
                    value = textnip,
                    onValueChange = { textnip = it },
                    modifier = Modifier.height(60.dp),
                    maxLines = 1
                )
            }
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)){
            Row(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
                Text(text = "Kuota ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(70.dp))
                OutlinedTextField(
                    value = textkuota,
                    onValueChange = { textkuota = it },
                    modifier = Modifier.height(60.dp),
                    maxLines = 1
                )
            }
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)){
            Row(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
                Text(text = "Keahlian ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(80.dp))
                OutlinedTextField(
                    value = textkeahlian,
                    onValueChange = { textkeahlian = it },
                    modifier = Modifier.height(60.dp),
                    maxLines = 1
                )
            }
        }


    }
}