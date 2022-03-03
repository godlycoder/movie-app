package id.movie.features.movie.playnow

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import id.movie.common.core.BaseFragment
import id.movie.common.core.PagingLoadStateAdapter
import id.movie.features.movie.MoviesAdapter
import id.movie.features.movie.databinding.FragmentPlayNowBinding
import kotlinx.coroutines.launch


/**
 * Created by Muhamad Ribani on 08/02/22.
 */


@AndroidEntryPoint
class PlayNowFragment : BaseFragment<FragmentPlayNowBinding>() {

    private val viewModel : PlayNowViewModel by viewModels()

    private val adapter = MoviesAdapter().apply {
        withLoadStateHeaderAndFooter(PagingLoadStateAdapter(this), PagingLoadStateAdapter(this))
    }


    override fun FragmentPlayNowBinding.initialBinding() {
        rvList.adapter = adapter

        displayList()
    }

    private fun displayList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMoviesPlayNow().observe(this@PlayNowFragment) {
                adapter.submitData(lifecycle, it)
            }
        }
    }

}