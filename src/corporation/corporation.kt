package corporation

fun main() {

    val director = Director("Andrey", 35)
    val consultant = Consultant("Max")
    val assistant = Assistant("Helen", 20)

    val employees = listOf<Worker>(director, consultant, assistant)
    for (employee in employees) {
        employee.work()
        println()
    }
}
