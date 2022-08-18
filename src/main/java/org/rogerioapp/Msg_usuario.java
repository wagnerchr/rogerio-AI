package org.rogerioapp;

import java.text.Normalizer;

public class Msg_usuario {
    public String conteudo = "";
    public String resposta = "";

    public Msg_usuario(String conteudo){
        this.conteudo = conteudo;
    }

    //Esse método retorna a frase com as palavras juntas e formatadas
    public String juntarFrase(){
        String mensagem = this.conteudo;
        mensagem = mensagem.toLowerCase();
        mensagem = Normalizer.normalize(mensagem, Normalizer.Form.NFD);
        mensagem = mensagem.replaceAll("[ ,.!*#$%()+=ªº]","");
        mensagem = mensagem.replaceAll("[^\\p{ASCII}]", "");
        this.conteudo = mensagem;
        System.out.println(this.conteudo);
        return mensagem;
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
        if(mensagem.contains("rogerio")){
            return true;
        }else{
            return false;
        }
    }

    public void verificacoes(){
        juntarFrase();

        if(verificarNomeExiste()){
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
        }else{

        }
    }
    //Esse método confere se existe equivalência de resposta a pergunta feita
    public static boolean conferirRespostaExiste(){
        return false;
    }

    //Retorna uma mensagem randomizada se for reconhecida uma mensagem de adeus
    public static String mensagemAdeus(){
        return "";
    }
}
