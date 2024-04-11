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
        rulesFile.forEachLine { line ->
            val (cardValue, description) = line.split(":")
            addRule(Rule(cardValue, description))
        }
    }
}