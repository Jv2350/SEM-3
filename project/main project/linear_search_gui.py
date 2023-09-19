import tkinter as tk

class LinearSearchGUI:
    def __init__(self, root):
        self.root = root
        self.root.title("Linear Search Algorithm GUI")
        
        self.numbers = []  # List to store entered numbers
        
        self.display_title()
        self.display_list_instructions()
        self.create_list_label()
        self.create_list_entry()
        self.create_add_button()
        self.display_input_instructions()
        self.create_input_entry()
        self.create_search_button()

    def display_title(self):
        title_label = tk.Label(self.root, text="Linear Search Algorithm GUI", font=("Helvetica", 16))
        title_label.pack(pady=20)

    def display_list_instructions(self):
        instructions_label = tk.Label(self.root, text="Enter a number and click 'Add' to add it to the list:", font=("Helvetica", 12))
        instructions_label.pack()

    def create_list_label(self):
        self.list_label = tk.Label(self.root, text="List: ", font=("Helvetica", 12))
        self.list_label.pack()

    def create_list_entry(self):
        self.list_entry = tk.Entry(self.root, font=("Helvetica", 12))
        self.list_entry.pack()

    def create_add_button(self):
        self.add_button = tk.Button(self.root, text="Add", command=self.add_number_to_list)
        self.add_button.pack()

    def add_number_to_list(self):
        number = self.list_entry.get()
        if number.isdigit():
            self.numbers.append(int(number))
            self.update_list_label()
            self.list_entry.delete(0, tk.END)  # Clear the entry widget

    def update_list_label(self):
        self.list_label.config(text="List: " + ", ".join(map(str, self.numbers)))

    def display_input_instructions(self):
        instructions_label = tk.Label(self.root, text="Enter the number you want to search for:", font=("Helvetica", 12))
        instructions_label.pack()
        
    def create_input_entry(self):
        self.input_entry = tk.Entry(self.root, font=("Helvetica", 12))
        self.input_entry.pack()

    def create_search_button(self):
        self.search_button = tk.Button(self.root, text="Search", command=self.perform_search)
        self.search_button.pack()

    def perform_search(self):
        search_element = int(self.input_entry.get())  # Get the value from the input entry
        found = False
    
        for index, value in enumerate(self.numbers):
            if value == search_element:
                found = True
                result = f"Element {search_element} found at index {index}."
                break
        else:
            result = f"Element {search_element} not found in the list."
        
        self.display_search_result(result)

    def display_search_result(self, result):
        result_label = tk.Label(self.root, text=result, font=("Helvetica", 12))
        result_label.pack()

if __name__ == "__main__":
    root = tk.Tk()
    app = LinearSearchGUI(root)
    root.mainloop()
