package app.zendoo.namaste.util

import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString

class TimberDebugTreeTest {

    //region TimberDebugTree

    private lateinit var timberDebugTree: TimberDebugTree

    //endregion

    //region TimberDebugTreeTest

    @Before
    fun setUp() {
        timberDebugTree = TimberDebugTree()
    }

    @Test
    fun getSeed() {
        val actual = timberDebugTree.tree

        assertNotNull(actual)
    }

    @Test
    fun createStackElementTag() {
        val actual = timberDebugTree.tree

        actual.e(anyString())
    }

    //endregion
}
