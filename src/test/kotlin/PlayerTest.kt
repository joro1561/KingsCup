import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayerTest{

    @Test
    fun basictesttomakesureIcanmakeaplayerlol(){
        val player = Player("Joey", arrayListOf())
        assertEquals(player.name, "Joey", "PlayerTest: They messed up my name, that's rude.")
    }

    @Test
    fun addingbuddies(){
        val player = Player("Joey", arrayListOf())
        val player2 = Player("Dylan", arrayListOf())
        assertEquals(player.name, "Joey", "PlayerTest: They messed up my name, that's rude.")
        assertEquals(player2.name, "Dylan", "PlayerTest: They messed up my roommates name, that's rude.")

        player.addBuddy(player2)

        assertNotNull(player.buddyList(), "PlayerTest: BuddyList is null so that means we couldn't add buddies :(")
    }

}