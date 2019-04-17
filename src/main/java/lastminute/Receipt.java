package lastminute;

import java.util.LinkedList;
import java.util.List;

public class Receipt {

	private List<Item> itemList;

	private double salesTaxes;
	private double totalAmount;

	private boolean processed = false;

	public Receipt() {
		itemList = new LinkedList<Item>();
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public double getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder();
		result.append("Receipt \n");

		int count = 1;
		for (Item i : itemList) {
			result.append(count++);
			result.append(") " + i.toString());
		}

		if (isProcessed()) {
			result.append("\nSales Taxes = " + salesTaxes);
			result.append("\nTotal Amount = " + totalAmount);
		}
		return result.toString();
	}

}
