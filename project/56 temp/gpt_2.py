import tkinter as tk
from tkinter import messagebox

class SortedListGUI:
    def __init__(self, root):
        self.root = root
        self.root.title("Sorted List GUI")
        
        self.num_list = []

        self.input_label = tk.Label(self.root, text="Enter a number:")
        self.input_label.pack()

        self.input_entry = tk.Entry(self.root)
        self.input_entry.pack()
        self.input_entry.bind("<Return>", self.add_number)

        self.sort_button = tk.Button(self.root, text="Sort", command=self.sort_and_animate)
        self.sort_button.pack()

        self.target_label = tk.Label(self.root, text="Enter target number:")
        self.target_label.pack()

        self.target_entry = tk.Entry(self.root)
        self.target_entry.pack()

        self.start_button = tk.Button(self.root, text="Start Binary Search", command=self.start_binary_search)
        self.start_button.pack()

        self.canvas = tk.Canvas(self.root, width=1000, height=300)
        self.canvas.pack()

        self.animation_interval = 500  # milliseconds
        self.update_display()

    # ... (rest of the methods remain unchanged)
    def add_number(self, event):
        input_text = self.input_entry.get()
        try:
            num = int(input_text)
            self.num_list.append(num)
            self.update_display()
            self.input_entry.delete(0, tk.END)  # Clear the entry field
        except ValueError:
            messagebox.showerror("Error", "Please enter a valid number.")

    def sort_and_animate(self):
        sorted_nums = sorted(self.num_list)
        self.animate_sorted_list(sorted_nums)

    def update_display(sorted_nums=None):
        entered_text = "Entered Numbers:\n" + ", ".join(map(str, num_list))
        sorted_text = "Sorted List:\n" + ", ".join(map(str, sorted_nums)) if sorted_nums else ""
        display_text.config(state=tk.NORMAL)
        display_text.delete("1.0", tk.END)
        display_text.insert(tk.END, entered_text + "\n\n" + sorted_text)
        display_text.config(state=tk.DISABLED)




    def start_binary_search(self):
        target_text = self.target_entry.get()

        if not target_text:
            return

        target = int(target_text)
        result_index = self.binary_search(target)

        if result_index is not None:
            self.display_result(f"Target {target} found at index {result_index}.")
            self.highlight_box(result_index)
        else:
            self.display_result(f"Target {target} not found.")

    def binary_search(self, target):
        left, right = 0, len(self.num_list) - 1

        while left <= right:
            mid = (left + right) // 2
            mid_value = self.num_list[mid]

            if mid_value == target:
                return mid
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1

        return None

    def highlight_box(self, index):
        box_width = len(str(self.num_list[index])) * 20
        box_height = 30
        x = 20 + index * (box_width + 10)
        y = 200

        self.canvas.create_rectangle(x, y, x + box_width, y + box_height, outline="black", fill="#63adee")
        self.canvas.create_text(x + box_width / 2, y + box_height / 2, text=str(self.num_list[index]), font=("Arial", 14))

if __name__ == "__main__":
    root = tk.Tk()
    app = SortedListGUI(root)
    root.mainloop()
