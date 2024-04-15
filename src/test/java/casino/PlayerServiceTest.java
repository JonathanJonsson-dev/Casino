package casino;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fk.examples.onlinecasino.model.Player;
import fk.examples.onlinecasino.service.PlayerService;

public class PlayerServiceTest {

	private final PlayerService ps;
	
	public PlayerServiceTest() {
		ps = new PlayerService();
	}
	
	@Test
	public void testPlayerSaldoTransfer() {
		Player p1 = new Player("0001", "Robin", "Hood", 100, "robin.hood@gmail.com", "monkey123");
		Player p2 = new Player("0002", "Joakim", "von Anka", 1_000_000, "rikjoakim@gmail.com", "anka123");

		ps.transfer(p1, p2, 100);
		assertTrue(false);
	}

}