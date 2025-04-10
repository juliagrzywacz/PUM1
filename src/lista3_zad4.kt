fun countElements(lists: List<List<String>>): Map<String, Int> {
   return lists.flatten().groupingBy { it }.eachCount()
}

fun main() {
    println(countElements(listOf(
        listOf("a", "b", "c"),
        listOf("c", "d", "f"),
        listOf("d", "f", "g"))))
}