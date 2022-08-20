package org.rogerioapp;

import java.io.*;

public class Arquivos {
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
}
