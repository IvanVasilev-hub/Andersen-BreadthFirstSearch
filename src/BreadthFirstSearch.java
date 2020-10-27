import java.util.*;

public class BreadthFirstSearch {
  private static final Map<String, List<String>> graph = new HashMap<>();


  private static boolean search(String name) {
    if (!graph.containsKey(name)) {
      return false;
    }

    Queue<String> searchQueue = new ArrayDeque<>();
    searchQueue.addAll(graph.get(name));

    List<String> searched = new ArrayList<>();
//    searched.add(name);

    while (!searchQueue.isEmpty()) {
      String person = searchQueue.poll();
      if (!searched.contains(person)) {
        if (isSeller(person)) {
          System.out.printf("%s is a mango seller!\n", person);
          return true;
        }
        searchQueue.addAll(graph.get(person));
        searched.add(person);
      }
    }
    return false;
  }

  private static boolean isSeller(String name) {
    return name.endsWith("m");
  }

  public static void main(String[] args) {
    graph.put("you", Arrays.asList("alice", "bob", "claire"));
    graph.put("bob", Arrays.asList("anuj", "peggy"));
    graph.put("alice", Arrays.asList("peggy"));
    graph.put("claire", Arrays.asList("thom", "jonny"));
    graph.put("anuj", Collections.emptyList());
    graph.put("peggy", Collections.emptyList());
    graph.put("thom", Collections.emptyList());
    graph.put("jonny", Collections.emptyList());

    System.out.println(search("you"));
    System.out.println(search("jonny"));
  }
}
