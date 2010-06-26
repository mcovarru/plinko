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

    public Cell() {}
    
    public Cell(int row, int column) {
      this.row = row;
      this.column = column;
    }

    public Cell(String cellString) {
      StringTokenizer st = new StringTokenizer(cellString);
      row = Integer.valueOf(st.nextToken()).intValue();
      column = Integer.valueOf(st.nextToken()).intValue();
      if (st.hasMoreElements())
        throw new RuntimeException("should not be more elements in this cell: " + cellString);
    }
    
    public boolean equals(Object other) {
      Cell o = (Cell) other;
      return row == o.getRow() && column == o.getColumn();
    }
    
    public int hashCode() {
      return row * 4442 + column;
    }
  }
  
  
  public int [] rowAtDepth(int depth) {
    return rows[depth - 1];
  }
  
  public static final int MAX_ROWS = 30;
  private int [] [] rows = new int[MAX_ROWS][];
  
  private void buildRows() {
    rows[0] = new int[] {1};
    for (int r = 1; r < MAX_ROWS; r++) {
      int [] prior = rows[r-1];
      rows[r] = new int[r+1];
      int [] row = rows[r];
      row[0] = row[row.length - 1] = 1;
      
      for (int i = 0; i < prior.length - 1; i++) {
        row[i + 1] = prior[i] + prior[i + 1];
      }
    }
    
  }
  
  public FallingBall() {
    buildRows();
  }

  public int cellDiff(Cell first, Cell second) {
    
    int colDiff = second.getColumn() - first.getColumn();
    int rowDiff = second.getRow() - first.getRow();

    if (colDiff > rowDiff) return 0;

    int [] row = rows[rowDiff];

    return row[colDiff];
  }

  /**
   * Trick here is the boundary conditions?
   * 
   * @param cells
   * @param n
   * @return
   */
  public int howMany(String [] pCells, int n) {
    Cell [] cells = new Cell[pCells.length + 1];
    Cell [] parsedCells = Cell.parseCells(pCells);
    
    // prepend a 0, 0 Cell to the parsed up cells
    cells[0] = new Cell(0, 0);
    System.arraycopy(parsedCells, 0, cells, 1, parsedCells.length);
    
    // take the product of the different ways the ball can pass through
    // each of the specified cells
    int count = 1;
    for (int c = 0; c < cells.length - 1; c++)
      count *= cellDiff(cells[c], cells[c+1]);
    
    
    // now account for the final row which may or may not have a cell specified
    int [] finalRow = rows[(n - 1) - cells[cells.length - 1].row];
    int sum = 0;
    for (int s = 0; s < finalRow.length; s++) sum += finalRow[s];
    
    return sum * count;
  }

}
