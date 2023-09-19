import tkinter
import tkinter as tk
from tkinter import messagebox
from tkinter import font
import tkinter.messagebox
import tkinter

tkinter.set_appearance_mode("System")  # Modes: "System" (standard), "Dark", "Light"
tkinter.set_default_color_theme("blue")  # Themes: "blue" (standard), "green", "dark-blue"


class App(tkinter.CTk):
    def __init__(self):
        super().__init__()

        # configure window
        self.title("tkinter complex_example.py")
        self.geometry(f"{1100}x{580}")

        # configure grid layout (4x4)
        self.grid_columnconfigure(1, weight=1)
        self.grid_columnconfigure((2, 3), weight=0)
        self.grid_rowconfigure((0, 1, 2), weight=1)

        # create sidebar frame with widgets
        # fon=('times', 20)
        self.sidebar_frame = tkinter.CTkFrame(self, width=140, corner_radius=0)
        self.sidebar_frame.grid(row=0, column=5, rowspan=5, sticky="nsew")
        self.sidebar_frame.grid_rowconfigure(4, weight=1)
        self.appearance_mode_label = tkinter.CTkLabel(self.sidebar_frame, text="Appearance Mode:", anchor="w",font=('',20))
        self.appearance_mode_label.grid(row=5, column=9, padx=20, pady=(10, 0))
        self.appearance_mode_optionemenu = tkinter.CTkOptionMenu(self.sidebar_frame, values=["Light", "Dark", "System"],command=self.change_appearance_mode_event)
        self.appearance_mode_optionemenu.grid(row=5, column=10, padx=20, pady=(10, 10))
        self.scaling_label = tkinter.CTkLabel(self.sidebar_frame, text="UI Scaling:", anchor="w",font=('',20))
        self.scaling_label.grid(row=7, column=9, padx=20, pady=(10, 20),)
        self.scaling_optionemenu = tkinter.CTkOptionMenu(self.sidebar_frame, values=["80%", "90%", "100%", "110%", "120%"],command=self.change_scaling_event)
        self.scaling_optionemenu.grid(row=7, column=10, padx=20, pady=(10, 20))
    
        # create main entry and button
        # self.input_entry = tkinter.CTkEntry(self, placeholder_text="Etner a number")
        # self.input_entry.grid(row=0, column=0, padx=20, pady=20, sticky="ew")
        self.main_button_1 = tkinter.CTkButton(master=self, fg_color="transparent", border_width=2, text_color=("gray10", "#DCE4EE"))
        self.main_button_1.grid(row=0, column=1, padx=20, pady=20, sticky="ew")

        # self.input_label = tkinter.CTkEntry(self, placeholder_text="Etner a number")
        self.input_label = tkinter.CTkLabel(self, text="Enter a number: ", anchor="w",font=('',20))
        self.input_label.grid(row=0, column=0, padx=20, pady=20, sticky="ew")

        self.input_entry = tkinter.CTkEntry(self, placeholder_text="Etner a number")
        self.input_entry.grid(row=0, column=0, padx=20, pady=20, sticky="ew")

        # Bind Enter key press to add_number function
        self.input_entry.bind("<Return>", add_number)

        # Create the "Sort" button
        self.sort_button = tk.Button(self, text="Sort", command=sort_list)
        self.sort_button.pack()

        # Create a Text widget to display entered numbers and sorted list
        self.display_text = tk.Text(self, height=10, width=30)
        self.display_text.pack()
        self.display_text.config(state=tk.DISABLED)  # Make the text widget read-only

    def change_appearance_mode_event(self, new_appearance_mode: str):
        tkinter.set_appearance_mode(new_appearance_mode)

    def change_scaling_event(self, new_scaling: str):
        new_scaling_float = int(new_scaling.replace("%", "")) / 100
        tkinter.set_widget_scaling(new_scaling_float)

    def sidebar_button_event(self):
        print("sidebar_button click")

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



if __name__ == "__main__":
    app = App()
    app.mainloop()
