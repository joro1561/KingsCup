// Main.kt
fun main() {
    val players = mutableListOf<Player>()
    val deckFactory = TheDeckFactory()
    val deck = deckFactory.createDeck()
    val ruleManager = RuleManager()
    ruleManager.rulesInit("../resources/rules.txt")
  
    val game = Game(players, deck, ruleManager)
    
    game.start()
}

