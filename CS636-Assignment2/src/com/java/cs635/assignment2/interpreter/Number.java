package com.java.cs635.assignment2.interpreter;

public class Number extends PostFix
	{

		// the value of the number
		private double value;

		public Number(double value)
			{
				this.value = value;
			}

		@Override
		public double interpret()
			{
				
				return Double.valueOf(value);
			}

	}
