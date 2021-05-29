/** Une classe liste FIFO. */
case class Queue[T](in:List[T] = Nil, out:List[T] = Nil) {
  /** Ajoute un élément `x` en tête. */
  def enqueue(x:T):Queue[T] = {
    Queue[T](x::in,out)
  }

  /** Retire le dernier élément. */
  def dequeue():(T,Queue[T]) = out match {
    case Nil =>
      val head :: tail = in.reverse
      (head,Queue[T](Nil, tail))
    case x :: xs => (x, Queue[T](in, xs))
  }

  /** Accès au premier élément, s'il existe (dernier élément entré). */
  def headOption():Option[T] = {
    if(isEmpty) return Option.empty
    if(in.isEmpty) return Option(out.last)
    Option(in.head)
  }

  /** Vrai si la liste est vide. */
  def isEmpty:Boolean = in.isEmpty && out.isEmpty
}