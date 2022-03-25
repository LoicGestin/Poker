package Poker

import scala.util.Random

object PokerMain {

  @main def main() =

    //val deck = List(FrenchDeck().generateDeck);
    //Random.shuffle(deck);
    //val flop = PokerFlop(List(deck.drop(3)));
    //val river = PokerRiver(List(deck.drop(2)));


    /*def sussy: List[PlayingCard] = List(PlayingCard(Nombre.DAME,Couleur.COEUR),PlayingCard(Nombre.ROI,Couleur.COEUR),PlayingCard(Nombre.AS,Couleur.COEUR),PlayingCard(Nombre.TROIS,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.COEUR))
    def pop: PokerHand = PokerHand(sussy)
    println(pop.ListeOccurencesNombre)
    pop.printHands()

    def jedevienne: List[PlayingCard] = List(PlayingCard(Nombre.AS,Couleur.TREFLE),PlayingCard(Nombre.DIX,Couleur.TREFLE),PlayingCard(Nombre.VALET,Couleur.TREFLE),PlayingCard(Nombre.DAME,Couleur.TREFLE),PlayingCard(Nombre.ROI,Couleur.TREFLE))
    def fou: PokerHand = PokerHand(jedevienne)
    println(fou.ListeOccurencesNombre)
    fou.printHands()*/

    val r = scala.util.Random
    val deck = FrenchDeck.deck
    //println("Taille du deck: "+deck.size)
    //println(deck.toString)

    //println(shuffled.toString)
    val player1: PokerHand = PokerHand(r.shuffle(deck).take(5))
    //println(player1.cartes.toString)
    println("Main joueur 1: "+player1.orderedcartes.toString)

    val player2: PokerHand = PokerHand(r.shuffle(deck).takeRight(5))
    //println(player2.cartes.toString)
    println("Main joueur 2: "+player2.orderedcartes.toString)

    println(player1.ListeOccurencesNombre)
    println(player2.ListeOccurencesNombre)

    println("\n-----\n")
    player1.printHands()
    player2.printHands()

    val fight: Int = ComparePH.compare(player1,player2)
    if(fight == 1) println("Joueur 1 wins")
    else if (fight == -1) println("Joueur 2 wins")
    else println("Draw")

    /*shuffled = r.shuffle(shuffled)
    val p2hand: List[PlayingCard] = shuffled.take(5)
    val player2: PokerHand = PokerHand(p2hand)
    println(player2.cartes.toString)
    println(player2.orderedcartes.toString)*/
  

}

object FrenchDeck:
  def deck: List[PlayingCard] = List(
    PlayingCard(Nombre.AS,Couleur.TREFLE),
    PlayingCard(Nombre.AS,Couleur.COEUR),
    PlayingCard(Nombre.AS,Couleur.CARREAU),
    PlayingCard(Nombre.AS,Couleur.PIQUE),

    PlayingCard(Nombre.DEUX,Couleur.TREFLE),
    PlayingCard(Nombre.DEUX,Couleur.COEUR),
    PlayingCard(Nombre.DEUX,Couleur.CARREAU),
    PlayingCard(Nombre.DEUX,Couleur.PIQUE),

    PlayingCard(Nombre.TROIS,Couleur.TREFLE),
    PlayingCard(Nombre.TROIS,Couleur.COEUR),
    PlayingCard(Nombre.TROIS,Couleur.CARREAU),
    PlayingCard(Nombre.TROIS,Couleur.PIQUE),

    PlayingCard(Nombre.QUATRE,Couleur.TREFLE),
    PlayingCard(Nombre.QUATRE,Couleur.COEUR),
    PlayingCard(Nombre.QUATRE,Couleur.CARREAU),
    PlayingCard(Nombre.QUATRE,Couleur.PIQUE),

    PlayingCard(Nombre.CINQ,Couleur.TREFLE),
    PlayingCard(Nombre.CINQ,Couleur.COEUR),
    PlayingCard(Nombre.CINQ,Couleur.CARREAU),
    PlayingCard(Nombre.CINQ,Couleur.PIQUE),

    PlayingCard(Nombre.SIX,Couleur.TREFLE),
    PlayingCard(Nombre.SIX,Couleur.COEUR),
    PlayingCard(Nombre.SIX,Couleur.CARREAU),
    PlayingCard(Nombre.SIX,Couleur.PIQUE),

    PlayingCard(Nombre.SEPT,Couleur.TREFLE),
    PlayingCard(Nombre.SEPT,Couleur.COEUR),
    PlayingCard(Nombre.SEPT,Couleur.CARREAU),
    PlayingCard(Nombre.SEPT,Couleur.PIQUE),

    PlayingCard(Nombre.HUIT,Couleur.TREFLE),
    PlayingCard(Nombre.HUIT,Couleur.COEUR),
    PlayingCard(Nombre.HUIT,Couleur.CARREAU),
    PlayingCard(Nombre.HUIT,Couleur.PIQUE),

    PlayingCard(Nombre.NEUF,Couleur.TREFLE),
    PlayingCard(Nombre.NEUF,Couleur.COEUR),
    PlayingCard(Nombre.NEUF,Couleur.CARREAU),
    PlayingCard(Nombre.NEUF,Couleur.PIQUE),

    PlayingCard(Nombre.DIX,Couleur.TREFLE),
    PlayingCard(Nombre.DIX,Couleur.COEUR),
    PlayingCard(Nombre.DIX,Couleur.CARREAU),
    PlayingCard(Nombre.DIX,Couleur.PIQUE),

    PlayingCard(Nombre.VALET,Couleur.TREFLE),
    PlayingCard(Nombre.VALET,Couleur.COEUR),
    PlayingCard(Nombre.VALET,Couleur.CARREAU),
    PlayingCard(Nombre.VALET,Couleur.PIQUE),

    PlayingCard(Nombre.DAME,Couleur.TREFLE),
    PlayingCard(Nombre.DAME,Couleur.COEUR),
    PlayingCard(Nombre.DAME,Couleur.CARREAU),
    PlayingCard(Nombre.DAME,Couleur.PIQUE),

    PlayingCard(Nombre.ROI,Couleur.TREFLE),
    PlayingCard(Nombre.ROI,Couleur.COEUR),
    PlayingCard(Nombre.ROI,Couleur.CARREAU),
    PlayingCard(Nombre.ROI,Couleur.PIQUE),
  )