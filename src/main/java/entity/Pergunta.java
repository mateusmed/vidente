package entity;

import java.util.List;

public class Pergunta {

    private String id;
    private String nomePergunta;
    private Integer idVerde;

    public Pergunta() {
    }

    public Pergunta(String id, String nomePergunta, Integer idVerde) {
        this.id = id;
        this.nomePergunta = nomePergunta;
        this.idVerde = idVerde;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomePergunta() {
        return nomePergunta;
    }

    public void setNomePergunta(String nomePergunta) {
        this.nomePergunta = nomePergunta;
    }

    public Integer getIdVerde() {
        return idVerde;
    }

    public void setIdVerde(Integer idVerde) {
        this.idVerde = idVerde;
   }


    @Override
    public boolean equals(Object obj) {

        Pergunta p = (Pergunta) obj;

        if(p != null && id != null){

            if(id.equalsIgnoreCase(p.getId())){

                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pergunta{" +
                "id='" + id + '\'' +
                ", nomePergunta='" + nomePergunta + '\'' +
                ", idVerde=" + idVerde +
                '}';
    }
}
