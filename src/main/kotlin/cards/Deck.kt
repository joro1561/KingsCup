class Deck{
    val cards: MutableList<Card> = mutableListOf()

    init {
        val suits = listOf("Hearts", "Diamonds", "Clubs", "Spades")
        val values = listOf("2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace")

        for (suit in suits){
            for (value in values){
                cards.add(Card(suit, value))
            }
        }
    }

    // Function remove a card from the deck
    fun removeCard(card_picked: Card){
        if cards.contains(card_picked){
            cards.remove(card_picked)
        }
    }
}