public class Person {
    private int age;
    private String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        return new Person(age, name);
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        return new Person(age, name);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null) return false;

        if (!getClass().equals(o.getClass())) return false;
        Person person = (Person) o;
        if (age != person.getAge()) return false;
        if (!name.equals(person.getName())) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int hash = 1;
        hash = 31 * hash + age;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);

        return hash;
    }
}
