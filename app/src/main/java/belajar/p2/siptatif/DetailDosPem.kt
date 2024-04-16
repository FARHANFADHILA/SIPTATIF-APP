package belajar.p2.siptatif

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import belajar.p2.siptatif.data.DataMahasiswa
import belajar.p2.siptatif.data.DosenPembimbing
import belajar.p2.siptatif.data.Mahasiswa
import belajar.p2.siptatif.ui.theme.MyTheme
@Suppress("DEPRECATION")
class DetailDosPem : ComponentActivity() {
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
                    val nama = modelDospem.nama
                    Scaffold(
                        topBar = { TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                            title = { Text(text = "DETAIL DOSEN PEMBIMBING",textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
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
                        Column(modifier = Modifier.padding(top = 20.dp)){
                            Column(modifier = Modifier.padding(top=70.dp, start = 10.dp)){
                                Card(        modifier = Modifier.padding(end = 9.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
                                ){
                                    Row(modifier = Modifier.padding(top =20.dp, bottom = 20.dp)){
                                        Text(text = nama, modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .padding(start = 10.dp)
                                            .fillMaxWidth(),
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                }
                                Card(
                                    modifier = Modifier
                                        .padding(top = 20.dp, bottom = 20.dp)
                                    ,
                                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 60.dp)

                                ){
                                    Row(modifier = Modifier.padding(top =15.dp, bottom = 15.dp, end = 8.dp)){
                                        Text(text = "Mahasiswa Yang Dibimbing", modifier = Modifier.padding(start = 10.dp))

                                    }
                                }
                                Adapter()

                            }
                        }

                    }

                }
            }
        }
    }
}


@Composable
fun ListMhsBimbingan(model: Mahasiswa) {
    val content = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                val toDetail = Intent(content, DetailMahasiswa::class.java)
                toDetail.putExtra("data", model)
                content.startActivity(toDetail)
            },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()) {
            Row(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.icon_people),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(text = model.nama)
                    Text(text = model.nim)
                }

            }
        }
    }
}
@Composable
fun Adapter() {
    val listMahasiswa = remember {
        DataMahasiswa.mahasiswalist
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(
            items = listMahasiswa,
            itemContent = { ListMhsBimbingan(model = it) }
        )
    }
}
