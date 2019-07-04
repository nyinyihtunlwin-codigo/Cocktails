package com.nyinyihtunlwin.cocktails.feature.cocktails.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.nyinyihtunlwin.cocktails.R
import com.nyinyihtunlwin.cocktails.feature.base.mvi.MviXFragment
import com.nyinyihtunlwin.domain.model.cocktail.Cocktail
import com.nyinyihtunlwin.domain.viewstate.CocktailsListViewState
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_cocktails.*
import kotlinx.android.synthetic.main.fragment_cocktails.view.*
import org.koin.android.ext.android.inject

private const val ARG_TYPE = "type"

class CocktailsFragment : MviXFragment<CocktailsView, CocktailsPresenter>(), CocktailDelegate, CocktailsView {

    private val mPresenter: CocktailsPresenter by inject()
    private var type: String? = null
    private lateinit var mAdapter: CocktailsAdapter
    private val cocktailsRelay: PublishSubject<String> = PublishSubject.create()

    companion object {
        @JvmStatic
        fun newInstance(type: String) =
            CocktailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TYPE, type)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        cocktailsRelay.onNext(type!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            type = it.getString(ARG_TYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cocktails, container, false)
        view.rvCocktails.setEmptyView(view.vpEmpty)
        mAdapter = CocktailsAdapter(context!!, this)
        view.rvCocktails.adapter = mAdapter
        view.rvCocktails.setHasFixedSize(true)
        view.rvCocktails.layoutManager = GridLayoutManager(
            context, 2
        )

        view.swipeRefresh.setOnRefreshListener {
            cocktailsRelay.onNext(type!!)
        }

        return view
    }

    override fun render(viewState: CocktailsListViewState) {
        when (viewState) {
            is CocktailsListViewState.Progress -> {
                swipeRefresh.isRefreshing = true
            }
            is CocktailsListViewState.Cocktails -> {
                swipeRefresh.isRefreshing = false
                mAdapter.setNewData(viewState.cocktails as MutableList<Cocktail>)
            }
            is CocktailsListViewState.Error -> {
                swipeRefresh.isRefreshing = false
                Toast.makeText(context, viewState.t.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun cocktailsIntent(): Observable<String> {
        return cocktailsRelay
    }

    override fun onTapCocktail(cocktail: Cocktail) {
        Toast.makeText(context, cocktail.strDrink, Toast.LENGTH_SHORT).show()
    }

    override fun createPresenter(): CocktailsPresenter {
        return mPresenter
    }


}