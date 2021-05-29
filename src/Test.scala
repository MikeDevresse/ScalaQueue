object Test {
  def main(args: Array[String]): Unit = {
    println("\n**** Tests basiques ****")
    println("\n** QUEUE1")
    val queue1 = Queue[Int](Nil, Nil)
    printQueue(queue1)

    println("\n** TEST DEQUEUE VIDE")
    val dequeue1 = queue1.dequeue()
    println("Dequeue: " + dequeue1._1)
    printQueue(dequeue1._2)

    val queue2 = queue1.enqueue(1)
    println("\n** QUEUE2")
    printQueue(queue2)

    val queue3 = queue2.enqueue(2)
    println("\n** QUEUE3")
    printQueue(queue3)

    val queue4 = queue3.enqueue(3)
    println("\n** QUEUE4")
    printQueue(queue4)

    println("\n** QUEUE5")
    val dequeue5 = queue4.dequeue()
    println("Dequeue: " + dequeue5._1)
    printQueue(dequeue5._2)

    /** Ajoute 1 à chaque élément de notre liste */
    println("\n**** Test map ****")
    val queue6 = dequeue5._2.map(y => y + 1)
    printQueue(queue6)

    /** Addition de l'ensemble  */
    println("\n**** Test foldLeft ****")
    printQueue(queue4)
    println(queue4.foldLeft(0)((a,b) => a+b))

    println("\n**** Test instanciation listes non vides ****")
    var queueNonVide = Queue[Int](List(2,5,6,7),List(5,6,1))
    printQueue(queueNonVide)

  }

  def printQueue(q: Queue[Int]): Unit = {
    if(q.isEmpty) {
      println("Liste vide")
      return
    }

    println("Tete: " + q.headOption())
    println("Queue: " + q.rearOption())
    println("Taille: " + q.length)
    println("Contenu: " + q)
    println("En list: " + q.toList)
  }
}
