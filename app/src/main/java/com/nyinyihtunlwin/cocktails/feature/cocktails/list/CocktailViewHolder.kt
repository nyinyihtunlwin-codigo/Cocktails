package com.nyinyihtunlwin.cocktails.feature.cocktails.list

import android.view.View
import com.bumptech.glide.Glide
import com.nyinyihtunlwin.cocktails.feature.base.BaseViewHolder
import com.nyinyihtunlwin.domain.model.cocktail.Cocktail
import kotlinx.android.synthetic.main.view_item_cocktail.view.*

class CocktailViewHolder(
    itemView: View,
    var cocktailDelegate: CocktailDelegate
) : BaseViewHolder<Cocktail>(itemView) {

    override fun setData(data: Cocktail) {
        mData = data
        itemView.tvCocktail.text = mData?.strDrink
        Glide.with(itemView.context)
            .load(mData?.strDrinkThumb)
            .into(itemView.ivCocktail)
    }

    override fun onClick(v: View?) {
        cocktailDelegate.onTapCocktail(mData!!)
    }
}