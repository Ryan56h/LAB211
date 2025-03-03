package Week_6Short54;

public class Contact {

    private int id;
    private String fullname;
    private String group;
    private String address;
    private String phone;
    private String lastName;
    private String firstname;

    public Contact(int id, String fullname, String group, String address, String phone, String lastName, String firstname) {
        this.id = id;
        this.fullname = fullname;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.lastName = lastName;
        this.firstname = firstname;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", fullname=" + fullname + ", group=" + group + ", address=" + address + ", phone=" + phone + ", lastName=" + lastName + ", firstname=" + firstname + '}';
    }

    
    
    
}
