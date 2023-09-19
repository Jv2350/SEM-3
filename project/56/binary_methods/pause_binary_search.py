def pause_binary_search(self):
    self.animation_paused = True
    self.pause_button.config(state=tk.DISABLED)
    self.next_button.config(state=tk.NORMAL)
