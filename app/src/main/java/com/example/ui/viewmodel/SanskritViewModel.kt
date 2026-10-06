package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.BuildConfig
import com.example.audio.SanskritTtsManager
import com.example.data.guru.GeneratedSentence
import com.example.data.guru.GuruMessage
import com.example.data.guru.SanskritGuruEngine
import com.example.data.local.UserPreferences
import com.example.data.model.*
import com.example.data.repository.SanskritRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class NavigationTab(val title: TrilingualText) {
    HOME(TrilingualText("गृहम्", "गृहपृष्ठ", "Home")),
    LEARN(TrilingualText("शिक्षणम्", "सिक्नुहोस्", "Learn")),
    PRACTICE(TrilingualText("अभ्यासः", "अभ्यास", "Practice")),
    ABOUT(TrilingualText("परिचयः", "एप विवरण", "About App"))
}

enum class LearnSubSection {
    OVERVIEW,
    VARNAMALA,
    MAHESHWARA,
    SHABDA_RUPA,
    DHATU_RUPA,
    SANDHI,
    KARAKA,
    CONVERSATION
}

enum class PracticeMode {
    FLASHCARDS,
    QUIZ
}

class SanskritViewModel(application: Application) : AndroidViewModel(application) {

    private val userPrefs = UserPreferences(application)
    val ttsManager = SanskritTtsManager(application)
    private val guruEngine = SanskritGuruEngine()

    private val _currentLanguage = MutableStateFlow(userPrefs.language)
    val currentLanguage: StateFlow<AppLanguage> = _currentLanguage.asStateFlow()

    private val _currentTab = MutableStateFlow(NavigationTab.HOME)
    val currentTab: StateFlow<NavigationTab> = _currentTab.asStateFlow()

    private val _learnSubSection = MutableStateFlow(LearnSubSection.OVERVIEW)
    val learnSubSection: StateFlow<LearnSubSection> = _learnSubSection.asStateFlow()

    private val _practiceMode = MutableStateFlow(PracticeMode.FLASHCARDS)
    val practiceMode: StateFlow<PracticeMode> = _practiceMode.asStateFlow()

    // Culture & Traditions Article Selection
    val cultureArticles = SanskritRepository.cultureArticles
    private val _selectedCultureArticleId = MutableStateFlow(cultureArticles.first().id)
    val selectedCultureArticleId: StateFlow<String> = _selectedCultureArticleId.asStateFlow()

    fun selectCultureArticle(id: String) {
        _selectedCultureArticleId.value = id
    }

    // Streaks and XP
    private val _streak = MutableStateFlow(userPrefs.checkAndUpdateStreak())
    val streak: StateFlow<Int> = _streak.asStateFlow()

    private val _xp = MutableStateFlow(userPrefs.xp)
    val xp: StateFlow<Int> = _xp.asStateFlow()

    private val _bookmarks = MutableStateFlow(userPrefs.getBookmarks())
    val bookmarks: StateFlow<Set<String>> = _bookmarks.asStateFlow()

    // Learning selection states
    val swaras = SanskritRepository.swaras
    val vyanjanas = SanskritRepository.vyanjanas
    val maheshwaraSutras = SanskritRepository.maheshwaraSutras
    val shabdaRupaTables = SanskritRepository.shabdaRupaTables
    val dhatuRupaTables = SanskritRepository.dhatuRupaTables
    val sandhiRules = SanskritRepository.sandhiRules
    val karakaTopics = SanskritRepository.karakaTopics
    val conversationPhrases = SanskritRepository.conversationPhrases
    val subhashitas = SanskritRepository.subhashitas
    val vocabulary = SanskritRepository.vocabulary
    val quizQuestions = SanskritRepository.quizQuestions
    val flashcards = SanskritRepository.flashcards

    private val _selectedShabdaId = MutableStateFlow(shabdaRupaTables.first().id)
    val selectedShabdaId: StateFlow<String> = _selectedShabdaId.asStateFlow()

    private val _selectedDhatuId = MutableStateFlow(dhatuRupaTables.first().id)
    val selectedDhatuId: StateFlow<String> = _selectedDhatuId.asStateFlow()

    private val _selectedSandhiId = MutableStateFlow(sandhiRules.first().id)
    val selectedSandhiId: StateFlow<String> = _selectedSandhiId.asStateFlow()

    // Flashcard State
    private val _flashcardIndex = MutableStateFlow(0)
    val flashcardIndex: StateFlow<Int> = _flashcardIndex.asStateFlow()

    private val _isCardFlipped = MutableStateFlow(false)
    val isCardFlipped: StateFlow<Boolean> = _isCardFlipped.asStateFlow()

    // Quiz State
    private val _quizIndex = MutableStateFlow(0)
    val quizIndex: StateFlow<Int> = _quizIndex.asStateFlow()

    private val _selectedAnswerIndex = MutableStateFlow<Int?>(null)
    val selectedAnswerIndex: StateFlow<Int?> = _selectedAnswerIndex.asStateFlow()

    private val _isAnswerSubmitted = MutableStateFlow(false)
    val isAnswerSubmitted: StateFlow<Boolean> = _isAnswerSubmitted.asStateFlow()

    private val _quizScore = MutableStateFlow(0)
    val quizScore: StateFlow<Int> = _quizScore.asStateFlow()

    // Dictionary & Search
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategoryFilter = MutableStateFlow("All")
    val selectedCategoryFilter: StateFlow<String> = _selectedCategoryFilter.asStateFlow()

    // Sentence Constructor
    val subjects = guruEngine.subjects
    val objects = guruEngine.objects
    val verbs = guruEngine.verbs

    private val _selectedSubjectId = MutableStateFlow(subjects.first().id)
    val selectedSubjectId: StateFlow<String> = _selectedSubjectId.asStateFlow()

    private val _selectedObjectId = MutableStateFlow(objects.first().id)
    val selectedObjectId: StateFlow<String> = _selectedObjectId.asStateFlow()

    private val _selectedVerbId = MutableStateFlow(verbs.first().id)
    val selectedVerbId: StateFlow<String> = _selectedVerbId.asStateFlow()

    private val _constructedSentence = MutableStateFlow(
        guruEngine.constructSentence(subjects.first().id, objects.first().id, verbs.first().id)
    )
    val constructedSentence: StateFlow<GeneratedSentence> = _constructedSentence.asStateFlow()

    // Guru Chat
    private val _guruMessages = MutableStateFlow<List<GuruMessage>>(
        listOf(
            GuruMessage(
                id = "welcome",
                isUser = false,
                text = "हरिः ॐ! अहं तव वैयाकरण-गुरुः अस्मि। संस्कृतव्याकरणे, श्लोकेषु, अनुवादकार्येषु च साह्यं कर्तुं सज्जः अस्मि।\n(Greetings! I am your Sanskrit Guru. Ask me anything about grammar, shlokas, or sentence translation!)",
                sanskritQuote = "गुरुर्ब्रह्मा गुरुर्विष्णुः गुरुर्देवो महेश्वरः।"
            )
        )
    )
    val guruMessages: StateFlow<List<GuruMessage>> = _guruMessages.asStateFlow()

    private val _isGuruTyping = MutableStateFlow(false)
    val isGuruTyping: StateFlow<Boolean> = _isGuruTyping.asStateFlow()

    init {
        ttsManager.speechRate = userPrefs.speechRate
    }

    // Actions
    fun setLanguage(lang: AppLanguage) {
        userPrefs.language = lang
        _currentLanguage.value = lang
    }

    fun toggleLanguage() {
        setLanguage(_currentLanguage.value.next())
    }

    fun selectTab(tab: NavigationTab) {
        _currentTab.value = tab
    }

    fun selectLearnSubSection(section: LearnSubSection) {
        _learnSubSection.value = section
    }

    fun selectPracticeMode(mode: PracticeMode) {
        _practiceMode.value = mode
    }

    fun selectShabda(id: String) {
        _selectedShabdaId.value = id
    }

    fun selectDhatu(id: String) {
        _selectedDhatuId.value = id
    }

    fun selectSandhi(id: String) {
        _selectedSandhiId.value = id
    }

    fun toggleBookmark(id: String) {
        userPrefs.toggleBookmark(id)
        _bookmarks.value = userPrefs.getBookmarks()
    }

    fun isBookmarked(id: String): Boolean {
        return _bookmarks.value.contains(id)
    }

    // Flashcard Actions
    fun flipCard() {
        _isCardFlipped.value = !_isCardFlipped.value
    }

    fun nextFlashcard() {
        if (_flashcardIndex.value < flashcards.size - 1) {
            _flashcardIndex.value += 1
            _isCardFlipped.value = false
        } else {
            _flashcardIndex.value = 0
            _isCardFlipped.value = false
        }
    }

    fun prevFlashcard() {
        if (_flashcardIndex.value > 0) {
            _flashcardIndex.value -= 1
            _isCardFlipped.value = false
        }
    }

    fun markFlashcardMastered() {
        val currentCard = flashcards[_flashcardIndex.value]
        userPrefs.toggleMastered(currentCard.id)
        addXp(15)
        nextFlashcard()
    }

    // Quiz Actions
    fun selectQuizAnswer(index: Int) {
        if (!_isAnswerSubmitted.value) {
            _selectedAnswerIndex.value = index
        }
    }

    fun submitQuizAnswer() {
        if (_selectedAnswerIndex.value == null || _isAnswerSubmitted.value) return
        _isAnswerSubmitted.value = true
        val currentQ = quizQuestions[_quizIndex.value]
        if (_selectedAnswerIndex.value == currentQ.correctIndex) {
            _quizScore.value += 1
            addXp(currentQ.xpValue)
        }
    }

    fun nextQuizQuestion() {
        if (_quizIndex.value < quizQuestions.size - 1) {
            _quizIndex.value += 1
            _selectedAnswerIndex.value = null
            _isAnswerSubmitted.value = false
        } else {
            // Quiz complete - reset or show complete
            _quizIndex.value = 0
            _selectedAnswerIndex.value = null
            _isAnswerSubmitted.value = false
            _quizScore.value = 0
        }
    }

    // Sentence Constructor Actions
    fun updateSubject(id: String) {
        _selectedSubjectId.value = id
        rebuildSentence()
    }

    fun updateObject(id: String) {
        _selectedObjectId.value = id
        rebuildSentence()
    }

    fun updateVerb(id: String) {
        _selectedVerbId.value = id
        rebuildSentence()
    }

    private fun rebuildSentence() {
        _constructedSentence.value = guruEngine.constructSentence(
            _selectedSubjectId.value,
            _selectedObjectId.value,
            _selectedVerbId.value
        )
    }

    // Guru Chat Actions
    fun askGuru(query: String) {
        if (query.isBlank()) return
        val userMsg = GuruMessage(
            id = System.currentTimeMillis().toString(),
            isUser = true,
            text = query
        )
        _guruMessages.value = _guruMessages.value + userMsg
        _isGuruTyping.value = true

        viewModelScope.launch {
            // Get GEMINI_API_KEY from BuildConfig if available
            val apiKey = try {
                BuildConfig::class.java.getField("GEMINI_API_KEY").get(null) as? String
            } catch (e: Exception) {
                null
            }

            val reply = guruEngine.consultGuru(query, _currentLanguage.value, apiKey)
            _isGuruTyping.value = false
            _guruMessages.value = _guruMessages.value + reply
            addXp(10)
        }
    }

    // Audio actions
    fun speak(text: String) {
        ttsManager.speak(text)
    }

    fun stopAudio() {
        ttsManager.stop()
    }

    fun updateSpeechRate(rate: Float) {
        userPrefs.speechRate = rate
        ttsManager.speechRate = rate
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setCategoryFilter(category: String) {
        _selectedCategoryFilter.value = category
    }

    private fun addXp(points: Int) {
        val newXp = userPrefs.addXp(points)
        _xp.value = newXp
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.shutdown()
    }
}
