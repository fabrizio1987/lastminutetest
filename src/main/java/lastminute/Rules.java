package lastminute;

public class Rules {
	
	//può diventare singleton
	
	private final static double salesTaxRate = 0.1;
	private final static double importTaxRate = 0.05;
	private final static double exemptTaxRate = 0;

	public static double getTaxRate(Item i) {
		Type type = i.getType();
		switch (type) {
			case OTHER:
				return salesTaxRate;
			case FOOD:
				return exemptTaxRate;
			case MEDICAL:
				return exemptTaxRate;
			case BOOK: 
				return exemptTaxRate;
			default:
				return salesTaxRate;
		}
	}
	
	public static double getImportTaxRate(Item i) {
		boolean isImported = i.isImported();		
		if (isImported) 
			return importTaxRate;
		else
			return exemptTaxRate;
	}

}
