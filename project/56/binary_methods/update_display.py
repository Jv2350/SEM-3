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
