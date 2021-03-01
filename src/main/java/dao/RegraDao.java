package dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entity.Pergunta;
import entity.Regra;

import javax.swing.text.StyledEditorKit;
import java.sql.ResultSet;
import java.util.List;

public class RegraDao extends DaoMysql{


    private PerguntaDao perguntaDao;

    {
        perguntaDao = new PerguntaDao();
    }


    public Regra resultSetRegra(ResultSet rs) throws Exception{
        Regra r = new Regra();

        if(rs.next()){

            r.setId(rs.getInt(1));
            r.setPresente(rs.getString(2));
            r.setDecisao(rs.getString(3));
            r.setFuturo(rs.getString(4));
        }
        return r;
    }

    public Pergunta getPerguntaFutura(Pergunta pergunta, String respostaUsuario)throws Exception{

        open();

        stmt = con.prepareStatement(" select * from regra where presente = ? and decisao = ?");
        stmt.setString(1, pergunta.getId());
        stmt.setString(2, respostaUsuario);

        rs = stmt.executeQuery();

        Regra r = resultSetRegra(rs);


        close();

        return perguntaDao.getPerguntaById(r.getFuturo());

    }


    public Regra getRegra(Pergunta pergunta)throws Exception{

        open();

        stmt = con.prepareStatement(" select * from regra where futuro = ?");
        stmt.setString(1, pergunta.getId());

        rs = stmt.executeQuery();

        Regra r = resultSetRegra(rs);

        close();

        return r;

    }



    public Pergunta getPerguntaPassado(Pergunta pergunta)throws Exception{

        open();

        stmt = con.prepareStatement(" select * from regra where futuro = ?");
        stmt.setString(1, pergunta.getId());

        rs = stmt.executeQuery();

        Regra r = resultSetRegra(rs);

        close();

        return perguntaDao.getPerguntaById(r.getPresente());

    }


}
