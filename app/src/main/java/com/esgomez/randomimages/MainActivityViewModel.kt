package com.esgomez.randomimages

class MainActivityViewModel {

    private var urlImage: String? = null

    fun callUrlImage(): String? {
        if (urlImage == null) {
            urlImage = randomNumbresUrl()
        }

        return urlImage
    }
    //
    fun randomNumbresUrl(): String {
        return "https://picsum.photos/${(3..5).random()}00/${(3..5).random()}00"
    }
}