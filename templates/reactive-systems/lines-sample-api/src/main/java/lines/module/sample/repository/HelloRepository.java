package lines.module.sample.repository;


import lines.module.sample.entity.HelloEntity;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

public interface HelloRepository extends CrudRepository<HelloEntity, String> {
    public Flux<HelloEntity> findAllBy();
}
