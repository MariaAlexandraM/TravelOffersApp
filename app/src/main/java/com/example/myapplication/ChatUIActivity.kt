package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.ChatMessage
import com.example.myapplication.model.DataFactory
import com.example.myapplication.ui.theme.MyApplicationTheme

class ChatUIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ChatUIScreen()
            }
        }
    }
}

@Composable
fun ChatUIScreen() {

    val messages by remember { mutableStateOf(DataFactory.getChatMessages(20)) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column (
            modifier = Modifier.padding(innerPadding)
        ) {
            Row ( modifier = Modifier
                .padding(start = 10.dp, end = 10.dp),){
                Text("Username: ")
                Text("Maria", fontWeight = FontWeight.Bold)
            }

            ChatWriteMessage()

        LazyColumn {
            itemsIndexed(messages) {
                index, message ->
                ChatListElement_Design1(message)
            }
        }
        }
    }
}

@Composable
fun ChatListElement_Design1(message: ChatMessage) {
   Box (
       modifier = Modifier.fillMaxWidth()
   ){
        Text(
            message.sender, fontWeight = FontWeight.Bold
        )

       Image (
           painterResource(R.drawable.star),
           contentDescription = "",
           modifier = Modifier
               .size(25.dp)
               .align(Alignment.CenterEnd)
       )

    }

    Text(message.message,
        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))

    Text(
        message.timestamp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Right,
        modifier = Modifier.fillMaxWidth()
    )

    HorizontalDivider(
        modifier = Modifier.padding(vertical = 10.dp),
        thickness = 1.dp,
        color = Color.LightGray
    )

}

@Composable
fun ChatWriteMessage() {

    var messagetext by remember { mutableStateOf("") }

    Row (verticalAlignment = Alignment.CenterVertically)
    {
        TextField(
            value = messagetext,
            onValueChange = {messagetext = it },
            label = { Text("Your message: ")},
            modifier = Modifier.weight(1F)

        )

        Button(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp),
            onClick = {}) {
            Text("Send")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        ChatUIScreen()
    }
}