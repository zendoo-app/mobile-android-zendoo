package app.zendoo.namaste.util

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class ApplicationInitializerTest {

    //region ApplicationInitializer

    private lateinit var initializer: ApplicationInitializer

    //endregion

    //region mock

    @Mock
    lateinit var timber: TimberInitializer

    //endregion

    //region ApplicationInitializerTest

    @Before
    fun setUp() {
        initMocks(this)
        initializer = ApplicationInitializer(
            timber = timber
        )
    }

    @Test
    fun init() {
        doAnswer { }.`when`(timber).init()

        initializer.init()

        verify(timber).init()
    }

    //endregion
}
