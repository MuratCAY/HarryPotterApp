package com.muratcay.harrypotterapp.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muratcay.harrypotterapp.R
import com.muratcay.harrypotterapp.data.model.CharacterModel
import com.muratcay.harrypotterapp.ui.overview.adapter.CharactersAdapter
import com.muratcay.harrypotterapp.util.Status.*

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CharacterModel>?) {
    val adapter = recyclerView.adapter as CharactersAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(imageView.context).load(imageUrl).apply(
            RequestOptions.placeholderOf(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
        ).into(imageView)
    }
}

@BindingAdapter("status")
fun bindStatus(statusImage: ImageView, status: Status?) {
    when (status) {
        LOADING -> {
            statusImage.visibility = View.VISIBLE
            statusImage.setImageResource(R.drawable.loading_animation)
        }
        DONE -> statusImage.visibility = View.GONE
        else -> {
            statusImage.visibility = View.VISIBLE
            statusImage.setImageResource(R.drawable.ic_connection_error)
        }
    }
}