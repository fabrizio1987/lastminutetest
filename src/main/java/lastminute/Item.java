package lastminute;

public class Item {
	
	private boolean isImported;
	private Type type;
	private String description;
	private int quantity;
	private double netPrice;
	
	private double grossPrice;
	private double salesTaxAmount;
	private double importTaxAmount;
	
	private boolean processed = false;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Item(boolean isImported, Type type, String description, int quantity, double price) {
		super();
		this.isImported = isImported;
		this.type = type;
		this.description = description;
		this.quantity = quantity;
		this.netPrice = price;
	}



	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(" " + quantity);
		result.append(isImported ? " imported" : " ");		
		result.append("\t" + description);
		result.append(" (" + type + ") :\t");
		if(isProcessed()) {
			result.append(grossPrice);
		} else {
			result.append(netPrice);
		}
		result.append("\n");
		return result.toString();
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isImported != other.isImported)
			return false;
		if (Double.doubleToLongBits(netPrice) != Double.doubleToLongBits(other.netPrice))
			return false;
		if (quantity != other.quantity)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



	public String getDescription() {
		return description;
	}
	public int getQuantity() {
		return quantity;
	}
	public Type getType() {
		return type;
	}
	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.netPrice = price;
	}
	public double getGrossPrice() {
		return grossPrice;
	}
	public void setGrossPrice(double grossPrice) {
		this.grossPrice = grossPrice;
	}
	
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}



	public double getNetPrice() {
		return netPrice;
	}



	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}



	public double getSalesTaxAmount() {
		return salesTaxAmount;
	}



	public void setSalesTaxAmount(double salesTaxAmount) {
		this.salesTaxAmount = salesTaxAmount;
	}



	public double getImportTaxAmount() {
		return importTaxAmount;
	}



	public void setImportTaxAmount(double importTaxAmount) {
		this.importTaxAmount = importTaxAmount;
	}
	

}
