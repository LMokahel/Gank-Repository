package dontnag.gankdetector.member.dto;

import dontnag.gankdetector.member.Role;

public record Member(long id, String username, String password, Role role, boolean valid, String date_created) {

    public String safeRole(){
        if(this.role == null) return null;
        return role.toString();
    }
}
