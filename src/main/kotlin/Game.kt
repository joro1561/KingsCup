// Add GameUI when we have a UI
class Game(private var players: List<Player>, private val deck: Deck, private val ruleManager: RuleManager){

    // Keep Track of whose turn it is
    private var currentPlayerIndex = 0

    //TODO: Add in while loop a check over the player ending their turn
    fun start(){
        intializeGame()
        while (!isGameOver()){
            playTurn()
        }
        println("GAME OVER! Hope you had fun :)")
        // finishGame()
        return
    }

    // TODO: Add visual for this
    // Ask them if they want to shuffle the deck again
    private fun intializeGame(){
        if(players.isEmpty()){
            players = setupPlayers()
        }
        for (i in 0..3){
            deck.cards.shuffle()
        }
    }

    // TODO: Currently asks for direct input, need to make the input UI based
    fun setupPlayers(): List<Player> {
        println("How many people are playing: ")
        val playerCount = readLine()?.toIntOrNull() ?: 0
        val newPlayers = mutableListOf<Player>()
        
        for (i in 1..playerCount) {
            println("Enter name for player $i:")
            val name = readLine() ?: "Player $i" 
            newPlayers.add(Player(name, arrayListOf()))
        }
        
        return newPlayers
    }

    // TODO: Add visual for drawing card and displaying the rule
    private fun playTurn(){
        val currentPlayer = players[currentPlayerIndex]

        // TEMPORARY BEFORE UI INTEGRATION
        println("It is ${currentPlayer.name}'s turn. Press Enter to draw a card!")
        readLine()
        // TEMPORARY BEFORE UI INTEGRATION

        val card = deck.drawCard()
        if (card != null){
            
            // TEMPORARY BEFORE UI INTEGRATION
            println("${currentPlayer.name} drew ${card.value} of ${card.suit}")
            println(card)

            // TEMPORARY BEFORE UI INTEGRATION

            val rule = ruleManager.getRule(card.value)

            // TEMPORARY BEFORE UI INTEGRATION
            println("The rule for ${card.value} is ${rule?.description ?: "WHERE MY RULE AT?"}!")
            // TEMPORARY BEFORE UI INTEGRATION

            // Display the rule
            // Wait for the player to click Done
            
            // If the card was an 8, prompt again but for the player to select a buddy
            // if (card.value == "8"){
            //     val selectedBuddy = gameUI.promptForBuddy(player, players)
            //     player.addBuddy(selectedBuddy)
            //     updateBuddyDisplay()
            // }
            
            // Update the currentPlayerIndex

            // TEMPORARY BEFORE UI INTEGRATION
            println("Press Enter to end your turn.")
            readLine()
            // TEMPORARY BEFORE UI INTEGRATION
        }
        else{
            println("No more cards in the deck.")
        }
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size
    }

    // Add in once we have a UI
    // private fun updateBuddyDisplay() {
    //     for (player in players) {
    //         gameUI.displayBuddies(player, player.getBuddies())
    //     }
    // }

    private fun isGameOver(): Boolean{
        return deck.cards.isEmpty() || !deck.hasKing(deck)
    }

    // TODO: Show in UI that the game has concluded
    // private fun finishGame(){
    //     return
    // }
}
