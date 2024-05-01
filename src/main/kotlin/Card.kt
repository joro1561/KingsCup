class Card(val suit: String, val value: String){
    override fun toString(): String {
        return """
          ___________
         |           |
         | ${value.padEnd(2)}        |
         |           |
         |    ${suitSymbol()}      |
         |           |
         |       ${value.padStart(2)}  |
         |___________|
        """
    }

    private fun suitSymbol(): String {
        return when (suit) {
            "Hearts" -> "\u2665"
            "Diamonds" -> "\u2666"
            "Clubs" -> "\u2663"
            "Spades" -> "\u2660"
            else -> "InvalidSuit"
        }
    }
}