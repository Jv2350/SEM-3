import tkinter as tk
from tkinter import messagebox

class BinarySearchVisualization:
    def __init__(self, root):
        self.root = root
        self.root.title("Binary Search Visualization")
        self.root.geometry("800x600")
        self.num_list = []

        # Create input label and entry
        self.input_label = tk.Label(root, text="Enter a number:")
        self.input_label.grid(row=1,column=0)

        self.input_entry = tk.Entry(root)
        self.input_entry.grid(row=1,column=1)

        # Bind Enter key press to add_number function
        self.input_entry.bind("<Return>", self.add_number)

        # Create the "Sort" button
        self.sort_button = tk.Button(root, text="Sort", command=self.sort_list)
        self.sort_button.grid(row=2,column=0)

        # Create a Text widget to display entered numbers and sorted list
        self.display_text = tk.Text(root, height=10, width=30)
        self.display_text.grid(row=3,columnspan=2)
        self.display_text.config(state=tk.DISABLED)  # Make the text widget read-only


    def add_number(self,event):
        input_text = self.input_entry.get()
        try:
            num = int(input_text)
            self.num_list.append(num)
            self.update_display()
            self.input_entry.delete(0, tk.END)  # Clear the entry field
        except ValueError:
            messagebox.showerror("Error", "Please enter a valid number.")

    def sort_list(self):
        self.sorted_nums = sorted(self.num_list)
        self.update_display(self.sorted_nums)

    def update_display(self,sorted_nums=None):
        entered_text = "Entered Numbers:\n" + ", ".join(map(str, self.num_list))
        sorted_text = "Sorted List:\n" + ", ".join(map(str, sorted_nums)) if sorted_nums else ""
        self.display_text.config(state=tk.NORMAL)
        self.display_text.delete("1.0", tk.END)
        self.display_text.insert(tk.END, entered_text + "\n\n" + sorted_text)
        self.display_text.config(state=tk.DISABLED)

    # Create the main window
# Start the GUI event loop
# root.mainloop()
if __name__ == "__main__":
    root = tk.Tk()
    root.configure(bg="black")  # Set the background color of the main window
    app = BinarySearchVisualization(root)
    root.mainloop()
