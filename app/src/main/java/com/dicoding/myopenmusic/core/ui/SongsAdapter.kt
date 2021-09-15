package com.dicoding.myopenmusic.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myopenmusic.R
import com.dicoding.myopenmusic.core.domain.model.Songs
import com.dicoding.myopenmusic.databinding.ItemListSongBinding

class SongsAdapter : RecyclerView.Adapter<SongsAdapter.ListViewHolder>() {

    private var listData = ArrayList<Songs>()
    var onItemClick: ((Songs) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Songs>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsAdapter.ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_song, parent, false))

    override fun onBindViewHolder(holder: SongsAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListSongBinding.bind(itemView)
        fun bind(data: Songs) {
            with(binding) {
                tvSongTitle.text = data.title
                tvSongPerformer.text = data.performer
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[bindingAdapterPosition])
            }
        }
    }
}