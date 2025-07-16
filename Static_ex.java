
class Number {

    static int num = 0; //클래스 필드
    int num2 = 0; //인스턴스 필드
}

public class Static_ex {

    public static void main(String[] args) {
        Number number1 = new Number(); //첫번째 number
        Number number2 = new Number(); //두번쨰 number

        number1.num++; //클래스 필드 num을 1증가시킴
        number1.num2++; //인스턴스 필드 num을 1증가시킴
        System.out.println(number2.num); //두번째 number의 클래스 필드 출력
        System.out.println(number2.num2); //두번째 number의 인스턴스 필드 출력
    }
}


//static으로 된 필드는 클래스 내의 필드이다. 따라서 인스턴스 필드와는 달리 정보가 저장된다. static 영역에 할당된 메모리는 모든 객체가 공유하여 하나의 멤버를 어디서든 참조할 수 있는 장점이 있다. 하지만 GC 관리 밖이라 계속된 사용은 성능에 악영향을 미친다. 보통 "클래스이름.필드"로 static 필드를 호출해야 한다고 알고 있지만 객체 생성을 통해서 하는것도 가능은 하다.