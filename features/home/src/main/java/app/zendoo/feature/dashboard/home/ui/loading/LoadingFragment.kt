package app.zendoo.feature.dashboard.home.ui.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import app.zendoo.feature.dashboard.home.R
import app.zendoo.feature.dashboard.home.databinding.FragmentLoadingBinding
import app.zendoo.feature.dashboard.home.ui.HomeViewModel
import dagger.android.support.DaggerFragment
import io.supercharge.shimmerlayout.ShimmerLayout
import javax.inject.Inject

class LoadingFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //endregion

    //region lateinit

    private lateinit var binding: FragmentLoadingBinding

    //endregion

    //region val

    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    //endregion

    //region DaggerFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_loading,
            container,
            false
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel.asd()

        setupShimmerLayout(binding.root)

        return binding.root
    }

    //endregion

    //region ShimmerLayout

    private fun setupShimmerLayout(view: View) {
        val shimmerLayout = view.findViewById(R.id.shimmerlayout_loading) as ShimmerLayout
        shimmerLayout.startShimmerAnimation()
    }

    //endregion
}
