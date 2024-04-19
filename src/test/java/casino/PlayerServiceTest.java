package casino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

	@Test
	public void testTransferExactBalance(){
		Integer transferAmount = p1.getCredit();
		ps.transfer(p1, p2, transferAmount);
		assertEquals(0, p1.getCredit());
		assertEquals(1000 + transferAmount, p2.getCredit());
	}

	@Test
	public void testTransferZeroAmount() {
		Integer initialCreditP1 = p1.getCredit();
		Integer initialCreditP2 = p2.getCredit();
		ps.transfer(p1, p2, 0);
		assertEquals(initialCreditP1, p1.getCredit());
		assertEquals(initialCreditP2, p2.getCredit());
	}

	@Test
	public void testReverseTransfer() {
		Integer transferAmount = 50;
		ps.transfer(p2, p1, transferAmount);
		assertEquals(100 + transferAmount, p1.getCredit());
		assertEquals(1000 - transferAmount, p2.getCredit());
	}

	@Test
	public void testPassByValue(){
		int[] array = {0, 1, 2};
		modifyArray(array, 10, 0);
		assertEquals(10, array[0]);
		
	}
	
	private void modifyArray(int[] array, int value, int index) {
		array[index] = value;
	}

	@Test
	public void testPassByValue1(){
		SomeObject obj = new SomeObject("Original");
		SomeObject newObject = modifyObject(obj);
		assertEquals("Modified", obj.name);
		assertEquals(obj.name, newObject.name);	
	}

	private SomeObject modifyObject(SomeObject obj) {
		obj.name = "Modified";
		return obj;
	}

	@Test
	public void testPassByReference(){
		SomeObject obj = new SomeObject("Original");
		reassignObject(obj);
		assertNotEquals("Reassigned", obj.name);
	}

	private void reassignObject(SomeObject o) {
        o = new SomeObject("Reassigned");
    }
}