package dontnag.gankdetector.common.dto;

public record GetEntitiesByNameRequest(long limit, long offset, String name) {
}
