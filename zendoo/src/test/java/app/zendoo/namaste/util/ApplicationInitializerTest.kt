package app.zendoo.namaste.util

import io.mockk.MockKAnnotations
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class ApplicationInitializerTest {

    // @MockK

    @MockK
    private lateinit var timber: TimberInitializer

    @InjectMockKs
    private lateinit var initializer: ApplicationInitializer

    //endregion

    //region UnitTest

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    //endregion

    //region ApplicationInitializerTest

    @Test
    fun init() {
        every { timber.init() } answers {}

        initializer.init()

        verify { timber.init() }

        confirmVerified(timber)
    }

    //endregion
}
