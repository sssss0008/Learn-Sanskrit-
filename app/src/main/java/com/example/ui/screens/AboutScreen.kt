package com.example.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AppLanguage
import com.example.data.model.TrilingualText
import com.example.ui.components.AudioSpeakButton
import com.example.ui.components.LanguageSelectorPill
import com.example.ui.theme.SanskritGold
import com.example.ui.theme.SanskritGreen
import com.example.ui.theme.SanskritOrange
import com.example.ui.viewmodel.SanskritViewModel

@Composable
fun AboutScreen(
    viewModel: SanskritViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val currentLang by viewModel.currentLanguage.collectAsState()
    var speechRate by remember { mutableFloatStateOf(viewModel.ttsManager.speechRate) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // App Hero Card
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f), RoundedCornerShape(24.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                                    MaterialTheme.colorScheme.surface
                                )
                            )
                        )
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // Sacred Om Emblem
                        Box(
                            modifier = Modifier
                                .size(72.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "ॐ",
                                style = MaterialTheme.typography.displaySmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "संस्कृतम् (Sanskritam)",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = TrilingualText(
                                "देववाणी-शिक्षणस्य अमृत-सोपानम्",
                                "संस्कृत भाषा सिक्ने सर्वोत्कृष्ट माध्यम",
                                "The Complete Sanskrit Learning Sanctuary"
                            ).get(currentLang),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.secondaryContainer
                        ) {
                            Text(
                                text = "Version 1.0 • Trilingual Edition",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }

        // About the App Philosophy & Details
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Info, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = TrilingualText("एप-विवरणम् (About App)", "एप विवरण तथा उद्देश्य", "About the Application").get(currentLang),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = TrilingualText(
                            "संस्कृतम् एपः संस्कृत-भाषायाः पुनरुत्थानाय, वेदानां रक्षणाय, छात्राणां च सरलोपयोगाय निर्मितम्। अत्र संस्कृत-नेपाली-आङ्ग्लभाषासु सम्पूर्णं शिक्षणं प्राप्यते। वर्णमाला, पाणिनि-व्याकरणम्, शब्दरूपाणि, धातुरूपाणि, सन्धिः, कारकाणि, सुभाषितानि, शब्दकोशः चात्र सुलभाः सन्ति।",
                            "संस्कृतम् एप संस्कृत भाषाको संरक्षण, संवर्द्धन र सम्पूर्ण नेपाली तथा अन्तर्राष्ट्रिय जिज्ञासुहरूलाई सरल ढङ्गले सिकाउने उद्देश्यले निर्माण गरिएको हो। यसमा संस्कृत, नेपाली र अङ्ग्रेजी तीनै भाषामा समान रूपले व्याकरण, वर्णमाला, शब्दरूप, धातुरूप, सन्धि, कारक, र दैनिक कुराकानीको अभ्यास उपलब्ध छ।",
                            "Sanskritam is a comprehensive language learning sanctuary designed to make the sublime world of Sanskrit accessible to modern learners worldwide. Built with seamless trilingual support across Sanskrit, Nepali, and English, it encompasses phonetic anatomy, Paninian grammar, noun declensions, verb conjugations, spoken phrases, and cultural wisdom."
                        ).get(currentLang),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 22.sp
                    )
                }
            }
        }

        // Language & Speech Rate Settings
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = TrilingualText("भाषा एवं उच्चारण-व्यवस्था", "भाषा र आवाज सेटिङ", "Language & Voice Settings").get(currentLang),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = TrilingualText("एप-भाषा (Active Language):", "एपको भाषा:", "Active Language:").get(currentLang),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        LanguageSelectorPill(
                            currentLanguage = currentLang,
                            onLanguageChange = { viewModel.setLanguage(it) }
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "${TrilingualText("उच्चारण-गतिः (Speech Rate):", "आवाजको गति:", "Speech Rate:").get(currentLang)} ${"%.2f".format(speechRate)}x",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Slider(
                        value = speechRate,
                        onValueChange = {
                            speechRate = it
                            viewModel.updateSpeechRate(it)
                        },
                        valueRange = 0.6f..1.3f,
                        steps = 7,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        OutlinedButton(
                            onClick = { viewModel.speak("ॐ नमो भगवते वासुदेवाय। शुभम् अस्तु!") }
                        ) {
                            Icon(Icons.Default.VolumeUp, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(TrilingualText("परीक्षणं कुरु (Test Voice)", "ध्वनि परीक्षण", "Test Voice").get(currentLang))
                        }
                    }
                }
            }
        }

        // Developer & Direct Feedback Section
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(18.dp))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.ContactSupport, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = TrilingualText("सम्पर्कः एवं प्रतिक्रिया (Feedback)", "सम्पर्क तथा प्रतिक्रिया (Feedback)", "Contact & Developer Feedback").get(currentLang),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = TrilingualText(
                            "भवतां सूचनं प्रतिक्रिया च अस्माकं कृते बहुमूल्या अस्ति। कृपया निम्नलिखितेषु सम्पर्केषु स्वाभिप्रायं प्रेषयन्तु:",
                            "तपाईंको सल्लाह, सुझाव र प्रतिक्रिया हाम्रा लागि अत्यन्तै महत्त्वपूर्ण छ। कृपया निम्न माध्यमहरूबाट हामीलाई सिधै सम्पर्क गर्नुहोस्:",
                            "Your valuable suggestions and feedback help us elevate Sanskrit education. Connect directly with the developer below:"
                        ).get(currentLang),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // 1. Email Button
                    FeedbackActionTile(
                        icon = Icons.Default.Email,
                        title = "Email (ईमेल)",
                        value = "awiskaracharya@gmail.com",
                        buttonText = TrilingualText("सन्देशं प्रेषयतु", "ईमेल पठाउनुहोस्", "Send Email").get(currentLang),
                        color = MaterialTheme.colorScheme.primary,
                        onClick = {
                            openEmail(context, "awiskaracharya@gmail.com")
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // 2. WhatsApp Button
                    FeedbackActionTile(
                        icon = Icons.Default.Chat,
                        title = "WhatsApp (ह्वाट्सएप)",
                        value = "+977 9827106244",
                        buttonText = TrilingualText("वार्तालापं कुरु", "ह्वाट्सएपमा कुरा गर्नुहोस्", "Open WhatsApp").get(currentLang),
                        color = SanskritGreen,
                        onClick = {
                            openWhatsApp(context, "+9779827106244")
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // 3. LinkedIn Button
                    FeedbackActionTile(
                        icon = Icons.Default.Link,
                        title = "LinkedIn (लिंक्डइन)",
                        value = "linkedin.com/in/awiskaracharya",
                        buttonText = TrilingualText("सम्पर्कं योजयतु", "प्रोफाइल हेर्नुहोस्", "View LinkedIn").get(currentLang),
                        color = MaterialTheme.colorScheme.tertiary,
                        onClick = {
                            openUrl(context, "https://www.linkedin.com/in/awiskaracharya/")
                        }
                    )
                }
            }
        }

        // Sacred Closing Blessing
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "ॐ असतो मा सद्गमय।\nतमसो मा ज्योतिर्गमय।\nमृत्योर्माऽमृतं गमय॥",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        lineHeight = 24.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "ॐ शान्तिः शान्तिः शान्तिः॥",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    AudioSpeakButton(
                        textToSpeak = "ॐ असतो मा सद्गमय। तमसो मा ज्योतिर्गमय। मृत्योर्मा अमृतं गमय। ॐ शान्तिः शान्तिः शान्तिः॥",
                        onSpeak = { viewModel.speak(it) }
                    )
                }
            }
        }
    }
}

@Composable
fun FeedbackActionTile(
    icon: ImageVector,
    title: String,
    value: String,
    buttonText: String,
    color: Color,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            FilledTonalButton(
                onClick = onClick,
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                modifier = Modifier.height(34.dp)
            ) {
                Text(text = buttonText, style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

// Helpers for intents
private fun openEmail(context: Context, email: String) {
    try {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
            putExtra(Intent.EXTRA_SUBJECT, "Sanskritam App Feedback")
            putExtra(Intent.EXTRA_TEXT, "Namaste! Here is my feedback for the Sanskritam application:\n\n")
        }
        context.startActivity(Intent.createChooser(intent, "Send Email"))
    } catch (e: Exception) {
        Toast.makeText(context, "Email: $email", Toast.LENGTH_LONG).show()
    }
}

private fun openWhatsApp(context: Context, phone: String) {
    try {
        val cleanPhone = phone.replace("+", "").replace(" ", "").replace("-", "")
        val url = "https://wa.me/$cleanPhone?text=${Uri.encode("Namaste! Regarding the Sanskritam app:")}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "WhatsApp: $phone", Toast.LENGTH_LONG).show()
    }
}

private fun openUrl(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, url, Toast.LENGTH_LONG).show()
    }
}
