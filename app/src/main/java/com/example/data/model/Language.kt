package com.example.data.model

enum class AppLanguage(val code: String, val displayName: String, val nativeName: String, val iconText: String) {
    SANSKRIT("sa", "Sanskrit", "संस्कृतम्", "सं"),
    NEPALI("ne", "Nepali", "नेपाली", "ने"),
    ENGLISH("en", "English", "English", "EN");

    fun next(): AppLanguage {
        val values = values()
        return values[(ordinal + 1) % values.size]
    }
}

data class TrilingualText(
    val sa: String,
    val ne: String,
    val en: String
) {
    fun get(language: AppLanguage): String = when (language) {
        AppLanguage.SANSKRIT -> sa
        AppLanguage.NEPALI -> ne
        AppLanguage.ENGLISH -> en
    }
}
