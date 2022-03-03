package id.movie.features.movie.popular

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import id.movie.common.core.BaseFragment
import id.movie.common.core.PagingLoadStateAdapter
import id.movie.features.movie.MoviesAdapter
import id.movie.features.movie.databinding.FragmentPopularBinding
import kotlinx.coroutines.launch


/**
 * Created by Muhamad Ribani on 08/02/22.
 */


@AndroidEntryPoint
class PopularFragment : BaseFragment<FragmentPopularBinding>() {

    private val viewModel: PopularViewModel by viewModels()

    private val adapter = MoviesAdapter().apply {
        withLoadStateHeaderAndFooter(PagingLoadStateAdapter(this), PagingLoadStateAdapter(this))
    }

    override fun FragmentPopularBinding.initialBinding() {
        rvList.adapter = adapter

        displayList()
    }

    private fun displayList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMoviesPopular().observe(this@PopularFragment) {
                adapter.submitData(lifecycle, it)
            }
        }
    }
}