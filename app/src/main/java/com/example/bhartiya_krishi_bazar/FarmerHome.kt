package com.example.bhartiya_krishi_bazar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bhartiya_krishi_bazar.ui.theme.Orange
import java.util.*

@Composable
@Preview
fun FarmerHome(navController: NavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column() {
        Row(){
            Row(verticalAlignment = Alignment.CenterVertically , modifier = Modifier.padding(top = 10.dp,bottom = 10.dp)) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.LocationOn, contentDescription = "Location", tint = Orange)
                }
                Text(text = "You are Here", modifier = Modifier.width(60.dp))
                Box(modifier = Modifier.weight(8f)){SearchView(textState)}
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Add, contentDescription = "Location", tint = Orange)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "Account", tint = Orange)
                }
            }
        }
        TabRowFarmer(textState,navController)
    }
}

@Composable
fun TabRowFarmer(textState: MutableState<TextFieldValue>,navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth()
    ) {
        listOf("Sell", "Seed").forEachIndexed { index, text ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index },
                text = { Text(text) }
            )
        }
    }
    when (selectedTabIndex) {
        0 -> {
            // Content for Tab 1
            SellScreen(textState,navController)
        }
        1 -> {
            // Content for Tab 2
            SeedScreen(textState,navController)
        }

    }
}

@Composable
fun SellScreen(textState: MutableState<TextFieldValue>,navController: NavController) {

    val items = remember { listOf("Wheat", "Mustard", "Paddy", "Garlic","Coffee","Cotton","Sugar Cane","Wheat", "Mustard", "Paddy", "Garlic","Coffee","Cotton","Sugar Cane") }
    val filteredItems = remember {
        derivedStateOf {
            val searchText = textState.value.text.lowercase(Locale.getDefault())
            items.filter { it.lowercase(Locale.getDefault()).contains(searchText) }
        }
    }

    Column(Modifier.background(Color.White)) {
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.White)) {
                Icon(Icons.Filled.Share, contentDescription = "Location")
                Text(text = "Sort")
            }
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.White)) {
                Text(text = "On demand")
            }
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.White)) {
                Text(text = "Seasonal")
            }
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.White)) {
                Text(text = "Price")
            }
        }
        ItemList(filteredItems.value,navController)
    }
}

@Composable
fun SeedScreen(textState: MutableState<TextFieldValue>,navController: NavController) {

    val items = remember { listOf("Wheat", "Mustard", "Paddy", "Garlic","Coffee","Cotton","Sugar Cane","Wheat", "Mustard", "Paddy", "Garlic","Coffee","Cotton","Sugar Cane") }
    val filteredItems = remember {
        derivedStateOf {
            val searchText = textState.value.text.lowercase(Locale.getDefault())
            items.filter { it.lowercase(Locale.getDefault()).contains(searchText) }
        }
    }

    Column(
        Modifier
            .background(Color.White)
            .fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.White)) {
                Icon(Icons.Filled.Share, contentDescription = "Location")
                Text(text = "Sort")
            }
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.White)) {
                Text(text = "On demand")
            }
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.White)) {
                Text(text = "Seasonal")
            }
            Button(onClick = { /*TODO*/ },modifier = Modifier.background(Color.White)) {
                Text(text = "Price")
            }
        }
        ItemListBid(filteredItems.value,navController)
    }
}

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    Card(
        modifier = Modifier.shadow(20.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        TextField(
            value = state.value,
            onValueChange = { value ->
                state.value = value
            },
            textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            },
            trailingIcon = {
                if (state.value != TextFieldValue("")) {
                    IconButton(
                        onClick = {
                            state.value = TextFieldValue("")
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(15.dp)
                                .size(24.dp)
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                leadingIconColor = Color.White,
                trailingIconColor = Color.White,
                backgroundColor = MaterialTheme.colors.primary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),

            )
    }


}

@Composable
fun ItemList(items: List<String>,navController: NavController) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)
    ) {
        items(items.size) { item ->
            ItemListItem(item = items[item],navController)
        }
    }
}

@Composable
fun ItemListItem(item: String,navController: NavController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { navController.navigate("farmer/sell/$item") }, horizontalAlignment = Alignment.CenterHorizontally){
        Card(modifier = Modifier.shadow(10.dp),
            shape = RoundedCornerShape(5.dp)) {
            Image(painter = painterResource(id = R.drawable.welcome_1), contentDescription = "card_image")
        }
        Text(text = item, modifier = Modifier.padding(top = 4.dp),style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            fontStyle = FontStyle.Italic,
            color = Color(0xFF000000),
        ))
    }
}

@Composable
fun ItemListBid(items: List<String>,navController: NavController){
    LazyColumn {
        items(items) { item ->
            ItemListBidItem(item = item, navController = navController)
        }
    }
}

@Composable
fun ItemListBidItem(item: String,navController: NavController) {
    Box(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)){
    Card(modifier = Modifier
        .shadow(2.dp)
        .fillMaxSize()
        .clickable { navController.navigate("farmer/sell/$item") }
        .border(3.dp, color = Orange, shape = RoundedCornerShape(10.dp)), shape = RoundedCornerShape(10.dp)) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.item1),
                contentDescription = "card_image"
            )
            Text(
                text = item, modifier = Modifier
                    .padding(top = 4.dp)
                    .shadow(5.dp), style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight(600),
                    fontStyle = FontStyle.Italic,
                    color = Color(0xFFFFFFFF),
                )
            )
        }
    }
    }
}