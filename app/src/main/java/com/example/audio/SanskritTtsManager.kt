package com.example.audio

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Locale

class SanskritTtsManager(context: Context) {
    private var tts: TextToSpeech? = null
    private var isInitialized = false

    private val _isSpeaking = MutableStateFlow(false)
    val isSpeaking: StateFlow<Boolean> = _isSpeaking.asStateFlow()

    private val _currentUtteranceId = MutableStateFlow<String?>(null)
    val currentUtteranceId: StateFlow<String?> = _currentUtteranceId.asStateFlow()

    var speechRate: Float = 0.85f

    init {
        tts = TextToSpeech(context.applicationContext) { status ->
            if (status == TextToSpeech.SUCCESS) {
                // Try Sanskrit locale, then Hindi, then Nepali
                val saLocale = Locale("sa")
                val hiLocale = Locale("hi", "IN")
                val neLocale = Locale("ne", "NP")

                val engine = tts
                val result = if (engine != null) {
                    when {
                        engine.isLanguageAvailable(saLocale) == TextToSpeech.LANG_AVAILABLE -> {
                            engine.language = saLocale
                            TextToSpeech.LANG_AVAILABLE
                        }
                        engine.isLanguageAvailable(hiLocale) >= TextToSpeech.LANG_AVAILABLE -> {
                            engine.language = hiLocale
                            TextToSpeech.LANG_AVAILABLE
                        }
                        engine.isLanguageAvailable(neLocale) >= TextToSpeech.LANG_AVAILABLE -> {
                            engine.language = neLocale
                            TextToSpeech.LANG_AVAILABLE
                        }
                        else -> {
                            engine.language = Locale.getDefault()
                            TextToSpeech.LANG_AVAILABLE
                        }
                    }
                } else {
                    TextToSpeech.LANG_NOT_SUPPORTED
                }

                if (result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED) {
                    isInitialized = true
                    tts?.setPitch(1.0f)
                    tts?.setSpeechRate(speechRate)
                    setupProgressListener()
                } else {
                    Log.w("SanskritTtsManager", "TTS language not fully supported, falling back")
                    isInitialized = true
                }
            } else {
                Log.e("SanskritTtsManager", "Failed to initialize TTS engine")
            }
        }
    }

    private fun setupProgressListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                _isSpeaking.value = true
                _currentUtteranceId.value = utteranceId
            }

            override fun onDone(utteranceId: String?) {
                _isSpeaking.value = false
                _currentUtteranceId.value = null
            }

            @Deprecated("Deprecated in Java")
            override fun onError(utteranceId: String?) {
                _isSpeaking.value = false
                _currentUtteranceId.value = null
            }
        })
    }

    fun speak(text: String, utteranceId: String = "sanskrit_${System.currentTimeMillis()}") {
        if (!isInitialized || tts == null) return
        stop()
        tts?.setSpeechRate(speechRate)
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
    }

    fun stop() {
        if (tts != null) {
            tts?.stop()
            _isSpeaking.value = false
            _currentUtteranceId.value = null
        }
    }

    fun shutdown() {
        stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
    }
}
