package redis.dio.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Item")
public class Item {

    private Integer idProduto;
    private Integer quantidade;

    public Item() {
    }

    public Item(Integer idProduto, Integer quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
