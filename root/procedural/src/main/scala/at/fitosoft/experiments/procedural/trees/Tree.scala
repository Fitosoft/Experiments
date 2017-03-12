package at.fitosoft.experiments.procedural.trees

import at.fitosoft.experiments.procedural.{Procedural, Seed}

object Tree {
  val BranchCountSeed: Seed = Seed(268389866)
  val BranchSeed: Seed = Seed(88440572)
  val TrunkHeightSeed: Seed = Seed(166546907)

  def apply(seed: Seed): Tree = {
    val branchCount: Int = Procedural.createNonNegativeInt(seed, BranchCountSeed, 10)
    val children: Seq[Branch] = (1 to branchCount).map(counter => Branch(BranchSeed.siblingSeed(counter)))

    val trunkHeight: Int = Procedural.createNonNegativeInt(seed, TrunkHeightSeed, 10)

    Tree(seed, trunkHeight, children)
  }
}

/**
  * Created by Tom on 12.03.2017.
  */
case class Tree(seed: Seed, trunkHeight: Int, children: Seq[Branch]) extends Procedural
