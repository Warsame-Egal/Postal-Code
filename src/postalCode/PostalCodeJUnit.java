/* File Name: PostalCodeJUnit.java
 * Course Name: CST8130 - Data Structures
 * Lab Section: 
 * Student Name: Warsame Egal
 * Date: 2015/1/29
 */

package postalCode;

import postalCode.PostalCode;
import postalCode.PostalCodeIndex;
import static org.junit.Assert.*;
import org.junit.Test;

public class PostalCodeJUnit {

	/*
	 * The following test method compares PostalCode objects 
	 * iterate through the codeOrderList and compare the before and after checksums to ensure that no records have been lost
	 * for code sorting algorithm 
	 */
	@Test
	public void testSortCode() {
		long before = 0;
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		for (PostalCode beforeSort : postalCodeIndex.getCodeOrderList()) {
			before += beforeSort.hashCode(); //grab the hash code before sorting
		}// end for
		postalCodeIndex.sortPostalCode(); //call the sorting method from PostalCode class

		PostalCode previous = null; // compares PostalCode objects if using an enhanced-for-loop, currently set to null
		for (PostalCode current : postalCodeIndex.getCodeOrderList()) {
			if (previous == null) { // must be the first time, so capture first as previous, continue with next
				previous = current;
				continue;
			}
			assertTrue((previous.getCode().compareTo(current.getCode()) <= 0)); //check is the condition is true, if not
			previous = current;
		}

		long after = 0;
		for (PostalCode afterSort : postalCodeIndex.getCodeOrderList()) {
			after += afterSort.hashCode();
		}// end for
		System.out.println("Postal Code Test");
		System.out.printf("%d\t\t%d\n\n\n", before, after);

		assertEquals(before, after); // check if two longs are equal, if not an assertion error is thrown
	}

	/*
	 * The following test method compares PostalCode objects 
	 * iterate through the cityOrderList and compare the before and after checksums to ensure that no records have been lost
	 * for code sorting algorithm 
	 */
	@Test
	public void testSortCity() {
		long before = 0;
		long after = 0;
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		for (PostalCode beforeSort : postalCodeIndex.getCodeOrderList()) {
			before += beforeSort.hashCode();
		}// end for
		postalCodeIndex.sortCity();

		PostalCode previous = null; // compares PostalCode objects if using an enhanced-for-loop, currently set to null
		for (PostalCode current : postalCodeIndex.getCityOrderList()) {
			if (previous == null) { // must be the first time, so capture first as previous, continue with next
				previous = current;
				continue;
			}
			assertTrue((previous.getCity().compareTo(current.getCity()) <= 0));
			previous = current;
		}

		for (PostalCode afterSort : postalCodeIndex.getCityOrderList()) {
			after += afterSort.hashCode();
		}// end for
		System.out.println("City Test");
		System.out.printf("%d\t\t%d\n\n\n", before, after);
		assertEquals(before, after); // check if two longs are equal, if not an assertion error is thrown
	}

	/*
	 * The following test method compares PostalCode objects 
	 * iterate through the provinceOrderList and compare the before and after checksums to ensure that no records have been lost
	 * for code sorting algorithm 
	 */
	@Test
	public void testSortProvince() {
		long before = 0;
		long after = 0;
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		for (PostalCode beforeSort : postalCodeIndex.getProvinceOrderList()) {
			before += beforeSort.hashCode();
		}// end for
		postalCodeIndex.sortProvince();

		PostalCode previous = null; // compares PostalCode objects if using an enhanced-for-loop, currently set to null
		for (PostalCode current : postalCodeIndex.getProvinceOrderList()) {
			if (previous == null) { // must be the first time, so capture first as previous, continue with next
				previous = current;
				continue;
			}
			assertTrue((previous.getProvince().compareTo(current.getProvince()) <= 0));
			previous = current;
		}

		for (PostalCode afterSort : postalCodeIndex.getProvinceOrderList()) {
			after += afterSort.hashCode();
		}// end for
		System.out.println("Province Test");
		System.out.printf("%d\t\t%d\n\n\n", before, after);
		assertEquals(before, after); // check if two longs are equal, if not an assertion error is thrown
	}

	/*
	 * The following test method compares PostalCode objects 
	 * iterate through the latitudeOrderList and compare the before and after checksums to ensure that no records have been lost
	 * for code sorting algorithm 
	 */
	@Test
	public void testSortLatitude() {
		long startTime = System.currentTimeMillis();
		long before = 0;
		long after = 0;
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		for (PostalCode beforeSort : postalCodeIndex.getLatitudeOrderList()) {
			before += beforeSort.hashCode();
		}// end for
		postalCodeIndex.sortLatitude();

		PostalCode previous = null; // compares PostalCode objects if using an enhanced-for-loop, currently set to null
		for (PostalCode current : postalCodeIndex.getLatitudeOrderList()) {
			if (previous == null) { // must be the first time, so capture first as previous, continue with next
				previous = current;
				continue;
			}
			//assertTrue((previous.getDoubleLatitude().compareTo(current.getDoubleLatitude()) <= 0));
			assertTrue(previous.getdoubleLatitude() <= current.getdoubleLatitude());
			previous = current;
		}
		System.err.println("Elapse time verify latitude sort: " + (System.currentTimeMillis() - startTime));

		for (PostalCode afterSort : postalCodeIndex.getLatitudeOrderList()) {
			after += afterSort.hashCode();
		}// end for
		System.out.println("Latitude Test");
		System.out.printf("%d\t\t%d\n\n\n", before, after);
		assertEquals(before, after); // check if two longs are equal, if not an assertion error is thrown
	}

	/*
	 * The following test method compares PostalCode objects 
	 * iterate through the longitudeOrderList and compare the before and after checksums to ensure that no records have been lost
	 * for code sorting algorithm 
	 */
	@Test
	public void testSortLongitude() {
		long before = 0;
		long after = 0;
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		for (PostalCode beforeSort : postalCodeIndex.getLongitudeOrderList()) {
			before += beforeSort.hashCode();
		}

		postalCodeIndex.sortLongitude();
		PostalCode previous = null; // compares PostalCode objects if using an enhanced-for-loop, currently set to null
		for (PostalCode current : postalCodeIndex.getLongitudeOrderList()) {
			if (previous == null) { // must be the first time, so capture first as previous, continue with next
				previous = current;
				continue;
			}
			assertTrue((previous.getLongitude().compareTo(current.getLongitude()) <= 0));
			previous = current;
		}

		for (PostalCode afterSort : postalCodeIndex.getLongitudeOrderList()) {
			after += afterSort.hashCode();
		}// end for
		System.out.println("Longitude Test");
		System.out.printf("%d\t\t%d\n\n\n", before, after);
		assertEquals(before, after); // check if two longs are equal, if not an assertion error is thrown
	}
}
