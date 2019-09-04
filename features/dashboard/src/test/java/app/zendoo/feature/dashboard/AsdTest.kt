package app.zendoo.feature.dashboard

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations.initMocks

class AsdTest {
    lateinit var asd: Asd

    @Before
    internal fun setUp() {
        initMocks(this)
    }

    @Test
    fun testAsd() {
        asd = Asd()

        val result = asd.asd(0, 0)
        Assert.assertEquals(0, result.toLong())
    }
}
