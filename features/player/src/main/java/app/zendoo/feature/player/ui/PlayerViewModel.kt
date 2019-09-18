package app.zendoo.feature.player.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import app.zendoo.domain.model.Session
import app.zendoo.domain.repository.SessionRepository
import app.zendoo.feature.player.ui.entity.PlayerViewEntity
import app.zendoo.feature.player.ui.entity.PlayerViewEntityFactory
import javax.inject.Inject

class PlayerViewModel
@Inject
constructor(
    private val playerViewEntityFactory: PlayerViewEntityFactory,
    private val sessionRepository: SessionRepository
) : ViewModel() {

    //region var

    internal var id: Int = -1

    //endregion

    //region private

    private val session: MutableLiveData<Session?> = getSession()

    //endregion

    //region PlayerViewEntity

    internal val viewEntity: LiveData<PlayerViewEntity> by lazy {
        Transformations.map(
            session,
            ::mapPlayerViewEntity
        )
    }

    //endregion

    //region PlayerViewEntityFactory

    private fun getSession() = sessionRepository.getSession(id) as MutableLiveData

    //endregion

    //region PlayerViewEntityFactory

    private fun mapPlayerViewEntity(session: Session?) = playerViewEntityFactory.create(session)

    //endregion
}
