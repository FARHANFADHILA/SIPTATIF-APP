package belajar.p2.siptatif

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import belajar.p2.siptatif.ui.theme.MyTheme

class LupaPassword : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Run_LP()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Run_LP() {
    Scaffold(modifier = Modifier.padding(20.dp)){
        Column {
            Logo()
            Card_Lupapw()
        }
    }
}
@Composable
fun Logo() {
    Column(modifier = Modifier.padding(bottom = 30.dp)){
        Image(painter = painterResource(id = R.drawable.logo_tif), contentDescription ="", modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, top = 10.dp))
        Image(painter = painterResource(id = R.drawable.siptatif), contentDescription ="", modifier = Modifier
            .fillMaxWidth()
            .size(25.dp))
    }
}

@Composable
fun Card_Lupapw() {
    val content = LocalContext.current
    var email by remember { mutableStateOf(TextFieldValue("")) }
        Column {
            MyTheme {
            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                ,
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
            ) {

                Text(
                    text = "LUPA PASSWORD",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 40.dp, top = 20.dp)
                        .fillMaxWidth()
                )

                OutlinedTextField(value = email,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    onValueChange = { email = it },
                    shape = RoundedCornerShape(14.dp),
                    placeholder = {
                        Text(
                            text = "Email Address", fontStyle = FontStyle.Italic
                        )
                    })
                MyTheme {
                    Button(
                        onClick = {
                            val toLogin = Intent(content, MainActivity::class.java)
                            content.startActivity(toLogin)
                            Toast.makeText(content, "TERKIRIM", Toast.LENGTH_SHORT).show()

                        }, modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(220.dp)
                    ) {
                        Text(text = "Send Password Reset Link")
                    }

                    Button(
                        onClick = {
                                val toLogin = Intent(content, MainActivity::class.java)
                                content.startActivity(toLogin)
                        }, modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(220.dp)
                            .padding(bottom = 15.dp)
                    ) {
                        Text(text = "Kembali Login")
                    }
                }
            }

        }
        }
}


@Preview
@Composable
fun Prev() {
MyTheme{
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Run_LP()
    }
}
}