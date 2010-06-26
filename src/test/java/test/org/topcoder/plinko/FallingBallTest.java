package test.org.topcoder.plinko;


import java.util.Arrays;

import junit.framework.TestCase;

import org.topcoder.plinko.FallingBall;


public class FallingBallTest extends TestCase {
  
  private FallingBall ball;

  public FallingBallTest(String name) {
    super(name);
  }

  protected void setUp() throws Exception {
    super.setUp();
    this.ball = new FallingBall();
  }

  
  protected void tearDown() throws Exception {
    super.tearDown();
    this.ball = null;
  }
  
  public void testSingleCellParse() {
    FallingBall.Cell cell;
    
    cell = new FallingBall.Cell("0 0");
    assertEquals(0, cell.getRow());
    assertEquals(0, cell.getColumn());
    
    
    cell = new FallingBall.Cell("19 3");
    assertEquals(19, cell.getRow());
    assertEquals(3, cell.getColumn());
    
  }
  
  public void testRowAtDepth() {
    assertTrue(Arrays.equals(new int[] {1}, ball.rowAtDepth(1)));
    assertTrue(Arrays.equals(new int[] {1, 1}, ball.rowAtDepth(2)));
    assertTrue(Arrays.equals(new int[] {1, 2, 1}, ball.rowAtDepth(3)));
    
    // this is really a reformulation of test 1
    int sum = 0;
    
    int [] row30 = ball.rowAtDepth(30);
    for (int i = 0; i < row30.length; i++)
      sum += row30[i];
    assertEquals(536870912, sum);
  }
  
  
  public void testCellArrayParse() {
    String [] cellStrings = new String[] {"19 3", "12 2"};
    
    FallingBall.Cell [] ret = FallingBall.Cell.parseCells(cellStrings);
    
    assertEquals(2, ret.length);
    assertEquals(12, ret[0].getRow());
    assertEquals(2, ret[0].getColumn());
    
    assertEquals(19, ret[1].getRow());
    assertEquals(3, ret[1].getColumn());
    
  }
  
  
  /**
   * {"3 2", "5 2"}
   * 7
   * returns 6
   */
  public void test0() {
    
  }
  
  
  /**
   * {"0 0", "0 0"}
   * 30
   * returns 536870912
   */
  public void test1() {
    
  }
  
  /**
   * {"0 0", "29 0"}
   * 30
   * returns 1
   */
  public void test2() {
    
  }
  
  
  /**
   * {"10 0", "10 1"}
   * 15
   * returns 0
   */
  public void test3() {
    
  }

}
