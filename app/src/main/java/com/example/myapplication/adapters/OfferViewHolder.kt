package com.example.myapplication.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.interaction.OffersListItemClickListener
import com.example.myapplication.model.Offer

class OfferViewHolder (view: View, val clickListener: OffersListItemClickListener): RecyclerView.ViewHolder(view) {
    var titleRef: TextView
    var descriptionRef: TextView
    var pictureRef: ImageView
    var priceRef: TextView
    var viewRef: View

    init {
        titleRef = view.findViewById(R.id.offerTitleTextView)
        descriptionRef = view.findViewById(R.id.offerDescriptionTextView)
        pictureRef = view.findViewById(R.id.offerPictureImageView)
        priceRef = view.findViewById(R.id.offerPriceTextView)
        viewRef = view
    }

    fun bindData(data: Offer) {
        titleRef.text = data.title
        descriptionRef.text = data.description
        pictureRef.setImageResource(data.picture)
        priceRef.text = data.price.toString() + " " + data.currency

        viewRef.setOnClickListener {
            clickListener.onClick(data.id)
        }
    }
}