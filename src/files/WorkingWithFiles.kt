package files

import java.io.File

fun main() {

    val operationCodes = OperationCodeTest.entries
    val file = File("todo_list.txt")

    while (true) {
        print("Enter the operation code.")
        for ((index, code) in operationCodes.withIndex()) {
            print(" $index - ${code.title},")
        }
        print("\b: ")

        val operationIndex = readln().toInt()
        val operationCode = operationCodes[operationIndex]
        when (operationCode) {
            OperationCodeTest.EXIT -> break
            OperationCodeTest.ADD_NEW_ITEM -> {
                print("Enter a new item: ")
                val item = readln()
                file.appendText("$item\n")
            }

            OperationCodeTest.SHOW_ALL_ITEMS -> {
                val content = file.readText().trim()
                val items = content.split("\n")
                for ((index, item) in items.withIndex()) {
                    println("$index - $item")
                }
            }
        }
    }
}
