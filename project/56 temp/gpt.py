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

        # self.sort_button = tk.Button(self.root, text="Sort", command=self.sort_and_animate)
        # self.sort_button.pack()

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

    def add_number(self, event):
        input_text = self.input_entry.get()
        try:
            num = int(input_text)
            self.num_list.append(num)
            self.update_display()
            self.input_entry.delete(0, tk.END)  # Clear the entry field
        except ValueError:
            messagebox.showerror("Error", "Please enter a valid number.")

    # def sort_and_animate(self):
    #     sorted_nums = sorted(self.num_list)
    #     self.animate_sorted_list(sorted_nums)

    # def animate_sorted_list(self, sorted_nums):
    #     self.animation_index = 0
    #     self.animating = True
    #     self.sorted_nums = sorted_nums
    #     self.root.after(self.animation_interval, self.animate_step)

    # def animate_step(self):
    #     if self.animation_index < len(self.sorted_nums):
    #         self.update_display(self.sorted_nums[:self.animation_index + 1])
    #         self.animation_index += 1
    #         self.root.after(self.animation_interval, self.animate_step)
    #     else:
    #         self.animating = False
    #         self.update_display(self.sorted_nums)

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

    def display_result(self, result_text):
        result_label = tk.Label(self.root, text=result_text)
        result_label.pack()

    # def start_binary_search(self):
    #     target_text = self.target_entry.get()

    #     if not target_text:
    #         return

    #     target = int(target_text)
    #     result_index = self.binary_search(target)

    #     if result_index is not None:
    #         self.display_result(f"Target {target} found at index {result_index}.")
    #         self.highlight_box(result_index)
    #     else:
    #         self.display_result(f"Target {target} not found.")

    # def binary_search(self, target):
    #     left, right = 0, len(self.num_list) - 1

    #     while left <= right:
    #         mid = (left + right) // 2
    #         mid_value = self.num_list[mid]

    #         if mid_value == target:
    #             return mid
    #         elif mid_value < target:
    #             left = mid + 1
    #         else:
    #             right = mid - 1

    #     return None

    # def highlight_box(self, index):
    #     # ... (method to highlight the result box)
    #     box_width = len(str(self.num_list[index])) * 20
    #     box_height = 30
    #     x = 20 + index * (box_width + 10)
    #     y = 200

    #     self.canvas.create_rectangle(x, y, x + box_width, y + box_height, outline="black", fill="#63adee")
    #     self.canvas.create_text(x + box_width / 2, y + box_height / 2, text=str(self.num_list[index]), font=("Arial", 14))
    # # ... (remaining methods and if __name__ == "__main__")

if __name__ == "__main__":
    root = tk.Tk()
    app = SortedListGUI(root)
    root.mainloop()
