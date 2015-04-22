package com.assignments.contactsapp.core;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by anurag on 20/04/15.
 * @author              anurag
 * @version             1.0
 */
@Entity
@Table(name="users")
@NamedQueries({
        @NamedQuery(
                name = "com.assignments.contactsapp.core.User.findAll",
                query = "Select u from User u ORDER BY u.id"
        ),
        @NamedQuery(
                name = "com.assignments.contactsapp.core.User.findByEmail",
                query = "Select u from User u where u.email = :email"
        )
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "mobile", nullable = true)
    private String mobile;
    @Column(name = "contact_list", nullable = true)
    private String contactList = new String();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContactList() {
        return contactList;
    }

    public void setContactList(String contactList) {
        this.contactList = contactList;
    }

    /**
     * Merge the passed user with current user.
     * This operation is generally used while updating entity
     * @param   user                    user to merge with this
     * @return                          merged user
     */
    public User merge(User user) {
        if(!Objects.equal(null, user.getFullName())) {
            this.setFullName(user.getFullName());
        }
        if(!Objects.equal(null, user.getEmail())) {
            this.setEmail(user.getEmail());
        }
        if(!Objects.equal(null, user.getMobile())) {
            this.setMobile(user.getMobile());
        }
        return this;
    }
}
