package com.example.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme
import com.example.navigation.ui.theme.pages.about.AboutScreen
import com.example.navigation.ui.theme.pages.home.HomeScreen
import com.example.navigation.ui.theme.pages.login.LoginScreen
import com.example.navigation.ui.theme.pages.products.AddProductsScreen
import com.example.navigation.ui.theme.pages.products.ViewProductsScreen
import com.example.navigation.ui.theme.pages.signup.SignupScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN
){
    NavHost(navController = navController,
        modifier = Modifier, startDestination = startDestination){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_SIGNUP){
            SignupScreen(navController)
        }

        composable(ROUTE_ABOUT){
            AboutScreen(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }

        composable(ROUTE_ADD_PRODUCTS){
            AddProductsScreen(navController)
        }

        composable(ROUTE_VIEW_PRODUCTS){
    ViewProductsScreen(navController)
        }

    }
}

@Preview
@Composable
fun AppNavHostPreview() {
    NavigationTheme{
        AppNavHost(rememberNavController())
    }
}