package app.zendoo.feature.dashboard.home.ui.progressing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import app.zendoo.feature.dashboard.home.R
import app.zendoo.feature.dashboard.home.databinding.FragmentStartingBinding
import app.zendoo.feature.dashboard.home.ui.HomeViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ProgressingFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //endregion

    //region lateinit

    private lateinit var binding: FragmentStartingBinding

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
            R.layout.fragment_starting,
            container,
            false
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel.viewEntity

        return binding.root
    }

    //endregion
}
