package com.company;

public class Main {

  public static void main(String[] args) {
    Graph<String> graph = new Graph<>();
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "D");
    graph.addVertex("D");
    System.out.println(graph);
    System.out.println(graph.getAllVertexFromSource("A"));
    BreadthFirstSearch search = new BreadthFirstSearch(graph);
    System.out.println(search.search("A", "D"));
    System.out.println(search.search("A", "E"));
    System.out.println(search.search("B", "A"));

  }
}
