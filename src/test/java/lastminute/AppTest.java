package lastminute;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testAppConstructor() {
		try {
			new App();
		} catch (Exception e) {
			fail("Construction failed.");
		}
	}

	@Test
	public void testAppMain() {
		App.main(null);
		try {
			assertEquals("Hello World!" + System.getProperty("line.separator"), outContent.toString());
		} catch (AssertionError e) {
			fail("\"message\" is not \"Hello World!\"");
		}
	}
	
	
	@Test
	public void testReceipt1() {
		
		ReceiptService service = new ReceiptService(); 
		
		Item i1 = new Item(false, Type.BOOK, "book", 1, 12.49);
		Item i2 = new Item(false, Type.OTHER, "music CD", 1, 14.99);
		Item i3 = new Item(false, Type.FOOD, "chocolate bar", 1, 0.85);
		Receipt receipt = new Receipt();
		receipt.addItem(i1);
		receipt.addItem(i2);
		receipt.addItem(i3);
		
		System.out.println(receipt);
		
		service.processReceipt(receipt);
		
		System.out.println(receipt);
		
		try {
			
			assertTrue(receipt.getSalesTaxes() == 1.50);
			assertTrue(receipt.getTotalAmount() == 29.83);
			
		} catch (AssertionError e) {
			fail("error test receipt 1");
		}
	}
	
	@Test
	public void testReceipt2() {
		
		ReceiptService service = new ReceiptService(); 
		
		Item i1 = new Item(true, Type.FOOD, "box of chocolate", 1, 10.00);
		Item i2 = new Item(true, Type.OTHER, "bottle of perfume", 1, 47.50);
		Receipt receipt = new Receipt();
		receipt.addItem(i1);
		receipt.addItem(i2);
		
		System.out.println(receipt);
		
		service.processReceipt(receipt);
		
		System.out.println(receipt);
		
		try {
			assertTrue(receipt.getSalesTaxes() == 7.65);
			assertTrue(receipt.getTotalAmount() == 65.15);
		} catch (AssertionError e) {
			fail("error test receipt 2");
		}
	}
	
	@Test
	public void testReceipt3() {
		
		ReceiptService service = new ReceiptService(); 
		
		Item i1 = new Item(true, Type.OTHER, "bottle of perfume", 1, 27.99);
		Item i2 = new Item(false, Type.OTHER, "bottle of perfume", 1, 18.99);
		Item i3 = new Item(false, Type.MEDICAL, "packet of headache pills", 1, 9.75);
		Item i4 = new Item(true, Type.FOOD, "box of chocolate", 1, 11.25);
		Receipt receipt = new Receipt();
		receipt.addItem(i1);
		receipt.addItem(i2);
		receipt.addItem(i3);
		receipt.addItem(i4);
		
		System.out.println(receipt);
		
		service.processReceipt(receipt);
		
		System.out.println(receipt);
		
		try {
			assertTrue(receipt.getSalesTaxes() == 6.70);
			assertTrue(receipt.getTotalAmount() == 74.68);
		} catch (AssertionError e) {
			fail("error test receipt 3");
		}
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

}