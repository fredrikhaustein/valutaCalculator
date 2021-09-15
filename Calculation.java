package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Calculation {

	ConvertToNok convertToNok = new ConvertToNok();

	public String fraChoosenValuta;
	public String tilChoosenValuta;
	public double valutaKurs;
	public double tilValuta;
	public double fraValuta;
	public double nokKurs;
	private HashMap<String, Double> currencyMap = new HashMap<String, Double>();

	public void setFraValuta(double fraValuta) {
		if (fraValuta < 0) {
			throw new IllegalArgumentException("M� v�re en positiv verdi som blir tatt inn");
		}
		this.fraValuta = fraValuta;
		System.out.println("Dette er fraValuta " + fraValuta);
	}

	public void setFraChoosenValuta(String fraChoosenValuta) {
		this.fraChoosenValuta = fraChoosenValuta;
		System.out.println("Dette er fraChoosenValuta " + fraChoosenValuta);
	}

	public void setTilChoosenValuta(String fraChoosenValuta) {
		this.tilChoosenValuta = fraChoosenValuta;
		System.out.println("Dette er til tilChoosenValuta " + tilChoosenValuta);
	}

	public void setTilValue(double tilValuta) {
		this.tilValuta = tilValuta;
	}

	public String getFraChoosenValuta() {
		return this.fraChoosenValuta;
	}

	public String getTilChoosenValuta() {
		return this.tilChoosenValuta;
	}

	public void setNokValue(String fraChoosenValuta) {
		try {
			convertToNok.findKurs(fraChoosenValuta);
			this.nokKurs = convertToNok.setNokkurs(this.fraValuta);
			System.out.println("Nokkurs er " + nokKurs);
		} catch (Exception e) {
			throw new IllegalArgumentException("setNokValue funker ikke");
		}
	}

	public void setValutaKurs(String filename) {
		try {
			readFileToCurrencyMap(filename);
			for (Entry<String, Double> valuta : currencyMap.entrySet()) {
				if (valuta.getKey().equals(tilChoosenValuta)) {
					this.valutaKurs = valuta.getValue();
					System.out.println("Dette er valutakursen" + valutaKurs);
					break;
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("setValutaKurs ");
		}
	}

	public double setValutaValue() {
		try {
			this.tilValuta = this.valutaKurs * this.nokKurs;
			System.out.println("Den nye valutakursen er " + tilValuta);
			return tilValuta;
		} catch (Exception e) {
			throw new IllegalArgumentException("setValutaValue funker ikke");
		}
	}

	public void readFileToCurrencyMap(String filename) {
		BufferedReader objReader = null;
		try {
			String strCurrentLine;

			objReader = new BufferedReader(new FileReader(filename));

			while ((strCurrentLine = objReader.readLine()) != null) {
				String[] split = strCurrentLine.split(":");
				currencyMap.put(split[0], Double.parseDouble(split[1]));
			}
			System.out.println("Currencymap i calculation er" + currencyMap);
		} catch (IOException e) {
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
// if (valutaLand.get(i).equals(tilChoosenValuta)) {
// this.valutaKurs = valutaKurser.get(i);
// System.out.println(valutaKurs);
// break;
