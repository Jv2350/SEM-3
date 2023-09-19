import customtkinter

class MyApp:
    def __init__(self):
        self.app = customtkinter.CTk()
        self.app.title("My App")
        
        self.screen_width = self.app.winfo_screenwidth()
        self.screen_height = self.app.winfo_screenheight() 
           

        self.app.geometry(f"{self.screen_width}x{self.screen_height}")

        self.app.grid_columnconfigure(0, weight=1)
        self.app.grid_columnconfigure((0, 1), weight=1)

        self.create_widgets()

    def create_widgets(self):
        self.button = customtkinter.CTkButton(self.app, text="My Button", command=self.button_callback)
        self.button.grid(row=0, column=0, padx=20, pady=20, sticky="ew", columnspan=2)

        self.checkbox_1 = customtkinter.CTkCheckBox(self.app, text="Checkbox 1")
        self.checkbox_1.grid(row=1, column=0, padx=20, pady=(0, 20), sticky="w")

        self.checkbox_2 = customtkinter.CTkCheckBox(self.app, text="Checkbox 2")
        self.checkbox_2.grid(row=1, column=1, padx=20, pady=(0, 20), sticky="w")

    def button_callback(self):
        print("Button pressed")

    def run(self):
        self.app.mainloop()

if __name__ == "__main__":
    my_app = MyApp()
    my_app.run()
