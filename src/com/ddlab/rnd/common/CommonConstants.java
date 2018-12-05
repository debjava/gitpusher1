package com.ddlab.rnd.common;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class CommonConstants {

  public static final Display DISPLAY = Display.getDefault();
  public static final FontData PLAIN_FONT_DATA = new FontData("Times New Roman", 12, SWT.NORMAL);//Courier New
  public static final FontData BOLD_FONT_DATA = new FontData("Times New Roman", 10, SWT.BOLD);

  public static final Font PLAIN_TXT_FONT = new Font(DISPLAY, PLAIN_FONT_DATA);
  public static final Font BOLD_FONT = new Font(DISPLAY, BOLD_FONT_DATA);

  public static final String[] GIT_ACCOUNTS = new String[] {"GitHub", "Bitbucket"};

  public static final String DLG_SHELL_TXT = "Git account information";
  public static final String DLG_TITLE_TXT = "Git account information";

  public static final String SHELL_IMG_16 = "github16.png";
  public static final String SHELL_IMG_64 = "github64.png";

  public static final String ACT_TYPE_LBL_TXT = "Select Git account type";
  public static final String ACT_TYPE_DECORATOR_TXT = "Select account type, default GitHub";

  public static final String USER_NAME_TEXT = "User name";
  public static final String USER_NAME_DECORATOR_TXT = "User name can not be blank or empty";

  public static final String PWD_LBL_TXT = "Password";
  public static final String PWD_DECORATOE_TXT = "Password can not be blank or empty";

  public static final String REPO_COMBO_DECORATOR_TXT = "Displays the list of repositories";

  public static final String REPO_LBL_TXT = "Test and show my repositories";
}
