package corporation

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val caloric: Int,
) : ProductCard(name, brand, price) {

    override fun printInfo() {
        println("Name: ${name}\nBrand: ${brand}\nPrice: $price\nCaloric: $caloric")
    }
}
