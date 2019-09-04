package app.zendoo.feature.dashboard.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import app.zendoo.domain.model.Session
import app.zendoo.domain.repository.SessionRepository
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

    internal val state: MediatorLiveData<Pair<HomeViewEntityEnum, List<Session>?>> =
        MediatorLiveData()
    internal val entity = Transformations.map(state, ::mapHomeViewEntity)

    init {
        val currentSession: LiveData<Session?> = sessionRepository.currentSession
        val sessionList: LiveData<List<Session>?> = sessionRepository.sessionList
        state.addSource(currentSession) {
            state.value = combineLatestData(currentSession.value, sessionList.value)
        }

        state.addSource(sessionList) {
            state.value = combineLatestData(currentSession.value, sessionList.value)
        }
    }

    private fun combineLatestData(
        currentSession: Session?,
        sessionList: List<Session>?
    ): Pair<HomeViewEntityEnum, List<Session>?> {
        val enum: HomeViewEntityEnum = when (currentSession) {
            null -> sessionList?.let { HomeViewEntityEnum.STARTING }
                ?: run { HomeViewEntityEnum.LOADING }
            else -> HomeViewEntityEnum.WORKING
        }
        return Pair(enum, sessionList)
    }

    private fun mapHomeViewEntity(asd: Pair<HomeViewEntityEnum, List<Session>?>) =
        homeViewEntityFactory.create(asd.first)
}
