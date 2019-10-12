package com.java.cs635.assignment2.interpreter;

public class Divide extends PostFix {
	
	
		private PostFix lhs;
		private PostFix rhs;
		
		public Divide(PostFix lhs,PostFix rhs)
		{
			this.lhs=lhs;
			this.rhs=rhs;
		}

		@Override
		public double interpret() {
			
			return lhs.interpret()/rhs.interpret();
		}	
	

}
