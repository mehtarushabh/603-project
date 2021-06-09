package com.rushabh.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOperations {
	static BufferedReader bufferedReader;

	public static List<String> readLines(String filePath) {
		List<String> lines = new ArrayList<>();
		String validSyntaxRegex = "[1-9,+,\\-,*,\\\\,^,@,#,$,!,(,), ]";
		Pattern pattern = Pattern.compile(validSyntaxRegex);
		Matcher matcher;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));

			String line = bufferedReader.readLine();
			int lineNumber = 0;
			while(line != null) {
				lineNumber ++;
				matcher = pattern.matcher(line);
				if(matcher.lookingAt()){
					lines.add(line);
				}else {
					System.out.println("Invalid syntax for line: " + lineNumber);
					System.out.println();
				}
				line = bufferedReader.readLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}