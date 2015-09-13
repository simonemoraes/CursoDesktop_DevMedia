
package application.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JButton;

public class PrimeiraJanela {

    public static void main(String[] args) {
       Frame janela = new Frame();
       janela.setTitle( "Título da Janela" );
       
       Button btCentro = new Button( "Centro" );
       Button btNorte = new Button( "Norte" );
       Button btSul = new Button( "Sul" );
       Button btLeste = new Button( "Leste" );
       Button btOeste = new Button( "Oeste" );
       
       btCentro.setBackground(Color.red);
       btSul.setBackground(Color.blue);
       btNorte.setBackground(Color.yellow);
       
       btCentro.setForeground(Color.white);
       
       janela.add( btCentro, BorderLayout.CENTER );
       janela.add( btNorte, BorderLayout.NORTH );
       janela.add( btSul, BorderLayout.SOUTH );
       janela.add( btLeste, BorderLayout.EAST );
       janela.add( btOeste, BorderLayout.WEST );
       
       janela.setSize(640, 480);
       janela.setVisible(true);
       
        
        
        
       
    }
}
