package casino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fk.examples.onlinecasino.Exceptions.InsufficientFundsException;
import fk.examples.onlinecasino.model.Player;
import fk.examples.onlinecasino.service.PlayerService;

public class PlayerServiceTest {

	private final PlayerService ps;
	private Player p1;
	private Player p2;
	
	public PlayerServiceTest() {
		ps = new PlayerService();
	}
	@BeforeEach
	public void initialize() {
		p1 = new Player("0001", "Robin Hood", 100, "robin.hood@gmail.com", "monkey123");
		p2 = new Player("0002", "Joakim von Anka", 1000, "rikjoakim@gmail.com", "anka123");
	}
	@Test
	public void testPlayerSaldoTransfer() {
		Integer transferAmount = 10;
		Integer expectedP1Credit = p1.getCredit() - transferAmount;
		Integer expectedP2Credit = p2.getCredit() + transferAmount;

		ps.transfer(p1, p2, transferAmount);

		assertEquals(expectedP1Credit, p1.getCredit());
		assertEquals(expectedP2Credit, p2.getCredit());
	}
	@Test
	public void testPlayerNegativeSaldoTransfer(){
		assertThrows(IllegalArgumentException.class, () -> {
            ps.transfer(p1, p2, -100);
        });
	}

	@Test
	public void testTransferToNullPlayer() {
		assertThrows(IllegalArgumentException.class, () -> {
            ps.transfer(p1, null, 100);
        });
	}

	@Test
	public void testTransferExceedsBalance() {
		assertThrows(InsufficientFundsException.class, () -> {
			ps.transfer(p1, p2, p1.getCredit() + 500);
		});
	}
}