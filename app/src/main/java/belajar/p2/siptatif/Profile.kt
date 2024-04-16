package belajar.p2.siptatif

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import belajar.p2.siptatif.ui.theme.MyTheme
import belajar.p2.siptatif.ui.theme.SIPTATIFTheme
@Suppress("DEPRECATION")
class Profile : ComponentActivity() {
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
                    Scaffold(
                        topBar = { TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.tertiary),
                            title = { Text(text = "PROFILE",textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
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
                            Profileuser()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Profileuser() {
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
                Image(painter = painterResource(id = R.drawable.saya), contentDescription =null, modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally) )
                Box{
                    Row{
                        Icon(
                            Icons.Filled.AccountCircle, contentDescription = null, modifier = Modifier
                                .align(
                                    Alignment.Top
                                )
                                .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Nama :")
                            Text(text = "Koordinator TA", fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Box{
                    Row{
                        Icon(
                            Icons.Filled.MailOutline, contentDescription = null, modifier = Modifier
                                .align(
                                    Alignment.Top
                                )
                                .size(30.dp) , tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Email :")
                            Text(text = "koordinatorTA@gmail.com", fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Box{
                    Row{
                        Icon(
                            Icons.Filled.AccountBox, contentDescription = null, modifier = Modifier
                                .align(
                                    Alignment.Top
                                )
                                .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "Username :")
                            Text(text = "KoordinatorTa0221", fontWeight = FontWeight.Bold)
                        }
                    }
                }
                Box{
                    Row{
                        Icon(
                            Icons.Filled.Call, contentDescription = null, modifier = Modifier
                                .align(
                                    Alignment.Top
                                )
                                .size(30.dp), tint = MaterialTheme.colorScheme.primary)
                        Column(modifier = Modifier.padding(bottom = 15.dp)) {
                            Text(text = "No Handphone :")
                            Text(text = "089560314823", fontWeight = FontWeight.Bold)
                        }
                    }
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    SIPTATIFTheme {
        Profileuser()
    }
}