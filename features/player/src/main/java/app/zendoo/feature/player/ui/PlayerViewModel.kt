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

    //region private

    private var id: MutableLiveData<Int?> = MutableLiveData(-1)

    //endregion

    //region lazy

    private val session: LiveData<Session?> by lazy {
        Transformations.map(id, ::getSession)
    }
    internal val viewEntity: LiveData<PlayerViewEntity> by lazy {
        Transformations.map(
            session,
            ::mapPlayerViewEntity
        )
    }

    //endregion

    //region id

    fun setId(id: Int?) {
        this.id.apply { postValue(id) }
    }

    //endregion

    //region PlayerViewEntityFactory

    private fun mapPlayerViewEntity(session: Session?) = playerViewEntityFactory.create(session)

    //endregion

    //region SessionRepository

    private fun getSession(id: Int?): Session? {
        return sessionRepository.getSessionInfo(id)
    }

    //endregion
}
