object Test {
  def main(args: Array[String]): Unit = {
    val queue1 = Queue[Int](Nil, Nil)
    println("\n** QUEUE1 **")
    printQueue(queue1)

    val queue2 = queue1.enqueue(1)
    println("\n** QUEUE2 **")
    printQueue(queue2)

    val queue3 = queue2.enqueue(2)
    println("\n** QUEUE3 **")
    printQueue(queue3)

    val queue4 = queue3.enqueue(3)
    println("\n** QUEUE4 **")
    printQueue(queue4)

    println("\n** QUEUE5 **")
    val dequeue5 = queue4.dequeue()
    println("Dequeue: " + dequeue5._1)
    printQueue(dequeue5._2)

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
  }
}
