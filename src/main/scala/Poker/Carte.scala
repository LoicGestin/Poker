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
    case x::xs => if occurenceNombreCounter(xs,x.getnombre,1)==3 then true else isThreeOAKAux(xs)

  /**Petite suite*/
  def isStraight: Boolean = isStraightAux(this.cartes, this.cartes.head.nombre, 0)
  def isStraightAux(l : List[PlayingCard], num: Nombre, counter:Int): Boolean = l match
    case Nil => counter>=4
    case x::xs => if(occurenceNombreCounter(l,x.suiv,0)>=1) then isStraightAux(l,x.suiv,counter+1) else isStraightAux(xs,x.getnombre,counter);

  /*Couleur*/
  def isFlush(l : List[PlayingCard]): Boolean = l match
    case Nil => false
    case x::Nil => false
    case x::xs => if occurenceCouleurCounter(xs,x.getcouleur,1)==4 then true else isFlushAux(xs)

  /**Full*/
  def isFullHouse(list: List[PlayingCard]): Boolean = isTwoPair && isThreeOAK

  /**Carré*/
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

    def l: List[PlayingCard] = List(PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.TROIS,Couleur.COEUR),PlayingCard(Nombre.QUATRE,Couleur.COEUR),PlayingCard(Nombre.CINQ,Couleur.COEUR),PlayingCard(Nombre.SIX,Couleur.COEUR))
    println("isPair: "+PokerHand(l).isPair)
    println("isTwoPair: "+PokerHand(l).isTwoPair)
    println("isThreeOfAKind: "+PokerHand(l).isThreeOAK)
    //println("isStraight: "+PokerHand(l).isStraight)
    println(Nombre.values.toList.map(numero => l.count(_.nombre == numero)));

    //println("isFlushPair: "+PokerHand(l).isFlush)
    def sussy: List[PlayingCard] = List(PlayingCard(Nombre.AS,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.TREFLE),PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.DEUX,Couleur.PIQUE),PlayingCard(Nombre.ROI,Couleur.PIQUE))
    println(Nombre.values.toList.map(numero => sussy.count(_.nombre == numero)));


  /*println(ComparePC.compare(PlayingCard(Nombre.DEUX,Couleur.PIQUE),PlayingCard(Nombre.QUATRE,Couleur.COEUR)))
  println(ComparePC.compare(PlayingCard(Nombre.HUIT,Couleur.PIQUE),PlayingCard(Nombre.QUATRE,Couleur.COEUR)))
  println(ComparePC.compare(PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.ROI,Couleur.COEUR)))
  println(ComparePC.compare(PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.AS,Couleur.COEUR)))*/

}

object ComparePH extends scala.math.Ordering[PokerHand]{
  def compare(a: PokerHand, b: PokerHand): Int = 0

}




