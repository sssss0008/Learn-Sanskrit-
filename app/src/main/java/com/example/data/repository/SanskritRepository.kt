package com.example.data.repository

import com.example.data.model.*

object SanskritRepository {

    // -------------------------------------------------------------
    // VARNAMALA (वर्णमाला)
    // -------------------------------------------------------------
    val swaras: List<VarnamalaItem> = listOf(
        VarnamalaItem(
            character = "अ", iast = "a", category = VarnaCategory.SWARA,
            sthana = TrilingualText("कण्ठः (Throat)", "कण्ठ (घाँटी)", "Guttural (Throat)"),
            prayatna = TrilingualText("विवृतम् (Open)", "विवृत (खुला)", "Open (Vivrita)"),
            exampleWord = "अश्वः",
            exampleMeaning = TrilingualText("घोटकः (Horse)", "घोडा (Horse)", "Horse"),
            pronunciationTip = TrilingualText("ह्रस्व स्वरः (Short vowel)", "छोटो स्वर ध्वनि", "Short neutral vowel like 'u' in cup")
        ),
        VarnamalaItem(
            character = "आ", iast = "ā", category = VarnaCategory.SWARA,
            sthana = TrilingualText("कण्ठः (Throat)", "कण्ठ (घाँटी)", "Guttural (Throat)"),
            prayatna = TrilingualText("विवृतम् (Open)", "विवृत (खुला)", "Open (Vivrita)"),
            exampleWord = "आकाशः",
            exampleMeaning = TrilingualText("गगनम् (Sky)", "आकाश (Sky)", "Sky / Space"),
            pronunciationTip = TrilingualText("दीर्घ स्वरः (Long vowel - 2 matras)", "लामो स्वर (दुई मात्रा)", "Long vowel like 'a' in father")
        ),
        VarnamalaItem(
            character = "इ", iast = "i", category = VarnaCategory.SWARA,
            sthana = TrilingualText("तालु (Palate)", "तालु (Palate)", "Palatal"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "इक्षुः",
            exampleMeaning = TrilingualText("मधुरदण्डः (Sugarcane)", "उखु (Sugarcane)", "Sugarcane"),
            pronunciationTip = TrilingualText("ह्रस्व इकारः", "छोटो ह्रस्व इ", "Short vowel like 'i' in bit")
        ),
        VarnamalaItem(
            character = "ई", iast = "ī", category = VarnaCategory.SWARA,
            sthana = TrilingualText("तालु (Palate)", "तालु", "Palatal"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "ईश्वरः",
            exampleMeaning = TrilingualText("परमात्मा (God)", "भगवान् (God)", "Lord / God"),
            pronunciationTip = TrilingualText("दीर्घ ईकारः (२ मात्रा)", "दीर्घ ई ध्वनि", "Long vowel like 'ee' in feel")
        ),
        VarnamalaItem(
            character = "उ", iast = "u", category = VarnaCategory.SWARA,
            sthana = TrilingualText("ओष्ठौ (Lips)", "ओठ (Lips)", "Labial (Lips)"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "उत्पलम्",
            exampleMeaning = TrilingualText("कमलम् (Lotus)", "कमल (Lotus)", "Lotus flower"),
            pronunciationTip = TrilingualText("ह्रस्व उकारः", "ह्रस्व उ", "Short vowel like 'u' in put")
        ),
        VarnamalaItem(
            character = "ऊ", iast = "ū", category = VarnaCategory.SWARA,
            sthana = TrilingualText("ओष्ठौ (Lips)", "ओठ (Lips)", "Labial (Lips)"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "ऊर्जा",
            exampleMeaning = TrilingualText("शक्तिः (Energy)", "शक्ति / बल", "Energy / Vitality"),
            pronunciationTip = TrilingualText("दीर्घ ऊकारः", "लामो ऊ ध्वनि", "Long vowel like 'oo' in cool")
        ),
        VarnamalaItem(
            character = "ऋ", iast = "ṛ", category = VarnaCategory.SWARA,
            sthana = TrilingualText("मूर्धा (Roof of Mouth)", "मूर्धा (तालुको माथिल्लो भाग)", "Retroflex (Roof of Mouth)"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "ऋषिः",
            exampleMeaning = TrilingualText("मुनिः (Sage)", "तपस्वी ऋषि (Sage)", "Vedic Sage / Seer"),
            pronunciationTip = TrilingualText("मूर्धन्य स्वरः - जिह्वा मूर्धनि स्पृशति", "जिभ्रो माथितिर घुमाएर उच्चारण गर्ने", "Vocalic r with tongue curled toward palate")
        ),
        VarnamalaItem(
            character = "ॠ", iast = "ṝ", category = VarnaCategory.SWARA,
            sthana = TrilingualText("मूर्धा (Roof of Mouth)", "मूर्धा", "Retroflex"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "पितॄणाम्",
            exampleMeaning = TrilingualText("पूर्वजानाम् (Of Ancestors)", "पितृहरूको (Of ancestors)", "Of the ancestors"),
            pronunciationTip = TrilingualText("दीर्घ ऋकारः", "दीर्घ ॠ ध्वनि", "Prolonged vocalic r")
        ),
        VarnamalaItem(
            character = "ऌ", iast = "ḷ", category = VarnaCategory.SWARA,
            sthana = TrilingualText("दन्ताः (Teeth)", "दाँत (Teeth)", "Dental"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "ऌकारः",
            exampleMeaning = TrilingualText("वर्णविशेषः (The letter Lri)", "ऌ वर्ण (The letter Lri)", "Vocalic l sound"),
            pronunciationTip = TrilingualText("दन्त्य स्वरः", "दन्त्य स्वर ध्वनि", "Vocalic l")
        ),
        VarnamalaItem(
            character = "ए", iast = "e", category = VarnaCategory.SWARA,
            sthana = TrilingualText("कण्ठतालु (Throat + Palate)", "कण्ठ र तालु", "Guttural-Palatal"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "एकता",
            exampleMeaning = TrilingualText("ऐक्यम् (Unity)", "एकता (Unity)", "Unity / Oneness"),
            pronunciationTip = TrilingualText("संयुक्त स्वरः (अ + इ = ए)", "अ र इ मिलेर बनेको संयुक्त स्वर", "Diphthong (a + i = e)")
        ),
        VarnamalaItem(
            character = "ऐ", iast = "ai", category = VarnaCategory.SWARA,
            sthana = TrilingualText("कण्ठतालु (Throat + Palate)", "कण्ठ र तालु", "Guttural-Palatal"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "ऐरावतः",
            exampleMeaning = TrilingualText("इन्द्रहस्ती (Indra's Elephant)", "इन्द्रको हात्ती", "Celestial White Elephant"),
            pronunciationTip = TrilingualText("संयुक्त स्वरः (अ + ए = ऐ)", "अ र ए को संयोजन", "Diphthong like 'ai' in aisle")
        ),
        VarnamalaItem(
            character = "ओ", iast = "o", category = VarnaCategory.SWARA,
            sthana = TrilingualText("कण्ठोष्ठम् (Throat + Lips)", "कण्ठ र ओठ", "Guttural-Labial"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "ओजः",
            exampleMeaning = TrilingualText("तेजः (Luster / Vital Power)", "तेज, चमक, कान्ति", "Radiance / Vital vigor"),
            pronunciationTip = TrilingualText("संयुक्त स्वरः (अ + उ = ओ)", "अ र उ को मिश्रण", "Diphthong like 'o' in boat")
        ),
        VarnamalaItem(
            character = "औ", iast = "au", category = VarnaCategory.SWARA,
            sthana = TrilingualText("कण्ठोष्ठम् (Throat + Lips)", "कण्ठ र ओठ", "Guttural-Labial"),
            prayatna = TrilingualText("विवृतम्", "विवृत", "Open"),
            exampleWord = "औषधम्",
            exampleMeaning = TrilingualText("भेषजम् (Medicine)", "औषधि (Medicine)", "Medicine / Remedy"),
            pronunciationTip = TrilingualText("संयुक्त स्वरः (अ + ओ = औ)", "अ र ओ को संयोजन", "Diphthong like 'ou' in out")
        ),
        VarnamalaItem(
            character = "अं", iast = "aṃ", category = VarnaCategory.AYOGAVAHA,
            sthana = TrilingualText("नासिका (Nose)", "नाक (Nose)", "Nasal"),
            prayatna = TrilingualText("अनुस्वारः", "अनुस्वार", "Anusvara"),
            exampleWord = "अंशः",
            exampleMeaning = TrilingualText("भागः (Part/Share)", "भाग वा अंश", "Part / Share / Portion"),
            pronunciationTip = TrilingualText("अनुस्वारः - स्वरादनु भवति", "स्वरको पछाडि आउने नासिक्य ध्वनि", "Pure nasal echo following a vowel")
        ),
        VarnamalaItem(
            character = "अः", iast = "aḥ", category = VarnaCategory.AYOGAVAHA,
            sthana = TrilingualText("कण्ठः (Throat)", "कण्ठ (Throat)", "Throat / Aspirate"),
            prayatna = TrilingualText("विसर्गः", "विसर्ग", "Visarga"),
            exampleWord = "रामः",
            exampleMeaning = TrilingualText("श्रीरामः (Rama)", "राम (Rama)", "Lord Rama"),
            pronunciationTip = TrilingualText("विसर्गः - श्वासध्वनिः", "हल्का सास छोडेर गरिने 'ह' जस्तो उच्चारण", "Soft vocalic aspiration (echo of prior vowel)")
        )
    )

    val vyanjanas: List<VarnamalaItem> = listOf(
        // क वर्ग (Gutturals)
        VarnamalaItem("क", "ka", VarnaCategory.SPARSHA, TrilingualText("कण्ठः", "कण्ठ", "Guttural (Velar)"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "कमलम्", TrilingualText("Lotus", "कमल", "Lotus"), TrilingualText("अल्पप्राण अघोष", "अल्पप्राण", "Unvoiced unaspirated")),
        VarnamalaItem("ख", "kha", VarnaCategory.SPARSHA, TrilingualText("कण्ठः", "कण्ठ", "Guttural (Velar)"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "खगः", TrilingualText("पक्षी (Bird)", "चरा (Bird)", "Bird"), TrilingualText("महाप्राण अघोष", "महाप्राण", "Unvoiced aspirated")),
        VarnamalaItem("ग", "ga", VarnaCategory.SPARSHA, TrilingualText("कण्ठः", "कण्ठ", "Guttural (Velar)"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "गजः", TrilingualText("हस्ती (Elephant)", "हात्ती (Elephant)", "Elephant"), TrilingualText("अल्पप्राण घोष", "अल्पप्राण घोष", "Voiced unaspirated")),
        VarnamalaItem("घ", "gha", VarnaCategory.SPARSHA, TrilingualText("कण्ठः", "कण्ठ", "Guttural (Velar)"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "घटः", TrilingualText("कुम्भः (Pot)", "घैँटो (Pot)", "Water Pot"), TrilingualText("महाप्राण घोष", "महाप्राण घोष", "Voiced aspirated")),
        VarnamalaItem("ङ", "ṅa", VarnaCategory.SPARSHA, TrilingualText("कण्ठः + नासिका", "कण्ठ र नाक", "Guttural-Nasal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "गङ्गा", TrilingualText("पवित्रनदी", "गङ्गा नदी", "Sacred river Ganges"), TrilingualText("नासिक्य घोष", "नासिक्य वर्ण", "Velar nasal")),

        // च वर्ग (Palatals)
        VarnamalaItem("च", "ca", VarnaCategory.SPARSHA, TrilingualText("तालु", "तालु", "Palatal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "चन्द्रः", TrilingualText("Moon", "चन्द्रमा", "Moon"), TrilingualText("अल्पप्राण अघोष", "अल्पप्राण", "Unvoiced unaspirated palatal")),
        VarnamalaItem("छ", "cha", VarnaCategory.SPARSHA, TrilingualText("तालु", "तालु", "Palatal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "छात्रः", TrilingualText("विद्यार्थी (Student)", "विद्यार्थी", "Student"), TrilingualText("महाप्राण अघोष", "महाप्राण", "Unvoiced aspirated palatal")),
        VarnamalaItem("ज", "ja", VarnaCategory.SPARSHA, TrilingualText("तालु", "तालु", "Palatal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "जलम्", TrilingualText("तोयम् (Water)", "पानी / जल", "Water"), TrilingualText("अल्पप्राण घोष", "अल्पप्राण घोष", "Voiced unaspirated palatal")),
        VarnamalaItem("झ", "jha", VarnaCategory.SPARSHA, TrilingualText("तालु", "तालु", "Palatal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "झषः", TrilingualText("मत्स्यः (Fish)", "माछा (Fish)", "Fish"), TrilingualText("महाप्राण घोष", "महाप्राण घोष", "Voiced aspirated palatal")),
        VarnamalaItem("ञ", "ña", VarnaCategory.SPARSHA, TrilingualText("तालु + नासिका", "तालु र नाक", "Palatal-Nasal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "ज्ञानम्", TrilingualText("विद्या (Knowledge)", "ज्ञान / विद्या", "Wisdom / Knowledge"), TrilingualText("नासिक्य घोष", "नासिक्य", "Palatal nasal")),

        // ट वर्ग (Retroflex)
        VarnamalaItem("ट", "ṭa", VarnaCategory.SPARSHA, TrilingualText("मूर्धा", "मूर्धा", "Retroflex"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "टीका", TrilingualText("भाष्यम् (Commentary)", "व्याख्या / टीका", "Commentary"), TrilingualText("अल्पप्राण", "अल्पप्राण", "Retroflex stop")),
        VarnamalaItem("ठ", "ṭha", VarnaCategory.SPARSHA, TrilingualText("मूर्धा", "मूर्धा", "Retroflex"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "ठक्कुरः", TrilingualText("पूज्यः (Venerable)", "पूज्य व्यक्ति", "Venerable person"), TrilingualText("महाप्राण", "महाप्राण", "Aspirated retroflex")),
        VarnamalaItem("ड", "ḍa", VarnaCategory.SPARSHA, TrilingualText("मूर्धा", "मूर्धा", "Retroflex"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "डमरुः", TrilingualText("शिववाद्यम् (Drum)", "डमरू", "Shiva's drum"), TrilingualText("अल्पप्राण घोष", "घोष", "Voiced retroflex")),
        VarnamalaItem("ढ", "ḍha", VarnaCategory.SPARSHA, TrilingualText("मूर्धा", "मूर्धा", "Retroflex"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "ढक्का", TrilingualText("बृहद्वाद्यम् (Kettledrum)", "ठूलो बाजा / ढोल", "Large drum"), TrilingualText("महाप्राण घोष", "महाप्राण घोष", "Voiced aspirated retroflex")),
        VarnamalaItem("ण", "ṇa", VarnaCategory.SPARSHA, TrilingualText("मूर्धा + नासिका", "मूर्धा र नाक", "Retroflex-Nasal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "वीणा", TrilingualText("सरस्वतीवाद्यम्", "वीणा बाजा", "Lute / Veena instrument"), TrilingualText("नासिक्य घोष", "नासिक्य", "Retroflex nasal")),

        // त वर्ग (Dentals)
        VarnamalaItem("त", "ta", VarnaCategory.SPARSHA, TrilingualText("दन्ताः", "दाँत", "Dental"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "तरुः", TrilingualText("वृक्षः (Tree)", "रुख / वृक्ष", "Tree"), TrilingualText("अल्पप्राण अघोष", "अल्पप्राण", "Pure dental unvoiced")),
        VarnamalaItem("थ", "tha", VarnaCategory.SPARSHA, TrilingualText("दन्ताः", "दाँत", "Dental"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "थाः", TrilingualText("पर्वतः (Mountain)", "पहाड", "Mountain"), TrilingualText("महाप्राण अघोष", "महाप्राण", "Dental aspirated")),
        VarnamalaItem("द", "da", VarnaCategory.SPARSHA, TrilingualText("दन्ताः", "दाँत", "Dental"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "देवः", TrilingualText("सुरः (Deity)", "देवता (God)", "Deity / God"), TrilingualText("अल्पप्राण घोष", "घोष", "Dental voiced")),
        VarnamalaItem("ध", "dha", VarnaCategory.SPARSHA, TrilingualText("दन्ताः", "दाँत", "Dental"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "धर्मः", TrilingualText("सदाचारः (Righteousness)", "धर्म / कर्तव्य", "Cosmic duty / Righteousness"), TrilingualText("महाप्राण घोष", "महाप्राण घोष", "Dental voiced aspirated")),
        VarnamalaItem("न", "na", VarnaCategory.SPARSHA, TrilingualText("दन्ताः + नासिका", "दाँत र नाक", "Dental-Nasal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "नदी", TrilingualText("सरित् (River)", "खोलो / नदी", "River"), TrilingualText("नासिक्य घोष", "नासिक्य", "Dental nasal")),

        // प वर्ग (Labials)
        VarnamalaItem("प", "pa", VarnaCategory.SPARSHA, TrilingualText("ओष्ठौ", "ओठ", "Labial"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "पत्रम्", TrilingualText("पर्णम् (Leaf/Letter)", "पात वा चिठी", "Leaf or Letter"), TrilingualText("अल्पप्राण अघोष", "अल्पप्राण", "Bilabial stop")),
        VarnamalaItem("फ", "pha", VarnaCategory.SPARSHA, TrilingualText("ओष्ठौ", "ओठ", "Labial"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "फलम्", TrilingualText("सस्यम् (Fruit)", "फलफूल (Fruit)", "Fruit"), TrilingualText("महाप्राण अघोष", "महाप्राण", "Aspirated bilabial (not 'f')")),
        VarnamalaItem("ब", "ba", VarnaCategory.SPARSHA, TrilingualText("ओष्ठौ", "ओठ", "Labial"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "बालकः", TrilingualText("शिशुः (Boy)", "केटा / बालक", "Boy / Child"), TrilingualText("अल्पप्राण घोष", "घोष", "Voiced bilabial")),
        VarnamalaItem("भ", "bha", VarnaCategory.SPARSHA, TrilingualText("ओष्ठौ", "ओठ", "Labial"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "भूमिः", TrilingualText("वसुन्धरा (Earth)", "पृथ्वी / जमिन", "Earth / Soil"), TrilingualText("महाप्राण घोष", "महाप्राण घोष", "Voiced aspirated bilabial")),
        VarnamalaItem("म", "ma", VarnaCategory.SPARSHA, TrilingualText("ओष्ठौ + नासिका", "ओठ र नाक", "Labial-Nasal"), TrilingualText("स्पृष्टम्", "स्पृष्ट", "Contact"), "माता", TrilingualText("जननी (Mother)", "आमा (Mother)", "Mother"), TrilingualText("नासिक्य घोष", "नासिक्य", "Bilabial nasal")),

        // अन्तःस्थाः (Semivowels)
        VarnamalaItem("य", "ya", VarnaCategory.ANTASHTHA, TrilingualText("तालु", "तालु", "Palatal"), TrilingualText("ईषत्स्पृष्टम्", "ईषत्स्पृष्ट", "Semi-contact"), "यज्ञः", TrilingualText("हवनम् (Sacrifice)", "यज्ञ / होम", "Sacred ritual"), TrilingualText("अन्तःस्थ", "अन्तःस्थ", "Semivowel y")),
        VarnamalaItem("र", "ra", VarnaCategory.ANTASHTHA, TrilingualText("मूर्धा", "मूर्धा", "Retroflex"), TrilingualText("ईषत्स्पृष्टम्", "ईषत्स्पृष्ट", "Semi-contact"), "रथः", TrilingualText("यानम् (Chariot)", "रथ (Chariot)", "Chariot"), TrilingualText("अन्तःस्थ", "अन्तःस्थ", "Flapped/rolled r")),
        VarnamalaItem("ल", "la", VarnaCategory.ANTASHTHA, TrilingualText("दन्ताः", "दाँत", "Dental"), TrilingualText("ईषत्स्पृष्टम्", "ईषत्स्पृष्ट", "Semi-contact"), "लता", TrilingualText("वल्लरी (Creeper)", "लहरा (Creeper)", "Creeper vine"), TrilingualText("अन्तःस्थ", "अन्तःस्थ", "Lateral semivowel l")),
        VarnamalaItem("व", "va", VarnaCategory.ANTASHTHA, TrilingualText("दन्तोष्ठम्", "दाँत र ओठ", "Dentolabial"), TrilingualText("ईषत्स्पृष्टम्", "ईषत्स्पृष्ट", "Semi-contact"), "वनम्", TrilingualText("अरण्यम् (Forest)", "जङ्गल / वन", "Forest"), TrilingualText("अन्तःस्थ", "अन्तःस्थ", "Dentolabial glide v/w")),

        // ऊष्म-वर्णाः (Sibilants & Aspirate)
        VarnamalaItem("श", "śa", VarnaCategory.USHMANA, TrilingualText("तालु", "तालु", "Palatal"), TrilingualText("ईषद्विवृतम्", "ईषद्विवृत", "Fricative"), "शान्तिः", TrilingualText("शमः (Peace)", "शान्ति (Peace)", "Peace"), TrilingualText("तालव्य श", "तालव्य श", "Palatal sibilant sh")),
        VarnamalaItem("ष", "ṣa", VarnaCategory.USHMANA, TrilingualText("मूर्धा", "मूर्धा", "Retroflex"), TrilingualText("ईषद्विवृतम्", "ईषद्विवृत", "Fricative"), "ऋषिः", TrilingualText("तपस्वी (Sage)", "ऋषि", "Sage"), TrilingualText("मूर्धन्य ष", "मूर्धन्य ष", "Retroflex sibilant sh")),
        VarnamalaItem("स", "sa", VarnaCategory.USHMANA, TrilingualText("दन्ताः", "दाँत", "Dental"), TrilingualText("ईषद्विवृतम्", "ईषद्विवृत", "Fricative"), "सत्यम्", TrilingualText("ऋतम् (Truth)", "सत्य / साँचो", "Truth / Reality"), TrilingualText("दन्त्य स", "दन्त्य स", "Dental sibilant s")),
        VarnamalaItem("ह", "ha", VarnaCategory.USHMANA, TrilingualText("कण्ठः", "कण्ठ", "Guttural (Throat)"), TrilingualText("ईषद्विवृतम्", "ईषद्विवृत", "Fricative"), "हरिः", TrilingualText("विष्णुः (Lord)", "हरि / भगवान्", "Lord Vishnu"), TrilingualText("कण्ठ्य ऊष्म", "कण्ठ्य महाप्राण", "Glottal aspirate h")),

        // संयुक्ताक्षराणि (Conjuncts)
        VarnamalaItem("क्ष", "kṣa", VarnaCategory.SAMYUKTA, TrilingualText("क् + ष्", "क् र ष् को योग", "k + ṣ"), TrilingualText("संयोगः", "संयोग", "Conjunct"), "क्षत्रियः", TrilingualText("योद्धा (Warrior)", "क्षत्रिय योद्धा", "Warrior / Protector"), TrilingualText("संयुक्त वर्णः", "संयुक्त", "Compound k-sha")),
        VarnamalaItem("त्र", "tra", VarnaCategory.SAMYUKTA, TrilingualText("त् + र्", "त् र र् को योग", "t + r"), TrilingualText("संयोगः", "संयोग", "Conjunct"), "त्रिशूलम्", TrilingualText("आयुधम् (Trident)", "त्रिशूल (Trident)", "Trident of Shiva"), TrilingualText("संयुक्त वर्णः", "संयुक्त", "Compound t-ra")),
        VarnamalaItem("ज्ञ", "jña", VarnaCategory.SAMYUKTA, TrilingualText("ज् + ञ्", "ज् र ञ् को योग", "j + ñ"), TrilingualText("संयोगः", "संयोग", "Conjunct"), "ज्ञानम्", TrilingualText("प्रज्ञा (Wisdom)", "ज्ञान / विद्या", "Wisdom / Sacred Science"), TrilingualText("संयुक्त वर्णः", "संयुक्त", "Compound j-nya"))
    )

    // -------------------------------------------------------------
    // MAHESHWARA SUTRAS (माहेश्वर सूत्राणि)
    // -------------------------------------------------------------
    val maheshwaraSutras: List<MaheshwaraSutra> = listOf(
        MaheshwaraSutra(1, "१. अ इ उ ण्", "a i u ṇ", "अ, इ, उ", TrilingualText("अण् प्रत्याहारस्य मूलम्", "अण् प्रत्याहारको आधार (अ, इ, उ)", "Foundation of Aṇ pratyāhāra (short vowels)")),
        MaheshwaraSutra(2, "२. ऋ ऌ क्", "ṛ ḷ k", "ऋ, ऌ", TrilingualText("अक् प्रत्याहारः (सर्वह्रस्वस्वराः)", "अक् प्रत्याहार (सबै ह्रस्व स्वरहरू)", "Ak pratyāhāra (all basic simple vowels)")),
        MaheshwaraSutra(3, "३. ए ओ ङ्", "e o ṅ", "ए, ओ", TrilingualText("एङ् प्रत्याहारः (गुणस्वराः)", "एङ् प्रत्याहार (गुण स्वरहरू)", "Eṅ pratyāhāra (Guṇa vowels)")),
        MaheshwaraSutra(4, "४. ऐ औ च्", "ai au c", "ऐ, औ", TrilingualText("अच् प्रत्याहारः (सम्पूर्णस्वराः)", "अच् प्रत्याहार (सबै स्वर वर्णहरू)", "Ac pratyāhāra (all Sanskrit vowels)")),
        MaheshwaraSutra(5, "५. ह य व र ट्", "ha ya va ra ṭ", "ह, य, व, र", TrilingualText("हल् प्रत्याहारस्य आरम्भः", "व्यञ्जनहरूको आरम्भ", "Beginning of all consonants")),
        MaheshwaraSutra(6, "६. ल ण्", "la ṇ", "ल", TrilingualText("यण् प्रत्याहारः (य, व, र, ल)", "यण् प्रत्याहार (अन्तःस्थ वर्ण)", "Yaṇ pratyāhāra (all semivowels)")),
        MaheshwaraSutra(7, "७. ञ म ङ ण न म्", "ña ma ṅa ṇa na m", "ञ, म, ङ, ण, न", TrilingualText("यमङ्णनम् - पञ्चमवर्णाः (नासिक्याः)", "पाँचौँ नासिक्य वर्णहरू", "5th nasal consonants of each group")),
        MaheshwaraSutra(8, "८. झ भ ञ्", "jha bha ñ", "झ, भ", TrilingualText("चतुर्थवर्णानाम् आरम्भः", "चौथो महाप्राण वर्णहरू", "4th consonants (aspirated voiced)")),
        MaheshwaraSutra(9, "९. घ ढ ध ष्", "gha ḍha dha ṣ", "घ, ढ, ध", TrilingualText("झष् प्रत्याहारः", "झष् प्रत्याहार", "4th consonants continued")),
        MaheshwaraSutra(10, "१०. ज ब ग ड द श्", "ja ba ga ḍa da ś", "ज, ब, ग, ड, द", TrilingualText("जश् प्रत्याहारः (तृतीयवर्णाः)", "तेस्रो अल्पप्राण घोष वर्णहरू", "3rd consonants (unaspirated voiced)")),
        MaheshwaraSutra(11, "११. ख फ छ ठ थ च ट त व्", "kha pha cha ṭha tha ca ṭa ta v", "ख, फ, छ, ठ, थ, च, ट, त", TrilingualText("द्वितीय-प्रथमवर्णाः (अघोष)", "दोस्रो र पहिलो अघोष वर्णहरू", "2nd and 1st unvoiced consonants")),
        MaheshwaraSutra(12, "१२. क प य्", "ka pa y", "क, प", TrilingualText("प्रथमवर्णाः (क, प)", "क र प वर्णहरू", "Remaining 1st consonants")),
        MaheshwaraSutra(13, "१३. श ष स र्", "śa ṣa sa r", "श, ष, स", TrilingualText("शर् प्रत्याहारः (ऊष्मवर्णाः)", "ऊष्म वर्णहरू (श, ष, स)", "Shar pratyāhāra (sibilants)")),
        MaheshwaraSutra(14, "१४. ह ल्", "ha l", "ह", TrilingualText("हल् प्रत्याहारः (सम्पूर्णव्यञ्जनानि)", "हल् प्रत्याहार (सम्पूर्ण व्यञ्जनहरू)", "Hal pratyāhāra (all consonants)"))
    )

    // -------------------------------------------------------------
    // SHABDA RUPA (शब्दरूपाणि - NOUN DECLENSIONS)
    // -------------------------------------------------------------
    val shabdaRupaTables: List<ShabdaRupaTable> = listOf(
        ShabdaRupaTable(
            id = "balaka",
            title = "बालक (Balaka - Boy)",
            baseWord = "बालक",
            gender = TrilingualText("पुंल्लिङ्गम् (Masculine)", "पुंलिङ्ग (Masculine)", "Masculine"),
            endingType = "अकारान्त (Ending in short 'a')",
            meaning = TrilingualText("बालकः (Boy / Child)", "केटा / बालक (Boy)", "Boy"),
            rows = listOf(
                VibhaktiRow(1, TrilingualText("प्रथमा (Nominative)", "प्रथमा (कर्ता - ले)", "Nominative (Subject)"), "बालकः", "बालकौ", "बालकाः", TrilingualText("कर्ता (The boy does)", "बालकले (Subject)", "The boy")),
                VibhaktiRow(2, TrilingualText("द्वितीया (Accusative)", "द्वितीया (कर्म - लाई)", "Accusative (Object)"), "बालकम्", "बालकौ", "बालकान्", TrilingualText("कर्म (To the boy)", "बालकलाई (To the boy)", "To the boy")),
                VibhaktiRow(3, TrilingualText("तृतीया (Instrumental)", "तृतीया (करण - ले/द्वारा)", "Instrumental (By/With)"), "बालकेन", "बालकाभ्याम्", "बालकैः", TrilingualText("करणम् (By/With boy)", "बालकद्वारा / ले", "By / With the boy")),
                VibhaktiRow(4, TrilingualText("चतुर्थी (Dative)", "चतुर्थी (सम्प्रदान - का लागि)", "Dative (For)"), "बालकाय", "बालकाभ्याम्", "बालकेभ्यः", TrilingualText("सम्प्रदानम् (For boy)", "बालकको लागि (For the boy)", "For the boy")),
                VibhaktiRow(5, TrilingualText("पञ्चमी (Ablative)", "पञ्चमी (अपादान - बाट/देखि)", "Ablative (From)"), "बालकात्", "बालकाभ्याम्", "बालकेभ्यः", TrilingualText("अपादानम् (From boy)", "बालकबाट (From the boy)", "From the boy")),
                VibhaktiRow(6, TrilingualText("षष्ठी (Genitive)", "षष्ठी (सम्बन्ध - को/का/की)", "Genitive (Of/'s)"), "बालकस्य", "बालकयोः", "बालकानाम्", TrilingualText("सम्बन्धः (Of the boy)", "बालकको (Of the boy)", "Of the boy")),
                VibhaktiRow(7, TrilingualText("सप्तमी (Locative)", "सप्तमी (अधिकरण - मा/माथि)", "Locative (In/On)"), "बालके", "बालकयोः", "बालकेषु", TrilingualText("अधिकरणम् (In/On boy)", "बालकमा (In the boy)", "In / On the boy")),
                VibhaktiRow(8, TrilingualText("सम्बोधनम् (Vocative)", "सम्बोधन (हे!)", "Vocative (Addressing)"), "हे बालक!", "हे बालकौ!", "हे बालकाः!", TrilingualText("सम्बोधनम् (O Boy!)", "हे बालक! (O Boy!)", "O Boy!"))
            )
        ),
        ShabdaRupaTable(
            id = "lata",
            title = "लता (Lata - Creeper / Woman)",
            baseWord = "लता",
            gender = TrilingualText("स्त्रीलिङ्गम् (Feminine)", "स्त्रीलिङ्ग (Feminine)", "Feminine"),
            endingType = "आकारान्त (Ending in long 'ā')",
            meaning = TrilingualText("वल्लरी (Creeper)", "लहरा वा स्त्री (Creeper)", "Creeper / Vine"),
            rows = listOf(
                VibhaktiRow(1, TrilingualText("प्रथमा", "प्रथमा", "Nominative"), "लता", "लते", "लताः", TrilingualText("लता (The vine)", "लहराले", "The creeper")),
                VibhaktiRow(2, TrilingualText("द्वितीया", "द्वितीया", "Accusative"), "लताम्", "लते", "लताः", TrilingualText("लताम्", "लहरालाई", "To the creeper")),
                VibhaktiRow(3, TrilingualText("तृतीया", "तृतीया", "Instrumental"), "लतया", "लताभ्याम्", "लताभिः", TrilingualText("लतया", "लहराद्वारा", "By the creeper")),
                VibhaktiRow(4, TrilingualText("चतुर्थी", "चतुर्थी", "Dative"), "लतायै", "लताभ्याम्", "लताभ्यः", TrilingualText("लतायै", "लहराको लागि", "For the creeper")),
                VibhaktiRow(5, TrilingualText("पञ्चमी", "पञ्चमी", "Ablative"), "लतायाः", "लताभ्याम्", "लताभ्यः", TrilingualText("लतायाः", "लहराबाट", "From the creeper")),
                VibhaktiRow(6, TrilingualText("षष्ठी", "षष्ठी", "Genitive"), "लतायाः", "लतयोः", "लतानाम्", TrilingualText("लतायाः", "लहराको", "Of the creeper")),
                VibhaktiRow(7, TrilingualText("सप्तमी", "सप्तमी", "Locative"), "लतायाम्", "लतयोः", "लतासु", TrilingualText("लतायाम्", "लहरामा", "In/On the creeper")),
                VibhaktiRow(8, TrilingualText("सम्बोधनम्", "सम्बोधन", "Vocative"), "हे लते!", "हे लते!", "हे लताः!", TrilingualText("हे लते!", "हे लता!", "O Creeper!"))
            )
        ),
        ShabdaRupaTable(
            id = "phala",
            title = "फल (Phala - Fruit)",
            baseWord = "फल",
            gender = TrilingualText("नपुंसकलिङ्गम् (Neuter)", "नपुंसकलिङ्ग (Neuter)", "Neuter"),
            endingType = "अकारान्त (Ending in short 'a')",
            meaning = TrilingualText("सस्यम् (Fruit)", "फलफूल (Fruit)", "Fruit"),
            rows = listOf(
                VibhaktiRow(1, TrilingualText("प्रथमा", "प्रथमा", "Nominative"), "फलम्", "फले", "फलानि", TrilingualText("फलम्", "फलले", "Fruit")),
                VibhaktiRow(2, TrilingualText("द्वितीया", "द्वितीया", "Accusative"), "फलम्", "फले", "फलानि", TrilingualText("फलम्", "फललाई", "To fruit")),
                VibhaktiRow(3, TrilingualText("तृतीया", "तृतीया", "Instrumental"), "फलेन", "फलाभ्याम्", "फलैः", TrilingualText("फलेन", "फलद्वारा", "By fruit")),
                VibhaktiRow(4, TrilingualText("चतुर्थी", "चतुर्थी", "Dative"), "फलाय", "फलाभ्याम्", "फलेभ्यः", TrilingualText("फलाय", "फलको लागि", "For fruit")),
                VibhaktiRow(5, TrilingualText("पञ्चमी", "पञ्चमी", "Ablative"), "फलात्", "फलाभ्याम्", "फलेभ्यः", TrilingualText("फलात्", "फलबाट", "From fruit")),
                VibhaktiRow(6, TrilingualText("षष्ठी", "षष्ठी", "Genitive"), "फलस्य", "फलयोः", "फलानाम्", TrilingualText("फलस्य", "फलको", "Of fruit")),
                VibhaktiRow(7, TrilingualText("सप्तमी", "सप्तमी", "Locative"), "फले", "फलयोः", "फलेषु", TrilingualText("फले", "फलमा", "In fruit")),
                VibhaktiRow(8, TrilingualText("सम्बोधनम्", "सम्बोधन", "Vocative"), "हे फल!", "हे फले!", "हे फलानि!", TrilingualText("हे फल!", "हे फल!", "O Fruit!"))
            )
        ),
        ShabdaRupaTable(
            id = "asmad",
            title = "अस्मद् (Asmad - I / We - सर्वनाम)",
            baseWord = "अस्मद्",
            gender = TrilingualText("त्रिषु लिङ्गेषु समानम् (All Genders)", "सबै लिङ्गमा समान", "All Genders"),
            endingType = "सर्वनाम (Pronoun)",
            meaning = TrilingualText("अहम् (I, We)", "म, हामी (I, We)", "First Person Pronoun (I, We)"),
            rows = listOf(
                VibhaktiRow(1, TrilingualText("प्रथमा", "प्रथमा", "Nominative"), "अहम् (I)", "आवाम् (We two)", "वयम् (We all)", TrilingualText("अहम्/वयम्", "म / हामी दुई / हामी सबै", "I / We two / We all")),
                VibhaktiRow(2, TrilingualText("द्वितीया", "द्वितीया", "Accusative"), "माम् / मा", "आवाम् / नौ", "अस्मान् / नः", TrilingualText("माम्", "मलाई / हामीलाई", "To me / To us")),
                VibhaktiRow(3, TrilingualText("तृतीया", "तृतीया", "Instrumental"), "मया", "आवाभ्याम्", "अस्माभिः", TrilingualText("मया", "मद्वारा / हामीद्वारा", "By me / By us")),
                VibhaktiRow(4, TrilingualText("चतुर्थी", "चतुर्थी", "Dative"), "मह्यम् / मे", "आवाभ्याम् / नौ", "अस्मभ्यम् / नः", TrilingualText("मह्यम्", "मेरो लागि / हाम्रा लागि", "For me / For us")),
                VibhaktiRow(5, TrilingualText("पञ्चमी", "पञ्चमी", "Ablative"), "मत्", "आवाभ्याम्", "अस्मत्", TrilingualText("मत्", "मबाट / हामीबाट", "From me / From us")),
                VibhaktiRow(6, TrilingualText("षष्ठी", "षष्ठी", "Genitive"), "मम / मे", "आवयोः / नौ", "अस्माकम् / नः", TrilingualText("मम", "मेरो / हाम्रो", "My / Our")),
                VibhaktiRow(7, TrilingualText("सप्तमी", "सप्तमी", "Locative"), "मयि", "आवयोः", "अस्मासु", TrilingualText("मयि", "ममा / हामीमा", "In me / In us"))
            )
        ),
        ShabdaRupaTable(
            id = "yushmad",
            title = "युष्मद् (Yushmad - You - सर्वनाम)",
            baseWord = "युष्मद्",
            gender = TrilingualText("त्रिषु लिङ्गेषु समानम्", "सबै लिङ्गमा समान", "All Genders"),
            endingType = "सर्वनाम (Pronoun)",
            meaning = TrilingualText("त्वम् (You)", "तपाईं / तिमी (You)", "Second Person Pronoun (You)"),
            rows = listOf(
                VibhaktiRow(1, TrilingualText("प्रथमा", "प्रथमा", "Nominative"), "त्वम्", "युवाम्", "यूयम्", TrilingualText("त्वम्", "तपाईं / तपाईंहरू दुई / तपाईंहरू सबै", "You / You two / You all")),
                VibhaktiRow(2, TrilingualText("द्वितीया", "द्वितीया", "Accusative"), "त्वाम् / त्वा", "युवाम् / वाम्", "युष्मान् / वः", TrilingualText("त्वाम्", "तपाईंलाई", "To you")),
                VibhaktiRow(3, TrilingualText("तृतीया", "तृतीया", "Instrumental"), "त्वया", "युवाभ्याम्", "युष्माभिः", TrilingualText("त्वया", "तपाईंद्वारा", "By you")),
                VibhaktiRow(4, TrilingualText("चतुर्थी", "चतुर्थी", "Dative"), "तुभ्यम् / ते", "युवाभ्याम् / वाम्", "युष्मभ्यम् / वः", TrilingualText("तुभ्यम्", "तपाईंका लागि", "For you")),
                VibhaktiRow(5, TrilingualText("पञ्चमी", "पञ्चमी", "Ablative"), "त्वत्", "युवाभ्याम्", "युष्मत्", TrilingualText("त्वत्", "तपाईंबाट", "From you")),
                VibhaktiRow(6, TrilingualText("षष्ठी", "षष्ठी", "Genitive"), "तव / ते", "युवयोः / वाम्", "युष्माकम् / वः", TrilingualText("तव", "तपाईंको / तिम्रो", "Your / Yours")),
                VibhaktiRow(7, TrilingualText("सप्तमी", "सप्तमी", "Locative"), "त्वयि", "युवयोः", "युष्मासु", TrilingualText("त्वयि", "तपाईंमा", "In you"))
            )
        )
    )

    // -------------------------------------------------------------
    // DHATU RUPA (धातुरूपाणि - VERB CONJUGATIONS)
    // -------------------------------------------------------------
    val dhatuRupaTables: List<DhatuRupaTable> = listOf(
        DhatuRupaTable(
            id = "path_lat",
            root = "पठ् (Paṭh)",
            rootMeaning = TrilingualText("पठनम् (To Read / Study)", "पढ्नु (To Read)", "To read / study"),
            lakara = "लट्-लकारः",
            lakaraName = TrilingualText("वर्तमानकालः (Present Tense)", "वर्तमान काल (Present Tense)", "Present Tense (Laṭ)"),
            rows = listOf(
                PurushaRow(TrilingualText("प्रथमपुरुषः (३rd Person)", "प्रथम पुरुष (उ, त्यो)", "Third Person (He/She/They)"), "पठति", "पठतः", "पठन्ति", "सः पठति / तौ पठतः / ते पठन्ति"),
                PurushaRow(TrilingualText("मध्यमपुरुषः (२nd Person)", "मध्यम पुरुष (तपाईं, तिमी)", "Second Person (You)"), "पठसि", "पठथः", "पठथ", "त्वं पठसि / युवां पठथः / यूयं पठथ"),
                PurushaRow(TrilingualText("उत्तमपुरुषः (१st Person)", "उत्तम पुरुष (म, हामी)", "First Person (I, We)"), "पठामि", "पठावः", "पठामः", "अहं पठामि / आवां पठावः / वयं पठामः")
            )
        ),
        DhatuRupaTable(
            id = "gam_lat",
            root = "गम् -> गच्छ् (Gam -> Gacch)",
            rootMeaning = TrilingualText("गमनम् (To Go)", "जानु (To Go)", "To go"),
            lakara = "लट्-लकारः",
            lakaraName = TrilingualText("वर्तमानकालः (Present Tense)", "वर्तमान काल (Present Tense)", "Present Tense (Laṭ)"),
            rows = listOf(
                PurushaRow(TrilingualText("प्रथमपुरुषः", "प्रथम पुरुष", "Third Person"), "गच्छति", "गच्छतः", "गच्छन्ति", "सः गच्छति (He goes)"),
                PurushaRow(TrilingualText("मध्यमपुरुषः", "मध्यम पुरुष", "Second Person"), "गच्छसि", "गच्छथः", "गच्छथ", "त्वं गच्छसि (You go)"),
                PurushaRow(TrilingualText("उत्तमपुरुषः", "उत्तम पुरुष", "First Person"), "गच्छामि", "गच्छावः", "गच्छामः", "अहं गच्छामि (I go)")
            )
        ),
        DhatuRupaTable(
            id = "gam_lrit",
            root = "गम् (Gam)",
            rootMeaning = TrilingualText("गमनम् (To Go)", "जानु (To Go)", "To go"),
            lakara = "लृट्-लकारः",
            lakaraName = TrilingualText("भविष्यत्कालः (Future Tense)", "भविष्यत् काल (Future Tense)", "Future Tense (Lṛṭ)"),
            rows = listOf(
                PurushaRow(TrilingualText("प्रथमपुरुषः", "प्रथम पुरुष", "Third Person"), "गमिष्यति", "गमिष्यतः", "गमिष्यन्ति", "सः गमिष्यति (He will go)"),
                PurushaRow(TrilingualText("मध्यमपुरुषः", "मध्यम पुरुष", "Second Person"), "गमिष्यसि", "गमिष्यथः", "गमिष्यथ", "त्वं गमिष्यसि (You will go)"),
                PurushaRow(TrilingualText("उत्तमपुरुषः", "उत्तम पुरुष", "First Person"), "गमिष्यामि", "गमिष्यावः", "गमिष्यामः", "अहं गमिष्यामि (I will go)")
            )
        ),
        DhatuRupaTable(
            id = "path_lang",
            root = "पठ् (Paṭh)",
            rootMeaning = TrilingualText("पठनम् (To Read)", "पढ्नु (To Read)", "To read"),
            lakara = "लङ्-लकारः",
            lakaraName = TrilingualText("अनद्यतन-भूतकालः (Past Imperfect)", "भूतकाल (Past Tense)", "Past Tense (Laṅ)"),
            rows = listOf(
                PurushaRow(TrilingualText("प्रथमपुरुषः", "प्रथम पुरुष", "Third Person"), "अपठत्", "अपठताम्", "अपठन्", "सः अपठत् (He read)"),
                PurushaRow(TrilingualText("मध्यमपुरुषः", "मध्यम पुरुष", "Second Person"), "अपठः", "अपठतम्", "अपठत", "त्वम् अपठः (You read)"),
                PurushaRow(TrilingualText("उत्तमपुरुषः", "उत्तम पुरुष", "First Person"), "अपठम्", "अपठाव", "अपठाम", "अहम् अपठम् (I read)")
            )
        ),
        DhatuRupaTable(
            id = "bhu_lot",
            root = "भू -> भव् (Bhū -> Bhav)",
            rootMeaning = TrilingualText("भवनम् / सत्ता (To Be / Become)", "हुनु (To Be)", "To be / become"),
            lakara = "लोट्-लकारः",
            lakaraName = TrilingualText("आज्ञार्थः (Imperative / Order)", "आज्ञार्थक / अनुरोध (Imperative)", "Imperative (Loṭ)"),
            rows = listOf(
                PurushaRow(TrilingualText("प्रथमपुरुषः", "प्रथम पुरुष", "Third Person"), "भवतु", "भवताम्", "भवन्तु", "सः भवतु (May he be!)"),
                PurushaRow(TrilingualText("मध्यमपुरुषः", "मध्यम पुरुष", "Second Person"), "भव", "भवतम्", "भवत", "त्वं भव (Be!)"),
                PurushaRow(TrilingualText("उत्तमपुरुषः", "उत्तम पुरुष", "First Person"), "भवानि", "भवाव", "भवाम", "अहं भवानि (May I be!)")
            )
        )
    )

    // -------------------------------------------------------------
    // SANDHI (सन्धिः - PHONETIC COMBINATIONS)
    // -------------------------------------------------------------
    val sandhiRules: List<SandhiRule> = listOf(
        SandhiRule(
            id = "dirgha_sandhi",
            name = TrilingualText("दीर्घसन्धिः (अकः सवर्णे दीर्घः)", "दीर्घ सन्धि (ह्रस्व वा दीर्घ मिलेर दीर्घ हुनु)", "Dīrgha Sandhi (Vowel Lengthening)"),
            formula = "अ/आ + अ/आ = आ | इ/ई + इ/ई = ई | उ/ऊ + उ/ऊ = ऊ | ऋ/ॠ + ऋ/ॠ = ॠ",
            explanation = TrilingualText(
                "समानस्वरयोः मेलने दीर्घस्वरः भवति।",
                "समान स्वरहरू (ह्रस्व वा दीर्घ) जोडिँदा दीर्घ स्वर बन्दछ।",
                "When two similar vowels meet, they combine into their long counterpart."
            ),
            examples = listOf(
                SandhiExample("हिम", "आलयः", "हिमालयः", TrilingualText("हिमस्य आलयः (Abode of snow)", "हिउँको घर / हिमालय", "Abode of Snow")),
                SandhiExample("विद्या", "आलयः", "विद्यालयः", TrilingualText("ज्ञानगृहम् (School)", "विद्यालय / पाठशाला", "School / House of Knowledge")),
                SandhiExample("कवि", "इन्द्रः", "कवीन्द्रः", TrilingualText("श्रेष्ठकविः (Great Poet)", "कविहरूमा श्रेष्ठ", "Chief among poets")),
                SandhiExample("भानु", "उदयः", "भानूदयः", TrilingualText("सूर्यस्य उदयः", "सूर्यको उदय", "Sunrise"))
            )
        ),
        SandhiRule(
            id = "guna_sandhi",
            name = TrilingualText("गुणसन्धिः (आद्गुणः)", "गुण सन्धि (ए, ओ, अर् बन्ने)", "Guṇa Sandhi"),
            formula = "अ/आ + इ/ई = ए | अ/आ + उ/ऊ = ओ | अ/आ + ऋ/ॠ = अर्",
            explanation = TrilingualText(
                "अ अथवा आ परे इ, उ, ऋ वर्णैः सह गुणीभवति।",
                "अ वा आ पछि इ/ई आए 'ए', उ/ऊ आए 'ओ', ऋ आए 'अर्' बन्दछ।",
                "When 'a/ā' is followed by 'i/ī', 'u/ū', or 'ṛ', they merge into 'e', 'o', and 'ar'."
            ),
            examples = listOf(
                SandhiExample("नर", "इन्द्रः", "नरेन्द्रः", TrilingualText("राजन (King)", "मानिसहरूको राजा", "King of Men")),
                SandhiExample("सूर्य", "उदयः", "सूर्योदयः", TrilingualText("सूर्यस्य उदयः", "घाम झुल्कनु", "Sunrise")),
                SandhiExample("महा", "ऋषिः", "महर्षिः", TrilingualText("महान् ऋषिः", "महान् तपस्वी ऋषि", "Great Sage"))
            )
        ),
        SandhiRule(
            id = "vriddhi_sandhi",
            name = TrilingualText("वृद्धिसन्धिः (वृद्धिरेचि)", "वृद्धि सन्धि (ऐ र औ बन्ने)", "Vṛddhi Sandhi"),
            formula = "अ/आ + ए/ऐ = ऐ | अ/आ + ओ/औ = औ",
            explanation = TrilingualText(
                "अ अथवा आ परे एच् वर्णैः सह वृद्धिः भवति।",
                "अ वा आ पछि ए/ऐ आए 'ऐ' र ओ/औ आए 'औ' हुन्छ।",
                "When 'a/ā' is followed by 'e/ai' or 'o/au', they merge into 'ai' and 'au'."
            ),
            examples = listOf(
                SandhiExample("एक", "एकम्", "एकैकम्", TrilingualText("प्रत्येकम् (One by one)", "एक-एक गरेर", "One by one")),
                SandhiExample("जल", "ओघः", "जलौघः", TrilingualText("जलप्रवाहः (Water stream)", "पानीको ठूलो भेल", "Rush of water"))
            )
        ),
        SandhiRule(
            id = "yan_sandhi",
            name = TrilingualText("यण्सन्धिः (इको यणचि)", "यण् सन्धि (य, व, र, ल बन्ने)", "Yaṇ Sandhi (Semivowel Formation)"),
            formula = "इ/ई + असमान स्वर = य् | उ/ऊ + असमान स्वर = व् | ऋ + असमान स्वर = र्",
            explanation = TrilingualText(
                "इक् वर्णस्य स्थाने यण् भवति यदि असमानस्वरः परे स्यात्।",
                "इ, उ, ऋ पछि भिन्न स्वर आएमा क्रमशः य्, व्, र् बन्दछ।",
                "When 'i/u/ṛ' are followed by a dissimilar vowel, they change into 'y', 'v', 'r'."
            ),
            examples = listOf(
                SandhiExample("प्रति", "एकम्", "प्रत्येकम्", TrilingualText("प्रत्येकम् (Everyone)", "हरेक / प्रत्येक", "Each / Every")),
                SandhiExample("सु", "आगतम्", "स्वागतम्", TrilingualText("अभिनन्दनम् (Welcome)", "स्वागत (Welcome)", "Welcome"))
            )
        )
    )

    // -------------------------------------------------------------
    // KARAKA (कारकाणि - CASES & SYNTAX)
    // -------------------------------------------------------------
    val karakaTopics: List<KarakaTopic> = listOf(
        KarakaTopic("karta", TrilingualText("१. कर्ताकारकम् (Subject)", "कर्ता कारक (Subject - ले)", "Subject (Kartā)"), TrilingualText("प्रथमा विभक्तिः", "प्रथमा विभक्ति", "Nominative Case"), TrilingualText("स्वतन्त्रः कर्ता - यः कार्यं करोति।", "काम गर्ने मुख्य व्यक्ति वा पात्र।", "The independent doer of an action."), "रामः पुस्तकं पठति।", TrilingualText("अत्र 'रामः' कर्ता अस्ति।", "यहाँ 'राम' कर्ता हो जसले पढ्ने काम गर्छ।", "Here 'Rāmaḥ' is the subject who reads.")),
        KarakaTopic("karma", TrilingualText("२. कर्मकारकम् (Object)", "कर्म कारक (Object - लाई)", "Object (Karma)"), TrilingualText("द्वितीया विभक्तिः", "द्वितीया विभक्ति", "Accusative Case"), TrilingualText("कर्तुरीप्सिततमं कर्म - क्रियायाः फलं यत्र पतति।", "कर्ताको क्रियाको प्रत्यक्ष फल पर्ने वस्तु वा व्यक्ति।", "That which the doer most seeks to affect."), "बालकः दुग्धं पिबति।", TrilingualText("अत्र 'दुग्धम्' कर्म अस्ति।", "यहाँ 'दुग्धम्' (दूध) कर्म हो।", "Here 'Dugdham' (milk) is the direct object.")),
        KarakaTopic("karana", TrilingualText("३. करणकारकम् (Instrument)", "करण कारक (Instrument - द्वारा)", "Instrument (Karaṇa)"), TrilingualText("तृतीया विभक्तिः", "तृतीया विभक्ति", "Instrumental Case"), TrilingualText("साधकतमं करणम् - क्रियासिद्धौ यत् मुख्यसाधनं भवति।", "काम सम्पन्न गर्न प्रयोग गरिने मुख्य साधन।", "The primary instrument through which action is achieved."), "छात्रः कलमेन लिखति।", TrilingualText("अत्र 'कलमेन' करणम् अस्ति।", "यहाँ कलम मुख्य साधन (करण) हो।", "Here 'Kalamena' (with pen) is the instrument.")),
        KarakaTopic("sampradana", TrilingualText("४. सम्प्रदानकारकम् (Recipient)", "सम्प्रदान कारक (Recipient - का लागि)", "Recipient (Sampradāna)"), TrilingualText("चतुर्थी विभक्तिः", "चतुर्थी विभक्ति", "Dative Case"), TrilingualText("कर्मणा यमभिप्रेति स सम्प्रदानम् - यस्मै दानं क्रियते।", "जसलाई केही कुरा सप्रेम वा दान स्वरूप दिइन्छ।", "The one to whom something is dedicated or given."), "राजा विप्राय गां ददाति।", TrilingualText("अत्र 'विप्राय' सम्प्रदानम्।", "यहाँ ब्राह्मण (विप्र) सम्प्रदान हुन्।", "Here the priest (Viprāya) is the recipient.")),
        KarakaTopic("apadana", TrilingualText("५. अपादानकारकम् (Source / Separation)", "अपादान कारक (Source - बाट)", "Source (Apādāna)"), TrilingualText("पञ्चमी विभक्तिः", "पञ्चमी विभक्ति", "Ablative Case"), TrilingualText("ध्रुवमपायेऽपादानम् - यस्मात् वस्तुनः पृथग्भावः भवति।", "कुनै स्थिर वस्तुबाट छुट्टिने वा अलग हुने भाव।", "The fixed point from which separation occurs."), "वृक्षात् पत्रं पतति।", TrilingualText("अत्र 'वृक्षात्' अपादानम्।", "यहाँ रुख (वृक्ष) बाट पात खस्छ।", "Here the tree (Vṛkṣāt) is the source of separation.")),
        KarakaTopic("adhikarana", TrilingualText("६. अधिकरणकारकम् (Locus / Location)", "अधिकरण कारक (Locus - मा)", "Locus (Adhikaraṇa)"), TrilingualText("सप्तमी विभक्तिः", "सप्तमी विभक्ति", "Locative Case"), TrilingualText("आधारोऽधिकरणम् - क्रियायाः आधारः।", "क्रिया सम्पन्न हुने ठाउँ वा आधार।", "The substratum or locus where an action takes place."), "मुनिः वने वसति।", TrilingualText("अत्र 'वने' अधिकरणम् अस्ति।", "यहाँ वन (जङ्गल) बस्ने आधार हो।", "Here 'Vane' (in the forest) is the locus/place."))
    )

    // -------------------------------------------------------------
    // SPOKEN SANSKRIT & CONVERSATIONS (सम्भाषण-संस्कृतम्)
    // -------------------------------------------------------------
    val conversationPhrases: List<ConversationPhrase> = listOf(
        // शिष्टाचारः (Greetings)
        ConversationPhrase("g1", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "हरिः ॐ!", "Hariḥ Om!", "नमस्ते / ॐ प्रणाम!", "Hello / Sacred Greeting!"),
        ConversationPhrase("g2", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "नमो नमः / नमस्ते!", "Namo namaḥ / Namaste!", "नमस्कार / प्रणाम!", "Salutations / Greetings!"),
        ConversationPhrase("g3", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "सुप्रभातम्!", "Suprabhātam!", "शुभ प्रभात / बिहानीको नमस्कार!", "Good morning!"),
        ConversationPhrase("g4", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "शुभरात्रिः!", "Śubharātriḥ!", "शुभ रात्रि!", "Good night!"),
        ConversationPhrase("g5", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "धन्यवादः!", "Dhanyavādaḥ!", "धन्यवाद!", "Thank you!"),
        ConversationPhrase("g6", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "स्वागतम्!", "Svāgatam!", "स्वागत छ!", "Welcome!"),
        ConversationPhrase("g7", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "क्षम्यताम्!", "Kṣamyatām!", "माफ गर्नुहोस्!", "Excuse me / Please forgive!"),
        ConversationPhrase("g8", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "पुनर्मिलामः!", "Punarmilāmaḥ!", "फेरि भेटौँला!", "See you again!"),
        ConversationPhrase("g9", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "अस्तु / आम्!", "Astu / Ām!", "हुन्छ / हो!", "Alright / Yes!"),
        ConversationPhrase("g10", TrilingualText("शिष्टाचारः", "शिष्टाचार", "Etiquette"), "नहि / मास्तु!", "Nahi / Māstu!", "होइन / चाहिँदैन!", "No / Don't want!"),

        // परिचयः (Self Introduction)
        ConversationPhrase("p1", TrilingualText("परिचयः", "परिचय", "Introduction"), "भवतः नाम किम्? (पुं)", "Bhavataḥ nāma kim?", "तपाईंको नाम के हो? (पुरुषलाई)", "What is your name? (to male)"),
        ConversationPhrase("p2", TrilingualText("परिचयः", "परिचय", "Introduction"), "भवत्याः नाम किम्? (स्त्री)", "Bhavatyāḥ nāma kim?", "तपाईंको नाम के हो? (महिलालाई)", "What is your name? (to female)"),
        ConversationPhrase("p3", TrilingualText("परिचयः", "परिचय", "Introduction"), "मम नाम आनन्दः अस्ति।", "Mama nāma Ānandaḥ asti.", "मेरो नाम आनन्द हो।", "My name is Ananda."),
        ConversationPhrase("p4", TrilingualText("परिचयः", "परिचय", "Introduction"), "भवान् कथम् अस्ति? (पुं)", "Bhavān katham asti?", "तपाईं कस्तो हुनुहुन्छ? (पुरुषलाई)", "How are you? (to male)"),
        ConversationPhrase("p5", TrilingualText("परिचयः", "परिचय", "Introduction"), "भवती कथम् अस्ति? (स्त्री)", "Bhavatī katham asti?", "तपाईं कस्तो हुनुहुन्छ? (महिलालाई)", "How are you? (to female)"),
        ConversationPhrase("p6", TrilingualText("परिचयः", "परिचय", "Introduction"), "अहं कुशली अस्मि।", "Ahaṃ kuśalī asmi.", "म सञ्चै छु / आरामै छु।", "I am well / fine."),
        ConversationPhrase("p7", TrilingualText("परिचयः", "परिचय", "Introduction"), "भवान् कुत्र वसति?", "Bhavān kutra vasati?", "तपाईं कहाँ बस्नुहुन्छ?", "Where do you live?"),
        ConversationPhrase("p8", TrilingualText("परिचयः", "परिचय", "Introduction"), "अहं काष्ठमण्डपे वसामि।", "Ahaṃ Kāṣṭhamaṇḍape vasāmi.", "म काठमाडौँमा बस्छु।", "I live in Kathmandu."),

        // प्रश्नवाचक शब्दाः (Question Words)
        ConversationPhrase("q1", TrilingualText("प्रश्नाः", "प्रश्न सोध्ने शब्द", "Questions"), "किम्?", "Kim?", "के?", "What?"),
        ConversationPhrase("q2", TrilingualText("प्रश्नाः", "प्रश्न सोध्ने शब्द", "Questions"), "कुत्र?", "Kutra?", "कहाँ?", "Where?"),
        ConversationPhrase("q3", TrilingualText("प्रश्नाः", "प्रश्न सोध्ने शब्द", "Questions"), "कदा?", "Kadā?", "कहिले?", "When?"),
        ConversationPhrase("q4", TrilingualText("प्रश्नाः", "प्रश्न सोध्ने शब्द", "Questions"), "कथम्?", "Katham?", "कसरी / कस्तो?", "How?"),
        ConversationPhrase("q5", TrilingualText("प्रश्नाः", "प्रश्न सोध्ने शब्द", "Questions"), "किमर्थम्?", "Kimartham?", "किन / केका लागि?", "Why / For what?"),
        ConversationPhrase("q6", TrilingualText("प्रश्नाः", "प्रश्न सोध्ने शब्द", "Questions"), "कति?", "Kati?", "कति?", "How many / much?"),
        ConversationPhrase("q7", TrilingualText("प्रश्नाः", "प्रश्न सोध्ने शब्द", "Questions"), "कः / का?", "Kaḥ / Kā?", "को? (पुरुष / महिला)", "Who? (Male / Female)"),

        // समय-बोधनम् (Telling Time)
        ConversationPhrase("t1", TrilingualText("समयः", "समय", "Time"), "अधुना कः समयः?", "Adhunā kaḥ samayaḥ?", "अहिले कति बज्यो?", "What time is it right now?"),
        ConversationPhrase("t2", TrilingualText("समयः", "समय", "Time"), "एकवादनम् (१:००)", "Eka-vādanam", "एक बज्यो", "One o'clock"),
        ConversationPhrase("t3", TrilingualText("समयः", "समय", "Time"), "सपाद-पञ्चवादनम् (५:१५)", "Sapāda-pañcavādanam", "सवा पाँच बज्यो", "Quarter past five"),
        ConversationPhrase("t4", TrilingualText("समयः", "समय", "Time"), "सार्ध-सप्तवादनम् (७:३०)", "Sārdha-saptavādanam", "साढे सात बज्यो", "Half past seven"),
        ConversationPhrase("t5", TrilingualText("समयः", "समय", "Time"), "पादोन-दशवादनम् (९:४५)", "Pādona-daśavādanam", "पौने दश बज्यो", "Quarter to ten")
    )

    // -------------------------------------------------------------
    // SUBHASHITANI (सुभाषितानि एवं श्लोकाः)
    // -------------------------------------------------------------
    val subhashitas: List<Subhashita> = listOf(
        Subhashita(
            id = "vidya_dadati",
            title = TrilingualText("विद्यायाः महत्त्वम्", "विद्याको महत्त्व", "The Fruit of True Learning"),
            slokaText = "विद्या ददाति विनयं विनयाद् याति पात्रताम्।\nपात्रत्वाद् धनमाप्नोति धनाद् धर्मं ततः सुखम्॥",
            source = "हितोपदेशः (Hitopadesha)",
            padachheda = "विद्या | ददाति | विनयम् | विनयात् | याति | पात्रताम् | पात्रत्वात् | धनम् | आप्नोति | धनात् | धर्मम् | ततः | सुखम्",
            anvaya = "विद्या विनयं ददाति। विनयात् पात्रतां याति। पात्रत्वात् धनम् आप्नोति। धनात् धर्मं (करोति), ततः सुखम् (भवति)।",
            nepaliMeaning = "विद्याले विनम्रता दिन्छ, विनम्रताले योग्यता (पात्रता) प्राप्त हुन्छ। योग्यताले धन आर्जन हुन्छ, धनबाट धर्म (सत्कर्म) गर्न सकिन्छ र धर्मबाट नै साँचो सुख एवं शान्ति मिल्छ।",
            englishMeaning = "Knowledge bestows humility; from humility comes worthiness; from worthiness one earns wealth; from wealth one performs righteous duty, and from that springs true enduring happiness.",
            sanskritMeaning = "यथार्थविद्या मनुष्ये विनम्रतां जनयति। विनयेन मनुष्यः योग्यः भवति। योग्यतया धनम् आप्यते, तेन धनेन सत्कर्म क्रियते, अन्ते च परमं सुखं लभ्यते।",
            moralTeaching = TrilingualText("विद्यायाः अन्तिमं लक्ष्यं सद्गुणः सुखं च अस्ति।", "ज्ञानको वास्तविक फल विनय र सत्कर्म हो।", "Knowledge elevates the soul through humility and righteous living.")
        ),
        Subhashita(
            id = "udyamena_hi",
            title = TrilingualText("परिश्रमस्य महिमा", "परिश्रमको महिमा", "Power of Diligence"),
            slokaText = "उद्यमेन हि सिध्यन्ति कार्याणि न मनोरथैः।\nन हि सुप्तस्य सिंहस्य प्रविशन्ति मुखे मृगाः॥",
            source = "पञ्चतन्त्रम् (Panchatantra)",
            padachheda = "उद्यमेन | हि | सिध्यन्ति | कार्याणि | न | मनोरथैः | न | हि | सुप्तस्य | सिंहस्य | प्रविशन्ति | मुखे | मृगाः",
            anvaya = "कार्याणि उद्यमेन हि सिध्यन्ति, मनोरथैः न। सुप्तस्य सिंहस्य मुखे मृगाः न हि प्रविशन्ति।",
            nepaliMeaning = "सबै काम परिश्रम र कडा मिहिनेतले मात्र सफल हुन्छन्, केवल मनको इच्छा वा कल्पनाले होइन। सुतेको सिंहको मुखमा आफैँ हरिण पस्दैन, उसले पनि शिकार गर्न परिश्रम गर्नैपर्छ।",
            englishMeaning = "Actions succeed through diligent effort alone, never by mere wishes. Deer do not enter the mouth of a sleeping lion on their own; even the king of beasts must hunt.",
            sanskritMeaning = "परिश्रमेण एव सर्वाणि कार्याणि पूर्णाणि भवन्ति, केवलं सङ्कल्पमात्रेण न। निद्रितस्य वनराजस्य मुखे स्वयं पशवः न आगच्छन्ति।",
            moralTeaching = TrilingualText("कर्म एव सफलतायाः कुञ्चिका अस्ति।", "सफलताको एकमात्र साँचो कठोर परिश्रम हो।", "Diligence and action are the sole keys to success.")
        ),
        Subhashita(
            id = "ayam_nijah",
            title = TrilingualText("वसुधैव कुटुम्बकम्", "विश्वबन्धुत्व (वसुधैव कुटुम्बकम्)", "Universal Brotherhood"),
            slokaText = "अयं निजः परो वेति गणना लघुचेतसाम्।\nउदारचरितानां तु वसुधैव कुटुम्बकम्॥",
            source = "महोपनिषद् (Mahopanishad)",
            padachheda = "अयम् | निजः | परः | वा | इति | गणना | लघु-चेतसाम् | उदार-चरितानाम् | तु | वसुधा | एव | कुटुम्बकम्",
            anvaya = "अयम् निजः वा परः इति गणना लघुचेतसां भवति। उदारचरितानां तु वसुधा एव कुटुम्बकम्।",
            nepaliMeaning = "'यो मेरो हो र त्यो अरूको हो' भन्ने सङ्कुचित विचार सानो मन भएकाहरूको हुन्छ। विशाल र उदार मन भएका महान् व्यक्तिहरूका लागि त सम्पूर्ण पृथ्वी नै एउटा परिवार हो।",
            englishMeaning = "'This person is mine and that is a stranger' is the reckoning of small minds. For the noble-hearted, the entire earth is but a single family.",
            sanskritMeaning = "मम वा अन्यस्य इति सङ्कुचितविचारः हीनबुद्धीनां भवति। येषां हृदयं विशालं ते तु समग्रं संसारं स्वपरिवारवत् पश्यन्ति।",
            moralTeaching = TrilingualText("समग्रसंसारः एकं बृहत् कुटुम्बम् अस्ति।", "सम्पूर्ण संसार एउटै परिवार हो, संकीर्णता त्यागौँ।", "Embrace global harmony and universal fellowship.")
        ),
        Subhashita(
            id = "karagre_vasate",
            title = TrilingualText("करदर्शन-मन्त्रः (प्रातःस्मरणम्)", "करदर्शन मन्त्र (बिहान हत्केला हेर्दा)", "Morning Palm Contemplation"),
            slokaText = "कराग्रे वसते लक्ष्मीः करमध्ये सरस्वती।\nकरमूले तु गोविन्दः प्रभाते करदर्शनम्॥",
            source = "सनातन प्रातःस्मरणम्",
            padachheda = "कर-अग्रे | वसते | लक्ष्मीः | कर-मध्ये | सरस्वती | कर-मूले | तु | गोविन्दः | प्रभाते | कर-दर्शनम्",
            anvaya = "कराग्रे लक्ष्मीः वसते, करमध्ये सरस्वती (वसते), करमूले तु गोविन्दः (वसते), अतः प्रभाते करदर्शनं (कर्तव्यम्)।",
            nepaliMeaning = "हातको टुप्पामा धनकी देवी लक्ष्मी, हत्केलाको बीचमा विद्याकी देवी सरस्वती र हातको फेदमा भगवान् गोविन्द (विष्णु) को बास हुन्छ। तसर्थ बिहान उठ्नेबित्तिकै आफ्ना दुवै हत्केलाको दर्शन गर्नुपर्छ।",
            englishMeaning = "At the tip of the hand resides Lakshmi (prosperity); in the center dwells Saraswati (wisdom); at the base rests Govinda (divine source). Therefore, one should behold the hands upon waking.",
            sanskritMeaning = "हस्तस्य पुरोभागे धनदात्री लक्ष्मीः, मध्ये विद्यादात्री सरस्वती, मूले च जगत्पालकः गोविन्दः तिष्ठति। अतः प्रातःकाले हस्तदर्शनं मङ्गलं भवति।",
            moralTeaching = TrilingualText("स्वावलम्बनम् ईशस्मरणं च जीवनस्य मूलम्।", "हाम्रो भाग्य हाम्रै हातमा छ, कर्म नै पूजा हो।", "Our destiny is in our own hands; work is divine.")
        ),
        Subhashita(
            id = "shanti_mantra",
            title = TrilingualText("शान्तिमन्त्रः", "विश्व शान्ति मन्त्र", "Universal Peace Invocation"),
            slokaText = "ॐ सर्वे भवन्तु सुखिनः सर्वे सन्तु निरामयाः।\nसर्वे भद्राणि पश्यन्तु मा कश्चिद् दुःखभाग् भवेत्॥",
            source = "बृहदारण्यकोपनिषद्",
            padachheda = "ॐ | सर्वे | भवन्तु | सुखिनः | सर्वे | सन्तु | निरामयाः | सर्वे | भद्राणि | पश्यन्तु | मा | कश्चित् | दुःख-भाक् | भवेत्",
            anvaya = "सर्वे सुखिनः भवन्तु, सर्वे निरामयाः सन्तु, सर्वे भद्राणि पश्यन्तु, कश्चित् दुःखभाग् मा भवेत्।",
            nepaliMeaning = "सबै प्राणी सुखी होऊन्, सबै निरोगी र स्वस्थ होऊन्, सबैले कल्याण एवं मङ्गलमय देख्न पाऊन् र संसारमा कोही पनि कहिल्यै दुःखको भागीदार बन्नु नपरोस्।",
            englishMeaning = "May all beings be happy; may all be free from illness and distress; may all behold what is auspicious and good; may no one suffer or be touched by grief.",
            sanskritMeaning = "सकलजगतः सुखं, स्वास्थ्यं, मङ्गलं च प्रार्थ्यते। कोऽपि जीवः कष्टं न प्राप्नुयात् इति सद्भावः।",
            moralTeaching = TrilingualText("सर्वेषां प्राणिनां कल्याणमेव परमो धर्मः।", "सबैको सुख र आरोग्य नै धर्मको सर्वोच्च लक्ष्य हो।", "Unconditional goodwill and compasssion toward all existence.")
        )
    )

    // -------------------------------------------------------------
    // THEMATIC VOCABULARY (शब्दकोशः)
    // -------------------------------------------------------------
    val vocabulary: List<VocabWord> = listOf(
        // Relations (सम्बन्धाः)
        VocabWord("v1", TrilingualText("सम्बन्धाः", "नातागोता", "Relationships"), "पिता / जनकः", "Pitā / Janakaḥ", "बुबा / पिता", "Father", "पुं"),
        VocabWord("v2", TrilingualText("सम्बन्धाः", "नातागोता", "Relationships"), "माता / जननी", "Mātā / Jananī", "आमा / माता", "Mother", "स्त्री"),
        VocabWord("v3", TrilingualText("सम्बन्धाः", "नातागोता", "Relationships"), "भ्राता / सोदरः", "Bhrātā / Sodaraḥ", "दाजु / भाइ", "Brother", "पुं"),
        VocabWord("v4", TrilingualText("सम्बन्धाः", "नातागोता", "Relationships"), "भगिनी", "Bhaginī", "दिदी / बहिनी", "Sister", "स्त्री"),
        VocabWord("v5", TrilingualText("सम्बन्धाः", "नातागोता", "Relationships"), "पुत्रः / सुतः", "Putraḥ / Sutaḥ", "छोरा / पुत्र", "Son", "पुं"),
        VocabWord("v6", TrilingualText("सम्बन्धाः", "नातागोता", "Relationships"), "पुत्री / सुता", "Putrī / Sutā", "छोरी / पुत्री", "Daughter", "स्त्री"),
        VocabWord("v7", TrilingualText("सम्बन्धाः", "नातागोता", "Relationships"), "मित्रम् / सखा", "Mitram / Sakhā", "साथी / मित्र", "Friend", "नपुं"),
        VocabWord("v8", TrilingualText("सम्बन्धाः", "नातागोता", "Relationships"), "गुरुः / आचार्यः", "Guruḥ / Ācāryaḥ", "गुरु / शिक्षक", "Teacher / Mentor", "पुं"),

        // Animals & Birds (पशवः पक्षिणश्च)
        VocabWord("v9", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "धेनुः / गौः", "Dhenuḥ / Gauḥ", "गाई (Cow)", "Cow", "स्त्री"),
        VocabWord("v10", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "अश्वः / घोटकः", "Aśvaḥ / Ghoṭakaḥ", "घोडा (Horse)", "Horse", "पुं"),
        VocabWord("v11", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "गजः / हस्ती", "Gajaḥ / Hastī", "हात्ती (Elephant)", "Elephant", "पुं"),
        VocabWord("v12", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "सिंहः", "Siṃhaḥ", "सिंह (Lion)", "Lion", "पुं"),
        VocabWord("v13", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "व्याघ्रः", "Vyāghraḥ", "बाघ (Tiger)", "Tiger", "पुं"),
        VocabWord("v14", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "कुकुरः / श्वा", "Kukuraḥ / Śvā", "कुकुर (Dog)", "Dog", "पुं"),
        VocabWord("v15", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "मार्जारः / बिडालः", "Mārjāraḥ / Biḍālaḥ", "विरालो (Cat)", "Cat", "पुं"),
        VocabWord("v16", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "मयूरः", "Mayūraḥ", "मयूर (Peacock)", "Peacock", "पुं"),
        VocabWord("v17", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "शुकः", "Śukaḥ", "सुगा (Parrot)", "Parrot", "पुं"),
        VocabWord("v18", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "काकः", "Kākaḥ", "काग (Crow)", "Crow", "पुं"),
        VocabWord("v19", TrilingualText("पशवः", "पशुपक्षी", "Animals & Birds"), "हंसः", "Haṃsaḥ", "हंस (Swan)", "Swan", "पुं"),

        // Fruits & Food (फलानि शाकानि च)
        VocabWord("v20", TrilingualText("फलानि", "फलफूल र अन्न", "Fruits & Food"), "आम्रम्", "Āmram", "आँप (Mango)", "Mango", "नपुं"),
        VocabWord("v21", TrilingualText("फलानि", "फलफूल र अन्न", "Fruits & Food"), "कदलीफलम्", "Kadalīphalam", "केरा (Banana)", "Banana", "नपुं"),
        VocabWord("v22", TrilingualText("फलानि", "फलफूल र अन्न", "Fruits & Food"), "सेवम्", "Sevam", "स्याउ (Apple)", "Apple", "नपुं"),
        VocabWord("v23", TrilingualText("फलानि", "फलफूल र अन्न", "Fruits & Food"), "द्राक्षा", "Drākṣā", "अङ्गुर (Grape)", "Grape", "स्त्री"),
        VocabWord("v24", TrilingualText("फलानि", "फलफूल र अन्न", "Fruits & Food"), "दुग्धम् / क्षीरम्", "Dugdham / Kṣīram", "दूध (Milk)", "Milk", "नपुं"),
        VocabWord("v25", TrilingualText("फलानि", "फलफूल र अन्न", "Fruits & Food"), "घृतम् / आज्यम्", "Ghṛtam / Ājyam", "घिउ (Ghee)", "Clarified Butter (Ghee)", "नपुं"),
        VocabWord("v26", TrilingualText("फलानि", "फलफूल र अन्न", "Fruits & Food"), "ओदनम् / भक्तम्", "Odanam / Bhaktam", "भात (Cooked Rice)", "Cooked Rice", "नपुं"),
        VocabWord("v27", TrilingualText("फलानि", "फलफूल र अन्न", "Fruits & Food"), "मधु", "Madhu", "मह (Honey)", "Honey", "नपुं"),

        // Body Parts (शरीराङ्गानि)
        VocabWord("v28", TrilingualText("शरीराङ्गानि", "शरीरका अङ्गहरू", "Body Parts"), "शिरः / मस्तकम्", "Śiraḥ / Mastakam", "टाउको (Head)", "Head", "नपुं"),
        VocabWord("v29", TrilingualText("शरीराङ्गानि", "शरीरका अङ्गहरू", "Body Parts"), "नेत्रम् / नयनम्", "Netram / Nayanam", "आँखा (Eye)", "Eye", "नपुं"),
        VocabWord("v30", TrilingualText("शरीराङ्गानि", "शरीरका अङ्गहरू", "Body Parts"), "कर्णः / श्रोत्रम्", "Karṇaḥ / Śrotram", "कान (Ear)", "Ear", "पुं"),
        VocabWord("v31", TrilingualText("शरीराङ्गानि", "शरीरका अङ्गहरू", "Body Parts"), "नासिका / घ्राणम्", "Nāsikā / Ghrāṇam", "नाक (Nose)", "Nose", "स्त्री"),
        VocabWord("v32", TrilingualText("शरीराङ्गानि", "शरीरका अङ्गहरू", "Body Parts"), "हस्तः / करः", "Hastaḥ / Karaḥ", "हात (Hand)", "Hand", "पुं"),
        VocabWord("v33", TrilingualText("शरीराङ्गानि", "शरीरका अङ्गहरू", "Body Parts"), "पादः / चरणः", "Pādaḥ / Caraṇaḥ", "खुट्टा / पाउ", "Foot / Leg", "पुं"),
        VocabWord("v34", TrilingualText("शरीराङ्गानि", "शरीरका अङ्गहरू", "Body Parts"), "हृदयम्", "Hṛdayam", "मुटु / हृदय", "Heart", "नपुं"),

        // Nature & Elements (प्रकृतिः)
        VocabWord("v35", TrilingualText("प्रकृतिः", "प्रकृति र पञ्चतत्त्व", "Nature & Cosmos"), "सूर्यः / भानुः", "Sūryaḥ / Bhānuḥ", "घाम / सूर्य (Sun)", "Sun", "पुं"),
        VocabWord("v36", TrilingualText("प्रकृतिः", "प्रकृति र पञ्चतत्त्व", "Nature & Cosmos"), "चन्द्रः / शशी", "Candraḥ / Śaśī", "चन्द्रमा (Moon)", "Moon", "पुं"),
        VocabWord("v37", TrilingualText("प्रकृतिः", "प्रकृति र पञ्चतत्त्व", "Nature & Cosmos"), "भूमिः / पृथ्वी", "Bhūmiḥ / Pṛthvī", "पृथ्वी / जमिन", "Earth / Land", "स्त्री"),
        VocabWord("v38", TrilingualText("प्रकृतिः", "प्रकृति र पञ्चतत्त्व", "Nature & Cosmos"), "जलम् / वारि", "Jalam / Vāri", "पानी / जल (Water)", "Water", "नपुं"),
        VocabWord("v39", TrilingualText("प्रकृतिः", "प्रकृति र पञ्चतत्त्व", "Nature & Cosmos"), "अग्निः / पावकः", "Agniḥ / Pāvakaḥ", "आगो / अग्नि (Fire)", "Fire", "पुं"),
        VocabWord("v40", TrilingualText("प्रकृतिः", "प्रकृति र पञ्चतत्त्व", "Nature & Cosmos"), "वायुः / पवनः", "Vāyuḥ / Pavanaḥ", "हावा / बतास (Wind)", "Wind / Air", "पुं"),
        VocabWord("v41", TrilingualText("प्रकृतिः", "प्रकृति र पञ्चतत्त्व", "Nature & Cosmos"), "आकाशः / गगनम्", "Ākāśaḥ / Gaganam", "आकाश (Sky)", "Sky / Ether", "पुं"),
        VocabWord("v42", TrilingualText("प्रकृतिः", "प्रकृति र पञ्चतत्त्व", "Nature & Cosmos"), "पर्वतः / गिरिः", "Parvataḥ / Giriḥ", "पहाड / हिमाल", "Mountain", "पुं")
    )

    // -------------------------------------------------------------
    // QUIZZES (प्रश्नोत्तरी)
    // -------------------------------------------------------------
    val quizQuestions: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = "q1",
            category = "Varnamala",
            question = TrilingualText("संस्कृते कण्ठ्यस्वरौ कौ स्तः?", "संस्कृतमा कण्ठबाट उच्चारण हुने स्वरहरू कुन-कुन हुन्?", "Which vowels are articulated from the throat (Guttural)?"),
            options = listOf(
                TrilingualText("अ, आ", "अ, आ", "a, ā"),
                TrilingualText("इ, ई", "इ, ई", "i, ī"),
                TrilingualText("उ, ऊ", "उ, ऊ", "u, ū"),
                TrilingualText("ऋ, ॠ", "ऋ, ॠ", "ṛ, ṝ")
            ),
            correctIndex = 0,
            explanation = TrilingualText("'अकुहविसर्जनीयानां कण्ठः' इति सूत्रेण अ, आ, क-वर्गः, हकारः विसर्गश्च कण्ठ्याः।", "अ र आ कण्ठबाट उत्पन्न हुने स्वर हुन्।", "According to Panini's sutra, 'a' and 'ā' are articulated at the throat.")
        ),
        QuizQuestion(
            id = "q2",
            category = "Shabda Rupa",
            question = TrilingualText("'बालक' शब्दस्य तृतीया-एकवचने किं रूपं भवति?", "'बालक' शब्दको तृतीया विभक्ति एकवचनमा कुन रूप बन्दछ?", "What is the Instrumental Singular form of 'Bālaka'?"),
            options = listOf(
                TrilingualText("बालकम्", "बालकम्", "Bālakam"),
                TrilingualText("बालकाय", "बालकाय", "Bālakāya"),
                TrilingualText("बालकेन", "बालकेन", "Bālakena"),
                TrilingualText("बालकात्", "बालकात्", "Bālakāt")
            ),
            correctIndex = 2,
            explanation = TrilingualText("बालकस्य तृतीयायां 'बालकेन, बालकाभ्याम्, बालकैः' भवति।", "तृतीया एकवचनमा 'बालकेन' (बालकद्वारा) हुन्छ।", "Bālakena is the correct instrumental singular (by/with the boy).")
        ),
        QuizQuestion(
            id = "q3",
            category = "Dhatu Rupa",
            question = TrilingualText("'पठ्' धातोः लट्-लकारे उत्तमपुरुष-एकवचनं किम्?", "'पठ्' धातुको लट् लकार उत्तम पुरुष एकवचन के हुन्छ?", "What is the 1st person singular present tense form of 'Paṭh'?"),
            options = listOf(
                TrilingualText("पठति", "पठति", "Paṭhati"),
                TrilingualText("पठसि", "पठसि", "Paṭhasi"),
                TrilingualText("पठामि", "पठामि", "Paṭhāmi"),
                TrilingualText("अपठम्", "अपठम्", "Apaṭham")
            ),
            correctIndex = 2,
            explanation = TrilingualText("उत्तमपुरुषे 'अहं पठामि' इति भवति।", "उत्तम पुरुष एकवचनमा 'पठामि' (म पढ्छु) हुन्छ।", "Paṭhāmi is used with 'Aham' (I read).")
        ),
        QuizQuestion(
            id = "q4",
            category = "Sandhi",
            question = TrilingualText("'विद्या + आलयः' अस्य सन्धिपदं किम्?", "'विद्या + आलयः' जोड्दा के बन्दछ?", "What is the combined form of 'Vidyā + Ālayaḥ'?"),
            options = listOf(
                TrilingualText("विद्य्यालयः", "विद्य्यालयः", "Vidyālayaḥ"),
                TrilingualText("विद्यालयः", "विद्यालयः", "Vidyālayaḥ"),
                TrilingualText("विद्योदयः", "विद्योदयः", "Vidyodayaḥ"),
                TrilingualText("विद्यालयम्", "विद्यालयम्", "Vidyālayam")
            ),
            correctIndex = 1,
            explanation = TrilingualText("अकः सवर्णे दीर्घः इति सूत्रेण आ + आ = आ (दीर्घसन्धिः)।", "दीर्घ सन्धिको नियम अनुसार आ + आ = आ भएर 'विद्यालयः' बन्छ।", "Dirgha sandhi combines ā + ā into ā, forming Vidyālayaḥ.")
        ),
        QuizQuestion(
            id = "q5",
            category = "Conversation",
            question = TrilingualText("संस्कृते 'Thank you' इत्यर्थे किं कथ्यते?", "संस्कृतमा 'धन्यवाद (Thank you)' लाई के भनिन्छ?", "How do you say 'Thank you' in Sanskrit?"),
            options = listOf(
                TrilingualText("स्वागतम्", "स्वागतम्", "Svāgatam"),
                TrilingualText("क्षम्यताम्", "क्षम्यताम्", "Kṣamyatām"),
                TrilingualText("धन्यवादः", "धन्यवादः", "Dhanyavādaḥ"),
                TrilingualText("पुनर्मिलामः", "पुनर्मिलामः", "Punarmilāmaḥ")
            ),
            correctIndex = 2,
            explanation = TrilingualText("कृतज्ञताप्रकटनाय 'धन्यवादः' इति प्रयुज्यते।", "कृतज्ञता व्यक्त गर्दा 'धन्यवादः' भनिन्छ।", "Dhanyavādaḥ is used to express gratitude.")
        ),
        QuizQuestion(
            id = "q6",
            category = "Vocabulary",
            question = TrilingualText("'सूर्यः' इत्यस्य संस्कृतपर्यायपदं किम्?", "'सूर्य' को संस्कृत पर्यायवाची शब्द कुन हो?", "Which is a Sanskrit synonym for Sun (Sūrya)?"),
            options = listOf(
                TrilingualText("शशी", "शशी", "Śaśī"),
                TrilingualText("भानुः", "भानुः", "Bhānuḥ"),
                TrilingualText("वारि", "वारि", "Vāri"),
                TrilingualText("पावकः", "पावकः", "Pāvakaḥ")
            ),
            correctIndex = 1,
            explanation = TrilingualText("भानुः, भास्करः, दिवाकरः, रविः - एते सूर्यस्य पर्यायाः।", "भानु, भास्कर, रवि सूर्यका नाम हुन् (शशी चन्द्रमाको नाम हो)।", "Bhānuḥ, Ravi, and Bhāskara are synonyms of the Sun.")
        ),
        QuizQuestion(
            id = "q7",
            category = "Karaka",
            question = TrilingualText("'वृक्षात् पत्रं पतति' अत्र वृक्षात् पदे का विभक्तिः?", "'वृक्षात् पत्रं पतति' वाक्यमा 'वृक्षात्' मा कुन विभक्ति लागेको छ?", "Which case is used in 'Vṛkṣāt' in the sentence 'Vṛkṣāt patraṃ patati'?"),
            options = listOf(
                TrilingualText("तृतीया", "तृतीया", "Tṛtīyā (3rd)"),
                TrilingualText("चतुर्थी", "चतुर्थी", "Caturthī (4th)"),
                TrilingualText("पञ्चमी", "पञ्चमी", "Pañcamī (5th)"),
                TrilingualText("सप्तमी", "सप्तमी", "Saptamī (7th)")
            ),
            correctIndex = 2,
            explanation = TrilingualText("पृथग्भावे अपादानकारके पञ्चमी विभक्तिः प्रयुज्यते।", "रुखबाट पात अलग हुने (अपादान) हुनाले पञ्चमी विभक्ति लाग्यो।", "Ablative (Pañcamī) is used for separation from a source.")
        )
    )

    // -------------------------------------------------------------
    // FLASHCARDS (स्मरण-पट्टिका)
    // -------------------------------------------------------------
    val flashcards: List<FlashcardItem> = listOf(
        FlashcardItem("fc1", "अहम्", "Aham", "म (I)", "I (First person singular)", TrilingualText("अस्मद्-शब्दस्य प्रथमा-एकवचनम्", "अस्मद् प्रथमा एकवचन", "Nominative Singular of Asmad"), "Pronoun"),
        FlashcardItem("fc2", "त्वम्", "Tvam", "तपाईं / तिमी (You)", "You (Second person singular)", TrilingualText("युष्मद्-शब्दस्य प्रथमा-एकवचनम्", "युष्मद् प्रथमा एकवचन", "Nominative Singular of Yushmad"), "Pronoun"),
        FlashcardItem("fc3", "सः", "Saḥ", "उनी / त्यो (He/That)", "He / That (Masculine)", TrilingualText("तद्-शब्दस्य पुंल्लिङ्गे प्रथमा", "तद् पुंलिङ्ग प्रथमा", "Nominative Masculine of Tad"), "Pronoun"),
        FlashcardItem("fc4", "सा", "Sā", "उनी / त्यो (She/That)", "She / That (Feminine)", TrilingualText("तद्-शब्दस्य स्त्रीलिङ्गे प्रथमा", "तद् स्त्रीलिङ्ग प्रथमा", "Nominative Feminine of Tad"), "Pronoun"),
        FlashcardItem("fc5", "गच्छति", "Gacchati", "जान्छ / जानुहुन्छ", "Goes (Present tense 3rd person)", TrilingualText("गम् धातोः लट् प्रथमपुरुष-एकवचनम्", "गम् लट् प्रथम पुरुष", "Gam root present 3rd sing."), "Verb"),
        FlashcardItem("fc6", "पठति", "Paṭhati", "पढ्छ / पढ्नुहुन्छ", "Reads (Present tense 3rd person)", TrilingualText("पठ् धातोः लट् प्रथमपुरुष-एकवचनम्", "पठ् लट् प्रथम पुरुष", "Path root present 3rd sing."), "Verb"),
        FlashcardItem("fc7", "अस्ति", "Asti", "छ / हुनुहुन्छ", "Is / Exists", TrilingualText("अस् धातोः लट् प्रथमपुरुष-एकवचनम्", "अस् लट् प्रथम पुरुष", "As root present 3rd sing."), "Verb"),
        FlashcardItem("fc8", "पुस्तकम्", "Pustakam", "किताब / पुस्तक", "Book", TrilingualText("अकारान्त-नपुंसकलिङ्गम्", "अकारान्त नपुंसकलिङ्ग", "Neuter noun"), "Noun"),
        FlashcardItem("fc9", "गृहम्", "Gṛham", "घर / निवास", "Home / House", TrilingualText("अकारान्त-नपुंसकलिङ्गम्", "अकारान्त नपुंसकलिङ्ग", "Neuter noun"), "Noun"),
        FlashcardItem("fc10", "विद्यालयः", "Vidyālayaḥ", "विद्यालय / पाठशाला", "School", TrilingualText("अकारान्त-पुंल्लिङ्गम्", "अकारान्त पुंलिङ्ग", "Masculine noun"), "Noun"),
        FlashcardItem("fc11", "सत्यम्", "Satyam", "सत्य / साँचो", "Truth / Reality", TrilingualText("नपुंसकलिङ्गम्", "नपुंसकलिङ्ग", "Neuter noun"), "Wisdom"),
        FlashcardItem("fc12", "शान्तिः", "Śāntiḥ", "शान्ति / अमन", "Peace / Calmness", TrilingualText("इकारान्त-स्त्रीलिङ्गम्", "इकारान्त स्त्रीलिङ्ग", "Feminine noun"), "Wisdom")
    )

    // -------------------------------------------------------------
    // CULTURE, TRADITIONS & HISTORY (संस्कृतिः, परम्परा, इतिहासश्च)
    // -------------------------------------------------------------
    val cultureArticles: List<CultureArticle> = listOf(
        CultureArticle(
            id = "c1",
            title = TrilingualText("वैदिक-परम्परा एवं इतिहासः", "वैदिक संस्कृति तथा इतिहास", "Vedic Heritage & Antiquity"),
            category = TrilingualText("इतिहासः (History)", "इतिहास", "History"),
            subtitle = TrilingualText("वेदवाणी, मन्त्राः ऋषयश्च", "चार वेद र ऋषिका उपदेशहरू", "The Four Vedas & the Seers"),
            content = TrilingualText(
                "संस्कृतभाषा विश्वस्य प्राचीनतमा परिष्कृता च भाषा अस्ति। 'संस्कृतम्' इत्यस्य अर्थः 'संस्कृतं शुद्धं परिमार्जितम्' इति। चत्वारः वेदाः (ऋग्वेदः, यजुर्वेदः, सामवेदः, अथर्ववेदः) मानवजातेः प्राचीनतमाः ग्रन्थाः सन्ति। ऋषयः ध्यानसमाधौ एतान् मन्त्रान् अपश्यन्, अतः वेदाः 'अपौरुषेयाः' मन्यन्ते।",
                "संस्कृत संसारकै सबैभन्दा प्राचीन, समृद्ध र वैज्ञानिक भाषा हो। 'संस्कृत' को अर्थ नै 'संस्कार गरिएको, शुद्ध र परिमार्जित' भन्ने हुन्छ। हाम्रा चार वेदहरू (ऋग्वेद, यजुर्वेद, सामवेद, अथर्ववेद) मानव सभ्यताका प्राचीनतम ग्रन्थ हुन्। ऋषि-मुनिहरूले ध्यानको गहिराइमा यी मन्त्रहरूको साक्षात्कार गरेका थिए।",
                "Sanskrit is one of the world's most ancient and meticulously perfected languages. The term 'Samskritam' literally signifies 'refined, polished, and sacredly consecrated'. The four Vedas represent humanity's earliest extant sacred literature, perceived directly by visionary seers in deep states of contemplation."
            ),
            highlightVerse = "एकं सद् विप्रा बहुधा वदन्ति। (ऋग्वेदः १.१६४.४६)",
            keyFacts = listOf(
                TrilingualText("ऋग्वेदः १०२८ सूक्तैः युक्तः अस्ति।", "ऋग्वेदमा १,०२८ सूक्तहरू छन्।", "Rigveda contains 1,028 hymns."),
                TrilingualText("वेदाः मौखिकपरम्परया सुरक्षिताः।", "वेदहरू हजारौँ वर्षदेखि मौखिक परम्पराबाट सुरक्षित राखिए।", "Preserved through unbroken oral recitation."),
                TrilingualText("युनेस्को-संस्थया 'अमूर्त-धरोहर' रूपेण स्वीकृतः।", "युनेस्कोले वैदिक पाठलाई विश्व अमूर्त सम्पदा घोषणा गरेको छ।", "Recognized by UNESCO as Masterpiece of Oral Heritage.")
            )
        ),
        CultureArticle(
            id = "c2",
            title = TrilingualText("नेपाले संस्कृत-परम्परा", "नेपालमा संस्कृतको ऐतिहासिक परम्परा", "Sanskrit Traditions of Nepal"),
            category = TrilingualText("परम्परा (Tradition)", "नेपाल सम्पदा", "Nepal Heritage"),
            subtitle = TrilingualText("काष्ठमण्डपस्य पाण्डुलिपयः, लिच्छवि-शिलालेखाः च", "काठमाडौँ उपत्यका र लिच्छविकालीन संस्कृत अभिलेख", "Manuscripts, Licchavi Inscriptions & Ashrams"),
            content = TrilingualText(
                "नेपालदेशः अनादिकालत एव संस्कृतविद्यायाः प्रमुखं केन्द्रं वर्तते। काष्ठमण्डपे (काठमाडौँ) पशुपतिनाथस्य पावनक्षेत्रे, जनकपुरे विदेहराजस्य राजसभायां, देवघाट-तपोभूमौ च संस्कृतस्य अविरलः प्रवाहः आसीत्। लिच्छविकालस्य मानदेवस्य शिलालेखेषु (चाँगुनारायण) उत्कृष्टं संस्कृतकाव्यं दृश्यते। नेपालस्य राष्ट्रियाभिलेखागारे विश्वस्य प्राचीनाः ताडपत्र-पाण्डुलिपयः अद्यापि सुरक्षिताः सन्ति।",
                "नेपाल अनादिकालदेखि नै संस्कृत विद्या, साधना र अनुसन्धानको पुण्यभूमि रहिआएको छ। काठमाडौँको पशुपतिनाथ क्षेत्र, जनकपुरको जनक-याज्ञवल्क्य सभा, र देवघाट-वराहक्षेत्र जस्ता तपोभूमिमा संस्कृतको अक्षुण्ण साधना हुँदै आएको छ। राजा मानदेवको चाँगुनारायणको शिलालेख (ई.सं. ४६४) नेपालको पहिलो प्रामाणिक संस्कृत काव्य अभिलेख हो। नेपालको राष्ट्रिय अभिलेखागारमा विश्वमै दुर्लभ प्राचीन तालपत्र पाण्डुलिपिहरू सङ्गृहीत छन्।",
                "Nepal has been an unbroken cradle of Sanskrit learning and spirituality for millennia. From the sacred Pashupatinath temple complex to the philosophical courts of King Janaka in Mithila and the Himalayan retreats of Devghat, Sanskrit thrived. The Changunarayan pillar inscription of King Manadeva (464 CE) stands as a poetic masterpiece in Sanskrit, and Nepal's National Archives houses thousands of the world's oldest palm-leaf manuscripts."
            ),
            highlightVerse = "जननी जन्मभूमिश्च स्वर्गादपि गरीयसी। (रामायणम् - नेपालस्य राष्ट्रिय-ध्येयवाक्यम्)",
            keyFacts = listOf(
                TrilingualText("नेपालस्य राष्ट्रिय-ध्येयवाक्यं संस्कृते अस्ति।", "नेपालको राष्ट्रिय आदर्श वाक्य संस्कृतमा छ ('जननी जन्मभूमिश्च...')।", "Nepal's national motto is in Sanskrit."),
                TrilingualText("लिच्छविकालस्य सर्वे शिलालेखाः संस्कृते एव सन्ति।", "लिच्छविकालका सबै राजकीय अभिलेखहरू शुद्ध संस्कृतमा कुँदिएका छन्।", "All Licchavi royal inscriptions were in Sanskrit."),
                TrilingualText("विश्वस्य प्राचीनतमः 'सुश्रुतसंहिता' तालपत्र-ग्रन्थः नेपाले लब्धः।", "सुश्रुतसंहिताको संसारकै सबैभन्दा पुरानो पाण्डुलिपि नेपालमै फेला परेको थियो।", "The oldest palm-leaf Sushruta Samhita was preserved in Nepal.")
            )
        ),
        CultureArticle(
            id = "c3",
            title = TrilingualText("महर्षिः पाणिनिः एवं व्याकरण-विज्ञानम्", "महर्षि पाणिनि र व्याकरण विज्ञान", "Panini & Scientific Grammar"),
            category = TrilingualText("विज्ञानम् (Science)", "भाषा विज्ञान", "Linguistics"),
            subtitle = TrilingualText("अष्टाध्यायी - विश्वस्य प्रथमा सङ्गणकीय भाषा", "४,००० सूत्र र कम्प्युटर विज्ञानसँग तुलना", "Ashtadhyayi & Computational Structure"),
            content = TrilingualText(
                "महर्षिः पाणिनिः (क्रि.पू. ५००) संस्कृतस्य यद् व्याकरणं रचितवान्, तद् आधुनिकभाषाविज्ञानस्य सङ्गणकशास्त्रस्य च आश्चर्यम् अस्ति। अष्टाध्याय्यां केवलं प्रायः ४००० सूत्राणि सन्ति, यैः समग्रसंस्कृतशब्दानां निष्पत्तिः गणितीय-अल्गोरिदम-रूपेण भवति। 'नासा' (NASA) वैज्ञानिकैः अपि संस्कृतं कृत्रिमबुद्धेः (AI) कृते सर्वाधिकं उपयुक्तम् इति घोषितम्।",
                "महर्षि पाणिनिले (ईसापूर्व ५०० तिर) रचना गरेको 'अष्टाध्यायी' ग्रन्थ संसारकै पहिलो औपचारिक व्याकरण प्रणाली हो। केवल करिब ४,००० सूत्रहरू मार्फत संस्कृतका सम्पूर्ण शब्दहरूको निर्माण गणितीय अल्गोरिदम झैँ हुन्छ। यसको नियमबद्धता यति अचम्मको छ कि कम्प्युटर भाषा (Backus-Naur Form) र कृत्रिम बुद्धिमत्ता (AI) का लागि संस्कृतलाई विश्वकै आदर्श भाषा मानिन्छ।",
                "Around 500 BCE, Maharishi Panini created the 'Ashtadhyayi', a generative grammar comprising nearly 4,000 algorithmic rules. Its rule-precedence, metarules, and auxiliary markers anticipate modern computer programming languages and context-free grammars (BNF) by more than two millennia."
            ),
            highlightVerse = "वृद्धिरादैच्॥ (अष्टाध्यायी १.१.१)",
            keyFacts = listOf(
                TrilingualText("४००० सूत्राणां सङ्क्षिप्तः तन्त्रविशेषः।", "४,००० संक्षिप्त सूत्रहरूमा सम्पूर्ण भाषा बाँधिएको छ।", "4,000 algorithmic rules cover the entire language."),
                TrilingualText("माहेश्वरसूत्राणि ध्वनिविज्ञानस्य परमा पराकाष्ठा।", "माहेश्वर सूत्रहरू ध्वनिविज्ञानको सर्वोच्च नमुना हुन्।", "Shiva Sutras represent ultimate phonetic classification."),
                TrilingualText("कम्प्युटर-प्रोग्रामिङ-भाषासदृशं रूपम्।", "कम्प्युटर कोडिङसँग मेल खाने अचम्मको संरचना।", "Directly parallels formal context-free grammars.")
            )
        ),
        CultureArticle(
            id = "c4",
            title = TrilingualText("संस्कृते दर्शनं खगोलशास्त्रं च", "संस्कृतमा दर्शन, खगोल र आयुर्वेद", "Philosophy, Astronomy & Ayurveda"),
            category = TrilingualText("ज्ञानम् (Wisdom)", "ज्ञान-विज्ञान", "Knowledge"),
            subtitle = TrilingualText("आर्यभटः, चरकः, सुश्रुतः उपनिषदश्च", "शून्यको आविष्कार, आयुर्वेद र खगोल विज्ञान", "Aryabhata, Charaka, Sushruta & Upanishads"),
            content = TrilingualText(
                "संस्कृतं केवलं पूजा-पाठस्य भाषा न, अपि तु गहनविज्ञानस्य भण्डारम् अस्ति। आर्यभटेन पृथिव्याः घूर्णनं, सूर्यग्रहणस्य कारणं, π (पाइ) इत्यस्य मानं च संस्कृतेन श्लोकरूपेण प्रतिपादितम्। चरकसंहितायां सुश्रुतसंहितायां च आधुनिकशल्यक्रियायाः औषधविज्ञानस्य च प्राचीना आधारशिला वर्तते।",
                "संस्कृत केवल पूजाआजाको भाषा मात्र होइन, यो विज्ञान, खगोल, चिकित्सा र गहन दर्शनको भण्डार हो। आर्यभटले पृथ्वीको दैनिक गति र सूर्यग्रहणको वैज्ञानिक कारण संस्कृत श्लोकमै प्रमाणित गरेका थिए। सुश्रुतसंहितामा संसारकै पहिलो प्लास्टिक सर्जरी र शल्यक्रियाका साधनहरूको विस्तृत वर्णन पाइन्छ।",
                "Sanskrit is a boundless repository of empirical science, mathematics, and philosophy. In the Aryabhatiya, Aryabhata calculated the value of Pi, explained lunar and solar eclipses, and asserted planetary rotations. Sushruta documented over 300 surgical procedures and 120 surgical instruments in Sanskrit."
            ),
            highlightVerse = "सत्यमेव जयते नानृतम्। (मुण्डकोपनिषद् ३.१.६)",
            keyFacts = listOf(
                TrilingualText("दशमलव-पद्धतेः शून्यस्य च आविष्कारः।", "शून्य र दशमलव पद्धतिको वैज्ञानिक विकास।", "Invention of Zero and decimal numeral system."),
                TrilingualText("शल्यक्रियायाः जनकः सुश्रुतः।", "सुश्रुतलाई विश्व शल्यचिकित्सा (सर्जरी) का जनक मानिन्छ।", "Sushruta is hailed as the father of surgery."),
                TrilingualText("उपनिषदां वेदान्त-दर्शनम्।", "उपनिषदहरूको अद्वैत दर्शन विश्वकै गहन विचार मानिन्छ।", "Upanishadic philosophy influenced global thought.")
            )
        )
    )
}
