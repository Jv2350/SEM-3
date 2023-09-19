import tkinter as tk

import time

class BinarySearchVisualization:
    def __init__(self, root):
        self.root = root
        self.root.title("Binary Search Visualization")
        self.root.geometry("800x600")
        #self.root.configure(bg="pink")  # Set the background color of the main window



    def __init__(self, root):  # noqa: F811
        self.root = root
        self.root.title("Binary Search Visualization")
        self.root.geometry("800x600")

        self.label = tk.Label(root, text="Enter sorted numbers:", bd=2, relief=tk.GROOVE, font=("Helvetica", 14, "bold"), bg="light green")  # noqa: E501
        self.label.pack(pady=20)

        self.input_numbers = tk.Entry(root)
        self.input_numbers.pack() 

        self.target_label = tk.Label(root, text="Enter target number:", bd=2, relief=tk.GROOVE, font=("Helvetica", 14, "bold"), bg="light green")
        self.target_label.pack(pady=20)

        self.input_target = tk.Entry(root)
        self.input_target.pack()    

        self.start_button = tk.Button(root, text="Start Binary Search", command=self.start_binary_search, bd=2, relief=tk.RAISED, font=("Helvetica", 12), bg="orange")
        self.start_button.pack(pady=10)

        self.pause_button = tk.Button(root, text="Pause", command=self.pause_binary_search, state=tk.DISABLED, font=("Helvetica", 12, "bold"), bg="light green")
        self.pause_button.pack(pady=10)

        self.next_button = tk.Button(root, text="Next Step", command=self.next_step, state=tk.DISABLED, font=("Helvetica", 12, "bold"), bg="light green")
        self.next_button.pack(pady=10)

        self.step_label = tk.Label(root, text="", font=("Helvetica", 12))
        self.step_label.pack()

        self.instruction_label = tk.Label(root, text="", font=("Helvetica", 10), wraplength=400)
        self.instruction_label.pack()

        self.canvas = tk.Canvas(root, width=600, height=300)  # Adjusted height
        self.canvas.pack()

        self.number_list = []
        self.target = None
        self.animation_index = None
        self.animation_paused = False
        self.steps = []  # Store the steps for the binary search algorithm

    def start_binary_search(self):
        numbers_text = self.input_numbers.get()
        target_text = self.input_target.get()

        if not numbers_text or not target_text:
            return

        self.number_list = list(map(int, numbers_text.split()))

        # Check if the array is sorted
        if not self.is_sorted(self.number_list):
            self.display_instruction("Error: Please enter a sorted array.")
            return

        self.target = int(target_text)
        self.number_list.sort()
        self.animation_index = None

        self.display_number_boxes()
        self.pause_button.config(state=tk.NORMAL)
        self.next_button.config(state=tk.NORMAL)

        self.steps.clear()  # Clear previous steps
        self.steps.append(f"The array in which searching is to be performed is: {self.number_list}. Let x = {self.target} be the element to be searched.")
        self.binary_search(0, len(self.number_list) - 1)

    def binary_search(self, left, right):
        if left > right or self.animation_paused:
            return
        mid = (left + right) // 2
        current_number = self.number_list[mid]

        current_step = f"Step: Compare {current_number} with target {self.target}"
        self.step_label.config(text=current_step)
        self.canvas.delete("arrow")

        if current_number == self.target:
            self.display_result(f"Target {self.target} found at index {mid}.")
            self.draw_arrow(mid)
            self.steps.append(f"x = {self.target} is found at index {mid}.")
            self.display_instruction(self.steps[0])  # Display the current step's instruction


        elif current_number < self.target:
            self.display_number_boxes()
            self.draw_arrow(mid, direction="right")
            self.steps.append(f"x > {current_number}, so compare x with the middle element of the elements on the right side of mid.")
            self.display_instruction(self.steps[0])
            self.animate_discard(mid + 1, right)
        else:
            self.display_number_boxes()
            self.draw_arrow(mid, direction="left")
            self.steps.append(f"x < {current_number}, so compare x with the middle element of the elements on the left side of mid.")
            self.display_instruction(self.steps[0])
            self.animate_discard(left, mid - 1)

    def animate_discard(self, left, right):
        if self.animation_paused:
            return

        self.draw_highlight(left, right)
        self.root.update()  # Update the GUI to show the highlight

        time.sleep(1)  # Pause for a short time to show the highlight

        self.draw_highlight()  # Clear the highlight
        self.root.update()

        self.fall_discarded_boxes(left, right)

    def fall_discarded_boxes(self, left, right):
        box_width = 40
        box_height = 40
        x = 50 + left * 50

        for i in range(left, right + 1):
            self.canvas.delete(f"box_{i}")
            self.canvas.create_rectangle(x, 180, x + box_width, 180 + box_height, outline="black", fill="lightblue", tags=f"box_{i}")
            self.canvas.create_text(x + box_width // 2, 180 + box_height // 2, text=str(self.number_list[i]) + f" [{i}]", tags=f"box_{i}")
            x += box_width + 10

            for y in range(180, 600, 10):
                self.canvas.coords(f"box_{i}", x, y, x + box_width, y + box_height)
                self.root.update()
                time.sleep(0.05)  # Slower animation

            self.canvas.delete(f"box_{i}")
            self.root.update()

        self.binary_search(left, right)

    def next_step(self):
        if self.steps:
            self.steps.pop(0)
            if self.steps:
                self.step_label.config(text=self.steps[0])
                self.display_instruction(self.steps[0])

    def pause_binary_search(self):
        self.animation_paused = True
        self.pause_button.config(state=tk.DISABLED)
        self.next_button.config(state=tk.NORMAL)

    def display_number_boxes(self):
        self.canvas.delete("box")
        self.canvas.delete("box_index")

        box_width = 40
        box_height = 40
        x = 50

        for i, number in enumerate(self.number_list):
            self.canvas.create_text(x + box_width // 2, 160, text=str(i), font=("Helvetica", 10, "bold"), tags="box_index")
            self.canvas.create_rectangle(x, 180, x + box_width, 180 + box_height, outline="black", fill="lightblue", tags="box")
            self.canvas.create_text(x + box_width // 2, 180 + box_height // 2, text=str(number), tags="box")
            x += box_width + 10

    def draw_arrow(self, index, direction=""):
        x = 50 + index * 50

        if direction == "right":
            self.canvas.create_line(x + 20, 140, x + 30, 160, arrow=tk.LAST, fill="red", width=2, tags="arrow")
        elif direction == "left":
            self.canvas.create_line(x + 20, 160, x + 30, 140, arrow=tk.LAST, fill="red", width=2, tags="arrow")
        else:
            self.canvas.create_line(x + 20, 140, x + 20, 160, arrow=tk.LAST, fill="red", width=2, tags="arrow")

    def draw_highlight(self, left=None, right=None):
        self.canvas.delete("highlight")

        if left is not None and right is not None:
            x1 = 50 + left * 50
            x2 = 50 + (right + 1) * 50
            self.canvas.create_rectangle(x1, 180, x2, 180 + 40, outline="black", fill="yellow", tags="highlight")

    def display_result(self, text):
        self.step_label.config(text=text)
        self.display_instruction("")

    def display_instruction(self, text):
        self.instruction_label.config(text=text)

    def is_sorted(self, array):
        return all(array[i] <= array[i + 1] for i in range(len(array) - 1))

if __name__ == "__main__":
    root = tk.Tk()
    root.configure(bg="black")  # Set the background color of the main window
    app = BinarySearchVisualization(root)
    root.mainloop()
