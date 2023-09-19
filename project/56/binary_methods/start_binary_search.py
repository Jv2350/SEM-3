def start_binary_search(self):
    numbers_text = self.input_numbers.get()
    target_text = self.input_target.get()
    if not numbers_text or not target_text:
        return
    self.number_list = list(map(int, numbers_text.split()))
    # Check if the array is sorted
    if not self.is_sorted(self.number_list):
        self.display_instruction("Error: Please enter a sorted array.")
        return
    self.target = int(target_text)
    self.number_list.sort()
    self.animation_index = None
    self.display_number_boxes()
    self.pause_button.config(state=tk.NORMAL)
    self.next_button.config(state=tk.NORMAL)
    self.steps.clear()  # Clear previous steps
    self.steps.append(f"The array in which searching is to be performed is: {self.number_list}. Let x = {self.target} be the element to be searched.")
    self.binary_search(0, len(self.number_list) - 1)
