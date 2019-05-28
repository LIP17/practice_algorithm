package graph;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import org.testng.annotations.Test;

public class TopologicalSortTest {

  private static class Item {
    int count;
    Item(int count) { this.count = count; }
  }

  @Test
  public void givenDirectedGraphWithCycle_whenTopoloticalSort_thenReturnEmptyOptional() {
    Set<Integer>[] graph = getCyclicDirectedGraph();
    assertEquals(TopologicalSort.sort(graph), Optional.empty());
  }

  @Test
  public void givenDAG_whenTopologicalSort_thenReturnOnePossibleSort() {
    Set<Integer>[] graph = getDAG();
    List<Integer> result = TopologicalSort.sort(graph).get();
    System.out.println(result);
    assertTrue(result.indexOf(0) == 0);
    assertTrue(result.indexOf(1) < result.indexOf(3));
  }

  private Set<Integer>[] getCyclicDirectedGraph() {
    String a = "asdf";
    a.indexOf("asdf");
    Set<Integer>[] graph = (Set<Integer>[]) new Set[4];
    graph[0] = new HashSet<>();
    graph[0].add(1);
    graph[1] = new HashSet<>();
    graph[1].add(2);
    graph[2] = new HashSet<>();
    graph[2].add(3);
    graph[3] = new HashSet<>();
    graph[3].add(0);
    return graph;
  }

  private Set<Integer>[] getDAG() {
    Set<Integer>[] graph = (Set<Integer>[]) new Set[4];
    graph[0] = new HashSet<>();
    graph[0].add(1);
    graph[1] = new HashSet<>();
    graph[1].add(2);
    graph[1].add(3);
    graph[2] = new HashSet<>();
    graph[3] = new HashSet<>();
    return graph;
  }


}
