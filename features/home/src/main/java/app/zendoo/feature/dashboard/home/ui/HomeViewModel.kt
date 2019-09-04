package app.zendoo.feature.dashboard.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntity
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntityEnum
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntityFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel
@Inject constructor(
    private val homeViewEntityFactory: HomeViewEntityFactory,
    private val sessionRepository: SessionRepository
) : ViewModel() {

    val state: LiveData<HomeViewEntityEnum> =

    fun asd(): LiveData<HomeViewEntity> {
        val liveData = MutableLiveData<HomeViewEntity>()
        liveData.value = homeViewEntityFactory.create(HomeViewEntityEnum.START)
        return liveData
    }
}
