package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.model.Offer
import com.example.myapplication.ui.theme.MyApplicationTheme

class OffersDetailsActivity : ComponentActivity() {

    private lateinit var offer: Offer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        offer = intent.getSerializableExtra("offer-data") as Offer

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    DisplayTopBar(innerPadding)
                    DisplayContent(innerPadding, offer)
                    DisplayBottomBar(innerPadding)
                }
            }
        }
    }
}

@Composable
fun DisplayTopBar(padding: PaddingValues) {

}

@Composable
fun DisplayContent(padding: PaddingValues, offerInfo: Offer) {
    Column(modifier = Modifier.padding(padding)) {
        Text(offerInfo.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))

        DisplayOfferPictureAndPrice(offerInfo)

        Text(offerInfo.description)
        Text("This page has been displayed : ")
    }
}

@Composable
fun DisplayOfferPictureAndPrice(offerInfo: Offer) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(offerInfo.picture),
                contentDescription = "image describing the offer",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )
            Text("${offerInfo.price} ${offerInfo.currency}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 5.dp, end = 5.dp)
            )
        }
}

@Composable
fun DisplayBottomBar(padding: PaddingValues) {

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
//        Greeting("Android")
        DisplayContent(
            PaddingValues(0.dp),
            Offer(123,
                "Titlu oferta",
                "Descriere",
                123,
                "EUR",
                R.drawable.offer_new
                )
        )
    }
}