import kotlin.random.Random

fun main() {
    val options = listOf("Камень", "Ножницы", "Бумага")
    var isGameRunning = true;
    while (isGameRunning) {
        val userChoice = getUserChoice(options)
        val computerChoice = getComputerChoice(options)

        println("Компьютер выбрал: ${options[computerChoice]}")
        println("Вы выбрали: ${options[userChoice]}")

        isGameRunning = determineWinner(userChoice, computerChoice)
    }
}

fun getUserChoice(options: List<String>): Int{
    while (true) {
        println("Выберите: 1 - Камень, 2 - Ножницы, 3 - Бумага")
        val userInput = readLine()

        when (userInput) {
            "1" -> return 0
            "2" -> return 1
            "3" -> return 2
            else -> println("Неверный ввод. Пожалуйста, выберите 1, 2 или 3.")
        }
    }
}

fun getComputerChoice(options: List<String>): Int {
    return Random.nextInt(0, options.size)
}

fun determineWinner(userChoice: Int, computerChoice: Int): Boolean {
    return when {
        userChoice == computerChoice -> {
            println("Ничья! Переиграем.")
            true
        }
        (userChoice == 0 && computerChoice == 1) ||
                (userChoice == 1 && computerChoice == 2) ||
                (userChoice == 2 && computerChoice == 0) -> {
            println("Вы победили!")
            false
        }
        else -> {
            println("Компьютер победил!")
            false
        }
    }
}
