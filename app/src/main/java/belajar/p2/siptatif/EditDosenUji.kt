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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import belajar.p2.siptatif.data.DosenPenguji
import belajar.p2.siptatif.ui.theme.MyTheme
import belajar.p2.siptatif.ui.theme.SIPTATIFTheme
@Suppress("DEPRECATION")
class EditDosenUji : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val modelDosuji = intent.getSerializableExtra("data") as DosenPenguji
                    val nama = modelDosuji.nama
                    val nip = modelDosuji.nip
                    val kuota = modelDosuji.kuota
                    val keahlian = modelDosuji.keahlian
                    Scaffold(

                        topBar = { TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                            title = { Text(text = "Edit Data", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
                        )
                        },
                    ){
                        Column(modifier = Modifier.padding(top=55.dp)){
                                Edit(nama,nip,kuota,keahlian)
                            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                                MyTheme {

                                    Button(onClick = {onBackPressed() }, modifier = Modifier.padding(end = 20.dp)) {
                                        Text(text = "BATAL")
                                    }
                                    Button(onClick = { val tobrd = Intent(this@EditDosenUji, Beranda::class.java)
                                        startActivity(tobrd)
                                        Toast.makeText(this@EditDosenUji, "TERSIMPAN", Toast.LENGTH_SHORT).show()}, modifier = Modifier.padding(start = 20.dp)) {
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
fun Edit(nama:String, nip:String, kuota:String,keahlian:String) {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    SIPTATIFTheme {
       Edit("naanjna","123455","8", "akokoqkoko")
    }
}