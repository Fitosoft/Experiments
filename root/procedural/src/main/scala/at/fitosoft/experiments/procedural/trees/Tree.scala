package at.fitosoft.experiments.procedural.trees

import at.fitosoft.experiments.procedural.Procedural._
import at.fitosoft.experiments.procedural.{Procedural, Seed}

object Tree {
  val BranchCountSeed: Seed = Seed(268389866)
  val BranchSeed: Seed = Seed(88440572)
  val TrunkHeightSeed: Seed = Seed(166546907)

  def apply(elementSeed: Seed): Tree = {
    val branchCount: Int = createNonNegativeInt(elementSeed, BranchCountSeed, 8) + 4
    //println(branchCount)
    val trunkHeight: Int = createNonNegativeInt(elementSeed, TrunkHeightSeed, 20) + 5
    val direction: Int = -90

    val children: Seq[Branch] = (1 to branchCount).map(counter => Branch(BranchSeed.childSeed(counter, elementSeed), 1, trunkHeight, direction))

    Tree(elementSeed, trunkHeight, children)
  }
}

/**
  * Created by Tom on 12.03.2017.
  */
case class Tree(seed: Seed, trunkHeight: Int, children: Seq[Branch]) extends Procedural
