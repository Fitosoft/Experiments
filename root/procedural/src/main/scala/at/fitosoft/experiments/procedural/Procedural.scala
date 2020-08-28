package at.fitosoft.experiments.procedural

/**
  * Representing a procedural entity.
  */
trait Procedural {
  def seed: Seed

  def children: Seq[Procedural]
}

object Procedural {
  def createInt(proceduralSeed: Seed, intSeed: Seed, lowerBound: Int, upperBound: Int): Int = {
    createNonNegativeInt(proceduralSeed, intSeed, upperBound - lowerBound - 1) + lowerBound + 1
  }

  /**
   * Creates a procedural int value (0 to  upperBound-1) based on the procedural's own seed,
   * the integer value seed and an upper bound.
   *
   * @param proceduralSeed seed of the procedural
   * @param intSeed        seed of this integer value
   * @param upperBound     upper bound of the integer value to be created
   * @return integer value 0 to  upperBound-1
   */
  def createNonNegativeInt(proceduralSeed: Seed, intSeed: Seed, upperBound: Int): Int = {
    Math.abs((proceduralSeed.seedValue ^ intSeed.seedValue) % upperBound)
  }
}
