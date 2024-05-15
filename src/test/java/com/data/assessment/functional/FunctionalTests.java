package com.data.assessment.functional;

import static com.data.assessment.testutils.TestUtils.businessTestFile;
import static com.data.assessment.testutils.TestUtils.currentTest;
import static com.data.assessment.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.data.assessment.SaleRecord;
import com.data.assessment.SalesAnalyzer;

public class FunctionalTests {

	private SalesAnalyzer analyzer;

	@BeforeEach
	public void setUp() {
		analyzer = new SalesAnalyzer();
	}

	@Test
	public void testTotalSalesByProduct() throws IOException {
		// Prepare data
		List<SaleRecord> records = Arrays.asList(new SaleRecord("Laptop", 5, "North"),
				new SaleRecord("Laptop", 8, "South"), new SaleRecord("Smartphone", 10, "North"),
				new SaleRecord("Smartphone", 12, "East"), new SaleRecord("Tablet", 3, "North"),
				new SaleRecord("Tablet", 4, "East"));

		// Execute
		Map<String, Integer> totals = analyzer.totalSalesByProduct(records);

		yakshaAssert(currentTest(), totals.size() == 3 ? "true" : "false", businessTestFile);

		// Verify the results
//        assertNotNull(totals, "The result should not be null.");
//        assertEquals(3, totals.size(), "There should be totals for three products.");
//        assertEquals(13, totals.get("Laptop").intValue(), "Total units sold of Laptops should be 13.");
//        assertEquals(22, totals.get("Smartphone").intValue(), "Total units sold of Smartphones should be 22.");
//        assertEquals(7, totals.get("Tablet").intValue(), "Total units sold of Tablets should be 7.");
	}
}
