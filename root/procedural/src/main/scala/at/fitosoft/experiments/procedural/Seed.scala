package at.fitosoft.experiments.procedural

/**
  * Created by Tom on 12.03.2017.
  */
case class Seed(seedValue: Int) {
  def siblingSeed(siblingId: Int): Seed = Seed((seedValue >>> siblingId) | (seedValue << (Integer.SIZE - siblingId)))
}

