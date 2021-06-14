/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.model.Algorithms;

import GraphTheory.model.Graph.Coordinate;
import GraphTheory.model.Graph.Graphs.SpringEmbeddedGraph;
import GraphTheory.model.Graph.Vertices.RingVertex;

/**
 *
 * @author t520
 */
public class Eades84 {
    private double c1 = 2;
    private double c2 = 1;
    private double c3 = 1;
    private double c4 = 0.5;
    private double iterationBound = 100;

    public Eades84 () {}

    public Eades84 (double _c1, double _c2, double _c3, double _c4, int _iterationBound) {
        this.c1 = _c1;
        this.c2 = _c2;
        this.c3 = _c3;
        this.c4 = _c4;
        this.iterationBound = _iterationBound;
    }

    public double calculateAttractiveForce (RingVertex _v1, RingVertex _v2) {
        return this.c1 * Math.log10(Coordinate.EuclideanDistance(_v1, _v2) / this.c2);
    }

    public double calculateRepulsiveForce (RingVertex _v1, RingVertex _v2) {
        return this.c3 / Math.pow(Coordinate.EuclideanDistance(_v1, _v2), 2);
    }

    public void execute(SpringEmbeddedGraph _graph) {
        int currentIteration = 0;
        while (currentIteration < this.iterationBound) {
            _graph.getVertices().forEach((v1) -> {
                _graph.getEdges().get(v1).forEach((v2) -> {
                    double force = this.calculateAttractiveForce(v1, v2);
                    Coordinate unitVector1 = Coordinate.UnitVectorPToV(v1.getPosition(), v2.getPosition());
                    //System.out.println("Before Delta: " + v1.getDeltaPosition().toString());
                    v1.getDeltaPosition().setXValue(v1.getDeltaPosition().getXValue() + force * unitVector1.getXValue());
                    //System.out.println("After Delta: " + v1.getDeltaPosition().toString());
                    v1.getDeltaPosition().setYValue(v1.getDeltaPosition().getYValue() + force * unitVector1.getYValue());
                    Coordinate unitVector2 = Coordinate.UnitVectorPToV(v2.getPosition(), v1.getPosition());
                    v2.getDeltaPosition().setXValue(v2.getDeltaPosition().getXValue() + force * unitVector2.getXValue());
                    v2.getDeltaPosition().setYValue(v2.getDeltaPosition().getYValue() + force * unitVector2.getYValue());
                });
                _graph.getVertices().forEach((v2) -> {
                    if (v1 != v2) {
                        if (!_graph.getEdges().get(v1).contains(v2) && !_graph.getEdges().get(v2).contains(v1)) {

                        Coordinate unitVector = Coordinate.UnitVectorPToV(v2.getPosition(), v1.getPosition());
                        v1.getDeltaPosition().setXValue(v1.getDeltaPosition().getXValue() + this.calculateRepulsiveForce(v1, v2) * unitVector.getXValue());
                        v1.getDeltaPosition().setYValue(v1.getDeltaPosition().getYValue() + this.calculateRepulsiveForce(v1, v2) * unitVector.getYValue());
                        }
                    }
                });
            });
            _graph.getVertices().forEach((v) -> {
                v.addDeltaToPosition(this.c4);
            });
            currentIteration++;
        }
    }

}