import java.io.File

class RuleManager{
    private val rules: MutableMap<String, Rule> = mutableMapOf()

    // Apart of Kings Card
    fun addRule(rule: Rule) {
        rules[rule.cardValue] = rule
    }

    // Get Rule for whatever card was pulled
    fun getRule(cardValue: String): Rule? {
        return rules[cardValue]
    }

    // Give Every Card it's rule
    fun rulesInit(fileName: String) {
        val rulesFile = File(fileName)
        // Check that file can be opened
        if (!rulesFile.exists()) {
            println("Rule file not found: $fileName")
            return
        }

        // Read all the
        rulesFile.forEachLine { line ->
            val (cardValue, description) = line.split(":")
            addRule(Rule(cardValue, description))
        }
    } 
}