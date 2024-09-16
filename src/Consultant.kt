class Consultant(
    val name: String,
    val age: Int = 0
) {
    fun sayHello() {
        print("Hello! My name is $name.")
        if (age >= 18)
            println(" I'm $age years old.")
        else println()
    }
}
