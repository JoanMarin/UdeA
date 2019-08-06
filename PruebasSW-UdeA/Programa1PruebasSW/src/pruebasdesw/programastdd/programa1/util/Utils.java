package pruebasdesw.programastdd.programa1.util;

import pruebasdesw.programastdd.programa1.model.LinkedList;
import pruebasdesw.programastdd.programa1.model.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sebastian.londonoa@udea.edu.co
 * @author johan.marinb@udea.edu.co
 * @author santiago.ramirez9@udea.edu.co
 */

/*
Clase Utils clase que contiene utilidades varias como lo es el manejo de archivo y validaciones.
 */
public class Utils {

/*
Metodo para calcular la media de un conjunto de numeros dados en forma de lista ligada   
*/
    public static double calculateMean(LinkedList list) {
        if (list.getHead() == null) {
            return 0;
        } else {
            double sum, mean, n;
            sum = 0;
            n = 0;
            Node node = list.getHead();
            while (node != null) {
                sum += node.getData();
                n++;
                node = node.getNext();
            }
            mean = sum / n;
            return mean;
        }
    }

/*
Metodo para calcular la varianza de un conjunto de numeros dados en forma de lista ligada   
*/
    public static double calculateStdDev(LinkedList list) {
        if (list.getHead() == null) {
            return Double.NaN;
        } else {
            double stdDev, sum, n, mean;
            sum = 0;
            n = 0;
            mean = calculateMean(list);
            Node node = list.getHead();
            while (node != null) {
                n++;
                node = node.getNext();
            }
            node = list.getHead();
            while (node != null) {
                sum += Math.pow(node.getData() - mean, 2);
                node = node.getNext();
            }
            stdDev = Math.sqrt(sum / (n - 1));
            return stdDev;
        }
    }

/*
Metodo que dado un archivo que contiene numeros los setea y los pasa a una lista ligada. 
*/   
    public static LinkedList getData(File file) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            double data;
            LinkedList list = new LinkedList();

            while (line != null) {
                data = Double.parseDouble(line);
                list.addNode(new Node(data));
                line = br.readLine();
            }
            return list;
        }
    }

}
