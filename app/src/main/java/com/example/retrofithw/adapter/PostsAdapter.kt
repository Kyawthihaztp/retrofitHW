package com.example.retrofithw.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofithw.R
import com.example.retrofithw.model.Posts
import kotlinx.android.synthetic.main.item_posts.view.*

class PostsAdapter(var post: List<Posts>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>(){
    inner class PostViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        fun bind(post:Posts){

            itemView.title.text=post.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_posts,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return post.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(post[position])
    }
}