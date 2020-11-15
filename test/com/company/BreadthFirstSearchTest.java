package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

  private static Graph<String> graph;
  private static BreadthFirstSearch<String> breadthFirstSearch;

  @BeforeEach
  void setUp() {
    graph = new Graph<>();
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("B", "C");
    graph.addEdge("B", "D");
    graph.addEdge("C", "D");
    graph.addVertex("D");
    breadthFirstSearch = new BreadthFirstSearch<>(graph);
  }

  @Test
  void testSearch() {
    assertTrue(breadthFirstSearch.search("A", "D"));
    assertFalse(breadthFirstSearch.search("B", "A"));
    assertFalse(breadthFirstSearch.search("E", "A"));
  }
}
