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
