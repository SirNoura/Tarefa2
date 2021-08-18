package idicare.project.tarefa2

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView: WebView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://www.google.pt/maps")

        // this will enable the javascript settings
        webView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)

        val btnLocal = findViewById<Button>(R.id.btnlocal)

        btnLocal.setOnClickListener {
            val popup = LayoutInflater.from(this).inflate(R.layout.dialogmorada,null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(popup)
            val mAlertDialog = mBuilder.show()
            val textMorada = popup.findViewById<TextView>(R.id.textMorada)
            textMorada.text = "Morada: "
        }

    }
}

