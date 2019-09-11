package app.zendoo.feature.player.util

import androidx.core.os.bundleOf

interface PlayerEnterNavigation {

    companion object {
        private const val SESSION_ID = "session_id"

        fun Int.toPlayerBundle() = PlayerBundle(bundleOf(SESSION_ID to this))

        fun PlayerBundle.toBundle() = this.bundle
    }

    fun enterPlayer(bundle: PlayerBundle)
}
