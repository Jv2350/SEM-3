def is_sorted(self, array):
    return all(array[i] <= array[i + 1] for i in range(len(array) - 1))