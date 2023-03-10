package com.example.application.views.personel;


import com.example.application.dto.UserDTO;
import com.example.application.service.UserService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.textfield.TextField;

@PageTitle("User")
@Route(value = "user", layout = MainLayout.class)
public class UserView extends VerticalLayout {

    private final UserService userService;
    TextField filterTextName = new TextField();

    TextField filterTextSurname = new TextField();

    TextField filterTextIdentityNumber = new TextField();

    public UserView(UserService userService) {
        this.userService = userService;
        Grid<UserDTO> grid = new Grid<>(UserDTO.class);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        filterTextName.setWidth("300px");
        filterTextSurname.setWidth("300px");
        filterTextIdentityNumber.setWidth("300px");
        horizontalLayout.add(filterTextName,filterTextSurname,filterTextIdentityNumber);
      // horizontalLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
       // horizontalLayout.setWidth("50%");
        setSpacing(false);
        grid.setColumns("name", "surname","identityNumber");
        grid.getColumnByKey("name").setHeader("Name");
        grid.getColumnByKey("surname").setHeader("Surname");
        grid.getColumnByKey("identityNumber").setHeader("Turkish Identity Number");
        grid.setItems(userService.getAllUser());
        grid.setHeight("450px");
        filterTextName.setPlaceholder("Filter by name...");
        filterTextName.addValueChangeListener(e -> grid.setItems(userService.findByNameStartsWithIgnoreCase(e.getValue())));
        filterTextSurname.setPlaceholder("Filter by surname...");
        filterTextSurname.addValueChangeListener(e -> grid.setItems(userService.findBySurnameStartsWithIgnoreCase(e.getValue())));
        filterTextIdentityNumber.setPlaceholder("Filter by Turkish identityNumber...");
        filterTextIdentityNumber.addValueChangeListener(e -> grid.setItems(userService.findByIdentityNumberStartsWithIgnoreCase(e.getValue())));
        add(horizontalLayout,grid);
    }

}
