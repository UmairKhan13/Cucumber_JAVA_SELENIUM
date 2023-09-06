package org.example.pageObjectClass.loginModule;

import org.example.generalizedOperations.commonActions.WebPortalActions;
import org.example.generalizedOperations.enums.IdentifierType;

import static org.example.pageObjectClass.loginModule.LoginModuleIdentifiers.*;

public class LoginPagePOM extends WebPortalActions {
    public void EnterEmail(String email)
    {
        enterText(IdentifierType.CSS, EmailTxtBox, email);
    }
    public void EnterPassword(String password)
    {
        enterText(IdentifierType.CSS, passwordTxtBox, password);
    }
    public void ClickLoginButton()
    {
        click(IdentifierType.CSS, LoginBtn);
    }
    public void ClickOnLogoutButton()
    {
        click(IdentifierType.CSS, logoutBtn);
    }
    public void ClickOnDashboard()
    {
        click(IdentifierType.CSS, dashBoardBtn);
    }
}