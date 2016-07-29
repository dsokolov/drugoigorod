package ru.drugoigorod.app.data

data class IndexItem(
        val articleId: String,
        val title: String,
        val backgroundUrl: String,
        val style: Style,
        val textColor: Int,
        val textBackgroundColor: Int
) {
    enum class Style {
        BIG, MIDDLE, NORMAL, NOPIC
    }
}

