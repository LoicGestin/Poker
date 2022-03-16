public class Carte {
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
        case Card(Couleur,Valeur)

    def valueOf(s: String): PlayingCard = s match
        case "A+" => BloodGroup.P(ABO.A, Signe.+)
        case "B+" => BloodGroup.P(ABO.B, Signe.+)
        case "AB+" => BloodGroup.P(ABO.AB, Signe.+)
        case "O+" => BloodGroup.P(ABO.O, Signe.+)
        case "A-" => BloodGroup.P(ABO.A, Signe.-)
        case "B-" => BloodGroup.P(ABO.B, Signe.-)
        case "AB-" => BloodGroup.P(ABO.AB, Signe.-)
        case "O-" => BloodGroup.P(ABO.O, Signe.-)
        case _ => throw new IllegalArgumentException


}

