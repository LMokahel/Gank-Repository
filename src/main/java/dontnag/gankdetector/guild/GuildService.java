package dontnag.gankdetector.guild;

import dontnag.gankdetector.common.GankService;
import dontnag.gankdetector.guild.dto.Guild;

import org.springframework.stereotype.Service;

@Service
public class GuildService extends GankService<Guild> {

    public GuildService(GuildRepository repository){
        super(repository);
    }
}
