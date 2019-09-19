package app.zendoo.feature.player.ui.entity

import app.zendoo.domain.model.Session
import app.zendoo.feature.player.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerViewEntityFactory
@Inject
constructor() {

    //region PlayerViewEntityFactory

    fun create(session: Session?): PlayerViewEntity {
        return PlayerViewEntity(
            leftImage = R.drawable.ic_bottom_left,
            middleImage = R.drawable.ic_bottom_middle,
            rightImage = R.drawable.ic_bottom_right
        )
    }

    //endregion

    //region PlayerViewEntity

    //endregion
}
