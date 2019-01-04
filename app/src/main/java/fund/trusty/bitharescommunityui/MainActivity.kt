package fund.trusty.bitharescommunityui

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdvancedWebView.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        advancedWebView.setListener(this,this)
        val url:String? = intent.getStringExtra("url")
        if(url!=null) advancedWebView.loadUrl(url)
        else advancedWebView.loadUrl(siteURL)
    }

    override fun onDownloadRequested(
        url: String?,
        suggestedFilename: String?,
        mimeType: String?,
        contentLength: Long,
        contentDisposition: String?,
        userAgent: String?
    ) {
    }

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
    }

    override fun onExternalPageRequest(url: String?) {
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
    }

    override fun onPageFinished(url: String?) {
        advancedWebView.visibility = View.VISIBLE
        splashScreenImage.visibility = View.INVISIBLE
    }

    override fun onBackPressed() {
        if(!advancedWebView.onBackPressed())
            return
        super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        advancedWebView.onResume();
    }

    override fun onPause() {
        advancedWebView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        advancedWebView.onDestroy()
        super.onDestroy()
    }

}
