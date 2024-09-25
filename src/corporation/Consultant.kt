package corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name: String,
    age: Int = 0,
) : Worker(id = id, name = name, age = age, position = Position.CONSULTANT), Cleaner {

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
