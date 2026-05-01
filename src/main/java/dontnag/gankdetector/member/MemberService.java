package dontnag.gankdetector.member;

import dontnag.gankdetector.member.dto.Member;
import dontnag.gankdetector.member.dto.UpdateMemberRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository){
        this.repository = repository;
    }

    public List<Member> getMembers(long limit, long offset){
        return repository.getMembers(limit, offset);
    }

    public List<Member> getMembersByUsername(long limit, long offset, String search){
        return repository.getMembersByUsername(limit, offset, search);
    }

    public Optional<Member> getMemberById(long id){
        return Optional.ofNullable(repository.getMemberById(id).getFirst());
    }

    public boolean updateMember(long id, UpdateMemberRequest request){
        return repository.updateMember(id, request.partialMember()) > 0;
    }

    public boolean addMember(String username, String password, Role role){
        return repository.addMember(username, password, role) > 0;
    }
}
