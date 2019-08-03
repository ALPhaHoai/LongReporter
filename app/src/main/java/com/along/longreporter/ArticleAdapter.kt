package com.along.longreporter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Created by Long
 * Date: 8/3/2019
 * Time: 10:21 AM
 */

enum class ArticleType(val type: Int) {
    MAIN(1),
    NORMAL(2)
}

class ArticleAdapter(val articleList: ArrayList<ArticleModel>, val context: Context) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun getItemViewType(position: Int): Int =
        if (position == 0) ArticleType.MAIN.type else ArticleType.NORMAL.type


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAdapter.ArticleViewHolder {
        return when (viewType) {
            ArticleType.MAIN.type -> ArticleViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.article_main_item,
                    parent,
                    false
                )
            )
            else -> ArticleViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.article_item,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: ArticleAdapter.ArticleViewHolder, position: Int) {
        holder.bind(articleList[position], context)
    }

    inner class ArticleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var mTitle: TextView? = null
        var mPhoto: ImageView? = null
        var mDescription: TextView? = null
        var mDateTime: TextView? = null
        var mComments: TextView? = null
        var mShare: ImageView? = null
        var mBookMark: ImageView? = null

        init {
            mTitle = view.findViewById(R.id.article_title)
            mPhoto = view.findViewById(R.id.article_photo)
            mDescription = view.findViewById(R.id.article_description)
            mDateTime = view.findViewById(R.id.article_datetime)
            mComments = view.findViewById(R.id.article_comment)
            mShare = view.findViewById(R.id.article_share)
            mBookMark = view.findViewById(R.id.article_bookmark)

            mShare?.setOnClickListener {
                Toast.makeText(context, "Share button cliced", Toast.LENGTH_LONG).show()
            }
            mBookMark?.setOnClickListener {
                Toast.makeText(context, "Bookmark button cliced", Toast.LENGTH_LONG).show()
            }
        }

        fun bind(anime: ArticleModel, context: Context) {
            mTitle?.text = anime.title
            mPhoto?.let {
                Glide
                    .with(context)
                    .load(anime.image)
                    .centerCrop()
                    .into(it)
            }
            mDescription?.text = anime.description
            mDateTime?.text = "" + anime.datetime + "h ago"
            if (anime.comments > 0) {
                mComments?.text = "" + anime.comments + " comments"
            } else {
                mComments?.visibility = View.GONE
            }
        }
    }
}