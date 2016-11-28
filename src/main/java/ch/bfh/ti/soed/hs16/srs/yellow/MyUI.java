
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	// Main UI
	private Panel panel = new Panel();
	private VerticalLayout panelContent = new VerticalLayout();
	private VerticalLayout searchLayout = new VerticalLayout();
	private VerticalLayout leftVLayout = new VerticalLayout();
	private VerticalLayout rightVLayout = new VerticalLayout();
	private HorizontalLayout headerLayout = new HorizontalLayout();
	private HorizontalLayout inputLayout = new HorizontalLayout();
	private HorizontalLayout loginLayout = new HorizontalLayout();

	private Label titleLbl = new Label("Search Room");

	private NativeSelect objSelect = new NativeSelect("Objects");
	private NativeSelect equipSelect = new NativeSelect("Equipments");

	private DateField fromDate = new PopupDateField("From");
	private DateField toDate = new PopupDateField("To");

	private Button searchBtn = new Button("Search");
	private Button loginBtn = new Button("Login");
	private Button signupBtn = new Button("Sign Up");

	private Date date;
	private Date lastDate;
	private Calendar limitDate;

	// Sign up
	private Panel sPanel = new Panel();
	private VerticalLayout signVLayout = new VerticalLayout();
	private FormLayout signFormLayout = new FormLayout();
	private HorizontalLayout sHeader = new HorizontalLayout();

	private TextField sUName = new TextField("Username");
	private PasswordField sPwd = new PasswordField("Password");
	private TextField fName = new TextField("Firstname");
	private TextField lName = new TextField("Lastname");
	private TextField emailField = new TextField("Email");

	private Button backBtn = new Button("Back");
	private Button sSignUpBtn = new Button("Sign up");

	// Login
	private Panel lPanel = new Panel();
	private VerticalLayout loginVLayout = new VerticalLayout();
	private FormLayout loginFormLayout = new FormLayout();
	private HorizontalLayout lHeader = new HorizontalLayout();

	private TextField lUName = new TextField("Username");
	private PasswordField lPwd = new PasswordField("Password");

	private Button lLoginBtn = new Button("Login");
	private Button lbackBtn = new Button("Back");


	@Override
	protected void init(VaadinRequest vaadinRequest) {
		// Main UI
		date = new Date();
		limitDate = Calendar.getInstance();
		limitDate.setTime(date);
		limitDate.add(Calendar.YEAR, 1);
		lastDate = limitDate.getTime();

		fromDate.setValue(date);
		fromDate.setRangeStart(date);
		fromDate.setRangeEnd(lastDate);
		fromDate.setImmediate(true);
		fromDate.setResolution(Resolution.MINUTE);

		toDate.setRangeStart(date);
		toDate.setRangeEnd(lastDate);
		toDate.setImmediate(true);
		toDate.setResolution(Resolution.MINUTE);

		objSelect.setSizeFull();
		equipSelect.setSizeFull();
		fromDate.setSizeFull();
		toDate.setSizeFull();
		searchBtn.setSizeFull();

		signupBtn.addClickListener(e -> {
			setContent(sPanel);
		});

		loginBtn.addClickListener(e -> {
			setContent(lPanel);
		});

		loginLayout.addComponents(signupBtn, loginBtn);

		headerLayout.addComponent(titleLbl);
		leftVLayout.addComponents(fromDate, objSelect);
		leftVLayout.setSpacing(true);
		leftVLayout.setSizeFull();
		rightVLayout.addComponents(toDate, equipSelect);
		rightVLayout.setSpacing(true);
		rightVLayout.setSizeFull();
		inputLayout.addComponents(leftVLayout, rightVLayout);
		inputLayout.setSpacing(true);
		inputLayout.setSizeFull();

		searchLayout.addComponents(headerLayout, inputLayout, searchBtn);
		searchLayout.setComponentAlignment(headerLayout, Alignment.TOP_CENTER);
		searchLayout.setMargin(true);
		searchLayout.setSpacing(true);
		searchLayout.setWidth(500, Unit.PIXELS);

		panelContent.addComponents(loginLayout, searchLayout);
		panelContent.setComponentAlignment(searchLayout, Alignment.MIDDLE_CENTER);
		panelContent.setComponentAlignment(loginLayout, Alignment.TOP_RIGHT);
		panel.setContent(panelContent);
		setContent(panel);

		// Sign up
		sUName.setRequired(true);
		sPwd.setRequired(true);
		fName.setRequired(true);
		lName.setRequired(true);
		emailField.setRequired(true);

		sUName.setSizeFull();
		sPwd.setSizeFull();
		fName.setSizeFull();
		lName.setSizeFull();
		emailField.setSizeFull();
		sSignUpBtn.setSizeFull();

		backBtn.addClickListener(e -> {
			setContent(panel);
		});

		signFormLayout.addComponents(sUName, sPwd, fName, lName, emailField, sSignUpBtn);
		signFormLayout.setMargin(true);
		signFormLayout.setWidth(500, Unit.PIXELS);

		sHeader.addComponent(backBtn);

		signVLayout.addComponents(sHeader, signFormLayout);
		signVLayout.setSpacing(true);
		signVLayout.setComponentAlignment(signFormLayout, Alignment.MIDDLE_CENTER);
		signVLayout.setComponentAlignment(sHeader, Alignment.TOP_RIGHT);
		sPanel.setContent(signVLayout);

		// Login
		lUName.setRequired(true);
		lPwd.setRequired(true);

		lUName.setSizeFull();
		lPwd.setSizeFull();
		lLoginBtn.setSizeFull();

		loginFormLayout.addComponents(lUName, lPwd, lLoginBtn);
		loginFormLayout.setMargin(true);
		loginFormLayout.setWidth(500, Unit.PIXELS);

		lHeader.addComponent(lbackBtn);
		lbackBtn.addClickListener(e -> {
			setContent(panel);
		});

		loginVLayout.addComponents(lHeader, loginFormLayout);
		loginVLayout.setSpacing(true);
		loginVLayout.setComponentAlignment(loginFormLayout, Alignment.MIDDLE_CENTER);
		loginVLayout.setComponentAlignment(lHeader, Alignment.TOP_RIGHT);

		lPanel.setContent(loginVLayout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
