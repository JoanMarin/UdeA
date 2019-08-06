package pruebasdesw.programa2.model;

/**
 * @author sebastian.londonoa@udea.edu.co
 * @author johan.marinb@udea.edu.co
 * @author santiago.ramirez9@udea.edu.co
 */

/*
Clase nodo la cual conforma un  elemento   de  lista ligada en este caso sera un nodo simple
*/

public class Node {
    private double data1;
    private double data2;
    private Node next;

    public Node() {
        this.data1 = 0.0;
        this.data2 = 0.0;
        this.next = null;
    }

    public Node(double data1, double data2) {
        this.data1 = data1;
        this.data2 = data2;
        this.next = null;
    }

    public double getData1() {
        return data1;
    }

    public void setData1(double data1) {
        this.data1 = data1;
    }

    public double getData2() {
        return data2;
    }

    public void setData2(double data2) {
        this.data2 = data2;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }  
}