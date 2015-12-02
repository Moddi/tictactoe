import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BoardTest {
	Board board;
	
	
	@Before
	public void initialize() {
		board = new Board();
	}
	
	@Test
	public void testInit() {
		Boolean expected = false;
		Boolean actual = board.hasWinner();
		assertTrue(expected == actual);
	}
	
	@Test
	public void testPlace() throws InvalidPositionException {
		board.setMark("O", 2, 2);
		Boolean expected = false;
		Boolean actual = board.hasWinner();
		assertTrue(expected == actual);
	}

	@Test
	public void testWinplacement() throws InvalidPositionException {
		board.setMark("O", 1, 1);
		board.setMark("O", 2, 2);
		board.setMark("O", 3, 3);
		Boolean expected = true;
		Boolean actual = board.hasWinner();
		assertTrue(expected == actual);
	}

	@Test (expected=InvalidPositionException.class)
	public void testMissplace() throws InvalidPositionException {
		board.setMark("O", 2, 4);
	}
}
