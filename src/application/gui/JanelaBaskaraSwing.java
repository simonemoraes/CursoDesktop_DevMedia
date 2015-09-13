package application.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JanelaBaskaraSwing extends JFrame {

    private JButton btCalcular;
    private JButton btLimpar;
    private JTextField tfA;
    private JTextField tfB;
    private JTextField tfC;
    private JLabel lbA;
    private JLabel lbB;
    private JLabel lbC;
    private JLabel lbX1;
    private JLabel lbX2;
    private JLabel lbResultX1;
    private JLabel lbResultX2;
    private JMenuBar barraMenu;
    private JMenu mnArquivo;
    private JMenu mnAjuda;
    private JMenuItem miNovo;
    private JMenuItem miSair;
    private JMenuItem miSobre;
    private Container container;

    public JanelaBaskaraSwing() {
        super("Fórmula de Baskara");


        container = this.getContentPane();//recupera o container da tela
        container.setLayout(new FlowLayout());//Layout de fluxo

        btCalcular = new JButton("Calcular");
        btLimpar = new JButton("Limpar");
        tfA = new JTextField(10);
        tfB = new JTextField(10);
        tfC = new JTextField(10);
        lbResultX1 = new JLabel("0.0");
        lbResultX2 = new JLabel("0.0");
        barraMenu = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnAjuda = new JMenu("Ajuda");
        miNovo = new JMenuItem("Novo");
        miSair = new JMenuItem("Sair");
        miSobre = new JMenuItem("Sobre...");

        barraMenu.add(mnArquivo);
        barraMenu.add(mnAjuda);

        mnArquivo.add(miNovo);
        mnArquivo.add(miSair);
        mnAjuda.add(miSobre);

        this.setJMenuBar(barraMenu);

        container.add(new JLabel("A:"));
        container.add(tfA);
        container.add(new JLabel("B:"));
        container.add(tfB);
        container.add(new JLabel("C:"));
        container.add(tfC);
        container.add(btCalcular);
        container.add(new JLabel("X':"));
        container.add(lbResultX1);
        container.add(new JLabel("X'':"));
        container.add(lbResultX2);
        container.add(btLimpar);

        container.setBackground(Color.green);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Implementando o metodo ActionListener.*/
        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btCalcularAction();
            }
        });
        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btLimparAction();
            }
        });
        miNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miNovoAction();
            }
        });
        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miSairAction();
            }
        });
        miSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miSobreAction();
            }
        });

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    

    private void btCalcularAction() {

        if (isCamposConsistentes()) {
            //entrada
            double a = Double.parseDouble(getTfA().getText());
            double b = Double.parseDouble(getTfB().getText());
            double c = Double.parseDouble(getTfC().getText());

            //processamento
            double delta = Math.pow(b, 2) - 4 * a * c;

            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);

            //saida
            getLbResultX1().setText(String.valueOf(x1));
            getLbResultX2().setText(String.valueOf(x2));
        } else {
            JOptionPane.showMessageDialog(this, "Campos Inconsistentes.");
        }
    }

    private void btLimparAction() {
        limpar();
    }

    private void limpar() {
        getTfA().setText("");
        getTfB().setText("");
        getTfC().setText("");
        getLbResultX1().setText("0.0");
        getLbResultX2().setText("0.0");
    }

    private void miNovoAction() {
        limpar();
    }

    private void miSairAction() {
        System.exit(0);
    }
    
    private void miSobreAction(){
        new JanelaSobre(this);
    }

    /* Tratando Inconsistencias.*/
    private boolean isCamposConsistentes() {

        String a = getTfA().getText().trim();
        String b = getTfB().getText().trim();
        String c = getTfC().getText().trim();

        if (a.equals("")) {
            getTfA().requestFocus();//deixara o o campo com erro piscando
            return false;
        } else if (b.equals("")) {
            getTfB().requestFocus();//deixara o o campo com erro piscando
            return false;
        } else if (c.equals("")) {
            getTfC().requestFocus();//deixara o o campo com erro piscando
            return false;
        }

        try {
            Double.parseDouble(a);
        } catch (Exception e) {
            getTfA().requestFocus();//deixara o o campo com erro piscando
            return false;
        }

        try {
            Double.parseDouble(b);
        } catch (Exception e) {
            getTfB().requestFocus();//deixara o o campo com erro piscando
            return false;
        }

        try {
            Double.parseDouble(c);
        } catch (Exception e) {
            getTfC().requestFocus();//deixara o o campo com erro piscando
            return false;
        }

        return true;
    }

    /* Metodos acessores*/
    public JTextField getTfA() {
        return tfA;
    }

    /**
     * @param tfA the tfA to set
     */
    public void setTfA(JTextField tfA) {
        this.tfA = tfA;
    }

    /**
     * @return the tfB
     */
    public JTextField getTfB() {
        return tfB;
    }

    /**
     * @param tfB the tfB to set
     */
    public void setTfB(JTextField tfB) {
        this.tfB = tfB;
    }

    /**
     * @return the tfC
     */
    public JTextField getTfC() {
        return tfC;
    }

    /**
     * @param tfC the tfC to set
     */
    public void setTfC(JTextField tfC) {
        this.tfC = tfC;
    }

    /**
     * @return the lbResultX1
     */
    public JLabel getLbResultX1() {
        return lbResultX1;
    }

    /**
     * @param lbResultX1 the lbResultX1 to set
     */
    public void setLbResultX1(JLabel lbResultX1) {
        this.lbResultX1 = lbResultX1;
    }

    /**
     * @return the lbResultX2
     */
    public JLabel getLbResultX2() {
        return lbResultX2;
    }

    /**
     * @param lbResultX2 the lbResultX2 to set
     */
    public void setLbResultX2(JLabel lbResultX2) {
        this.lbResultX2 = lbResultX2;
    }
    
    public static void main(String[] args) {

        new JanelaBaskaraSwing();
    }
}
