/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.model.Graph.Graphs;

import GraphTheory.model.Graph.Vertices.Vertex;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author t520
 */
public class Graph {
    private ArrayList<Vertex> vertices;
    private Hashtable<Vertex, ArrayList<Vertex>> edges;

    public Graph (ArrayList<Vertex> _vertices, Hashtable<Vertex, ArrayList<Vertex>> _edges) {
        this.vertices = _vertices;
        this.edges = _edges;
    }

    public ArrayList<Vertex> getVertices () { return this.vertices; }

    public Hashtable<Vertex, ArrayList<Vertex>> getEdges () { return this.edges; }

    public void setVertices (ArrayList<Vertex> _vertices) { this.vertices = _vertices; }

    public void setEdges (Hashtable<Vertex, ArrayList<Vertex>> _edges) { this.edges = _edges; }

}
