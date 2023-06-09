package com.shinjaehun.mvvmnewsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    @SerializedName("author")
    var author : String?,
    @SerializedName("content")
    var content : String?,
    @SerializedName("title")
    var title : String?,
    @SerializedName("description")
    var description : String?,
    @SerializedName("publishedAt")
    var publishedAt : String?,
    @SerializedName("source")
    var source : Source?,
    @SerializedName("url")
    var url : String?,
    @SerializedName("urlToImage")
    var urlToImage : String?,
) : java.io.Serializable
