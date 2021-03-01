package controller;

import com.sun.org.apache.xpath.internal.functions.FuncConcat;
import dao.ItemDao;
import dao.PerguntaDao;
import dao.RegraDao;
import entity.Item;
import entity.Pergunta;
import entity.Regra;
import tools.Ferramentas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MotorDeInferencia {

    private Ferramentas tools;
    private List<String> respostasInferencia;
    private RegraDao regraDao;
    private List<Pergunta> perguntasEspecule;

    {
        tools = new Ferramentas();
        respostasInferencia = new ArrayList<String>();
        regraDao = new RegraDao();
        perguntasEspecule = new ArrayList<Pergunta>();
    }

    public List<Pergunta> getPerguntasEspecule() {
        return perguntasEspecule;
    }

    public void setPerguntasEspecule(List<Pergunta> perguntasEspecule) {
        this.perguntasEspecule = perguntasEspecule;
    }

    public List<String> getRespostasInferencia() {
        return respostasInferencia;
    }

    public void setRespostasInferencia(List<String> respostasInferencia) {
        this.respostasInferencia = respostasInferencia;
    }

    public List<Pergunta> allEspeculacoes(){

        PerguntaDao perguntaDao = new PerguntaDao();

        try {

            List<Pergunta> especulacoes = perguntaDao.getEspeculacao();
            return especulacoes;

        }catch (Exception e){

            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }


    public void backwardChaning(Pergunta perguntaAtual){

        if(perguntaAtual.getId() == null){
            return;
        }


        try {
            Pergunta perguntaPassado  = regraDao.getPerguntaPassado(perguntaAtual);


            if(perguntaPassado.getId() != null){

                Regra regra = regraDao.getRegra(perguntaAtual);

                getRespostasInferencia().add(regra.getDecisao());

                backwardChaning(perguntaPassado);

            }else{
                backwardChaning(perguntaPassado);
            }

        }catch (Exception e){

            System.out.println("ERROR: " + e.getMessage());

        }

    }

    public void methodB(){
        System.out.println("SAIDA");

    }

    public Pergunta especule(){

          Random randomizer = new Random();
          Ferramentas tools = new Ferramentas();

          List<Pergunta> especulacoes = allEspeculacoes();

          String repostaEspeculacao;

          int cont= 1;

        Pergunta indiceEspeculacao = null;

        do{

              indiceEspeculacao = especulacoes.get(randomizer.nextInt(especulacoes.size()));

              tools.mostreAPergunta(indiceEspeculacao);

              repostaEspeculacao = tools.leiaRespostaUsuario();


              if(repostaEspeculacao == "1"){

                  getRespostasInferencia().add(repostaEspeculacao);
                  return indiceEspeculacao;
              }

              getPerguntasEspecule().add(indiceEspeculacao);
              especulacoes.remove(indiceEspeculacao);

              cont++;


          }while(repostaEspeculacao != "1" && cont <= 4);


          // já manda para o inicio da arvore

         return null;
      }

      public String cleanString(String result){
          return result.toString().replace("[", "").replace(",", "").replace("]", "").replace(" ", "");
      }


     //Concatena as regras do Item
      public String regraItem(List<String> rc, List<String> ri){

          if(ri.isEmpty()){
              return rc.toString().replace("[", "").replace(",", "").replace("]", "").replace(" ", "");
          }



          rc.addAll(ri);
          Collections.reverse(rc);

          return rc.toString().replace("[", "").replace(",", "").replace("]", "").replace(" ", "");

      }

      public Item itemEscolhido(List<String> rc, List<String> ri){
          Item item = new Item();
          ItemDao itemDao = new ItemDao();
        try{
            String resposta = regraItem(rc, ri);

            item = itemDao.getItemByRegra(resposta);
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }

        return item;
      }

}
