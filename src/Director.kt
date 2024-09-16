class Director(
    val name: String,
    val age: Int,
) {

    fun takeCoffee(assistant: Assistant, drinkName: String) {
        assistant.bringCoffee(drinkName)
        println("\nThank you, ${assistant.name}! The $drinkName is very tasty!")
    }
}
