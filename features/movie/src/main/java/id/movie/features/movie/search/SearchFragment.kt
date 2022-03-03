package id.movie.features.movie.search

import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import id.movie.common.core.BaseFragment
import id.movie.common.core.PagingLoadStateAdapter
import id.movie.features.movie.MoviesAdapter
import id.movie.features.movie.databinding.FragmentSearchBinding
import kotlinx.coroutines.launch


/**
 * Created by Muhamad Ribani on 08/02/22.
 */


@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val viewModel : SearchViewModel by viewModels()

    private val adapter = MoviesAdapter().apply {
        withLoadStateHeaderAndFooter(PagingLoadStateAdapter(this), PagingLoadStateAdapter(this))
    }

    private var query: String = ""

    override fun FragmentSearchBinding.initialBinding() {
        rvList.adapter = adapter
        etSearch.addTextChangedListener {
            query = it.toString()
            search()
        }
    }

    private fun search() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.search(query).observe(this@SearchFragment) {
                adapter.submitData(lifecycle, it)
            }
        }
    }

}