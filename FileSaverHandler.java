package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FileSaverHandler implements FilMethod {

	private boolean switcherWriteToFile;
	private boolean switcherReadToFile;
	private HashMap<String, Double> hm = new HashMap<String, Double>();
	public HashMap<String, Double> hashmap = new HashMap<String, Double>();
	static BufferedWriter bw;
	public ObservableList<String> textFromFileToList = FXCollections.observableArrayList();
	String file;

	public void setMap(String valuta, Double kurs) {
		if (hashmap.containsKey(valuta)) {
			hashmap.replace(valuta, hashmap.get(valuta), kurs);
		} else {
			hashmap.put(valuta, kurs);
		}
		System.out.println("Her er det nye map" + hashmap);
	}

	public void readFileToHashMap(String filename) {
		BufferedReader objReader = null;
		try {
			String strCurrentLine;

			objReader = new BufferedReader(new FileReader(filename + ".txt"));

			while ((strCurrentLine = objReader.readLine()) != null) {
				String[] split = strCurrentLine.split(":");
				hashmap.put(split[0], Double.parseDouble(split[1]));
			}
			System.out.println("Currencymap" + hashmap);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public String getTextFileReturn() {
		if (switcherWriteToFile) {
			System.out.println("Her gikk det");
			return "Teksten ble skrevet til filen.";
		}
		System.out.println("Noe gikk galt");
		return "Error: file 'Currency' could not be opened for writing.";
	}

	@Override
	public void writeToFile(String filename) {
		try {
			File file = new File(filename + ".txt");
			if (file.exists()) {
				// create new BufferedWriter for the output file
				bw = new BufferedWriter(new FileWriter(file, true));
				// iterate map entries
				for (Entry<String, Double> entry : hashmap.entrySet()) {

					// put key and value separated by a colon
					bw.write(entry.getKey() + ":" + entry.getValue());

					// new line
					bw.newLine();
				}

				bw.flush();
			} else {
				file.createNewFile();
				bw = new BufferedWriter(new FileWriter(file, true));
				// iterate map entries
				for (Entry<String, Double> entry : hashmap.entrySet()) {

					// put key and value separated by a colon
					bw.write(entry.getKey() + ":" + entry.getValue());

					// new line
					bw.newLine();
				}

				bw.flush();
			}

		} catch (IOException e) {
			System.out.println("Filen finnes ikke");
			e.printStackTrace();
		} finally {

			try {
				// always close the writer
				bw.close();
				switcherWriteToFile = true;
			} catch (Exception e) {
				switcherWriteToFile = false;
			}
		}
	}

	@Override
	public void readFromFile(String filename) throws IOException {
		BufferedReader objReader = null;
		try {
			String strCurrentLine;

			objReader = new BufferedReader(new FileReader(filename));

			while ((strCurrentLine = objReader.readLine()) != null) {
				if (!sortedList(strCurrentLine)) {
					textFromFileToList.add(strCurrentLine);
				}
			}

		} catch (IOException e) {
			switcherReadToFile = false;
			e.printStackTrace();

		}

	}

	public String getSuccessFileRead() {
		if (switcherReadToFile) {
			return "Alt i fra filen er lest";
		}
		return "Det er ikke noe � lese fra filen";
	}

	private boolean sortedList(String inputString) {
		String[] inputStringSplit = inputString.split(":");
		for (String string : textFromFileToList) {
			String[] stringSplit = string.split(":");
			if (stringSplit[0].equals(inputStringSplit)) {
				return true;
			}
		}
		return false;
	}

	public ObservableList<String> getObservableList() {
		System.out.println("Her er getObservableliste " + textFromFileToList);
		return textFromFileToList;
	}

	public void sortObservableList(String valuta, String kurs) {
		for (String string : textFromFileToList) {
			String[] stringSplit = string.split(":");
			if (stringSplit[0].equals(valuta)) {
				String nyValuta = valuta + ":" + kurs;
				int index = textFromFileToList.indexOf(string);
				textFromFileToList.set(index, nyValuta);
			}
		}

	}
}

// f (!file.exists()) {
// try {
// file.createNewFile();
// PrintWriter inputText = new PrintWriter(file);
// inputText.println(textToFile);
// inputText.close();
// success = true;
// } catch (IOException e) {
// success = false;
// System.exit(1);
// }
// }
// else {
// try {
// PrintWriter inputText = new PrintWriter(file);
// inputText.println(textToFile+ "\n");
// inputText.close();
// success = true;
// }
// catch (FileNotFoundException e) {
// success = false;
// System.exit(1);
// }
// }
// }

// private static String filename;
// public static String textTofile;
//
// public void setFilename(String filename) {
// this.filename = filename;
// }
// public void setTextToFile(String text) {
// this.textTofile = text;
// }
//