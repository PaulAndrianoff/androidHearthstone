package com.example.hp.myhearthstoneworkshop.main.model

class News constructor(title: String, subtitle: String, content: String, typeOfArticle: String, imageId: Int) {
    val title = title
    val label = typeOfArticle
    val subtitle = subtitle
    val content = content
    val imageId = imageId
}