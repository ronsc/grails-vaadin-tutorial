package tutorial

import grails.transaction.Transactional

@Transactional
class TodoService {

    def serviceMethod() {}

    void save(Todo todo) {
    	todo.save(failOnError: true)
    }

    void delete(Long id) {
    	def todo = Todo.get(id)
    	todo.delete()
    }

    List<Todo> findAll() {
    	return Todo.list()
    }
}
