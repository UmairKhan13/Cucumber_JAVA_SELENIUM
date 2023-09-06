package org.example.pageObjectClass.loginModule;

import static org.example.generalizedOperations.configloader.JsonUtils.getValue;
import static org.example.generalizedOperations.constants.FrameworkPathConstants.LOGIN_IDENTIFIERS_PATH;
public class LoginModuleIdentifiers {
    public static final String EmailTxtBox = getValue("EmailTxtBox", LOGIN_IDENTIFIERS_PATH);
    public static final String LoginBtn = getValue("LoginBtn", LOGIN_IDENTIFIERS_PATH);
    public static final String errorMessageTxtBox = getValue("errorMessageTxtBox", LOGIN_IDENTIFIERS_PATH);
    public static final String passwordTxtBox = getValue("passwordTxtBox", LOGIN_IDENTIFIERS_PATH);
    public static final String productTitleTxt = getValue("productTitleTxt", LOGIN_IDENTIFIERS_PATH);
    public static final String dashBoardBtn = getValue("dashBoardBtn", LOGIN_IDENTIFIERS_PATH);
    public static final String logoutBtn = getValue("logoutBtn", LOGIN_IDENTIFIERS_PATH);

}