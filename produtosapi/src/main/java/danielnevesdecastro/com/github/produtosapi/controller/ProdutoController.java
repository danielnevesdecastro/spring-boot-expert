package danielnevesdecastro.com.github.produtosapi.controller;

import danielnevesdecastro.com.github.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @PostMapping("/salvar")
    public Produto salvar (@RequestBody Produto produto){
        System.out.println("Produto recebido "+ produto);
        return produto;
    }

}
