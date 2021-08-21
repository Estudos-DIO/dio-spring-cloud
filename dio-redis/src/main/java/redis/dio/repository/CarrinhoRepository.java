package redis.dio.repository;

import org.springframework.data.repository.CrudRepository;
import redis.dio.model.Carrinho;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Integer> {
}
