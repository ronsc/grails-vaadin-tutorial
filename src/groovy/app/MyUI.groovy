package app

import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.Alignment
import com.vaadin.ui.Grid
import com.vaadin.ui.Panel

import com.vaadin.grails.Grails
import com.vaadin.data.util.BeanItemContainer

import com.vaadin.annotations.Title
import com.vaadin.annotations.Theme

import app.ui.*
import app.controllers.*
import tutorial.*

@Title("Todo App")
@Theme("todo")
class MyUI extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        buildLayout()
    }

    private void buildLayout() {
        VerticalLayout layout = new VerticalLayout()
        layout.setMargin(true)
        layout.setSpacing(true)
        layout.setWidth("100%")

        TodoEdit todoEdit = new TodoEdit()
        todoEdit.setWidth("40em")
        layout.addComponent(todoEdit)
        layout.setComponentAlignment(todoEdit, Alignment.TOP_CENTER)

        VerticalLayout vLayout = new VerticalLayout()
        layout.addComponent(vLayout)

        Controller c = new Controller(vLayout: vLayout)
        this.getSession().setAttribute("controller", c)
        c.showTodoItem()
        
        setContent(layout)
    }
}
