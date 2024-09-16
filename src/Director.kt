class Director(
    val name: String,
    val age: Int,
) {

    fun takeCoffee(assistant: Assistant) {
        assistant.bringCoffee()
        println("\nThank you, ${assistant.name}! The coffee is very tasty!")
    }
}
