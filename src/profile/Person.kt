package profile

class Person(
    private val name: String,
    private val height: Int,
    private val weight: Int
) {

    var age: Int = 0
        set(value) {
            if (value > field)
                field = value
            else println("The new age must be bigger than the old one")
        }
        get() {
            println("It is indecent to ask a person his age")
            return field
        }

    fun printInfo() {
        println("Name: $name\nAge: $age\nHeight: $height\nWeight: $weight")
    }

    fun sayHello() {
        println("Hello! My name is $name")
    }

    fun run() {
        println("Running...")
    }
}
