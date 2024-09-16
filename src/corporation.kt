fun main() {

    val productCard = ProductCard()

    print("Enter name: ")
    val name = readln()
    print("Enter brand: ")
    val brand = readln()
    print("Enter size: ")
    val size = readln().toFloat()
    print("Enter price: ")
    val price = readln().toInt()
    println()

    productCard.name = name
    productCard.brand = brand
    productCard.size = size
    productCard.price = price
    productCard.printInfo()
}
