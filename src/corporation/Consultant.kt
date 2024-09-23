package corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0,
) : Worker(name = name, age = age) {

    override fun work() {
        serveCustomers()
    }

    fun serveCustomers(): Int {
        val count = Random.nextInt(0, 10)
        repeat(count) {
            println("The customer is served...")
        }
        return count
    }

    fun sayHello() {
        print("Hello! My name is $name.")
        if (age >= 18)
            println(" I'm $age years old.")
        else println()
    }
}
