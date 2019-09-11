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
@Inject constructor(
    private val homeViewEntityFactory: HomeViewEntityFactory,
    sessionRepository: SessionRepository
) : ViewModel() {

    private val currentSession: LiveData<Session?> = sessionRepository.currentSession
    internal val viewEntity: LiveData<HomeViewEntity> =
        Transformations.map(currentSession, ::mapHomeViewEntity)
    internal val state: LiveData<HomeViewEntityEnum> =
        Transformations.map(currentSession, ::mapHomeViewEntityEnum)

    private fun mapHomeViewEntity(currentSession: Session?) =
        homeViewEntityFactory.create(currentSession)

    private fun mapHomeViewEntityEnum(currentSession: Session?) = currentSession.toEnum()
}
