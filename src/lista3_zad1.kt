fun findDuplicates(lst: List<Int>): List<Int> {
    val seen = mutableSetOf<Int>()
    val duplicates = mutableSetOf<Int>()

    for (num in lst) {
        if (!seen.add(num)) {
            duplicates.add(num)
        }
    }
    return duplicates.sorted()
}

fun main (){
    val lst = listOf(0, 1, 1, 1, 4, 4, 4, 9, 3, 3, 3, 3, 3)
    println(findDuplicates(lst))
}