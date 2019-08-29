package app.zendoo.namaste.ui

import android.os.Bundle
import app.zendoo.namaste.Asd
import app.zendoo.namaste.R
import dagger.android.support.DaggerAppCompatActivity

class ContainerActivity : DaggerAppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ZendooTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val asd = Asd(this)
        asd.asd(1, 2)
        asd.bsd()
    }
}
