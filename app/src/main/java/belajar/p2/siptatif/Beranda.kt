package belajar.p2.siptatif

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import belajar.p2.siptatif.data.DataDosenPembimbing
import belajar.p2.siptatif.data.DataDosenPenguji
import belajar.p2.siptatif.data.DataMahasiswa
import belajar.p2.siptatif.data.DosenPembimbing
import belajar.p2.siptatif.data.DosenPenguji
import belajar.p2.siptatif.data.Mahasiswa
import belajar.p2.siptatif.ui.theme.MyTheme



class Beranda : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Runhome()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Runhome() {
    val currentScreen = remember { mutableStateOf("home") }
    Scaffold(
        bottomBar= {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ){
//                untuk home
                IconButton(onClick = {currentScreen.value = "home"},modifier = Modifier
                    .size(100.dp)) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Column {
                            Text(
                                text = "Home",
                                fontSize = 10.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
//                untuk mahasiswa
                IconButton(onClick = {currentScreen.value = "mahasiswa"},modifier = Modifier
                    .size(100.dp)) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.vector1),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Column {
                            Text(
                                text = "Mahasiswa",
                                fontSize = 10.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
//                untuk dosen penguji
                IconButton(onClick = {currentScreen.value = "dosenpenguji"},modifier = Modifier
                    .size(100.dp)) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.pembimbing),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Column {
                            Text(
                                text = "Dosen Penguji",
                                fontSize = 10.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
//                untuk dosen pembimbing
                IconButton(onClick = {currentScreen.value = "dosenpembimbing"},modifier = Modifier
                    .size(100.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.pembimbing),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Column {
                            Text(
                                text = "Dosen Pembimbing",
                                fontSize = 8.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
            }
        }
    ){
        when (currentScreen.value) {
            "home" -> {
                // Menavigasi ke home screen
                MyAppNaviHost(startDestination = "home")
            }

            "mahasiswa" -> {
                // Menavigasi ke mahasiswa screen
                MyAppNaviHost(startDestination = "mahasiswa")
            }

            "dosenpenguji" -> {
                // Menavigasi ke dosen penguji screen
                MyAppNaviHost(startDestination = "dosenpenguji")
            }

            "dosenpembimbing" -> {
                // Menavigasi ke dosen pembimbing screen
                MyAppNaviHost(startDestination = "dosenpembimbing")
            }
        }
    }

}


@Composable
fun Tohome() {
    val showDialog = remember{ mutableStateOf(false)}
    val content = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(top = 30.dp)){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
            ){
                Column(modifier = Modifier.padding(9.dp)) {
                    Text(text = "Selamat Datang,")
                    Text(
                        text = "koordinator Ta",
                        modifier = Modifier.padding(start = 50.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Box(modifier = Modifier.clickable { expanded = !expanded  }){
                Image(
                    painter = painterResource(id = R.drawable.icon_people),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(start = 159.dp)
                        .size(50.dp),
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    offset = DpOffset(x = 70.dp, y = 0.dp),
                    modifier = Modifier
                        .size(100.dp)
                        .background(color = MaterialTheme.colorScheme.primary)
                ) {
                    DropdownMenuItem(text = { Text(text = "Profile", color = Color.White)}, onClick = {
                        val toProfile = Intent(content,Profile::class.java)
                        content.startActivity(toProfile)
                    })
                    DropdownMenuItem(text = { Text(text = "loggout", color = Color.White)}, onClick = {
                        showDialog.value = true
                        })
                }

            }
        }
        if (showDialog.value) {
        AlertDialog(
            icon = { Icon(Icons.Filled.Warning, contentDescription = null) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            onDismissRequest = { showDialog.value = false },
            title = {
                Text("LOGOUT", color = Color.White)
            },
            text = { Text("Apakah Anda yakin ingin melanjutkan?", color = Color.White) },
            confirmButton = {
                Column(modifier = Modifier.padding(end = 60.dp)){
                    Button(
                        onClick = {
                            val toLogin = Intent(content, MainActivity::class.java)
                            content.startActivity(toLogin)
                        }, modifier = Modifier.align(Alignment.Start)

                    ) {
                        Text("Ya")
                    }
                }
            },
            dismissButton = {
                Column(modifier = Modifier.padding()){
                    Button(
                        onClick = {
                            showDialog.value = false
                        }, modifier = Modifier.align(Alignment.Start)
                    ) {
                        Text("Tidak")
                    }
                }
            }
        )
    }
        Logo()
        Card(modifier = Modifier.align(Alignment.CenterHorizontally),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)){
            Column(modifier = Modifier.padding(30.dp)){
                Text(text = "Sistem Informasi Pendaftaraan", style = MaterialTheme.typography.titleLarge)
                Text(text = "Judul Tugas Akhir", style = MaterialTheme.typography.titleLarge)
                Text(text = "TEKNIK INFORMATIKA", style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}

class Mhs {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Mahasiswa() {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                    title = {
                    Text(
                        text = "DATA MAHASISWA",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                )
            },
        ) {
            Column(modifier = Modifier.padding(top = 60.dp,bottom = 80.dp)) {
                AdapterMahasiswa()
            }
        }
    }
    @Composable
    fun ListdataMahasiswa(model: Mahasiswa) {
        val content = LocalContext.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
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
                            Text(text = model.tanggalDaftar)
                        }

                }
                Text(
                    text = "Detail", modifier = Modifier
                        .padding(end = 5.dp)
                        .align(Alignment.End)
                        .clickable {
                            val toDetail = Intent(content, DetailMahasiswa::class.java)
                            toDetail.putExtra("data", model)
                            content.startActivity(toDetail)
                        }, fontWeight = FontWeight.Bold, fontSize = 20.sp
                )
            }
        }
    }


    @Composable
    fun AdapterMahasiswa() {
        val listMahasiswa = remember {
            DataMahasiswa.mahasiswalist
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(
                items = listMahasiswa,
                itemContent = { ListdataMahasiswa(model = it) }
            )
        }
    }
}
class   DsnPenguji {
    @Composable
    fun ListdataDosenPenguji(model: DosenPenguji, onDeleteClik:() -> Unit) {
        val content = LocalContext.current
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
            )
        {
            Column(modifier = Modifier.padding(15.dp)) {
                Row(modifier = Modifier.align(Alignment.End)){
                    Image(
                        painter = painterResource(id = R.drawable.editicon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                            .align(Alignment.CenterVertically)
                            .padding(end = 7.dp)
                            .clickable {
                                val toEditDosji = Intent(content, EditDosenUji::class.java)
                                toEditDosji.putExtra("data", model)
                                content.startActivity(toEditDosji)
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.delete),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically)
                            .clickable(onClick = onDeleteClik)
                    )
                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.icon_people),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.CenterVertically)
                            .padding(end = 5.dp)
                    )
                    Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(text = model.nama, fontWeight = FontWeight.Bold)
                        Text(text = model.nip)
                        Text(text = "kuota : ${model.kuota}")
                        Text(text = "keahlian: ${model.keahlian}")
                            Text(
                                text = "Detail", modifier = Modifier
                                    .align(Alignment.End)
                                    .clickable {
                                        val toDetailDosji =
                                            Intent(content, DetailDosenPenguji::class.java)
                                        toDetailDosji.putExtra("data", model)
                                        content.startActivity(toDetailDosji)
                                    }, fontWeight = FontWeight.Bold, fontSize = 20.sp
                            )

                    }
                }

            }
        }
    }

    @Composable
    fun AdapterDosenPenguji() {
        val content = LocalContext.current
        val listDosenPenguji = remember { mutableStateListOf<DosenPenguji>() }
        listDosenPenguji.addAll(DataDosenPenguji.dosenPengujilist)
        Column {
            OutlinedButton(
                onClick = {
                    val toTambah = Intent(content, TambahDosenPenguji::class.java)
                    content.startActivity(toTambah)
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .align(Alignment.End)
                    .width(160.dp)
                    .height(55.dp)
                    .padding(bottom = 8.dp)
                ,
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
                Text(text = "Tambah")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(
                    items = listDosenPenguji,
                    itemContent = {model ->
                        ListdataDosenPenguji(model = model, onDeleteClik = {
                            listDosenPenguji.remove(model)
                        })
                    }
                )
            }
        }

    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DosenPenguji() {
        MyTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                    title = {
                    Text(
                        text = "DOSEN PENGUJI",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                )
            },
        ) {
            Column(modifier = Modifier.padding(top = 70.dp, bottom = 80.dp)) {
                AdapterDosenPenguji()
            }
        }
        }
    }
}
class DsnPembimbing {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DosenPembimbing() {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                    title = {
                    Text(
                        text = "DOSEN PEMBIMBING",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                )
            },
        ) {
            Column(modifier = Modifier.padding(top = 70.dp, bottom = 80.dp)) {
                AdapterDosenPembimbing()
            }
        }
    }
    @Composable
    fun ListdataDosenPembimbing(model: DosenPembimbing, onDeleteClik:() -> Unit) {
        val content = LocalContext.current
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
        )
        {
            Column(modifier = Modifier.padding(15.dp)) {
                Row(modifier = Modifier.align(Alignment.End)){
                    Image(
                        painter = painterResource(id = R.drawable.editicon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                            .align(Alignment.CenterVertically)
                            .padding(end = 7.dp)
                            .clickable {
                                val toEditDospem = Intent(content, EditDosenPem::class.java)
                                toEditDospem.putExtra("data", model)
                                content.startActivity(toEditDospem)
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.delete),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.CenterVertically)
                            .clickable(onClick = onDeleteClik)
                    )
                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.icon_people),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.CenterVertically)
                            .padding(end = 5.dp)
                    )
                    Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Text(text = model.nama, fontWeight = FontWeight.Bold)
                        Text(text = model.nip)
                        Text(text = "kuota : ${model.kuota}")
                        Text(text = "keahlian: ${model.keahlian}")
                        Text(
                            text = "Detail", modifier = Modifier
                                .align(Alignment.End)
                                .clickable {
                                    val toDetailDospem =
                                        Intent(content, DetailDosPem::class.java)
                                    toDetailDospem.putExtra("data", model)
                                    content.startActivity(toDetailDospem)
                                }, fontWeight = FontWeight.Bold, fontSize = 20.sp
                        )

                    }
                }

            }
        }
    }
    @Composable
    fun AdapterDosenPembimbing() {
        val content = LocalContext.current
        val listDosenPembimbing = remember { mutableStateListOf<DosenPembimbing>() }
        listDosenPembimbing.addAll(DataDosenPembimbing.dosenPembimbinglist)
        Column {
            OutlinedButton(
                onClick = {
                    val toTambah = Intent(content, TambahDosenPenguji::class.java)
                    content.startActivity(toTambah)
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .align(Alignment.End)
                    .width(160.dp)
                    .height(55.dp)
                    .padding(bottom = 8.dp)
                ,
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
                Text(text = "Tambah")
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(
                    items = listDosenPembimbing
                ) { model ->
                    ListdataDosenPembimbing(model = model, onDeleteClik = {
                        listDosenPembimbing.remove(model)
                    })
                }
            }
        }

    }
}


@Composable
fun MyAppNaviHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ){
        composable("runhome"){
            Runhome()
        }
        composable("home"){
            Tohome()
        }
        composable("mahasiswa"){
            Mhs().Mahasiswa()
        }
        composable("dosenpenguji"){
            DsnPenguji().DosenPenguji()
        }
        composable("dosenpembimbing"){
            DsnPembimbing().DosenPembimbing()
        }
    }
    
}
@Preview
@Composable
fun Pww() {
    MyTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Mhs().Mahasiswa()
        }
    }

}
