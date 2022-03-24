package Poker

object PokerMain {

  @main def main() =

    def l: List[PlayingCard] = List(PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.TROIS,Couleur.COEUR),PlayingCard(Nombre.QUATRE,Couleur.COEUR),PlayingCard(Nombre.CINQ,Couleur.COEUR),PlayingCard(Nombre.SIX,Couleur.COEUR))
    def pup: PokerHand = PokerHand(l)
    println(pup.ListeOccurencesNombre)
    println(pup.ListeOccurencesCouleur)
    pup.printHands()

    def lol: List[PlayingCard] = List(PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.TROIS,Couleur.COEUR),PlayingCard(Nombre.QUATRE,Couleur.COEUR),PlayingCard(Nombre.CINQ,Couleur.COEUR),PlayingCard(Nombre.SEPT,Couleur.PIQUE))
    def bam: PokerHand= PokerHand(lol)
    println(bam.ListeOccurencesNombre)
    bam.printHands()


    def sussy: List[PlayingCard] = List(PlayingCard(Nombre.AS,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.TREFLE),PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.DEUX,Couleur.PIQUE),PlayingCard(Nombre.ROI,Couleur.PIQUE))
    def pop: PokerHand = PokerHand(sussy)
    println(pop.ListeOccurencesNombre)
    pop.printHands()

    def jedevienne: List[PlayingCard] = List(PlayingCard(Nombre.AS,Couleur.TREFLE),PlayingCard(Nombre.DIX,Couleur.TREFLE),PlayingCard(Nombre.VALET,Couleur.TREFLE),PlayingCard(Nombre.DAME,Couleur.TREFLE),PlayingCard(Nombre.ROI,Couleur.TREFLE))
    def fou: PokerHand = PokerHand(jedevienne)
    println(fou.ListeOccurencesNombre)
    fou.printHands()
}
