
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
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class SignUpView extends CustomComponent implements View {

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

     /*   backBtn.addClickListener(e -> {
            setContent(panel);
        });*/

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

    public void enter(ViewChangeListener.ViewChangeEvent evt) {

    }
}
