from tkinter import *
import os
from time import *
window = Tk(className="TrueCraft Loader")
label1 = Label(master=window ,text="0%")
label2 = Label(master=window ,text="Resource load: 50%")
label3 = Label(master=window ,text="Clear Ramdisk: 100%")
def start_true_craft():
    window.destroy()
    os.system("gradle desktop:run")

def start_config():
    start_true_craft()
button = Button(master=window, text="Finish up", command=start_config)
label1.pack()
label2.pack()
label3.pack()
button.pack()
window.mainloop()
