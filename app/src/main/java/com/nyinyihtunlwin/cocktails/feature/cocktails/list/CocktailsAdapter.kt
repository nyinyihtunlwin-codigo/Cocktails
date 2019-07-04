package com.nyinyihtunlwin.cocktails.feature.cocktails.list

import android.content.Context
import android.view.ViewGroup
import com.nyinyihtunlwin.cocktails.R
import com.nyinyihtunlwin.cocktails.feature.base.BaseRecyclerAdapter
import com.nyinyihtunlwin.cocktails.feature.base.BaseViewHolder
import com.nyinyihtunlwin.domain.model.cocktail.Cocktail

class CocktailsAdapter(context: Context, var cocktailDelegate: CocktailDelegate) :
    BaseRecyclerAdapter<CocktailViewHolder, Cocktail>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Cocktail> {
        val view = mLayoutInflator.inflate(R.layout.view_item_cocktail, parent, false)
        return CocktailViewHolder(view, cocktailDelegate)
    }
}