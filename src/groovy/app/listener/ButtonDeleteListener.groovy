package app.listener

import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.UI

import app.controllers.*

class ButtonDeleteListener implements ClickListener {
	Long id

	public ButtonDeleteListener(Long id) {
		this.id = id
	} 

	@Override
	public void buttonClick(ClickEvent event) {
		Controller controller = getController()
		// call method delete in Controller class
		controller.delete(id)
		// refresh data
		controller.showTodoItem()
	}

	private Controller getController() {
		Object c = UI.getCurrent().getSession().getAttribute("controller")
		return (Controller) c
	}
}