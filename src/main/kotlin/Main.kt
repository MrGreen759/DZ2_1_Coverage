fun main() {
    var value: Int                  // сумма к переводу
    var fromCard: String            // тип карты, с которой переводят
    var toCard: String              // тип карты, на которую переводят
    var sentInMonth: Int = 0        // переведено за месяц

    value = 60000
    fromCard = "Visa"
    toCard = "VK Pay"
    message(comission(value, fromCard, toCard, sentInMonth))

    value = 60000
    fromCard = "Mastercard"
    toCard = "Visa"
    sentInMonth = 21000
    message(comission(value, fromCard, toCard, sentInMonth))

    value = 60000
    fromCard = "Мир"
    toCard = "Visa"
    message(comission(value, fromCard, toCard, sentInMonth))
}

fun comission (sum: Int, from: String, to: String = "VK Pay", sent: Int = 0): Int {
    var comissionValue: Int = 0

    if ((sent+sum) > 600000) comissionValue = -1
    else {
        when {
            to == "VK Pay" -> comissionValue = 0
            (from == "Visa") || (from == "Мир") -> {
                comissionValue = (sum * 75) / 100
                if (comissionValue < 3500 ) comissionValue = 3500
            }
            (from == "Mastercard") || (from == "Maestro") -> {
                if ((sent + sum) <= 75000) comissionValue = 0
                else {
                    comissionValue = (sum * 6) / 10 + 2000
                }
            }
        }
    }
    return comissionValue
}

fun message(value: Int) {
    when (value) {
        -1 -> println("Превышен месячный лимит")
        0 -> println("Комиссия не взимается")
        else -> println("Комиссия составит $value копеек.")
    }
}