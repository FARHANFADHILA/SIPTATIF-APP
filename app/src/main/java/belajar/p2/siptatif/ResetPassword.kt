package belajar.p2.siptatif

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import belajar.p2.siptatif.ui.theme.SIPTATIFTheme

class ResetPassword : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SIPTATIFTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun ResetLink() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var text1 by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.fillMaxWidth()) {
        Logo()
        Card(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier .padding(17.dp)) {
                Text(
                    text = "RESET PASSWORD",
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = text,
                    maxLines = 2,
                    onValueChange = { text = it },
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    placeholder = {
                        Text(
                            text = "New Password", fontStyle = FontStyle.Italic
                        )
                    })
                OutlinedTextField(
                    value = text1,
                    maxLines = 1,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onValueChange = { text1 = it },
                    placeholder = { Text(text = "Confirm Password", fontStyle = FontStyle.Italic)},
                )
                OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp)
                    .width(220.dp)) {
                    Text(text = "RESET PASSWORD")
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SIPTATIFTheme {
        ResetLink()
    }
}