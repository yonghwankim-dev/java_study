package ch09.ex01_Object;

public class Student {
    int stdNo;
    String name;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            return stdNo == ((Student) obj).stdNo &&
                   name.equals(((Student) obj).name);
        }
        return false;
    }

    public Student(int stdNo, String name) {
        this.stdNo = stdNo;
        this.name = name;
    }

    public int getStdNo() {
        return stdNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("stdNo=%d, name=%s",stdNo, name);
    }
}

