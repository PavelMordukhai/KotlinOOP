package corporation

fun main() {

    val accountant = Accountant(0, "Christian", 30)
    val employees = accountant.loadAllEmployees()

    for (employee in employees) {
        if (employee is Cleaner)
            employee.clean()
    }
}
