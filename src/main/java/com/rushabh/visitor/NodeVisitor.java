package com.rushabh.visitor;

import com.rushabh.grammar.GrammarBaseVisitor;
import com.rushabh.grammar.GrammarParser;

public class NodeVisitor extends GrammarBaseVisitor<Double> {


	@Override
	public Double visitInteger(GrammarParser.IntegerContext ctx) {
		return Double.parseDouble(ctx.INTEGER().getText());
	}


	@Override
	public Double visitParentheses(GrammarParser.ParenthesesContext ctx) {
		return this.visit(ctx.inner);
	}


	@Override
	public Double visitAdditionOrSubtraction(GrammarParser.AdditionOrSubtractionContext ctx) {
		if(ctx.operation.getText().equals("-")) {
			return this.visit(ctx.left) - this.visit(ctx.right);
		} else if(ctx.operation.getText().equals("+")) {
			return this.visit(ctx.left) + this.visit(ctx.right);
		} else {
			return null;
		}
	}


	@Override
	public Double visitMultiplicationOrDivision(GrammarParser.MultiplicationOrDivisionContext ctx) {
		switch(ctx.operation.getText()) {
			case "*":
				return this.visit(ctx.left) * this.visit(ctx.right);
			case "/":
				return this.visit(ctx.left) / this.visit(ctx.right);
			default:
				return null;
		}
	}


	@Override
	public Double visitExponent(GrammarParser.ExponentContext ctx) {
		return Math.pow(this.visit(ctx.left), this.visit(ctx.right));
	}


	@Override
	public Double visitScientificFunction(GrammarParser.ScientificFunctionContext ctx) {
		switch(ctx.operation.getText()) {
			case "@":
				return Math.sin(Math.toRadians(this.visit(ctx.right)));
			case "#":
				return Math.cos(Math.toRadians(this.visit(ctx.right)));
			case "$":
				return Math.tan(Math.toRadians(this.visit(ctx.right)));
			case "!":
				return Math.log10(this.visit(ctx.right));
			default:
				return null;
		}
	}

}
