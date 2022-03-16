




class Main {


   
   type PlayingCard = String;
   type PokerHand = List[PlayingCard];


   trait ComparePC extends scala.math.Ordering[PlayingCard]{}
   trait ComparePH extends scala.math.Ordering[PokerHand]{}
}


