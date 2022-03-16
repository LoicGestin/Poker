
class Ordering {

  def compatibleSigne(val1: Valeur, recipient: Valeur): Boolean = (donor,recipient) match
    case (Signe.-, _) => true
    case (Signe.+, Signe.+) => true
    case _ => false

}
