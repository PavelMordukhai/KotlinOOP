class Director(
    val name: String,
    val age: Int,
) {

    fun takeCoffee(assistant: Assistant) {
        val drinkName: String = assistant.bringCoffee()
        println("\nThank you, ${assistant.name}! The $drinkName is very tasty!")
    }
}
