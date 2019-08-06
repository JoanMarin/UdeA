package pruebasdesw.programastdd.programa1.model;

/**
 * @author sebastian.londonoa@udea.edu.co
 * @author johan.marinb@udea.edu.co
 * @author santiago.ramirez9@udea.edu.co
 */

/*
Clase nodo la cual conforma un  elemento   de  lista ligada en este caso sera un nodo simple
*/

public class Node {
    
    private double data;
    private Node next;
    
    public Node() {
        this.data = 0;
        this.next = null;
    }

    public Node(double data) {
        this.data = data;
        this.next = null;
    }

    public double getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
