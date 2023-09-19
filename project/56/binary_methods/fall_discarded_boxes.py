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
