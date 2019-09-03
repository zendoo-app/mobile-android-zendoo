package app.zendoo.feature.dashboard.home

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel
@Inject constructor() : ViewModel() {
    fun asd() {
        Log.e("asd", this.toString())
    }
}
