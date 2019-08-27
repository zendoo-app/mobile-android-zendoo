package app.zendoo.zendoo

import android.content.Context
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

class AsdTest {
    lateinit var asd: Asd

    @Mock
    lateinit var context: Context

    @Before
    internal fun setUp() {
        initMocks(this)
    }

    @Test(expected = NullPointerException::class)
    fun testAsd() {
        asd = Asd(context)

        val result = asd.asd(0, 0)
        Assert.assertEquals(0, result.toLong())
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme