package com.shinjaehun.mvvmnewsapp.repository.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.shinjaehun.mvvmnewsapp.model.Article
import kotlinx.coroutines.CoroutineScope

class ArticleDataSourceFactory(private val scope: CoroutineScope) : DataSource.Factory<Int, Article>() {
    val articleDataSourceLiveData = MutableLiveData<ArticleDataSource>()

    override fun create(): DataSource<Int, Article> {
        val newArticleDataSource = ArticleDataSource(scope)
        articleDataSourceLiveData.postValue(newArticleDataSource)
        return newArticleDataSource
    }

}