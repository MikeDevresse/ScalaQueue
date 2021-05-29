import scala.annotation.tailrec

/** Une classe liste FIFO. */
case class Queue[T](in:List[T] = Nil, out:List[T] = Nil) {
  /** Ajoute un élément `x` en tête. */
  def enqueue(x:T):Queue[T] = {
    Queue[T](x::in,out)
  }

  /** Retire le dernier élément. */
  def dequeue():(Option[T],Queue[T]) = out match {
    case Nil if isEmpty => (Option.empty, Queue[T](Nil,Nil))
    case Nil =>
      val head :: tail = in.reverse
      (Option(head),Queue[T](Nil, tail))
    case x :: xs => (Option(x), Queue[T](in, xs))
  }

  /** Accès au premier élément, s'il existe (dernier élément entré). */
  def headOption():Option[T] = {
    if(isEmpty) return Option.empty
    if(in.isEmpty) return Option(out.last)
    Option(in.head)
  }

  /** Retourne le dernier élément de la queue */
  def rearOption(): Option[T] = {
    if(isEmpty) Option.empty
    if(out.nonEmpty) return Option(out.head)
    Option(in.last)
  }

  /** Retourne une queue d'un nouvel élément convertie grâce à une méthode passé en paramètre */
  def map[T2](f: T => T2): Queue[T2] = {
    Queue(in.map(f), out.map(f))
  }

  def foldLeft[T2](const: T2)(f: (T2, T) => T2): T2 = {
    out.foldRight(
      in.foldLeft(const)(f)
    )((a, b) => f(b, a))
  }

  /** Converti la Queue en liste simplement chaînée */
  def toList: List[T] = in ::: out.reverse

  /** Vrai si la liste est vide. */
  def isEmpty:Boolean = (in, out) match {
    case (Nil, Nil) => true
    case _ => false
  }

  /** Retourne la longueur de in et out */
  def length:Int = in.length + out.length
}