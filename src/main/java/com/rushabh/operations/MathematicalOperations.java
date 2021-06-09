package com.rushabh.operations;

import com.rushabh.grammar.GrammarLexer;
import com.rushabh.grammar.GrammarParser;
import com.rushabh.visitor.NodeVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

public class MathematicalOperations {

	public Double calculateResult(String input){
		CharStream characters = CharStreams.fromString(input);

		Lexer lexer = new GrammarLexer(characters);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		GrammarParser grammarParser = new GrammarParser(tokens);

		ParseTree parseTree = grammarParser.start();

		NodeVisitor nodeVisitor = new NodeVisitor();

		return nodeVisitor.visit(parseTree);
	}
}
