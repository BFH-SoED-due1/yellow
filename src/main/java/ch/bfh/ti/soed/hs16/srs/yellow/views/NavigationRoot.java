
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
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
public class NavigationRoot extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        View mainView = new MainView();

        Navigator navigator = new Navigator(this, this);

        navigator.addView("Main", mainView);

        navigator.addView("Login", new LoginView());

        navigator.addView("SignUp", new SignUpView());

        navigator.setErrorView(mainView);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = NavigationRoot.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
