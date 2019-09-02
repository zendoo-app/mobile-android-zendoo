package app.zendoo.namaste.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import app.zendoo.feature.dashboard.home.HomeViewModel
import app.zendoo.namaste.Asd
import app.zendoo.namaste.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ContainerActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //endregion

    //region lateinit

    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ZendooTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val asd = Asd(this)
        asd.asd(1, 2)
        asd.bsd()
    }
}
