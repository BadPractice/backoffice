

import static org.junit.Assert.*;

import org.junit.Test;

public class InputCheckerTest {

	@Test
	public void test1() {
		InputChecker unit = new InputChecker();
		assertEquals("Result",true,unit.checkName("Penis"));
	}
	@Test
	public void test2() {
		InputChecker unit = new InputChecker();
		assertEquals("Result",false,unit.checkName("1Penis"));
	}
	@Test
	public void test3() {
		InputChecker unit = new InputChecker();
		assertEquals("Result",false,unit.checkName("Pen1s"));
	}
	@Test
	public void test4() {
		InputChecker unit = new InputChecker();
		assertEquals("Result",false,unit.checkName("Penis1"));
	}

	@Test
	public void test5() {
		InputChecker unit = new InputChecker();
		assertEquals("Result",false,unit.checkName("Pe nis"));
	}

}
