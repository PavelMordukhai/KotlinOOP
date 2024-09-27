package profile

fun main() {

    print("Input 1st your name: ")
    val firstName = readln()
    print("Input 2st your name: ")
    val secondName = readln()

    print("Input 1st your lastname: ")
    val firstlastName = readln()
    print("Input 2st your lastname: ")
    val secondlastName = readln()

    print("Input 1st your age: ")
    val firstAge = readln().toInt()
    print("Input 2st your age: ")
    val secondAge = readln().toInt()

    print("Input 1st your height: ")
    val firstHeight = readln().toInt()
    print("Input 2st your height: ")
    val secondHeight = readln().toInt()

    print("Input 1st your weight: ")
    val firstWeight = readln().toInt()
    print("Input 2st your weight: ")
    val secondWeight = readln().toInt()

    val first = Person(
        name = firstName,
        lastName = firstlastName,
        height = firstHeight,
        weight = firstWeight
    )

    val second = Person(
        name = secondName,
        lastName = secondlastName,
        height = secondHeight,
        weight = secondWeight
    )

    println(first.fullName)
    println(second.fullName)

    first.age = firstAge
    second.age = secondAge

    first.printInfo()
    second.printInfo()

    second.lastName = firstlastName

    println(first.fullName)
    println(second.fullName)

    first.age = 0
    second.age = 0

    first.sayHello()
    second.sayHello()

    first.run()
    second.run()
}
