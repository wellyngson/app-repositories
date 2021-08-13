package com.bootcampinter.apprepositories.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bootcampinter.apprepositories.data.model.UserGit
import com.bootcampinter.apprepositories.databinding.ItemRepoBinding
import com.bumptech.glide.Glide

class RepoListAdapter : ListAdapter<UserGit, RepoListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserGit) {
            binding.tvName.text = item.name
            binding.tvDescription.text = item.description
            binding.tvLanguage.text = item.language
            binding.cpChipStar.text = item.stargazersCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.avatarURL).into(binding.ivOwner)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<UserGit>() {
    override fun areItemsTheSame(oldItem: UserGit, newItem: UserGit) = oldItem == newItem
    override fun areContentsTheSame(oldItem: UserGit, newItem: UserGit) = oldItem.id == newItem.id
}
