package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch<T> {
  private Graph<T> graph;

  public BreadthFirstSearch(Graph<T> graph) {
    this.graph = graph;
  }

  public boolean search(T root, T vertex) {
    if (!graph.containsVertex(root) || !graph.containsVertex(vertex)) {
      return false;
    }
    Queue<T> searchQueue = new LinkedList<>();
    searchQueue.addAll(graph.getAllVertexFromSource(root));
    List<T> searched = new LinkedList<>();
    searched.add(root);

    while (!searchQueue.isEmpty()) {
      T currVertex = searchQueue.poll();
      if (!searched.contains(currVertex)) {
        if (currVertex.equals(vertex))
          return true;
      }
      searched.add(currVertex);
      searchQueue.addAll(graph.getAllVertexFromSource(currVertex));
    }
    return false;
  }
}
