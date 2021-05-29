/** Une classe liste FIFO. */
case class Queue[T](in:List[T] = Nil, out:List[T] = Nil) {
  /**
   * Ajoute un élément `x` en tête.
   * @param x Élément à ajouter
   * @return Nouvel queue avec l'élément inséré
   */
  def enqueue(x:T):Queue[T] = Queue[T](x::in,out)

  /**
   * Retire le dernier élément.
   * @return Tuple contenant l'élément retiré (Option.empty si vide) et une nouvel queue
   */
  def dequeue:(Option[T],Queue[T]) = out match {
    case Nil if isEmpty => (Option.empty, Queue[T](Nil,Nil))
    case Nil =>
      val head :: tail = in.reverse
      (Option(head),Queue[T](Nil, tail))
    case x :: xs => (Option(x), Queue[T](in, xs))
  }

  /**
   * Accès au premier élément, s'il existe (dernier élément entré).
   * @return Si vide Option.empty sinon la tête de la queue
   */
  def headOption:Option[T] = {
    if(isEmpty) return Option.empty
    if(in.isEmpty) return Option(out.last)
    Option(in.head)
  }

  /**
   * Accès au dernier élément, s'il existe (premier élément entré).
   * @return Si vide Option.empty sinon la queue de la queue
   */
  def rearOption: Option[T] = {
    if(isEmpty) return Option.empty
    if(out.nonEmpty) return Option(out.head)
    Option(in.last)
  }

  /**
   * Retourne une queue d'un nouvel élément convertie grâce à une méthode passé en paramètre
   * @param f Fonction appliquée
   * @tparam T2 Type de la queue après application de f
   * @return Une Queue[T2] contenant les éléments une fois la fonction appliquée
   */
  def map[T2](f: T => T2): Queue[T2] = Queue(in.map(f), out.map(f))

  /**
   * Methode qui effectue une fonction f entre chaque éléments de la queue
   * @param const Valeur initiale
   * @param f Fonction appliquer entre 2 éléments
   * @tparam T2 Type de la queue après application de f
   * @return Un élément de type T2
   */
  def foldLeft[T2](const: T2)(f: (T2, T) => T2): T2 = {
    out.foldRight(
      in.foldLeft(const)(f)
    )((a, b) => f(b, a))
  }

  /**
   * Converti la Queue en liste simplement chaînée
   * @return List[T] Liste combinant in et out
   */
  def toList: List[T] = in ::: out.reverse

  /**
   * Vrai si la liste est vide.
   * @return boolean vrai si vide faux sinon
   */
  def isEmpty:Boolean = (in, out) match {
    case (Nil, Nil) => true
    case _ => false
  }

  /**
   * Retourne la longueur de in et out
   * @return Entier définissant la taille de la queue
   */
  def length:Int = in.length + out.length
}