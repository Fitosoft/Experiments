package at.fitosoft.experiments.procedural.trees

import javafx.application.Application
import javafx.scene.canvas.{Canvas, GraphicsContext}
import javafx.scene.paint.Color
import javafx.scene.{Group, Scene}
import javafx.stage.Stage

import at.fitosoft.experiments.procedural.Seed

/**
  * Created by Tom on 12.03.2017.
  */
object TreeGenerator {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[TreeGenerator], args: _*)
  }
}

class TreeGenerator extends Application {
  val Zoom = 20

  override def start(primaryStage: Stage): Unit = {
    val tree1 = Tree(Seed(982734981))
    println(s"tree1 = $tree1")

    val tree2 = Tree(Seed(609804563))
    println(s"tree2 = $tree2")

    primaryStage.setTitle("Hello Trees!")
    val root: Group = new Group
    val canvas: Canvas = new Canvas(1024, 768)
    val gc: GraphicsContext = canvas.getGraphicsContext2D

    gc.setStroke(Color.BROWN)
    gc.setLineWidth(5)

    drawTree(tree1, 250, 650, gc)
    drawTree(tree2, 550, 650, gc)

    root.getChildren.add(canvas)
    primaryStage.setScene(new Scene(root))

    primaryStage.show()
  }

  def drawTree(tree1: Tree, startX: Int, startY: Int, gc: GraphicsContext): Unit = {
    gc.strokeLine(startX, startY, startX, startY - tree1.trunkHeight * Zoom)
  }
}
