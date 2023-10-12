package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()){
        Row(Modifier.weight(1f)){
            ComposeCard(
                backgroundColor = Color(0xFFEADDFF),
                title = stringResource(R.string.text_composable),
                bodyText = stringResource(R.string.text_composable_description),
                modifier = Modifier.weight(1f),
            )
            ComposeCard(
                backgroundColor = Color(0xFFD0BCFF),
                title = stringResource(R.string.image_composable),
                bodyText = stringResource(R.string.image_composable_description),
                modifier = Modifier.weight(1f),
            )
        }
        Row(Modifier.weight(1f)){
            ComposeCard(
                backgroundColor = Color(0xFFB69DF8),
                title = stringResource(R.string.row_composable),
                bodyText = stringResource(R.string.row_composable_description),
                modifier = Modifier.weight(1f),
            )
            ComposeCard(
                backgroundColor = Color(0xFFF6EDFF),
                title = stringResource(R.string.column_composable),
                bodyText = stringResource(R.string.column_compasble_description),
                modifier = Modifier.weight(1f),
            )
        }
    }
}
@Composable
private fun ComposeCard(backgroundColor: Color, title: String, bodyText: String, modifier: Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = bodyText,
            textAlign = TextAlign.Justify
        )
    }    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}