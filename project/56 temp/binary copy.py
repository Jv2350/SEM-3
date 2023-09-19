from tkinter import *
from tkinter import messagebox
import time

f = ("Cascadia mono",20)

class BinarySearch:
    # super().__init__()
    def __init__(self,root):
        self.root = root
        self.root.configure(bg="gray")
        self.root.title("Binary Search made by Prachi")

        self.screen_width = root.winfo_screenwidth()
        self.screen_height = root.winfo_screenheight() 
           

        self.root.geometry(f"{self.screen_width}x{self.screen_height}")
        # self.root.attributes('-fullscreen', True)

        # configure grid layout (4x4)
        # self.grid_columnconfigure(1, weight=1)
        # self.grid_columnconfigure((2, 3), weight=0)
        # self.grid_rowconfigure((0, 1, 2), weight=1)  
        self.num_list = []

        # Create input label and entry
        self.input_label = Label(self.root, text="Enter a number:",font=f,relief=GROOVE,border=6)
        self.input_label.grid(row=0, column=0, padx=(20,0), pady=(20,0),sticky="news")
        # self.input_label.pack(side=LEFT,anchor="ne")

        self.input_entry = Entry(self.root,font=f,relief=GROOVE,border=6)
        self.input_entry.grid(row=0, column=1, padx=(20,0), pady=(20,0),sticky="news" )
        # self.input_entry.pack(side=LEFT,anchor="ne",padx=20)
        self.input_entry.bind("<Return>",self.add_number)

        self.sort_button = Button(self.root, text="Sort", command=self.sort_list,font=f,relief=GROOVE,border=6)
        self.sort_button.grid(row=0,column=2,columnspan=2,padx=(20,0), pady=(20,0),sticky="news")  
        # self.sort_button.pack(side=LEFT,anchor="e",padx=20)

        # self.target_label = Label(self.root, text="Enter target number:", bd=6, relief=GROOVE, font=f, bg="light green")
        self.target_label = Label(self.root, text="Enter target number: ",font=f,relief=GROOVE,border=6)
        # self.target_label.pack(pady=20)
        self.target_label.grid(row=1, column=0, padx=(20,0), pady=(20,0),sticky="news" )

        self.input_target = Entry(root,font=f,relief=GROOVE,border=6)
        # self.input_target.pack()    
        self.input_target.grid(row=1, column=1, padx=(20,0), pady=(20,0),sticky="news" )  

        self.start_button = Button(root, text="Start Binary Search", command=self.start_binary_search, bd=6, relief=GROOVE, font=f, bg="orange")
        # self.start_button.pack(pady=10)
        self.start_button.grid(row=1, column=2,columnspan=2, padx=(20,0), pady=(20,0),sticky="news" )

        self.step_label = Label(root, text="Steps:", font=f)
        # self.step_label.pack()
        self.step_label.grid(row=0,column=5,padx=(20,0), pady=(20,0),sticky="news")

        self.instruction_label = Label(root, text="Instructions:", font=f, wraplength=400)
        # self.instruction_label.pack()
        self.instruction_label.grid(row=1,column=5,padx=(20,0), pady=(20,0),sticky="news")

        self.pause_button = Button(root, text="Pause", command=self.pause_binary_search, state=DISABLED, font=f, bg="light green")
        # self.pause_button.pack(pady=10)
        self.pause_button.grid(row=2,column=0,columnspan=2,padx=(20,0), pady=(20,0),sticky="news")

        self.next_button = Button(root, text="Next   Step", command=self.next_step, state=DISABLED, font=f, bg="light green")
        # self.next_button.pack(pady=10)
        self.next_button.grid(row=2,column=2,columnspan=2,padx=(20,0), pady=(20,0),sticky="news")


        self.canvas1 = Canvas(root, width=1000, height=300)  # Adjusted height
        self.canvas1.grid(row=6,columnspan=4,padx=(20,0), pady=(20,0),sticky="news")

        self.canvas = Canvas(root, width=600, height=300)  # Adjusted height
        self.canvas.grid(row=7,columnspan=4,padx=(20,0), pady=(20,0),sticky="news")


        self.animation_interval = 500  # milliseconds
        self.update_display()

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
        # ... (method to highlight the result box)
        box_width = len(str(self.num_list[index])) * 20
        box_height = 30
        x = 20 + index * (box_width + 10)
        y = 200

        self.canvas.create_rectangle(x, y, x + box_width, y + box_height, outline="black", fill="#63adee")
        self.canvas.create_text(x + box_width / 2, y + box_height / 2, text=str(self.num_list[index]), font=("Arial", 14))

    def next_step(self):
        if self.steps:
            self.steps.pop(0)
            if self.steps:
                self.step_label.config(text=self.steps[0])
                self.display_instruction(self.steps[0])

    def pause_binary_search(self):
        self.animation_paused = True
        self.pause_button.config(state=DISABLED)
        self.next_button.config(state=NORMAL)





    def add_number(self, event):
        input_text = self.input_entry.get()
        try:
            num = int(input_text)
            self.num_list.append(num)
            self.update_display()
            self.input_entry.delete(0, END)  # Clear the entry field
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
        self.canvas1.delete("all")

        x = 20
        y = 100

        # Add "Entered Numbers:" label to canvas
        self.canvas1.create_text(x, y - 30, text="Entered Numbers:", font=f, anchor="w")

        for num in self.num_list:
            num_str = str(num)
            box_width = len(num_str) * 20
            box_height = 30
            self.canvas1.create_rectangle(x, y, x + box_width, y + box_height, outline="blue", fill="#63adee", activefill="#e06a77")
            self.canvas1.create_text(x + box_width / 2, y + box_height / 2, text=num_str, font=f, fill="#101010")
            x += box_width + 10

        if display_nums:
            x = 20
            y = 200

            # Add "Sorted List:" label to canvas
            self.canvas1.create_text(x, y - 30, text="Sorted List:", font=f, anchor=W)

            for num in display_nums:
                num_str = str(num)
                box_width = len(num_str) * 20
                box_height = 30
                self.canvas1.create_rectangle(x, y, x + box_width, y + box_height, outline="blue",fill="#63adee")
                self.canvas1.create_text(x + box_width / 2, y + box_height / 2, text=num_str, font=f)
                x += box_width + 10


if __name__ == "__main__":
    root = Tk()
    app = BinarySearch(root)
    root.mainloop()
