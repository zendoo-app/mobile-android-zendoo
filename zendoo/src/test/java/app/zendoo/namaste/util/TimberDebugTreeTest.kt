package app.zendoo.namaste.util

import io.mockk.MockKAnnotations.init
import io.mockk.confirmVerified
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertNotNull

class TimberDebugTreeTest {

    //@MockK

    @InjectMockKs
    private lateinit var timberDebugTree: TimberDebugTree

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

    //region TimberDebugTreeTest

    @Test
    fun getSeed() {
        val actual = timberDebugTree.tree

        assertNotNull(actual = actual)

        confirmVerified()
    }

    @Test
    fun createStackElementTag() {
        val actual = timberDebugTree.tree

        actual.e(String())

        confirmVerified()
    }

    //endregion
}
