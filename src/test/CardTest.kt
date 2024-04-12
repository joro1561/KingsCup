import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CardTest{

    @Test
    fun 'test Making Cards'(){
        val card = Card("Spades", "7")
        assertEquals("Spades", card.suit, "CardTest: Suit Test Failed")
        assertEquals("7", card.value, "CardTest: Value Test Failed")
    }

}