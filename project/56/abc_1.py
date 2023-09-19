import tkinter as tk
from tkinter import messagebox

num_list = []

def add_number(event):
    input_text = input_entry.get()
    try:
        num = int(input_text)
        num_list.append(num)
        update_display()
        input_entry.delete(0, tk.END)  # Clear the entry field
    except ValueError:
        messagebox.showerror("Error", "Please enter a valid number.")

def sort_list():
    sorted_nums = sorted(num_list)
    update_display(sorted_nums)

def update_display(sorted_nums=None):
    entered_text = "Entered Numbers:\n" + ", ".join(map(str, num_list))
    sorted_text = "Sorted List:\n" + ", ".join(map(str, sorted_nums)) if sorted_nums else ""
    display_text.config(state=tk.NORMAL)
    display_text.delete("1.0", tk.END)
    display_text.insert(tk.END, entered_text + "\n\n" + sorted_text)
    display_text.config(state=tk.DISABLED)

def start_binary_search():
    binary_search_window = tk.Toplevel(root)
    binary_search_window.title("Binary Search Visualization")
    binary_search_window.geometry("800x600")

    # Add the binary search visualization code here...

# Create the main window
root = tk.Tk()
root.title("Combined Application")

# Create input label and entry
input_label = tk.Label(root, text="Enter a number:")
input_label.pack()

input_entry = tk.Entry(root)
input_entry.pack()

# Bind Enter key press to add_number function
input_entry.bind("<Return>", add_number)

# Create the "Sort" button
sort_button = tk.Button(root, text="Sort", command=sort_list)
sort_button.pack()

# Create a Text widget to display entered numbers and sorted list
display_text = tk.Text(root, height=10, width=30)
display_text.pack()
display_text.config(state=tk.DISABLED)  # Make the text widget read-only

# Create the "Start Binary Search" button
binary_search_button = tk.Button(root, text="Start Binary Search", command=start_binary_search)
binary_search_button.pack()

# Start the GUI event loop
root.mainloop()
