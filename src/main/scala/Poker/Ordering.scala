package Poker
import Poker.PlayingCard

object ComparePC extends scala.math.Ordering[PlayingCard]{
  def compare(a: PlayingCard, b: PlayingCard): Int =
    if(a.valueOf()>b.valueOf()) 1
    else if(a.valueOf()<b.valueOf()) -1
    else 0


  @main def main =
    println(ComparePC.compare(PlayingCard(Nombre.DEUX,Couleur.PIQUE),PlayingCard(Nombre.QUATRE,Couleur.COEUR)))
    println(ComparePC.compare(PlayingCard(Nombre.HUIT,Couleur.PIQUE),PlayingCard(Nombre.QUATRE,Couleur.COEUR)))
    println(ComparePC.compare(PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.ROI,Couleur.COEUR)))
    println(ComparePC.compare(PlayingCard(Nombre.AS,Couleur.PIQUE),PlayingCard(Nombre.AS,Couleur.COEUR)))


}

class Ordering {



  //object ComparePH extends scala.math.Ordering[Hand]{
  //
  //}




  /*def compatibleSigne(val1: Valeur, recipient: Valeur): Boolean = (donor,recipient) match
    case (Signe.-, _) => true
    case (Signe.+, Signe.+) => true
    case _ => false
  */
}



