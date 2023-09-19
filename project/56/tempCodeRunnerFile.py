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

        self.sort_button = tk.Button(self.root, text="Sort", command=self.sort_list)
        self.sort_button.pack()

        self.canvas = tk.Canvas(self.root, width=1000, height=300)
        self.canvas.pack()

        self.animation_interval = 500  # milliseconds
        self.update_display()

    def add_number(self, event):
        input_text = self.input_entry.get()
        try:
            num = int(input_text)
            self.num_list.append(num)
            self.update_display()
            self.input_entry.delete(0, tk.END)  # Clear the entry field
        except ValueError:
            messagebox.showerror("Error", "Please enter a valid number.")

    def sort_list(self):
        sorted_nums = sorted(self.num_list)
        self.animate_sorted_list(sorted_nums)

    def animate_sorted_list(self, sorted_nums):
        self.animation_index = 0
        self.animating = True
        self.sorted_nums = sorted_nums
        self.root.after(self.animation_interval, self.animate_step)

    def animate_step(self):
        if self.animation_index < len(self.sorted_nums):
            self.update_display(self.sorted_nums[:self.animation_index + 1])
            self.animation_index += 1
            self.root.after(self.animation_interval, self.animate_step)
        else:
            self.animating = False
            self.update_display(self.sorted_nums)

    def update_display(self, display_nums=None):
        self.canvas.delete("all")

        x = 20
        y = 100

        # Add "Entered Numbers:" label to canvas
        self.canvas.create_text(x, y - 30, text="Entered Numbers:", font=("Arial", 12), anchor=tk.W)

        for num in self.num_list:
            num_str = str(num)
            box_width = len(num_str) * 20
            box_height = 30
            self.canvas.create_rectangle(x, y, x + box_width, y + box_height, outline="white", fill="#63adee", activefill="#e06a77")
            self.canvas.create_text(x + box_width / 2, y + box_height / 2, text=num_str, font=("Arial", 14), fill="#101010")
            x += box_width + 10

        if display_nums:
            x = 20
            y = 200

            # Add "Sorted List:" label to canvas
            self.canvas.create_text(x, y - 30, text="Sorted List:", font=("Arial", 12), anchor=tk.W)

            for num in display_nums:
                num_str = str(num)
                box_width = len(num_str) * 20
                box_height = 30
                self.canvas.create_rectangle(x, y, x + box_width, y + box_height, outline="black")
                self.canvas.create_text(x + box_width / 2, y + box_height / 2, text=num_str, font=("Arial", 14))
                x += box_width + 10

if __name__ == "__main__":
    root = tk.Tk()
    app = SortedListGUI(root)
    root.mainloop()
