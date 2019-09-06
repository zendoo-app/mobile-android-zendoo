package app.zendoo.feature.player.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import app.zendoo.feature.dashboard.home.databinding.FragmentLoadingBinding
import app.zendoo.feature.player.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PlayerFragment : DaggerFragment() {

    //region @Inject

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //endregion

    //region lateinit

    private lateinit var binding: FragmentLoadingBinding

    //endregion

    //region val

    private val viewModel: PlayerViewModel by viewModels {
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
            R.layout.fragment_player,
            container,
            false
        )

        binding.lifecycleOwner = this
        //  binding.viewModel = viewModel.viewEntity

        return binding.root
    }

    //endregion
}
