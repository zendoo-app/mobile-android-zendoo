package app.zendoo.libraries.ui

import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks

class ColorsTest {

    @Mock
    lateinit var context: Context

    @Before
    fun setup() {
        initMocks(this)

        `when`(context.getColor(R.color.colorAccent)).thenReturn(-15758422)
        `when`(context.getColor(R.color.colorAlmostWhite)).thenReturn(-328964)
        `when`(context.getColor(R.color.colorBorder)).thenReturn(-1644308)
        `when`(context.getColor(R.color.colorConfirmation)).thenReturn(-12285185)
        `when`(context.getColor(R.color.colorDusty)).thenReturn(-10325886)
        `when`(context.getColor(R.color.colorError)).thenReturn(-695710)
        `when`(context.getColor(R.color.colorMuchGranite)).thenReturn(-10325886)
        `when`(context.getColor(R.color.colorPrimary)).thenReturn(-12304167)
        `when`(context.getColor(R.color.colorPrimaryDark)).thenReturn(-13027914)
        `when`(context.getColor(R.color.colorPureWhite)).thenReturn(-1)
        `when`(context.getColor(R.color.colorVeryNavy)).thenReturn(-16771530)
        `when`(context.getColor(R.color.colorZenBlue)).thenReturn(-10391328)
        `when`(context.getColor(R.color.colorZenBlush)).thenReturn(-268583)
        `when`(context.getColor(R.color.colorZenGlacier)).thenReturn(-2626576)
        `when`(context.getColor(R.color.colorZenSalmon)).thenReturn(-411248)
    }

    @Test
    fun colorPrimary() {

        val actual = context.getColor(R.color.colorPrimary)
        val expected = -12304167

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorPrimary)
    }

    @Test
    fun colorPrimaryDark() {
        val actual = context.getColor(R.color.colorPrimaryDark)
        val expected = -13027914

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorPrimaryDark)
    }

    @Test
    fun colorAccent() {
        val actual = context.getColor(R.color.colorAccent)
        val expected = -15758422

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorAccent)
    }

    @Test
    fun colorError() {
        val actual = context.getColor(R.color.colorError)
        val expected = -695710

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorError)
    }

    @Test
    fun colorConfirmation() {
        val actual = context.getColor(R.color.colorConfirmation)
        val expected = -12285185

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorConfirmation)
    }

    @Test
    fun colorVeryNavy() {
        val actual = context.getColor(R.color.colorVeryNavy)
        val expected = -16771530

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorVeryNavy)
    }

    @Test
    fun colorMuchGranite() {
        val actual = context.getColor(R.color.colorMuchGranite)
        val expected = -10325886

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorMuchGranite)
    }

    @Test
    fun colorDusty() {
        val actual = context.getColor(R.color.colorDusty)
        val expected = -10325886

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorDusty)
    }

    @Test
    fun colorBorder() {
        val actual = context.getColor(R.color.colorBorder)
        val expected = -1644308

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorBorder)
    }

    @Test
    fun colorAlmostWhite() {
        val actual = context.getColor(R.color.colorAlmostWhite)
        val expected = -328964

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorAlmostWhite)
    }

    @Test
    fun colorPureWhite() {
        val actual = context.getColor(R.color.colorPureWhite)
        val expected = -1

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorPureWhite)
    }

    @Test
    fun colorZenBlue() {
        val actual = context.getColor(R.color.colorZenBlue)
        val expected = -10391328

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorZenBlue)
    }

    @Test
    fun colorZenSalmon() {
        val actual = context.getColor(R.color.colorZenSalmon)
        val expected = -411248

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorZenSalmon)
    }

    @Test
    fun colorZenGlacier() {
        val actual = context.getColor(R.color.colorZenGlacier)
        val expected = -2626576

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorZenGlacier)
    }

    @Test
    fun colorZenBlush() {
        val actual = context.getColor(R.color.colorZenBlush)
        val expected = -268583

        assertEquals(expected, actual)

        verify(context).getColor(R.color.colorZenBlush)
    }
}