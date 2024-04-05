class MyClass
{
private int a;
// Default Constructor
public MyClass()
{
System.out.println("Default Constructor");
}
// Overloaded Constructor
public MyClass(int value)
{
a=value;
System.out.println("Parameterized Constructor and value is:"+value);
}
// Copy Constructor
public MyClass(MyClass other)
{
a = other.a;
System.out.println("Copy Constructor and value is: "+a);
}
}
public class _1a
{
public static void main(String[] args)
{
MyClass obj1 = new MyClass();
MyClass obj2 = new MyClass(7);
MyClass obj3 = new MyClass(obj2);
}
}
//////////////////////////
class DemoStaticMethods {
    // Static method to add two numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Static method to subtract two numbers
    public static int subtract(int a, int b) {
        return a - b;
    }
}

public class _1c {
    public static void main(String[] args) {
        // Calling static methods directly on the class
        int sum = DemoStaticMethods.add(8, 4);
        int difference = DemoStaticMethods.subtract(7, 6);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
    }
}

///////////////////////////////////////////////////////////
class A
{
void show()
{
System.out.println("Base Class");
}
}
class B extends A
{
// Overriding Method of Base Class 
void show()
{
System.out.println("Derieved Class");
}
}
class _2a
{
public static void main(String args[])
{
B s=new B();
s.show();
}
}
////////////////////////////////////////////////////////////////
abstract class Shape {
    // Abstract method for calculating area
    public abstract double area();
}

// Concrete subclass - Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

public class _2b {
    public static void main(String[] args) {
        Circle circle = new Circle(10.0);
        // Create a Circle object
        // Calculate and display the area of the circle
        System.out.println("Circle Area: " + circle.area());
    }
}
////////////////////////////////////////////////////////////////////
// Define an interface
interface Shape {
    // Abstract methods (implicitly public and abstract)
    double area();
    double perimeter();
}

// Implement the interface in a class
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

public class _2c {
    public static void main(String[] args) {
        Circle circle = new Circle(10.0); // Create a Circle object
        // Calculate and display the area and perimeter of the circle
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());
    }
}
//////////////////////////////////////////////////////////
public class _3a {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero.");
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
/////////////////////////////////////////////////////////
//Define a custom exception class
class CustomException extends Exception
{
public CustomException(String message)
{
super(message);
}
}
public class _3b
{
public static void main(String[] args)
{
try
{
int age = -20;
// Check if age is negative i
if (age < 0)
{
throw new CustomException("Age cannot be negative.");
}
System.out.println("Age: " + age);
}
catch (CustomException e)
{
System.err.println("Error: " + e.getMessage());
}
}
}
///////////////////////////////////////////////////////////////
create database userDetails;
use userDetails;
create table myuser(id int, name varchar(45), age int);
insert into myuser(1, "Tushar",41);
insert into myuser values (2. "Sonali", 40);
insert into myuser values (3,"Yashashree",11);
insert into myuser values (4, "Vedshree",7);
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Pr5a extends JFrame
{
private JTable table;
private DefaultTableModel model;
public Pr5a()
{
setTitle("Database Table Display");
setSize(300, 200); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
model new DefaultTableModel(); table new JTable(model); 
JScrollPane scrollPane new JScrollPane(table);
add(scrollPane, BorderLayout.CENTER);
try
{
Connection connection DriverManager.getConnection 
("jdbc:mysql://localhost:3306/userDetails", "root", 
"root"); 
Statement statement connection.createStatement();
String query = "SELECT FROM myuser"; // Use your 
table name ResultSet resultSet 
statement.executeQuery(query);
int columnCount = 
resultSet.getMetaData().getColumnCount(); 
for (int i=1; i < columnCount; i++)
{
model.addColumn(resultSet.getMetaData().getC
olumnName(i));
}
while (resultSet.next())
{
Object[] row new Object[columnCount]; 
for (int i = 1; i <= columnCount; i++)
{
row[i-1] = resultSet.getObject(i);
}
model.addRow(row);
}
resultSet.close(); 
statement.close();
connection.close();
}
catch (SQLException e)
{
e.printStackTrace();
}
}
public static void main(String[] args)
{
SwingUtilities.invokeLater(()-> {
( Pr5a app new Pr5a();
app.setVisible(true);
});
}
}
//////////////////////////bouncing ball//////////////////
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BouncingBalls extends JPanel implements Runnable {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static final int NUM_BALLS = 5;
    private List<Ball> balls;

    public BouncingBalls() {
        balls = new ArrayList<>();
        // Create and add random balls
        Random random = new Random();
        for (int i = 0; i < NUM_BALLS; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            int xSpeed = random.nextInt(5) + 1;
            int ySpeed = random.nextInt(5) + 1;
            Color color = new Color(random.nextInt(256),
                    random.nextInt(256), random.nextInt(256));
            balls.add(new Ball(x, y, xSpeed, ySpeed, color));
        }
    }

    @Override
    public void run() {
        while (true) {
            for (Ball ball : balls) {
                ball.move();
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("5 Colors Bouncing Balls");
        BouncingBalls bouncingBalls = new BouncingBalls();
        frame.add(bouncingBalls);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Thread thread = new Thread(bouncingBalls);
        thread.start();
    }
}

class Ball {
    private int x, y, xSpeed, ySpeed;
    private Color color;

    public Ball(int x, int y, int xSpeed, int ySpeed, Color color) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = color;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (x < 0 || x > BouncingBalls.WIDTH) {
            xSpeed = -xSpeed;
        }

        if (y < 0 || y > BouncingBalls.HEIGHT) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 20); // Assuming a ball is represented as an oval
    }
}
////////////////////////////////////////////////////////////////////////////////////
create database userDetails;
use userDetails;
create table myuser(id int, name varchar(45), age int);
insert into myuser(1, "Tushar",41);
insert into myuser values (2. "Sonali", 40);
insert into myuser values (3,"Yashashree",11);
insert into myuser values (4, "Vedshree",7);
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Pr5a extends JFrame
{
private JTable table;
private DefaultTableModel model;
public Pr5a()
{
setTitle("Database Table Display");
setSize(300, 200); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
model new DefaultTableModel(); table new JTable(model); 
JScrollPane scrollPane new JScrollPane(table);
add(scrollPane, BorderLayout.CENTER);
try
{
Connection connection DriverManager.getConnection 
("jdbc:mysql://localhost:3306/userDetails", "root", 
"root"); 
Statement statement connection.createStatement();
String query = "SELECT FROM myuser"; // Use your 
table name ResultSet resultSet 
statement.executeQuery(query);
int columnCount = 
resultSet.getMetaData().getColumnCount(); 
for (int i=1; i < columnCount; i++)
{
model.addColumn(resultSet.getMetaData().getC
olumnName(i));
}
while (resultSet.next())
{
Object[] row new Object[columnCount]; 
for (int i = 1; i <= columnCount; i++)
{
row[i-1] = resultSet.getObject(i);
}
model.addRow(row);
}
resultSet.close(); 
statement.close();
connection.close();
}
catch (SQLException e)
{
e.printStackTrace();
}
}
public static void main(String[] args)
{
SwingUtilities.invokeLater(()-> {
( Pr5a app new Pr5a();
app.setVisible(true);
});
}
}
///////////////////////////////////////////5B/////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDetails extends JFrame
{
private JComboBox<String> userComboBox;
private JTextField idTextField;
private JTextField nameTextField;
public UserDetails()
{
setTitle("User Details");
setSize(400, 150); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
setLayout(new FlowLayout());
userComboBox = new JComboBox<>();
idTextField = new JTextField(20);
nameTextField = new JTextField(10);
add(new JLabel("Select ID:")); 
add(userComboBox);
add(new JLabel("Id")); 
add(idTextField);
add(new JLabel("Name")); 
add(name TextField);
try
{
Connection connection = 
DriverManager.getConnection
("jdbc:mysql://localhost:3306/userDetails", "root", 
"root"); 
String query = "SELECT id FROM myuser"; // use 
your table name
PreparedStatement preparedStatement -
connection.prepareStatement(query); ResultSet 
resultSet = preparedStatement.executeQuery();
while (resultSet.next())
{
int id = resultSet.getInt("id");
userComboBox.addItem(Integer.toString(id));
}
resultSet.close();
preparedStatement.close();
connection.close();
}
catch (SQLException e)
{
e.printStackTrace();
}
userComboBox.addActionListener(new ActionListener()
{
@Override
public void actionPerformed(ActionEvent e)
{
String selectedId= (String) 
userComboBox.getSelectedItem(); 
if (selectedid!= null)
{
try
{
Connection connection = 
DriverManager.getConnection
(jdbc:mysql://localhost:3306/userDet
ails", "root", "root"); 
String query "SELECT id, name 
FROM myuser WHERE id=?";
PreparedStatement 
preparedStatement=
connection.prepareStatement(query);
preparedStatement.setString(1, 
selectedId); 
ResultSet resultSet=
preparedStatement.executeQuery():
if (resultSet.next())
{
int id resultSet.getInt("id");
String name = 
resultSet.getString("name"), id 
TextField.setText(Integer.toString(id)
);
nameTextField.setText(name):
}
resultSet.close();
preparedStatement.close();
connection.close();
}
catch (SQLException ex)
{
ex.printStackTrace();
}
}
}
});
}
public static void main(String[] args)
{
SwingUtilities.invokeLater(()-> [ UserDetails user = new 
UserDetails(); 
user.setVisible(true);
});
}
}
//////////////////////Prac 6/////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class ChangeColor extends JFrame
{
private JPanel colorPanel;
private JButton changeColorButton;
public ChangeColor()
{
setTitle("Random Color Changer");
setSize(300, 200);
setDefaultCloseOperation(JFrame EXIT ON CLOSE);
setLayout(new BorderLayout());
colorPanel new JPanel();
changeColorButton = new JButton("Change Color");
add(colorPanel, BorderLayout.CENTER);
add(changeColorButton, BorderLayout.SOUTH);
changeColorButton.addActionListener(new 
ActionListener() 
{
@Override
public void actionPerformed(ActionEvent e) | 
changeColor();
}
});
}
private void changeColor() |
{
Random random new Random();
Color randomColor = new Color(random.nextInt(256), 
random.nextInt(256),random.nextInt(256));
colorPanel.setBackground(randomColor);
}
public static void main(String[] args) 
{
SwingUtilities invokeLater(()->{
ChangeColor app = new ChangeColor();
app.setVisible(true);
});
}
}
//////////////////////////////////////////////////////////////////////////////////
import javax.swing.*
import java.awt.*;
import java.awt.event.ActionEvent.
import java.awt.event.ActionListener:
import java.io.BufferedReader;
import java.io.FileReader.
import java.io.IOException;
public class Show FileInTestArea extends JFrame
{
private JTextArea textArea new JTextArea(20, 40);
private JButton openFileButton new JButton("Open File");
}
public Show Fileln TextArea()
{
setTitle("File Viewer");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout()); 
JScrollPane scrollPane new JScrollPane(textArea); 
add(scrollPane, BorderLayout.CENTER); 
add(openFileButton, BorderLayout.SOUTH);
openFileButton.addActionListener(new ActionListener() 
{ @Override
public void actionPerformed(ActionEvent e) 
{
openFile();
}
});
pack();
setLocation RelativeTo(null); // Center the frame on the screen
private void openFile() (
{
JFileChooser fileChooser = new JFileChooser():
int result fileChooser.showOpenDialog(this); 
if (result JFileChooser.APPROVE_OPTION) 
{
try (BufferedReader reader = new BufferedReader
(new FileReader(fileChooser.getSelectedFile()))) 
{
StringBuilder content = new StringBuilder();
String line;
while ((line = reader.readLine()) != null) 
{
content.append(line).append("\n");
}
textArea.setLineWrap(true);
textArea.setText(content.toString());
{
catch (IOException e) 
{
JOptionPane.showMessageDialog(this, "Error 
reading the file.", "Error", JOptionPane.ERROR 
MESSAGE);
}
}
}
public static void main(String[] args) 
{
SwingUtilities.invokeLater(()-> (
new Show FilelnTextArea().setVisible(true);
});
}
}
/////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ColorChnager extends JFrame
{
private JScrollPane scrollPane new JScrollPane();
private JButton changeColorButton = new JButton("Change 
Color");
public ColorChnager() 
{
setTitle("ScrollPane Color Changer");
setSize(400, 300):
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());
add(scrollPane, BorderLayout.CENTER);
add(changeColorButton, BorderLayout SOUTH);
changeColorButton.addActionListener(new ActionListener() 
{ @Override
public void actionPerformed(ActionEvent e)(
{
Color selected Color =JColorChooser.showDialog
(null, "Choose a Color", scrollPane.getBackground());
if (selected Color != null) 
{
scrollPane.getViewport().setBackground(selectedColor);
}
}
});
}
public static void main(String[] args)
{
SwingUtilities.invokeLater(()-> (
new ColorChnager().setVisible(true);
});
}
}
////////////////////////////////////////7///////////////////////
import javax.swing.*;
import java.awt.*;
public class DemoFlowLayout
{
	public static void main(String s[])
	{
		JFrame frame=new JFrame("FLow Layout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		
		JPanel panel= new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton b1= new JButton("Button1");
		JButton b2= new JButton("Button2");
		JButton b3= new JButton("Button3");
	
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);

		frame.add(panel);
		frame.setVisible(true);
	}
}

/////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
public class DemoGridLayout
{
	public static void main(String s[])
	{
		JFrame frame=new JFrame("FLow Layout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		
		JPanel panel= new JPanel(new GridLayout(2,3));

		JButton b1= new JButton("Button1");
		JButton b2= new JButton("Button2");
		JButton b3= new JButton("Button3");
		JButton b4= new JButton("Button4");
		JButton b5= new JButton("Button5");
		JButton b6= new JButton("Button6");
	
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);

		frame.add(panel);
		frame.setVisible(true);
	}

}
/////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChnager extends JFrame
{
private JScrollPane scrollPane new JScrollPane();
private JButton changeColorButton = new JButton("Change Color");
		public ColorChnager() 
		{
setTitle("ScrollPane Color Changer");
setSize(400, 300):
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());
add(scrollPane, BorderLayout.CENTER);
add(changeColorButton, BorderLayout SOUTH);
changeColorButton.addActionListener(new ActionListener() 
{ @Override
public void actionPerformed(ActionEvent e)(
			{
Color selected Color =JColorChooser.showDialog
(null, "Choose a Color", scrollPane.getBackground());
if (selected Color != null) 
{
 scrollPane.getViewport().setBackground(selectedColor);
			}
			}
		});
	}	
public static void main(String[] args)
{ 
 SwingUtilities.invokeLater(()-> (
		new ColorChanger().setVisible(true);
		});
	}
}
/////////////////////8///////////////////////////////////////
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnClkDemo 
{
public static void main(String[] args) 
{
JFrame frame = new JFrame("Button Click Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JButton button = new JButton("Click Me");
button.addActionListener(new ActionListener() 
{ 
@Override
public void actionPerformed(ActionEvent e) 
{
JOptionPane.showMessageDialog(frame, "Button Clicked!");
}
});
frame.getContentPane().add(button);
frame.pack();
frame.setVisible(true);
}
}
////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItmClk 
{
public static void main(String[] args)
 {
JFrame frame = new JFrame("Menu Item Click Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JMenuBar menuBar = new JMenuBar();
JMenu fileMenu = new JMenu("File");
JMenuItem openItem = new JMenuItem("Open");
openItem.addActionListener(new ActionListener() { @Override
public void actionPerformed(ActionEvent e)
 {
JOptionPane.showMessageDialog(frame, "File -> Open clicked!");
}
});	
fileMenu.add(openItem);
 menuBar.add(fileMenu);
 frame.setJMenuBar(menuBar);
frame.setSize(400, 300);
 frame.setVisible(true);
}
}
//////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TxtEntrKey
 {
public static void main(String[] args) 
{
JFrame frame = new JFrame("Text Field Enter Key Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JTextField textField = new JTextField(20);
textField.addActionListener(new ActionListener() 
{ @Override
public void actionPerformed(ActionEvent e) 
{
JOptionPane.showMessageDialog(frame,"Enter key pressed in text field.");
}
});
frame.getContentPane().add(textField);
frame.pack();
frame.setVisible(true);
}
}
////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TxtEntrKey
 {
public static void main(String[] args) 
{
JFrame frame = new JFrame("Text Field Enter Key Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JTextField textField = new JTextField(20);
textField.addActionListener(new ActionListener() 
{ @Override
public void actionPerformed(ActionEvent e) 
{
JOptionPane.showMessageDialog(frame,"Enter key pressed in text field.");
}
});
frame.getContentPane().add(textField);
frame.pack();
frame.setVisible(true);
}
}
////////////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllKeyEvents
{
public static void main(String[] args)
{
JFrame frame = new JFrame("All Key Events");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
JTextField textField = new JTextField(20);
Frame.add(textField);

textField.addKEyListener(new KeyAdapter() {
@Override
public void keyTyped (KeyEvent e) {
System.out.println(“Key Typed:”+ e.getKeyChar());
}

@Override
public void keyPressed (KeyEvent e) {
System.out.println(“Key Pressed:”+ KeyEvent.getKeyText(e.getKeyCode()));

}

@Override
public void keyReleased (KeyEvent e) {
System.out.println(“Key Released:”+ KeyEvent.getKeyText(e.getKeyCode()));
}
});
frame.pack();
frame.setVisible(true);
}
}


//Handling Mouse Enter and Exit Event 
panel.addMouseListener(new MouseAdapter() {
@Override
public void mouseEntered(MouseEvent e) { 
frame.setTitle("Mouse Entered");
}
@Override
public void mouseExited (MouseEvent e) {
 frame.setTitle("Mouse Exited");
}
});
frame.add(panel);
frame.pack();
frame.setVisible(true);
});
}
}
////////////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionEvents
{
public static void main(String[] args)
{

SwingUtilities.invokeLater(() -> {
JFrame frame = new JFrame("MouseClick Event Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

String[] items = {“item1”,”item2”,”item3”};
 JComboBx<Sting> comboBox = new JCOmboBOx<>(items);
comboBox.addActionListener(new ActionListener()
{
@Override
public void actionPerformed(ActionEvent e)
{	
String selectedItem = (String) comboBox.getSelectedItem ();
System.out.println(“Selected :” + selectedItem);
}
});
 
frame.add(comboCox,BorderLayout.CENTER);
frame.setSize(300,200);
frame.setVisible(true);
});
}
}
////////////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AllFocusEvents
{
public static void main(String[] args)
{
SwingUtilities.invokeLater(() -> {
JFrame frame = new JFrame("MouseClick Event Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllKeyEvents {
    public static void main(String[] args) {
        JFrame frame = new JFrame("All Key Events");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(20);
        frame.add(textField);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
/////////////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AllMouseEvents
{
public static void main(String[] args)
{
SwingUtilities.invokeLater(() -> {
JFrame frame = new JFrame("MouseClick Event Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel();
JLabel j1 = new JLabel();
panel.add(j1);
panel.setPreferredSize(new Dimension(300, 200));
//Handling Mouse Click Event
panel.addMouseListener(new MouseAdapter(){

@Override
public void mouseClicked (MouseEvent e) {
JOptionPane.showMessageDialog(frame, "Mouse Clicked at ("+e.getX()+","+e.getY() + ")");
}
});

//Handling Mouse Motion Event
panel.addMouseMotionListener(new MouseAdapter() {
@Override
public void mouseMoved (MouseEvent e) {
j1.setText("Mouse Moved at (" + e.getX()+", "+e.getY() + ")");

}
});
//Handling Mouse Enter and Exit Event 
panel.addMouseListener(new MouseAdapter() {
@Override
public void mouseEntered(MouseEvent e) { 
frame.setTitle("Mouse Entered");
}
@Override
public void mouseExited (MouseEvent e) {
 frame.setTitle("Mouse Exited");
}
});
frame.add(panel);
frame.pack();
frame.setVisible(true);
});
}
}
////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnClkDemo 
{
public static void main(String[] args) 
{
JFrame frame = new JFrame("Button Click Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JButton button = new JButton("Click Me");
button.addActionListener(new ActionListener() 
{ 
@Override
public void actionPerformed(ActionEvent e) 
{
JOptionPane.showMessageDialog(frame, "Button Clicked!");
}
});
frame.getContentPane().add(button);
frame.pack();
frame.setVisible(true);
}
}

////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ChangeColor extends JFrame {
    private JPanel colorPanel;
    private JButton changeColorButton;

    public ChangeColor() {
        setTitle("Random Color Changer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Corrected this line
        setLayout(new BorderLayout());
        colorPanel = new JPanel(); // Corrected this line
        changeColorButton = new JButton("Change Color");
        add(colorPanel, BorderLayout.CENTER);
        add(changeColorButton, BorderLayout.SOUTH);
        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        });
    }

    private void changeColor() {
        Random random = new Random(); // Corrected this line
        Color randomColor = new Color(random.nextInt(256),
                random.nextInt(256), random.nextInt(256));
        colorPanel.setBackground(randomColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Corrected this line
            ChangeColor app = new ChangeColor();
            app.setVisible(true);
        });
    }
}
////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
public class DemoFlowLayout
{
	public static void main(String s[])
	{
		JFrame frame=new JFrame("FLow Layout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		
		JPanel panel= new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton b1= new JButton("Button1");
		JButton b2= new JButton("Button2");
		JButton b3= new JButton("Button3");
	
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);

		frame.add(panel);
		frame.setVisible(true);
	}
}
//////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
public class DemoGridLayout
{
	public static void main(String s[])
	{
		JFrame frame=new JFrame("FLow Layout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		
		JPanel panel= new JPanel(new GridLayout(2,3));

		JButton b1= new JButton("Button1");
		JButton b2= new JButton("Button2");
		JButton b3= new JButton("Button3");
		JButton b4= new JButton("Button4");
		JButton b5= new JButton("Button5");
		JButton b6= new JButton("Button6");
	
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);

		frame.add(panel);
		frame.setVisible(true);
	}

}
////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItmClk {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Menu Item Click Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu fileMenu = new JMenu("File");

        // Create a menu item
        JMenuItem openItem = new JMenuItem("Open");

        // Add ActionListener to the menu item
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a message dialog when the menu item is clicked
                JOptionPane.showMessageDialog(frame, "File -> Open clicked!");
            }
        });

        // Add the menu item to the menu
        fileMenu.add(openItem);

        // Add the menu to the menu bar
        menuBar.add(fileMenu);

        // Set the menu bar to the frame
        frame.setJMenuBar(menuBar);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Make the frame visible
        frame.setVisible(true);
    }
}
//////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionEvents {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Selection Events Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            String[] items = {"item1", "item2", "item3"};
            JComboBox<String> comboBox = new JComboBox<>(items);
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedItem = (String) comboBox.getSelectedItem();
                    System.out.println("Selected: " + selectedItem);
                }
            });

            frame.add(comboBox, BorderLayout.CENTER);
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
//////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; // Added semicolon
import java.awt.event.ActionListener; // Added semicolon
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShowFileInTextArea extends JFrame { // Renamed class and removed space in class name
    private JTextArea textArea = new JTextArea(20, 40); // Added '=' instead of 'new'
    private JButton openFileButton = new JButton("Open File"); // Added '=' instead of 'new'

    public ShowFileInTextArea() { // Corrected method declaration
        setTitle("File Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(textArea); // Added 'new'
        add(scrollPane, BorderLayout.CENTER);
        add(openFileButton, BorderLayout.SOUTH);

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        pack();
        setLocationRelativeTo(null); // Corrected method name and added 'this.'
    }

    private void openFile() { // Corrected method declaration
        JFileChooser fileChooser = new JFileChooser(); // Removed ':' and added semicolon
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setLineWrap(true);
                textArea.setText(content.toString());
            } catch (IOException ex) { // Changed 'e' to 'ex' for clarity
                JOptionPane.showMessageDialog(this, "Error reading the file.", "Error", JOptionPane.ERROR_MESSAGE); // Added semicolon and corrected constant name
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShowFileInTextArea().setVisible(true); // Corrected class name
        });
    }
}
////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TxtEntrKey
 {
public static void main(String[] args) 
{
JFrame frame = new JFrame("Text Field Enter Key Demo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JTextField textField = new JTextField(20);
textField.addActionListener(new ActionListener() 
{ @Override
public void actionPerformed(ActionEvent e) 
{
JOptionPane.showMessageDialog(frame,"Enter key pressed in text field.");
}
});
frame.getContentPane().add(textField);
frame.pack();
frame.setVisible(true);
}
}
//////////end///////////////////////////////////////////////////

