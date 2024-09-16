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

    print("Input 1st your height: ")
    first.height = readln().toInt()
    print("Input 2st your height: ")
    second.height = readln().toInt()

    print("Input 1st your weight: ")
    first.weight = readln().toInt()
    print("Input 2st your weight: ")
    second.weight = readln().toInt()

    println("\n1. Name: ${first.name}\nAge: ${first.age}" +
            "\nHeight: ${first.height}\nWeight: ${first.weight}")
    println("\n2. Name: ${second.name}\nAge: ${second.age}" +
            "\nHeight: ${second.height}\nWeight: ${second.weight}")
}

