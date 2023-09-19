def animate_step(self):
    if self.animation_index < len(self.sorted_nums):
        self.update_display(self.sorted_nums[:self.animation_index + 1])
        self.animation_index += 1
        self.root.after(self.animation_interval, self.animate_step)
    else:
        self.animating = False
        self.update_display(self.sorted_nums)
