package app.zendoo.namaste.util

import io.mockk.MockKAnnotations.init
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import timber.log.Timber

class TimberInitializerTest {

    //@MockK

    @MockK
    private val buildConfig: BuildConfigProvider = mockk()

    @MockK
    private val seed: Timber.DebugTree = mockk()

    @MockK
    private val timberDebugTree: TimberDebugTree = mockk()

    @InjectMockKs
    private lateinit var timberInitializer: TimberInitializer

    //endregion

    //region UnitTest

    @Before
    fun setUp() {
        mockkStatic(Timber::class)
        init(this)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    //endregion

    //region TimberInitializerTest

    @Test
    fun `init !DEBUG`() {
        every { buildConfig.isDebug() } returns false

        timberInitializer.init()

        verify { buildConfig.isDebug() }

        confirmVerified(buildConfig)
    }

    @Test
    fun `init DEBUG`() {
        every { buildConfig.isDebug() } returns true
        every { timberDebugTree.tree } returns seed

        timberInitializer.init()

        verify { buildConfig.isDebug(); Timber.plant(any()) }

        confirmVerified(buildConfig, timberDebugTree.tree)
    }

    //endregion
}
