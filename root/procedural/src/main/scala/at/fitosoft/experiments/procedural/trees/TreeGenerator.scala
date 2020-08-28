package at.fitosoft.experiments.procedural.trees

import at.fitosoft.experiments.procedural.Seed
import javafx.application.Application
import javafx.scene.canvas.{Canvas, GraphicsContext}
import javafx.scene.paint.Color
import javafx.scene.{Group, Scene}
import javafx.stage.Stage

/**
 * Created by Tom on 12.03.2017.
 */
object TreeGenerator {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[TreeGenerator], args: _*)
  }
}

class TreeGenerator extends Application {
  val Zoom = 5

  override def start(primaryStage: Stage): Unit = {
    val trees = Seq(872398749, 987239487, 19870234, 897234987, 50128034, 9727412, 609578123, 973294, 972133, 797123, 216843, 1234567, 987654).map(seedInt => Tree(Seed(seedInt)))

    primaryStage.setTitle("Hello Trees!")
    val root: Group = new Group
    val canvas: Canvas = new Canvas(1800, 800)
    val gc: GraphicsContext = canvas.getGraphicsContext2D

    gc.setStroke(Color.BROWN)
    gc.setLineWidth(1)

    var x = 80
    val dx = 120
    for (tree <- trees) {
      drawTree(tree, x, 650, gc)
      x += dx
    }

    root.getChildren.add(canvas)
    primaryStage.setScene(new Scene(root))

    primaryStage.show()
  }

  def drawBranch(branch: Branch, startX: Int, startY: Int, gc: GraphicsContext): Unit = {
    val endX = startX + Math.round(branch.branchLength * Math.cos(branch.branchDirection * Math.PI / 180)) * Zoom
    val endY = startY + Math.round(branch.branchLength * Math.sin(branch.branchDirection * Math.PI / 180)) * Zoom
    gc.strokeLine(startX, startY, endX, endY)

    for (subBranch <- branch.children) drawBranch(subBranch, endX.toInt, endY.toInt, gc)
  }

  def drawTree(tree: Tree, startX: Int, startY: Int, gc: GraphicsContext): Unit = {
    gc.strokeLine(startX, startY, startX, startY - tree.trunkHeight * Zoom)

    for (branch <- tree.children) drawBranch(branch, startX, startY - tree.trunkHeight * Zoom, gc)
  }

  def createDummyTree(): Tree = {
    val dummySeed = Seed(0)
    val branch11 = new Branch(dummySeed, 1, 3, 100, Seq.empty)
    val branch12 = new Branch(dummySeed, 1, 4, 70, Seq.empty)
    val branches: Seq[Branch] = Seq(branch11, branch12)
    new Tree(dummySeed, 10, branches)
  }
}
