import kotlin.math.pow

fun checkArmstrong(number:Int): Boolean{
    val digits = number.toString().map { it.digitToInt()}
    val power = digits.size
    val sum = digits.sumOf { it.toDouble().pow(power).toInt() }
    return sum == number
}
fun main(){
    val number: Int = 153
    println(checkArmstrong(number))
}