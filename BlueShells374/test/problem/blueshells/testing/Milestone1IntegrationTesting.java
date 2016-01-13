package problem.blueshells.testing;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import problem.asm.DesignParser;

public class Milestone1IntegrationTesting {
	private String[] args;
	
	@Before
	public void setUp(){
		args = new String[2];
	}
	
	@Test
	public void testMilestone1() throws IOException{
		args[0] = "problem.interfaces.IField";
		args[1] = "problem.javaClasses.Field";
		InputStream Input1 = new ByteArrayInputStream( "Generator\rUMLGenerator\rQuit\r".getBytes() );
		InputStream old = System.in;
		System.setIn(Input1);
		DesignParser.parser(args);
		BufferedReader br1 = new BufferedReader(new FileReader("input_output/graph.gv"));
		BufferedReader br2 = new BufferedReader(new FileReader("test/problem/blueshells/testing/testDoc"));
		
		String line = "";
		while((line = br1.readLine()) != null){
			assertEquals(line, br2.readLine());
		}
		System.setIn(old);
		br1.close();
		br2.close();
	}
}
