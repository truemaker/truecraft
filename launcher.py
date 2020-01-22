from tkinter import *
import os

window = Tk(className="trueCraft Launcher")
label = Label(master=window, text="1.0")
def f_f():
    os.system("python3 1.0.py")


button = Button(master=window, text="Start", command=f_f)
label.pack()
button.pack()
window.mainloop()
