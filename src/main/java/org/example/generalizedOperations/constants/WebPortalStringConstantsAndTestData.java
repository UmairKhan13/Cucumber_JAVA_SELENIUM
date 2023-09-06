package org.example.generalizedOperations.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;

import static org.example.generalizedOperations.constants.FrameworkPathConstants.PROJECT_PATH;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebPortalStringConstantsAndTestData {
    public static final String TEST_RESOURCES_DIR = PROJECT_PATH + File.separator + "src/test/resources";
    public static final String CHROME_DRIVER_EXE_PATH =
            TEST_RESOURCES_DIR + File.separator + "executables" + File.separator + "chromedriver";
    public static final String CHROME_WEB_DRIVER = "webdriver.chrome.driver";

}