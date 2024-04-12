import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeckTest{

    private val deckFactory = TheDeckFactory()

    @Test
    fun 'Test creating deck with deck factory'(){
        val deck = deckFactory.createDeck()
        assertEquals(deck.cards.size, 52, "DeckTest: Deck of cards does not have 52 cards!!!")
    }

    @Test
    fun 'Test drawing a card and have less cards in deck'(){
        val deck = deckFactory.createDeck()
        deck.drawCard()
        assertEquals(deck.cards.size, 51, "DeckTest: Deck still has 52 cards after draw!!!")
    }

    @Test 
    fun 'test empty deck returns null when drawn'() {
        val deck = Deck()
        assertNull(deck.drawCard(), "DeckTest: Empty Deck does not return null when drawn from!!!")
    }

    @Test
    fun 'Test to make sure has King works'(){
        val deck = Deck()
        deck.cards.add(Card("Diamonds", "King"))
        assertTrue(deck.cards.size == 1, "DeckTest: King not added tto empty Deck!!!")
        assertTrue(deck.hasKing(deck), "DeckTest: King added but function did not find King!!!")
        deck.drawCard()
        assertFalse(deck.hasKing(deck), "DeckTest: King added, found, drawn, but remains in deck!!!")
    }

}