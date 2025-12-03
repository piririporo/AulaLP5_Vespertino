/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Pedidos;
import bean.PedidosProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u1845853
 */
public class PedidosProdutosDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    public void deleteProdutos(Pedidos pedidos) {
        //listar todos os produtos do pedido
        List lista = (List) listProdutos(pedidos);
        //deleta  a lista acima 
        session.beginTransaction();
        for (int i = 0; i < lista.size(); i++) {
            PedidosProdutos pedidosProdutos = (PedidosProdutos) lista.get(i);
            //delete(pedidosProdutos);
            session.flush();
            session.clear();
            session.delete(pedidosProdutos);
        }
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(PedidosProdutos.class);
        criteria.add(Restrictions.eq("idpedidosProdutos", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listProdutos(Pedidos pedidos) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(PedidosProdutos.class);
        criteria.add(Restrictions.eq("pedidos", pedidos));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(PedidosProdutos.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        PedidosProdutosDAO usuariosDAO = new PedidosProdutosDAO();
        usuariosDAO.listAll();
    }
}
