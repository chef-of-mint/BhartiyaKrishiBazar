package com.example.bhartiya_krishi_bazar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bhartiya_krishi_bazar.ui.theme.Orange

@Composable
fun Welcome (navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(modifier = Modifier.fillMaxSize().blur(radius = 8.dp),contentScale = ContentScale.Crop, painter = painterResource(id = R.drawable.welcome_bg), contentDescription = "background")
        Column(modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(modifier = Modifier.fillMaxWidth(),painter = painterResource(id = R.drawable.top_bg),contentScale = ContentScale.Crop, contentDescription = "background")
                Image(modifier = Modifier
                    .size(50.dp), alignment = Alignment.Center,painter = painterResource(id = R.drawable.logo), contentDescription = "background")
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
                .fillMaxWidth()
                .weight(3f)) {
                Text(text = "Welcome",style = TextStyle(
                    fontSize = 41.sp,
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Italic,
                    color = Color(0xFFFFF4F4),
                ))
                Text(modifier = Modifier.padding(top = 20.dp),text = "Please choose ONE",style = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight(600),
                    fontStyle = FontStyle.Italic,
                    color = Color(0xFFFFFFFF),
                ))
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(10f)){
                Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
                    Image(modifier = Modifier
                        .size(170.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(5.dp, Color.White, CircleShape) ,contentScale = ContentScale.Crop,painter = painterResource(id = R.drawable.welcome_1), contentDescription = "Image")
                    Text(text = "Farmer", modifier = Modifier.clickable {
                        navController.navigate("farmer")
                    }.drawWithContent {
                        drawContent()
                        drawRect(
                            color = Color.White.copy(alpha = 0.3f),
                            size = size
                        )
                    }.padding(10.dp),style = TextStyle(
                        fontSize = 33.sp,
                        fontWeight = FontWeight(400),
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )
                    )
                }
                Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
                    Image(modifier = Modifier
                        .size(170.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(5.dp, Color.White, CircleShape) ,contentScale = ContentScale.Crop,painter = painterResource(id = R.drawable.welcome_2), contentDescription = "Image")
                    Text(text = "Merchant", modifier = Modifier.clickable {
                        navController.navigate("merchant")
                    }.drawWithContent {
                        drawContent()
                        drawRect(
                            color = Color.White.copy(alpha = 0.3f),
                            size = size
                        )
                    }.padding(10.dp),style = TextStyle(
                        fontSize = 33.sp,
                        fontWeight = FontWeight(400),
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )
                    )
                }
            }

            Column(verticalArrangement = Arrangement.SpaceAround,modifier = Modifier.fillMaxWidth()
                .weight(1.7f).background(color = Orange, shape = RoundedCornerShape(size = 13.dp))) {
                Text(modifier = Modifier.padding(start = 10.dp), text = "Contact us:",style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    fontStyle = FontStyle.Italic,
                    color = Color(0xFFFFFFFF),
                ))
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                    Text(text = "Mobile: 9876543210   Email:bkb@gmail.com ",style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight(600),
                        fontStyle = FontStyle.Italic,
                        color = Color(0xFFFFFFFF),
                    ))
                }
            }


        }
    }
}
