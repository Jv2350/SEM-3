def draw_highlight(self, left=None, right=None):
    self.canvas.delete("highlight")
    if left is not None and right is not None:
        x1 = 50 + left * 50
        x2 = 50 + (right + 1) * 50
        self.canvas.create_rectangle(x1, 180, x2, 180 + 40, outline="black", fill="yellow", tags="highlight")
