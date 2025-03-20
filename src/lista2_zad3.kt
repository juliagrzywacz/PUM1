fun <A> isSorted(lst: List<A>, order: (A, A) -> Boolean): Boolean {
    for (i in 0 until lst.size-1) {
        if (!order(lst[i], lst[i+1])) {
            return false
        }
    }
    return true
}

fun main() {
    println(isSorted(listOf(1, 2, 3, 4)) { i, j -> i < j })
    println(isSorted(listOf(1, 1, 1, 1)) { i, j -> i == j })
    println(isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu")) { i, j -> i.first() < j.first() })
}