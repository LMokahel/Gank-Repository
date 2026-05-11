package dontnag.gankdetector.moderation;

import dontnag.gankdetector.common.GankController;
import dontnag.gankdetector.moderation.dto.Moderation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moderation")
public class ModerationController extends GankController<Moderation> {

    public ModerationController(ModerationService service) {
        super(service);
    }
}
