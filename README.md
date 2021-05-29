# ScalaQueu

## Travail à réaliser
1. Implantez les méthodes de la classe Queue telles que listées ci-dessous.
2. Implantez une méthode length qui retourne la taille de le queue.
3. Implantez une méthode rearOption qui retourne le dernier élément de la queue (celui inséré
   en premier) sans la modifier.
4. Implantez une méthode toList qui convertit la Queue en liste simplement chaînée.
5. Implantez une méthode map sur Queue.
6. Implantez une méthode foldLeft sur Queue.
7. La méthode dequeue est partielle. Corrigez-la.
8. Ré-implantez isEmpty avec match.
9. Définissez un ensemble de tests exhaustifs dans un main. Nous n’avons pas encore vu de
   système de tests unitaires, mais suivez cette façon de faire


### Structure de donnée
```SCALA
/** Une classe liste FIFO. */
case class Queue[T](in:List[T] = Nil, out:List[T] = Nil) {
    /** Ajoute un élément `x` en tête. */
    def enqueue(x:T):Queue[T] = ???
    /** Retire le dernier élément. */
    def dequeue():(T,Queue[T]) = ???
    /** Accès au premier élément, s'il existe (dernier élément entré). */
    def headOption():Option[T] = ???
    /** Vrai si la liste est vide. */
    def isEmpty:Boolean = in.isEmpty && out.isEmpty
}
```
