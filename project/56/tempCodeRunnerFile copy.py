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

        self.add_button = tk.Button(self.root, text="Add", command=self.add_number)
        self.add_button.pack()

        self.sort_button = tk.Button(self.root, text="Sort", command=self.sort_list)
        self.sort_button.pack()

        self.search_label = tk.Label(self.root, text="Search for a number:")
        self.search_label.pack()

        self.search_entry = tk.Entry(self.root)
        self.search_entry.pack()

        self.search_button = tk.Button(self.root, text="Search", command=self.perform_binary_search)
        self.search_button.pack()

        self.result_label = tk.Label(self.root, text="", font=("Arial", 12))
        self.result_label.pack()    

        self.root.bind("<Return>", self.add_number_from_keyboard)

        self.canvas = tk.Canvas(self.root, width=1000, height=300)
        self.canvas.pack()

        self.animation_interval = 500  # milliseconds
        self.update_display()

        self.performing_search = False


    def sort_list(self):
        self.sorted_nums = sorted(self.num_list)  # Sort the list
        self.update_display(display_nums=self.sorted_nums)  # Update the display with the sorted list

    def perform_binary_search(self):
        search_input = self.search_entry.get()
        try:
            target = int(search_input)
            self.result_label.config(text="", fg="black")  # Clear previous search result
            self.animate_binary_search(target)  # Start binary search animation
        except ValueError:
            self.result_label.config(text="Please enter a valid number.", fg="red")
    
    def binary_search(self, nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return None

    def highlight_search_result(self, result_index):
        self.update_display(self.sorted_nums, highlight_index=result_index, highlight_color="#00FF00")  # Green color
    
    def add_number(self):
        input_text = self.input_entry.get()
        self.add_number_to_list(input_text)

    def add_number_from_keyboard(self, event):
        input_text = self.input_entry.get()
        self.add_number_to_list(input_text)

    def add_number_to_list(self, input_text):
        try:
            num = int(input_text)
            self.num_list.append(num)
            self.update_display()
            self.input_entry.delete(0, tk.END)  # Clear the entry field
        except ValueError:
            messagebox.showerror("Error", "Please enter a valid number.")

    def animate_sorted_list(self):
        self.animation_index = 0
        self.animating = True
        self.root.after(self.animation_interval, self.animate_step)

    def animate_step(self):
        if self.animating:
            if self.animation_index < len(self.sorted_nums):
                self.update_display(self.sorted_nums[:self.animation_index + 1], highlight_index=self.animation_index)
                self.animation_index += 1
                self.root.after(self.animation_interval, self.animate_step)
            else:
                self.animating = False
                self.perform_binary_search()  # Start binary search animation

    def update_display(self, display_nums=None, highlight_index=None, highlight_range=None, highlight_color="#FFD700"):
        self.canvas.delete("all")

        x = 20
        y = 100
        box_height = 30  # Common box height

        # Add "Entered Numbers:" label to canvas
        self.canvas.create_text(x, y - 30, text="Entered Numbers:", font=("Arial", 12), anchor=tk.W)

        for idx, num in enumerate(self.num_list):
            num_str = str(num)
            box_width = len(num_str) * 20
            self.canvas.create_rectangle(x, y, x + box_width, y + box_height, outline="white", fill="#63adee", activefill="#e06a77")
            self.canvas.create_text(x + box_width / 2, y + box_height / 2, text=num_str, font=("Arial", 14), fill="#101010")
            x += box_width + 10

        if display_nums is not None:
            for idx, num in enumerate(display_nums):
                num_str = str(num)
                box_width = len(num_str) * 20
                self.canvas.create_rectangle(x, y, x + box_width, y + box_height, outline="black")
                self.canvas.create_text(x + box_width / 2, y + box_height / 2, text=num_str, font=("Arial", 14))

                if highlight_index is not None and idx == highlight_index:
                    highlight_x = x
                    highlight_y = y
                    self.canvas.create_rectangle(
                        highlight_x, highlight_y, highlight_x + box_width, highlight_y + box_height,
                        outline="black", fill=highlight_color, tags="highlight"
                    )

                if highlight_range is not None:
                    highlight_start, highlight_end = highlight_range
                    if highlight_start <= idx <= highlight_end:
                        highlight_x = x
                        highlight_y = y
                        self.canvas.create_rectangle(
                            highlight_x, highlight_y, highlight_x + box_width, highlight_y + box_height,
                            outline="black", fill=highlight_color, tags="highlight"
                        )

                x += box_width + 10
                
    def animate_binary_search(self, target):
        left, right = 0, len(self.sorted_nums) - 1
        self.animation_indices = [(left, right)]  # Store indices for animation

        self.animation_index = 0
        self.animating = True
        self.target = target

        self.root.after(self.animation_interval, self.animate_search_step)

    def animate_search_step(self):
        if self.animating and self.animation_index < len(self.animation_indices):
            left, right = self.animation_indices[self.animation_index]
            mid = (left + right) // 2
            if self.sorted_nums[mid] == self.target:
                self.highlight_search_result(mid, "#00FF00")  # Green color
                self.animation_index = len(self.animation_indices)  # Stop animation
                return
            elif self.sorted_nums[mid] < self.target:
                left = mid + 1
            else:
                right = mid - 1
            self.animation_indices.append((left, right))
            self.update_display(display_nums=self.sorted_nums, highlight_range=(left, right), highlight_color="#FFD700")  # Gold color
            self.animation_index += 1
            self.root.after(self.animation_interval, self.animate_search_step)
        else:
            self.animating = False
            self.update_display(display_nums=self.sorted_nums)  # Reset display
        
    def highlight_search_result(self, result_index, highlight_color="#00FF00"):
            self.update_display(self.sorted_nums, highlight_index=result_index, highlight_color=highlight_color)             

if __name__ == "__main__":
    root = tk.Tk()
    root.configure(bg="black")  # Set the background color of the main window
    app = SortedListGUI(root)
    root.mainloop()
