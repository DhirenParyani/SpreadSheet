package com.java.cs635.assignment2.interpreter;

public class Log extends PostFix{
	
	private PostFix rhs;
	
	
	public Log(PostFix rhs)
	{
		this.rhs=rhs;
		
	}

	@Override
	public double interpret() {
		
		return Math.log(rhs.interpret())/Math.log(2);
	}
	
	

}
