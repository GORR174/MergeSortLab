import net.catstack.mergesortlab.MassTaskResolver
import net.catstack.mergesortlab.models.PlanModel
import net.catstack.mergesortlab.sorting.StringsMergeSorter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StringGenerationTests {
    val planModel = PlanModel(listOf())

    @Test
    fun testStringLength() {
        val resolver = MassTaskResolver(planModel)
        Assertions.assertEquals(16, resolver.generateRandomString(16).length)
        Assertions.assertEquals(16, resolver.generateRandomString(16).length)
        Assertions.assertEquals(16, resolver.generateRandomString(16).length)
    }

    @Test
    fun testStringsDifference() {
        val resolver = MassTaskResolver(planModel)
        Assertions.assertNotEquals(resolver.generateRandomString(16), resolver.generateRandomString(16))
    }

    @Test
    fun testArrayLength() {
        val resolver = MassTaskResolver(planModel)
        Assertions.assertEquals(20, resolver.generateRandomStringList(15)[0].length)
        Assertions.assertEquals(15, resolver.generateRandomStringList(15, 15)[0].length)
        Assertions.assertEquals(15, resolver.generateRandomStringList(15).size)
    }
}