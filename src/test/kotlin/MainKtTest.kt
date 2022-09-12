import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun noComission() {
        var value: Int = 60000                  // сумма к переводу
        var fromCard: String = "Visa"            // тип карты, с которой переводят
        var toCard: String = "VK Pay"              // тип карты, на которую переводят
        var sentInMonth: Int = 0        // переведено за месяц

        val result = comission(value, fromCard, toCard, sentInMonth)

        assertEquals(0, result)
    }

    @Test
    fun offLimit() {
        var value: Int = 60000                  // сумма к переводу
        var fromCard: String = "Mastercard"            // тип карты, с которой переводят
        var toCard: String = "Visa"              // тип карты, на которую переводят
        var sentInMonth: Int = 810000        // переведено за месяц

        val result = comission(value, fromCard, toCard, sentInMonth)

        assertEquals(-1, result)
    }

    @Test
    fun comissionFromMasterMaestro() {
        var value: Int = 60000                  // сумма к переводу
        var fromCard: String = "Mastercard"            // тип карты, с которой переводят
        var toCard: String = "Visa"              // тип карты, на которую переводят
        var sentInMonth: Int = 21000        // переведено за месяц

        var result = comission(value, fromCard, toCard, sentInMonth)
        assertEquals(38000, result)

        value = 1000
        fromCard = "Maestro"
        result = comission(value, fromCard, toCard, sentInMonth)
        assertEquals(0, result)
    }

    @Test
    fun comissionFromVisaMir() {
        var value: Int = 60000                  // сумма к переводу
        var fromCard: String = "Visa"            // тип карты, с которой переводят
        var toCard: String = "Visa"              // тип карты, на которую переводят
        var sentInMonth: Int = 21000        // переведено за месяц

        var result = comission(value, fromCard, toCard, sentInMonth)
        assertEquals(45000, result)

        value = 1000
        fromCard = "Мир"
        result = comission(value, fromCard, toCard, sentInMonth)
        assertEquals(3500, result)
    }

}