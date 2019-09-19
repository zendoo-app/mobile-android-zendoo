package app.zendoo.feature.home.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import app.zendoo.feature.home.R
import app.zendoo.feature.home.databinding.FragmentStartBinding
import app.zendoo.feature.home.ui.HomeViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StartFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //endregion

    //region lateinit

    private lateinit var binding: FragmentStartBinding

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
            R.layout.fragment_start,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel.viewEntity

        return binding.root
    }

    //endregion
}