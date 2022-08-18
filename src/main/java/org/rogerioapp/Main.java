package org.rogerioapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.text.Normalizer;
import javax.swing.*;

public class Main extends Frame {

    //-------------------------------------------------------------------------------//
    //!!MÉTODOS!!//

    //Ex. parametro arqLendo: dicionario.txt, log.txt, etc.
    public static String[] lerArquivo(String arqLendo) throws IOException {
        File arq = new File(arqLendo);
        String arqDir = arq.getAbsolutePath();
        BufferedReader buffRead = new BufferedReader(new FileReader(arqDir));

        int N = 0;

        while(buffRead.readLine() != null){
            N += 1;
        }
        buffRead.close();

        BufferedReader br = new BufferedReader(new FileReader(arqDir));

        String[] res = new String[N];

        for(int i = 0; i < N; i++){
            res[i] = br.readLine();
        }

        System.out.println(N);
        br.close();
        return res;
    }

    public static void escreverArquivo(String arqEscrevendo, String mensagem) throws IOException {
        File arq = new File(arqEscrevendo);
        String arqDir = arq.getAbsolutePath();

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqDir, true));

        buffWrite.append(mensagem + "\n");
        buffWrite.close();

    }

    //Esse método retorna a frase com as palavras juntas e formatadas
    public static String juntarFrase(String mensagem){
        mensagem = mensagem.toLowerCase();
        mensagem = Normalizer.normalize(mensagem, Normalizer.Form.NFD);
        mensagem = mensagem.replaceAll("[ ?,.!*#$%()+=ªº]","");
        mensagem = mensagem.replaceAll("[^\\p{ASCII}]", "");
        return mensagem;
    }

    //Esse método retorna a frase num vetor em que cada posição equivale a uma palavra (Sem acentos)
    public static String[] separarPalavras(String mensagem){
        mensagem = mensagem.toLowerCase();
        mensagem = Normalizer.normalize(mensagem, Normalizer.Form.NFD);
        mensagem = mensagem.replaceAll("[?,.!*#$%()+=ªº]","");
        mensagem = mensagem.replaceAll("[^\\p{ASCII}]", "");
        msg_sep_plv = mensagem.split(" ");
        return msg_sep_plv;
    }

    //Esse método verifica se na mensagem está sendo citado o nome dele ou se é uma pergunta referente a ele
    public static String verificarNome(String mensagem){
        String resposta;
        String[] saudacoes = {"ola","oi"};

        if(mensagem.equals("rogerio")){

            resposta = "Sou eu";
            return resposta;

        }else if(mensagem.contains("rogerio")){


            return saudacoes[1];
        }else{
            return "";
        }
    }

    //Esse método retorna se a palavra existe no dicionario
    public static boolean conferirDicionario(){
        return false;
    }

    //Esse método confere se existe equivalência de resposta a pergunta feita
    public static boolean conferirRespostaExiste(){
        return false;
    }

    //Retorna uma mensagem randomizada se for reconhecida uma mensagem de adeus
    public static String mensagemAdeus(){
        return "";
    }

    //--------------------------------------------------------------------------------//
    static ActionListener enviar = new ActionListener(){

        public void actionPerformed(ActionEvent e){


            msg = t.getText();

            msg = juntarFrase(msg);

            msg_maq.setText(verificarNome(msg));

            msg_user.setText(t.getText());

            // set the text of field to blank
            t.setText("");

        }};

    //--------------------------------------------------------------------------------//
    //CRIAÇÃO DA JANELA//
    static TextField t;
    static Button b;
    static Label msg_user;
    static Label msg_maq;
    static Label l2;
    static Label l3;
    static String msg;
    static String[] msg_sep_plv;

    public Main() {
        t = new TextField("");
        b = new Button("ENVIAR");
        msg_user = new Label("");
        msg_maq = new Label("");
        l2 = new Label("");
        l3 = new Label("");

        b.setMaximumSize(new Dimension(100, 50));
        t.setMaximumSize(new Dimension(500, 100));
        msg_user.setMaximumSize(new Dimension(500, 75));
        msg_maq.setMaximumSize(new Dimension(500, 75));
        l2.setMaximumSize(new Dimension(10, 10));
        l3.setMaximumSize(new Dimension(10, 10));

        msg_user.setBackground(Color.decode("#5E5952"));
        msg_user.setForeground(Color.decode("#66CCFF"));
        msg_maq.setBackground(Color.decode("#5E5952"));
        msg_maq.setForeground(Color.decode("#4FFD19"));
        b.setBackground(Color.decode("#66CCFF"));
        b.setForeground(Color.black);

        b.addActionListener(enviar);
        t.addActionListener(enviar);

        add(msg_maq);
        add(msg_user);
        add(l3);
        add(t);
        add(l2);
        add(b);

        setTitle("Rogério");
        setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#4F4B45"));
        setResizable(false);
        setSize(600,350);
        setLocationRelativeTo(null);

        //-------------------------//
        //METODO PARA FECHAR JANELA//
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent we) {
                                  dispose();
                              }
                          }
        );
        //-------------------------//

        setVisible(true);

    }

    public static void main(String args[]){
        Main ex = new Main();
    }
}