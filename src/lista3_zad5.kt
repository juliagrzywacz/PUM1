fun evenPositiveSquare(numbers: List<Int>): List<Int> {
    return numbers.withIndex()
        .filter { (index, value) -> index % 2 == 1 && value > 0 }
        .map { (_, value) -> value * value }
}

fun main() {
    println(evenPositiveSquare(listOf(1, 2, 3, 5, -6, -1, -1, 2, 3)))
}