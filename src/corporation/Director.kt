package corporation

data class Director(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = Position.DIRECTOR
), Supplier {

    override fun copy(
        id: Int,
        name: String,
        age: Int,
        salary: Int,
        position: Position
    ): Worker {
        return copy(id, name, age, salary)
    }

    override fun buyThings() {
        println("My position is ${position.title}. I'm buying things...")
    }

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
