package controller;

import entity.Pergunta;
import tools.Ferramentas;

import javax.xml.transform.sax.SAXSource;


public class Main {



    public static void main(String[] args) {


        Ferramentas tools = new Ferramentas();
        tools.titulo();

        MotorDeInferencia motorDeInferencia = new MotorDeInferencia();
        BaseDeConhecimento base = new BaseDeConhecimento();

        Pergunta p = motorDeInferencia.especule();

        if(p == null){

           base.fowardChaning(base.getPrimeiraPergunta(), motorDeInferencia.getPerguntasEspecule());

        }else{

            motorDeInferencia.backwardChaning(p);

            if(base.proximo(p).getId() != null){
                base.fowardChaning(base.proximo(p), motorDeInferencia.getPerguntasEspecule());
            }
        }

        System.out.println(motorDeInferencia.itemEscolhido(base.getRespostasConhecimento(), motorDeInferencia.getRespostasInferencia()));

    }


}
