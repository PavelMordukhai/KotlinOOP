package corporation

class Accountant(
    name: String,
    age: Int = 0,
) : Worker(name = name, age = age) {

    fun registerNewItem() {
        val productTypes = ProductType.entries

        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1)
                print(", ")
            else
                print(": ")
        }

        val productTypeIndex = readln().toInt()
        val productType: ProductType = productTypes[productTypeIndex]

        print("Enter the product name: ")
        val productName = readln()
        print("Enter the product brand: ")
        val productBrand = readln()
        print("Enter the product price: ")
        val productPrice = readln().toInt()

        val card = when (productType) {

            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                FoodCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    caloric = caloric
                )
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    wattage = wattage
                )
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                ShoeCard(
                    name = productName,
                    brand = productBrand,
                    price = productPrice,
                    size = size
                )
            }
        }

        card.printInfo()
    }

    override fun work() {
        while (true) {
            print("Enter the operation code. 0 - exit, 1 - register new item: ")
            val operation = readln().toInt()
            when (operation) {
                0 -> break
                1 -> registerNewItem()
            }
        }
    }
}
