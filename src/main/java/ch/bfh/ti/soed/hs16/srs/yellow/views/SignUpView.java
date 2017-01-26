
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.views;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.ti.soed.hs16.srs.yellow.controllers.JPAProxyDataAccessor;
import ch.bfh.ti.soed.hs16.srs.yellow.validation.EMailValidationStrategy;
import ch.bfh.ti.soed.hs16.srs.yellow.validation.PasswordValidationStrategy;
import ch.bfh.ti.soed.hs16.srs.yellow.validation.UserNameValidationStrategy;
import ch.bfh.ti.soed.hs16.srs.yellow.validation.ValidationContext;

@Theme("mytheme")
public class SignUpView extends CustomComponent implements View {

	// TODO Unused field
	private Panel sPanel = new Panel();

	private VerticalLayout signVLayout = new VerticalLayout();

	private FormLayout signFormLayout = new FormLayout();

	private HorizontalLayout sHeader = new HorizontalLayout();

	private TextField sUName = new TextField("Username");

	private PasswordField sPwd = new PasswordField("Password");

	private TextField fName = new TextField("Firstname");

	private TextField lName = new TextField("Lastname");

	private TextField emailField = new TextField("Email");

	private Button backBtn = new Button(" <- Back");

	private Button sSignUpBtn = new Button("Sign up");

	private NavigationRoot navigationRoot;

	private JPAProxyDataAccessor jpaProxyDataAccessor = new JPAProxyDataAccessor();

	private ValidationContext validationContext = new ValidationContext();

	public SignUpView() {

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
			navigationRoot.navigator.navigateTo(NavigationRoot.MAINVIEW);
		});

		sSignUpBtn.addClickListener(e -> {
			String result = checkIfAllFieldsAreValid();
			if (!(result == "")) {
				Notification.show(result);
			} else if (checkIfAllTextEntryNonEmpty()) {
				jpaProxyDataAccessor.makeCustomer(this.sUName.getValue(), this.sPwd.getValue());
				Notification.show("User created successfully");
				backBtn.click();
			} else {
				Notification.show("Please fill all required fields to create an user!");
			}
		});

		signFormLayout.addComponents(sUName, sPwd, fName, lName, emailField, sSignUpBtn);
		signFormLayout.setMargin(true);
		signFormLayout.setWidth(500, Sizeable.Unit.PIXELS);

		sHeader.addComponent(backBtn);

		signVLayout.addComponents(sHeader, signFormLayout);
		signVLayout.setSpacing(true);
		signVLayout.setComponentAlignment(signFormLayout, Alignment.MIDDLE_CENTER);
		signVLayout.setComponentAlignment(sHeader, Alignment.TOP_RIGHT);

		setCompositionRoot(signVLayout);
	}

	private boolean checkIfAllTextEntryNonEmpty() {
		return sUName.getValue() != "" && sPwd.getValue() != "" && fName.getValue() != "" && lName.getValue() != ""
				&& emailField.getValue() != "";
	}

	private String checkIfAllFieldsAreValid() {

		validationContext.setStrategy(new UserNameValidationStrategy());
		if (!validationContext.executeStrategy(sUName.getValue())) {
			return "Sorry, seems like your username contains invalid symbols.\n "
					+ "Only alphanumeric characters are allowed";
		}
		validationContext.setStrategy(new PasswordValidationStrategy());
		if (!validationContext.executeStrategy(sPwd.getValue())) {
			return "Sorry, seems like your password is not strong enough. Rules:\n "
					+ "1) A digit must occur at least once \n "
					+ "2) A lower and upper case letter must occur at least once \n "
					+ "3) A special character must occur at least once \n "
					+ "4) No whitespace allowed in the entire string \n "
					+ "5) Password must be at least eight places long.";
		}
		validationContext.setStrategy(new EMailValidationStrategy());
		if (!validationContext.executeStrategy(emailField.getValue())) {
			return "Sorry, seems like you have an invalid e-mail";
		}
		return "";
	}

	public void setNavigator(NavigationRoot navigationRoot) {
		this.navigationRoot = navigationRoot;
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent evt) {

	}
}
