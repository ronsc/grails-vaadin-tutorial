package tutorial

import grails.transaction.Transactional

@Transactional
class TodoService {

    def serviceMethod() {}

    void save(Todo todo) {
    	todo.save(failOnError: true)
    }

    List<Todo> findAll() {
    	return Todo.list()
    }
}
