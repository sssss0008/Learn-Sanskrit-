package com.example.data.model

// Varnamala (Alphabet)
enum class VarnaCategory(val title: TrilingualText) {
    SWARA(TrilingualText("स्वराः (Vowels)", "स्वरहरू (Vowels)", "Vowels (Swaras)")),
    SPARSHA(TrilingualText("स्पर्श-व्यञ्जनानि", "स्पर्श व्यञ्जनहरू", "Stop Consonants (Sparsha)")),
    ANTASHTHA(TrilingualText("अन्तःस्थाः (Semivowels)", "अन्तःस्थ वर्णहरू", "Semivowels (Antashtha)")),
    USHMANA(TrilingualText("ऊष्म-वर्णाः (Sibilants/Aspirates)", "ऊष्म वर्णहरू", "Sibilants & Aspirates")),
    AYOGAVAHA(TrilingualText("अयोगवाहाः", "अयोगवाह (अनुस्वार र विसर्ग)", "Ayogavahas (Anusvara & Visarga)")),
    SAMYUKTA(TrilingualText("संयुक्त-व्यञ्जनानि", "संयुक्त व्यञ्जनहरू", "Conjunct Consonants"))
}

data class VarnamalaItem(
    val character: String,
    val iast: String,
    val category: VarnaCategory,
    val sthana: TrilingualText, // Articulation place (कण्ठ, तालु, मूर्धा...)
    val prayatna: TrilingualText, // Articulation effort (विवृत, संवृत, स्पृष्ट...)
    val exampleWord: String,
    val exampleMeaning: TrilingualText,
    val pronunciationTip: TrilingualText
)

// Maheshwara Sutras
data class MaheshwaraSutra(
    val id: Int,
    val sutra: String,
    val iast: String,
    val includedLetters: String,
    val explanation: TrilingualText
)

// Shabda Rupa (Noun Declension)
data class VibhaktiRow(
    val vibhaktiNumber: Int,
    val vibhaktiName: TrilingualText,
    val singular: String,
    val dual: String,
    val plural: String,
    val meaningSummary: TrilingualText
)

data class ShabdaRupaTable(
    val id: String,
    val title: String,
    val baseWord: String,
    val gender: TrilingualText,
    val endingType: String, // e.g. "अकारान्त"
    val meaning: TrilingualText,
    val rows: List<VibhaktiRow>
)

// Dhatu Rupa (Verb Conjugation)
data class PurushaRow(
    val purushaName: TrilingualText, // प्रथम, मध्यम, उत्तम
    val singular: String,
    val dual: String,
    val plural: String,
    val pronounExample: String // सः/तौ/ते or त्वम्/युवाम्/यूयम् or अहम्/आवाम्/वयम्
)

data class DhatuRupaTable(
    val id: String,
    val root: String,
    val rootMeaning: TrilingualText,
    val lakara: String, // लट्, लङ्, लृट्, लोट्, विधिलिङ्
    val lakaraName: TrilingualText,
    val rows: List<PurushaRow>
)

// Sandhi Rules
data class SandhiRule(
    val id: String,
    val name: TrilingualText,
    val formula: String,
    val explanation: TrilingualText,
    val examples: List<SandhiExample>
)

data class SandhiExample(
    val firstWord: String,
    val secondWord: String,
    val combinedWord: String,
    val meaning: TrilingualText
)

// Karaka (Cases & Syntax)
data class KarakaTopic(
    val id: String,
    val name: TrilingualText,
    val vibhakti: TrilingualText,
    val definition: TrilingualText,
    val exampleSentence: String,
    val sentenceBreakdown: TrilingualText
)

// Spoken Sanskrit (Conversations & Phrases)
data class ConversationPhrase(
    val id: String,
    val category: TrilingualText,
    val sanskrit: String,
    val iast: String,
    val nepali: String,
    val english: String
)

// Subhashita (Wisdom Slokas)
data class Subhashita(
    val id: String,
    val title: TrilingualText,
    val slokaText: String,
    val source: String,
    val padachheda: String,
    val anvaya: String,
    val nepaliMeaning: String,
    val englishMeaning: String,
    val sanskritMeaning: String,
    val moralTeaching: TrilingualText
)

// Thematic Vocabulary
data class VocabWord(
    val id: String,
    val category: TrilingualText,
    val sanskrit: String,
    val iast: String,
    val nepali: String,
    val english: String,
    val gender: String = "पुं" // पुं / स्त्री / नपुं
)

// Quizzes & Practice
data class QuizQuestion(
    val id: String,
    val category: String,
    val question: TrilingualText,
    val options: List<TrilingualText>,
    val correctIndex: Int,
    val explanation: TrilingualText,
    val xpValue: Int = 10
)

// Flashcard for spaced repetition
data class FlashcardItem(
    val id: String,
    val sanskritFront: String,
    val iastFront: String,
    val nepaliBack: String,
    val englishBack: String,
    val grammaticalHint: TrilingualText,
    val category: String
)

// Culture, Traditions & History
data class CultureArticle(
    val id: String,
    val title: TrilingualText,
    val category: TrilingualText,
    val subtitle: TrilingualText,
    val content: TrilingualText,
    val highlightVerse: String? = null,
    val keyFacts: List<TrilingualText> = emptyList()
)

