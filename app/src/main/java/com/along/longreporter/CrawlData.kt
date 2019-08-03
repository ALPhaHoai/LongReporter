package com.along.longreporter

import android.os.AsyncTask
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Created by Long
 * Date: 8/3/2019
 * Time: 12:23 PM
 */
class CrawlData(val callback: (ArrayList<ArticleModel>) -> Unit) : AsyncTask<Void, Void, String>() {
    val articleList = ArrayList<ArticleModel>()
    override fun doInBackground(vararg params: Void?): String? {
        val doc = Jsoup.connect("https://e.vnexpress.net/").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36").get()
        articleList.addAll(parseArticleModel(doc))
        return null
    }

    fun parseArticleModel(doc: Document): ArrayList<ArticleModel> {
        val recentlyUpdateArticleList = doc.select(".item_list")
        val articleList: ArrayList<ArticleModel> = ArrayList()
        for (article in recentlyUpdateArticleList) {
            val title = article.selectFirst("h4.title_news_site > a:first-child")?.text() ?: continue
            val image = article.selectFirst("a.thumb_news_site > img.vne_lazy_image")?.attr("data-original") ?: continue
            val link = article.selectFirst("h4.title_news_site > a:first-child")?.attr("href") ?: continue
            val description = article.selectFirst(".lead_news_site")?.text() ?: continue
            var time = 5
            var comments = 21
            articleList.add(ArticleModel(title, image, description, time, comments))
        }
        return articleList
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        callback(articleList)
    }
}