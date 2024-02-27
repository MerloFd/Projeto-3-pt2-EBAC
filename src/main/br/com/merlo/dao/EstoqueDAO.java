package main.br.com.merlo.dao;

import main.br.com.merlo.dao.generic.GenericDAO;
import main.br.com.merlo.domain.Estoque;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstoqueDAO extends GenericDAO<Estoque,Long> implements IEstoqueDAO {

    public EstoqueDAO (){
        super();
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualiarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setId(entity.getId());
        entityCadastrado.setQuantidade(entity.getQuantidade());
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_ESTOQUE ");
        sb.append("(ID, QUANTIDADE, ID_PROD_ESTOQUE_FK");
        sb.append("VALUES (nextval('sq_estoque'),?,?)");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1,entity.getQuantidade());
        stmInsert.setLong(2,entity.getProduto().getId());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE ID_PROD_ESTOQUE_FK = ? ";
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE FROM TB_ESTOQUE ");
        sb.append("SET QUANTIDADE = ?");
        sb.append(" WHERE ID_PROD_ESTOQUE_FK = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long valor) throws SQLException {
        stmDelete.setLong(1,valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setLong(1,entity.getQuantidade());
        stmUpdate.setLong(2,entity.getProduto().getId());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmUpdate, Long valor) throws SQLException {
        stmUpdate.setLong(1,valor);
    }
}
