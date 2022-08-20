package org.rogerioapp;

import java.io.IOException;
import java.sql.SQLOutput;
import java.text.Normalizer;

public class Msg_rogerio {
    static String conteudo = "";
    public Msg_rogerio(String msg) throws IOException {
        conferirRespostaExiste(msg);
        this.conteudo = conteudo;
    }

    //Esse método confere se existe equivalência de resposta a pergunta feita
    public static void conferirRespostaExiste(String msg) throws IOException {

        Arquivos arq = new Arquivos();

        String[] vetRespostas = arq.lerArquivo("respostas.txt");

        for (int i = 0; i < vetRespostas.length; i++) {
            //dividir a frase no *
            String[] pergResp = vetRespostas[i].split("\\*");

            String conf = pergResp[0].replaceAll(" ","");

            int x = conf.compareTo(msg);
            if(x == 0){
                conteudo = pergResp[1];
                i = vetRespostas.length;
            }else{
                Msg_usuario msgu = new Msg_usuario(msg);
                conteudo = msgu.resposta;
            }

        }
    }

    //Esse método retorna se a palavra existe no dicionario
    public static boolean conferirDicionario(){
        return false;
    }

}
