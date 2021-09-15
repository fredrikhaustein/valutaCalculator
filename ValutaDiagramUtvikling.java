package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValutaDiagramUtvikling {

	public List<Double> liste;
	String valuta;

	List<Double> norskKrone = new ArrayList<Double>(Arrays.asList());
	List<Double> dollar = new ArrayList<Double>(Arrays.asList(6.0453, 5.6074, 5.8210, 5.8210, 5.8768, 6.3019, 8.0739,
			8.3987, 8.2630, 8.1338, 8.5643, 9.3345));
	List<Double> pund = new ArrayList<Double>(Arrays.asList(9.3402, 8.9841, 9.2199, 9.1968, 10.3690, 12.3415, 11.3725,
			10.6386, 10.8463, 11.2358, 12.1645));
	List<Double> danskKrone = new ArrayList<Double>(
			Arrays.asList(107.51, 104.59, 100.41, 104.70, 112.06, 120.04, 124.78, 125.39, 128.75, 131.9166, 135.0503));
	List<Double> svenskKrone = new ArrayList<Double>(Arrays.asList());
	List<Double> euro = new ArrayList<Double>(
			Arrays.asList(8.0068, 7.7926, 7.4744, 7.8087, 8.3534, 8.9530, 9.2899, 9.3271, 9.5962, 9.8527, 10.0934));
	List<Double> sveitserFranc = new ArrayList<Double>(Arrays.asList());
	List<Double> kanadiskDollar = new ArrayList<Double>(Arrays.asList());
	List<Double> japanskYen = new ArrayList<Double>(Arrays.asList());
	List<Double> kinesiskYuan = new ArrayList<Double>(Arrays.asList());
	List<Double> newZealandDollar = new ArrayList<Double>(Arrays.asList());
	List<Double> russiskRubler = new ArrayList<Double>(Arrays.asList());
	List<Double> singaporeDollar = new ArrayList<Double>(Arrays.asList());
	List<Double> s�rAfrikRand=new ArrayList<Double>(Arrays.asList());
	List<Double> brasilReal = new ArrayList<Double>(
			Arrays.asList(3.4384, 3.3525, 2.9912, 2.7275, 2.6781, 2.4459, 2.4234, 2.5907, 2.2348, 2.1934, 2.1534));
	List<Double> tyrkiskLire = new ArrayList<Double>(Arrays.asList());
	List<Double> hongkongDollar = new ArrayList<Double>(Arrays.asList());
	List<Double> australskDollar = new ArrayList<Double>(Arrays.asList(5.5586, 5.7813, 6.0295, 5.6757, 5.6788, 6.0589,
			6.2474, 6.3337, 6.0771, 6.1160, 6.1160, 6.2356));

	public void setValutaValueDeveloper(String valuta) {
		this.valuta = valuta;
	}

	public String getValutaValueDeveloper() {
		return this.valuta;
	}

	public List<Double> createSeries(String valuta) {
		if (valuta.equals("Valuta/Ticker")) {
			System.out.println("M� v�re en valuta");
		}
		if (valuta.equals("Norsk Krone/NOK")) {
			this.liste = norskKrone;
		}
		if (valuta.equals("Amerikansk Dollar/USD")) {
			this.liste = dollar;
			return this.liste;
		}
		if (valuta.equals("Britiske Pund/GDB")) {
			this.liste = pund;
		}
		if (valuta.equals("Svenske Kroner/SEK")) {
			this.liste = svenskKrone;
		}
		if (valuta.equals("Danske Kroner/DKK")) {
			this.liste = danskKrone;
		}
		if (valuta.equals("Australske dollar/AUD")) {
			this.liste = australskDollar;
		}
		if (valuta.equals("Euro/EUR")) {
			this.liste = euro;
		}
		if (valuta.equals("Japanske yen/JPY")) {
			this.liste = japanskYen;
		}
		if (valuta.equals("Kanadiske dollar/CAD")) {
			this.liste = kanadiskDollar;
		}
		if (valuta.equals("Kinesiske yuan/CNY")) {
			this.liste = kinesiskYuan;
		}
		if (valuta.equals("New Zealand Dollar/NZD")) {
			this.liste = newZealandDollar;
		}
		if (valuta.equals("Russiske rubler/RUB")) {
			this.liste = russiskRubler;
		}
		if (valuta.equals("Singapore Dollar/SGD")) {
			this.liste = singaporeDollar;
		}
		if (valuta.equals("Sveitsiske franc/CHF")) {
			this.liste = sveitserFranc;
		}
		if (valuta.equals("S�r-Afrikanske rand/ZAR")) {
			this.liste = s�rAfrikRand;
		}
		if (valuta.equals("Brasilianske real/BRL")) {
			this.liste = brasilReal;
		}
		if (valuta.equals("Tyrkiske lire/TRY")) {
			this.liste = tyrkiskLire;
		}
		if (valuta.equals("Hong Kong Dollar/HKD")) {
			this.liste = hongkongDollar;
		}
		return this.liste;

	}

}
