val <T> List<T>.tail: List<T>
    get()= if (this.isNotEmpty()) this.drop(1) else emptyList()

val <T> List<T>.head: T
    get() = this.first()

fun main() {
    val lista = listOf(1,2,3,4,5)

    println(lista.head)
    println(lista.tail)
}