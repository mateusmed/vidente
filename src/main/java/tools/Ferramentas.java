package tools;


import entity.Pergunta;

import java.util.Scanner;

public class Ferramentas {

    public String leiaRespostaUsuario(){
        Scanner input= new Scanner(System.in);

        String resposta = input.next();

        if(resposta.equalsIgnoreCase("s")){

            return "1";
        }else if (resposta.equalsIgnoreCase("n")){
            return "0";
        }else{
            mostreErro();
        }

        return null;
    }


    public boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public void titulo(){
        System.out.println("======================");
        System.out.println("Selecione: ");
        System.out.println("S - para verdade");
        System.out.println("N - para falso");
        System.out.println("======================");
    }


    public void mostreAPergunta(Pergunta p){
        System.out.println("======================");
        System.out.println(p.getNomePergunta());
        System.out.println("======================");

    }


    public void mostreErro(){
        System.out.println("======================");
        System.out.println("Resposta Invalida, reiniciando o programa.");
        System.out.println("======================");

    }
}