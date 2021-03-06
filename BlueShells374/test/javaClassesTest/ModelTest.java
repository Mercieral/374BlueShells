package javaClassesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import project.interfaces.IClass;
import project.javaClasses.ConcreteClass;
import project.javaClasses.Model;

public class ModelTest {

	//Model 
	@Test
	public void testClassesList() {
		Model m = new Model();
		assertEquals(m.getClasses(), new ArrayList<IClass>());
		IClass c1 = new ConcreteClass();
		m.addClass(c1);
		assertEquals(m.getClasses().size(), 1);
	}

}
