package security;
import securesocial.core.Identity;
import securesocial.core.java.Authorization;
import utility.Utility;

public class WithAdmin implements Authorization {
    public boolean isAuthorized(Identity user, String params[]) {
        return user.email().get().equals(Utility.ADMIN_EMAIL);
    }
}