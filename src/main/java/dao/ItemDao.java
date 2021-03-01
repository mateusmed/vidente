package dao;

import entity.Item;

public class ItemDao extends DaoMysql{
    //Retornar o item através da consulta no banco onde o return da RegraItem for = a regra da tabela item.
    public Item getItemByRegra(String regra) throws Exception{

        open();

        stmt = con.prepareStatement("select * from item where regra = ?");
        stmt.setString(1, regra);

        rs = stmt.executeQuery();

        Item item = new Item();

        if (rs.next()){
           item.setId(rs.getInt(1));
           item.setNome(rs.getString(2));
           item.setRegra(rs.getString(3));
        }

        close();
        return item;
    }

}
