package entity;

public class Regra {

    private Integer id;
    private String presente;
    private String decisao;
    private String futuro;


    public Regra() {
    }

    public Regra(Integer id, String presente, String decisao, String futuro) {
        this.id = id;
        this.presente = presente;
        this.decisao = decisao;
        this.futuro = futuro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPresente() {
        return presente;
    }

    public void setPresente(String presente) {
        this.presente = presente;
    }

    public String getDecisao() {
        return decisao;
    }

    public void setDecisao(String decisao) {
        this.decisao = decisao;
    }

    public String getFuturo() {
        return futuro;
    }

    public void setFuturo(String futuro) {
        this.futuro = futuro;
    }

    @Override
    public String toString() {
        return "Regra{" +
                "id=" + id +
                ", presente='" + presente + '\'' +
                ", decisao='" + decisao + '\'' +
                ", futuro='" + futuro + '\'' +
                '}';
    }
}
