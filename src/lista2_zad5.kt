fun <A> setHead(lst: List<A>, item: A): List<A> {
    if (lst.isEmpty()) throw IllegalStateException("Empty list")
    return listOf(item) + lst.drop(1)
}

fun main () {
    println(setHead(listOf(1, 2, 3, 4, 5), 6))
}