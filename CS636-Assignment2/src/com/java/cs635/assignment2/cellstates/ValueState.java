package com.java.cs635.assignment2.cellstates;


import com.java.cs635.assignment2.spreadsheet.Cell;
import com.java.cs635.assignment2.spreadsheet.SpreadSheet;


public class ValueState implements CellState
{

	/*
	 * * @see com.java.cs635.assignment2.cellstates.CellState#setValue(com.java.cs635.assignment2.cellstates.CellStateContext)
	 * Points to Remember: 
	 * Regular operation of setting a cell with a double value is performed in normal cases. (cell.setValue)
	 * When a cell which was previously in error due to circular reference is set with double, following things should be taken care:
	 * It should be made independent since it now has a value.
	 * Removing all its edges since it is now a constant value.
	 * and updating the circular references since it might clear the deadlock.
	 */

	@Override
	public void setValue(CellStateContext context)
		{

			if (context.getValue().toString().matches("\\d+"))
				{
					Cell cell = context.getCell();
					context.getSpreadSheet().saveCellState(cell);
					if (cell.isCellDependent() == true)
						{
							cell.setCellDependent(false);
							cell.setFormula(null);
							SpreadSheet.oGraph.initEdge(SpreadSheet.positionHeaderMap.get(cell.getPosition()));
							context.getSpreadSheet().updateAllCircularReferences();

						}
					cell.setValue(Double.valueOf(context.getValue().toString()));
				} else
					{
						context.setState(new EquationState());
						context.setValue();
					}

		}

}
