package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.interaction.OffersListItemClickListener
import com.example.myapplication.model.Offer

class OffersAdapter(
    val context: Context,
    val itemsData: List<Offer>,
    val clickListener: OffersListItemClickListener): RecyclerView.Adapter<OfferViewHolder>() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val viewHolder = inflater.inflate(R.layout.single_offers_list_element_template,
            parent, false)
        return OfferViewHolder(viewHolder, clickListener)
    }

    override fun getItemCount(): Int {
        return itemsData.size
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bindData(itemsData[position])
    }

    fun getOfferById(offerId: Int): Offer? { // ? inseamna ca poate returna null
        for (offer in itemsData) {
            if(offer.id == offerId) {
                return offer
            }
        }
        return null
    }

}