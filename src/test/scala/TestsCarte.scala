import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.{an, shouldBe, be}
import _root_.Poker._

class TestsCarte extends AnyFlatSpec {
  "Pair" should "be defined" in {
    def l: List[PlayingCard] = List(PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.DEUX,Couleur.COEUR),PlayingCard(Nombre.TROIS,Couleur.COEUR),PlayingCard(Nombre.TROIS,Couleur.COEUR))
    PokerHand(l).isPair shouldBe(true)
    //PokerHand(l).isTwoPair shouldBe(true)
  }
}
