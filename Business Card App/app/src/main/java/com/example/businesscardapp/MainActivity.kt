package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF28282B))
            .padding(top = 210.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BaseBusinessInfo(
            logo = painterResource(R.drawable.jusan_logo),
            fullName = stringResource(R.string.mukhtar_bimurat),
            title = stringResource(R.string.jusan_kz)
        )
        ContactInfo(
            phoneNumber = stringResource(R.string.jusan_phone_number),
            mail = stringResource(R.string.info_jusan_kz),
            channel = stringResource(R.string.jusan_channel),//https://www.youtube.com/channel/UCo2nrMAz-qALwXTqQslt2jA
        )
    }
}

@Composable
private fun BaseBusinessInfo(logo: Painter, fullName: String, title: String){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.height(250.dp)
    ){
        Image(
            painter = logo,
            contentDescription = "Jusan.kz",
            modifier = Modifier.height(130.dp)

//            height, width
        )
        Text(
            text = fullName,
            color = Color.White,
            fontSize = 30.sp,
        )
        Text(
            text = title,
            color = Color(0xFFFF5F1F),
            fontSize = 20.sp,
            letterSpacing = 0.1.em
        )
    }
}

@Composable
private fun ContactInfo(phoneNumber: String, mail: String, channel: String){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(60.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
        ){
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Phone number",
                tint = Color(0xFFFF5F1F),
                modifier = Modifier
                    .padding(end = 10.dp),
            )
            Text(
                text = phoneNumber,
                color = Color.White,
            )
        }
        Row(modifier = Modifier
            .padding(8.dp),
            ){
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "mail",
                tint = Color(0xFFFF5F1F),
                modifier = Modifier
                    .padding(end = 10.dp),
            )
            Text(
                text = mail,
                color = Color.White,
            )
        }
        Row(
            modifier = Modifier
                .padding(8.dp),
        ){
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "YouTube Channel",
                tint = Color(0xFFFF5F1F),
                modifier = Modifier
                    .padding(end = 10.dp),
            )
            Text(
                text = channel,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}
