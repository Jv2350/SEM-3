def binary_search(self, left, right):
    if left > right or self.animation_paused:
        return
    mid = (left + right) // 2
    current_number = self.number_list[mid]
    current_step = f"Step: Compare {current_number} with target {self.target}"
    self.step_label.config(text=current_step)
    self.canvas.delete("arrow")
    if current_number == self.target:
        self.display_result(f"Target {self.target} found at index {mid}.")
        self.draw_arrow(mid)
        self.steps.append(f"x = {self.target} is found at index {mid}.")
        self.display_instruction(self.steps[0])  # Display the current step's instruction
    elif current_number < self.target:
        self.display_number_boxes()
        self.draw_arrow(mid, direction="right")
        self.steps.append(f"x > {current_number}, so compare x with the middle element of the elements on the right side of mid.")
        self.display_instruction(self.steps[0])
        self.animate_discard(mid + 1, right)
    else:
        self.display_number_boxes()
        self.draw_arrow(mid, direction="left")
        self.steps.append(f"x < {current_number}, so compare x with the middle element of the elements on the left side of mid.")
        self.display_instruction(self.steps[0])
        self.animate_discard(left, mid - 1)
