package dontnag.gankdetector.common;

import java.util.List;
import java.util.Optional;

public abstract class GankService<T> {

    protected final GankRepository<T> repository;

    public GankService(GankRepository<T> repository){
        this.repository = repository;
    }

    public List<T> getEntities(long limit, long offset){
        return repository.getEntities(limit, offset);
    }

    public List<T> getEntitiesByName(long limit, long offset, String search){
        return repository.getEntitiesByName(limit, offset, search);
    }

    public Optional<T> getEntityById(long id){
        return Optional.ofNullable(repository.getEntityById(id).getFirst());
    }

    public boolean updateEntity(long id, T member){
        return repository.updateEntity(id, member) > 0;
    }

    public boolean addEntity(T member){
        return repository.addEntity(member) > 0;
    }
}
