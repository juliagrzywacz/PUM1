fun perm(nums: List<Int>): List<List<Int>> {
    if (nums.isEmpty()) return listOf(emptyList())

    return nums.flatMap { num -> perm(nums-num).map { listOf(num) + it }
    }
}

fun main() {
    println(perm(listOf(1, 2, 3,)))
}
