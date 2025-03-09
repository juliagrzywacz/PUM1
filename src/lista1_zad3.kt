fun printPascal(height: Int) {
    // Lista przechowująca kolejne wiersze trójkąta Pascala
    val triangle = mutableListOf<List<Int>>()

    // Pętla generująca kolejne wiersze trójkąta
    for (i in 0 until height) {
        // Tworzymy nowy wiersz o długości i+1, wypełniony jedynkami
        val row = MutableList(i + 1) { 1 }

        // Wypełniamy środkowe wartości wiersza, jeśli jest większy niż 2.
        // Każdy element (poza pierwszym i ostatnim) to suma dwóch elementów z poprzedniego wiersza.
        if (i > 1) {
            for (j in 1 until i) {
                row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
            }
        }

        // Dodajemy nowo utworzony wiersz do listy trójkąta
        triangle.add(row)

        // Tworzymy odpowiednią liczbę spacji, aby wyśrodkować wiersz
        val spaces = " ".repeat(height - i - 1)

        // Drukujemy wiersz, oddzielając liczby spacją
        println(spaces + row.joinToString(" "))
    }
}
fun main() {
    val height = 4
    printPascal(height)
}