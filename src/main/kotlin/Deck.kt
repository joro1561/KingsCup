class Deck{

    val cards: MutableList<Card> = mutableListOf()

    // Draw Card returns the last card of the deck and removes it from the deck
    // Love Kotlins removeAt function :)
    fun drawCard(): Card?{
        if(cards.isNotEmpty()){
            return cards.removeAt(cards.size - 1)
        }
        return null
    }

    // Just a check to see if we have a King or not
    fun hasKing(deck: Deck): Boolean{
        return deck.cards.any {it.value == "King"}
    }
}