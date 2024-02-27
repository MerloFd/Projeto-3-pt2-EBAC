package main.br.com.merlo.dao;

import main.br.com.merlo.dao.generic.IGenericDAO;
import main.br.com.merlo.domain.Venda;
import main.br.com.merlo.exceptions.DAOException;
import main.br.com.merlo.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
