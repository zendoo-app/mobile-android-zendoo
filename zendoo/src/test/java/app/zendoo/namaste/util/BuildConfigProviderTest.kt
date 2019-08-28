package app.zendoo.namaste.util

import app.zendoo.namaste.BuildConfig
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BuildConfigProviderTest {

    //region BuildConfigProvider

    private lateinit var buildConfigProvider: BuildConfigProvider

    //endregion

    //region BuildConfigProviderTest

    @Before
    fun setUp() {
        buildConfigProvider = BuildConfigProvider()
    }

    @Test
    fun DEBUG() {
        val expected = BuildConfig.DEBUG
        val actual = buildConfigProvider.isDebug()

        assertEquals(actual, expected)
    }

    //endregion
}
