package app.ui

import com.vaadin.ui.CustomComponent
import com.vaadin.ui.Panel
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.TextField
import com.vaadin.ui.Button
import com.vaadin.ui.Alignment
import com.vaadin.ui.UI

import app.controllers.*
import tutorial.Todo

class TodoEdit extends CustomComponent {
	TextField title = new TextField("Todo")
	TextField name 	= new TextField("Name")

	public TodoEdit() {
		Panel editPanel = new Panel()
		HorizontalLayout hLayout = new HorizontalLayout()
		editPanel.setContent(hLayout)
		hLayout.setSizeFull()
		hLayout.setMargin(true)
		hLayout.setSpacing(true)

		title.setSizeFull()
		hLayout.addComponent(title)
		hLayout.setExpandRatio(title, 1.0f)

		name.setSizeFull()
		hLayout.addComponent(name)
		hLayout.setExpandRatio(name, 0.5f)

		Button btnAdd = new Button("Add")
		hLayout.addComponent(btnAdd)
		hLayout.setComponentAlignment(btnAdd, Alignment.BOTTOM_RIGHT)

		// onclick Add -> call method saveToDB
		btnAdd.addClickListener({ event -> saveToDB() } as Button.ClickListener)

		setCompositionRoot(editPanel)
	}

	void saveToDB() {
		Controller c = getController()
		// save data to db
		Todo todo = new Todo(title: title.getValue(), name: name.getValue())
		c.save(todo)
		// refresh data
		c.showTodoItem()
		// clear input 
		title.setValue("")
		name.setValue("")
	}

	private Controller getController() {
		Object c = UI.getCurrent().getSession().getAttribute("controller")
		return (Controller) c
	}
}