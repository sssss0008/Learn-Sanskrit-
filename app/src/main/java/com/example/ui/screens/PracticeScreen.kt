package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AppLanguage
import com.example.data.model.TrilingualText
import com.example.ui.components.AudioSpeakButton
import com.example.ui.theme.SanskritGold
import com.example.ui.theme.SanskritGreen
import com.example.ui.viewmodel.PracticeMode
import com.example.ui.viewmodel.SanskritViewModel

@Composable
fun PracticeScreen(
    viewModel: SanskritViewModel,
    modifier: Modifier = Modifier
) {
    val currentLang by viewModel.currentLanguage.collectAsState()
    val practiceMode by viewModel.practiceMode.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        // Practice Mode Switcher
        TabRow(
            selectedTabIndex = if (practiceMode == PracticeMode.FLASHCARDS) 0 else 1,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
        ) {
            Tab(
                selected = practiceMode == PracticeMode.FLASHCARDS,
                onClick = { viewModel.selectPracticeMode(PracticeMode.FLASHCARDS) },
                text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Style, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = TrilingualText("स्मरण-पट्टिका (Cards)", "स्मरण-कार्ड (Cards)", "Flashcards").get(currentLang),
                            fontWeight = if (practiceMode == PracticeMode.FLASHCARDS) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            )
            Tab(
                selected = practiceMode == PracticeMode.QUIZ,
                onClick = { viewModel.selectPracticeMode(PracticeMode.QUIZ) },
                text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Quiz, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = TrilingualText("प्रश्नोत्तरी (Quiz)", "प्रश्नोत्तरी (Quiz)", "Interactive Quiz").get(currentLang),
                            fontWeight = if (practiceMode == PracticeMode.QUIZ) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedContent(
            targetState = practiceMode,
            label = "practice_mode_switch"
        ) { mode ->
            when (mode) {
                PracticeMode.FLASHCARDS -> FlashcardView(viewModel, currentLang)
                PracticeMode.QUIZ -> QuizView(viewModel, currentLang)
            }
        }
    }
}

// -------------------------------------------------------------
// FLASHCARDS VIEW
// -------------------------------------------------------------
@Composable
fun FlashcardView(
    viewModel: SanskritViewModel,
    lang: AppLanguage
) {
    val currentIndex by viewModel.flashcardIndex.collectAsState()
    val isFlipped by viewModel.isCardFlipped.collectAsState()
    val cards = viewModel.flashcards
    val currentCard = cards[currentIndex]

    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing),
        label = "card_rotation"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 96.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${TrilingualText("पट्टिका", "कार्ड", "Card").get(lang)} ${currentIndex + 1} / ${cards.size}",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = TrilingualText("परावर्तनाय स्पृशतु (Tap to flip)", "उल्टाउन थिच्नुहोस्", "Tap card to flip").get(lang),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = { (currentIndex + 1).toFloat() / cards.size },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp)),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isFlipped) MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f)
                else MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12f * density
                }
                .clickable { viewModel.flipCard() }
                .border(
                    2.dp,
                    if (isFlipped) MaterialTheme.colorScheme.secondary
                    else MaterialTheme.colorScheme.primaryContainer,
                    RoundedCornerShape(24.dp)
                )
                .testTag("flashcard_item")
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                if (rotation <= 90f) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Text(
                                text = currentCard.category,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        Text(
                            text = currentCard.sanskritFront,
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "[ ${currentCard.iastFront} ]",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Text(
                            text = currentCard.grammaticalHint.get(lang),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                } else {
                    Column(
                        modifier = Modifier.graphicsLayer { rotationY = 180f },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.secondaryContainer
                        ) {
                            Text(
                                text = TrilingualText("अर्थः (Meaning)", "नेपाली तथा अङ्ग्रेजी अर्थ", "Translations").get(lang),
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "नेपाली: ${currentCard.nepaliBack}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "English: ${currentCard.englishBack}",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = currentCard.grammaticalHint.get(lang),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilledTonalIconButton(
                onClick = { viewModel.prevFlashcard() },
                enabled = currentIndex > 0,
                modifier = Modifier.size(52.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous")
            }

            FilledTonalIconButton(
                onClick = { viewModel.speak(currentCard.sanskritFront) },
                modifier = Modifier.size(52.dp)
            ) {
                Icon(Icons.Default.VolumeUp, contentDescription = "Audio")
            }

            Button(
                onClick = { viewModel.markFlashcardMastered() },
                colors = ButtonDefaults.buttonColors(containerColor = SanskritGreen),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.height(52.dp)
            ) {
                Icon(Icons.Default.CheckCircle, contentDescription = null)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = TrilingualText("कण्ठस्थम् (+१५)", "याद भयो (+१५)", "Mastered (+15)").get(lang),
                    fontWeight = FontWeight.Bold
                )
            }

            FilledTonalIconButton(
                onClick = { viewModel.nextFlashcard() },
                modifier = Modifier.size(52.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next")
            }
        }
    }
}

// -------------------------------------------------------------
// QUIZ VIEW
// -------------------------------------------------------------
@Composable
fun QuizView(
    viewModel: SanskritViewModel,
    lang: AppLanguage
) {
    val quizIndex by viewModel.quizIndex.collectAsState()
    val selectedAnswerIndex by viewModel.selectedAnswerIndex.collectAsState()
    val isAnswerSubmitted by viewModel.isAnswerSubmitted.collectAsState()
    val score by viewModel.quizScore.collectAsState()

    val questions = viewModel.quizQuestions
    val currentQ = questions[quizIndex]

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${TrilingualText("प्रश्नः", "प्रश्न", "Question").get(lang)} ${quizIndex + 1} / ${questions.size}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = SanskritGold.copy(alpha = 0.2f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Icon(Icons.Default.Stars, contentDescription = null, tint = SanskritGold, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${TrilingualText("अङ्काः", "अङ्क", "Score").get(lang)}: $score",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        item {
            LinearProgressIndicator(
                progress = { (quizIndex + 1).toFloat() / questions.size },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    ) {
                        Text(
                            text = currentQ.category,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = currentQ.question.get(lang),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 24.sp
                    )
                }
            }
        }

        items(currentQ.options.size) { index ->
            val option = currentQ.options[index]
            val isSelected = selectedAnswerIndex == index
            val isCorrect = index == currentQ.correctIndex

            val backgroundColor = when {
                !isAnswerSubmitted -> if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                isCorrect -> SanskritGreen.copy(alpha = 0.2f)
                isSelected && !isCorrect -> MaterialTheme.colorScheme.errorContainer
                else -> MaterialTheme.colorScheme.surface
            }

            val borderColor = when {
                !isAnswerSubmitted -> if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                isCorrect -> SanskritGreen
                isSelected && !isCorrect -> MaterialTheme.colorScheme.error
                else -> MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
            }

            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = backgroundColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.5.dp, borderColor, RoundedCornerShape(14.dp))
                    .clickable(enabled = !isAnswerSubmitted) {
                        viewModel.selectQuizAnswer(index)
                    }
                    .testTag("quiz_option_$index")
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${'A' + index}",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Text(
                        text = option.get(lang),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )

                    if (isAnswerSubmitted) {
                        if (isCorrect) {
                            Icon(Icons.Default.CheckCircle, contentDescription = "Correct", tint = SanskritGreen)
                        } else if (isSelected) {
                            Icon(Icons.Default.Cancel, contentDescription = "Incorrect", tint = MaterialTheme.colorScheme.error)
                        }
                    }
                }
            }
        }

        item {
            if (isAnswerSubmitted) {
                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Info, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = TrilingualText("स्पष्टीकरणम् (Explanation)", "स्पष्टीकरण", "Grammar Explanation").get(lang),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = currentQ.explanation.get(lang),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { viewModel.nextQuizQuestion() },
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .testTag("quiz_next_button")
                ) {
                    Text(
                        text = if (quizIndex < questions.size - 1)
                            TrilingualText("अग्रिमः प्रश्नः ->", "अर्को प्रश्न ->", "Next Question ->").get(lang)
                        else
                            TrilingualText("समाप्तम् / पुनः आरम्भः", "सम्पन्न / फेरि सुरु गर्नुहोस्", "Finish & Restart").get(lang),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            } else {
                Button(
                    onClick = { viewModel.submitQuizAnswer() },
                    enabled = selectedAnswerIndex != null,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .testTag("quiz_submit_button")
                ) {
                    Text(
                        text = TrilingualText("उत्तरं परीक्षताम् (Submit)", "उत्तर जाँच गर्नुहोस्", "Check Answer").get(lang),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
