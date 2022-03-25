package Poker

import scala.annotation.tailrec

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

  def suiv: Nombre = this match {
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


class PlayingCard(val nombre: Nombre, val couleur: Couleur) extends Ordered[PlayingCard] {

  override def compare(that: PlayingCard): Int = ComparePC.compare(this, that);

  override def toString: String = stringValue + suitValue

  def stringValue: String = this.nombre.match {
    case Nombre.AS => "A"
    case Nombre.VALET => "V"
    case Nombre.DAME => "D"
    case Nombre.ROI => "R"
    case _ => (valueOf + 1).toString
  }

  def suitValue: String = this.couleur match {
    case Couleur.TREFLE => "♣"
    case Couleur.PIQUE => "♠"
    case Couleur.COEUR => "♥"
    case Couleur.CARREAU => "♦"
  }


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


class PokerHand(val cartes: List[PlayingCard]) extends Ordered[PokerHand] {

  val orderedcartes: List[PlayingCard] = this.cartes.sorted.reverse

  override def compare(that: PokerHand): Int = ComparePH.compare(this, that);
  //def allCurrentCards: List[PlayingCard] = cartes::PokerFlop.cartes::PokerRiver.cartes

  def printHands(): Unit = println("" +
    "Paire: " + isPair + "\n" +
    "Double Paire: " + isTwoPair + "\n" +
    "Brelan: " + isThreeOAK + "\n" +
    "Carré: " + isFourOAK + "\n" +
    "Couleur: " + isFlush + "\n" +
    "Suite: " + isStraight + "\n" +
    "Suite flush: " + isStraightFlush + "\n" +
    "Full: " + isFullHouse + "\n" +
    "Royale: " + isRoyalFlush + "\n")


  def ListeOccurencesNombre: List[Int] = Nombre.values.toList.map(numero => this.cartes.count(_.nombre == numero));

  def ListeOccurencesCouleur: List[Int] = Couleur.values.toList.map(coul => this.cartes.count(_.couleur == coul));

  def ListePlayingCardSorted: List[PlayingCard] = this.cartes.sortWith(_.valueOf > _.valueOf);


  /** Paire */
  def isPair: Boolean = isPairAux(ListeOccurencesNombre, 0)

  def isPairAux(l: List[Int], count: Int): Boolean = l match
    case Nil => count == 1
    case _ => if (l.head == 2) isPairAux(l.tail, count + 1) else isPairAux(l.tail, count)

  /** Deux Paires */
  def isTwoPair: Boolean = isTwoPairAux(ListeOccurencesNombre, 0)

  def isTwoPairAux(l: List[Int], count: Int): Boolean = l match
    case Nil => count == 2
    case _ => if (l.head == 2) isTwoPairAux(l.tail, count + 1) else isTwoPairAux(l.tail, count)

  /** Brelan */
  def isThreeOAK: Boolean = isThreeOAKAux(ListeOccurencesNombre)

  def isThreeOAKAux(l: List[Int]): Boolean = l match
    case Nil => false
    case _ => if (l.head == 3) true else isThreeOAKAux(l.tail)

  /** Grande suite */
  def isStraight: Boolean = isASeriesAux(ListeOccurencesNombre, 0, false, 0, 5)

  def isASeriesAux(l: List[Int], previous: Int, broken: Boolean, count: Int, destination: Int): Boolean = l match
    case Nil => count == destination
    case _ =>
      if (l.head == 1 && (!broken)) isASeriesAux(l.tail, 1, broken, count + 1, destination)
      else if (l.head != 1 && (!broken) && previous == 1) isASeriesAux(l.tail, 0, true, count, destination)
      else if (l.size < 4 && previous != 1 && (!broken)) false
      else isASeriesAux(l.tail, 0, false, count, destination)

  /** Couleur */
  def isFlush: Boolean = isFlushAux(ListeOccurencesCouleur)

  def isFlushAux(l: List[Int]): Boolean = l match
    case Nil => false
    case _ => if (l.head == 5) true else isFlushAux(l.tail)

  //def isStraightFlush: Boolean = isStraight && isFlush

  /** Full */
  //def isFullHouse: Boolean = isPair && isThreeOAK

  /**StraightFlush**/
  def isStraightFlush: Boolean = isStraightFlushAux(ListePlayingCardSorted.sorted,ListePlayingCardSorted.head.couleur,ListePlayingCardSorted.head.nombre,0)
  def isStraightFlushAux(l : List[PlayingCard], couleur: Couleur,nombre: Nombre, counter:Int): Boolean = l match
    case Nil => counter == 5
    case x::xs => if(x.nombre== nombre.suiv) then if(couleur==x.couleur) then isStraightFlushAux(xs, couleur, x.nombre, counter+1) else isStraightFlushAux(xs,couleur,nombre,counter)else if(x.nombre==nombre) then isStraightFlushAux(xs,couleur, nombre, counter) else isStraightFlushAux(xs,couleur, nombre, 0);


  /**Full*/
  //def isFullHouse: Boolean = isPair && isThreeOAK

  def isFullHouse: Boolean = isFullHouseAux(ListePlayingCardSorted,ListePlayingCardSorted.head.nombre,0,false,false)
  def isFullHouseAux(l : List[PlayingCard],nombre: Nombre, counter:Int,Full: Boolean, Pair: Boolean): Boolean = l match
    case Nil => if (Full) then if (counter == 2) then true else false else false
    case x::xs => if(x.nombre==nombre) if (counter == 1) then if (Full) then true else isFullHouseAux(xs,nombre,counter +1,Full,true) else if(counter == 2) then isFullHouseAux(xs,nombre,0,true,false) else if (counter == 0 ) then isFullHouseAux(xs,x.nombre,counter +1,Full,Pair) else isFullHouseAux(xs,x.nombre,counter +1,Full,Pair)  else isFullHouseAux(xs,x.nombre,0,Full,Pair)

  /** Carré */
  def isFourOAK: Boolean = isFourOAKAux(ListeOccurencesNombre)

  def isFourOAKAux(l: List[Int]): Boolean = l match
    case Nil => false
    case _ => if (l.head == 4) true else isFourOAKAux(l.tail)

  /** Suite royale */
  def isRoyalFlush: Boolean = isFlush && isASeriesAux(ListeOccurencesNombre.head :: ListeOccurencesNombre.drop(9), 0, false, 0, 5)

  //def isHighCard: !(isPair || isTwoPair || isThreeOAK || isFourOAK || isStraight || isFlush)

  def valueOf: Int =
    if isRoyalFlush then 9
    else if isStraightFlush then 8
    else if isFourOAK then 7
    else if isFullHouse then 6
    else if isFlush then 5
    else if isStraight then 4
    else if isThreeOAK then 3
    else if isTwoPair then 2
    else if isPair then 1
    else 0

}

object ComparePC extends scala.math.Ordering[PlayingCard] {
  def compare(a: PlayingCard, b: PlayingCard): Int =
    if (a.valueOf > b.valueOf) 1
    else if (a.valueOf < b.valueOf) -1
    else 0
}

object ComparePH extends scala.math.Ordering[PokerHand] {
  def compare(a: PokerHand, b: PokerHand): Int =
    if (a.valueOf > b.valueOf) 1
    else if (a.valueOf < b.valueOf) -1
    else {
      val i: Int = a.valueOf
      val d: Int = getValueOfClashing(i, a, b)
      if(d==0) getHighCard(a,b) else d
    }


  def getValueOfClashing(i: Int, a: PokerHand, b: PokerHand): Int = i match {
    case 1 | 2 => getValueOfHighestPair(a, b)
    case 3 | 6 => getValueOfHighestThree(a, b)
    case 4 | 8 => getValueOfHighestStraight(a, b)
    case 0 | 5 => getHighCard(a, b)
    case 7 => getValueOfHighestFour(a, b)
    case 9 | _ => 0
  }

  def getHighCard(a: PokerHand, b: PokerHand): Int = getHighCardAux(a.orderedcartes,b.orderedcartes)
  @tailrec
  def getHighCardAux(a: List[PlayingCard], b: List[PlayingCard]): Int =
    if (a.nonEmpty && b.nonEmpty) {
      if (a.head.valueOf > b.head.valueOf) 1
      else if (a.head.valueOf < b.head.valueOf) -1
      else getHighCardAux(a.tail, b.tail)
    }
    else 0

  def getValueOfHighestPair(a: PokerHand, b: PokerHand): Int = a.ListeOccurencesNombre.lastIndexOf(2).max(b.ListeOccurencesNombre.lastIndexOf(2))
  def getValueOfHighestThree(a: PokerHand, b: PokerHand): Int = a.ListeOccurencesNombre.lastIndexOf(3).max(b.ListeOccurencesNombre.lastIndexOf(3))
  def getValueOfHighestStraight(a: PokerHand, b: PokerHand): Int = a.ListeOccurencesNombre.lastIndexOf(1).max(b.ListeOccurencesNombre.lastIndexOf(1))
  def getValueOfHighestFour(a: PokerHand, b: PokerHand): Int = a.ListeOccurencesNombre.lastIndexOf(4).max(b.ListeOccurencesNombre.lastIndexOf(4))
}


