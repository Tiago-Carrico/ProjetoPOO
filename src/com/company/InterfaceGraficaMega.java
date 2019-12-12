package com.company;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfaceGraficaMega extends JFrame {

    protected JPanel panelPrincipal, panelProjeto;
    protected JButton buttonCreate, buttonSelect, buttonAssociate;
    protected CentroInvestigacao centro;
    protected DefaultListModel<String> nomesProjetos = new DefaultListModel<String>();
    protected JList<String> listProjetos = new JList<>(nomesProjetos);
    protected JScrollPane listScroller = new JScrollPane(listProjetos);

    private FlowLayout layout = new FlowLayout();

    public void fillListProj( ArrayList<Projeto> list){
        for(int i = 0; i < list.size(); i++){
            nomesProjetos.addElement(list.get(i).getNome());
        }
    }

    public void fillSingleProj(Projeto proj){
        nomesProjetos.addElement(proj.getNome());
    }

    public CentroInvestigacao getCentro(){
        return centro;
    }

    public InterfaceGraficaMega(CentroInvestigacao ci) {
        //Detalhes do painel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(layout);

        //Detalhes da lista
        fillListProj(ci.projetos);

        //Detalhes dos botoes
        buttonCreate = new JButton("Criar Projeto");
        buttonSelect = new JButton("Selecionar Projeto");
        buttonAssociate = new JButton("Associar pessoa");

        buttonCreate.addActionListener(new InterfaceCriarProjeto2());


        //add everything
        panelPrincipal.add(listScroller);
        listScroller.setPreferredSize(new Dimension(700, 600));     //escolhe o tamanho da lista dos projetos
        panelPrincipal.add(buttonCreate);
        panelPrincipal.add(buttonSelect);
        panelPrincipal.add(buttonAssociate);

        this.add(panelPrincipal);
        this.setTitle(centro.getName() + " - Gestor de Projetos");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private class InterfaceCriarProjeto2 extends JFrame implements ActionListener{
        private JPanel panelCriar;
        private JTextField textFieldNome, textFieldAcronimo, textFieldDia, textFieldMes, textFieldAno, textFieldDuracao;
        private JButton buttonCriar;
        private JLabel labelNome, labelAcronimo, labelDia, labelMes, labelAno, labelDuracao;
        private Projeto projeto;
        private JFrame frame2;
        @Override
        public void actionPerformed(ActionEvent ae) {
            this.panelCriar = new JPanel();
            frame2 = new JFrame();
            frame2.setTitle("Criar Projeto");
            frame2.setSize(480, 350);
            frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame2.setResizable(false);
            frame2.setVisible(true);
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
            labelDuracao = new JLabel("Duração (meses):");
            labelDuracao.setBounds(20, 220, 120, 20);

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

            buttonCriar.addActionListener(new criarListener());


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
            frame2.add(panelCriar);
        }
        private class criarListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    Projeto retTemp;
                    String nome = textFieldNome.getText();
                    String acronimo = textFieldAcronimo.getText();
                    String diaTemp = textFieldDia.getText();
                    int dia = Integer.parseInt(diaTemp);
                    String mesTemp = textFieldMes.getText();
                    int mes = Integer.parseInt(mesTemp);
                    String anoTemp = textFieldAno.getText();
                    int ano = Integer.parseInt(anoTemp);
                    String duracaoTemp = textFieldDuracao.getText();
                    int duracao = Integer.parseInt(duracaoTemp);

                    retTemp = new Projeto(nome, acronimo, new Data(dia, mes, ano), duracao);
                    centro.adicionaProjeto(retTemp);
                    projeto = retTemp;
                    fillSingleProj(retTemp);
                    listProjetos = new JList<>(nomesProjetos);
                    listScroller = new JScrollPane(listProjetos);
                    panelPrincipal.add(listScroller);
                    listScroller.setPreferredSize(new Dimension(700, 600));
                    frame2.setVisible(false);


                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }//TODO talvez adicionar uma exceçao caso retTemp esteja vazio, idk
            }
        }

    }

}



