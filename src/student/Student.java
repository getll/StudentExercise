package student;

/**
 * Class of Student, basic OOP exercise
 * @author Denmar Ermitano
 */
public class Student {
    private String name;
    private int age;
    private String gender;
    private String id;
    private String email;
    private Address address;
    private static int nextId = 1;
    private final static String SCHOOL_NAME = "Vanier College";
    
    /**
     * Default constructor
     */
    public Student() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.id = null;
        this.email = null;
        this.address = null;
    }
    
    /**
     * Constructor with name and gender of the student
     * @param name the name of the student
     * @param gender the gender of the student
     */
    public Student(String name, String gender) {
        this.name = name;
        this.age = 0;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);
        generateEmail();
        this.address = null;
    }
    
    /**
     * Constructor with name, age and gender of the student
     * @param name the name of the student
     * @param age the age of the student
     * @param gender the gender of the student
     */
    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);
        generateEmail();
        this.address = null;
    }
    
    /**
     * Constructor with data members you can input
     * @param name the name of the student
     * @param age the age of the student
     * @param gender the gender of the student
     * @param address the address of the student
     */
    public Student(String name, int age, String gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);
        generateEmail();
        this.address = address;
    }
    
    /**
     * Copy constructor
     * @param student the student to copy
     */
    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.gender = student.gender;
        this.id = student.id;
        this.email = student.email;
        this.address = new Address(student.address);
    }
    
    /**
     * To generate the email of a student based on their name
     */
    public void generateEmail() {
        String emailSuffix = "vaniercollege.qc.ca";
        email = String.format("%s@%s", name, emailSuffix).toLowerCase();
    }
    
    /**
     * To compare two students
     * @param student the student to compare
     * @return true if the students are the same, false if they are different
     */
    public boolean equals(Student student) {
        return this.name.equals(student.name) &&
                this.age == student.age &&
                this.gender.equals(student.gender) &&
                this.id.equals(student.id) &&
                this.email.equals(student.email) &&
                this.address.equals(student.address);
    }
    
    /**
     * To evaluate the distance between the student and the school
     */
    public void checkDistance() {
        if (this.address.getCity().equalsIgnoreCase("montreal"))
            System.out.println("You live very close to school");
        else if (this.address.getProvince().equalsIgnoreCase("qc"))
            System.out.println("You live not very close to school, but also not too far");
        else
            System.out.println("You live really far from the school!!!");
    }
    
    /**
     * To check if a name is valid
     * @param name the name to check
     * @return true if the name is valid, false if it contains invalid characters
     */
    public static boolean isNameValid(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '\'')
                return false;
        }
        
        return true;
    }
    
    /**
     * To generate a string representing a student
     * @return the string representing a student
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("Student from %s\n", SCHOOL_NAME);
        str += String.format("%-10s: %s\n", "ID", id);
        str += String.format("%-10s: %s\n", "Name", name);
        str += String.format("%-10s: %s\n", "Age", age);
        str += String.format("%-10s: %s\n", "Gender", gender);
        str += String.format("%-10s: %s\n", "Email", email);
        str += String.format("%-10s: \n", "Address");
        str += String.format("%s\n", address);
        return str;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        if (isNameValid(name)) {
            this.name = name;
            this.email = String.format("%s@%s", name, "vaniercollege.qc.ca");
        }
        else
            System.out.println("Sorry, the new name is invalid. Request denied.");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        int atIdx = email.indexOf('@');
        name = email.substring(0, atIdx);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
