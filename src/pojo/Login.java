package pojo;

public class Login {
    private int loginId;
    private String loginName;
    private String password;

    public Login(int loginId, String loginName, String password) {
        this.loginId = loginId;
        this.loginName = loginName;
        this.password = password;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return loginName;
    }
}
