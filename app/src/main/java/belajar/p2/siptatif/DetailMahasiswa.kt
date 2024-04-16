package belajar.p2.siptatif

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import belajar.p2.siptatif.data.Mahasiswa
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import belajar.p2.siptatif.ui.theme.MyTheme
import belajar.p2.siptatif.ui.theme.opensans
@Suppress("DEPRECATION")
class DetailMahasiswa : ComponentActivity() {
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
                    val modelMahasiswa = intent.getSerializableExtra("data") as Mahasiswa
                    val nama = modelMahasiswa.nama
                    val nim = modelMahasiswa.nim
                    val email = modelMahasiswa.email
                    val judul = modelMahasiswa.judulTugasSkripsi
                    val calon1 = modelMahasiswa.calonPembimbing1
                    val calon2 = modelMahasiswa.calonPembimbing2
                    Scaffold(
                        topBar = { TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                            title = { Text(text = "DETAIL MAHASISWA",textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
                            navigationIcon = {
                                IconButton(onClick = {
                                    onBackPressed()
                                }) {
                                    Icon(Icons.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(40.dp), tint = Color.Black )
                                }
                            }
                        )
                        },
                    ){
                        Column(modifier = Modifier.padding(top=70.dp)){
                            DetailMhs(
                                nama = nama,
                                nim = nim,
                                email = email,
                                judul = judul,
                                calon1 = calon1,
                                calon2 = calon2
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun DetailMhs(nama:String, nim:String, email:String,judul:String, calon1:String, calon2:String) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(modifier = Modifier
                .padding(25.dp)
                .fillMaxWidth()){
                Image(painter = painterResource(id = R.drawable.icon_people), contentDescription =null, modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally) )
                Box{
                    Row{
                        Icon(Icons.Filled.AccountCircle, contentDescription = null, modifier = Modifier.align(Alignment.Top) .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Nama :")
                            Text(text = nama, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Box{
                    Row{
                        Icon(Icons.Filled.AccountBox, contentDescription = null, modifier = Modifier.align(Alignment.Top) .size(30.dp) , tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Nim :")
                            Text(text = nim, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Box{
                    Row{
                        Icon(Icons.Filled.Email, contentDescription = null, modifier = Modifier.align(Alignment.Top) .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Email :")
                            Text(text = email, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Box{
                    Row{
                        Icon(Icons.Filled.Info, contentDescription = null, modifier = Modifier.align(Alignment.Top) .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Judul Skripsi :")
                            Text(text = judul, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Box{
                    Row{
                        Icon(Icons.Filled.Info, contentDescription = null, modifier = Modifier.align(Alignment.Top) .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Pembimbing 1 :")
                            Text(text = calon1, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Box{
                    Row{
                        Icon(Icons.Filled.Info, contentDescription = null, modifier = Modifier.align(Alignment.Top) .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Pembimbing 2 :")
                            Text(text = calon2, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                var status by remember {
                    mutableStateOf("MENUNGGU")
                }
                Box{
                    Row{
                        Icon(Icons.Filled.CheckCircle, contentDescription = null, modifier = Modifier.align(Alignment.Top) .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Status Berkas : $status")
                            StatusSelection { select ->
                                status = if (select == "DITERIMA") {
                                    "DITERIMA"
                                } else {
                                    "DITOLAK"
                                }
                            }
                        }
                    }
                }

            }



        }
        val content = LocalContext.current
        MyTheme {
                Button(
                    onClick = {
                              val tomhs = Intent(content,Beranda::class.java)
                        content.startActivity(tomhs)
                        Toast.makeText(content, "TERUPDATE", Toast.LENGTH_SHORT).show()
                    }, modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(end = 10.dp)
                        .width(190.dp)
                ) {
                    Text(text = "UPDATE", fontFamily = opensans)

                }

        }
    }
}
@Composable
fun StatusSelection(onStatusSelected: (String) -> Unit) {
    var selectedStatus by remember { mutableStateOf("") }

    Row(modifier = Modifier) {
        Spacer(modifier = Modifier.height(8.dp))
        RadioButton(
            selected = selectedStatus == "DITERIMA",
            onClick = { selectedStatus = "DITERIMA"; onStatusSelected(selectedStatus) },
        )
        Text(text = "DITERIMA", modifier = Modifier.align(Alignment.CenterVertically))
        Spacer(modifier = Modifier.height(4.dp))
        RadioButton(
            selected = selectedStatus == "DITOLAK",
            onClick = { selectedStatus= "DITOLAK"; onStatusSelected(selectedStatus) },

        )
        Text("DITOLAK", modifier = Modifier.align(Alignment.CenterVertically))
    }
}
@Preview(showBackground = true)
@Composable
fun Preb() {
    DetailMhs(nama = "kqsoxosxnsx", nim = "1234567", email ="sn jasaibxis", judul ="snxjsnxnwxnswxnsixnwnx" , calon1 = "msmscmdicmdicm", calon2 ="ssssssssssssss" )
}
