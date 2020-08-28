package at.fitosoft.experiments.procedural.trees

import at.fitosoft.experiments.procedural.{Procedural, Seed}

/**
 * Created by Tom on 12.03.2017.
 */

object Branch {
  val BranchCountSeed: Seed = Seed(378946415)
  val BranchSeed: Seed = Seed(513420551)
  val BranchLengthSeed: Seed = Seed(335878764)
  val BranchDirectionChangeSeed: Seed = Seed(98374587)

  def apply(elementSeed: Seed, level: Int, parentLength: Int, parentDirection: Int): Branch = {
    val branchCount: Int = Procedural.createNonNegativeInt(elementSeed, BranchCountSeed, 6) + 3
    val branchLength: Int = Procedural.createNonNegativeInt(elementSeed, BranchLengthSeed, parentLength) + 1
    val branchDirectionChange: Int = Procedural.createInt(elementSeed, BranchLengthSeed, -60, 60)
    val branchDirection: Int = parentDirection + branchDirectionChange


    val children: Seq[Branch] = if (level < 6)
      (1 to branchCount).map(counter => Branch(BranchSeed.childSeed(counter, elementSeed), level + 1, branchLength, branchDirection))
    else
      Seq.empty

    Branch(elementSeed, level, branchLength, branchDirection, children)
  }

}

case class Branch(seed: Seed, level: Int, branchLength: Int, branchDirection: Int, children: Seq[Branch]) extends Procedural
