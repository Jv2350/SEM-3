def add_number(self, event):
    input_text = self.input_entry.get()
    try:
        num = int(input_text)
        self.num_list.append(num)
        self.update_display()
        self.input_entry.delete(0, tk.END)  # Clear the entry field
    except ValueError:
        messagebox.showerror("Error", "Please enter a valid number.")
