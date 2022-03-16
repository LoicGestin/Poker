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
      
      def valueOf(): Int = this.nombre match {
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
