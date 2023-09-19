def animate_discard(self, left, right):
    if self.animation_paused:
        return
    self.draw_highlight(left, right)
    self.root.update()  # Update the GUI to show the highlight
    time.sleep(1)  # Pause for a short time to show the highlight
    self.draw_highlight()  # Clear the highlight
    self.root.update()
    self.fall_discarded_boxes(left, right)
