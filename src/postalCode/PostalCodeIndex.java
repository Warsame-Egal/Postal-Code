/* File Name: PostalCodeIndex.java
 * Course Name: CST8130 - Data Structures
 * Lab Section: 
 * Student Name: Warsame Egal
 * Date: 2015/1/29
 */

package postalCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.*;

public class PostalCodeIndex {

	/*
	 * The reference-to variable will track an ArrayList wrapped inside an Observable list. These will be built in the constructor. The use of ObservableList supports easy communication with a
	 * JavaFX-ListView object which will be created in FXLauncher. codeOrderList is a private reference-to variable, yet we need to communicate this to the ListView object that is managed elsewhere. If
	 * we made the MISTAKE of merely returning codeOrderList, other programmers could damage our data structure. We wrap the reference-to value stored in "codeOrderList" in an unmodifiableObservableList
	 * to give external code READ-ONLY access. The reference-to variable "cityOrderList" is created here, but it will start with the value "null". We will create the required ObservableList object for
	 * this, only after having read in the original data into the first ObservableList.
	 */
	private ObservableList<PostalCode> codeOrderList;

	public ObservableList<PostalCode> getCodeOrderList() {
		return FXCollections.unmodifiableObservableList(codeOrderList);
	}

	private ObservableList<PostalCode> cityOrderList;

	public ObservableList<PostalCode> getCityOrderList() {
		return FXCollections.unmodifiableObservableList(cityOrderList);
	}

	private ObservableList<PostalCode> provinceOrderList;

	public ObservableList<PostalCode> getProvinceOrderList() {
		return FXCollections.unmodifiableObservableList(provinceOrderList);
	}

	private ObservableList<PostalCode> latitudeOrderList;

	public ObservableList<PostalCode> getLatitudeOrderList() {
		return FXCollections.unmodifiableObservableList(latitudeOrderList);
	}

	private ObservableList<PostalCode> longitudeOrderList;

	public ObservableList<PostalCode> getLongitudeOrderList() {
		return FXCollections.unmodifiableObservableList(longitudeOrderList);
	}

	/**
	 * Constructor will open the file, read/parse/copy data into many PostalCode objects. The collection of PostalCode objects will be managed through several ObservableList objects. Try catch with
	 * resources, calls on Collections.sort to sort each list according to their sorting algorithms in each sorting class instide PostalCode
	 */
	public PostalCodeIndex() {
		// The following line creates ArrayList objects that can hold references-to PostalCode objects. The ArrayList objects are wrapped in an ObservableList.
		codeOrderList = FXCollections.observableList(new ArrayList<>());
		cityOrderList = FXCollections.observableList(new ArrayList<>());
		provinceOrderList = FXCollections.observableList(new ArrayList<>());
		latitudeOrderList = FXCollections.observableList(new ArrayList<>());
		longitudeOrderList = FXCollections.observableList(new ArrayList<>());
		
		File file = new File("postal_codes.csv"); // A File object will contain the fully-resolved pathname for our disk-based file.
	
		try (BufferedReader input = Files.newBufferedReader(file.toPath())) { // try-with-resources. This ensures that the BufferedReader is properly closed.		
			String inputLine = input.readLine(); // first line is title information, abandon the String after reading
			while ((inputLine = input.readLine()) != null) { // keep reading line-after-line, checking end of file for null
				PostalCode postalCode = new PostalCode(inputLine);
				codeOrderList.add(postalCode);
				cityOrderList.add(postalCode);
				provinceOrderList.add(postalCode);
				latitudeOrderList.add(postalCode);
				longitudeOrderList.add(postalCode);
			}// all 3/4 million records have now been loaded into ONE ArrayList (which is wrapped in an ObservableList)

			// Creates a long startTime variable which is then used to calculate how long it takes to copy the ArrayList from the file.
			long startTime = System.currentTimeMillis();
			cityOrderList = FXCollections.observableList(new ArrayList<PostalCode>(codeOrderList));
			provinceOrderList = FXCollections.observableList(new ArrayList<PostalCode>(codeOrderList));
			latitudeOrderList = FXCollections.observableList(new ArrayList<PostalCode>(codeOrderList));
			longitudeOrderList = FXCollections.observableList(new ArrayList<PostalCode>(codeOrderList));
			System.out.printf("Copied ArrayList:	%.3f seconds%n", (double) (System.currentTimeMillis() - startTime) / 1000.0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 
	 * The following five method calls Collections.sort to sort the references in the List for code, city, province, latitude, longitude
	 * which is then later than called in the FXLauncher class to sort the arraylist 
	 */
	public void sortPostalCode() {
		Collections.sort(codeOrderList, PostalCode.CompareCode.instance);
	}

	public void sortCity() {
		Collections.sort(cityOrderList, PostalCode.CompareCity.instance);
	}

	public void sortProvince() {
		Collections.sort(provinceOrderList, PostalCode.CompareProvince.instance);
	}

	public void sortLatitude() {
		Collections.sort(latitudeOrderList, PostalCode.CompareLatitude.instance);
	}

	public void sortLongitude() {
		Collections.sort(longitudeOrderList, PostalCode.CompareLongitude.instance);
	}

}
