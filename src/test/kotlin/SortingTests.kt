import net.catstack.mergesortlab.sorting.StringsMergeSorter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SortingTests {
    private val sorter = StringsMergeSorter()

    @Test
    fun testEmpty() {
        Assertions.assertEquals(arrayListOf<String>(), sorter.sort(arrayListOf()))
    }

    @Test
    fun testOneElement() {
        Assertions.assertEquals(arrayListOf("abc"), sorter.sort(arrayListOf("abc")))
    }

    @Test
    fun testEnglishStrings() {
        Assertions.assertEquals(arrayListOf("a", "b", "c"), sorter.sort(arrayListOf("b", "c", "a")))
        Assertions.assertEquals(arrayListOf("a", "aaa", "ab", "abaa", "absd", "adsohiao", "hkldfsn"),
            sorter.sort(arrayListOf("hkldfsn", "absd", "aaa", "a", "adsohiao", "ab", "abaa")))
    }

    @Test
    fun testRussianStrings() {
        Assertions.assertEquals(arrayListOf("а", "г", "ю"), sorter.sort(arrayListOf("ю", "г", "а")))
        Assertions.assertEquals(arrayListOf("абр", "аыв", "баб", "мы", "р", "рцу", "ыва"),
            sorter.sort(arrayListOf("р", "ыва", "мы", "рцу", "аыв", "баб", "абр")))
    }

    @Test
    fun testNumbersStrings() {
        Assertions.assertEquals(arrayListOf("09", "1", "101", "11", "712", "8165"),
            sorter.sort(arrayListOf("101", "8165", "712", "11", "1", "09")))
    }
}