import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static HashSet<Character> characters;


    public static void main(String[] args) {
        logger.debug("Initializing program...");
        JFrame frame = new JFrame();

        String[] a = {"a","a" ,"a", "a" ,"a", "a", "a"};

        ArrayList<String> b2 = new ArrayList<>();
        logger.info("Frame created");

        try {
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON file to map
            Character character = mapper.readValue(Paths.get("src/main/resources/data.json").toFile(), Character.class);
            characters.add(character);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JTable table = new JTable((Object[][]) characters.toArray(), characters.toArray());
        frame.add(table);
        frame.setTitle("Star Wars App");
        frame.setBounds(20, 20, 600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



}
