import tutorial.Todo

class BootStrap {

    def init = { servletContext ->
    	Todo todo = new Todo(title: "ข้อมูลเริ่มต้นด้วย BootStrap.groovy", name: "admin")
    	todo.save(failOnError: true)
    }
    def destroy = {
    }
}
