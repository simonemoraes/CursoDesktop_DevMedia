
package application.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;

public class UsandoFlowLayout {

    public static void main(String[] args) {
       Frame janela = new Frame();
       janela.setTitle( "Título da Janela" );
       
       //o FlowLayout é usado no panel
       janela.setLayout( new FlowLayout());
       
       Button bt1 = new Button( "bt1" );
       Button bt2 = new Button( "bt2" );
       Button bt3 = new Button( "bt3" );
       Button bt4 = new Button( "bt4" );
       Button bt5 = new Button( "bt5" );
       
       janela.add( bt1 );
       janela.add( bt2 );
       janela.add( bt3 );
       janela.add( bt4 );
       janela.add( bt5 );
       
       janela.setSize(640, 480);
       janela.setVisible(true);
       
        
        
        
       
    }
}
