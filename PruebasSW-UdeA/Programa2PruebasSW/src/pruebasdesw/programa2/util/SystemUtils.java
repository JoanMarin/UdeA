package pruebasdesw.programa2.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import pruebasdesw.programa2.model.LinkedList;
import pruebasdesw.programa2.model.Node;
import pruebasdesw.programa2.util.exception.ValuesNumberException;

/**
/**
 * @author sebastian.londonoa@udea.edu.co
 * @author johan.marinb@udea.edu.co
 * @author santiago.ramirez9@udea.edu.co
 */
public class SystemUtils {
    
        public static LinkedList getData(File file) throws FileNotFoundException, IOException, ValuesNumberException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            double data1, data2;
            LinkedList list = new LinkedList();
            while (line != null) {
                String[] lineArray = line.split(",");
                if(lineArray.length != 2) {
                    throw new ValuesNumberException();
                }
                data1 = Double.parseDouble(lineArray[0].trim());
                data2 = Double.parseDouble(lineArray[1].trim());
                list.addNode(new Node(data1, data2));
                line = br.readLine();
            }
            return list;
        }
    }
}