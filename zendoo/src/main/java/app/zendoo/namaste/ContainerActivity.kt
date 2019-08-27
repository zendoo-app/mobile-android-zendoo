package app.zendoo.namaste

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.zendoo.zendoo.R

class ContainerActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        val asd = Asd(this)
        asd.asd(1, 2)
        asd.bsd()
    }
}
