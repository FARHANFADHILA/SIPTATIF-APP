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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import belajar.p2.siptatif.ui.theme.MyTheme
import belajar.p2.siptatif.ui.theme.SIPTATIFTheme
@Suppress("DEPRECATION")
class Register : ComponentActivity() {
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
                    Scaffold(
                        topBar = { TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                            title = { Text(text = "DAFTAR", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
                            navigationIcon = {
                                IconButton(onClick = {onBackPressed()}) {
                                    Icon(Icons.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(40.dp), tint = Color.Black)
                                }
                            }
                        )
                        },
                    ){
                        Column(modifier = Modifier.padding(top=80.dp)){
                            Input()
                            Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
                                MyTheme {

                                    Button(onClick = {onBackPressed()}, modifier = Modifier.padding(end = 20.dp)) {
                                        Text(text = "BATAL")
                                    }
                                    Button(onClick = {
                                        val tobrd = Intent(this@Register, MainActivity::class.java)
                                        startActivity(tobrd)
                                        Toast.makeText(this@Register, "TERDAFTAR", Toast.LENGTH_SHORT).show()


                                    }, modifier = Modifier.padding(start = 20.dp)) {
                                        Text(text = "DAFTAR")
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
fun Input7() {
    var textnama by remember { mutableStateOf(TextFieldValue("")) }
    var textnim by remember { mutableStateOf(TextFieldValue("")) }
    var textEmail by remember { mutableStateOf(TextFieldValue("")) }
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var judul by remember { mutableStateOf(TextFieldValue("")) }
    Column {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)){
            Row(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
                Text(text = "Nama ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(85.dp))
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
                Text(text = "NIM ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(85.dp))
                OutlinedTextField(
                    value = textnim,
                    onValueChange = { textnim = it },
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
                Text(text = "Email ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(85.dp))
                OutlinedTextField(
                    value = textEmail,
                    onValueChange = { textEmail = it },
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
                Text(text = "Username ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(70.dp))
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
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
                Text(text = "Password ", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(85.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
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
                Text(text = "Judul", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .widthIn(85.dp))
                OutlinedTextField(
                    value = judul,
                    onValueChange = { judul = it },
                    modifier = Modifier.height(60.dp),
                    maxLines = 1
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SIPTATIFTheme {
       Input7()
    }
}