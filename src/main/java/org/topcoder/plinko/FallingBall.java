package org.topcoder.plinko;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FallingBall {
  
  public static class CellComparator implements Comparator {

    public int compare(Object arg0, Object arg1) {
      Cell cell0 = (Cell) arg0;
      Cell cell1 = (Cell) arg1;
      
      int rowDiff = cell0.getRow() - cell1.getRow();
      if (rowDiff != 0) return rowDiff;
      
      int colDiff = cell0.getColumn() - cell1.getColumn();
      return colDiff;
    }
    
  }
  
  
  public static class Cell {
    
    public static Cell[] parseCells(String [] cellStrings) {
      Cell [] ret = new Cell[cellStrings.length];
      for (int c = 0; c < cellStrings.length; c++) {
        ret[c] = new Cell(cellStrings[c]);
      }
      
      Arrays.sort(ret, new CellComparator());
      
      return ret;
    }

    private int row;
    private int column;
   
    public int getRow() {
      return row;
    }

    public int getColumn() {
      return column;
    }
    
    public Cell(String cellString) {
      StringTokenizer st = new StringTokenizer(cellString);
      row = Integer.valueOf(st.nextToken()).intValue();
      column = Integer.valueOf(st.nextToken()).intValue();
      if (st.hasMoreElements())
        throw new RuntimeException("should not be more elements in this cell: " + cellString);
    }
  }
  

  
  public int howMany(String [] cells, int n) {
    return 0;
  }

}
