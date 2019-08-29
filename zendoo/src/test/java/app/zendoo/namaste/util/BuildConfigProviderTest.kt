package app.zendoo.namaste.util

import app.zendoo.namaste.BuildConfig
import io.mockk.MockKAnnotations.init
import io.mockk.confirmVerified
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class BuildConfigProviderTest {

    // @MockK

    @InjectMockKs
    private lateinit var buildConfigProvider: BuildConfigProvider

    //endregion

    //region UnitTest

    @Before
    fun setUp() {
        init(this)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    //endregion

    //region BuildConfigProviderTest

    @Test
    fun isDebug() {
        val expected = BuildConfig.DEBUG
        val actual = buildConfigProvider.isDebug()

        assertEquals(actual = actual, expected = expected)

        confirmVerified()
    }

    //endregion
}
