package com.esgomez.randomimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imagePhoto: ImageView = findViewById(R.id.imagePhoto)

        //var model: MainActivityViewModel = MainActivityViewModel()
        //Damos de alta la clase como Provider esto permitira que los datos persistan al girar el dispositivo
        var model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //insertamos la Photo
        Picasso.get().load(model.callUrlImage()).into(imagePhoto)
    }
}