package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ConvertToNok {

	double nokKurs;
	double nokExchangeRate;
	double valueFromValuta;
	double newValutaValue;

	private HashMap<String, Double> exchangeRate = new HashMap<String, Double>();

	public void findKurs(String fraChoosenValuta) {
		try {
			readFileToexchangeRateMap();
			for (Entry<String, Double> valuta : exchangeRate.entrySet()) {
				if (valuta.getKey().equals(fraChoosenValuta)) {
					nokExchangeRate = valuta.getValue();
					System.out.println("Den norske kursen i convertToNok er " + nokExchangeRate);
					break;
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Finner ikke valutaen du leter etter");
		}
	}

	public double setNokkurs(Double fraValuta) throws IOException {
		System.out.println(fraValuta);
		System.out.println(nokExchangeRate);
		nokKurs = fraValuta / nokExchangeRate;
		System.out.println("Nok kurs etter deling er " + nokKurs);
		return nokKurs;
	}

	public void readFileToexchangeRateMap() {
		BufferedReader objReader = null;
		try {
			String strCurrentLine;

			objReader = new BufferedReader(new FileReader("currencyHashMap.txt"));

			while ((strCurrentLine = objReader.readLine()) != null) {
				String[] split = strCurrentLine.split(":");
				exchangeRate.put(split[0], Double.parseDouble(split[1]));
			}
			System.out.println("ExchangeRate" + exchangeRate);
		} catch (IOException e) {
			System.out.println("Noe er feil med readfiletoexchangeratemap");
			e.printStackTrace();

		}
	}
}

// List<Double> valutaKurser = new
// ArrayList<Double>(Arrays.asList(0.0,1.0,0.1117,0.0867,
// 1.0964,0.7710,0.1745,0.1042,12.2211,0.1471,0.8001,0.1845,8.9331,0.1627,
// 0.1076,2.1013,0.5177,0.7598,0.9093));
// List<String> valutaLand = Arrays.asList("Valuta/Ticker","Norsk
// Krone/NOK","Amerikansk Dollar/USD",
// "Britiske Pund/GDB","Svenske Kroner/SEK","Danske Kroner/DKK", "Australske
// dollar/AUD",
// "Euro/EUR","Japanske yen/JPY","Kanadiske dollar/CAD","Kinesiske yuan/CNY",
// "New Zealand Dollar/NZD","Russiske rubler/RUB","Singapore
// Dollar/SGD","Sveitsiske franc/CHF",
// "S�r-Afrikanske rand/ZAR","Brasilianske real/BRL","Tyrkiske lire/TRY","Hong
// Kong Dollar/HKD");
// int length = valutaKurser.size();
// for(int i=0;i<length;i++) {
// if (valutaLand.get(i).equals(fromValuta)) {
// this.nokKurs = valutaKurser.get(i);
// break;
// }
