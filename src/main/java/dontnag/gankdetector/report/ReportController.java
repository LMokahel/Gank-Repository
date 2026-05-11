package dontnag.gankdetector.report;

import dontnag.gankdetector.common.GankController;
import dontnag.gankdetector.report.dto.Report;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController extends GankController<Report> {

    public ReportController(ReportService service) {
        super(service);
    }
}
