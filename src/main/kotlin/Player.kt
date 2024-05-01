class Player(val name: String, val buddies: ArrayList<Player>){

    // Function to track buddies from 8 is mate card pull
    fun addBuddy(buddy: Player) {
        if (!buddies.contains(buddy)) {
            buddies.add(buddy)
            buddy.buddies.add(this)

            //Added this so that loops of buddies can be created
            // Essentially when A and B are already buddies and then B and C become buddies
            // We want A and C to also become buddies
            for(existingBuddy in buddies){
                if(existingBuddy != buddy){
                    existingBuddy.addBuddy(buddy)
                    buddy.addBuddy(existingBuddy)
                }
            }
        }
    }

    // Return players that are buddies
    fun buddyList(): List<Player> {
        return buddies.toList()
    }

}