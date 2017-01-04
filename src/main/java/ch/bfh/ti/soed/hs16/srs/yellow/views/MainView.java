
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.views;

import ch.bfh.ti.soed.hs16.srs.yellow.controllers.JPAProxyDataAccessor;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Theme("mytheme")
public class MainView
        extends CustomComponent
        implements View {

    private Panel panel = new Panel();

    private VerticalLayout panelContent = new VerticalLayout();

    private VerticalLayout searchLayout = new VerticalLayout();

    private VerticalLayout leftVLayout = new VerticalLayout();

    private VerticalLayout rightVLayout = new VerticalLayout();

    private HorizontalLayout headerLayout;

    private HorizontalLayout inputLayout = new HorizontalLayout();

    private HorizontalLayout loginLayout = new HorizontalLayout();

    private Label titleLbl = new Label("Search Room");

    private NativeSelect objSelect = new NativeSelect("Objects");

    private NativeSelect equipSelect = new NativeSelect("Equipments");

    private DateField fromDate = new PopupDateField("From");

    private DateField toDate = new PopupDateField("To");

    private Button searchBtn = new Button("Search");

    private Button loginBtn = new Button("Sign in");

    private Button signupBtn = new Button("Register");

    private Date date;

    private Date lastDate;

    private Calendar limitDate;

    private NavigationRoot navigationRoot;

    private JPAProxyDataAccessor jpaProxyDataAccessor = new JPAProxyDataAccessor();

    public MainView() {

        setSizeFull();

        headerLayout = new HorizontalLayout();
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
            navigationRoot.navigator.navigateTo(NavigationRoot.SIGNUPVIEW);
        });

        loginBtn.addClickListener(e -> {
            navigationRoot.navigator.navigateTo(NavigationRoot.LOGINVIEW);
        });

        searchBtn.addClickListener(evt -> {
            Notification.show("Sorry, search will be made later with Vaadin Grid.");
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
        searchLayout.setWidth(500, Sizeable.Unit.PIXELS);

        panelContent.addComponents(loginLayout, searchLayout);
        panelContent.setComponentAlignment(searchLayout, Alignment.MIDDLE_CENTER);
        panelContent.setComponentAlignment(loginLayout, Alignment.TOP_RIGHT);
        panel.setContent(panelContent);
        setCompositionRoot(panelContent);
    }

    private void updateSelectionOfObjects() {

        if (!this.objSelect.isEmpty()) {
            this.objSelect.removeAllItems();
        }
        List<String> buildingNamesList = this.jpaProxyDataAccessor.findAllBuildings()
                .stream()
                .map(x ->
                {
                    if (x.getName() != "")
                        return x.getName();
                    else return "";
                })
                .collect(Collectors.toList());
        this.objSelect.addItems(buildingNamesList);
    }

    private void updateSelectionOfEquipments() {

        if (!this.equipSelect.isEmpty()) {
            this.equipSelect.removeAllItems();
        }
        List<String> equipmentsNamesList = this.jpaProxyDataAccessor.findAllEquipments()
                .stream()
                .map(
                        x -> {
                            if (x.getDescription() != "")
                                return x.getDescription();
                            else return "";
                        })
                .collect(Collectors.toList());
        this.equipSelect.addItems(equipmentsNamesList);
    }

    public void setNavigator(NavigationRoot navigationRoot) {
        this.navigationRoot = navigationRoot;
    }

    public void enter(ViewChangeListener.ViewChangeEvent evt) {

        updateSelectionOfObjects();

        updateSelectionOfEquipments();

    }
}
