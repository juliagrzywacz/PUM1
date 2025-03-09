fun classifyNumber(number: Int): String {
    // Suma dzielników właściwych liczby
    val sumOfDivisors = (1 until number).filter { number % it == 0 }.sum()

    return when {
        sumOfDivisors == number -> "perfect" // Liczba doskonała
        sumOfDivisors > number -> "abundant" // Liczba obfita
        else -> "deficient" // Liczba niedomiarowa
    }
}

fun main() {
    val number = 28
    println(classifyNumber(number))
}
