import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.nio.file.Paths;
import java.security.Key;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        JFrame frame = new JFrame();


        String[][] a = {{"a","a" ,"a", "a" ,"a", "a", "a"},
                        {"a","a" ,"a", "a" ,"a", "a", "a"}};


        ArrayList<String> b2 = new ArrayList<>();

        logger.info("Frame created");

        try {
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON file to map
            Map<?, ?> map = mapper.readValue(Paths.get("src/main/resources/data.json").toFile(), Map.class);

            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
                b2.add((String) entry.getKey());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JTable table = new JTable(a, b2.stream().toArray());

        frame.setTitle("Star Wars App");
        frame.setBounds(20, 20, 600, 600);
        frame.add(table);

        frame.setVisible(true);
    }



}
