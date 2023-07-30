package com.example.bhartiya_krishi_bazar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
@Preview
fun Farmer_Sell(navController: NavController,item : String?){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            IconButton(onClick = { navController.popBackStack() }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back Button", tint = Color.DarkGray)
            }
            Text(
                modifier = Modifier.weight(8f),
                text = "Details",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                )
            )
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.AccountCircle, contentDescription = "Language", tint = Color.DarkGray)
            }
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp),contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = R.drawable.card_bg_detail), contentScale = ContentScale.FillBounds, contentDescription = "Card Background")
            Card {
                Text(text = item?: "Item Not Available!")
            }
        }
    }

}