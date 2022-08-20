package org.rogerioapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Interface extends Frame {
    static TextField textbox;
    static Button btnEviar;
    static Label lmsguser;
    static Label lmsgrogerio;
    static Label l2;
    static Label l3;

    public Interface(){
        textbox = new TextField("");
        btnEviar = new Button("ENVIAR");
        lmsguser = new Label("");
        lmsgrogerio = new Label("");
        l2 = new Label("");
        l3 = new Label("");

        btnEviar.setMaximumSize(new Dimension(100, 50));
        textbox.setMaximumSize(new Dimension(500, 100));
        lmsguser.setMaximumSize(new Dimension(500, 75));
        lmsgrogerio.setMaximumSize(new Dimension(500, 75));
        l2.setMaximumSize(new Dimension(10, 10));
        l3.setMaximumSize(new Dimension(10, 10));

        lmsguser.setBackground(Color.decode("#5E5952"));
        lmsguser.setForeground(Color.decode("#66CCFF"));
        lmsgrogerio.setBackground(Color.decode("#5E5952"));
        lmsgrogerio.setForeground(Color.decode("#4FFD19"));
        btnEviar.setBackground(Color.decode("#66CCFF"));
        btnEviar.setForeground(Color.black);

        btnEviar.addActionListener(enviar);
        textbox.addActionListener(enviar);

        add(lmsgrogerio);
        add(lmsguser);
        add(l3);
        add(textbox);
        add(l2);
        add(btnEviar);

        setTitle("Rogério");
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
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

    static ActionListener enviar = new ActionListener(){

        public void actionPerformed(ActionEvent e){
            lmsguser.setText(textbox.getText());

            try {
                Msg_usuario msgu = new Msg_usuario(textbox.getText());

                Msg_rogerio msgr = new Msg_rogerio(msgu.conteudo);

                //Mostra a mensagem do rogério
                lmsgrogerio.setText(msgr.conteudo);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


            // Mantém em branco a caixa de texto
            textbox.setText("");

        }
    };
}
