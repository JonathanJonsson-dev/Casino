package fk.examples.onlinecasino.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fk.examples.onlinecasino.model.Player;

public class PlayerXMLImporter {

    public static List<Player> importPlayers(String filePath) {
        List<Player> players = new ArrayList<>();
        try {
            // Initialize the XML Document Builder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(filePath);

            // Normalize the XML structure
            doc.getDocumentElement().normalize();

            // Get all <Player> nodes
            NodeList nList = doc.getElementsByTagName("Player");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Extract information for each player
                    String id = eElement.getAttribute("id");
                    String name = eElement.getElementsByTagName("Name").item(0).getTextContent();
                    int credit = Integer.parseInt(eElement.getElementsByTagName("Credit").item(0).getTextContent());
                    String email = eElement.getElementsByTagName("Email").item(0).getTextContent();
                    String password = eElement.getElementsByTagName("Password").item(0).getTextContent();

                    // Add the player to the list
                    players.add(new Player(id, name, credit, email, password));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }

    public static void main(String[] args) {
        List<Player> players = importPlayers("players.xml");
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }
}
