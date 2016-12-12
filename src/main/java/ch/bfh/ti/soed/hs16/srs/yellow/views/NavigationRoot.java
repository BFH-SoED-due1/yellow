
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
public class NavigationRoot extends UI {

    protected static final String MAINVIEW = "Main";

    protected static final String LOGINVIEW = "Login";

    protected static final String SIGNUPVIEW = "SignUp";

    protected Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        MainView mainView = new MainView();

        LoginView loginView = new LoginView();

        SignUpView signUpView = new SignUpView();

        mainView.setNavigator(this);

        loginView.setNavigator(this);

        signUpView.setNavigator(this);

        navigator = new Navigator(this, this);

        navigator.addView(MAINVIEW, mainView);

        navigator.addView(LOGINVIEW, loginView);

        navigator.addView(SIGNUPVIEW, signUpView);

        navigator.setErrorView(mainView);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = NavigationRoot.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
