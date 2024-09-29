package corporation

import kotlin.random.Random

data class Consultant(
    override val id: Int,
    override val name: String,
    override val age: Int = 0,
    override val salary: Int,
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = Position.CONSULTANT
), Cleaner {

    override fun copy(salary: Int, age: Int): Consultant {
        return Consultant(this.id, this.name, age, salary)
    }

    override fun clean() {
        println("My position is ${position.title}. I'm cleaning workplace...")
    }

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
