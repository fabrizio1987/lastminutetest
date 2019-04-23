package lastminute;

import java.util.List;

public class ReceiptService {

	public void processItem(Item item) {
		if (item.isProcessed()) {
			System.out.println("Item already processed.");
			return;
		}

		double importTaxAmount = Rules.getImportTaxRate(item) * item.getNetPrice() * item.getQuantity();
		double taxAmount = Rules.getTaxRate(item) * item.getNetPrice() * item.getQuantity();
		double grossPrice = item.getNetPrice() * item.getQuantity() + roundTo005(importTaxAmount + taxAmount);

		item.setImportTaxAmount(importTaxAmount);
		item.setSalesTaxAmount(taxAmount);
		item.setGrossPrice(round(grossPrice));
		item.setProcessed(true);

	}
	
	public void processReceipt(Receipt receipt) {
		if (receipt.isProcessed()) {
			System.out.println("Receipt already processed.");
			return;
		}

		
		double total = 0.0;
		double taxAmount = 0.0;
		
		List<Item> items = receipt.getItemList();
		
		for (Item item : items) {
			if (!item.isProcessed())
				processItem(item);
			
			taxAmount += item.getImportTaxAmount() + item.getSalesTaxAmount();
			total += item.getGrossPrice();
			
		}

		receipt.setSalesTaxes(roundTo005(taxAmount));
		receipt.setTotalAmount(round(total));		
		
		receipt.setProcessed(true);

	}	
	
	public double round(double d) {
		return Math.round(d * 100.0) / 100.0;
	}
	
	private double roundTo005(double d) {
		return Math.round(Math.ceil(d * 20.0)) / 20.0;
	}
	

}
