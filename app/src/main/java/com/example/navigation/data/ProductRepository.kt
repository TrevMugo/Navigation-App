package com.example.navigation.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.navigation.models.Product
import com.example.navigation.navigation.ROUTE_LOGIN
import com.google.firebase.database.FirebaseDatabase

class ProductRepository(var navController: NavHostController, var context: Context) {
    var authRepository:AuthRepository
    var progress:ProgressDialog

    init {
        authRepository = AuthRepository(navController, context)
        if (!authRepository.isLoggedIn()){
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait....")
    }

    fun saveProduct(name:String, quantity:String, price:String){
var id = System.currentTimeMillis().toString()
var productData = Product(name, quantity, price, id)
var productRef = FirebaseDatabase.getInstance().getReference()
    .child("Products/$id")
        progress.show()
    productRef.setValue(productData).addOnCompleteListener { 
       progress.dismiss()
        if (it.isSuccessful){
            Toast.makeText(context, "Yoo", Toast.LENGTH_SHORT).show()
        }
    }
    }


    fun viewProduct(name:String, quantity:String, price:String){

    }


}