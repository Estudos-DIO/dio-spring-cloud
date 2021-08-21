package cloud.spring.dio.controller;

import cloud.spring.dio.model.Produto;
import cloud.spring.dio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController
{
    @Autowired
    private ProdutoRepository repositorioProduto;

    @RequestMapping(method = RequestMethod.POST)
    public Produto criar(@RequestBody Produto produto) {
        Produto novoProduto = repositorioProduto.save( produto );
        return novoProduto;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Optional<Produto> procurarPorId(@PathVariable Integer id) {
        Optional<Produto> produto = repositorioProduto.findById( id );
        return produto;
    }

}
