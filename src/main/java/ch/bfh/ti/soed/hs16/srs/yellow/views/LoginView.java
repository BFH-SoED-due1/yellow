
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
public class LoginView
        extends CustomComponent
        implements View {

    // Login
    private Panel lPanel = new Panel();
    private VerticalLayout loginVLayout = new VerticalLayout();
    private FormLayout loginFormLayout = new FormLayout();
    private HorizontalLayout lHeader = new HorizontalLayout();

    private TextField lUName = new TextField("Username");
    private PasswordField lPwd = new PasswordField("Password");

    private Button lLoginBtn = new Button("Login");
    private Button lbackBtn = new Button("Back");

    public LoginView() {

        setSizeFull();

        // Login
        lUName.setRequired(true);
        lPwd.setRequired(true);

        lUName.setSizeFull();
        lPwd.setSizeFull();
        lLoginBtn.setSizeFull();

        loginFormLayout.addComponents(lUName, lPwd, lLoginBtn);
        loginFormLayout.setMargin(true);
        loginFormLayout.setWidth(500, Sizeable.Unit.PIXELS);

        lHeader.addComponent(lbackBtn);
        lbackBtn.addClickListener(e -> {
            //setContent(panel);
        });

        loginVLayout.addComponents(lHeader, loginFormLayout);
        loginVLayout.setSpacing(true);
        loginVLayout.setComponentAlignment(loginFormLayout, Alignment.MIDDLE_CENTER);
        loginVLayout.setComponentAlignment(lHeader, Alignment.TOP_RIGHT);

        setCompositionRoot(loginVLayout);
    }

    public void enter(ViewChangeListener.ViewChangeEvent evt) {

    }
}
