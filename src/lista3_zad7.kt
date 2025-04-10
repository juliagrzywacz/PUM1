fun srt(words: List<String>): List<Pair<String, List<String>>> {
    return words
        .filter {it.length % 2 == 0}
        .groupBy { it.first() }
        .toSortedMap()
        .map { (key, value) -> key.toString() to value }

}

fun main() {
    println(srt(listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")))
}