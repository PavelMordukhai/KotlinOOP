fun main() {

    print("Enter name: ")
    val name = readln()
    print("Enter brand: ")
    val brand = readln()
    print("Enter size: ")
    val size = readln().toFloat()
    print("Enter price: ")
    val price = readln().toInt()
    println()

    val productCard = ProductCard(name = name, brand = brand, size = size, price = price)

    productCard.printInfo()
}
