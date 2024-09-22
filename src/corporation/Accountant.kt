package corporation

import java.io.File

class Accountant(
    name: String,
    age: Int = 0,
) : Worker(name = name, age = age) {

    val items = mutableListOf<ProductCard>()
    val file = File("product_cards.txt")

    override fun work() {
        val operationCodes = OperationCode.entries

        while (true) {
            print("Enter the operation code.")
            for ((index, code) in operationCodes.withIndex()) {
                print(" $index - ${code.title},")
            }
            print("\b: ")

            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
            }
        }
    }

    fun showAllItems() {
        for (item in items) {
            item.printInfo()
        }
    }

    fun registerNewItem() {
        val productTypes = ProductType.entries

        print("Enter the product type.")
        for ((index, type) in productTypes.withIndex()) {
            print(" $index - ${type.title},")
        }
        print("\b: ")

        val productTypeIndex = readln().toInt()
        val productType: ProductType = productTypes[productTypeIndex]

        print("Enter the product name: ")
        val productName = readln()
        file.appendText(productName)

        print("Enter the product brand: ")
        val productBrand = readln()
        file.appendText(productBrand)

        print("Enter the product price: ")
        val productPrice = readln().toInt()
        file.appendText("$productPrice")

        when (productType) {

            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                file.appendText("$caloric")
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                file.appendText("$wattage")
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                file.appendText("$size")
            }
        }

        file.appendText("\n")
    }
}
