package danielnevesdecastro.com.github.produtosapi.controller;

import danielnevesdecastro.com.github.produtosapi.model.Produto;
import danielnevesdecastro.com.github.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
//        Optional<Produto> produto = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null ; //forma literal
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Produto atualizar(@PathVariable("id")  String  id , @RequestBody Produto    produto){
        produto.setId(id);
        return  produtoRepository.save(produto);
    }
}
