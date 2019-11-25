[java Practice]


```java
package EXEX;

public abstract class Transportation {

	private int fee; // 요금
	private int capacity;
	
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	abstract public void ride();
	abstract public int payment(int money);
}
```
```java
package EXEX;

public class Subway extends Transportation {
    private int line = 1;
    
    public Subway(int capacity, int fee) {
    	setCapacity(capacity);
    	setFee(fee);
    }
    
    public int getLine() {
    	return line;
    }
	@Override
	public void ride() {
		System.out.println("지하철을 타다.");
	}

	@Override
	public int payment(int money) {
		System.out.println("교통요금 지불완료.");
		return money;
	}
	
	public void transfer(int line) {
		System.out.println(line + "호선으로 환승하였습니다.");
	}
}
```
```java
package EXEX;

public class Bus extends Transportation {
    private String busCode; //버스 번호
    String area = "경기";
    
    public Bus(int capacity,int fee, String area) {
    	setCapacity(capacity);
    	setFee(fee);
    	
    }
   
	public void setArea(String area) {
		
	}
	public String getArea() {
		return area;
	}


	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	@Override
	public void ride() {
		System.out.println("버스를 타다.");
	}

	@Override
	public int payment(int money) {
		System.out.println("교통요금 지불 완료.");
		return money;
	}

	public void transfer(String busCode) {
		System.out.println(busCode + "번으로 환승 하였습니다.");
	}
	
}
```
```java
package EXEX;

public class Taxi extends Transportation implements Reservationable {
    String area = "경기";
	
	public Taxi(int capacity, int fee, String area) {
	    setCapacity(capacity);
	    setFee(fee);
	   
	}
	
	public void setArea(String area) {
		
	}

	public String getArea() {
		return area;
	}

	@Override
	public void ride() {
		System.out.println("택시를 타다");
	}

	@Override
	public int payment(int money) {
		System.out.println("택시 요금을 지불 하다.");
		return money;
	}

	@Override
	public void reserve(String date, String name) {
		System.out.println("탑승 예정일 : " + date);
		System.out.println("탑승자 : " + name);
		System.out.println("예약이 완료 되었습니다.");
	}

	@Override
	public void cancel(String cancelDate, String cancelName) {
		System.out.println("탑승 취소 날짜 " + cancelDate);
		System.out.println("취소자 : " + cancelName);
		System.out.println("취소가 완료 되었습니다.");
		
	}
	

}
```
```java
package EXEX;

public class TransportationEx {

	public static void main(String[] args) {
		Transportation taxi = new Taxi(4, 3800, "경기");
		Transportation bus = new Bus(40, 1450, "경기");
		Transportation subway = new Subway(600, 1450);
//		
//		taxi.setCapacity(4);
//		taxi.setFee(3800);
//		
//		bus.setCapacity(40);
//		bus.setFee(1450);
//		
//		subway.setCapacity(600);
//		subway.setFee(1450);
		
		printInfoTransportation(taxi);
		printInfoTransportation(bus);
		printInfoTransportation(subway);
		
		((Taxi) taxi).reserve("2019-11-25", "남설빈");

	}

	private static void printInfoTransportation(Transportation t) {
		System.out.println("--------------------------");
		System.out.println("수용 인원" + t.getCapacity());
		System.out.println("요금: " + t.getFee());
	    
		if(t instanceof Subway) {
			System.out.println(((Subway) t).getLine());
		}
		if(t instanceof Taxi) {
			System.out.println(((Taxi) t).getArea());
		}
		if(t instanceof Bus) {
			System.out.println(((Bus) t).getArea());
		}
		System.out.println("--------------------------");
		
	}
    
}
```
```java
package EXEX;

public interface Reservationable {
	void reserve(String date,String name);
	void cancel(String date,String name);

}
//--------------------------------------------------------------
```

```java

package EXEX;

public abstract class Man {

	String name;
	int age;
	String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	abstract public void work();
	
}
```
```java

package EXEX;

public class CollegeStudent extends Man {

	private String major;
	
	public CollegeStudent(String name, int age, String job) {
		setName(name);
		setAge(age);
		setJob(job);
	}
	
	@Override
	public void work() {
		System.out.println("학생이 공부를 하다.");
		
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	

}
```
```java

package EXEX;

public class Athlete extends Man {

	String event;
	
	public Athlete(String name, int age, String job) {
		setName(name);
		setAge(age);
		setJob(job);
	}
	
	@Override
	public void work() {
		System.out.println("운동 선수가 훈련을 하다.");
		
	}
	
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}

}
```
```java

package EXEX;

public class ManEx {

	public static void main(String[] args) {
		
		Man student = new CollegeStudent("남설빈", 28, "학생");
		Man athlete = new Athlete("남설빈", 18, "운동선수");
		
		((CollegeStudent)student).setMajor("컴퓨터 공학과");
		((Athlete)athlete).setEvent("유도 선수");
		
		printInforMan(student);
		printInforMan(athlete);
		
	}

	private static void printInforMan(Man m) {
		System.out.println("-------------------------");
		System.out.println("이름 : " + m.getName());
		System.out.println("나이 : " + m.getAge());
		System.out.println("직업 : " + m.getJob());
		
		if(m instanceof CollegeStudent) {
			System.out.println(((CollegeStudent) m).getMajor());
		}
		if(m instanceof Athlete) {
			System.out.println(((Athlete) m).getEvent());
		}
	}

}
//----------------------------------------------------------------------
```

