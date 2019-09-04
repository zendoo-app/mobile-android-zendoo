package app.zendoo.feature.dashboard.home.ui.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.zendoo.feature.dashboard.home.R
import dagger.android.support.DaggerFragment
import io.supercharge.shimmerlayout.ShimmerLayout

class LoadingFragment : DaggerFragment() {

    //region DaggerFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_loading, container, false)

        setupShimmerLayout(view)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    //endregion

    //region ShimmerLayout

    private fun setupShimmerLayout(view: View) {
        val shimmerLayout = view.findViewById(R.id.shimmerlayout_loading) as ShimmerLayout
        shimmerLayout.startShimmerAnimation()
    }

    //endregion
}
