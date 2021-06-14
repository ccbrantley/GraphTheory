/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.model.Graph.Vertices;

import GraphTheory.model.Graph.Coordinate;

/**
 *
 * @author t520
 */
public class RingVertex extends Vertex {
    private Coordinate deltaPosition = new Coordinate();
    private Coordinate position = Coordinate.GenerateRandomCoordinate(-10, 10);

    public RingVertex (String _identifier) {
        super(_identifier);
    }

    public void addDeltaToPosition (double _c4) {
        this.position.setXValue(this.position.getXValue() + this.deltaPosition.getXValue() * _c4);
        this.deltaPosition.setXValue(0);
        this.position.setYValue(this.position.getYValue() + this.deltaPosition.getYValue() * _c4);
        this.deltaPosition.setYValue(0);
    }

    public Coordinate getDeltaPosition () { return this.deltaPosition; }

    public Coordinate getPosition () { return this.position; }

    public void setDeltaPosition (Coordinate _deltaPosition) { this.deltaPosition = _deltaPosition; }

    public void setPosition (Coordinate _position) { this.position = _position; }

}
