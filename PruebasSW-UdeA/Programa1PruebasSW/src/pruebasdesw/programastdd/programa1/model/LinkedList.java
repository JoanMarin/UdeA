package pruebasdesw.programastdd.programa1.model;

/**
 * @author sebastian.londonoa@udea.edu.co
 * @author johan.marinb@udea.edu.co
 * @author santiago.ramirez9@udea.edu.co
 */

/*
Clase creada para el manejo de datos en forma de lista ligada y sus operaciones basicas
*/

public class LinkedList {
    
    // variable para almanecar el nodo cabeza de la lista
    private Node head;
    
    public LinkedList() {
        this.head = null;
    }
    
    public LinkedList(Node head) {
        this.head = head;
    }
    
    // metodos getters an setters de nodo cabeza
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    
    
    /*
    Metodo utilizado para agregar un  nodo al final de la lista
    */
    public void addNode(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while(node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }
    
    /*
    Elimina el primer nodo que contiene un valor igual al numero dado
    */
    public void removeNode(double number) {
        if(head != null) {
            if(head.getData() == number) {
                head = head.getNext();
            } else {
                Node node = head;
                Node auxNode = head.getNext();
                while(auxNode.getNext() != null) {
                    if(auxNode.getData() == number) {
                        node.setNext(auxNode.getNext());
                    }
                    node = auxNode;
                    auxNode = auxNode.getNext();
                }
            }
        }
    }
}
