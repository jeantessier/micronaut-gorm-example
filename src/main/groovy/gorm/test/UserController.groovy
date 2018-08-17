package gorm.test

import io.micronaut.http.annotation.*
import io.micronaut.spring.tx.annotation.*
import java.text.*

@Controller("/users")
class UserController {

    @Get("/")
    @Transactional(readOnly = true)
    def index() {
        User.list()
    }

    @Get("/{id}")
    @Transactional(readOnly = true)
    def show(id) {
        User.get(id)
    }

    @Post("/")
    @Transactional
    def save(String emailAddress, String password, String fullname) {
        def user = new User(emailAddress: emailAddress, password: password, fullname: fullname)
        if (user.save()) {
            return user
        } else {
            return user.errors.allErrors.collect { MessageFormat.format(it.defaultMessage, it.arguments) }.join(", ")
        }
    }

    @Delete("/{id}")
    @Transactional
    def delete(id) {
        def user = User.get(id)
        if (user) {
            user.delete()
            return "OK"
        } else {
            return "Could not delete user ${id}."
        }
    }

}
