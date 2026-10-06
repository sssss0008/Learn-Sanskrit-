package com.example.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.data.model.AppLanguage
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UserPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("sanskritam_prefs", Context.MODE_PRIVATE)
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    var language: AppLanguage
        get() {
            val code = prefs.getString("selected_lang", AppLanguage.SANSKRIT.name) ?: AppLanguage.SANSKRIT.name
            return try {
                AppLanguage.valueOf(code)
            } catch (e: Exception) {
                AppLanguage.SANSKRIT
            }
        }
        set(value) {
            prefs.edit().putString("selected_lang", value.name).apply()
        }

    var xp: Int
        get() = prefs.getInt("user_xp", 120)
        set(value) = prefs.edit().putInt("user_xp", value).apply()

    fun addXp(points: Int): Int {
        val newXp = xp + points
        xp = newXp
        return newXp
    }

    var streak: Int
        get() = prefs.getInt("user_streak", 3)
        private set(value) = prefs.edit().putInt("user_streak", value).apply()

    fun checkAndUpdateStreak(): Int {
        val today = dateFormat.format(Date())
        val lastDate = prefs.getString("last_active_date", "")

        if (lastDate == today) {
            return streak
        }

        val yesterday = dateFormat.format(Date(System.currentTimeMillis() - 86400000L))
        val newStreak = if (lastDate == yesterday) {
            streak + 1
        } else if (lastDate.isNullOrEmpty()) {
            1
        } else {
            1
        }

        streak = newStreak
        prefs.edit().putString("last_active_date", today).apply()
        return newStreak
    }

    var speechRate: Float
        get() = prefs.getFloat("speech_rate", 0.85f)
        set(value) = prefs.edit().putFloat("speech_rate", value).apply()

    fun isBookmarked(id: String): Boolean {
        val set = prefs.getStringSet("bookmarked_ids", emptySet()) ?: emptySet()
        return set.contains(id)
    }

    fun toggleBookmark(id: String): Boolean {
        val current = prefs.getStringSet("bookmarked_ids", emptySet())?.toMutableSet() ?: mutableSetOf()
        val newState = if (current.contains(id)) {
            current.remove(id)
            false
        } else {
            current.add(id)
            true
        }
        prefs.edit().putStringSet("bookmarked_ids", current).apply()
        return newState
    }

    fun getBookmarks(): Set<String> {
        return prefs.getStringSet("bookmarked_ids", emptySet()) ?: emptySet()
    }

    fun isMastered(flashcardId: String): Boolean {
        val set = prefs.getStringSet("mastered_cards", emptySet()) ?: emptySet()
        return set.contains(flashcardId)
    }

    fun toggleMastered(flashcardId: String): Boolean {
        val current = prefs.getStringSet("mastered_cards", emptySet())?.toMutableSet() ?: mutableSetOf()
        val newState = if (current.contains(flashcardId)) {
            current.remove(flashcardId)
            false
        } else {
            current.add(flashcardId)
            true
        }
        prefs.edit().putStringSet("mastered_cards", current).apply()
        return newState
    }

    fun getMasteredCards(): Set<String> {
        return prefs.getStringSet("mastered_cards", emptySet()) ?: emptySet()
    }

    fun isLessonCompleted(lessonId: String): Boolean {
        val set = prefs.getStringSet("completed_lessons", emptySet()) ?: emptySet()
        return set.contains(lessonId)
    }

    fun markLessonCompleted(lessonId: String) {
        val current = prefs.getStringSet("completed_lessons", emptySet())?.toMutableSet() ?: mutableSetOf()
        if (!current.contains(lessonId)) {
            current.add(lessonId)
            prefs.edit().putStringSet("completed_lessons", current).apply()
            addXp(25)
        }
    }
}
