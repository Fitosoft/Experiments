package at.fitosoft.experiments.procedural

import org.junit.Test

class ProceduralTest {
  private val seed1 = Seed(927394)
  private val seed2 = Seed(98745623)
  private val seed3 = Seed(23987347)
  private val seed4 = Seed(99872346)
  private val seed5 = Seed(349748971)

  @Test
  def createNonNegativeInt(): Unit = {
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed1, seed2, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed1, seed3, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed1, seed4, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed1, seed5, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed2, seed3, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed2, seed4, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed2, seed5, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed3, seed4, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed3, seed5, 100))
    checkRange(-1, 100, Procedural.createNonNegativeInt(seed4, seed5, 100))

    //    val x = (0 to 10000).map(i => Procedural.createNonNegativeInt(Seed(i + 62348762), Seed(i * 2 + 917698203), 100))
    //    val y = x.sorted
    //    println(y)
  }

  @Test def createInt(): Unit = {
    checkRange(-50, 100, Procedural.createInt(seed1, seed2, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed1, seed3, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed1, seed4, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed1, seed5, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed2, seed3, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed2, seed4, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed2, seed5, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed3, seed4, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed3, seed5, -50, 100))
    checkRange(-50, 100, Procedural.createInt(seed4, seed5, -50, 100))

    //    val x = (0 to 10000).map(i => Procedural.createInt(Seed(i + 62348762), Seed(i * 2 + 917698203), -50, 100))
    //    val y = x.sorted
    //    println(y)
  }

  def checkRange(lowerBound: Int, upperBound: Int, actualValue: Int): Unit = actualValue > lowerBound && actualValue < upperBound

}
