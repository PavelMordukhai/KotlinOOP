package corporation

class Director(
    name: String,
    age: Int,
): Worker(name = name, age = age) {

    fun takeCoffee(assistant: Assistant) {
        val drinkName: String = assistant.bringCoffee()
        println("\nThank you, ${assistant.name}! The $drinkName is very tasty!")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("corporation.Consultant ${consultant.name} served $count clients")
    }
}
