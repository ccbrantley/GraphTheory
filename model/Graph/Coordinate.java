/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.model.Graph;

import GraphTheory.model.Graph.Vertices.RingVertex;

/**
 *
 * @author t520
 */

public class Coordinate {
    private double xValue = 0;
    private double yValue = 0;

    public Coordinate () {
    }

    public Coordinate (double _xValue, double _yValue) {
        this.xValue = _xValue;
        this.yValue = _yValue;
    }

    public double getXValue () { return this.xValue; }

    public double getYValue () { return this.yValue; }

    public void setXValue (double _xValue) { this.xValue = _xValue; }

    public void setYValue (double _yValue) { this.yValue = _yValue; }

    @Override
    public String toString() {
        return "xValue: " + this.xValue + "\t" + "yValue: " + this.yValue;
    }
    public static double EuclideanDistance (RingVertex _v1, RingVertex _v2) {
        double xDistance = Math.pow(_v2.getPosition().getXValue() - _v1.getPosition().getXValue(), 2);
        double yDistance = Math.pow(_v2.getPosition().getYValue() - _v1.getPosition().getYValue(), 2);
        return Math.sqrt(xDistance + yDistance);
    }

    public static double EuclideanDistance (Coordinate _c1, Coordinate _c2) {
        double xDistance = Math.pow(_c2.getXValue() - _c1.getXValue(), 2);
        double yDistance = Math.pow(_c2.getYValue() - _c1.getYValue(), 2);
        return Math.sqrt(xDistance + yDistance);
    }

    public static Coordinate GenerateRandomCoordinate (int _lower, int _upper) {
        int randomX = (int)(Math.floor(Math.random() * (_upper - _lower + 1) + _lower));
        int randomY = (int)(Math.floor(Math.random() * (_upper - _lower + 1) + _lower));
        return new Coordinate(randomX, randomY);
    }


    public static Coordinate UnitVectorPToV (Coordinate _c1, Coordinate _c2) {
        return new Coordinate((_c2.getXValue() - _c1.getXValue()) / Coordinate.EuclideanDistance(_c1, _c2),
                (_c2.getYValue() - _c1.getYValue()) / Coordinate.EuclideanDistance(_c1, _c2));
    }

    public static Coordinate UnitVector (Coordinate _coordinate) {
        double magnitude = Coordinate.Magnitude(_coordinate);
        return new Coordinate(_coordinate.getXValue() / magnitude, _coordinate.getYValue() / magnitude);
    }

    public static double Magnitude (Coordinate _coordinate) {
        return Math.sqrt(Math.pow(_coordinate.getXValue(), 2) + Math.pow(_coordinate.getYValue(), 2));
    }

}
