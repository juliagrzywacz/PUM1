data class StudentScore(val name: String, val subject: String, val score: Int)

fun analyzeResults(students: List<StudentScore>): Triple<Map<String, List<StudentScore>>, List<StudentScore>, List<String>> {
    val passingScore = 50

    // Mapa przedmiotow z listami studentow ktorzy zdali
    val passsedBySubject = students
        .filter { it.score >= passingScore }
        .groupBy { it.subject }

    // Lista studentow ktorzy nie zdali
    val failed = students.filter { it.score < passingScore }

    // Lista przedmiotow w ktorych wszyscy zdali
    val subjectsAllPassed = students
        .groupBy { it.subject }
        .filterValues { it.all {student -> student.score >= passingScore } }
        .keys.toList()

    return Triple(passsedBySubject, failed, subjectsAllPassed)
}

fun main() {
    val students = listOf(
        StudentScore("Alice", "Math", 78),
        StudentScore("Bob", "Math", 45),
        StudentScore("Charlie", "Physics", 92),
        StudentScore("Dave", "Physics", 55),
        StudentScore("Eve", "Physics", 40),
        StudentScore("Frank", "CS", 60),
        StudentScore("Grace", "CS", 80),
    )

    val (passedBySubject, failed, subjectsAllPassed) = analyzeResults(students)

    println("Zdani studenci według przedmiotów: $passedBySubject")
    println("Niezdani studenci: $failed")
    println("Przedmioty, w których wszyscy zdali: $subjectsAllPassed")

}