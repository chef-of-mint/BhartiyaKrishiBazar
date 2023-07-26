package com.example.bhartiya_krishi_bazar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MerchantHome() {
    Column() {
        TabRowMerchant()
    }
}

@Composable
fun TabRowMerchant() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth()
    ) {
        listOf("Bid", "Chats").forEachIndexed { index, text ->
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
            Text(text = "Hi")

        }
        1 -> {
            // Content for Tab 2

        }

    }
}