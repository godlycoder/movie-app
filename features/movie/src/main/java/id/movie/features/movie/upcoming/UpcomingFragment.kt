package id.movie.features.movie.upcoming

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import id.movie.common.core.BaseFragment
import id.movie.common.core.PagingLoadStateAdapter
import id.movie.domain.usecase.GetMoviesUpcomingUseCase
import id.movie.features.movie.MoviesAdapter
import id.movie.features.movie.databinding.FragmentPopularBinding
import id.movie.features.movie.databinding.FragmentUpcomingBinding
import id.movie.features.movie.popular.PopularViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Muhamad Ribani on 08/02/22.
 */


@AndroidEntryPoint
class UpcomingFragment : BaseFragment<FragmentUpcomingBinding>() {

    private val viewModel: UpcomingViewModel by viewModels()

    private val adapter = MoviesAdapter().apply {
        withLoadStateHeaderAndFooter(PagingLoadStateAdapter(this), PagingLoadStateAdapter(this))
    }

    override fun FragmentUpcomingBinding.initialBinding() {
        rvList.adapter = adapter

        displayList()
    }

    private fun displayList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMoviesUpcoming().observe(this@UpcomingFragment) {
                adapter.submitData(lifecycle, it)
            }
        }
    }

}