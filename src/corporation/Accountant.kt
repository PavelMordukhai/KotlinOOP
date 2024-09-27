package corporation

class Accountant(
    id: Int,
    name: String,
    age: Int,
    salary: Int
) : Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = Position.ACCOUNTANT
), Cleaner, Supplier {

    private val workersRepository = WorkersRepository()
    private val productCardsRepository = ProductCardsRepository()

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
                OperationCode.EXIT -> {
                    workersRepository.saveChanges()
                    break
                }
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
        workersRepository.changeSalary(id, salary)
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
            Position.DIRECTOR -> Director(id, name, age, salary)
            Position.ACCOUNTANT -> Accountant(id, name, age, salary)
            Position.ASSISTANT -> Assistant(id, name, age, salary)
            Position.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployee(worker)
    }

    private fun fireAnEmployee() {
        print("Enter employee's ID to fire: ")
        val id = readln().toInt()
        workersRepository.fireAnEmployee(id)
    }

    private fun showAllEmployees() {
        val employees = workersRepository.workers
        for (employee in employees)
            employee.printInfo()
    }

    private fun removeProductCard() {
        print("Enter name of card of removing: ")
        val name = readln()
        productCardsRepository.removeProductCard(name)
    }

    private fun showAllItems() {
        val cards = productCardsRepository.loadAllCards()
        for (card in cards)
            card.printInfo()
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
        productCardsRepository.registerNewItem(card)
    }
}
