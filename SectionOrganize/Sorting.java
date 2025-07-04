package SectionOrganize;

import java.util.ArrayList;
import java.util.List;

/**
 * 여기서의 정렬은 복합 자료형을 비교하기 위한 것이다.
 */
public class Sorting {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(202001234, "홍길동", 90));
        list.add(new Student(202002345, "김철수", 80));
        list.add(new Student(202003456, "최아롬", 100));
    
        System.out.println(list);
    }
}

class Student{
    
    public final int id;
    public final String name;
    public final int score;

    Student(int id, String name, int score){
        this.id = id;
        this.name = name;
        this.score = score;
    }
    
    @Override
    public String toString() {
        return "Student{id = " + id + ", name = '" + name + "', score = " + score + "}";
    }
}