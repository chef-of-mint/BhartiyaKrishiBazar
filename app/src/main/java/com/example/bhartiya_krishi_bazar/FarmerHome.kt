package com.example.bhartiya_krishi_bazar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun FarmerHome() {
    Column() {
        TabRowFarmer()
    }
}

@Composable
fun TabRowFarmer() {
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
            MainScreen()

        }
        1 -> {
            // Content for Tab 2
            MainScreen()
        }

    }
}

@Composable
fun MainScreen() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val items = remember { listOf("Drink water", "Walk") }
    val filteredItems = remember {
        derivedStateOf {
            val searchText = textState.value.text.lowercase(Locale.getDefault())
            items.filter { it.lowercase(Locale.getDefault()).contains(searchText) }
        }
    }

    Column {
        SearchView(textState)
        ItemList(filteredItems.value)
    }
}

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier.fillMaxWidth(),
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
        shape = RectangleShape,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = MaterialTheme.colors.primary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ItemList(items: List<String>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items) { item ->
            ItemListItem(item)
        }
    }
}

@Composable
fun ItemListItem(item: String) {
    Row(
        modifier = Modifier
            .background(color = Color(0xFF4CAF50))
            .height(57.dp)
            .fillMaxWidth()
            .padding(8.dp, 16.dp)
    ) {
        Text(text = item, fontSize = 18.sp, color = Color.White)
    }
}