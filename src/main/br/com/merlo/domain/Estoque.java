package main.br.com.merlo.domain;

import main.anotacao.ColunaTabela;
import main.anotacao.Tabela;
import main.anotacao.TipoChave;
import main.br.com.merlo.dao.generic.Persistente;

@Tabela("TB_ESTOQUE")
public class Estoque implements Persistente {
    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;
    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Long quantidade;
    @TipoChave("getProduto.getId")
    @ColunaTabela(dbName = "id_prod_estoque_fk", setJavaName = "setIdProdutoFk")
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
