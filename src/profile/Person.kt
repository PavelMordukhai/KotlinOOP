package profile

class Person {

    val name: String
    val age: Int
    val height: Int
    val weight: Int

    constructor(name: String, age: Int, height: Int, weight: Int) {
        this.name = name
        this.age = age
        this.height = height
        this.weight = weight
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
