import java.io.File

class Game(private var players: List<Player>, private val deck: Deck, private val ruleManager: RuleManager){

    //Exit Code
    private var leaveGame = false
    // Keep Track of whose turn it is
    private var currentPlayerIndex = 0
    //Variable for checking if they want to end the game early so you are not stuck in the game
    private var endEarly = false
    //Track The Turn we are on
    private var turnCount = 1

    //Start game function that gets called in the main file
    fun start(){
        //Make it so the game ends but the program does not, in case you want to play again or restart
        while(!leaveGame){
            println("==========================MENU============================")
            if (isGameOver()){
                println("1. Play Again!")
            }
            else{
                println("1. Play!")
            }
            println("2. Rules of Kings Cup!")
            println("3. Quit :(")
            println("==========================================================")
            println("Please type a single number for your choice:")
            var input = readLine() ?: ""

            //Option to play the game
            if(input == "1"){
                intializeGame()
                println("==========================================================")
                println("Players:")
                for(i in 0..(players.size - 1)){
                    println("${players[i].name}")
                }
                while (!isGameOver()){
                    println("==========================================================")
                    println("Round ${turnCount}; That means ${53 - turnCount} cards left")
                    println("==========================================================")
                    playTurn()
                    turnCount++
                }
                println("GAME OVER! Hope you had fun, stay hydrated! :)")
            }

            //Option to learn the rules
            else if(input == "2"){
                println("===========================RULES============================")
                val ruleFile = "../resources/rulesMenu.txt"
                File(ruleFile).forEachLine { line ->
                    println(line)
                }
                println("============================================================")
                println("Press Enter to go back to the Main Menu!")
                readLine()
            }

            //Option to quit out
            else if(input == "3"){
                leaveGame = true
                return
            }

            //Incorrect Input
            else{
                println("Incorrect Input! A Single Number; No Spaces please!")
            }
        }
    }

    //intialize the game by setting up players and shuffling the deck 4 times
    private fun intializeGame(){
        if(players.isEmpty()){
            players = setupPlayers()
        }
        for (i in 0..3){
            deck.cards.shuffle()
        }
    }

    //Intialize all players when start of game comes around
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

    //Find a player based on the name input
    fun getPlayer(name: String): Player? {
        //return the player found without being case sensitive 
        return players.find{it.name.equals(name, ignoreCase = true)}
    }

    //Where are the turn playing happens
    private fun playTurn(){
        //Find the current player
        val currentPlayer = players[currentPlayerIndex]

        //If the current player has a buddy or buddies display them
        if(!currentPlayer.buddies.isEmpty()){
            val buddiesNames = currentPlayer.buddies.joinToString(separator = ", ") {it.name}
            if (currentPlayer.buddies.size == 1){
                println("Remember ${currentPlayer.name}, your buddy is ${buddiesNames}!")
            }
            else{
                println("Remember ${currentPlayer.name}, your buddies are ${buddiesNames}!")
            }
        }

        //Await the player to press Enter to draw their card
        println("It is ${currentPlayer.name}'s turn. Press Enter to draw a card!")
        readLine()

        //Draw a card
        val card = deck.drawCard()
        if (card != null){

            println("${currentPlayer.name} drew ${card.value} of ${card.suit}")
            println(card)

            val rule = ruleManager.getRule(card.value)
            println("The rule for ${card.value}:${rule?.description ?: "WHERE MY RULE AT?"}!")

            // 8 is Mate Rule
            if (rule?.cardValue == "8"){
                var buddy: Player?
                //while you don't have a valid buddy loop through until they input a valid buddy
                do{
                    println("Choose your Mate!")
                    val buddyName = readLine() ?: ""
                    buddy = getPlayer(buddyName)
                    if(buddy == null){
                        println("Invalid Player to choose as a buddy. You said \"${buddyName}\".")
                    }
                } while(buddy == null)
                //Add the buddies, and display the new buddies
                currentPlayer.addBuddy(buddy)
                println("${currentPlayer.name} is now buddies with ${buddy.name}!")
            }

            //Give option to keep playing to leave the game if you're done
            println("Press Enter to end your turn or type \"done\" to quit the game early.")
            val input = readLine()
            if (input == "done"){
                endEarly = true
            }
        }
        else{
            println("No more cards in the deck.")
        }
        //A circle loop so that current player index continously loops through all players
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size
    }

    //A Check function for the game being over
    private fun isGameOver(): Boolean{
        return deck.cards.isEmpty() || !deck.hasKing(deck) || endEarly
    }

}
