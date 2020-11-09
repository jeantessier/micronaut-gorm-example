package gorm.test

import grails.gorm.annotation.*

@Entity
class User {

    String id

    String emailAddress
    String password
    String fullname

    Date dateCreated
    Date lastUpdated

    static constraints = {
        id maxSize: 36, nullable: true // Gets assigned automatically by the mapping generator
        emailAddress email: true
        password nullable: true
        fullname blank: false
    }

    static mapping = {
        id generator: "uuid2"
    }

}
