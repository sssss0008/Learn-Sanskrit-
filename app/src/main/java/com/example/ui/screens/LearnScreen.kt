package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AppLanguage
import com.example.data.model.TrilingualText
import com.example.data.model.VarnaCategory
import com.example.ui.components.AudioSpeakButton
import com.example.ui.theme.SanskritGold
import com.example.ui.theme.SanskritOrange
import com.example.ui.viewmodel.LearnSubSection
import com.example.ui.viewmodel.SanskritViewModel

@Composable
fun LearnScreen(
    viewModel: SanskritViewModel,
    modifier: Modifier = Modifier
) {
    val subSection by viewModel.learnSubSection.collectAsState()
    val currentLang by viewModel.currentLanguage.collectAsState()

    // Handle back button when inside a sub-module
    BackHandler(enabled = subSection != LearnSubSection.OVERVIEW) {
        viewModel.selectLearnSubSection(LearnSubSection.OVERVIEW)
    }

    AnimatedContent(
        targetState = subSection,
        transitionSpec = {
            if (targetState == LearnSubSection.OVERVIEW) {
                slideInHorizontally { -it } + fadeIn() togetherWith slideOutHorizontally { it } + fadeOut()
            } else {
                slideInHorizontally { it } + fadeIn() togetherWith slideOutHorizontally { -it } + fadeOut()
            }
        },
        label = "learn_navigation"
    ) { section ->
        when (section) {
            LearnSubSection.OVERVIEW -> LearnOverviewView(viewModel, currentLang, modifier)
            LearnSubSection.VARNAMALA -> VarnamalaDetailView(viewModel, currentLang, modifier)
            LearnSubSection.MAHESHWARA -> MaheshwaraDetailView(viewModel, currentLang, modifier)
            LearnSubSection.SHABDA_RUPA -> ShabdaRupaDetailView(viewModel, currentLang, modifier)
            LearnSubSection.DHATU_RUPA -> DhatuRupaDetailView(viewModel, currentLang, modifier)
            LearnSubSection.SANDHI -> SandhiDetailView(viewModel, currentLang, modifier)
            LearnSubSection.KARAKA -> KarakaDetailView(viewModel, currentLang, modifier)
            LearnSubSection.CONVERSATION -> ConversationDetailView(viewModel, currentLang, modifier)
        }
    }
}

@Composable
fun LearnOverviewView(
    viewModel: SanskritViewModel,
    lang: AppLanguage,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Daily Verse Banner
        item {
            DailyVerseBanner(viewModel, lang)
        }

        // Section Title
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AutoStories,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = when (lang) {
                        AppLanguage.SANSKRIT -> "संस्कृत-शिक्षण-पाठाः"
                        AppLanguage.NEPALI -> "संस्कृत शिक्षण पाठहरू"
                        AppLanguage.ENGLISH -> "Sanskrit Curriculum Modules"
                    },
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        // Grid of Curricular Modules
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                // 1. Varnamala & Maheshwara
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ModuleCard(
                        title = TrilingualText("१. वर्णमाला", "१. वर्णमाला", "1. Alphabet").get(lang),
                        subtitle = TrilingualText("स्वराः व्यञ्जनानि च", "स्वर र व्यञ्जन वर्ण", "Vowels & Consonants").get(lang),
                        icon = Icons.Default.Translate,
                        badge = "४६ वर्णाः",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f),
                        onClick = { viewModel.selectLearnSubSection(LearnSubSection.VARNAMALA) }
                    )
                    ModuleCard(
                        title = TrilingualText("२. माहेश्वरसूत्राणि", "२. माहेश्वर सूत्र", "2. Shiva Sutras").get(lang),
                        subtitle = TrilingualText("पाणिनीय-व्याकरणम्", "व्याकरणको मूल आधार", "Panini Foundations").get(lang),
                        icon = Icons.Default.MusicNote,
                        badge = "१४ सूत्राणि",
                        color = SanskritOrange,
                        modifier = Modifier.weight(1f),
                        onClick = { viewModel.selectLearnSubSection(LearnSubSection.MAHESHWARA) }
                    )
                }

                // 2. Shabda Rupa & Dhatu Rupa
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ModuleCard(
                        title = TrilingualText("३. शब्दरूपाणि", "३. शब्दरूप (विभक्ति)", "3. Noun Declensions").get(lang),
                        subtitle = TrilingualText("७ विभक्तयः, ३ वचनानि", "सबै लिङ्गका शब्दहरू", "7 Cases & 3 Numbers").get(lang),
                        icon = Icons.Default.TableChart,
                        badge = "बालक, लता...",
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.weight(1f),
                        onClick = { viewModel.selectLearnSubSection(LearnSubSection.SHABDA_RUPA) }
                    )
                    ModuleCard(
                        title = TrilingualText("४. धातुरूपाणि", "४. धातुरूप (क्रियापद)", "4. Verb Conjugations").get(lang),
                        subtitle = TrilingualText("लट्, लृट्, लङ्...", "काल तथा आज्ञा रूप", "Present, Past, Future").get(lang),
                        icon = Icons.Default.Bolt,
                        badge = "पठ्, गम्...",
                        color = SanskritGold,
                        modifier = Modifier.weight(1f),
                        onClick = { viewModel.selectLearnSubSection(LearnSubSection.DHATU_RUPA) }
                    )
                }

                // 3. Sandhi & Karaka
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ModuleCard(
                        title = TrilingualText("५. सन्धि-प्रकरणम्", "५. सन्धिको नियम", "5. Sandhi Rules").get(lang),
                        subtitle = TrilingualText("स्वर-व्यञ्जन-विसर्गः", "ध्वनि संयोजनका नियम", "Sound Combinations").get(lang),
                        icon = Icons.Default.MergeType,
                        badge = "दीर्घ, गुण...",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f),
                        onClick = { viewModel.selectLearnSubSection(LearnSubSection.SANDHI) }
                    )
                    ModuleCard(
                        title = TrilingualText("६. कारक-प्रकरणम्", "६. कारक तथा वाक्य", "6. Karaka & Syntax").get(lang),
                        subtitle = TrilingualText("कर्ता, कर्म, करणम्...", "६ कारक र विभक्ति", "Cases & Relationships").get(lang),
                        icon = Icons.Default.AccountTree,
                        badge = "६ कारकाणि",
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.weight(1f),
                        onClick = { viewModel.selectLearnSubSection(LearnSubSection.KARAKA) }
                    )
                }

                // 4. Spoken Sanskrit
                ModuleCardFull(
                    title = TrilingualText("७. सम्भाषण-संस्कृतम् (Spoken Sanskrit)", "७. दैनिक संस्कृत कुराकानी", "7. Spoken Sanskrit & Daily Phrases").get(lang),
                    subtitle = TrilingualText("अभिवादनम्, परिचयः, समयः, सङ्ख्याः च", "दैनिक संवाद, समय सोध्ने र सङ्ख्याहरू", "Daily greetings, introductions, telling time & numbers").get(lang),
                    icon = Icons.Default.Forum,
                    badge = "३०+ वाक्यानि",
                    color = MaterialTheme.colorScheme.primary,
                    onClick = { viewModel.selectLearnSubSection(LearnSubSection.CONVERSATION) }
                )
            }
        }
    }
}

@Composable
fun DailyVerseBanner(
    viewModel: SanskritViewModel,
    lang: AppLanguage
) {
    val dailySloka = viewModel.subhashitas.first()

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                            MaterialTheme.colorScheme.surfaceVariant
                        )
                    )
                )
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = when (lang) {
                            AppLanguage.SANSKRIT -> "दैनिक-सुभाषितम्"
                            AppLanguage.NEPALI -> "दैनिक सुभाषित श्लोक"
                            AppLanguage.ENGLISH -> "Verse of the Day"
                        },
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                AudioSpeakButton(
                    textToSpeak = dailySloka.slokaText,
                    onSpeak = { viewModel.speak(it) }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = dailySloka.slokaText,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                lineHeight = 26.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalDivider(
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.2f),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = when (lang) {
                    AppLanguage.SANSKRIT -> dailySloka.sanskritMeaning
                    AppLanguage.NEPALI -> dailySloka.nepaliMeaning
                    AppLanguage.ENGLISH -> dailySloka.englishMeaning
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 20.sp
            )
        }
    }
}

@Composable
fun ModuleCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    badge: String,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = color,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = badge,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }
    }
}

@Composable
fun ModuleCardFull(
    title: String,
    subtitle: String,
    icon: ImageVector,
    badge: String,
    color: Color,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = color,
                    modifier = Modifier.size(26.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Text(
                    text = badge,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

// -------------------------------------------------------------
// VARNAMALA DETAIL VIEW
// -------------------------------------------------------------
@Composable
fun VarnamalaDetailView(
    viewModel: SanskritViewModel,
    lang: AppLanguage,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        TrilingualText("स्वराः (१३)", "स्वरहरू (१३)", "Vowels (13)"),
        TrilingualText("व्यञ्जनानि (३३)", "व्यञ्जनहरू (३३)", "Consonants (33)")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // Back header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            IconButton(
                onClick = { viewModel.selectLearnSubSection(LearnSubSection.OVERVIEW) },
                modifier = Modifier.minimumInteractiveComponentSize()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = TrilingualText("संस्कृत-वर्णमाला", "संस्कृत वर्णमाला", "Sanskrit Alphabet").get(lang),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = TrilingualText("अक्षर-ज्ञानम् एवं उच्चारणस्थानम्", "अक्षर तथा उच्चारण स्थान", "Phonetics & Articulation Anatomy").get(lang),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Tab Row
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title.get(lang),
                            fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        val currentItems = if (selectedTab == 0) viewModel.swaras else viewModel.vyanjanas

        LazyColumn(
            contentPadding = PaddingValues(bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(currentItems) { item ->
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Large Devanagari character display
                        Box(
                            modifier = Modifier
                                .size(54.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item.character,
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = item.character,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "[ ${item.iast} ]",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "${TrilingualText("स्थानम्:", "उच्चारण स्थान:", "Place:").get(lang)} ${item.sthana.get(lang)}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Text(
                                text = "${TrilingualText("यथा:", "उदाहरण:", "Example:").get(lang)} ${item.exampleWord} (${item.exampleMeaning.get(lang)})",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        AudioSpeakButton(
                            textToSpeak = "${item.character}, ${item.exampleWord}",
                            onSpeak = { viewModel.speak(it) }
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// MAHESHWARA SUTRAS VIEW
// -------------------------------------------------------------
@Composable
fun MaheshwaraDetailView(
    viewModel: SanskritViewModel,
    lang: AppLanguage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            IconButton(
                onClick = { viewModel.selectLearnSubSection(LearnSubSection.OVERVIEW) },
                modifier = Modifier.minimumInteractiveComponentSize()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = TrilingualText("माहेश्वर-सूत्राणि (Shiva Sutras)", "माहेश्वर सूत्रहरू (१४ सूत्र)", "14 Maheshwara Sutras").get(lang),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = TrilingualText("पाणिनीय-व्याकरणस्य आधारस्तम्भः", "पाणिनि व्याकरणको बीज मन्त्र", "Algorithmic foundation of Sanskrit grammar").get(lang),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Introduction Banner
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = TrilingualText(
                    "नृत्तावसाने नटराजराजो ननाद ढक्कां नवपञ्चवारम्।\nउद्धर्तुकामः सनकादिसिद्धानेतद् विमर्शे शिवसूत्रजालम्॥",
                    "भगवान् शिवजीले ताण्डव नृत्यको अन्त्यमा १४ पटक डमरू बजाउनुहुँदा यी १४ माहेश्वर सूत्रहरू प्रकट भएका थिए।",
                    "At the climax of the cosmic dance, Lord Shiva sounded his drum 14 times, revealing these 14 phonological formulas."
                ).get(lang),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            contentPadding = PaddingValues(bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.maheshwaraSutras) { sutra ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = sutra.sutra,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "[ ${sutra.iast} ]",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "${TrilingualText("समाविष्टाः वर्णाः:", "वर्णहरू:", "Letters:").get(lang)} ${sutra.includedLetters}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = sutra.explanation.get(lang),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        AudioSpeakButton(
                            textToSpeak = sutra.sutra,
                            onSpeak = { viewModel.speak(it) }
                        )
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// SHABDA RUPA DETAIL VIEW
// -------------------------------------------------------------
@Composable
fun ShabdaRupaDetailView(
    viewModel: SanskritViewModel,
    lang: AppLanguage,
    modifier: Modifier = Modifier
) {
    val selectedId by viewModel.selectedShabdaId.collectAsState()
    val table = viewModel.shabdaRupaTables.find { it.id == selectedId } ?: viewModel.shabdaRupaTables.first()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            IconButton(
                onClick = { viewModel.selectLearnSubSection(LearnSubSection.OVERVIEW) },
                modifier = Modifier.minimumInteractiveComponentSize()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = TrilingualText("शब्दरूपाणि (Noun Declensions)", "शब्दरूप (विभक्ति तालिकाहरू)", "Noun Declension Tables").get(lang),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${table.gender.get(lang)} - ${table.endingType}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // Horizontal selector for nouns
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            items(viewModel.shabdaRupaTables) { item ->
                FilterChip(
                    selected = item.id == selectedId,
                    onClick = { viewModel.selectShabda(item.id) },
                    label = { Text(item.title) }
                )
            }
        }

        // Shabda Rupa Table Header & Rows
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                // Table Columns Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("विभक्तिः", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.weight(1.2f))
                    Text("एकवचनम्", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("द्विवचनम्", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("बहुवचनम्", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                }

                Spacer(modifier = Modifier.height(6.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxHeight(),
                    contentPadding = PaddingValues(bottom = 96.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(table.rows) { row ->
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1.2f)) {
                                        Text(
                                            text = row.vibhaktiName.get(lang),
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                        Text(
                                            text = row.meaningSummary.get(lang),
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                            fontSize = 10.sp
                                        )
                                    }

                                    Text(
                                        text = row.singular,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        text = row.dual,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        text = row.plural,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Center
                                    )

                                    AudioSpeakButton(
                                        textToSpeak = "${row.singular}, ${row.dual}, ${row.plural}",
                                        onSpeak = { viewModel.speak(it) },
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// DHATU RUPA DETAIL VIEW
// -------------------------------------------------------------
@Composable
fun DhatuRupaDetailView(
    viewModel: SanskritViewModel,
    lang: AppLanguage,
    modifier: Modifier = Modifier
) {
    val selectedId by viewModel.selectedDhatuId.collectAsState()
    val table = viewModel.dhatuRupaTables.find { it.id == selectedId } ?: viewModel.dhatuRupaTables.first()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            IconButton(
                onClick = { viewModel.selectLearnSubSection(LearnSubSection.OVERVIEW) },
                modifier = Modifier.minimumInteractiveComponentSize()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = TrilingualText("धातुरूपाणि (Verb Conjugations)", "धातुरूप (क्रियापद तालिका)", "Verb Conjugation Tables").get(lang),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${table.root} - ${table.lakaraName.get(lang)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // Horizontal selector for Dhatus
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            items(viewModel.dhatuRupaTables) { item ->
                FilterChip(
                    selected = item.id == selectedId,
                    onClick = { viewModel.selectDhatu(item.id) },
                    label = { Text("${item.root} (${item.lakara})") }
                )
            }
        }

        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("पुरुषः", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.weight(1.2f))
                    Text("एकवचनम्", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("द्विवचनम्", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("बहुवचनम्", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelMedium, modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                }

                Spacer(modifier = Modifier.height(8.dp))

                table.rows.forEach { row ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = row.purushaName.get(lang),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.secondary,
                                    modifier = Modifier.weight(1.2f)
                                )

                                Text(
                                    text = row.singular,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.weight(1f),
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = row.dual,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.weight(1f),
                                    textAlign = TextAlign.Center
                                )

                                Text(
                                    text = row.plural,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.weight(1f),
                                    textAlign = TextAlign.Center
                                )

                                AudioSpeakButton(
                                    textToSpeak = "${row.singular}, ${row.dual}, ${row.plural}",
                                    onSpeak = { viewModel.speak(it) },
                                    modifier = Modifier.size(32.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "${TrilingualText("उदाहरणम्:", "उदाहरण:", "Example:").get(lang)} ${row.pronounExample}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// SANDHI DETAIL VIEW
// -------------------------------------------------------------
@Composable
fun SandhiDetailView(
    viewModel: SanskritViewModel,
    lang: AppLanguage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            IconButton(
                onClick = { viewModel.selectLearnSubSection(LearnSubSection.OVERVIEW) },
                modifier = Modifier.minimumInteractiveComponentSize()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = TrilingualText("सन्धि-प्रकरणम्", "सन्धि नियमहरू", "Sandhi Rules & Formulas").get(lang),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = TrilingualText("परः संनिकर्षः संहिता (वर्णसंयोजनम्)", "वर्णहरूको वैज्ञानिक संयोजन", "Phonetic Euphonic Junctions").get(lang),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(viewModel.sandhiRules) { rule ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = rule.name.get(lang),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Formula: ${rule.formula}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = rule.explanation.get(lang),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = TrilingualText("प्रमुखाणि उदाहरणानि:", "प्रमुख उदाहरणहरू:", "Key Examples:").get(lang),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        rule.examples.forEach { eg ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "${eg.firstWord} + ${eg.secondWord} =",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = eg.combinedWord,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "(${eg.meaning.get(lang)})",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                AudioSpeakButton(
                                    textToSpeak = eg.combinedWord,
                                    onSpeak = { viewModel.speak(it) },
                                    modifier = Modifier.size(28.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// KARAKA DETAIL VIEW
// -------------------------------------------------------------
@Composable
fun KarakaDetailView(
    viewModel: SanskritViewModel,
    lang: AppLanguage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            IconButton(
                onClick = { viewModel.selectLearnSubSection(LearnSubSection.OVERVIEW) },
                modifier = Modifier.minimumInteractiveComponentSize()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = TrilingualText("कारक-प्रकरणम् (Cases & Syntax)", "कारक तथा विभक्ति नियम", "Karaka (Semantic Cases)").get(lang),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = TrilingualText("क्रियाजनकं कारकम् (६ कारकाणि)", "क्रियासँग प्रत्यक्ष सम्बन्ध राख्ने पद", "Direct relationship between noun and verb").get(lang),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(viewModel.karakaTopics) { karaka ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = karaka.name.get(lang),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Text(
                                    text = karaka.vibhakti.get(lang),
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = karaka.definition.get(lang),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = karaka.exampleSentence,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = karaka.sentenceBreakdown.get(lang),
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }

                                AudioSpeakButton(
                                    textToSpeak = karaka.exampleSentence,
                                    onSpeak = { viewModel.speak(it) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// -------------------------------------------------------------
// CONVERSATION DETAIL VIEW
// -------------------------------------------------------------
@Composable
fun ConversationDetailView(
    viewModel: SanskritViewModel,
    lang: AppLanguage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            IconButton(
                onClick = { viewModel.selectLearnSubSection(LearnSubSection.OVERVIEW) },
                modifier = Modifier.minimumInteractiveComponentSize()
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = TrilingualText("सम्भाषण-संस्कृतम् (Daily Sanskrit)", "दैनिक कुराकानी र संवाद", "Spoken Sanskrit Conversation").get(lang),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = TrilingualText("व्यवहारे संस्कृतम् - शिष्टाचारः, परिचयः, समयः", "दैनिक जीवनमा प्रयोग हुने मीठा वाक्यहरू", "Everyday phrases with audio pronunciation").get(lang),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(viewModel.conversationPhrases) { phrase ->
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(14.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                                modifier = Modifier.padding(bottom = 4.dp)
                            ) {
                                Text(
                                    text = phrase.category.get(lang),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }

                            Text(
                                text = phrase.sanskrit,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Text(
                                text = "[ ${phrase.iast} ]",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = when (lang) {
                                    AppLanguage.SANSKRIT -> "नेपाली: ${phrase.nepali} | English: ${phrase.english}"
                                    AppLanguage.NEPALI -> phrase.nepali
                                    AppLanguage.ENGLISH -> phrase.english
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        AudioSpeakButton(
                            textToSpeak = phrase.sanskrit,
                            onSpeak = { viewModel.speak(it) }
                        )
                    }
                }
            }
        }
    }
}
