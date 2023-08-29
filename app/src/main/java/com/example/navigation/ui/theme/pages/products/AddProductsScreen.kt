package com.example.navigation.ui.theme.pages.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.data.ProductRepository

import com.example.navigation.ui.theme.NavigationTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current
        Text(text = "Add Product(s)",
            fontSize = 30.sp,
            textDecoration = TextDecoration.Underline,
            color = Color.Yellow,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color.Transparent))

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text ="Register Here!",
            color = Color.Cyan,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        var productName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = productName,
            onValueChange = {productName = it},
            label = { Text(text = "Name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )

        Spacer(modifier = Modifier.height(20.dp))

        var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = productQuantity,
            onValueChange = {productQuantity = it},
            label = { Text(text = "Quantity*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

            )
        Spacer(modifier = Modifier.height(20.dp))

        var productPrice by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = productPrice,
            onValueChange = {productPrice= it},
            label = { Text(text = "Price *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )



        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
//----Write save logic here----//
            var productRepository = ProductRepository(navController, context)
            productRepository.saveProduct(productName.text.trim(), productQuantity.text.trim(), productPrice.text.trim() )

        }) { Text(text = "SAVE") }






    }

}

@Preview
@Composable
fun AddProductsScreenPreview() {
    NavigationTheme {
AddProductsScreen(rememberNavController())
    }

}