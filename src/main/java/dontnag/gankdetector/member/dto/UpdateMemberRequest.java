package dontnag.gankdetector.member.dto;

import dontnag.gankdetector.member.Role;

public class UpdateMemberRequest {

    private final String username;
    private final String password;
    private final String role;
    private final boolean valid;

    public UpdateMemberRequest(String username, String password, String role, boolean valid){
        this.username = username;
        this.password = password;
        this.role = role;
        this.valid = valid;
    }

    public String getUsername(){
        if(this.username.isEmpty()) return null;
        return this.username;
    }

    public String getPassword(){
        if(this.password.isEmpty()) return null;
        return this.password;
    }

    public Role getRole(){
        if(this.role.isEmpty()) return null;
        return Role.valueOf(this.role);
    }

    public boolean isValid(){
        return this.valid;
    }

    public Member partialMember(){
        return new Member(-1, this.getUsername(), this.getPassword(), this.getRole(), null, this.isValid());
    }
}
