/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.view;

import GraphTheory.model.Algorithms.Eades84;
import GraphTheory.model.Graph.Graphs.GraphGenerator;
import GraphTheory.model.Graph.Graphs.SpringEmbeddedGraph;
import GraphTheory.model.Graph.Vertices.RingVertex;
import GraphTheory.controller.Controller;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author t520
 */
public class Demo {
    private static double CANVASWIDTH = 720;
    private static double CANVASHEIGHT = 720;
    private SpringEmbeddedGraph springGraph = GraphGenerator.SpringGraphGenerator();
    //private SpringEmbeddedGraph springGraph = GraphGenerator.TestGraph();
    Eades84 eades84 = new Eades84(2, 1, 5, .5, 1);
    private HBox parentPane = new HBox();
    private Canvas canvas = new Canvas(720, 720);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private Canvas canvas2 = new Canvas(720, 720);
    private GraphicsContext gc2 = canvas2.getGraphicsContext2D();

    public Demo () {
        this.drawVertices();
        this.drawEdges();
        this.eades84.execute(this.springGraph);
        this.normalize();
        this.drawVertices2();
        this.drawEdges2();
        this.canvas2OnAction();
        this.parentPane.getChildren().addAll(this.canvas, this.canvas2);
    }

    public void canvas2OnAction () {
        this.canvas2.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                this.eades84.execute(this.springGraph);
                gc2.clearRect(0, 0, Demo.CANVASWIDTH, Demo.CANVASHEIGHT);
                this.drawVertices2();
                this.drawEdges2();
            }
            if (event.getButton() == MouseButton.SECONDARY) {
                for (int i = 0; i < 10; i++) {
                    this.eades84.execute(this.springGraph);
                }
                gc2.clearRect(0, 0, Demo.CANVASWIDTH, Demo.CANVASHEIGHT);
                this.drawVertices2();
                this.drawEdges2();
            }
        });
    }

    public void normalize () {
        double minX = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;
        for (RingVertex v1 : this.springGraph.getVertices()) {
            double xValue = v1.getPosition().getXValue();
            if (xValue < minX) {
                minX = xValue;
            }
            if (xValue > maxX) {
                maxX = xValue;
            }
            double yValue = v1.getPosition().getYValue();
            if (yValue < minY) {
                minY = yValue;
            }
            if (yValue > maxY) {
                maxY = yValue;
            }
        }
        System.out.println(minX);
        System.out.println(maxX);
        System.out.println(minY);
        System.out.println(maxY);
    }

    public void drawVertices () {
        gc2.setStroke(Color.BLUE);
        this.springGraph.getVertices().forEach((v1) -> {
            gc.setFont(new Font("Georgia", 10));
            gc.setStroke(Color.BLUE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            this.gc.strokeText(v1.getIdentifier(),
                    (v1.getPosition().getXValue() * 10) + Demo.CANVASWIDTH / 2,
                    (v1.getPosition().getYValue() * 10) + Demo.CANVASHEIGHT / 2);
        });
    }

    public void drawVertices2 () {
        gc2.setStroke(Color.RED);
        this.springGraph.getVertices().forEach((v1) -> {
            gc2.setFont(new Font("Georgia", 10));
            gc2.setTextAlign(TextAlignment.CENTER);
            gc2.setTextBaseline(VPos.CENTER);
            this.gc2.strokeText(v1.getIdentifier(),
                    (v1.getPosition().getXValue() * 10) + Demo.CANVASWIDTH / 2,
                    (v1.getPosition().getYValue() * 10) + Demo.CANVASHEIGHT / 2);
        });
    }

    public void drawEdges () {
        this.springGraph.getEdges().forEach((v1, edges) -> {
            edges.forEach((v2) -> {
                this.gc.strokeLine((v1.getPosition().getXValue() * 10) + Demo.CANVASWIDTH / 2,
                        (v1.getPosition().getYValue() * 10) + Demo.CANVASHEIGHT  / 2,
                        (v2.getPosition().getXValue() * 10) + Demo.CANVASWIDTH / 2,
                        (v2.getPosition().getYValue() * 10) + Demo.CANVASHEIGHT / 2);
            });
        });
    }

    public void drawEdges2 () {
        this.springGraph.getEdges().forEach((v1, edges) -> {
            edges.forEach((v2) -> {
                this.gc2.strokeLine((v1.getPosition().getXValue() * 10) + Demo.CANVASWIDTH / 2,
                        (v1.getPosition().getYValue() * 10) + Demo.CANVASHEIGHT  / 2,
                        (v2.getPosition().getXValue() * 10) + Demo.CANVASWIDTH / 2,
                        (v2.getPosition().getYValue() * 10) + Demo.CANVASHEIGHT / 2);
            });
        });
    }

    public Pane getParentPane () {
        return this.parentPane;
    }
}
