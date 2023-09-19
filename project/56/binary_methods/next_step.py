def next_step(self):
    if self.steps:
        self.steps.pop(0)
        if self.steps:
            self.step_label.config(text=self.steps[0])
            self.display_instruction(self.steps[0])
