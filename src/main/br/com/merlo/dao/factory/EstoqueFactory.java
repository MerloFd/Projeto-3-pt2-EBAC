package main.br.com.merlo.dao.factory;

import main.br.com.merlo.domain.Estoque;
import main.br.com.merlo.domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueFactory {

        public static Estoque convert (ResultSet rs) throws SQLException {
            Produto produto = ProdutoFactory.convert(rs);
            Estoque estoque = new Estoque();
            estoque.setId(rs.getLong("ID"));
            estoque.setQuantidade(rs.getLong("QUANTIDADE"));
            estoque.setProduto(produto);
            return estoque;
        }
}
