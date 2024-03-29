package pruebasdesw.programa2.util;

import pruebasdesw.programa2.util.exception.BadIndexException;
import pruebasdesw.programa2.model.LinkedList;
import pruebasdesw.programa2.model.Node;

/**
 * @author sebastian.londonoa@udea.edu.co
 * @author johan.marinb@udea.edu.co
 * @author santiago.ramirez9@udea.edu.co
 */
public class MathUtils {

    public static double calculateMean(LinkedList list, int index) throws BadIndexException {
        if(index < 0 || index > 1){
            throw new BadIndexException();
        }
        if(list.getHead() == null) {
            return 0;
        } else {
            double sum, mean, n;
            sum = 0;
            n = 0;
            Node p = list.getHead();
            while(p != null) {
                sum += (index == 0)?p.getData1():p.getData2();
                n++;
                p = p.getNext();
            }
            mean = sum/n;
            return mean;
        }
    }
    
    public static double calculateSum(LinkedList list,int index, int power) throws BadIndexException{
        if(index < 0 || index > 1){
            throw new BadIndexException();
        }
        if(list.getHead() == null) {
            return 0;
        } else {
            double sum, mean, n;
            sum = 0;
            n = 0;
            Node p = list.getHead();
            while(p != null) {
                sum += Math.pow((index == 0)?p.getData1():p.getData2(),power);
                n++;
                p = p.getNext();
            }
            return sum;
        }
    }

    public static double calculateSumMult(LinkedList list) {
        if(list.getHead() == null) {
            return 0;
        } else {
            double sum, mean, n;
            sum = 0;
            n = 0;
            Node p = list.getHead();
            while(p != null) {
                sum += (p.getData1()*p.getData2());
                n++;
                p = p.getNext();
            }
            return sum;
        }
    }
}