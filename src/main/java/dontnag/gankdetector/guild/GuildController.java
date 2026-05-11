package dontnag.gankdetector.guild;

import dontnag.gankdetector.common.GankController;
import dontnag.gankdetector.guild.dto.Guild;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guild")
public class GuildController extends GankController<Guild> {

    public GuildController(GuildService service){
        super(service);
    }
}
