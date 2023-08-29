package com.example.navigation.ui.theme.pages.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navigation.ROUTE_ADD_PRODUCTS
import com.example.navigation.navigation.ROUTE_VIEW_PRODUCTS
import com.example.navigation.ui.theme.NavigationTheme

@Composable
fun HomeScreen(navController: NavHostController) {
Column(modifier = Modifier
    .fillMaxSize(),
horizontalAlignment = Alignment.CenterHorizontally) {
    var context = LocalContext.current
    Text(
        text = "Welcome to Home Screen",
        color = Color.Cyan,
        fontSize = 28.sp,
        fontFamily =  androidx.compose.ui.text.font.FontFamily.Monospace
    )

    Spacer(modifier = Modifier.height(30.dp))

    Button(onClick = {
        navController.navigate(ROUTE_ADD_PRODUCTS)
    }) {
        Text(text = "Add products")
    }

    Spacer(modifier = Modifier.height(20.dp))



    Button(onClick = {
        navController.navigate(ROUTE_VIEW_PRODUCTS)
    }) {
        Text(text = "View Products")
    }

}

}

@Preview
@Composable
fun HomeScreenPreview() {
    NavigationTheme {
        HomeScreen(rememberNavController())

    }

}