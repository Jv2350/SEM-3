def animate_sorted_list(self, sorted_nums):
    self.animation_index = 0
    self.animating = True
    self.sorted_nums = sorted_nums
    self.root.after(self.animation_interval, self.animate_step)
