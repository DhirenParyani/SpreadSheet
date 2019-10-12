package com.java.cs635.assignment2.cellstates;

import com.java.cs635.assignment2.spreadsheet.Cell;
import com.java.cs635.assignment2.spreadsheet.SpreadSheet;

public class CellStateContext {
	private CellState currentState;
	private Cell cell;
	private Object value;
	private SpreadSheet spreadSheet;
	public CellStateContext(Cell cell,Object value,SpreadSheet spreadSheet) {
		
		this.currentState= new ValueState();
		this.cell=cell;
		this.value=value;
		this.spreadSheet=spreadSheet;
	}
	
	public Object getValue()
	{
		return value;
	}
	public Cell getCell()
	{
		return cell;
	}
	
	public SpreadSheet getSpreadSheet()
	{
		return spreadSheet;
	}
	
	public void setState(CellState state)
	{
		this.currentState=state;
	}
	
	
	public void setValue()
	{
		this.currentState.setValue(this);
	}

}
