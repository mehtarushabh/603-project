package com.rushabh;

import com.rushabh.operations.MathematicalOperations;
import com.rushabh.utils.FileOperations;

public class ToyCompiler {
	public static void main(String[] args) {
		String filePath = "src/main/resources/TestInput.txt";
		Double result;

		MathematicalOperations mathematicalOperations = new MathematicalOperations();

		for(String lines : FileOperations.readLines(filePath)) {
			result = mathematicalOperations.calculateResult(lines);
			System.out.println("Input: " + lines);
			System.out.println("Result: " + result);
			System.out.println();
		}
	}
}
