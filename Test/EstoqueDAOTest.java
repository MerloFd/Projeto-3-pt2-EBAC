import main.br.com.merlo.dao.EstoqueDAO;
import main.br.com.merlo.dao.IEstoqueDAO;
import main.br.com.merlo.dao.IProdutoDAO;
import main.br.com.merlo.dao.ProdutoDAO;
import main.br.com.merlo.domain.Cliente;
import main.br.com.merlo.domain.Estoque;
import main.br.com.merlo.domain.Produto;
import main.br.com.merlo.exceptions.DAOException;
import main.br.com.merlo.exceptions.MaisDeUmRegistroException;
import main.br.com.merlo.exceptions.TableException;
import main.br.com.merlo.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class EstoqueDAOTest {

    private IEstoqueDAO estoqueDAO;

    private IProdutoDAO produtoDAO;
    private Produto produto;

    public EstoqueDAOTest (){
        estoqueDAO = new EstoqueDAO();
        produtoDAO = new ProdutoDAO();
    }

    @After // exclui todos os registros do banco de test
    public void end() throws DAOException {
        Collection<Estoque> list = estoqueDAO.buscarTodos();
        list.forEach(est -> {
            try {
                estoqueDAO.excluir(est.getProduto().getId());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private Estoque criarEstoque(Long codigo){
        Estoque estoque = new Estoque();
        estoque.setQuantidade(codigo);
        estoque.setProduto(this.produto.getId());
        return estoque;
    }

    //mudar a chave de base de estoque pra uma fk de codigo de um produto. Nao da pra seta id pois ele é colocado instantaneamente
    @Test
    public void pesquisarProdutoEstoque () throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException{
        Estoque estoque = criarEstoque(1l);
        Boolean retorno = estoqueDAO.cadastrar(estoque);
        assertTrue(retorno);
    }
}
