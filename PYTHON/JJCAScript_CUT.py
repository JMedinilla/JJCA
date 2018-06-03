import cv2
import glob
import os
import platform
import shutil

def getAllImageNames():
    imagefiles = []
    for file in glob.glob(n + "/*.jpg"):
        imagefiles.append(file)
    for file in glob.glob(n + "/*.jpeg"):
        imagefiles.append(file)
    for file in glob.glob(n + "/*.png"):
        imagefiles.append(file)
    return imagefiles

def cutImageInHalf(image, imageName):
    h, w, ch = image.shape
    half = w//2
    firstHalf = image[0:h, 0:half]
    secondHalf = image[0:h, half:w]
    if platform.system() == "Windows":
        partsSlash = imageName.split("\\", 2)
    else:
        partsSlash = imageName.split("/", 2)
    parts = partsSlash[2].split(".", 1)
    if w > h:
        r1 = os.path.join(copiesDir, parts[0] + "_a." + parts[1])
        r2 = os.path.join(copiesDir, parts[0] + "_b." + parts[1])
        cv2.imwrite(r1, secondHalf)
        cv2.imwrite(r2, firstHalf)
    else:
        cv2.imwrite(os.path.join(copiesDir, parts[0] + "_ab." + parts[1]), image)

parents = os.listdir()
for par in parents:
    if "py" not in par:
        nameDir = os.listdir(par)
        for n in nameDir:
            n = os.path.join(par, n)
            if os.path.exists(n):
                copiesDir = n + "_copy"
                if os.path.exists(copiesDir):
                    shutil.rmtree(copiesDir)
                os.mkdir(copiesDir)
                filenames = getAllImageNames()
                for f in filenames:
                    image = cv2.imread(f)
                    cutImageInHalf(image, f)
            else:
                print("No folder found")
