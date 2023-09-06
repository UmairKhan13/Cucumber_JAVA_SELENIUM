package org.example.pageObjectClass.loginModule;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static org.example.generalizedOperations.commonActions.WebPortalActions.loadDotenv;
import static org.example.generalizedOperations.configloader.JsonUtils.getValue;
import static org.example.generalizedOperations.constants.FrameworkPathConstants.ENV_FILE_DIR;
import static org.example.generalizedOperations.constants.FrameworkPathConstants.LOGIN_MODULE_TEST_DATA;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LoginPageTestData {
  static Dotenv dotenv = loadDotenv(ENV_FILE_DIR);
  public static final String CORRECT_USER_EMAIL = dotenv.get("email");
  public static final String CORRECT_USER_PASSWORD = dotenv.get("password");
  public static final String ERROR_MESSAGE_ON_WRONG_CREDENTIALS = getValue("ERROR_MESSAGE_ON_WRONG_CREDENTIALS", LOGIN_MODULE_TEST_DATA);
  public static final String PRODUCT_TITLE = getValue("PRODUCT_TITLE", LOGIN_MODULE_TEST_DATA);

}