package com.gmail.at.rospopa.pavlo;

public class Person {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object other){
        boolean result = false;
        if (other instanceof Person) {
            Person that = (Person) other;
            result = this.firstName == null ? that.firstName == null
                                            : this.firstName.equals(that.firstName);
            result &= this.lastName == null ? that.lastName == null
                                            : this.lastName.equals(that.lastName);
        }
        return result;
    }

    @Override
    public int hashCode(){
        int firstNameHashCode = this.firstName == null ? 0 : this.firstName.hashCode();
        int lastNameHashCode = this.lastName == null ? 0 : this.lastName.hashCode();
        return (41*(41 + firstNameHashCode) + lastNameHashCode);
    }
}

