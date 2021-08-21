package cloud.spring.dio.repository;

import cloud.spring.dio.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>
{
}
