/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.model.Graph.Vertices;

/**
 *
 * @author t520
 */
public class Vertex {
    private String identifier;

    public Vertex (String _identifier) {
        this.identifier = _identifier;
    }

    public String getIdentifier () { return this.identifier; }

    public void setIdentifier (String _identifier) { this.identifier = _identifier; }

}
