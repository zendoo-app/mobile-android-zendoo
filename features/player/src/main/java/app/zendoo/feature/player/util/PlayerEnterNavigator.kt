package app.zendoo.feature.player.util

import android.os.Bundle
import androidx.core.os.bundleOf

interface PlayerEnterNavigator {

    companion object {
        private const val SESSION_ID = "session_id"

        fun Int.toPlayerBundle() = PlayerBundle(this)

        fun PlayerBundle.toBundle() = bundleOf(SESSION_ID to this.id)

        fun Bundle.getSessionId() = this.getInt(SESSION_ID)
    }

    fun enterPlayer(bundle: PlayerBundle)
}
