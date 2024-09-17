package corporation

fun main() {

    val director = Director("Andrey", 35)
    val consultant = Consultant("Max")
    val assistant = Assistant("Helen", 20)

    director.getConsultantToWork(consultant)
    println()
    director.takeCoffee(assistant)
}
