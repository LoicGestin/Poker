package Poker

    enum Couleur:
      case PIQUE
      case COEUR
      case CARREAU
      case TREFLE

    enum Nombre:

      case AS
      case DEUX
      case TROIS
      case QUATRE
      case CINQ
      case SIX
      case SEPT
      case HUIT
      case NEUF
      case DIX
      case VALET
      case DAME
      case ROI


    class PlayingCard(val nombre: Nombre, val couleur: Couleur){

      def valueOf: Int = this.nombre match {
        case Nombre.AS => 13
        case Nombre.DEUX => 1
        case Nombre.TROIS => 2
        case Nombre.QUATRE => 3
        case Nombre.CINQ => 4
        case Nombre.SIX => 5
        case Nombre.SEPT => 6
        case Nombre.HUIT => 7
        case Nombre.NEUF => 8
        case Nombre.DIX => 9
        case Nombre.VALET => 10
        case Nombre.DAME => 11
        case Nombre.ROI => 12
      }
    }

class PokerHand(val cartes: List[PlayingCard]){

  enum Hands:
    case HIGHCARD
    case PAIR
    case TWOPAIR
    case THREEOAK
    case STRAIGHT
    case FLUSH
    case FULLHOUSE
    case FOUROAK
    case STRAIGHTFLUSH
    case ROYALFLUSH

  def allCurrentCards: List[PlayingCard] = cartes::PokerFlop.cartes::PokerRiver.cartes
  def occurenceCounter(l: List[PlayingCard], v: valeur, Int: curr): Int = a.head.valueOf match {
    case valeur => occurenceCounter(l.tail,v+1)
    case Nil => 0
    case _ => occurenceCounter(l.tail,v)
  }

  /*Paire*/
  def isPair: Boolean = occurenceCounter(allCurrentCards,allCurrentCards.head.valueOf,0)

  /*Deux Paires*/
  def isTwoPair: Boolean = true

  /*Brelan*/
  def isThreeOAK: Boolean = true

  /*Petite suite*/
  def isStraight: Boolean = true

  /*Couleur*/
  def isFlush: Boolean = true

  /*Full*/
  def isFullHouse: Boolean = true

  /*Carré*/
  def isFourOAK: Boolean = true

  /*Grande suite*/
  def isStraightFlush: Boolean = true

  /*Suite royale*/
  def isRoyalFlush: Boolean = true


}

object PokerFlop(val cartes: List[PlayingCard]){
}
object PokerRiver(val cartes: List[PlayingCard]){

}


object ComparePC extends scala.math.Ordering[PlayingCard] {
  def compare(a: PlayingCard, b: PlayingCard): Int =
    if (a.valueOf > b.valueOf) 1
    else if (a.valueOf < b.valueOf) -1
    else 0


  @main def main =
    println(ComparePC.compare(PlayingCard(Nombre.DEUX,Couleur.PIQUE),PlayingCard(Nombre.QUATRE,Couleur.COEUR)))
    println(ComparePC.compare(PlayingCard(Nombre.HUIT,Couleur.PIQUE),PlayingCard(Nombre.QUATRE,Couleur.COEUR)))
    println(ComparePC.compare(PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.ROI,Couleur.COEUR)))
    println(ComparePC.compare(PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.AS,Couleur.COEUR)))

}

object ComparePH extends scala.math.Ordering[PokerHand]{
  def compare(a: PokerHand, b: PokerHand): Int = 0

}
