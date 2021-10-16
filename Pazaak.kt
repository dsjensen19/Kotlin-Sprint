import java.util.*

fun main() {

    var matchScore = 0

    while (matchScore < 3 && matchScore > -3) {
        var playingMatch = true
        var playerScore = 0
        var npcScore = 0
        var hitMe = true
        var npcPlaying = true
        println("Let's play a game of Pazaak!)")

        println("Time for a match! Your score is 0.")
        while (playingMatch == true) { //One match

            if (hitMe == true) { //The player turn, getting a card and adding a card.

                var nuCard = 0
                nuCard = normDeck()
                playerScore += nuCard
                println("Your card is: $nuCard and your new score is $playerScore")

                var nuPCard = 0
                nuPCard = personalDeck()
                playerScore += nuPCard
            }

            hitMe = takeAnother(playerScore) //deciding if they want to keep going

            if (npcPlaying == true) { //npc take turn
                var npcCard = 0
                npcCard = normDeck()
                npcScore += npcCard
                println("The npc was dealt a $npcCard. it's score is $npcScore")

                var npcPCard = 0
                npcPCard = cheating(npcScore)
                npcScore = npcPCard

            }

            npcPlaying = npcAgain(npcScore)//computer decides if it wants to keep playing

            if (!npcPlaying || !hitMe) {
                var results = 0
                results = winner(playerScore, npcScore)
                matchScore += results
                playingMatch = false
            }





        }
    }
    if (matchScore > 0) {
        print("Congrats! You Won!")

    } else {
        print("Too bad, You Lost!")
    }






}



fun normDeck(): Int {
    //This function deals a card from the deck to the player
    //it returns the points values
    var changer = 0
    val randomValue = 7 + changer
    changer -2
        //{ Random.nextInt(0, 11) }

    return randomValue

}

fun personalDeck(): Int {
    //this function gives the player the opportunity to use a card
    //it takes the remaining cards and returns the points on the card
    println("Would you like to use a card? Your cards are -3, -1, 2, 3, 5 (y/n)")
    val decision = readLine()!!
    if (decision == "n") {

    } else if (decision == "y"){
        val reader = Scanner(System.`in`)
        println("Which would you like to use?")
        var integer:Int = reader.nextInt()
        return integer
    }
    val retVal = 0
    return retVal
}

fun takeAnother(playerScore: Int): Boolean {
    //asks player if they want another card from the deck
    print("Your score is $playerScore. Would you like another card? (y/n)")
    val decision = readLine()!!
    if (decision == "n") {
        return false
    } else {
        return true
    }

}

fun cheating(npcScore:Int): Int {
    //npc gets or loses points to win
    if ((npcScore-20 <3) && (npcScore-20 > -3)) {
        return 20
    } else {
        return npcScore
    }

}

fun npcAgain(npcScore: Int): Boolean {
    //npc decides if it wants to keep playing
    //returns bool
    if (npcScore >= 20) {
        return false
    } else {
        return true
    }

}

fun winner(playerScore: Int, npcScore: Int): Int {
    //logic for what happens if scores exceed 20, etc.
    //returns 0 for nothing, 1 for player win, -1 for player loss
    if (playerScore > 20) {
        if (npcScore > 20) {
            print("You both lost!")
            return 0
        } else {
            print("You lost the match!")
            return -1
        }
    } else {
        if (npcScore > 20) {
          print("You won the match!")
          return 1
        } else {
            if (playerScore > npcScore) {
                print("You won the match!")
                return 1
            } else if (playerScore == npcScore) {
                print("A Tie!")
                return 0
            }else {
                print("You lost the match!")
                return -1
            }
        }
    }
}
