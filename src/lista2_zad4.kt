fun <A> tailToHead(lst: List<A>): List<A> {
    if (lst.isEmpty()) throw IllegalStateException("Empty list")
    return listOf(lst.last()) + lst.dropLast(1)
}

fun main() {
    println(tailToHead(listOf(1, 2, 3, 4, 5)))
}