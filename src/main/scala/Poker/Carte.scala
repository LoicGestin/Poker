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


      def suiv: Nombre = this.nombre match {
        case Nombre.AS => Nombre.DEUX
        case Nombre.DEUX => Nombre.TROIS
        case Nombre.TROIS => Nombre.QUATRE
        case Nombre.QUATRE => Nombre.CINQ
        case Nombre.CINQ => Nombre.SIX
        case Nombre.SIX => Nombre.SEPT
        case Nombre.SEPT => Nombre.HUIT
        case Nombre.HUIT => Nombre.NEUF
        case Nombre.NEUF => Nombre.DIX
        case Nombre.DIX => Nombre.VALET
        case Nombre.VALET => Nombre.DAME
        case Nombre.DAME => Nombre.ROI
        case Nombre.ROI => Nombre.AS
      }

      def getcouleur = this.couleur;
    }



class PokerHand(val cartes: List[PlayingCard]){

  //enum Hands:
  //  case HIGHCARD
  //  case PAIR
  //  case TWOPAIR
  //  case THREEOAK
  //  case STRAIGHT
  //  case FLUSH
  //  case FULLHOUSE
  //  case FOUROAK
  //  case STRAIGHTFLUSH
  //  case ROYALFLUSH

  //def allCurrentCards: List[PlayingCard] = cartes::PokerFlop.cartes::PokerRiver.cartes

  def printHands(): Unit = println("" +
    "Paire: "+isPair+"\n"+
    "Double Paire: "+isTwoPair+"\n"+
    "Brelan: "+isThreeOAK+"\n"+
    "Carré: "+isFourOAK+"\n"+
    "Couleur: "+isFlush+"\n"+
    "Suite: "+isStraight+"\n"+
    "Suite flush: "+isStraightFlush+"\n"+
    "Full: "+isFullHouse+"\n"+
    "Royale: "+isRoyalFlush+"\n")



  def ListeOccurencesNombre: List[Int] = Nombre.values.toList.map(numero => this.cartes.count(_.nombre == numero));
  def ListeOccurencesCouleur: List[Int] = Couleur.values.toList.map(coul => this.cartes.count(_.couleur == coul));

  def ListePlayingCardSorted: List[PlayingCard]= this.cartes.sortWith(_.valueOf > _.valueOf);


  /**Paire*/
  def isPair: Boolean = isPairAux(ListeOccurencesNombre,0)
  def isPairAux(l : List[Int],count: Int): Boolean = l match
    case Nil => count==1
    case _ => if(l.head==2) isPairAux(l.tail,count+1) else isPairAux(l.tail,count)

  //def isPaire2: List[PlayingCard] = isPair2Aux(ListePlayingCard,Nil,0)
  //def isPair2Aux(l : List[PlayingCard],pair: List[PlayingCard],count: Int): Boolean = l match
    //case Nil => pair
    //case l :: next => if(pair == Nil) then 
    //}

  /**Deux Paires*/
  def isTwoPair: Boolean = isTwoPairAux(ListeOccurencesNombre,0)
  def isTwoPairAux(l : List[Int],count: Int): Boolean = l match
    case Nil => count==2
    case _ => if(l.head==2) isTwoPairAux(l.tail,count+1) else isTwoPairAux(l.tail,count)

  /**Brelan*/
  def isThreeOAK: Boolean = isThreeOAKAux(ListeOccurencesNombre)
  def isThreeOAKAux(l : List[Int]): Boolean = l match
    case Nil => false
    case _ => if(l.head==3) true else isThreeOAKAux(l.tail)

  /**Grande suite*/
  def isStraight: Boolean = isASeriesAux(ListeOccurencesNombre,0,false,0,5)
  def isASeriesAux(l : List[Int], previous: Int, broken: Boolean, count: Int, destination: Int): Boolean = l match
    case Nil => count==destination
    case _ =>
      if(l.head==1&&(!broken)) isASeriesAux(l.tail,1,broken,count+1,destination)
      else if(l.head!=1&&(!broken)&&previous==1) isASeriesAux(l.tail,0,true,count,destination)
      else isASeriesAux(l.tail,0,false,count,destination)

  /**Couleur*/
  def isFlush: Boolean = isFlushAux(ListeOccurencesCouleur)
  def isFlushAux(l : List[Int]): Boolean = l match
    case Nil => false
    case _ => if(l.head==5) true else isFlushAux(l.tail)

  def isStraightFlush: Boolean = isStraight&&isFlush

  /**Full*/
  def isFullHouse: Boolean = isPair && isThreeOAK

  /**Carré*/
  def isFourOAK: Boolean = isFourOAKAux(ListeOccurencesNombre)
  def isFourOAKAux(l : List[Int]): Boolean = l match
    case Nil => false
    case _ => if (l.head==4) true else isFourOAKAux(l.tail)

  /**Suite royale*/
  def isRoyalFlush: Boolean = isFlush&&isASeriesAux(ListeOccurencesNombre.head::ListeOccurencesNombre.drop(9),0,false,0,5)

  //def isHighCard: !(isPair || isTwoPair || isThreeOAK || isFourOAK || isStraight || isFlush)

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
}

object ComparePH extends scala.math.Ordering[PokerHand]{
  def compare(a: PokerHand, b: PokerHand): Int = 0

}
/*
object HandIdentifier{
  def getBestHand(a: List[PlayingCard]): String =
    if(a.size!=5) "Invalid list argument"
    else {
      def poker: PokerHand = PokerHand(a)
      if poker.isRoyalFlush then "Royal Flush"
      else if poker.isStraightFlush then "Straight Flush"
      else if poker.isFourOAK then "Four Of A Kind"
      else if poker.isFullHouse then "Full House"
      else if poker.isFlush then "Flush"
      else if poker.isStraight then "Straight"
      
    }


}

*/


