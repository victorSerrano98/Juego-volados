/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_volados;

import javax.swing.JOptionPane;

/**
 *
 * @author VICTOR SERRANO
 */
public class Juego_Volados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int corridas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Corridas"));
        int dineroInicial = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dinero inicial"));
        int apuestaInicail=10;
        boolean bmeta=true;
        while (bmeta) {            
            int objetivo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Meta"));
            if (objetivo>dineroInicial) {
                bmeta= false;
            }else{
                JOptionPane.showMessageDialog(null, "El dinero de Meta debe ser mayor que el dinero inical");
            }
        }
        
        int c = corridas;
        String aux="";
        int gano = 0, perdio = 0;
        int cantidadAntes = dineroInicial;
        int apuestaAntes = 0;
        System.out.println("+---------------+---------------+---------------+-------------------------------+---------------+----------------+--------------+");
        System.out.println("| Corridas      |  Dinero Antes |    Apuesta\t|\tNumeroAleatorio\t\t|\tGano?\t|Cantidad Despues|\tMeta\t|");
        System.out.println("+---------------+---------------+---------------+-------------------------------+---------------+----------------+--------------+");
        for (int i = 0; i < corridas; i++) {
            boolean b = true;
            int dinero = dineroInicial;
            int apuesta = apuestaInicail;
            int meta = 50;
            
            while (b) {
                double random = Math.random() * 1;
                cantidadAntes= dinero;
                apuestaAntes=apuesta;
                if (random < 0.5) {
                    dinero = dinero + apuesta;
                    aux = "Si";
                    apuesta=apuestaInicail;
                } else {
                    dinero = dinero - apuesta;
                    aux = "No";
                    if (dinero >= (2 * apuesta)) {
                        apuesta = 2 * apuesta;
                    } else {
                        apuesta = dinero;
                    }

                }
                if (dinero >= meta) {
                    b = false;
                    gano++;
                    c--;
                    System.out.println("|    "+(i+1)+"  \t|\t"+cantidadAntes+"\t|\t"+apuestaAntes+"\t|\t"+random+"\t|\t"+aux+"\t|\t"+dinero+"  \t |\tSi\t|");
                    System.out.println("+---------------+---------------+---------------+-------------------------------+---------------+----------------+--------------+");
                } else {
                    if (dinero <= 0) {
                        b = false;
                        perdio++;
                        c--;
                        System.out.println("|    "+(i+1)+"  \t|\t"+cantidadAntes+"\t|\t"+apuestaAntes+"\t|\t"+random+"\t|\t"+aux+"\t|\t"+dinero+"  \t |\tNo\t|");
                        System.out.println("+---------------+---------------+---------------+-------------------------------+---------------+----------------+--------------+");
                    }else{
                        System.out.println("|    "+(i+1)+"  \t|\t"+cantidadAntes+"\t|\t"+apuestaAntes+"\t|\t"+random+"\t|\t"+aux+"\t|\t"+dinero+"  \t |\t-\t|");
                    }
                }

            }

        }
        System.out.println("Ganadas: " + gano + "\n Perdio: " + perdio);
    }

}
