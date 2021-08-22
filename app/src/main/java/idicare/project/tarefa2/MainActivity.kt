package idicare.project.tarefa2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webView: WebView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient()

        webView.loadUrl("http://192.168.1.64/")

        // this will enable the javascript settings
        webView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)

        val popup = LayoutInflater.from(this).inflate(R.layout.dialogmorada,null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(popup)


        webView.addJavascriptInterface(object:Any() {
            @JavascriptInterface // For API 17+
            fun performClick(string:String) {
                val mAlertDialog = mBuilder.show()
                val textMorada = popup.findViewById<TextView>(R.id.textMorada)
                textMorada.text = string
            }
        }, "ok")
    }


}

