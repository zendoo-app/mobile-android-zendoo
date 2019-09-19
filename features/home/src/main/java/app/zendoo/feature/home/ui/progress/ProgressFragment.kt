package app.zendoo.feature.home.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import app.zendoo.feature.home.R
import app.zendoo.feature.home.databinding.FragmentProgressBinding
import app.zendoo.feature.home.ui.HomeViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProgressFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //endregion

    //region var

    private var binding: FragmentProgressBinding? = null

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
            R.layout.fragment_progress,
            container,
            false
        )

        initBinding()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        destroyBinding()
    }

    //endregion

    //region binding

    private fun initBinding() {
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.viewModel = viewModel.viewEntity
    }

    private fun destroyBinding() {
        binding = null
    }

    //endregion
}
