/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yapayzekahw1;

import javax.swing.JFrame;

/**
 *
 * @author civankorkmaz
 */
public class Main {
    public static void main(String[] args) {
        UI gui = new UI();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setResizable(true);
        gui.setLocationRelativeTo(null);
        gui.setTitle("Path Finder");
    }
    
}
