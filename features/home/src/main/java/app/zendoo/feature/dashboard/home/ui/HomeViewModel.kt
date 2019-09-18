package app.zendoo.feature.dashboard.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import app.zendoo.domain.model.Session
import app.zendoo.domain.repository.SessionRepository
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntity
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntityEnum
import app.zendoo.feature.dashboard.home.ui.entity.HomeViewEntityFactory
import app.zendoo.feature.dashboard.home.ui.entity.toEnum
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel
@Inject
constructor(
    private val homeViewEntityFactory: HomeViewEntityFactory,
    sessionRepository: SessionRepository
) : ViewModel() {

    //region private

    private val currentSession: LiveData<Session?> by lazy {
        sessionRepository.currentSession
    }

    //endregion

    //region HomeViewEntity

    internal val viewEntity: LiveData<HomeViewEntity> by lazy {
        Transformations.map(currentSession, ::mapHomeViewEntity)
    }

    //endregion

    //region HomeViewEntityEnum

    internal val state: LiveData<HomeViewEntityEnum> by lazy {
        Transformations.map(currentSession, ::mapHomeViewEntityEnum)
    }

    private fun mapHomeViewEntityEnum(currentSession: Session?) = currentSession.toEnum()

    //endregion

    //region HomeViewEntityFactory

    private fun mapHomeViewEntity(currentSession: Session?) =
        homeViewEntityFactory.create(currentSession)

    //endregion
}
