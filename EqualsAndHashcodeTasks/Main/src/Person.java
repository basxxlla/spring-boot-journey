public class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person p = (Person) obj;
        //Based on id
        //return this.id == p.id;
        //Based on name
        //return this.name.equals(p.name);
        //Based on both
        return this.id == p.id && this.name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
