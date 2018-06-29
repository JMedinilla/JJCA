import glob
import os
from PIL import Image

list = glob.glob("*.jpg")
for file in list:
    img = Image.open(file)
    imgRZ = img.resize((520,800), Image.ANTIALIAS)
    imgRZ.save("hola/"+file, optimize=True, quality=85)