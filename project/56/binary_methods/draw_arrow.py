def draw_arrow(self, index, direction=""):
    x = 50 + index * 50
    if direction == "right":
        self.canvas.create_line(x + 20, 140, x + 30, 160, arrow=tk.LAST, fill="red", width=2, tags="arrow")
    elif direction == "left":
        self.canvas.create_line(x + 20, 160, x + 30, 140, arrow=tk.LAST, fill="red", width=2, tags="arrow")
    else:
        self.canvas.create_line(x + 20, 140, x + 20, 160, arrow=tk.LAST, fill="red", width=2, tags="arrow")
