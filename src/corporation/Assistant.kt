package corporation

class Assistant(
    id: Int,
    name: String,
    age: Int = 0,
) : Worker(id = id, name = name, age = age, position = Position.ASSISTANT) {

    override fun work() {
        println("I'm answering the phone now...")
    }

    fun bringCoffee(
        drinkName: String = "Cappuccino",
        count: Int = 1,
    ): String {
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("Press the \"$drinkName\" button")
            println("Wait for the \"$drinkName\" to be prepared")
            println("Take coffee")
            println("Bring coffee to the director")
            println("Put coffee on the table")
            println("Return to the workplace")
        }
        return drinkName
    }
}
