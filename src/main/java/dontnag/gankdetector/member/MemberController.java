package dontnag.gankdetector.member;

import dontnag.gankdetector.common.GankController;
import dontnag.gankdetector.member.dto.Member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController extends GankController<Member> {

    public MemberController(MemberService service){
        super(service);
    }
}
