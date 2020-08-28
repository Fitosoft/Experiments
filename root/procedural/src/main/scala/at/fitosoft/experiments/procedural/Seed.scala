package at.fitosoft.experiments.procedural

import at.fitosoft.experiments.procedural.Procedural.createNonNegativeInt

/**
 * Created by Tom on 12.03.2017.
 */
case class Seed(seedValue: Int) {

  def childSeed(siblingId: Int, parentSeed: Seed): Seed = {
    val seededSiblingId = createNonNegativeInt(this, parentSeed, siblingId * parentSeed.seedValue)
    //    println(seededSiblingId)
    Seed((seedValue >>> seededSiblingId) | (seedValue << (Integer.SIZE - seededSiblingId)))
  }
}

