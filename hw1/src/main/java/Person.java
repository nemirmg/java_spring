import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {}

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).
                append(firstName).
                append(lastName).
                append(age).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != getClass()) { return false; }
        Person person = (Person) obj;
        return new EqualsBuilder()
                .append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .append(age, person.age)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("имя", firstName).
                append("фамилия", lastName).
                append("возраст", age).
                toString();
    }
}
