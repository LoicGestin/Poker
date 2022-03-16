class Carte {

    enum Couleur:
      case PIQUE
      case COEUR
      case CARREAU
      case TREFLE

    enum Valeur:
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

    enum PlayingCard:
      case P(c:Couleur,v:Valeur)

    def valueOf(s: String): PlayingCard = s match
      case "COEUR AS" => PlayingCard.P(Couleur.COEUR, Valeur.AS)
      case "COEUR DEUX" => PlayingCard.P(Couleur.COEUR, Valeur.DEUX)
      case "COEUR TROIS" => PlayingCard.P(Couleur.COEUR, Valeur.TROIS)
      case "COEUR QUATRE" => PlayingCard.P(Couleur.COEUR, Valeur.QUATRE)
      case "COEUR CINQ" => PlayingCard.P(Couleur.COEUR, Valeur.CINQ)
      case "COEUR SIX" => PlayingCard.P(Couleur.COEUR, Valeur.SIX)
      case "COEUR SEPT" => PlayingCard.P(Couleur.COEUR, Valeur.SEPT)
      case "COEUR HUIT" => PlayingCard.P(Couleur.COEUR, Valeur.HUIT)
      case "COEUR NEUF" => PlayingCard.P(Couleur.COEUR, Valeur.NEUF)
      case "COEUR DIX" => PlayingCard.P(Couleur.COEUR, Valeur.DIX)
      case "COEUR VALE" => PlayingCard.P(Couleur.COEUR, Valeur.VALET)
      case "COEUR DAME" => PlayingCard.P(Couleur.COEUR, Valeur.DAME)
      case "COEUR ROI" => PlayingCard.P(Couleur.COEUR, Valeur.ROI)
      case "PIQUE AS" => PlayingCard.P(Couleur.PIQUE, Valeur.AS)
      case "PIQUE DEUX" => PlayingCard.P(Couleur.PIQUE, Valeur.DEUX)
      case "PIQUE TROIS" => PlayingCard.P(Couleur.PIQUE, Valeur.TROIS)
      case "PIQUE QUATRE" => PlayingCard.P(Couleur.PIQUE, Valeur.QUATRE)
      case "PIQUE CINQ" => PlayingCard.P(Couleur.PIQUE, Valeur.CINQ)
      case "PIQUE SIX" => PlayingCard.P(Couleur.PIQUE, Valeur.SIX)
      case "PIQUE SEPT" => PlayingCard.P(Couleur.PIQUE, Valeur.SEPT)
      case "PIQUE HUIT" => PlayingCard.P(Couleur.PIQUE, Valeur.HUIT)
      case "PIQUE NEUF" => PlayingCard.P(Couleur.PIQUE, Valeur.NEUF)
      case "PIQUE DIX" => PlayingCard.P(Couleur.PIQUE, Valeur.DIX)
      case "PIQUE VALE" => PlayingCard.P(Couleur.PIQUE, Valeur.VALET)
      case "PIQUE DAME" => PlayingCard.P(Couleur.PIQUE, Valeur.DAME)
      case "PIQUE ROI" => PlayingCard.P(Couleur.PIQUE, Valeur.ROI)
      case "CARREAU AS" => PlayingCard.P(Couleur.CARREAU, Valeur.AS)
      case "CARREAU DEUX" => PlayingCard.P(Couleur.CARREAU, Valeur.DEUX)
      case "CARREAU TROIS" => PlayingCard.P(Couleur.CARREAU, Valeur.TROIS)
      case "CARREAU QUATRE" => PlayingCard.P(Couleur.CARREAU, Valeur.QUATRE)
      case "CARREAU CINQ" => PlayingCard.P(Couleur.CARREAU, Valeur.CINQ)
      case "CARREAU SIX" => PlayingCard.P(Couleur.CARREAU, Valeur.SIX)
      case "CARREAU SEPT" => PlayingCard.P(Couleur.CARREAU, Valeur.SEPT)
      case "CARREAU HUIT" => PlayingCard.P(Couleur.CARREAU, Valeur.HUIT)
      case "CARREAU NEUF" => PlayingCard.P(Couleur.CARREAU, Valeur.NEUF)
      case "CARREAU DIX" => PlayingCard.P(Couleur.CARREAU, Valeur.DIX)
      case "CARREAU VALE" => PlayingCard.P(Couleur.CARREAU, Valeur.VALET)
      case "CARREAU DAME" => PlayingCard.P(Couleur.CARREAU, Valeur.DAME)
      case "CARREAU ROI" => PlayingCard.P(Couleur.CARREAU, Valeur.ROI)
      case "TREFLE AS" => PlayingCard.P(Couleur.TREFLE, Valeur.AS)
      case "TREFLE DEUX" => PlayingCard.P(Couleur.TREFLE, Valeur.DEUX)
      case "TREFLE TROIS" => PlayingCard.P(Couleur.TREFLE, Valeur.TROIS)
      case "TREFLE QUATRE" => PlayingCard.P(Couleur.TREFLE, Valeur.QUATRE)
      case "TREFLE CINQ" => PlayingCard.P(Couleur.TREFLE, Valeur.CINQ)
      case "TREFLE SIX" => PlayingCard.P(Couleur.TREFLE, Valeur.SIX)
      case "TREFLE SEPT" => PlayingCard.P(Couleur.TREFLE, Valeur.SEPT)
      case "TREFLE HUIT" => PlayingCard.P(Couleur.TREFLE, Valeur.HUIT)
      case "TREFLE NEUF" => PlayingCard.P(Couleur.TREFLE, Valeur.NEUF)
      case "TREFLE DIX" => PlayingCard.P(Couleur.TREFLE, Valeur.DIX)
      case "TREFLE VALE" => PlayingCard.P(Couleur.TREFLE, Valeur.VALET)
      case "TREFLE DAME" => PlayingCard.P(Couleur.TREFLE, Valeur.DAME)
      case "TREFLE ROI" => PlayingCard.P(Couleur.TREFLE, Valeur.ROI)

      case _ => throw new IllegalArgumentException

}
