
val menu = mapOf(
    "Clássico" to mutableListOf("morango", "banana", "abacaxi", "manga", "pêssego", "mel", "gelo", "iogurte"),
    "Forest Berry" to mutableListOf("morango", "framboesa", "mirtilo", "mel", "gelo", "iogurte"),
    "Freezie" to mutableListOf("amora", "mirtilo", "groselha preta", "suco de uva", "iogurte congelado"),
    "Greenie" to mutableListOf("maçã verde", "kiwi", "limão", "abacate", "espinafre", "gelo", "suco de maçã"),
    "Vegan Delight" to mutableListOf("morango", "maracujá", "abacaxi", "manga", "pêssego", "gelo", "leite de soja"),
    "Apenas sobremesas" to mutableListOf("banana", "sorvete", "chocolate", "amendoim", "cereja")
)

fun processOrder(order: String): List<String> {
    val parts = order.split(",").map { it.trim() }
    val smoothieName = parts[0]
    val ingredients = menu[smoothieName]?.toMutableList() ?: return emptyList()

    for (i in 1..<parts.size) {
        val operation = parts[i]
        when {
            operation.startsWith("+") -> ingredients.add(operation.substring(1))
            operation.startsWith("-") -> ingredients.remove(operation.substring(1))
        }
    }

    return ingredients
}

fun main() {
    println(processOrder("Clássico, +abacaxi, -morango"))
}