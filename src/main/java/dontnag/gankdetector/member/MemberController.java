package dontnag.gankdetector.member;

import dontnag.gankdetector.member.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Member>> getMembers(@RequestBody GetMembersRequest request){
        return ResponseEntity.ok(service.getMembers(
            request.limit(),
            request.offset()
        ));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Member>> getMembersByUsername(@RequestBody GetMembersByUsernameRequest request){
        return ResponseEntity.ok(service.getMembersByUsername(
            request.limit(),
            request.offset(),
            request.username()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable long id){
        return service.getMemberById(id)
            .map(ResponseEntity::ok)
            .orElseGet(ResponseEntity.notFound()::build);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateMember(@PathVariable long id, @RequestBody UpdateMemberRequest request){
        boolean updated = service.updateMember(id, request);
        return ResponseEntity.status(updated ? 204 : 404).build();
    }

    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody AddMemberRequest request){
        boolean updated = service.addMember(
            request.username(),
            request.password(),
            Role.valueOf(request.role())
        );
        return ResponseEntity.status(updated ? 201 : 400).build();
    }
}
