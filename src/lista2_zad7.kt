fun check(N: Int, lst: List<Int>): Int {
    if (lst.size <= N) return -1  // Jeśli lista jest krótsza niż preambuła, zwracamy -1

    for (i in N until lst.size) {
        val preamble = lst.subList(i - N, i).toSet() // Pobieramy ostatnie N liczb jako zbiór
        val target = lst[i]

        // Sprawdzamy, czy istnieją dwa różne elementy w preambule, które sumują się do target
        var isValid = false
        for (x in preamble) {
            val y = target - x
            if (y != x && y in preamble) {
                isValid = true
                break
            }
        }

        if (!isValid) return target // Jeśli nie znaleziono sumy, zwracamy tę liczbę
    }
    return -1 // Jeśli wszystkie liczby spełniają warunek, zwracamy -1
}

fun main() {
    println(check(2, listOf(1, 2, 3, 4, 5, 6))) // Output: 4
    println(check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576))) // Output: 127
}
