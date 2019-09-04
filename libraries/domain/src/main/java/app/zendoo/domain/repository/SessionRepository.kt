package app.zendoo.domain.repository

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.zendoo.domain.model.Session
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionRepository
@Inject constructor() {

    val currentSession: LiveData<Session?> = asd()
    val sessionList: MutableLiveData<List<Session>?> = asd2()

    private fun asd(): LiveData<Session?> {
        val liveData = MutableLiveData<Session?>()
        liveData.value = null
        return liveData
    }

    private fun asd2(): MutableLiveData<List<Session>?> {
        val liveData = MutableLiveData<List<Session>?>()
        liveData.value = null
        asd3()
        return liveData
    }

    private fun asd3() {
        Handler().postDelayed(
            {
                sessionList.value = arrayListOf()
            }, 2000
        )
    }
}
