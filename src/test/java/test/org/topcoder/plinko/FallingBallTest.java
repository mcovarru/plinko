package test.org.topcoder.plinko;


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
  
  public void testCellParse() {
    FallingBall.Cell cell;
    
    cell = new FallingBall.Cell("0 0");
    assertEquals(0, cell.getRow());
    assertEquals(0, cell.getColumn());
    
    
    cell = new FallingBall.Cell("19 3");
    assertEquals(19, cell.getRow());
    assertEquals(3, cell.getColumn());
    
  }
  
  public void test32_52() {
    
  }
  
  public void test00_00() {
    
  }
  
  public void test00_290() {
    
  }
  
  public void test100_101() {
    
  }

}
