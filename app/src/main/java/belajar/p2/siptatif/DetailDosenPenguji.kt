package belajar.p2.siptatif

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import belajar.p2.siptatif.data.DosenPenguji
import belajar.p2.siptatif.ui.theme.MyTheme

//import belajar.p2.siptatif.ui.theme.SIPTATIFTheme
@Suppress("DEPRECATION")
class DetailDosenPenguji : ComponentActivity() {
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
                    val modelDospem = intent.getSerializableExtra("data") as DosenPenguji
                    val nama = modelDospem.nama
                    Scaffold(
                        topBar = { TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                            title = { Text(text = "DETAIL DOSEN PENGUJI",textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
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
                                        Text(text = "Mahasiswa Yang Di Uji", modifier = Modifier.padding(start = 10.dp))

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
