import tkinter as tk

root = tk.Tk()
canvas = tk.Canvas(root, width=300, height=200)
canvas.pack()

# Creating a rectangle
rectangle = canvas.create_rectangle(50, 50, 200, 150, outline='blue', fill='red', width=2)

root.mainloop()
