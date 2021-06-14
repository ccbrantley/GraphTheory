/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphTheory.model.Graph.Graphs;

import GraphTheory.model.Graph.Vertices.RingVertex;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author t520
 */
public class GraphGenerator {
    // Probability out of EDGEUPPERBOUND.
    private static int EDGEPROBABILITY = 0;
    private static int EDGEUPPERBOUND = 10;

    private GraphGenerator () {}

    public static SpringEmbeddedGraph TestGraph () {
        RingVertex v1 = new RingVertex("A");
        RingVertex v2 = new RingVertex("B");
        RingVertex v3 = new RingVertex("C");
        RingVertex v4 = new RingVertex("D");
        RingVertex v5 = new RingVertex("E");
        ArrayList<RingVertex> vertices = new ArrayList<RingVertex>() {{
            add(v1);
            add(v2);
            add(v3);
            add(v4);
            add(v5);
        }};
        Hashtable<RingVertex, ArrayList<RingVertex>> edges = new Hashtable<>();
        edges.put(v1, new ArrayList<RingVertex>() {{add(v2);}});
        edges.put(v2, new ArrayList<RingVertex>() {{add(v3);}});
        edges.put(v3, new ArrayList<RingVertex>() {{add(v4); add(v5);}});
        edges.put(v4, new ArrayList<RingVertex>() {{add(v5);}});
        edges.put(v5, new ArrayList<RingVertex>() {{add(v1);}});
        return new SpringEmbeddedGraph(vertices, edges);
    }
    public static SpringEmbeddedGraph SpringGraphGenerator () {
        ArrayList<RingVertex> vertices = new ArrayList<>();
        for (char alpha = 'A'; alpha <= 'M'; alpha++) {
            vertices.add(new RingVertex(String.valueOf(alpha)));
        }
        Random random = new Random();
        Hashtable<RingVertex, ArrayList<RingVertex>> edges = new Hashtable<>();
        vertices.forEach((v1) -> {
            ArrayList<RingVertex> curEdges = new ArrayList<>();
            vertices.forEach((v2) -> {
                if(!v1.equals(v2)) {
                    if (edges.keySet().contains(v2)) {
                        if (!edges.get(v2).contains(v1)) {
                            int randomInteger = random.nextInt(GraphGenerator.EDGEUPPERBOUND + 1);
                            if (randomInteger <= GraphGenerator.EDGEPROBABILITY) curEdges.add(v2);
                        }
                    }
                    else {
                        int randomInteger = random.nextInt(GraphGenerator.EDGEUPPERBOUND + 1);
                        if (randomInteger <= GraphGenerator.EDGEPROBABILITY) curEdges.add(v2);
                    }
                }
            });
            edges.put(v1, curEdges);
        });
        return new SpringEmbeddedGraph(vertices, edges);
    }

}