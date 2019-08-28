package app.zendoo.namaste.util

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import timber.log.Timber

class TimberInitializerTest {

    //region TimberInitializer

    private lateinit var timberInitializer: TimberInitializer

    //endregion

    //region mock

    @Mock
    lateinit var buildConfig: BuildConfigProvider
    lateinit var timberDebugTree: TimberDebugTree
    lateinit var seed: Timber.DebugTree

    //endregion

    //region TimberInitializerTest

    @Before
    fun setUp() {

        timberInitializer = TimberInitializer(buildConfig, timberDebugTree)
    }

    @Test
    fun `init !DEBUG`() {
        `when`(buildConfig.isDebug()).thenReturn(false)

        timberInitializer.init()

        verify(buildConfig).isDebug()
    }

    @Test
    fun `init DEBUG`() {
    }

    //endregion
}
