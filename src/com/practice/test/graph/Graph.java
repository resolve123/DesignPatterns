package com.practice.test.graph;

import java.util.*;

public class Graph {
    class Vertex {
        String label;

        Vertex(String label) {
            this.label = label;
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return label;
        }

        private Graph getOuterType() {
            return Graph.this;
        }

    }

    /**
     * This is the Graph implementaion
     */
    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }


    public void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList());
    }


    public void removeVertex(String label) {
        adjVertices.remove(new Vertex(label));
        adjVertices.values().stream().forEach(x -> x.remove(new Vertex(label)));

    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        if (adjVertices.get(v1) != null)
            adjVertices.get(v1).add(v2);
        else {
            List list = new ArrayList();
            list.add(v2);
            adjVertices.put(v1, list);
        }
        if (adjVertices.get(v2) != null)
            adjVertices.get(v2).add(v1);
        else {
            List list = new ArrayList();
            list.add(v1);
            adjVertices.put(v2, list);
        }

    }

    public void removeEdge(String label1, String label2) {
        Vertex edge1 = new Vertex(label1);
        Vertex edge2 = new Vertex(label2);
        adjVertices.remove(edge1);
        adjVertices.remove(edge2);
        adjVertices.values().stream().forEach(list -> {
            list.remove(edge1);
            list.remove(edge2);
        });

    }


    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for (Vertex v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
        }
        return sb.toString();
    }

    public Set<String> depthFirstSearch(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.empty()) {
            String vertex = stack.pop();

            if (!visited.contains(vertex)) {
                System.out.println(vertex);
                visited.add(vertex);
                for (Vertex v : getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    public Set<String> breadthFirstSearch(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}
