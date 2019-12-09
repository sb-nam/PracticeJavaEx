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
//-------------------------------------------------------------- 상속
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
//---------------------------------------------------------------------- 상속
```

```java

package 명품자바Ex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:\\Temp\\test.txt");

			while (true) {
				String line = sc.nextLine();
				if (line.length() == 0) {
					break;
				}
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();

		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		sc.close();

	}

}

```
```java

package 명품자바Ex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;
		System.out.println("이클립스상");
		int c;
		
		try {
			fw = new FileWriter("c:\\Temp\\test.txt");
			while(true) {
				System.out.print("이름 : ");
				String name = sc.nextLine();
				if(name.length() == 0)
					break;
				System.out.print("전공 : ");
				String major = sc.nextLine();
				
				fw.write("이름은 " + name);
				fw.write("\r\n", 0, 2);
				fw.write("전공은 " + major);
				
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		sc.close();
	}

}
```

```java
package 명품자바Ex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;

		try {
			fw = new FileWriter("c:\\Temp\\gugudan.txt");

			for (int i = 2; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					fw.write("\r\n");
					fw.write(i + "단 " + i + " x " + j + " = " + i * j + " ");
				}
				fw.write("\r\n");
				fw.write("----------------");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		sc.close();

	}

}

```

```java

package Exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise8_1 {

	public static void main(String[] args) {

		System.out.println("전화번호 입력 프로그램 입니다.");

		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;

		try {
			fw = new FileWriter("c:\\Temp\\Info.txt");

			while (true) {
				System.out.print("이름 전화번호>>>");

				String namePhone = sc.nextLine();
				if (namePhone.equals("그만")) {
					System.out.println("c:\\\\Temp\\\\Info.txt에 저장 하였습니다.");
					break;
				}
				fw.write("\r\n");
				fw.write(namePhone);
			}
			fw.close();
			
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		sc.close();

	}

}
//-------------------------------------------------------------- FileWriter
```

```java

package Exercise;

import java.io.FileReader;
import java.io.IOException;

public class Exercise8_2 {
	public static void main(String[] args) {

		final int END = -1;

		FileReader fileReader = null;

		try {
			fileReader = new FileReader("c:\\Temp\\Info.txt");

			int read;
			while ((read = fileReader.read()) != END) {
				System.out.print((char) read);
			}
			fileReader.close();

		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
```

```java

package Exercise;

import java.io.FileReader;
import java.io.IOException;

public class Exercise8_3 {
	
	public static void main(String[] args) {

		final int END = -1;

		FileReader fileReader = null;
		String path = "c:\\windows\\system.ini";
		int read;

		try {
			fileReader = new FileReader(path);

			while ((read = fileReader.read()) != END) {
				System.out.print(Character.toUpperCase((char) read));
			}
			fileReader.close();

		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
//------------------------------------------------------- FileReader
```

```java
package 명품자바Ex;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KeyListenerEx extends JFrame {

	private JLabel[] keyMessage;

	public KeyListenerEx() {
		setTitle("KeyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());

		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel("getKeyCode() ");
		keyMessage[1] = new JLabel("getKeyChar() ");
		keyMessage[2] = new JLabel("getKeyText() ");

		for (int i = 0; i < keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}

		setSize(300, 150);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
			
			System.out.println("KeyPressed");
			super.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("KeyReleased");
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("KeyTyped");
		}

	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}
}

```

```java

package 명품자바Ex;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyCodeEx extends JFrame {

	private JLabel la = new JLabel();

	public KeyCodeEx() {
		setTitle("Key Code 예제 : F1키:초록색, % 키:노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.addKeyListener(new MyKeyListener());
		c.add(la);

		setSize(300, 150);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			Container contentPane = (Container) e.getSource();

			la.setText(KeyEvent.getKeyText(e.getKeyCode()) + "키가 입력되었음");

			if (e.getKeyChar() == '%') {
				contentPane.setBackground(Color.YELLOW);
			} else if (e.getKeyCode() == KeyEvent.VK_F1) {
				contentPane.setBackground(Color.GREEN);
			}
		}
	}

	public static void main(String[] args) {

		new KeyCodeEx();
	}

}
```
```java

package 명품자바Ex;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FlyingTextEx extends JFrame {

	private final int FLYING_UNIT = 10;
	private JLabel la = new JLabel("HELLO");
	
	public FlyingTextEx() {
		setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener());
		
		la.setLocation(50,50);
		la.setSize(100, 20);
		c.add(la);
		
		setSize(300,300);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
	}
	
	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_UP :
				la.setLocation(la.getX(), la.getY()-FLYING_UNIT);
				break;
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(), la.getY()+FLYING_UNIT);
				break;
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX()-FLYING_UNIT, la.getY());
				break;
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX()+FLYING_UNIT, la.getY());
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new FlyingTextEx();
	}
}

```
```java

package 명품자바Ex;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerAllEx extends JFrame {
	private JLabel la = new JLabel("NO Mouse Event");
	
	public MouseListenerAllEx() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
	
		c.add(la);
		setSize(300,200);
		setVisible(true);
		
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("MouseDragged (" + e.getX() + ", " + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("MouseMoved (" + e.getX() + ", " +e.getY() + ")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Component c = (Component)e.getSource();
			c.setBackground(Color.CYAN);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Component c = (Component)e.getSource();
			c.setBackground(Color.YELLOW);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("mousePressed (" + e.getX() + ", " + e.getY() +")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("MouseReleased (" + e.getX() + ", " + e.getY() +")" );
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MouseListenerAllEx();
	}

}

```

```java

package 명품자바Ex;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JComponentEx extends JFrame {

	public JComponentEx() {
		super("JComponent의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("Arial",Font.ITALIC,20));
		b2.setEnabled(false);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton b = (JButton)e.getSource();
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX() + ", " + b.getY());
			}
		});
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		setSize(260, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JComponentEx();
		
	}

}

```
```java

package 명품자바Ex;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame {

	public LabelEx() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("사랑합니다.");
		
	    ImageIcon beauty = new ImageIcon("images/beauty.jpg");
	    JLabel imgeLabel = new JLabel(beauty);
	    
	    ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
	    JLabel label = new JLabel("보고싶으면 전화하세요", normalIcon,SwingConstants.CENTER);
	    
	    c.add(textLabel);
	    c.add(imgeLabel);
	    c.add(label);
	    
	    setSize(400, 600);
	    setVisible(true);
	    
	}
	
	public static void main(String[] args) {
	
		new LabelEx();

	}

}

```

```java

package 명품자바Ex;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEx extends JFrame{

	public ButtonEx() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		
		JButton btn = new JButton("call~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		c.add(btn);
		
		setSize(250,150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new ButtonEx();

	}

}

```

```java

package 명품자바Ex;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxEx extends JFrame {

	public CheckBoxEx() {
		setTitle("체크 박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배");
		JCheckBox cherry = new JCheckBox("체리", cherryIcon);
		
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);
		
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		setSize(350, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxEx();

	}

}
```

```java
package 명품자바Ex;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxItemEventEx extends JFrame {

	private JCheckBox[] fruits = new JCheckBox[3];
	private String[] names = { "사과", "배", "체리" };

	private JLabel sumLabel;

	public CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));

		MyItemListener listener = new MyItemListener();
		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}

		sumLabel = new JLabel("현재 0 원 입니다.");
		c.add(sumLabel);

		setSize(250, 200);
		setVisible(true);
	}

	class MyItemListener implements ItemListener {

		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.SELECTED) {

				if (e.getItem() == fruits[0]) {
					sum += 100;

				} else if (e.getItem() == fruits[1]) {
					sum += 500;

				} else {
					sum += 20000;
				}
			
			} else {
				if(e.getItem() == fruits[0]) {
					sum -= 100;
				
				} else if(e.getItem() == fruits[1]) {
					sum -= 500;
					
				} else {
					sum -= 20000;
				}

			}
			sumLabel.setText("현재" + sum + "원 입니다.");

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxItemEventEx();

	}

}
```
```java

package 명품자바Ex;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class RadioButtonEx extends JFrame {
	public RadioButtonEx() {
		setTitle("라디오 버튼 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
		
		ButtonGroup g = new ButtonGroup();
		
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배", true);
		JRadioButton cherry = new JRadioButton("체리", cherryIcon);
		
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);
		
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		setSize(350,250);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RadioButtonEx();

	}

}

```
```java

package 명품자바Ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class RaidoButtonItemEventEx extends JFrame{
	private JRadioButton[] radio = new JRadioButton[3];
	private String[] text = {"사과","배","체리"};
	private ImageIcon[] image = { 
			new ImageIcon("images/apple.jpg") ,
			new ImageIcon("images/pear.jpg") ,
			new ImageIcon("images/cherry.jpg")
	};
	private JLabel imageLabel = new JLabel();
	
	public RaidoButtonItemEventEx() {
		setTitle("라디오 버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.GRAY);
		
		ButtonGroup g = new ButtonGroup();
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new MyItemListener());
		}
		
		radio[2].setSelected(true);
		c.add(radioPanel,BorderLayout.NORTH);
		c.add(imageLabel,BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		setSize(250,250);
		setVisible(true);
		
	}

	class MyItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange() == ItemEvent.DESELECTED) {
				return;
			}
			if(radio[0].isSelected()) {
				imageLabel.setIcon(image[0]);
			} else if(radio[1].isSelected()) {
				imageLabel.setIcon(image[1]);
			} else {
				imageLabel.setIcon(image[2]);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RaidoButtonItemEventEx();

	}

}

```
