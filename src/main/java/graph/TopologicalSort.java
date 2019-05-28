package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

/**
 * simple def of directed graph graph = Set<>[] where graph[i] means vertex i and all its next vetices.
 * */
/**
 * A given directed graph can be topological sorted when it is no directed cycles.
 */
public class TopologicalSort {

  private static final int VISITING = -1, NOT_VISITED = 0, VISITED = 1;

  public static Optional<List<Integer>> sort(Set<Integer>[] graph) {
    int[] mark = new int[graph.length];
    Stack<Integer> stack = new Stack<>();
    for(int v = 0; v < graph.length; v++) {
      if(mark[v] == NOT_VISITED && hasCycle(graph, v, mark, stack)) {
        return Optional.empty();
      }
    }

    List<Integer> result = new ArrayList<>(stack.size());

    while (!stack.isEmpty()) result.add(stack.pop());

    return Optional.of(result);
  }

  private static boolean hasCycle(Set<Integer>[] graph, int start, int[] mark, Stack<Integer> stack) {

    mark[start] = VISITING;

    for(int next: graph[start]) {
      if(mark[next] == VISITING) {
        return true;
      }

      if(mark[next] == NOT_VISITED && hasCycle(graph, next, mark, stack)) {
        return true;
      }
    }

    stack.push(start);
    mark[start] = VISITED;
    return false;
  }
}
