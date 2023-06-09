package com.shinjaehun.mvvmnewsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.util.Util
import com.shinjaehun.mvvmnewsapp.R
import com.shinjaehun.mvvmnewsapp.databinding.ItemArticleBinding
import com.shinjaehun.mvvmnewsapp.databinding.ItemSavedNewsBinding
import com.shinjaehun.mvvmnewsapp.model.Article

class SavedNewsAdapter : RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder>() {

    private val diffUtilCallBack = object : DiffUtil.ItemCallback<Article>() {
        // 왜 여기선 companion object로 선언 안 하는거야???
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }
    }
    inner class SavedNewsViewHolder(var view: ItemSavedNewsBinding) : RecyclerView.ViewHolder(view.root)

    val differ = AsyncListDiffer(this, diffUtilCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemSavedNewsBinding>(inflater, R.layout.item_saved_news, parent, false)
        return SavedNewsViewHolder(view)
//        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedNewsViewHolder, position: Int) {
        val article = differ.currentList[position]

        holder.view.article = article

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                article.let {  article ->
                    it(article)
                }
            }
        }

        holder.view.ivShare.setOnClickListener {
            onShareNewsClick?.let {
                article.let {  itl ->
                    it(itl)
                }
            }
        }
    }

    override fun getItemCount() = differ.currentList.size

    private var onItemClickListener: ((Article) -> Unit)? = null
    private var onShareNewsClick: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
    fun onShareClickListener(listener: ((Article) -> Unit)) {
        onShareNewsClick = listener
    }

}