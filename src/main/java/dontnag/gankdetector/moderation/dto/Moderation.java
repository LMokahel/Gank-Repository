package dontnag.gankdetector.moderation.dto;

import dontnag.gankdetector.report.ReportStatus;

public record Moderation (long id, long moderator_id, long report_id, String description, ReportStatus updated_status, String date_created){
}
