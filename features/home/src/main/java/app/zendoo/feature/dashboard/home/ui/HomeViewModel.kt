package app.zendoo.feature.dashboard.home.ui

import androidx.lifecycle.ViewModel
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntity
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntityEnum
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntityFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel
@Inject constructor(private val homeViewEntityFactory: HomeViewEntityFactory) : ViewModel() {
    fun asd(): HomeViewEntity {
        return homeViewEntityFactory.get(HomeViewEntityEnum.START)
    }
}
