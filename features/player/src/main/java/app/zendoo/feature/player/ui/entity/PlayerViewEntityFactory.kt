package app.zendoo.feature.player.ui.entity

import app.zendoo.domain.model.Session
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerViewEntityFactory
@Inject
constructor() {

    //region PlayerViewEntityFactory

    fun create(session: Session?): PlayerViewEntity {
        return PlayerViewEntity(1)
    }

    //endregion

    //region PlayerViewEntity

    //endregion
}
