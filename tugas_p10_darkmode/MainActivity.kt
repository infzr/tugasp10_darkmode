package com.example.tugas_p10_darkmode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugas_p10_darkmode.ui.theme.Tugas_utsTheme

class MainActivity : ComponentActivity() {
    private lateinit var prefsManager: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        prefsManager = PrefsManager(this)

        setContent {
            var isDarkMode by remember { mutableStateOf(prefsManager.isDarkMode()) }

            Tugas_utsTheme(darkTheme = isDarkMode) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .clickable {
                                // Mengubah tema saat teks/layar disentuh (mirip demo materi)
                                isDarkMode = !isDarkMode
                                prefsManager.setDarkMode(isDarkMode)
                            },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Halo, infazar!",
                            fontSize = 28.sp,
                            style = MaterialTheme.typography.headlineMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = if (isDarkMode) "🌙 Tema Gelap" else "☀️ Tema Terang",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val savedTheme = prefsManager.isDarkMode()
    }
}