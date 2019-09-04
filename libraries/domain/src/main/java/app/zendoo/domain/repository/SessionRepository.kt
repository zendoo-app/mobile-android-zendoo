package app.zendoo.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.zendoo.domain.model.Session
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionRepository
@Inject constructor() {

    val currentSession: LiveData<Session?> = asd()
    val sessionList: LiveData<List<Session>?> = asd2()

    private fun asd(): LiveData<Session?> {
        val liveData = MutableLiveData<Session?>()
        liveData.value = null
        return liveData
    }

    private fun asd2(): LiveData<List<Session>?> {
        val liveData = MutableLiveData<List<Session>>()
        liveData.value = arrayListOf()
        return liveData
    }
}


