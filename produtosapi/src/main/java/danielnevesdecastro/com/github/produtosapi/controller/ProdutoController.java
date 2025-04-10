package danielnevesdecastro.com.github.produtosapi.controller;

import danielnevesdecastro.com.github.produtosapi.model.Produto;
import danielnevesdecastro.com.github.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/salvar")
    public Produto salvar (@RequestBody Produto produto){
        String id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        System.out.println("Produto recebido "+ produto);
        return produto;
    }

}
