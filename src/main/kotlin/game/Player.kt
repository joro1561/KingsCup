class Player(val name: String, var status: Boolean, val buddies: ArrayList<PLayer>){

    // Function to track buddies from 8 is mate card pull
    fun addBuddy(buddy: Player){
        if (!buddies.contains(buddy)){
            buddies.add(buddy)
        }
    }

    // Return players that are buddies
    fun getBuddies(player_name: Player){
        if player_name.buddies.isEmpty(){
            for(buddy in player_name.buddies){
                println(buddy)
            }
        }
    }

    // Loop for who's turn it is
    fun turnLoop(prevPlayer: Player, currPlayer: Player){
        if prevPlayer{
            prevPlayer.status = False
            currPlayer.status = True
        }
        else{
            currPlayer.status = True
        }
    }
}