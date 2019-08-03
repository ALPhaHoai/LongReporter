package com.along.longreporter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Long
 * Date: 8/3/2019
 * Time: 8:44 AM
 */
class HomeFragment : Fragment() {
    private var v: View? = null
    private var progressBar: ProgressBar? = null
    private var recycleView: RecyclerView? = null
    public val articleList: ArrayList<ArticleModel> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.home_fragment, container, false)
        recycleView = v?.findViewById(R.id.recycleView)
        progressBar = v?.findViewById(R.id.progressBar)
        recycleView?.layoutManager = LinearLayoutManager(this.context)
        recycleView?.adapter = ArticleAdapter(articleList, this.context!!)
        loadData()
        return v
    }

    fun loadData() {
        progressBar?.visibility = View.VISIBLE
        CrawlData() {
            articleList.addAll(it)
            recycleView?.adapter?.notifyDataSetChanged()
            progressBar?.visibility = View.GONE
        }.execute()
    }
}