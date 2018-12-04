package com.ddlab.rnd.dialog;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ddlab.rnd.ui.util.ImageUtil;

public class GitPushDialog extends TitleAreaDialog {

	private final String[] GIT_ACCOUNTS = new String[] { "GitHub", "Bitbucket" };

	private Combo gitActCombo = null;
	private Text userNameText = null;
	private Text passwordText = null;
	private Button showRepoBtn = null;
	private Combo myRepoCombo = null;

	public GitPushDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		getShell().setText("Git account information");
		setTitle("Git account information");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogComposite = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(dialogComposite, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		// createFirstName(container);
		// createLastName(container);

		createGitAccountCombo(container);
		createUserName(container);
		createPassword(container);
		createShowRepo(container);

		return dialogComposite;
	}

	private void createGitAccountCombo(Composite container) {
		Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
		Label gitActLabel = new Label(container, SWT.NONE);
		gitActLabel.setText("Select you Git account :");
		
		gitActLabel.setFont(boldFont);
		gitActLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

//		gitActLabel.setLayoutData(new GridData(GridData.END, SWT.CENTER, false, false));

		gitActCombo = new Combo(container, SWT.READ_ONLY);
		gitActCombo.setItems(GIT_ACCOUNTS);
		gitActCombo.select(0);
		
		
//		GridData gitActComboGdata = new GridData();
//		gitActComboGdata.heightHint = 40;
//		gitActComboGdata.grabExcessHorizontalSpace = true;
//		gitActComboGdata.horizontalAlignment = GridData.FILL;
//		gitActCombo.setLayoutData(gitActComboGdata);
		
		
		GridData gd1 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
	    gd1.heightHint = 15;
//	    gd1.widthHint = 60;
	    gitActCombo.setLayoutData(gd1);
		
		
		
	}

	private void createUserName(Composite container) {
		Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
		Label userNameLabel = new Label(container, SWT.NONE);
		userNameLabel.setText("Enter user name for selected account :");
		userNameLabel.setFont(boldFont);
		
		userNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		
//		userNameLabel.setLayoutData(new GridData(GridData.END, SWT.CENTER, false, false));
		
		
//		userNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));

		userNameText = new Text(container, SWT.NONE);
		
		ControlDecoration decorator = new ControlDecoration(userNameText, SWT.CENTER);
	    decorator.setDescriptionText("Only numeric values are allowed");
	    decorator.setImage(ImageUtil.PROPOSAL_IMAGE);
	    decorator.show();
		
		
//		GridData userNamegData = new GridData();
//		userNamegData.heightHint = 30;
//		userNamegData.widthHint = 60;
//		userNamegData.grabExcessHorizontalSpace = true;
//		userNamegData.horizontalAlignment = GridData.FILL;
		
//		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//	    gd.heightHint = 20;
//	    gd.widthHint = 60;
//	    gd.horizontalAlignment = SWT.FILL;
//	    gd.verticalAlignment = SWT.FILL;
//	    userNameText.setLayoutData(gd);
	    
	    
	    
	    
	    GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
	    gd.heightHint = 30;
//	    gd.widthHint = 60;
	    gd.horizontalAlignment = SWT.FILL;
	    gd.verticalAlignment = SWT.FILL;
	    userNameText.setLayoutData(gd);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
//		userNameText.setLayoutData(userNamegData);
		
		
	}

	private void createPassword(Composite container) {
		Label passwordLabel = new Label(container, SWT.NONE);
		passwordLabel.setText("Enter password for selected account:");
		passwordLabel.setLayoutData(new GridData(GridData.END, SWT.CENTER, false, false));

		passwordText = new Text(container, SWT.PASSWORD);
		GridData userNamegData = new GridData();
		userNamegData.heightHint = 30;
		userNamegData.grabExcessHorizontalSpace = true;
		userNamegData.horizontalAlignment = GridData.FILL;
		passwordText.setLayoutData(userNamegData);
	}
	
	private void createShowRepo(Composite container) {
		showRepoBtn = new Button(container, SWT.NONE);
		showRepoBtn.setText("Test and show my repositories");
		showRepoBtn.setLayoutData(new GridData(GridData.END, SWT.CENTER, false, false));
		
		myRepoCombo = new Combo(container, SWT.READ_ONLY);
		GridData gitActComboGdata = new GridData();
		gitActComboGdata.grabExcessHorizontalSpace = true;
		gitActComboGdata.horizontalAlignment = GridData.FILL;
		myRepoCombo.setLayoutData(gitActComboGdata);
		
		addRepoBtnListener();
	}
	
	private void addRepoBtnListener() {
		showRepoBtn.addSelectionListener( new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				populateRepoCombo();
			}
		});
	}
	
	private void populateRepoCombo() {
		//get the list of repositories;
		String[] repos = new String[] {"a","b","c","d"};
		myRepoCombo.setItems(repos);
		myRepoCombo.select(0);//if items are not empty
	}
	

	// private void createFirstName(Composite container) {
	// Label lbtFirstName = new Label(container, SWT.NONE);
	// lbtFirstName.setText("First Name");
	//
	// GridData dataFirstName = new GridData();
	// dataFirstName.grabExcessHorizontalSpace = true;
	// dataFirstName.horizontalAlignment = GridData.FILL;
	//
	// txtFirstName = new Text(container, SWT.BORDER);
	// txtFirstName.setLayoutData(dataFirstName);
	// }

	@Override
	protected void okPressed() {
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
	}

}
