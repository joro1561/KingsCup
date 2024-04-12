import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RuleManagerTest{

    ruleManager = RuleManager()

    @Test
    fun 'test my ruleInit function even though I know it works'(){
        ruleManager.ruleInit("../main/resources/rules.txt")
        ruleForWhatever = ruleManager.getRule("8")
        assertEquals(ruleForWhatever, " Eight is Mate!", "RuleManagerTest: Play around with this one more can't get the test perfect!!!")
    }

}