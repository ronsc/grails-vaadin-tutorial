package app.controllers

import com.vaadin.ui.Label
import com.vaadin.ui.Grid
import com.vaadin.ui.Panel
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Notification

import com.vaadin.grails.Grails
import tutorial.*

class Controller {
	TodoService todoService
	VerticalLayout vLayout

	public Controller() {
		todoService = Grails.get(TodoService)
	}

	void showTodoItem() {
		// clear component in vLayout
		vLayout.removeAllComponents()
		// add new data
		List<Todo> todos = Grails.get(TodoService).findAll()
        for(Todo todo : todos) {
			HorizontalLayout hLayout = new HorizontalLayout()
			hLayout.setSizeFull()
			hLayout.setMargin(true)
			hLayout.setSpacing(true)

			Label titleLabel = new Label(todo.title)
			Label nameLabel = new Label(todo.name)

			hLayout.addComponent(titleLabel)
			hLayout.addComponent(nameLabel)

			hLayout.setExpandRatio(titleLabel, 1.0f)
			hLayout.setExpandRatio(nameLabel, 1.0f)

			Panel p = new Panel()
	        p.setContent(hLayout)
	        p.setWidth("40em")
	        vLayout.addComponent(p)
	        vLayout.setComponentAlignment(p, Alignment.TOP_CENTER)
	    }
	}

	void save(Todo todo) {
		todoService.save(todo)
	}
}