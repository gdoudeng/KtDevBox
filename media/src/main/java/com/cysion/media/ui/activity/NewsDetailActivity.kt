package com.cysion.media.ui.activity

import android.webkit.WebView
import android.webkit.WebViewClient
import com.cysion.ktbox.base.BaseActivity
import com.cysion.ktbox.utils.whiteTextTheme
import com.cysion.media.R
import com.cysion.other.color
import com.cysion.uibox.bar.TopBar
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_news_detail

    private val title: String by lazy {
        intent.getBundleExtra("key").getString("title")
    }
    private val linkurl: String by lazy {
        intent.getBundleExtra("key").getString("link")
    }

    override fun initView() {
        whiteTextTheme(color(R.color.colorAccent))
        topbar.apply {
            setTitle(title)
            setOnTopBarClickListener { obj, pos ->
                if (pos == TopBar.Pos.LEFT) {
                    finish()
                }
            }
        }
        webview.settings.javaScriptEnabled = true
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: String?): Boolean {
                view?.loadUrl(request)
                return true
            }
        }
        webview.loadUrl(linkurl)
    }
    override fun closeMvp() {

    }
}