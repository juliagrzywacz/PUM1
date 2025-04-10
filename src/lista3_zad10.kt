data class Point(val x: Int, val y: Int) {

    // Dodawanie dwoch punktow - +
    operator fun plus(other: Point) = Point(this.x + other.x, this.y + other.y)

    // Dodawanie wartosci do punktu - +
    operator fun plus(value: Int) = Point(this.x + value, this.y + value)

    // Odejmowanie dwoch punktow - -
    operator fun minus(other: Point) = Point(this.x - other.x, this.y - other.y)

    // Mnozenie dwoch punktow - *
    operator fun times(other: Point) = Point(this.x * other.x, this.y * other.y)

    // Inkrementacja punktu - ++
    operator fun inc() = Point(this.x + 1, this.y + 1)

    // Dekrementacja punktu - --
    operator fun dec() = Point(this.x - 1, this.y - 1)

    // Negacja punktu - !
    operator fun not() = Point(-this.x, -this.y)

    override fun toString(): String {
        return "($x, $y)"
    }
}

fun main() {
    val p1 = Point(1, 1)
    val p2 = Point(2, 2)

    println(p1 + p2)
    println(p1 + 1)
    println(p1 - p2)
    println(p1 * p2)
    println(p1.inc())
    println(p1.dec())
    println(!p1)
}
