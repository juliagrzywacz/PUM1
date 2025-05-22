import java.time.LocalDate
import kotlin.random.Random
import java.time.Month

enum class CostType(val costType: String) {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat")
}

data class Cost (
    val type: CostType,
    val date: LocalDate,
    val amount: Int
)

data class Car(
    val name: String,
    val brand: String,
    val model: String,
    val yearOfProduction: Int,
    val costs: List<Cost>
)

object DataProvider {
    private fun generalCosts(size: Int) = List(size) {
        Cost(
            CostType
                .values()[Random.nextInt(CostType.values().size)],
            LocalDate.of(
                2025,
                Random.nextInt(1,13),
                Random.nextInt(1,28)),
                Random.nextInt(5000)
            )
    }

    val cars = listOf(
        Car("Domowy", "Skoda", "Fabia", 2002, generalCosts(100)),
        Car("Służbowy", "BMW", "Coupe", 2015, generalCosts(50)),
        Car("Kolekcjonerski", "Fiat", "125p", 1985, generalCosts(10))
    )
}

// Zadanie 1
fun groupedCostMap(costs: List<Cost>): Map<Month, List<Cost>> {
    return costs
        .groupBy { it.date.month }
        .toSortedMap()
}

// Zadanie 2
fun printCarCostsByMonth(costs: List<Cost>) {
    costs
        .sortedBy { it.date }
        .groupBy { it.date.month }
        .toSortedMap()
        .forEach {(month, monthlyCosts) ->
            println(month.name)
            monthlyCosts.forEach{ cost ->
                val day = cost.date.dayOfMonth.toString().padStart(2, '0')
                println("$day: ${cost.type.name} ${cost.amount} zl")
            }
        }
}

// Zadanie 3
fun getCarCosts(name:String): List<Pair<CostType, Int>> {
    val car = DataProvider.cars.find {it.name == name}
        ?: throw IllegalArgumentException("Nie znaleziono auta o nazwie: $name")

    return CostType.values()
        .map { type ->
            val sum = car.costs
                .filter {it.type == type}
                .sumOf { it.amount }
            type to sum
        }
        .sortedByDescending { it.second }
}

fun printCarCosts(costs: List<Pair<CostType, Int>>) {
    costs.forEachIndexed { index, (type, sum) ->
        val comma = if (index < costs.size -1) "," else ""
        println("${type.name} ${sum} zł$comma")
    }
}

// Zadanie 4
fun getFullCosts(car: List<Car>): Map<CostType, Int> {
    return CostType.values().associateWith { type ->
        DataProvider.cars
            .flatMap {it.costs}
            .filter {it.type == type}
            .sumOf {it.amount }

    }
}

fun printFullCosts(costMap: Map<CostType, Int>) {
    costMap
        .toList()
        .sortedBy { it.first.name }
        .forEach { (type, amount) ->
            println("${type.name} $amount")
        }
}

fun main() {
    val car = DataProvider.cars[0]

    val gruped = groupedCostMap(car.costs)
    println("Zadanie 1: Grupowanie kosztow po miesiacach")
    println(gruped)

    println("Zadanie 2: Koszty samochodu ${car.name} po miesiacach")
    println("${car.name.uppercase()} (${car.brand} ${car.model})")
    printCarCostsByMonth(car.costs)

    println("\nZadanie 3: Podsumowanie kosztow dla samochodu ${car.name}")
    val summary = getCarCosts("Domowy")
    printCarCosts(summary)

    println("\nZadanie 4: Podsumowanie wszystkich kosztow")
    printFullCosts(getFullCosts(DataProvider.cars))


}