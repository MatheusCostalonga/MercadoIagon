package telas;

import component.FormCadastroProduto;
import component.FormCasaIntel;
import component.FormEdicaoProduto;
import component.FormGames;
import component.FormGerenciaUsuario;
import component.FormHardware;
import component.FormHome;
import component.FormPerifirico;
import java.awt.Component;
import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;
import javax.swing.JFrame;
import raven.toast.Notifications;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        Notifications.getInstance().setJFrame(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        GradientDropdownMenu menu = new GradientDropdownMenu();
        menu.addItem("Home");
        menu.addItem("Categorias", "Hardware", "Periféricos", "Games", "Casa Inteligente");
        menu.addItem("ADM", "Cadastro de Produtos", "Modificação de Produtos", "Gerenciamento de usuarios");

        menu.setFont(new java.awt.Font("sansserif", 1, 14));
        menu.applay(this);
        menu.addEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex, boolean menuItem) {
                if (menuItem && index == 0 && subIndex == 0) {
                    showForm(new FormHome());
                } else if (menuItem && index == 1 && subIndex == 1) {
                    showForm(new FormHardware());
                } else if (menuItem && index == 1 && subIndex == 2) {
                    showForm(new FormPerifirico());
                } else if (menuItem && index == 1 && subIndex == 3) {
                    showForm(new FormGames());
                } else if (menuItem && index == 1 && subIndex == 4) {
                    showForm(new FormCasaIntel());
                } else if (menuItem && index == 2 && subIndex == 1) {
                    showForm(new FormCadastroProduto());
                } else if (menuItem && index == 2 && subIndex == 2) {
                    showForm(new FormEdicaoProduto());
                } else if (menuItem && index == 2 && subIndex == 3) {
                    showForm(new FormGerenciaUsuario());
                }
            }
        });
    }

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 1405, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
