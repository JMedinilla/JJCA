import os

p = input("Part -> ")
v = input("Volume -> ")

if p and v:
    files = []
    newFiles = []

    for file in os.listdir():
        if ".py" not in file:
            files.append(file)

    for index, file in enumerate(files):
        extension = file.split(".")[1]
        newName = "p" + str(p).zfill(2) + "_v" + str(v).zfill(2) + "_" + str(index + 1).zfill(3) + "." + extension
        newFiles.append(newName)

    for index, file in enumerate(files):
        os.rename(file, newFiles[index])
