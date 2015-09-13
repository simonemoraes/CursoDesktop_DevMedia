package application.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class JanelaSobre extends JDialog {

    private Container container;
    private JanelaBaskaraSwing janelaPrincipal;
    private JButton btEnviar;
    private JProgressBar pbStatus;

    public JanelaSobre(JanelaBaskaraSwing janelaPrincipal) {

        super(janelaPrincipal, true);

        this.janelaPrincipal = janelaPrincipal;

        container = this.getContentPane();

        btEnviar = new JButton("Enviar");
        pbStatus = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);

        container.setLayout(new GridLayout(7, 1));
        container.add(new JLabel("A: " + janelaPrincipal.getTfA().getText()));
        container.add(new JLabel("B: " + janelaPrincipal.getTfB().getText()));
        container.add(new JLabel("B: " + janelaPrincipal.getTfC().getText()));
        container.add(new JLabel("X': " + janelaPrincipal.getLbResultX1().getText()));
        container.add(new JLabel("X'': " + janelaPrincipal.getLbResultX2().getText()));
        container.add(btEnviar);
        container.add(pbStatus);

        btEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btEnviarAction();
            }
        });

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.pack();
        this.setResizable(false);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void btEnviarAction() {
        ProcessarThread pt = new ProcessarThread();
        pt.start();
    }

    /* Classe criada para executar uma thread separado da Thread da janela.*/
    class ProcessarThread extends Thread {

        public void run() {
            for (int i = 1; i <= 100; i++) {
                pbStatus.setValue(i);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        }
    }
}
