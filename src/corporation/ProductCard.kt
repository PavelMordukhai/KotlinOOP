package corporation

class ProductCard(
    val name: String,
    val brand: String,
    val size: Float,
    val price: Int,
) {

    fun printInfo() {
        println("Name: ${name}\nBrand: ${brand}\nSize: ${size}\nPrice: $price")
    }
}
