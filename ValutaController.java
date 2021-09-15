package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ValutaController {

	Calculation calculation = new Calculation();
	ValutaDiagramUtvikling valutaDiagramUtvikling = new ValutaDiagramUtvikling();
	FileSaverHandler fileSaverHandler = new FileSaverHandler();
	// ReadFile readFile = new ReadFile();
	HashMap<String, Integer> updateValutaCurrency = new HashMap<String, Integer>();

	@FXML
	AnchorPane rootPane;
	@FXML
	AnchorPane valutaKalkulator;
	@FXML
	AnchorPane valutaDiagram;
	@FXML
	AnchorPane valutaFiler;
	@FXML
	TextField fraValuta;
	@FXML
	TextField newValuta;
	@FXML
	TextField newExchangeRate;
	@FXML
	TextField filenameWrite;
	@FXML
	TextField filenameRead;
	@FXML
	Label fraValutaChoosen;
	@FXML
	Label tilValutaChoosen;
	@FXML
	Label tilValuta;
	@FXML
	Label utviklingsValuta;
	@FXML
	Label writeToFilereturn;
	@FXML
	Label readToFileReturn;
	@FXML
	Label writeToFileReturnSuccess;
	@FXML
	Label readFromFileReturnSuccess;

	XYChart.Series<Number, Number> serie = new XYChart.Series<>();
	@FXML
	ChoiceBox<String> tilValutaChoices;
	@FXML
	ChoiceBox<String> fraValutaChoices;
	@FXML
	ChoiceBox<String> valutaUtviklingChoices;
	@FXML
	ListView<String> fileList;
	NumberAxis xAxis = new NumberAxis();
	NumberAxis yAxis = new NumberAxis();
	@FXML
	LineChart<Number, Number> lineChartValuta;

	public void getFieldValues() {
		try {
			calculation.setFraValuta(Double.parseDouble(fraValuta.getText()));
			System.out.println("Steg 1");
			calculation.setFraChoosenValuta(fraValutaChoices.getValue());
			System.out.println("Steg 2");
			calculation.setTilChoosenValuta(tilValutaChoices.getValue());
			System.out.println("Steg 3");
			calculation.setNokValue(fraValutaChoices.getValue());
			System.out.println("Steg 4");
			calculation.setValutaKurs("currencyHashMap.txt");
			System.out.println("Steg 5");
			valutaDiagramUtvikling.setValutaValueDeveloper(valutaUtviklingChoices.getValue());
			System.out.println("Steg 6");
		} catch (Exception e) {
			throw new IllegalArgumentException("Feil i getfieldvalues");
		}
	}

	private void setValutaChoiceValues() {
		try {
			fileSaverHandler.readFromFile("currencyHashMap.txt");
			ObservableList<String> availableChoices = FXCollections.observableArrayList();
			List<String> helpList = new ArrayList<String>();
			helpList.addAll(fileSaverHandler.getObservableList());
			for (String string : helpList) {
				String[] splitString = string.split(":");
				if (!availableChoices.contains(splitString[0]))
					availableChoices.add(splitString[0]);
			}
			System.out.println("Her er availablechoices" + availableChoices);
			ObservableList<String> availableChoicesUtvikling = FXCollections.observableArrayList("Valuta/Ticker",
					"Norsk Krone/NOK", "Amerikansk Dollar/USD", "Britiske Pund/GDB", "Svenske Kroner/SEK",
					"Danske Kroner/DKK", "Australske dollar/AUD", "Euro/EUR", "Japanske yen/JPY",
					"Kanadiske dollar/CAD", "Kinesiske yuan/CNY", "New Zealand Dollar/NZD", "Russiske rubler/RUB",
					"Singapore Dollar/SGD", "Sveitsiske franc/CHF", "S�r-Afrikanske rand/ZAR", "Brasilianske real/BRL",
					"Tyrkiske lire/TRY", "Hong Kong Dollar/HKD");
			tilValutaChoices.setItems(availableChoices);
			fraValutaChoices.setItems(availableChoices);
			valutaUtviklingChoices.setItems(availableChoicesUtvikling);
		} catch (Exception e) {
			throw new IllegalArgumentException("Ugyldig input");
		}
	}

	public void createSerieToChart(String string) {
		try {
			List<Double> liste = valutaDiagramUtvikling.createSeries(string);
			this.serie.setName("Utvikling");
			this.serie.getData().add(new XYChart.Data<>(1, liste.get(1)));
			this.serie.getData().add(new XYChart.Data<>(2, liste.get(2)));
			this.serie.getData().add(new XYChart.Data<>(3, liste.get(3)));
			this.serie.getData().add(new XYChart.Data<>(4, liste.get(4)));
			this.serie.getData().add(new XYChart.Data<>(5, liste.get(5)));
			this.serie.getData().add(new XYChart.Data<>(6, liste.get(6)));
			this.serie.getData().add(new XYChart.Data<>(7, liste.get(7)));
			this.serie.getData().add(new XYChart.Data<>(8, liste.get(8)));
			this.serie.getData().add(new XYChart.Data<>(9, liste.get(9)));
			this.serie.getData().add(new XYChart.Data<>(10, liste.get(10)));
			System.out.println(liste);
			System.out.println(serie);
		} catch (Exception e) {
			System.out.println("Noe gikk galt i creatSeriesToChart");
		}
	}

	@FXML
	public void velgButtonPressed() {
		try {
			valutaDiagramUtvikling.setValutaValueDeveloper(valutaUtviklingChoices.getValue());
			String string = valutaDiagramUtvikling.getValutaValueDeveloper();
			System.out.println(string);
			createSerieToChart(string);
			// NumberAxis xAxis = new NumberAxis();
			// NumberAxis yAxis = new NumberAxis();
			// lineChartValuta = new LineChart(xAxis,yAxis);
			if (string.equals("Svenske Kroner/SEK") || string.equals("Danske Kroner/DKK")) {
				utviklingsValuta.setText(valutaDiagramUtvikling.getValutaValueDeveloper() + " per 100 kroner");
			} else {
				utviklingsValuta.setText(valutaDiagramUtvikling.getValutaValueDeveloper() + " per 1 kroner");
			}
			lineChartValuta.getData().add(serie);
		} catch (Exception e) {
			System.out.println("Noe gikk galt i trybuttom");
		}
	}

	@FXML
	public void buttonConverter() {
		try {
			getFieldValues();
			System.out.println("Steg 7");
			fraValutaChoosen.setText(calculation.getFraChoosenValuta().toString());
			System.out.println("Steg 8");
			tilValutaChoosen.setText(calculation.getTilChoosenValuta().toString());
			System.out.println("Steg 9");
			tilValuta.setText(Double.toString(calculation.setValutaValue()));
			System.out.println("Klarte buttonconvert");
		} catch (Exception e) {
			System.out.println("Noe gikk galt p� buttonconverter");
		}
	}

	@FXML
	public void writeToFile() throws IOException {
		fileSaverHandler.readFileToHashMap(filenameWrite.getText());
		fileSaverHandler.setMap(newValuta.getText(), Double.parseDouble(newExchangeRate.getText()));
		fileSaverHandler.writeToFile(filenameWrite.getText());
		writeToFileReturnSuccess.setText(fileSaverHandler.getTextFileReturn());
		fileSaverHandler.sortObservableList(newValuta.getText(), newExchangeRate.getText());

	}

	@FXML
	public void readFromFile() throws IOException {
		fileSaverHandler.readFromFile(filenameRead.getText());
		fileList.getItems().addAll(fileSaverHandler.getObservableList());
		readFromFileReturnSuccess.setText(fileSaverHandler.getSuccessFileRead());
	}

	@FXML
	public void changeToValutaCalculator() {
		valutaDiagram.setVisible(false);
		valutaKalkulator.setVisible(true);
		valutaFiler.setVisible(false);
		setValutaChoiceValues();

	}

	@FXML
	public void changeToValutaDevelopment() {
		valutaKalkulator.setVisible(false);
		valutaDiagram.setVisible(true);
		valutaFiler.setVisible(false);
	}

	@FXML
	public void changeToFilReadWrite() {
		valutaFiler.setVisible(true);
		valutaKalkulator.setVisible(false);
		valutaDiagram.setVisible(false);
	}

	public void initialize() {
		setValutaChoiceValues();
		fileList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		rootPane.setVisible(true);
		valutaKalkulator.setVisible(true);
		valutaDiagram.setVisible(false);
		valutaFiler.setVisible(false);

	}
}

// public String changeToCalculator() {
// String stage1 = "ValutaCalculator.fxml";
// return stage1;
// }
// public String changeToDiagram() {
// String stage = "ValutaUtvikling.fxml";
// return stage;
// }
// public String changeToFile() {
// String stage2 = ""
// }
