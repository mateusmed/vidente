package dao;

import entity.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class PerguntaDao extends DaoMysql{

    public List<Pergunta> getEspeculacao()throws Exception{

        open();

        stmt = con.prepareStatement("select * from pergunta where id_verde= ?");
        stmt.setInt(1, 1);

        rs = stmt.executeQuery();

        List<Pergunta> perguntaList = new ArrayList<Pergunta>();

        while (rs.next()){

            Pergunta p = new Pergunta();

            p.setId(rs.getString(1));
            p.setNomePergunta(rs.getString(2));
            p.setIdVerde(rs.getInt(3));

            perguntaList.add(p);
        }

        close();
        return perguntaList;
   }


    public Pergunta getPerguntaById(String id)throws Exception{

        open();

        stmt = con.prepareStatement("select * from pergunta where id = ?");
        stmt.setString(1, id);

        rs = stmt.executeQuery();

        Pergunta p = new Pergunta();

        if(rs.next()){

            p.setId(rs.getString(1));
            p.setNomePergunta(rs.getString(2));
            p.setIdVerde(rs.getInt(3));

        }

        close();
        return p;
    }



}
