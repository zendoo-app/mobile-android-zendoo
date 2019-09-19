package app.zendoo.domain.repository

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import app.zendoo.domain.model.Session
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionRepository
@Inject constructor() {

    val currentSession: MutableLiveData<Session?> = getSession()

    private fun getSession(): MutableLiveData<Session?> {
        val liveData = MutableLiveData<Session?>()
        liveData.value = null
        toStarting()
        return liveData
    }

    private fun toStarting() {
        Handler().postDelayed(
            {
                currentSession.value = Session(1, 0, 10)
            }, 3000
        )
    }

    private fun toProgressing() {
        currentSession.value = Session(1, 1, 10)
    }

    fun getSessionInfo(id: Int?): Session? {
        toProgressing()
        return Session(1, 1, 10)
    }
}
