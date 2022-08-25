package org.rogerioapp;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;

public class Msg_usuario {
    public String conteudo = "";
    public String resposta = "";

    public String mensagemOriginal;

    public Msg_usuario(String cntd) throws IOException {
        this.mensagemOriginal = cntd;
        this.conteudo = cntd;
        juntarFrase();
        verificacoes();
    }

    //Esse método retorna a frase com as palavras juntas e formatadas
    public void juntarFrase(){
        if(!verificarNomeExiste()){
            String mensagem = this.conteudo;
            mensagem = mensagem.toLowerCase();
            mensagem = Normalizer.normalize(mensagem, Normalizer.Form.NFD);
            mensagem = mensagem.replaceAll("[ ?,.!*#$%()+=ªº]","");
            mensagem = mensagem.replaceAll("[^\\p{ASCII}]", "");
            this.conteudo = mensagem;
        }else{
            String[] vetPalavras = separarFrase();
            for(int i = 0; i < vetPalavras.length; i++){
                if(vetPalavras[i].equals("rogerio")){
                    vetPalavras[i] = "";
                }
            }

            String mensagem = Arrays.toString(vetPalavras);
            mensagem = mensagem.replaceAll("[ ?,.!*#$%()+=ªº]","");
            mensagem = mensagem.replaceAll("[\\[\\]\"]", "");
            this.conteudo = mensagem;
        }
    }

    //Esse método retorna a frase num vetor em que cada posição equivale a uma palavra (Sem acentos)
    public String[] separarFrase(){
        String mensagem = this.conteudo;
        mensagem = mensagem.toLowerCase();
        mensagem = Normalizer.normalize(mensagem, Normalizer.Form.NFD);
        mensagem = mensagem.replaceAll("[?,.!*#$%()+=ªº]","");
        mensagem = mensagem.replaceAll("[^\\p{ASCII}]", "");
        String[] vetPalavras = mensagem.split(" ");
        return vetPalavras;
    }

    //Esse método verifica se na mensagem está sendo citado o nome dele ou se é uma pergunta referente a ele
    public boolean verificarNomeExiste(){
        String mensagem = this.conteudo;
        mensagem = mensagem.toLowerCase();
        if(mensagem.contains("rogerio")){
            return true;
        }else{
            return false;
        }
    }

    public void verificacoes() throws IOException {
            //Verifica se a mensagem é apenas Rogério
            if(this.conteudo.equals("rogerio")){
                String[] opcoes = {"Olá","Esse é meu nome","Diga","Oi","Eu","O próprio"};
                int random = (int)(Math.random() * 5);
                this.resposta = opcoes[random];
            }else{
                String[] perguntas1 = {"seunomee","esseeseunome","eseunome","teunome"};
                String[] respostas1 = {"Esse é meu nome","Sim","Exatamente","Como adivinhou?"};
                for(int i = 0; i < perguntas1.length;i++){
                    if(this.conteudo.contains(perguntas1[i])){
                        int random = (int)(Math.random() * 3);
                        this.resposta = respostas1[random];
                    }
                }
            }
        }

    //Retorna uma mensagem randomizada se for reconhecida uma mensagem de adeus
    public static String mensagemAdeus(){
        return "";
    }
}

