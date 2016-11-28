
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.views;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

/**
 * Created by rdrand on 28/11/16.
 */
@Theme("mytheme")
public class LoginView extends UI{

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
            //setContent(panel);
        });

        loginVLayout.addComponents(lHeader, loginFormLayout);
        loginVLayout.setSpacing(true);
        loginVLayout.setComponentAlignment(loginFormLayout, Alignment.MIDDLE_CENTER);
        loginVLayout.setComponentAlignment(lHeader, Alignment.TOP_RIGHT);

        lPanel.setContent(loginVLayout);
    }
}
