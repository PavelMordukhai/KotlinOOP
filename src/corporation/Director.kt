package corporation

class Director(
    id: Int,
    name: String,
    age: Int,
) : Worker(id = id, name = name, age = age, position = Position.DIRECTOR) {

    override fun work() {
        println("I'm drinking coffee...")
    }

    fun takeCoffee(assistant: Assistant) {
        val drinkName: String = assistant.bringCoffee()
        println("\nThank you, ${assistant.name}! The $drinkName is very tasty!")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("corporation.Consultant ${consultant.name} served $count clients")
    }
}
