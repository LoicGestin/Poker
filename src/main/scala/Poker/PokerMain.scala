package Poker

object PokerMain {

  @main def main() =
    val de = 0;

    //val deck = List(FrenchDeck().generateDeck);
    //Random.shuffle(deck);
    //val flop = PokerFlop(List(deck.drop(3)));
    //val river = PokerRiver(List(deck.drop(2)));


    def sussy: List[PlayingCard] = List(PlayingCard(Nombre.AS,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.TREFLE),PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.DEUX,Couleur.PIQUE),PlayingCard(Nombre.ROI,Couleur.PIQUE))
    def pop: PokerHand = PokerHand(sussy)
    println(pop.ListeOccurencesNombre)
    pop.printHands()

    def jedevienne: List[PlayingCard] = List(PlayingCard(Nombre.AS,Couleur.TREFLE),PlayingCard(Nombre.DIX,Couleur.TREFLE),PlayingCard(Nombre.VALET,Couleur.TREFLE),PlayingCard(Nombre.DAME,Couleur.TREFLE),PlayingCard(Nombre.ROI,Couleur.TREFLE))
    def fou: PokerHand = PokerHand(jedevienne)
    println(fou.ListeOccurencesNombre)
    fou.printHands()
}
