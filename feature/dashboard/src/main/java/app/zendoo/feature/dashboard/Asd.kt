package app.zendoo.feature.dashboard

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics

class Asd(context: Context) {
    private val mFirebaseAnalytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(context)

    fun asd(i: Int, i1: Int): Int {
        return i + i1
    }

    fun bsd() {
        mFirebaseAnalytics.logEvent("test", null)
    }
}
