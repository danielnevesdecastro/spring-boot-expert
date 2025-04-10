package danielnevesdecastro.com.github.produtosapi.repository;

import danielnevesdecastro.com.github.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
