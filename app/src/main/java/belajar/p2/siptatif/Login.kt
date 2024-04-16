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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import belajar.p2.siptatif.ui.theme.MyTheme
import belajar.p2.siptatif.ui.theme.opensans
@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    @Deprecated("Use finishAffinity() instead", ReplaceWith("finishAffinity()"))
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Run()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Run() {
        Scaffold(modifier = Modifier.padding(20.dp)) {
            Column {
                To_login()
                Username_Password()

            }
        }
}
@Composable
fun To_login() {
    Column {
        Image(painter = painterResource(id = R.drawable.logo_tif), contentDescription ="", modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp, top = 10.dp))
        Image(painter = painterResource(id = R.drawable.siptatif), contentDescription ="", modifier = Modifier
            .fillMaxWidth()
            .size(25.dp))
    }
}

@Composable
fun Username_Password() {
    val content = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, top = 30.dp, end = 50.dp)
    ) {
        Text(
            text = "USERNAME", fontFamily = opensans
        )
        var username by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            maxLines = 1,
            shape = RoundedCornerShape(14.dp)
        )
        Text(
            text = "PASSWORD", modifier = Modifier
                .padding(top = 30.dp), fontFamily = opensans
        )
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var keypw by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            maxLines = 1,
            shape = RoundedCornerShape(14.dp),
            visualTransformation = if (keypw) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }, trailingIcon = {
                if (keypw) {
                    IconButton(onClick = { keypw = false }) {
                        Icon(
                            painter = painterResource(id = R.drawable.visibility),
                            contentDescription = "",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                } else {
                    IconButton(onClick = { keypw = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.visibility_off),
                            contentDescription = "",
                            modifier = Modifier.size(30.dp)
                        )

                    }
                }
            }
        )

        Text(text = "Lupa Password?",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    val intentLp = Intent(content, LupaPassword::class.java)
                    content.startActivity(intentLp)
                }, fontFamily = opensans
        )
        MyTheme {
            Button(
                onClick = {
                    val intentLG = Intent(content, Beranda::class.java)
                    content.startActivity(intentLG)

                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(190.dp)
                    .height(150.dp)
                    .padding(top = 90.dp)
                    .shadow(
                        elevation = 60.dp,
                        ambientColor = Color.Black,
                        spotColor = Color.Black
                    ),
            ) {
                Text(text = "LOGIN", fontSize = 25.sp, fontFamily = opensans)
            }

            Row(modifier = Modifier.padding(top = 40.dp)){
                Text(text = "Belum Punya Akun ?", modifier = Modifier.align(Alignment.CenterVertically))
                Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary), modifier= Modifier.clickable { val toRegister = Intent(content, Register::class.java)
                content.startActivity(toRegister)}) {
                    Text(text = "Daftar Sini", modifier = Modifier.padding(6.dp), fontWeight = FontWeight.ExtraBold)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun User_passPrev() {
    Username_Password()
}