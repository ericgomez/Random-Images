package com.esgomez.randomimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imagePhoto: ImageView = findViewById(R.id.imagePhoto)
        var imagePhoto2: ImageView = findViewById(R.id.imagePhoto2)
        var btnGetUrlImage: Button = findViewById(R.id.btnGetUrlImage)

        //var model: MainActivityViewModel = MainActivityViewModel()
        //Damos de alta la clase como Provider esto permitira que los datos persistan al girar el dispositivo
        var model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        var urlImage: MutableLiveData<String?>? = model.callUrlImage()

        urlImage?.observe(this, Observer {
            print("Se ejecuta si la url sufre un cambio")
            //insertamos la Photo que viene en el string it
            Picasso.get().load(it).into(imagePhoto)
            Picasso.get().load(it).into(imagePhoto2)
        })

        btnGetUrlImage.setOnClickListener {//Ese cambio ocurre cuando doy click en el boton
            model.randomNumbresUrl()
        }
    }
}