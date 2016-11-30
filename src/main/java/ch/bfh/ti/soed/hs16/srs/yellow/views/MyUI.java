
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
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    private Panel panel = new Panel();
    private VerticalLayout panelContent;
    private VerticalLayout searchLayout;
    private VerticalLayout leftVLayout;
    private VerticalLayout rightVLayout;
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

    public MyUI() {
        panelContent = new VerticalLayout();
        searchLayout = new VerticalLayout();
        leftVLayout = new VerticalLayout();
        rightVLayout = new VerticalLayout();
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
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
    }

//	@Override
//	protected void init(VaadinRequest vaadinRequest) {
//
//	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
