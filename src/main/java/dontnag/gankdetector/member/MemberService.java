package dontnag.gankdetector.member;

import dontnag.gankdetector.common.GankService;
import dontnag.gankdetector.member.dto.Member;

import org.springframework.stereotype.Service;

@Service
public class MemberService extends GankService<Member> {

    public MemberService(MemberRepository repository){
        super(repository);
    }
}
