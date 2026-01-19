package com.example.webviewtugas // Pastikan ini sesuai dengan namespace di build.gradle.kts Anda

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
// HAPUS: import androidx.compose.ui.layout.layout // Baris ini sudah dihapus

class MainActivity : AppCompatActivity() {

    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Error R akan hilang jika XML dan namespace benar

        myWebView = findViewById(R.id.myWebView) // Error R akan hilang jika XML dan namespace benar
        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl("https://ecampus.utmj.ac.id/utmj/login")

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (myWebView.canGoBack()) {
                    myWebView.goBack()
                } else {
                    if (isEnabled) {
                        isEnabled = false
                        // Sebaiknya panggil super.onBackPressed() atau onBackPressedDispatcher.onBackPressed()
                        // Jika Anda ingin perilaku default (menutup activity)
                        onBackPressedDispatcher.onBackPressed() // Atau super.onBackPressed()
                    }
                }
            }
        })
    }
}
