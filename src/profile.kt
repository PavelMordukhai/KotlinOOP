fun main() {

    print("Input 1st your name: ")
    val firstName = readln()
    print("Input 2st your name: ")
    val secondName = readln()

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

    val first = Person(name = firstName, age = firstAge, height = firstHeight, weight = firstWeight)
    val second = Person(name = secondName, age = secondAge, height = secondHeight, weight = secondWeight)

    first.printInfo()
    second.printInfo()

    first.sayHello()
    second.sayHello()

    first.run()
    second.run()
}
