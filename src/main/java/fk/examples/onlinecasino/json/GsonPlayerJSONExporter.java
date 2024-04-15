package fk.examples.onlinecasino.json;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fk.examples.onlinecasino.model.Player;
import fk.examples.onlinecasino.xml.JcabiPlayerXMLImporter;

public class GsonPlayerJSONExporter {

	public static String exportPlayersToJson(List<Player> players) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(players);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// Example usage
		List<Player> players = JcabiPlayerXMLImporter.importPlayers("players.xml");

		String json = exportPlayersToJson(players);
		System.out.println(json);
		try (FileWriter writer = new FileWriter("players.json")) {
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
