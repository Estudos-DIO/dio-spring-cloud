package redis.dio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@RedisHash("Carrinho")
public class Carrinho {

    @Id
    private Integer id;
    private List<Item> listaItens;

    public Carrinho() {
    }

    public Carrinho(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getListaItens() {
        if( listaItens == null ) {
            listaItens = new ArrayList<>();
        }

        return listaItens;
    }

    public void setListaItens(List<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public void adicionarItem( Item item ) {
        if( listaItens == null ) {
            listaItens = new ArrayList<>();
        }

        this.listaItens.add( item );
    }
}
