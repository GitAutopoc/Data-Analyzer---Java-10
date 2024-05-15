package com.data.assessment;

public class SaleRecord {
	private String productName;
	private int unitsSold;
	private String salesRegion;

	public SaleRecord(String productName, int unitsSold, String salesRegion) {
		this.productName = productName;
		this.unitsSold = unitsSold;
		this.salesRegion = salesRegion;
	}

	public String getProductName() {
		return productName;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public String getSalesRegion() {
		return salesRegion;
	}
}