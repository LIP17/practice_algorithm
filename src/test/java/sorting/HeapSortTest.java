package sorting;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeapSortTest extends SortingTestBase {
  @BeforeClass
  private void setup() {
    sorted = new Integer[]{1, 2, 3, 4, 5};
  }

  @BeforeMethod
  private void reset() {
    unsorted = new Integer[]{3, 2, 1, 4, 5};
  }

  @Test
  public void givenUnsortedArray_whenCallSort_shouldBeSorted() {
    HeapSort.sort(unsorted);
    assertArrayEquals(unsorted, sorted);
  }
}
