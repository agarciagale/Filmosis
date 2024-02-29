package com.example.filmosis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmosis.R
import com.example.filmosis.adapters.GenresCardViewsAdapter
import com.example.filmosis.data.access.tmdb.MoviesAccess
import com.example.filmosis.utilities.tmdb.TmdbData

class ExploreFragment : Fragment() {
    private lateinit var rootView: View

    private val moviesAccess = MoviesAccess()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_explore, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        val searchView: SearchView = rootView.findViewById(R.id.explore_searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isNotEmpty()) {
                    performSearch(query)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        initGenreCardViews()
    }

    private fun performSearch(query: String) {
        // TODO
        // LLAMAR A FRAGMENTO DE MOVIESLIST CON LA QUERY COMO ARGUMENTO EN MAPA...
    }

    private fun initGenreCardViews() {
        val genresRecyclerView: RecyclerView = rootView.findViewById(R.id.explore_genresRecyclerView)

        genresRecyclerView.adapter = GenresCardViewsAdapter(TmdbData.movieGenresIds)

        genresRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3, LinearLayoutManager.HORIZONTAL, false)
    }

}