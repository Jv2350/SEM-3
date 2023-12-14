import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class LibraryManagementSystem extends JFrame {

    JTextField studentNameField, classNameField, rollNumberField, bookNameField, authorField, issueDateField, returnDateField;
    JButton addButton;
    JTextArea bookListTextArea;

    ArrayList<String> bookList; //array list of string data type 

    LibraryManagementSystem() {
        bookList = new ArrayList<>(); // ArrayList is collection class

        setLayout(new BorderLayout());

        bookListTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(bookListTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10)); //some area on the window
        studentNameField = new JTextField();
        classNameField = new JTextField();
        rollNumberField = new JTextField();
        bookNameField = new JTextField();
        authorField = new JTextField();
        issueDateField = new JTextField();
        returnDateField = new JTextField();
        addButton = new JButton("Add Book");

        inputPanel.add(new JLabel("Student Name:")); inputPanel.add(studentNameField);
        inputPanel.add(new JLabel("Class Name:")); inputPanel.add(classNameField);
        inputPanel.add(new JLabel("Roll Number:")); inputPanel.add(rollNumberField);
        inputPanel.add(new JLabel("Book Name:")); inputPanel.add(bookNameField);
        inputPanel.add(new JLabel("Author:")); inputPanel.add(authorField);
        inputPanel.add(new JLabel("Issue Date:")); inputPanel.add(issueDateField);
        inputPanel.add(new JLabel("Return Date:")); inputPanel.add(returnDateField);
        inputPanel.add(new JLabel()); // Empty space for layout
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void addBook() {
        String studentName = studentNameField.getText();
        String className = classNameField.getText();
        String rollNumber = rollNumberField.getText();
        String bookName = bookNameField.getText();
        String author = authorField.getText();
        String issueDate = issueDateField.getText();
        String returnDate = returnDateField.getText();

        if (!studentName.isEmpty() && !className.isEmpty() && !rollNumber.isEmpty() &&
                !bookName.isEmpty() && !author.isEmpty() && !issueDate.isEmpty() && !returnDate.isEmpty()) {
            String bookDetails = "Student Name: " + studentName + ", Class Name: " + className +
                    ", Roll Number: " + rollNumber + "\n" +
                    "Book Name: " + bookName + ", Author: " + author +
                    ", Issue Date: " + issueDate + ", Return Date: " + returnDate;
            bookList.add(bookDetails);
            updateBookList();
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }

    void updateBookList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String bookDetails : bookList) {
            stringBuilder.append(bookDetails).append("\n\n");
        }
        bookListTextArea.setText(stringBuilder.toString());
    }

    void clearInputFields() {
        studentNameField.setText("");
        classNameField.setText("");
        rollNumberField.setText("");
        bookNameField.setText("");
        authorField.setText("");
        issueDateField.setText("");
        returnDateField.setText("");
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}
