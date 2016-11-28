
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
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;
import java.util.Calendar;
import java.util.Date;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MainView extends UI {

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
			//	setContent(sPanel);
		});

		loginBtn.addClickListener(e -> {
			//	setContent(lPanel);
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
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MainView.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
