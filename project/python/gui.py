import sys
from PyQt5.QtWidgets import QApplication, QWidget, QLabel, QLineEdit, QPushButton, QVBoxLayout
from PyQt5.QtGui import QFont

class LinearSearchApp(QWidget):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Linear Search App")
        self.setGeometry(100, 100, 400, 200)

        self.label = QLabel("Enter a number to search:", self)
        self.label.setFont(QFont(self.label.font().family(), self.label.font().pointSize() + 2))  # Increase font size by 2 points
        self.input_field = QLineEdit(self)
        self.search_button = QPushButton("Search", self)
        self.search_button.setFont(QFont(self.search_button.font().family(), self.search_button.font().pointSize() + 2))  # Increase font size by 2 points
        self.result_label = QLabel("", self)
        self.result_label.setFont(QFont(self.result_label.font().family(), self.result_label.font().pointSize() + 2))  # Increase font size by 2 points

        layout = QVBoxLayout()
        layout.addWidget(self.label)
        layout.addWidget(self.input_field)
        layout.addWidget(self.search_button)
        layout.addWidget(self.result_label)

        self.setLayout(layout)

        self.search_button.clicked.connect(self.perform_linear_search)

        self.number_list = [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]

    def perform_linear_search(self):
        search_key = int(self.input_field.text())
        found = False

        for index, number in enumerate(self.number_list):
            if number == search_key:
                self.result_label.setText(f"Found {search_key} at index {index}")
                found = True
                break

        if not found:
            self.result_label.setText(f"{search_key} not found")

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = LinearSearchApp()
    window.show()
    sys.exit(app.exec_())
