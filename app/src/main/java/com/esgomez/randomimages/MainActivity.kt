package com.esgomez.randomimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imagePhoto: ImageView = findViewById(R.id.imagePhoto)

        var model: MainActivityViewModel = MainActivityViewModel()

        //insertamos la Photo
        Picasso.get().load(model.callUrlImage()).into(imagePhoto)
    }
}