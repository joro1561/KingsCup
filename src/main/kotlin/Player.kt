class Player(val name: String, val buddies: ArrayList<Player>){

    // Function to track buddies from 8 is mate card pull
    fun addBuddy(buddy: Player) {
        if (!buddies.contains(buddy)) {
            buddies.add(buddy)
            buddy.buddies.add(this)
        }
    }

    // Return players that are buddies
    // to display on the UI
    fun buddyList(): List<Player> {
        return buddies
    }

}