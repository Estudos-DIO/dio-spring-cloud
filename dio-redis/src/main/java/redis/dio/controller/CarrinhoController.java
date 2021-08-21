package redis.dio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.dio.model.Carrinho;
import redis.dio.model.Item;
import redis.dio.repository.CarrinhoRepository;

import java.util.Optional;

@RestController
@RequestMapping(value="/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository repositorioCarrinho;

    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public Carrinho adicionarItem(@PathVariable Integer id, @RequestBody Item item) {
        Optional<Carrinho> salvarCarrinho = repositorioCarrinho.findById( id );
        Carrinho novoCarrinho = null;

        if( !salvarCarrinho.isPresent() ) {
            novoCarrinho = new Carrinho( id );
        } else {
            novoCarrinho = salvarCarrinho.get();
        }

        novoCarrinho.getListaItens().add( item );
        novoCarrinho = repositorioCarrinho.save( novoCarrinho );

        return novoCarrinho;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Optional<Carrinho> procurarPorId( @PathVariable Integer id ) {
        Optional<Carrinho> optCarrinho = repositorioCarrinho.findById( id );
        return optCarrinho;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void remover( @PathVariable Integer id ) {
        repositorioCarrinho.deleteById( id );
    }
}
