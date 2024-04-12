// Main.kt
fun main() {
    val players = mutableListOf<Player>()
    val deckFactory = TheDeckFactory()
    val deck = deckFactory.createDeck()
    val ruleManager = RuleManager()
    ruleManager.rulesInit("../resources/rules.txt")
    // val gameUI = GameUI()

    // Eventually add the GameUI to the game start up
    val game = Game(players, deck, ruleManager)
    
    game.start()
}

