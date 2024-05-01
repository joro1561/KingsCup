interface DeckFactory {
    fun createDeck(): Deck
}

class TheDeckFactory : DeckFactory {
    override fun createDeck(): Deck {
        val deck = Deck()
        // All Suits
        val suits = listOf("Hearts", "Diamonds", "Clubs", "Spades")
        val values = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace")

        for (suit in suits) {
            for (value in values) {
                deck.cards.add(Card(suit, value))
            }
        }

        return deck
    }
}
