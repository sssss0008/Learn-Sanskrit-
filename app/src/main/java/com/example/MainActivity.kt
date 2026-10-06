package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AppLanguage
import com.example.data.model.TrilingualText
import com.example.ui.components.LanguageSelectorPill
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearnScreen
import com.example.ui.screens.PracticeScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.SanskritGreen
import com.example.ui.theme.SanskritOrange
import com.example.ui.viewmodel.NavigationTab
import com.example.ui.viewmodel.SanskritViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: SanskritViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainAppScreen(viewModel = viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen(viewModel: SanskritViewModel) {
    val context = LocalContext.current
    val currentTab by viewModel.currentTab.collectAsState()
    val currentLang by viewModel.currentLanguage.collectAsState()
    val streak by viewModel.streak.collectAsState()
    val xp by viewModel.xp.collectAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(320.dp)
                    .fillMaxHeight(),
                drawerContainerColor = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // Drawer Header Banner
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.primary,
                                        MaterialTheme.colorScheme.primaryContainer
                                    )
                                )
                            )
                            .padding(horizontal = 20.dp, vertical = 28.dp)
                    ) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.surface),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "ॐ",
                                    style = MaterialTheme.typography.headlineMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "संस्कृतम् (Sanskritam)",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimary
                            )

                            Text(
                                text = TrilingualText(
                                    "देववाणी-संस्कृति-इतिहासश्च",
                                    "संस्कृत भाषा, संस्कृति तथा इतिहास",
                                    "Sacred Sanskrit Language & Heritage"
                                ).get(currentLang),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // 4 Main Navigation Tab Items in Drawer
                    Text(
                        text = TrilingualText("विभाग-चयनम्", "मुख्य खण्डहरू", "Main Sections").get(currentLang),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)
                    )

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = null) },
                        label = { Text(NavigationTab.HOME.title.get(currentLang), fontWeight = FontWeight.SemiBold) },
                        selected = currentTab == NavigationTab.HOME,
                        onClick = {
                            viewModel.selectTab(NavigationTab.HOME)
                            coroutineScope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
                    )

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Default.AutoStories, contentDescription = null) },
                        label = { Text(NavigationTab.LEARN.title.get(currentLang), fontWeight = FontWeight.SemiBold) },
                        selected = currentTab == NavigationTab.LEARN,
                        onClick = {
                            viewModel.selectTab(NavigationTab.LEARN)
                            coroutineScope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
                    )

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Default.Quiz, contentDescription = null) },
                        label = { Text(NavigationTab.PRACTICE.title.get(currentLang), fontWeight = FontWeight.SemiBold) },
                        selected = currentTab == NavigationTab.PRACTICE,
                        onClick = {
                            viewModel.selectTab(NavigationTab.PRACTICE)
                            coroutineScope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
                    )

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Default.Info, contentDescription = null) },
                        label = { Text(NavigationTab.ABOUT.title.get(currentLang), fontWeight = FontWeight.SemiBold) },
                        selected = currentTab == NavigationTab.ABOUT,
                        onClick = {
                            viewModel.selectTab(NavigationTab.ABOUT)
                            coroutineScope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp, horizontal = 20.dp))

                    // Cultural Heritage Highlights in Drawer
                    Text(
                        text = TrilingualText("संस्कृतिः एवं इतिहासः", "संस्कृति र इतिहास", "Culture & History").get(currentLang),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
                    )

                    DrawerCulturalTile(
                        title = TrilingualText("वैदिक-परम्परा", "वैदिक परम्परा", "Vedic Heritage").get(currentLang),
                        desc = TrilingualText("४ वेदाः, मन्त्राः ऋषयश्च", "चार वेद र ऋषिका उपदेश", "Four Vedas & Oral Traditions").get(currentLang),
                        icon = Icons.Default.MenuBook,
                        onClick = {
                            viewModel.selectTab(NavigationTab.HOME)
                            coroutineScope.launch { drawerState.close() }
                        }
                    )

                    DrawerCulturalTile(
                        title = TrilingualText("नेपाले संस्कृतम्", "नेपालमा संस्कृत सम्पदा", "Sanskrit in Nepal").get(currentLang),
                        desc = TrilingualText("लिच्छवि-शिलालेखाः तालपत्राणि च", "लिच्छवि अभिलेख र ताडपत्र", "Inscriptions & Ancient Manuscripts").get(currentLang),
                        icon = Icons.Default.TempleHindu,
                        onClick = {
                            viewModel.selectTab(NavigationTab.HOME)
                            coroutineScope.launch { drawerState.close() }
                        }
                    )

                    DrawerCulturalTile(
                        title = TrilingualText("महर्षिः पाणिनिः", "महर्षि पाणिनि र व्याकरण", "Panini's Linguistics").get(currentLang),
                        desc = TrilingualText("अष्टाध्यायी - ४००० सूत्राणि", "४,००० सूत्र र कम्प्युटर विज्ञान", "Algorithmic Grammar & Coding").get(currentLang),
                        icon = Icons.Default.Code,
                        onClick = {
                            viewModel.selectTab(NavigationTab.HOME)
                            coroutineScope.launch { drawerState.close() }
                        }
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp, horizontal = 20.dp))

                    // Direct Feedback Links in Drawer
                    Text(
                        text = TrilingualText("सम्पर्कः एवं प्रतिक्रिया", "सम्पर्क तथा प्रतिक्रिया (Feedback)", "Feedback & Contact").get(currentLang),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
                    )

                    DrawerContactTile(
                        icon = Icons.Default.Email,
                        title = "Email",
                        subtitle = "awiskaracharya@gmail.com",
                        onClick = { launchEmail(context, "awiskaracharya@gmail.com") }
                    )

                    DrawerContactTile(
                        icon = Icons.Default.Chat,
                        title = "WhatsApp",
                        subtitle = "+977 9827106244",
                        onClick = { launchWhatsApp(context, "+9779827106244") }
                    )

                    DrawerContactTile(
                        icon = Icons.Default.Link,
                        title = "LinkedIn",
                        subtitle = "awiskaracharya",
                        onClick = { launchUrl(context, "https://www.linkedin.com/in/awiskaracharya/") }
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "संस्कृतम्",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { coroutineScope.launch { drawerState.open() } },
                            modifier = Modifier
                                .minimumInteractiveComponentSize()
                                .testTag("drawer_menu_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Open Drawer Menu",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    },
                    actions = {
                        LanguageSelectorPill(
                            currentLanguage = currentLang,
                            onLanguageChange = { viewModel.setLanguage(it) },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 6.dp
                ) {
                    // 1. Home
                    NavigationBarItem(
                        selected = currentTab == NavigationTab.HOME,
                        onClick = { viewModel.selectTab(NavigationTab.HOME) },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text(NavigationTab.HOME.title.get(currentLang)) },
                        modifier = Modifier.testTag("nav_tab_home")
                    )

                    // 2. Learn
                    NavigationBarItem(
                        selected = currentTab == NavigationTab.LEARN,
                        onClick = { viewModel.selectTab(NavigationTab.LEARN) },
                        icon = { Icon(Icons.Default.AutoStories, contentDescription = "Learn") },
                        label = { Text(NavigationTab.LEARN.title.get(currentLang)) },
                        modifier = Modifier.testTag("nav_tab_learn")
                    )

                    // 3. Practice
                    NavigationBarItem(
                        selected = currentTab == NavigationTab.PRACTICE,
                        onClick = { viewModel.selectTab(NavigationTab.PRACTICE) },
                        icon = { Icon(Icons.Default.Quiz, contentDescription = "Practice") },
                        label = { Text(NavigationTab.PRACTICE.title.get(currentLang)) },
                        modifier = Modifier.testTag("nav_tab_practice")
                    )

                    // 4. About the App
                    NavigationBarItem(
                        selected = currentTab == NavigationTab.ABOUT,
                        onClick = { viewModel.selectTab(NavigationTab.ABOUT) },
                        icon = { Icon(Icons.Default.Info, contentDescription = "About App") },
                        label = { Text(NavigationTab.ABOUT.title.get(currentLang)) },
                        modifier = Modifier.testTag("nav_tab_about")
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AnimatedContent(
                    targetState = currentTab,
                    transitionSpec = {
                        fadeIn() togetherWith fadeOut()
                    },
                    label = "main_tab_switch"
                ) { tab ->
                    when (tab) {
                        NavigationTab.HOME -> HomeScreen(viewModel)
                        NavigationTab.LEARN -> LearnScreen(viewModel)
                        NavigationTab.PRACTICE -> PracticeScreen(viewModel)
                        NavigationTab.ABOUT -> AboutScreen(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun DrawerCulturalTile(
    title: String,
    desc: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
            Text(text = desc, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
fun DrawerContactTile(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(14.dp))
        Column {
            Text(text = title, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
            Text(text = subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

private fun launchEmail(context: Context, email: String) {
    try {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
            putExtra(Intent.EXTRA_SUBJECT, "Sanskritam App Feedback")
        }
        context.startActivity(Intent.createChooser(intent, "Send Email"))
    } catch (e: Exception) {
        Toast.makeText(context, email, Toast.LENGTH_SHORT).show()
    }
}

private fun launchWhatsApp(context: Context, phone: String) {
    try {
        val clean = phone.replace("+", "").replace(" ", "")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/$clean"))
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, phone, Toast.LENGTH_SHORT).show()
    }
}

private fun launchUrl(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, url, Toast.LENGTH_SHORT).show()
    }
}
