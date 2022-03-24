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

      def getnombre = this.nombre;

      def getcouleur = this.couleur;
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

  //def allCurrentCards: List[PlayingCard] = cartes::PokerFlop.cartes::PokerRiver.cartes

  // Compte le nombre de cartes avec le meme "Carte.nombre" donné en argument dans une liste de cartes
  def occurenceNombreCounter(l: List[PlayingCard], v: Nombre, curr:Int): Int = l match {
    case Nil => curr
    case x::xs => if(x.getnombre==v) occurenceNombreCounter(xs,v,curr+1) else occurenceNombreCounter(xs,v,curr)
  }

  // Compte le nombre de cartes avec le meme "Carte.couleur" donné en argument dans une liste de cartes
  def occurenceCouleurCounter(l: List[PlayingCard], v: Couleur, curr:Int): Int = l match {
    case Nil => curr
    case x::xs => if(x.getcouleur==v) occurenceCouleurCounter(xs,v,curr+1) else occurenceCouleurCounter(xs,v,curr)
  }


  /*Paire*/
  def isPair(l : List[PlayingCard]): Boolean = l match
    case Nil => false
    case x::Nil => false
    case x::xs => if occurenceNombreCounter(xs,x.getnombre,1)==2 then true else isPair(xs)

  //occurenceCounter(allCurrentCards,allCurrentCards.head.valueOf,0)

  /*Deux Paires*/
  def isTwoPair(l : List[PlayingCard],counterPair: Int): Boolean = l match
    case Nil => false
    case x::Nil => false
    case x::xs => if occurenceNombreCounter(xs,x.getnombre,1)==2 then if(counterPair==2)then true else isPair(xs) else isPair(xs)

  /*Brelan*/
  def isThreeOAK(l : List[PlayingCard]): Boolean = l match
    case Nil => false
    case x::Nil => false
    case x::xs => if occurenceNombreCounter(xs,x.getnombre,1)==3 then true else isPair(xs)

  /*Petite suite*/
  def isStraight: Boolean = true

  /*Couleur*/
  def isFlush(l : List[PlayingCard]): Boolean = l match
    case Nil => false
    case x::Nil => false
    case x::xs => if occurenceCouleurCounter(xs,x.getcouleur,1)==4 then true else isFlush(xs)
  /*Full*/
  def isFullHouse: Boolean = true

  /*Carré*/
  def isFourOAK(l : List[PlayingCard]): Boolean = l match
    case Nil => false
    case x::Nil => false
    case x::xs => if occurenceNombreCounter(xs,x.getnombre,1)==4 then true else isFourOAK(xs)

  /*Grande suite*/
  def isStraightFlush: Boolean = true

  /*Suite royale*/
  def isRoyalFlush: Boolean = true


}

class PokerFlop(val cartes: List[PlayingCard]){

}
class PokerRiver(val cartes: List[PlayingCard]){

}


object ComparePC extends scala.math.Ordering[PlayingCard] {
  def compare(a: PlayingCard, b: PlayingCard): Int =
    if (a.valueOf > b.valueOf) 1
    else if (a.valueOf < b.valueOf) -1
    else 0


  @main def main =

    def l: List[PlayingCard] = List(PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.QUATRE,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.COEUR))
    println("ispair :"+PokerHand(l).isPair(l))
    println("isTwopair :"+PokerHand(l).isTwoPair(l,0))
    println("isFlushpair :"+PokerHand(l).isFlush(l))



  /*println(ComparePC.compare(PlayingCard(Nombre.DEUX,Couleur.PIQUE),PlayingCard(Nombre.QUATRE,Couleur.COEUR)))
  println(ComparePC.compare(PlayingCard(Nombre.HUIT,Couleur.PIQUE),PlayingCard(Nombre.QUATRE,Couleur.COEUR)))
  println(ComparePC.compare(PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.ROI,Couleur.COEUR)))
  println(ComparePC.compare(PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.AS,Couleur.COEUR)))*/

}

object ComparePH extends scala.math.Ordering[PokerHand]{
  def compare(a: PokerHand, b: PokerHand): Int = 0

}




