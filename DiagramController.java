package app;

/*
 * import java.util.List;
 * 
 * import javafx.collections.FXCollections; import
 * javafx.collections.ObservableList; import javafx.event.ActionEvent; import
 * javafx.fxml.FXML; import javafx.scene.chart.Axis; import
 * javafx.scene.chart.CategoryAxis; import javafx.scene.chart.LineChart; import
 * javafx.scene.chart.NumberAxis; import javafx.scene.chart.XYChart; import
 * javafx.scene.chart.XYChart.Data; import javafx.scene.chart.XYChart.Series;
 * import javafx.scene.control.ChoiceBox; import javafx.scene.control.TextField;
 * 
 * public class DiagramController {
 * 
 * ValutaDiagramUtvikling valutadiagramutvikling = new ValutaDiagramUtvikling();
 * 
 * @FXML LineChart<Number, Number> valutaDiagram;
 * 
 * @FXML ChoiceBox<String> valutaChoiceBox;
 * 
 * @FXML TextField choosenValuta;
 * 
 * @FXML NumberAxis xaxis;
 * 
 * @FXML NumberAxis yaxis;
 * 
 * 
 * public void getvalutaChoiceBox() {
 * valutadiagramutvikling.setValutaValue(valutaChoiceBox.getValue());
 * 
 * } private void setValutaValues() { ObservableList<String> avalible =
 * FXCollections.observableArrayList("Valuta/Ticker","Norsk Krone/NOK"
 * ,"Amerikansk Dollar/USD",
 * "Britiske Pund/GDB","Svenske Kroner/SEK","Danske Kroner/DKK",
 * "Australske dollar/AUD",
 * "Euro/EUR","Japanske yen/JPY","Kanadiske dollar/CAD","Kinesiske yuan/CNY",
 * "New Zealand Dollar/NZD","Russiske rubler/RUB","Singapore Dollar/SGD"
 * ,"Sveitsiske franc/CHF",
 * "S�r-Afrikanske rand/ZAR","Brasilianske real/BRL","Tyrkiske lire/TRY"
 * ,"Hong Kong Dollar/HKD"); valutaChoiceBox.setItems(avalible); }
 * 
 * public void buttonPressed(ActionEvent event) { getvalutaChoiceBox();
 * choosenValuta.setText(valutadiagramutvikling.getValutaValue().toString());
 * seriesToLineChart(valutadiagramutvikling.createSeries());
 * 
 * }
 * 
 * public void seriesToLineChart(List<Double> liste) { XYChart.Series<Number,
 * Number> series = new XYChart.Series(); for (int i=0;i<6;i++) {
 * series.getData().add(new Data<Number, Number>(i, liste.get(i))); }
 * valutaDiagram.getData().add(series);
 * 
 * } public void initialize() { setValutaValues();
 * 
 * 
 * }
 * 
 * }
 */
