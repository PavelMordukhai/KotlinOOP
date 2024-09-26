package corporation

import java.io.File

class Accountant(
    id: Int,
    name: String,
    age: Int,
) : Worker(id = id, name = name, age = age, position = Position.ACCOUNTANT), Cleaner, Supplier {

    private val fileProductCards = File("product_cards.txt")
    private val fileWorkers = File("workers.txt")

    override fun clean() {
        println("My position is ${position.title}. I'm cleaning workplace...")
    }

    override fun buyThings() {
        println("My position is ${position.title}. I'm buying things...")
    }

    override fun work() {
        val operationCodes = OperationCode.entries

        while (true) {
            println("Operation codes:")
            for ((index, code) in operationCodes.withIndex())
                print("$index - ${code.title}\n")
            print("Enter the operation code: ")

            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireAnEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
            }
        }
    }

    private fun changeSalary() {
        print("Enter employee's ID to change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val salary = readln().toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees) {
            if (employee.id == id)
                employee.setSalary(salary)
            saveWorkerToFile(employee)
        }
    }

    private fun registerNewEmployee() {
        val positions = Position.entries
        print("Choose position -")
        for ((index, position) in positions.withIndex())
            print(" $index - ${position.title}")
        print("\b: ")

        val positionIndex = readln().toInt()
        val position = positions[positionIndex]

        print("Enter ID: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        print("Enter salary: ")
        val salary = readln().toInt()

        val worker = when (position) {
            Position.DIRECTOR -> Director(id, name, age)
            Position.ACCOUNTANT -> Accountant(id, name, age)
            Position.ASSISTANT -> Assistant(id, name, age)
            Position.CONSULTANT -> Consultant(id, name, age)
        }
        worker.setSalary(salary)

        saveWorkerToFile(worker)
    }

    private fun fireAnEmployee() {
        print("Enter employee's ID to fire: ")
        val id = readln().toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")
        for (employee in employees)
            if (employee.id != id)
                saveWorkerToFile(employee)
    }

    private fun showAllEmployees() {
        val employees = loadAllEmployees()
        for (employee in employees)
            employee.printInfo()
    }

    fun loadAllEmployees(): MutableList<Worker> {
        val employees = mutableListOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()
        val content = fileWorkers.readText().trim()
        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for (employeeAsText in employeesAsText) {
            val properties = employeeAsText.split("|")
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val salary = properties[3].toInt()
            val positionAsText = properties.last()
            val position = Position.valueOf(positionAsText)

            val worker = when (position) {
                Position.DIRECTOR -> Director(id, name, age)
                Position.ACCOUNTANT -> Accountant(id, name, age)
                Position.ASSISTANT -> Assistant(id, name, age)
                Position.CONSULTANT -> Consultant(id, name, age)
            }
            worker.setSalary(salary)
            employees.add(worker)
        }
        return employees
    }

    private fun saveWorkerToFile(worker: Worker) {
        fileWorkers.appendText("${worker.id}|${worker.name}|${worker.age}|${worker.getSalary()}|${worker.position}\n")
    }

    private fun removeProductCard() {
        val cards = loadAllCards()
        print("Enter name of card of removing: ")
        val name = readln()

        for (card in cards)
            if (card.name == name) {
                cards.remove(card)
                break
            }
        fileProductCards.writeText("")
        for (card in cards)
            saveProductCardToFile(card)
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()

        if (!fileProductCards.exists()) fileProductCards.createNewFile()
        val content = fileProductCards.readText().trim()
        if (content.isEmpty()) return cards

        val cardsAsString = content.split("\n")
        for (card in cardsAsString) {
            val properties = card.split("|")

            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()

            val type = properties.last()
            val productType = ProductType.valueOf(type)

            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    private fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards)
            card.printInfo()
    }

    private fun saveProductCardToFile(productCard: ProductCard) {
        fileProductCards.appendText("${productCard.name}|${productCard.brand}|${productCard.price}|")

        when (productCard) {
            is FoodCard -> fileProductCards.appendText("${productCard.caloric}|")
            is ShoeCard -> fileProductCards.appendText("${productCard.size}|")
            is ApplianceCard -> fileProductCards.appendText("${productCard.wattage}|")
        }
        fileProductCards.appendText("${productCard.productType}\n")
    }

    private fun registerNewItem() {
        val productTypes = ProductType.entries

        print("Enter the product type.")
        for ((index, type) in productTypes.withIndex())
            print(" $index - ${type.title},")
        print("\b: ")

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
                FoodCard(productName, productBrand, productPrice, caloric)
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(productName, productBrand, productPrice, wattage)
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                ShoeCard(productName, productBrand, productPrice, size)
            }
        }
        saveProductCardToFile(card)
    }
}
