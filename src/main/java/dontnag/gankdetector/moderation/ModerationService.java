package dontnag.gankdetector.moderation;

import dontnag.gankdetector.common.GankService;
import dontnag.gankdetector.moderation.dto.Moderation;

import org.springframework.stereotype.Service;

@Service
public class ModerationService extends GankService<Moderation> {

    public ModerationService(ModerationRepository repository) {
        super(repository);
    }
}
