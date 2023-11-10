package miniMaratona4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	public void testPath1() {
		assertEquals(true, Path.validPath(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }, 0, 2));
	}

	@Test
	public void testPath2() {
		assertEquals(false, Path.validPath(5, new int[][] { { 0, 2 }, { 4, 2 }, { 1, 3 } }, 0, 1));
	}

	@Test
	public void testPath3() {
		assertEquals(false, Path.validPath(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5));
	}

	@Test
	public void testPath4() {
		assertEquals(true, Path.validPath(6, new int[][] { { 0, 1 }, { 2, 4 }, { 4, 5 }, { 5, 1 }, { 0, 3 } }, 0, 2));
	}

	@Test
	public void testPath5() {
		assertEquals(true, Path.validPath(1, new int[][] { { 0, 0 } }, 0, 0));
	}

	@Test
	public void testPath6() {
		assertEquals(false, Path.validPath(4, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } }, 0, 3));
	}

}
