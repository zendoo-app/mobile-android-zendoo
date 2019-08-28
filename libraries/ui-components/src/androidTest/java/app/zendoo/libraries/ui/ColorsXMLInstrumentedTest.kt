package app.zendoo.libraries.ui

import android.content.res.Resources
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ColorsXMLInstrumentedTest {

    private lateinit var res: Resources

    @Before
    fun setup() {
        res = getInstrumentation().targetContext.resources
    }

    @Test
    fun colorPrimary() {
        val actual = res.getColor(R.color.colorPrimary, null)
        val expected = -12304167

        assertEquals(expected, actual)
    }

    @Test
    fun colorPrimaryDark() {
        val actual = res.getColor(R.color.colorPrimaryDark, null)
        val expected = -13027914

        assertEquals(expected, actual)
    }

    @Test
    fun colorAccent() {
        val actual = res.getColor(R.color.colorAccent, null)
        val expected = -15758422

        assertEquals(expected, actual)
    }

    @Test
    fun colorError() {
        val actual = res.getColor(R.color.colorError, null)
        val expected = -695710

        assertEquals(expected, actual)
    }

    @Test
    fun colorConfirmation() {
        val actual = res.getColor(R.color.colorConfirmation, null)
        val expected = -12285185

        assertEquals(expected, actual)
    }

    @Test
    fun colorVeryNavy() {
        val actual = res.getColor(R.color.colorVeryNavy, null)
        val expected = -16771530

        assertEquals(expected, actual)
    }

    @Test
    fun colorMuchGranite() {
        val actual = res.getColor(R.color.colorMuchGranite, null)
        val expected = -10325886

        assertEquals(expected, actual)
    }

    @Test
    fun colorDusty() {
        val actual = res.getColor(R.color.colorDusty, null)
        val expected = -10325886

        assertEquals(expected, actual)
    }

    @Test
    fun colorBorder() {
        val actual = res.getColor(R.color.colorBorder, null)
        val expected = -1644308

        assertEquals(expected, actual)
    }

    @Test
    fun colorAlmostWhite() {
        val actual = res.getColor(R.color.colorAlmostWhite, null)
        val expected = -328964

        assertEquals(expected, actual)
    }

    @Test
    fun colorPureWhite() {
        val actual = res.getColor(R.color.colorPureWhite, null)
        val expected = -1

        assertEquals(expected, actual)
    }

    @Test
    fun colorZenBlue() {
        val actual = res.getColor(R.color.colorZenBlue, null)
        val expected = -10391328

        assertEquals(expected, actual)
    }

    @Test
    fun colorZenSalmon() {
        val actual = res.getColor(R.color.colorZenSalmon, null)
        val expected = -411248

        assertEquals(expected, actual)
    }

    @Test
    fun colorZenGlacier() {
        val actual = res.getColor(R.color.colorZenGlacier, null)
        val expected = -2626576

        assertEquals(expected, actual)
    }

    @Test
    fun colorZenBlush() {
        val actual = res.getColor(R.color.colorZenBlush, null)
        val expected = -268583

        assertEquals(expected, actual)
    }
}