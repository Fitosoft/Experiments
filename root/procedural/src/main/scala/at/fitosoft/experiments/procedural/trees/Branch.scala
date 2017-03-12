package at.fitosoft.experiments.procedural.trees

import at.fitosoft.experiments.procedural.{Procedural, Seed}

/**
  * Created by Tom on 12.03.2017.
  */

object Branch {
  val BranchCountSeed: Seed = Seed(378946415)
  val BranchSeed: Seed = Seed(513420551)
  val BranchLengthSeed: Seed = Seed(335878764)

  def apply(seed: Seed): Branch = {
    val branchCount: Int = Procedural.createNonNegativeInt(seed, BranchCountSeed, 4)
    val children: Seq[Branch] = (1 to branchCount).map(counter => Branch(BranchSeed.siblingSeed(counter)))

    val branchLength: Int = Procedural.createNonNegativeInt(seed, BranchLengthSeed, 8)

    Branch(seed, branchLength, children)
  }

}

case class Branch(seed: Seed, branchLength: Int, children: Seq[Branch]) extends Procedural
