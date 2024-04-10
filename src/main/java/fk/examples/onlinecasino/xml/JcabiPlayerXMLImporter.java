package fk.examples.onlinecasino.xml;

import com.google.gson.Gson;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import fk.examples.onlinecasino.model.Player;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JcabiPlayerXMLImporter {
    private static Player xmlToPlayer(XML xmlPlayer) {
        String id = xmlPlayer.xpath("@id").get(0);
        String name = xmlPlayer.xpath("Name/text()").get(0);
        Integer credit = Integer.valueOf(xmlPlayer.xpath("Credit/text()").get(0));
        String email = xmlPlayer.xpath("Email/text()").get(0);
        String password = xmlPlayer.xpath("Password/text()").get(0);
        return new Player(id, name, credit, email, password);
    }
    public static List<Player> importPlayers(String filePath) {
        List<Player> players = new ArrayList<>();
        try {
            XML xml = new XMLDocument(Paths.get(filePath));
            List<XML> playersFromXML = xml.nodes("//Player");
            playersFromXML.stream().map(JcabiPlayerXMLImporter::xmlToPlayer).forEach(players::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }

    public static void main(String[] args) {
        List<Player> players = importPlayers("players.xml");
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("player.json")) {
            gson.toJson(players, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Player player : players) {
            System.out.println(player.toString());
        }
    }
}
