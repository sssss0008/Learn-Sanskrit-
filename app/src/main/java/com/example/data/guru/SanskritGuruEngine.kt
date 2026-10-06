package com.example.data.guru

import com.example.data.model.AppLanguage
import com.example.data.model.TrilingualText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

data class SentenceComponent(
    val id: String,
    val sanskrit: String,
    val nepali: String,
    val english: String,
    val caseOrPerson: String
)

data class GeneratedSentence(
    val sanskrit: String,
    val nepali: String,
    val english: String,
    val grammarExplanation: TrilingualText
)

data class GuruMessage(
    val id: String,
    val isUser: Boolean,
    val text: String,
    val sanskritQuote: String? = null,
    val explanation: TrilingualText? = null,
    val timestamp: Long = System.currentTimeMillis()
)

class SanskritGuruEngine {

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    // Pre-built sentence builder components
    val subjects = listOf(
        SentenceComponent("s1", "अहम् (Aham)", "म (I)", "I", "उत्तमपुरुषः / 1st Person"),
        SentenceComponent("s2", "वयम् (Vayam)", "हामीहरू (We)", "We", "उत्तमपुरुषः बहुवचन / 1st Person Plural"),
        SentenceComponent("s3", "त्वम् (Tvam)", "तपाईं / तिमी (You)", "You", "मध्यमपुरुषः / 2nd Person"),
        SentenceComponent("s4", "यूयम् (Yūyam)", "तपाईंहरू (You all)", "You all", "मध्यमपुरुषः बहुवचन / 2nd Person Plural"),
        SentenceComponent("s5", "सः (Saḥ)", "उनी / त्यो (He)", "He / That", "प्रथमपुरुषः पुं / 3rd Person Masc"),
        SentenceComponent("s6", "सा (Sā)", "उनी / त्यो (She)", "She / That", "प्रथमपुरुषः स्त्री / 3rd Person Fem"),
        SentenceComponent("s7", "बालकः (Bālakaḥ)", "बालकले (The boy)", "The boy", "प्रथमा विभक्तिः / Subject"),
        SentenceComponent("s8", "छात्रा (Chātrā)", "छात्राले (The student)", "The student", "प्रथमा विभक्तिः / Subject")
    )

    val objects = listOf(
        SentenceComponent("o1", "पुस्तकम् (Pustakam)", "किताबलाई (Book)", "the book", "द्वितीया कर्म / Accusative"),
        SentenceComponent("o2", "संस्कृतम् (Saṃskṛtam)", "संस्कृतलाई (Sanskrit)", "Sanskrit", "द्वितीया कर्म / Accusative"),
        SentenceComponent("o3", "गृहम् (Gṛham)", "घरतर्फ (Home)", "to home", "द्वितीया कर्म / Accusative"),
        SentenceComponent("o4", "विद्यालयम् (Vidyālayam)", "विद्यालयतर्फ (School)", "to school", "द्वितीया कर्म / Accusative"),
        SentenceComponent("o5", "जलम् (Jalam)", "पानी (Water)", "water", "द्वितीया कर्म / Accusative"),
        SentenceComponent("o6", "फलम् (Phalam)", "फल (Fruit)", "a fruit", "द्वितीया कर्म / Accusative"),
        SentenceComponent("o7", "श्लोकम् (Ślokam)", "श्लोकलाई (Sloka)", "the verse", "द्वितीया कर्म / Accusative")
    )

    val verbs = listOf(
        SentenceComponent("v1", "पठ् (Read)", "पढ्नु (Read)", "read", "Root"),
        SentenceComponent("v2", "गम् (Go)", "जानु (Go)", "go", "Root"),
        SentenceComponent("v3", "लिख् (Write)", "लेख्नु (Write)", "write", "Root"),
        SentenceComponent("v4", "खाद् (Eat)", "खानु (Eat)", "eat", "Root"),
        SentenceComponent("v5", "पा (Drink)", "पिउनु (Drink)", "drink", "Root"),
        SentenceComponent("v6", "स्मृ (Remember)", "सम्झनु (Remember)", "memorize/chant", "Root")
    )

    fun constructSentence(subjectId: String, objectId: String, verbId: String): GeneratedSentence {
        // Logic for agreement of Subject and Verb
        val (subjSkt, subjNep, subjEng) = when (subjectId) {
            "s1" -> Triple("अहं", "म", "I")
            "s2" -> Triple("वयं", "हामीहरू", "We")
            "s3" -> Triple("त्वं", "तपाईं", "You")
            "s4" -> Triple("यूयं", "तपाईंहरू", "You all")
            "s5" -> Triple("सः", "उहाँ", "He")
            "s6" -> Triple("सा", "उहाँ", "She")
            "s7" -> Triple("बालकः", "बालक", "The boy")
            "s8" -> Triple("छात्रा", "छात्रा", "The student")
            else -> Triple("अहं", "म", "I")
        }

        val (objSkt, objNep, objEng) = when (objectId) {
            "o1" -> Triple("पुस्तकं", "किताब", "the book")
            "o2" -> Triple("संस्कृतं", "संस्कृत", "Sanskrit")
            "o3" -> Triple("गृहं", "घर", "home")
            "o4" -> Triple("विद्यालयं", "विद्यालय", "to school")
            "o5" -> Triple("जलं", "पानी", "water")
            "o6" -> Triple("फलं", "फल", "fruit")
            "o7" -> Triple("श्लोकं", "श्लोक", "the verse")
            else -> Triple("पुस्तकं", "किताब", "the book")
        }

        val (verbSkt, verbNep, verbEng) = when (verbId) {
            "v1" -> when (subjectId) {
                "s1" -> Triple("पठामि।", "पढ्छु।", "read.")
                "s2" -> Triple("पठामः।", "पढ्छौँ।", "read.")
                "s3" -> Triple("पठसि।", "पढ्नुहुन्छ।", "read.")
                "s4" -> Triple("पठथ।", "पढ्नुहुन्छ।", "read.")
                else -> Triple("पठति।", "पढ्नुहुन्छ / पढ्छ।", "reads.")
            }
            "v2" -> when (subjectId) {
                "s1" -> Triple("गच्छामि।", "जान्छु।", "go.")
                "s2" -> Triple("गच्छामः।", "जान्छौँ।", "go.")
                "s3" -> Triple("गच्छसि।", "जानुहुन्छ।", "go.")
                "s4" -> Triple("गच्छथ।", "जानुहुन्छ।", "go.")
                else -> Triple("गच्छति।", "जानुहुन्छ / जान्छ।", "goes.")
            }
            "v3" -> when (subjectId) {
                "s1" -> Triple("लिखामि।", "लेख्छु।", "write.")
                "s2" -> Triple("लिखामः।", "लेख्छौँ।", "write.")
                "s3" -> Triple("लिखसि।", "लेख्नुहुन्छ।", "write.")
                "s4" -> Triple("लिखथ।", "लेख्नुहुन्छ।", "write.")
                else -> Triple("लिखति।", "लेख्नुहुन्छ / लेख्छ।", "writes.")
            }
            "v4" -> when (subjectId) {
                "s1" -> Triple("खादामि।", "खान्छु।", "eat.")
                "s2" -> Triple("खादामः।", "खान्छौँ।", "eat.")
                "s3" -> Triple("खादसि।", "खानुहुन्छ।", "eat.")
                "s4" -> Triple("खादथ।", "खानुहुन्छ।", "eat.")
                else -> Triple("खादति।", "खानुहुन्छ / खान्छ।", "eats.")
            }
            "v5" -> when (subjectId) {
                "s1" -> Triple("पिबामि।", "पिउँछु।", "drink.")
                "s2" -> Triple("पिबामः।", "पिउँछौँ।", "drink.")
                "s3" -> Triple("पिबसि।", "पिउनुहुन्छ।", "drink.")
                "s4" -> Triple("पिबथ।", "पिउनुहुन्छ।", "drink.")
                else -> Triple("पिबति।", "पिउनुहुन्छ / पिउँछ।", "drinks.")
            }
            else -> when (subjectId) {
                "s1" -> Triple("स्मरामि।", "स्मरण गर्छु।", "remember.")
                "s2" -> Triple("स्मरामः।", "स्मरण गर्छौँ।", "remember.")
                "s3" -> Triple("स्मरसि।", "स्मरण गर्नुहुन्छ।", "remember.")
                "s4" -> Triple("स्मरथ।", "स्मरण गर्नुहुन्छ।", "remember.")
                else -> Triple("स्मरति।", "स्मरण गर्नुहुन्छ।", "remembers.")
            }
        }

        val sktSentence = "$subjSkt $objSkt $verbSkt"
        val nepSentence = "$subjNep $objNep $verbNep"
        val engSentence = "$subjEng $verbEng $objEng"

        val explanation = TrilingualText(
            sa = "अत्र कर्ता प्रथमायाम्, कर्म द्वितीयायाम्, क्रिया च कर्तुरनुसारं लट्-लकारे वर्तते।",
            ne = "यहाँ कर्तामा प्रथमा, कर्ममा द्वितीया विभक्ति र क्रिया कर्ताको पुरुष/वचन अनुसार लट् लकारमा प्रयोग भएको छ।",
            en = "In this sentence, the Subject is in Nominative case, Object in Accusative case, and Verb agrees with the subject in Person and Number."
        )

        return GeneratedSentence(sktSentence, nepSentence, engSentence, explanation)
    }

    // Offline Sanskrit Acharya Knowledge Base
    suspend fun consultGuru(query: String, lang: AppLanguage, apiKey: String? = null): GuruMessage {
        val trimmed = query.trim().lowercase()

        // If API key is available, attempt real Gemini REST API call
        if (!apiKey.isNullOrEmpty() && apiKey != "MY_GEMINI_API_KEY") {
            try {
                val aiResponse = callGeminiApi(query, lang, apiKey)
                if (!aiResponse.isNullOrBlank()) {
                    return GuruMessage(
                        id = System.currentTimeMillis().toString(),
                        isUser = false,
                        text = aiResponse
                    )
                }
            } catch (e: Exception) {
                // Fallback to offline Acharya logic smoothly
            }
        }

        // Intelligent Offline Acharya Logic
        return withContext(Dispatchers.Default) {
            val response = when {
                trimmed.contains("sandhi") || trimmed.contains("सन्धि") -> {
                    GuruMessage(
                        id = System.currentTimeMillis().toString(),
                        isUser = false,
                        text = when (lang) {
                            AppLanguage.SANSKRIT -> "सन्धिः नाम द्वयोः वर्णयोः परस्परं मेलनेन जातः विकारः। मुख्यतया सन्धिः त्रिविधः - स्वरसन्धिः (अच्), व्यञ्जनसन्धिः (हल्), विसर्गसन्धिश्च।"
                            AppLanguage.NEPALI -> "सन्धि भनेको दुई वर्णहरू आपसमा जोडिँदा हुने ध्वनि परिवर्तन हो। सन्धि मुख्यतया ३ प्रकारका हुन्छन्: १. स्वर सन्धि (अच्) २. व्यञ्जन सन्धि (हल्) र ३. विसर्ग सन्धि।"
                            AppLanguage.ENGLISH -> "Sandhi means phonetic junction between words or sounds. There are 3 main types: 1. Svara Sandhi (Vowels) 2. Vyanjana Sandhi (Consonants) and 3. Visarga Sandhi."
                        },
                        sanskritQuote = "परः संनिकर्षः संहिता॥ (पाणिनि १.४.१०९)"
                    )
                }
                trimmed.contains("panini") || trimmed.contains("पाणिनि") || trimmed.contains("sutra") || trimmed.contains("सूत्र") -> {
                    GuruMessage(
                        id = System.currentTimeMillis().toString(),
                        isUser = false,
                        text = when (lang) {
                            AppLanguage.SANSKRIT -> "महर्षिः पाणिनिः संस्कृतव्याकरणस्य पिता मन्यते। तेन 'अष्टाध्यायी' ग्रन्थे प्रायः ४००० सूत्राणि रचितानि। माहेश्वरसूत्राणि अस्य आधारस्तम्भाः सन्ति।"
                            AppLanguage.NEPALI -> "महर्षि पाणिनि संस्कृत व्याकरणका प्रवर्तक हुन्। उनले 'अष्टाध्यायी' ग्रन्थमा करिब ४,००० सूत्रहरू मार्फत संस्कृतलाई विश्वकै सबैभन्दा वैज्ञानिक भाषा बनाए। शिवजीको डमरूबाट निस्केका १४ माहेश्वर सूत्रहरू यसका आधार हुन्।"
                            AppLanguage.ENGLISH -> "Maharishi Panini is the master grammarian of Sanskrit. In his monumental work 'Ashtadhyayi', he formulated around 4,000 algorithmic sutras rooted in the 14 Shiva Sutras."
                        },
                        sanskritQuote = "वृद्धिरादैच्॥ (अष्टाध्यायी १.१.१)"
                    )
                }
                trimmed.contains("vibhakti") || trimmed.contains("विभक्ति") || trimmed.contains("case") -> {
                    GuruMessage(
                        id = System.currentTimeMillis().toString(),
                        isUser = false,
                        text = when (lang) {
                            AppLanguage.SANSKRIT -> "संस्कृते सप्त विभक्तयः सन्ति - प्रथमा (कर्ता), द्वितीया (कर्म), तृतीया (करणम्), चतुर्थी (सम्प्रदानम्), पञ्चमी (अपादानम्), षष्ठी (सम्बन्धः), सप्तमी (अधिकरणम्)। सम्बोधनं प्रथमायाः एव रूपविशेषः।"
                            AppLanguage.NEPALI -> "संस्कृतमा सातवटा मुख्य विभक्तिहरू हुन्छन्: प्रथमा (ले), द्वितीया (लाई), तृतीया (ले/द्वारा), चतुर्थी (का लागि), पञ्चमी (बाट), षष्ठी (को/का/की), सप्तमी (मा/माथि) र सम्बोधन (हे!)।"
                            AppLanguage.ENGLISH -> "Sanskrit has 7 case forms (Vibhaktis): Nominative (Subject), Accusative (Object), Instrumental (By/With), Dative (For), Ablative (From), Genitive (Of), and Locative (In/At/On), along with Vocative."
                        },
                        sanskritQuote = "सुप्तिङन्तं पदम्॥ (१.४.१४)"
                    )
                }
                trimmed.contains("lakara") || trimmed.contains("लकार") || trimmed.contains("tense") || trimmed.contains("काल") -> {
                    GuruMessage(
                        id = System.currentTimeMillis().toString(),
                        isUser = false,
                        text = when (lang) {
                            AppLanguage.SANSKRIT -> "संस्कृते दश लकाराः सन्ति, तेषु पञ्च मुख्याः - लट् (वर्तमान), लृट् (भविष्यत्), लङ् (भूत), लोट् (आज्ञा), विधिलिङ् (प्रार्थना/सम्भावना)।"
                            AppLanguage.NEPALI -> "संस्कृतमा जम्मा १० लकारहरू हुन्छन्, जसमा ५ वटा दैनिक प्रयोगमा मुख्य छन्: लट् (वर्तमान काल), लृट् (भविष्यत् काल), लङ् (भूतकाल), लोट् (आज्ञार्थक), र विधिलिङ् (चाहिन्छ/हुनुपर्छ)।"
                            AppLanguage.ENGLISH -> "Sanskrit features 10 Lakāras (moods/tenses), of which 5 are most essential: Laṭ (Present), Lṛṭ (Future), Laṅ (Past Imperfect), Loṭ (Imperative/Command), and Vidhiliṅ (Optative/Potential)."
                        },
                        sanskritQuote = "लट् वर्तमाने॥ लृट् शेषे च॥"
                    )
                }
                trimmed.contains("greetings") || trimmed.contains("अभिवादन") || trimmed.contains("namaste") || trimmed.contains("hello") -> {
                    GuruMessage(
                        id = System.currentTimeMillis().toString(),
                        isUser = false,
                        text = when (lang) {
                            AppLanguage.SANSKRIT -> "संस्कृते अभिवादनाय 'हरिः ॐ', 'नमो नमः', 'प्रणामाः', 'सुप्रभातम्', 'शुभरात्रिः' च प्रयुज्यन्ते। कृतज्ञतायै 'धन्यवादः' कथ्यते।"
                            AppLanguage.NEPALI -> "संस्कृतमा अभिवादनका लागि 'हरिः ॐ!', 'नमो नमः!', 'नमस्ते!', 'सुप्रभातम्!' भनिन्छ। विदा हुँदा 'पुनर्मिलामः!' (फेरि भेटौँला) भनिन्छ।"
                            AppLanguage.ENGLISH -> "Traditional Sanskrit greetings include 'Hariḥ Om!', 'Namo Namaḥ!', 'Suprabhātam!' (Good morning), and upon departing 'Punarmilāmaḥ!' (See you again)."
                        },
                        sanskritQuote = "अभिवादनशीलस्य नित्यं वृद्धोपसेविनः। चत्वारि तस्य वर्धन्ते आयुर्विद्या यशो बलम्॥"
                    )
                }
                else -> {
                    GuruMessage(
                        id = System.currentTimeMillis().toString(),
                        isUser = false,
                        text = when (lang) {
                            AppLanguage.SANSKRIT -> "साधु पृष्टम्! संस्कृतभाषा देववाणी अस्ति। अत्र व्याकरणं सुस्पष्टं वैज्ञानिकं च वर्तते। व्याकरण-सम्बन्धि, श्लोक-सम्बन्धि वा प्रश्नं पुनः पृच्छतु।"
                            AppLanguage.NEPALI -> "राम्रो जिज्ञासा! संस्कृत भाषा सबै ज्ञान-विज्ञानको जननी र अत्यन्त वैज्ञानिक भाषा हो। तपाईंले सन्धि, विभक्ति, लकार, शब्दरूप, धातुरूप वा श्लोकका बारेमा सोध्न सक्नुहुन्छ।"
                            AppLanguage.ENGLISH -> "Wonderful question! Sanskrit is an exquisite and algorithmic language. You can ask about Sandhi rules, Vibhakti noun cases, Lakāra verb tenses, Shloka meanings, or sentence structures."
                        },
                        sanskritQuote = "संस्कृतं नाम दैवी वागन्वाख्याता महर्षिभिः॥"
                    )
                }
            }
            response
        }
    }

    private suspend fun callGeminiApi(prompt: String, lang: AppLanguage, apiKey: String): String? = withContext(Dispatchers.IO) {
        val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=$apiKey"
        val langInstruction = when (lang) {
            AppLanguage.SANSKRIT -> "Respond primarily in clear, simple Sanskrit (देववाणी) with Devanagari script."
            AppLanguage.NEPALI -> "Respond in natural, polite Nepali (नेपाली भाषा) with Sanskrit shlokas/examples where helpful."
            AppLanguage.ENGLISH -> "Respond in clear English with Sanskrit Devanagari terms and IAST transliterations."
        }

        val systemPrompt = "You are a venerable and scholarly Sanskrit Acharya (वैयाकरण-गुरुः). You guide students in learning Sanskrit grammar (Paninian vyakarana), vocabulary, shlokas, and daily conversation. Always be warm, clear, and authentic. $langInstruction"

        val jsonBody = JSONObject().apply {
            put("contents", JSONArray().apply {
                put(JSONObject().apply {
                    put("role", "user")
                    put("parts", JSONArray().apply {
                        put(JSONObject().put("text", "$systemPrompt\n\nStudent Query: $prompt"))
                    })
                })
            })
        }

        val request = Request.Builder()
            .url(url)
            .post(jsonBody.toString().toRequestBody("application/json".toMediaType()))
            .build()

        httpClient.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                val respText = response.body?.string() ?: return@withContext null
                val rootObj = JSONObject(respText)
                val candidates = rootObj.optJSONArray("candidates")
                if (candidates != null && candidates.length() > 0) {
                    val candidate = candidates.getJSONObject(0)
                    val content = candidate.optJSONObject("content")
                    val parts = content?.optJSONArray("parts")
                    if (parts != null && parts.length() > 0) {
                        return@withContext parts.getJSONObject(0).optString("text")
                    }
                }
            }
        }
        null
    }
}
