fun main() {

    val first = Person()
    val second = Person()

    print("Input 1st your name: ")
    first.name = readln()
    print("Input 2st your name: ")
    second.name = readln()

    print("Input 1st your age: ")
    first.age = readln().toInt()
    print("Input 2st your age: ")
    second.age = readln().toInt()

    println("\n1. Name: ${first.name}\nAge: ${first.age}")
    println("\n2. Name: ${second.name}\nAge: ${second.age}")
}

