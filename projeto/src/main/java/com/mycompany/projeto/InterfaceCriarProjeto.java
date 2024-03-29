package com.mycompany.projeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfaceCriarProjeto extends JFrame {
    private JPanel panelCriar;
    private JTextField textFieldNome, textFieldAcronimo, textFieldDia, textFieldMes, textFieldAno, textFieldDuracao;
    private JButton buttonCriar;
    private JLabel labelNome, labelAcronimo, labelDia, labelMes, labelAno, labelDuracao;

    public InterfaceCriarProjeto(){
        super();

        //panels
        panelCriar = new JPanel();
        panelCriar.setLayout(null);

        //labels
        labelNome = new JLabel("Nome:");
        labelNome.setBounds(20,20,100,20);
        labelAcronimo = new JLabel("Acronimo:");
        labelAcronimo.setBounds(20, 60, 100, 20);
        labelDia = new JLabel("Dia:");
        labelDia.setBounds(20, 100, 100, 20);
        labelMes = new JLabel("Mês:");
        labelMes.setBounds(20, 140, 100, 20);
        labelAno = new JLabel("Ano:");
        labelAno.setBounds(20, 180, 100, 20);
        labelDuracao = new JLabel("Duração prevista:");
        labelDuracao.setBounds(20, 220, 100, 20);

        //text fields
        textFieldNome = new JTextField();
        textFieldNome.setBounds(150, 20, 300, 20);
        textFieldAcronimo = new JTextField();
        textFieldAcronimo.setBounds(150, 60, 300, 20);
        textFieldDia = new JTextField();
        textFieldDia.setBounds(150, 100, 300, 20);
        textFieldMes = new JTextField();
        textFieldMes.setBounds(150, 140, 300, 20);
        textFieldAno = new JTextField();
        textFieldAno.setBounds(150, 180, 300, 20);
        textFieldDuracao = new JTextField();
        textFieldDuracao.setBounds(150, 220, 300, 20);

        //buttons
        buttonCriar = new JButton("Criar");
        buttonCriar.setBounds(20, 260, 430, 30);

        //Add everything
        panelCriar.add(labelNome);
        panelCriar.add(labelAcronimo);
        panelCriar.add(labelDia);
        panelCriar.add(labelMes);
        panelCriar.add(labelAno);
        panelCriar.add(labelDuracao);
        panelCriar.add(textFieldNome);
        panelCriar.add(textFieldAcronimo);
        panelCriar.add(textFieldDia);
        panelCriar.add(textFieldMes);
        panelCriar.add(textFieldAno);
        panelCriar.add(textFieldDuracao);
        panelCriar.add(buttonCriar);

        this.add(panelCriar);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String nome = textFieldNome.getText();
                String acronimo = textFieldAcronimo.getText();
                String diaTemp = textFieldDia.getText();
                int dia = Integer.parseInt(diaTemp);
                String mesTemp = textFieldMes.getText();
                int mes = Integer.parseInt(mesTemp);
                String anoTemp = textFieldAno.getText();
                int ano = Integer.parseInt(anoTemp);
            }
            catch(Exception ex){}
        }
    }
}
