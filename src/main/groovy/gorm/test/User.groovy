package gorm.test

import grails.gorm.annotation.*

@Entity
class User {

    String emailAddress
    String password
    String fullname

    static constraints = {
        emailAddress email: true
        password nullable: true
        fullname blank: false
    }

}
