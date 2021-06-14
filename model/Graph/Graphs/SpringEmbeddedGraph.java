/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.model.Graph.Graphs;

import GraphTheory.model.Graph.Vertices.RingVertex;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author t520
 */
public class SpringEmbeddedGraph {
    private ArrayList<RingVertex> vertices;
    private Hashtable<RingVertex, ArrayList<RingVertex>> edges;


    public SpringEmbeddedGraph (ArrayList<RingVertex> _vertices, Hashtable<RingVertex, ArrayList<RingVertex>> _edges) {
        this.vertices = _vertices;
        this.edges = _edges;
    }

    public ArrayList<RingVertex> getVertices () { return this.vertices; }

    public Hashtable<RingVertex, ArrayList<RingVertex>> getEdges () { return this.edges; }

    public void setVertices (ArrayList<RingVertex> _vertices) { this.vertices = _vertices; }

    public void setEdges (Hashtable<RingVertex, ArrayList<RingVertex>> _edges) { this.edges = _edges; }

}
