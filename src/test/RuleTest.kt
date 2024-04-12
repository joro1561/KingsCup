import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RuleTest{

    @Test
    fun 'literally just make a rule bruh'(){
        rule = Rule("8", "Test")
        assertEquals(rule.cardValue, "8", "RuleTest: CardValue Does not match what I set it to for the Rule!!!")
        assertEquals(rule.description, "Test", "RuleTest: Description Does not match what I set it to for the Rule!!!")
    }

}