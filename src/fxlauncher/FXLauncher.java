/* File Name: FXLauncher.java
 * Course Name: CST8130 - Data Structures
 * Lab Section: 
 * Student Name: Warsame Egal
 * Date: 2015/1/29
 */

package fxlauncher;

import postalCode.PostalCode;
import postalCode.PostalCodeIndex;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FXLauncher extends Application {

	private PostalCodeIndex postalCodeIndex = new PostalCodeIndex();

	 // A Stage is really just a window. primaryStage holds a reference-to a Stage object that was prebuilt by the superclass called
	//"Application". We are given a reference-to this prebuilt object
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Postal Code Analyzer");
		// ListView is a JavaFX control. It is given a reference-to an ObservableList. The ObservableList object holds a collection of references-to PostalCode objects.
		// The ListView object will automatically probe the ObservableList to access values to be shown in the ListView.
		// The ListView object will use the "toString()" method to gather the text to be output for each record.
		postalCodeIndex.sortPostalCode();
		postalCodeIndex.sortCity();
		postalCodeIndex.sortProvince();
		postalCodeIndex.sortLatitude();
		postalCodeIndex.sortLongitude();
		ListView<PostalCode> listCodeOrder = new ListView<>(postalCodeIndex.getCodeOrderList());
		ListView<PostalCode> listCityOrder = new ListView<>(postalCodeIndex.getCityOrderList());
		ListView<PostalCode> listProvinceOrderList = new ListView<>(postalCodeIndex.getProvinceOrderList());
		ListView<PostalCode> listLatitudeOrderList = new ListView<>(postalCodeIndex.getLatitudeOrderList());
		ListView<PostalCode> listLongitudeOrderList = new ListView<>(postalCodeIndex.getLongitudeOrderList());

		// HBox is a Parent (and Parents can have children). HBox is also a layout manager.
		// Any children added to the HBox will be displayed horizontally, side-by-side.
		HBox hBox = new HBox(listCodeOrder, listCityOrder, listProvinceOrderList, listLatitudeOrderList, listLongitudeOrderList);

		// The Scene contains the scene graph, that is, a collection of Node objects. The argument to the Scene constructor is a reference-to the HBox that currently has 4 children, our ListView objects.
		Scene scene = new Scene(hBox);

		// The Scene object is placed on the Stage
		primaryStage.setScene(scene);

		// Now that the Stage has been fully assembled, we can show it.
		primaryStage.show();
	}
	
	// main
	public static void main(String[] args) {
		launch(args);
	}
}
