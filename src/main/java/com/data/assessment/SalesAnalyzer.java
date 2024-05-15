package com.data.assessment;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesAnalyzer {
	public Map<String, Integer> totalSalesByProduct(List<SaleRecord> records) {
		return records.stream().collect(
				Collectors.groupingBy(SaleRecord::getProductName, Collectors.summingInt(SaleRecord::getUnitsSold)));
	}

	public Map<String, Integer> salesByRegion(List<SaleRecord> records) {
		return records.stream().collect(
				Collectors.groupingBy(SaleRecord::getSalesRegion, Collectors.summingInt(SaleRecord::getUnitsSold)));
	}

	public Map<String, Map<String, Integer>> topSellingProductByRegion(List<SaleRecord> records) {
		return records.stream()
				.collect(Collectors.groupingBy(SaleRecord::getSalesRegion,
						Collectors.collectingAndThen(
								Collectors.toMap(SaleRecord::getProductName, SaleRecord::getUnitsSold, Integer::sum),
								map -> map.entrySet().stream().max(Map.Entry.comparingByValue())
										.map(entry -> Map.of(entry.getKey(), entry.getValue()))
										.orElse(Collections.emptyMap()))));
	}

	public static void main(String[] args) {
		List<SaleRecord> records = List.of(new SaleRecord("Laptop", 5, "North"), new SaleRecord("Laptop", 8, "South"),
				new SaleRecord("Smartphone", 10, "North"), new SaleRecord("Smartphone", 12, "East"),
				new SaleRecord("Tablet", 3, "North"), new SaleRecord("Tablet", 4, "East"));

		SalesAnalyzer analyzer = new SalesAnalyzer();

		System.out.println("Total Sales by Product:");
		System.out.println(analyzer.totalSalesByProduct(records));

		System.out.println("Sales by Region:");
		System.out.println(analyzer.salesByRegion(records));

		System.out.println("Top Selling Product in Each Region:");
		System.out.println(analyzer.topSellingProductByRegion(records));
	}
}
