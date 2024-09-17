package corporation

fun main() {

    val director: Director = Director("Andrey", 35)
    val consultant: Consultant = Consultant("Max")
    val assistant: Assistant = Assistant("Helen", 20)

    director.getConsultantToWork(consultant)
    println()
    director.takeCoffee(assistant)
    println()

    // upcast
    val director2: Worker = Director("Andrey T", 30)
    val consultant2: Worker = Consultant("Max T")
    val assistant2: Worker = Assistant("Helen T", 25)
    println(director2.name)
    println(consultant2.age)
    println(assistant2.age)
//    director2.getConsultantToWork(consultant) // exception
//    consultant2.serveCustomers() // exception
//    assistant2.bringCoffee() // exception
    println()

    // downcast
    (assistant2 as Assistant).bringCoffee()
    (director2 as Director).getConsultantToWork(consultant2 as Consultant)

    // smartcast
    director2.takeCoffee(assistant2)
    consultant2.sayHello()
}
