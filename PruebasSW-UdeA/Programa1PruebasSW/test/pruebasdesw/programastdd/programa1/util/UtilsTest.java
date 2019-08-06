/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasdesw.programastdd.programa1.util;

import pruebasdesw.programastdd.programa1.util.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pruebasdesw.programastdd.programa1.model.LinkedList;
import pruebasdesw.programastdd.programa1.model.Node;

/**
 * @author sebastian.londonoa@udea.edu.co
 * @author johan.marinb@udea.edu.co
 * @author santiago.ramirez9@udea.edu.co
 */

/*
casos de pruebas para la clase Util
*/

public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * 1
     * Prueba calcular media en una lista vacia
     */
    @Test
    public void testMeanEmptyList() {
        System.out.println("* Prueba para calcular la media de una lista vacía");
        LinkedList helperList = new LinkedList();
        double mean = Utils.calculateMean(helperList);
        //assertEquals(expected, actual, delta);
        assertEquals(0, mean, 0.01);
    }
    
    /**
     * 2
     * Prueba para calcular la media de una lista con datos positivos enteros
     */
    @Test
    public void testMeanIntegerDataList() {
        System.out.println("* Prueba para calcular la media de una lista con datos positivos enteros");
        LinkedList helperList = new LinkedList(new Node(5));
        helperList.addNode(new Node(8));
        helperList.addNode(new Node(4));
        double mean = Utils.calculateMean(helperList);
        assertEquals(5.66, mean, 0.01);
        
    }
    
    /**
     * 3
     * Prueba para calcular la media de una lista con datos positivos reales
     */
    @Test
    public void testMeanDoubleDataList(){
        System.out.println("* Prueba para calcular la media de una lista con datos positivos reales");
        LinkedList helperList = new LinkedList(new Node(40.5));
        helperList.addNode(new Node(38.3));
        helperList.addNode(new Node(56.4));
        double mean = Utils.calculateMean(helperList);
        assertEquals(45.06, mean, 0.01);
    }
    
    /**
     * 4
     * Prueba para calcular la media de una lista con datos negativos enteros
     */
    @Test
    public void testMeanNegativeIntegerData() {
        System.out.println("* Prueba para calcular la media de una lista con datos negativos enteros");
        LinkedList helperList = new LinkedList(new Node(-5));
        helperList.addNode(new Node(-8));
        helperList.addNode(new Node(-4));
        double mean = Utils.calculateMean(helperList);
        assertEquals(-5.66, mean, 0.01);
        
    }
    
    /**
     * 5
     * Prueba para calcular la media de una lista con datos negativos reales
     */
    @Test
    public void testMeanNegativeDoubleData(){
        System.out.println("* Prueba para calcular la media de una lista con datos negativos reales");
        LinkedList helperList = new LinkedList(new Node(-40.5));
        helperList.addNode(new Node(-38.3));
        helperList.addNode(new Node(-56.4));
        double mean = Utils.calculateMean(helperList);
        assertEquals(-45.06, mean, 0.01);
    }
    
    /**
     * 6
     * Prueba para calcular la media de una lista con datos enteros negativos y positivos
     */
    @Test
    public void testMeanNegativeAndPositiveIntegerData() {
        System.out.println("* Prueba para calcular la media de una lista con datos enteros negativos y positivos");
        LinkedList helperList = new LinkedList(new Node(-5));
        helperList.addNode(new Node(8));
        helperList.addNode(new Node(-4));
        double mean = Utils.calculateMean(helperList);
        assertEquals(-0.33, mean, 0.01);
    }
    
    /**
     * 7
     * Prueba para calcular la media de una lista con datos reales negativos y positivos
     */
    @Test
    public void testMeanNegativeAndPositiveDoubleData() {
        System.out.println("* Prueba para calcular la media de una lista con datos enteros negativos y positivos");
        LinkedList helperList = new LinkedList(new Node(-40.5));
        helperList.addNode(new Node(38.3));
        helperList.addNode(new Node(56.4));
        double mean = Utils.calculateMean(helperList);
        assertEquals(18.06, mean, 0.01);
    }
    
    /**
     * 8
     * Prueba calcular la desviacion estandar de una lista vacia
     */
    @Test
    public void testStdDevEmptyList() {
        System.out.println("* Prueba para calcular la desviación estándar de una lista vacía");
        LinkedList helperList = new LinkedList();
        double stdDev = Utils.calculateStdDev(helperList);
        assertEquals(Double.NaN, stdDev, 0.01);
    }
    /**
     * 9
     * Prueba para calcular la desviación estándar de una lista con datos negativos y positivos 
     */
    @Test
    public void testStdDev() {
        System.out.println("* Prueba para calcular la desviación estándar de una lista con datos negativos y positivos");
        LinkedList helperList = new LinkedList(new Node(-5));
        helperList.addNode(new Node(8.0));
        helperList.addNode(new Node(-4.4));
        double stdDev = Utils.calculateStdDev(helperList);
        assertEquals(7.33, stdDev, 0.01);
        helperList = new LinkedList(new Node(-5));
        helperList.addNode(new Node(7.0));
        helperList.addNode(new Node(-4.4));
        stdDev = Utils.calculateStdDev(helperList);
        assertEquals(6.76, stdDev, 0.01);
        helperList = new LinkedList(new Node(5));
        helperList.addNode(new Node(8.0));
        helperList.addNode(new Node(4.4));
        stdDev = Utils.calculateStdDev(helperList);
        assertEquals(1.92, stdDev, 0.01);
    }
    
    /**
     * 10
     * Prueba lectura del archivo con los datos, cuando el archivo existe
     * @throws IOException 
     */
    @Test
    public void testReadText() throws IOException {
        System.out.println("* Prueba para la lectura del archivo con los datos");
        LinkedList helperList = Utils.getData(new File("src/pruebasdesw/programastdd/programa1/files/testFile.txt"));
    }
    
    /**
     * 11
     * Prueba para lectura del archivo con los datos, cuando el archivo no existe
     * @throws IOException 
     */
    @Test(expected=FileNotFoundException.class)
    public void testReadTextNoFile() throws IOException {
        System.out.println("* Prueba para excepción cuando archivo no existe");
        LinkedList helperList = Utils.getData(new File("src/pruebasdesw/programastdd/programa1/files/noFile.txt"));
    }
    
    /**
     * 12
     * Prueba para toda la funcionalidad del manejo de datos (archivos)
     * @throws IOException 
     */
    @Test
    public void testData() throws IOException {
        System.out.println("* Prueba para toda la funcionalidad del manejo de datos (archivos)");
        LinkedList helperList = Utils.getData(new  File("src/pruebasdesw/programastdd/programa1/files/testFile.txt"));
        Node p = helperList.getHead();
        assertEquals(404, p.getData(), 0.01);
        p = p.getNext();
        assertEquals(149, p.getData(), 0.01);
        p = p.getNext();
        assertEquals(187, p.getData(), 0.01);
        p = p.getNext();
        assertEquals(499, p.getData(), 0.01);
    }
    /**+
     * 13
     * Prueba para toda la funcionalidad de los calculos
     * @throws IOException 
     */
    @Test
    public void testAll() throws IOException {
        System.out.println("* Prueba para toda la funcionalidad de los calculos");
        LinkedList helperList = Utils.getData(new File("src/pruebasdesw/programastdd/programa1/files/colum1.txt"));
        double mean = Utils.calculateMean(helperList);
        double stdDev = Utils.calculateStdDev(helperList);
        System.out.println("    -columna 1");
        assertEquals(550.6, mean, 0.01);
        assertEquals(572.03, stdDev, 0.01);
        
        helperList = Utils.getData(new File("src/pruebasdesw/programastdd/programa1/files/colum2.txt"));
        mean = Utils.calculateMean(helperList);
        stdDev = Utils.calculateStdDev(helperList);
        System.out.println("    -columna 2");
        assertEquals(60.32, mean, 0.01);
        assertEquals(62.26, stdDev, 0.01);
    }
}
