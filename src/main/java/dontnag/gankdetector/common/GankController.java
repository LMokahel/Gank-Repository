package dontnag.gankdetector.common;

import dontnag.gankdetector.common.dto.GetEntitiesByNameRequest;
import dontnag.gankdetector.common.dto.GetEntitiesRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GankController<T> {

    protected final GankService<T> service;

    public GankController(GankService<T> service){
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<T>> getEntities(@RequestBody GetEntitiesRequest request){
        return ResponseEntity.ok(service.getEntities(
            request.limit(),
            request.offset()
        ));
    }

    @GetMapping("/search")
    public ResponseEntity<List<T>> getEntitiesByName(@RequestBody GetEntitiesByNameRequest request){
        return ResponseEntity.ok(service.getEntitiesByName(
            request.limit(),
            request.offset(),
            request.name()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getEntityById(@PathVariable long id){
        return service.getEntityById(id)
            .map(ResponseEntity::ok)
            .orElseGet(ResponseEntity.notFound()::build);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateEntity(@PathVariable long id, @RequestBody T request){
        boolean updated = service.updateEntity(id, request);
        return ResponseEntity.status(updated ? 204 : 404).build();
    }

    @PostMapping
    public ResponseEntity<String> addEntity(@RequestBody T request){
        boolean updated = service.addEntity(request);
        return ResponseEntity.status(updated ? 201 : 400).build();
    }
}
