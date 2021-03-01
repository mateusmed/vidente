package controller;

import dao.PerguntaDao;
import dao.RegraDao;
import entity.Pergunta;
import entity.Regra;
import tools.Ferramentas;

import java.util.ArrayList;
import java.util.List;

public class BaseDeConhecimento {


    private Ferramentas tools;
    private List<String> respostasConhecimento;
    private RegraDao regraDao;

    {
        tools = new Ferramentas();
        respostasConhecimento = new ArrayList<String>();
        regraDao = new RegraDao();
    }

    public List<String> getRespostasConhecimento() {
        return respostasConhecimento;
    }

    public void setRespostasConhecimento(List<String> respostasConhecimento) {
        this.respostasConhecimento = respostasConhecimento;
    }

    public Pergunta getPrimeiraPergunta(){

        PerguntaDao perguntaDao = new PerguntaDao();

        Pergunta p = null;

        try {

            p = perguntaDao.getPerguntaById("A");

        }catch (Exception e){

            System.out.println("ERROR: " + e.getMessage());
        }

        return p;
    }


    public Pergunta proximo(Pergunta p1){


        RegraDao r  = new RegraDao();

        Pergunta proxima = null;

        try {

            proxima = r.getPerguntaFutura(p1, "1");

        }catch (Exception e){

            System.out.println("Error 32 " + e.getMessage());
        }

        return proxima;
    }





    //sempre a cadeia vai para baixo.

    public void fowardChaning(Pergunta perguntaAtual, List<Pergunta> perguntasEspecule){

        //imprima pergunta
        //captura a resposta
        // obtem o futuro
        // chama a si mesmo

        tools.mostreAPergunta(perguntaAtual);
        String respostaUsuario = tools.leiaRespostaUsuario();

        //repita caso digitado errado (TENTE DE NOVO)
        if(respostaUsuario == null){
            fowardChaning(perguntaAtual, perguntasEspecule);
        }

        Pergunta perguntaFuturo = null;
        Pergunta perguntaFuturoX2 = null;

        try {
            perguntaFuturo  = regraDao.getPerguntaFutura(perguntaAtual, respostaUsuario);


            if(perguntasEspecule.contains(perguntaFuturo)){

                perguntaFuturoX2  = regraDao.getPerguntaFutura(perguntaFuturo, "0");

                //add a resposta do presente
                getRespostasConhecimento().add(respostaUsuario);
                //add a resposta de x1
                getRespostasConhecimento().add("0");
                fowardChaning(perguntaFuturoX2, perguntasEspecule);

            }else{

                if(perguntaFuturo.getId() != null){

                    getRespostasConhecimento().add(respostaUsuario);
                    fowardChaning(perguntaFuturo, perguntasEspecule);

                }else{

                    getRespostasConhecimento().add(respostaUsuario);
                    methodB();

                }
            }


        }catch (Exception e){

            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());

        }

    }


    public void methodB(){
        System.out.println("FIM");

    }



}
